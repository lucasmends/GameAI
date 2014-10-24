% VERIFICAR QUAIS PECAS BATEM

combinaEsq(peca(X,_), L, peca(Z,X)) :- member(peca(Z,Y), L).
combinaDir(peca(_,Y), L, peca(Y,Z)) :- member(peca(Y,Z), L).

combina(Peca) :- combinaEsq(Peca).
combina(Peca) :- combinaDir(Peca).

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
	
% DAR A PEÇA PARA ALGUÉM

dar_pecas(X, [], X, 0).
dar_pecas([peca(A, B)|Banco], [peca(A, B)|J], BancoFinal, I) :- member(peca(A, B), Banco), random_permutation(Banco, Banco2), dar_pecas(Banco2, J, BancoFinal, I-1).

% VERIFICAR SE UMA PEÇA É ENCAIXÁVEL

encaixavel(peca(A, _)) :- livre_esq(A), !.
encaixavel(peca(A, _)) :- livre_dir(A), !.
encaixavel(peca(_, B)) :- livre_esq(B), !.
encaixavel(peca(_, B)) :- livre_dir(B), !.

% LISTAR TODAS AS PEÇAS POSSÍVEIS DE UM JOGADOR, ou seja, as que podem ser jogadas

possiveis([], []).
possiveis([A|Pecas], [A|Possiveis]) :- encaixavel(A), !, possiveis(Pecas, Possiveis).
possiveis([_|Pecas], Possiveis) :- possiveis(Pecas, Possiveis).

% ENCAIXAR A PEÇA NUM ESPAÇO VAGO

encaixar(peca(X,Y), J, JF) :- livre_esq(X), !, delete(J, peca(X, Y), JF), retract(livre_esq(X)), asserta(livre_esq(Y)).
encaixar(peca(X,Y), J) :- livre_dir(X), !, retract(peca(X, Y), J), retract(livre_dir(X)), asserta(livre_dir(Y)).
encaixar(peca(X,Y), J) :- livre_esq(Y), !, retract(peca(X, Y), J), retract(livre_esq(Y)), asserta(livre_esq(X)).
encaixar(peca(X,Y), J) :- livre_dir(X), !, retract(peca(X, Y), J), retract(livre_dir(Y)), asserta(livre_dir(X)).