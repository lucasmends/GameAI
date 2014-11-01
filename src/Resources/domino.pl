% CONCATENAR DUAS LISTAS

concat([], L2, L2).
concat([A|L1], L2, LF) :- concat(L1, [A|L2], LF).

% TODAS AS PEÇAS AINDA NÃO PERTENCEM A NINGUÉM

iniciar_pecas(L) :- random_permutation(
	[peca(0,0),
	peca(0,1),
	peca(0,2),
	peca(0,3),
	peca(0,4),
	peca(0,5),
	peca(0,6),
	peca(1,1),
	peca(1,2),
	peca(1,3),
	peca(1,4),
	peca(1,5),
	peca(1,6),
	peca(2,2),
	peca(2,3),
	peca(2,4),
	peca(2,5),
	peca(2,6),
	peca(3,3),
	peca(3,4),
	peca(3,5),
	peca(3,6),
	peca(4,4),
	peca(4,5),
	peca(4,6),
	peca(5,5),
	peca(5,6),
	peca(6,6)], L).

% VERIFICAR SE UMA PEÇA É ENCAIXÁVEL

encaixavel(peca(A, _), A, _) :- !.
encaixavel(peca(A, _), _, A) :- !.
encaixavel(peca(_, B), B, _) :- !.
encaixavel(peca(_, B), _, B) :- !.

% PREPARAR LISTA DE PEÇAS JOGÁVEIS

preparar([], _, _, [], 0).
preparar([A|Pecas], Esq, Dir, [A|Possiveis], P) :- encaixavel(A, Esq, Dir), !, possiveis(Pecas, Esq, Dir, Possiveis, P1), P is P1+1.
preparar([_|Pecas], Esq, Dir, Possiveis, P) :- possiveis(Pecas, Esq, Dir, Possiveis, P).

/*
 *  INTELIGÊNCIA ARTIFICAL
 */

% AI BURRA: tudo no sort

dumb(Lista, Esq, Dir, peca(A, B)) :- preparar(Lista, Esq, Dir, ListaInicial, _), random_permutation(ListaInicial, [[_, peca(A, B)]|_]).

% AI ESPERTA

smart(Lista, Inimigas, Esq, Dir, MelhorInimigo, Nini, peca(A, B)) :- preparar(Lista, Esq, Dir, ListaInicial, P1),
	preparar(Inimigas, Esq, Dir, PecasInimigas, _), P1<MelhorInimigo, !,
	combo(ListaInicial, PecasInimigas, Nini, ListaFinal), maior(ListaFinal, _, peca(A,B)).

smart(Lista, Inimigas, Esq, Dir, MelhorInimigo, Nini, peca(A, B)) :- preparar(Lista, Esq, Dir, ListaInicial, P1),
	preparar(Inimigas, Esq, Dir, PecasInimigas, _), P1 == MelhorInimigo, maybe, !,
	combo(ListaInicial, PecasInimigas, Nini, ListaFinal), maior(ListaFinal, _, peca(A,B)).

smart(Lista, Inimigas, Esq, Dir, MelhorInimigo, _, peca(A, B)) :- preparar(Lista, Esq, Dir, ListaInicial, P1),
	preparar(Inimigas, Esq, Dir, PecasInimigas, _),
	evitar(ListaInicial, [], PecasInimigas, ListaFinal), maior(ListaFinal, _, peca(A,B)).

% COMBO - tenta colocar uma peça com a maior probabilide de um inimigo colocá-la e eu poder colocar de novo

combo([], _, _, []).
combo([peca(A, B)|L], PecasInimigas, Nini, [[peca(A, B), P]|L2]) :- 
    combo(L, PecasInimigas, Nini, L2),
    contar_peca(peca(A, B), peca(A, B), [], PecasInimigas, Nini, P).
    
contar_peca(peca(_, _), peca(_, _), [], [], _, 0).
contar_peca(peca(A,B), peca(C, D), _, _, 0, 1) :- encaixavel(peca(A,B), C, D), !.
contar_peca(peca(A,B), peca(C, D), _, _, 0, 0) :- !.

contar_peca(peca(A,B), peca(A1, B1), LA, [peca(C, D)| LD], Nini, P) :- encaixavel(peca(A1, B1), C, D), !,
    concat(LA, LD, LF), Nini2 is Nini-1, contar_peca(peca(A, B), peca(C, D), [], LF, Nini2, P1),
    contar_peca(peca(A, B), peca(A1, B1), [peca(C, D)|LA], LD, Nini, P2), P is P1+P2.

contar_peca(peca(A,B), peca(A1, B1), LA, [peca(C, D)| LD], Nini, P) :- 
    contar_peca(peca(A, B), peca(A1, B1), [peca(C, D)|LA], LD, Nini, P).

% EVITAR - evita que o inimigo consiga colocar sua peca

evitar([], _, _, []).
evitar([peca(A, B)|L], LD, ListaInimigos, [[peca(A, B), P]|ListaFinal]) :- evitar(L, [peca(A, B)|LD], ListaInimigos, ListaFinal)
    concat(LD, L, LF), peso_evitar(peca(A, B), LF, ListaInimigos, P).

peso_evitar(peca(A, B), MinhasPecas, [], D) :- contar_decimos(peca(A, B), MinhasPecas, D).
peso_evitar(peca(A, B), MinhasPecas, [peca(C, D)|ListaInimigos], P) :- peso_evitar(peca(A, B), MinhasPecas, ListaInimigos, P1)
    encaixavel(peca(C, D), A, B), !, P is P1-1.
peso_evitar(peca(A, B), MinhasPecas, [_|MP], P) :- peso_evitar(peca(A, B), MinhasPecas, MP, P).

contar_decimos(peca(A, B), [], 0).
contar_decimos(peca(A, B), [peca(C, D)|MP], D) :- encaixavel(peca(C, D), A, B), !, contar_decimos(peca(A, B), MP, D1), D is D1+(1/10).
contar_decimos(peca(A, B), [_|MP], D) :- contar_decimos(peca(A, B), MP, D).

% Maior valor de uma lista dupla de valores

maior([P, peca(A, B)], P, peca(A, B)) :- !.
maior([[P, peca(A, B)]|L], M1, peca(C, D)) :- maior(L, M1, peca(C, D)), M1>P, !.
maior([[P, peca(A, B)]|L], M1, peca(C, D)) :- maior(L, M1, peca(C, D)), M1==P, maybe, !.
maior([[P, peca(A, B)]|L], P, peca(A, B)).

