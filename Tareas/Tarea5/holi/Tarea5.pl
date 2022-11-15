%Consulta inspirada del libro del ejercicios pagina 27, ejercicio 2.14
parte([Y|_], 0, Y).
parte([_|Xs], N, Y):-
    N2 is N - 1,
    parte(Xs, N2, Y).
%Consulta sacada del libro de ejercicios pagina 12, ejercicio 1.5
conc([], L, L).
conc([X|L1], L2, [X|L3]):-
    conc(L1, L2, L3).

%nombre: separacion (Gablema)
% descripción: Tiene la función sacar los elemento de la lista que estan detro del intervalo i y j.

separacion(LISTA, I, J, L):-
    parte(LISTA, I, V1),
    parte(LISTA, J, V2),
    conc(_, [V1|R], LISTA),
    conc(L1, [V2|_], R),
    conc([V1], L1, LF),
    conc(LF, [V2], L).

%Consulta sacada del libro de ejercicios pagina 23, ejercicio 2.5
longitud([], 0).
longitud([_|L],N):-
    longitud(L, N1),
    N is N1 + 1.

%nombre: division (Pantema)
%descripción: Tiene función de dividir la lista a la mitad.
division(LISTA, LL):-
    longitud(LISTA, N),
    N1 is round(N/2) - 1,
    N2 is N1 + 1,
    N3 is N - 1,
    separacion(LISTA, 0, N1, X),
    separacion(LISTA, N2, N3,Y),
    conc([X], [Y], LL).

%Consulta sacada de guia de ejercicios pagina 24, ejercicio 2.8
suma_lista([], 0).
suma_lista([X|L], Y):-
    suma_lista(L,Y1),
    Y is X + Y1.

%nombre: pasadofuturo (PantLema)
% descripción: Tiene la función de dividir la lista a la mitad y sumar
% sus elementos por separados, si el de la izquierda es mayor RES sera 1
% y si no RES sera 0.
pasadofuturo(LISTA, RES):-
    longitud(LISTA, N),
    N1 is round(N/2) - 1,
    N2 is N1 + 1,
    N3 is N - 1,
    separacion(LISTA, 0, N1, I),
    separacion(LISTA, N2, N3, D),
    suma_lista(I, X),
    suma_lista(D, Y),
    X > Y -> RES is 1;RES is 0.


%nombre: arbolbonito (GabPantema)
% descripción: Tiene la funión de entregar una lista que representa un
% arbo binario, el dice su el arbol es bonito, si uno de las hojas en
% pasado y el nodo también, es true y si ambas hojas son futuro el y en
% el nodo también, es true. Si no se cumple esto es false.

arbolbonito(LISTA, ESBONITO):-
    conc([X|R], [], LISTA),
    conc([I|D], [], R),
    conc([I1|_], [], I),
    conc([D1|_], [], D),
    pasadofuturo(X, RES1),
    pasadofuturo(I1, RES2),
    pasadofuturo(D1, RES3),
    RES1 = 1 ->
    (   RES1 = RES2 -> arbolbonito(I, ESBONITO);
    RES1 = RES3 -> arbolbonito(D, ESBONITO); false);
    RES1 = 0 ->
    (   RES2 = RES3 -> ESBONITO = true; ESBONITO = false).

%Lo intente :c