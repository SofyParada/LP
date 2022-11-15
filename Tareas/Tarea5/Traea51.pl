
my_length([], 0).

my_length([_|Xs], L):-
    my_length(Xs, L2),
    L is L2 + 1.

parte([Y|_], 0, Y).

parte([_|Xs], N, Y):-
    N2 is N - 1,
    parte(Xs, N2, Y).


division([X|Y], [[X]|[Y]]).
division(LISTA, LL):-
    my_length(LISTA, N),
    N1 is N/2,
    parte(LISTA, N1, Y),

