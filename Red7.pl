%Colores de las cartas
color(red).
color(orange).
color(yellow).
color(green).
color(blue).
color(indigo).
color(violet).

%Definimos las reglas
rule(red, high). %Gana la carta mas alta
rule(orange, number). %Gana el que tenga mas cartas de un numero
rule(yellow, color). %Gana el que tenga mas cartas de un color
rule(green, even). %Gana el que tenga mas cartas pares
rule(blue, colors). %Gana el que tenga mas colores diferentes
rule(indigo, run). %Gana el que tenga mas cartas consecutivas
rule(violet, below). %Gana el que tenga mas cartas menores a 4

%Definimos las prioridades
priority(red, 7).
priority(orange, 6).
priority(yellow, 5).
priority(green, 4).
priority(blue, 3).
priority(indigo, 2).
priority(violet, 1).

%-------------------------------------------

%Quita todos los elementos de la lista
removeAll(_, [], []).
removeAll(X, [X|T], L):-
    removeAll(X, T, L), !.
removeAll(X, [H|T], [H|L]):-
    removeAll(X, T, L ).



%Elimina un elemento de la lista
removeOne(A, [A|B], B).
removeOne(A, [B, C|D], [B|E]) :-
    removeOne(A, [C|D], E).


%Elimina una carta de la lista
removeCard(A, X, [A, X|B], B).
removeCard(A, X, [B, Y,C|D], [B,Y|E]) :-
    removeCard(A, X, [C|D], E).


%Metodo para conseguir el mayor entre dos numeros
max(A,B,A) :-
    A >= B.
max(A,B,B) :-
    A < B.

%Metodo para conseguir el mayor de una lista
maxl([H],H).
maxl([H|T],M):-
    maxl(T,M1),
    max(M1,H,M).

%---------------------------------

%Metodo para conseguir la mayor carta
maxC(A,B,C1,C2,X,C):-
    A > B,
    X is A, C is C1;
    A = B,
    C1 > C2,
    X is A, C is C1;
    A = B,
    C1 < C2,
    X is B, C is C2;
    A < B,
    X is B, C is C2.

%Metodo para conseguir la mayor carta de una lista
maxCl([H,X],H,X).
maxCl([H,X|T],Num,Col):-
    maxCl(T,Num1,Col1),
    maxC(Num1,H,Col1,X,Num,Col).

%--------------------------------

%Metodo para obtener el elemento con mas repeticiones de una lista
element_count(X,N,L) :-
    aggregate(count,member(X,L),N).

max_element_count(X,N,L) :-
    aggregate(max(N1,X1),element_count(X1,N1,L),max(N,X)).


%--------------------------------

%Metodo para obtener la cantidad de cartas menores a 4
below4([],0).
below4([X,C|T],Y):-
    X < 4,
    below4(T,Z),
    Y is 1+Z.
below4([_,_|T],Z):-
    below4(T,Z).

%-------------------------------

%Metodo para obtener la cantidad de cartas pares

evenCount([], 0).
evenCount([H,X|T],N):-
    H rem 2 =:=0,
    evenCount(T,M),
    N is M+1;
    evenCount(T,N).

%------------------------------

%Metodo para obtener el largo de una lista
my_len([], 0).
my_len([H,X|Lc], N) :-
    my_len(Lc, M),
    N is M+1.

%------------------------------

%Metodo para


deck([1,7, 2,7, 3,7, 4,7, 5,7, 6,7, 7,7, %Red
      1,6, 2,6, 3,6, 4,6, 5,6, 6,6, 7,6, %Orange
      1,5, 2,5, 3,5, 4,5, 5,5, 6,5, 7,5, %Yellow
      1,4, 2,4, 3,4, 4,4, 5,4, 6,4, 7,4, %Green
      1,3, 2,3, 3,3, 4,3, 5,3, 6,3, 7,3, %Blue
      1,2, 2,2, 3,2, 4,2, 5,2, 6,2, 7,2, %Indigo
      1,1, 2,1, 3,1, 4,1, 5,1, 6,1, 7,1]). %Violet



%Reparte cierta cantidad de elementos en dos listas
%La cantidad a repartir es el ultimo parametro de dealer.
dealer(_,_,_,0).

dealer([X1,C1,X2,C2|Cards],[X1,C1],[X2,C2],N) :-
    N>0,
    N1 is N-1,
    dealer(Cards,[X1,C1],[X2,C2],N1).


dealer([X1,C1,X2,C2|Cards],[X1,C1|H1],[X2,C2|H2],N) :-
    N>0,
    N1 is N-1,
    dealer(Cards,H1,H2,N1).

deal(_,A,B) :-
    deck(Deck),
    random_permutation(Deck, ShuffledDeck),
    dealer(ShuffledDeck,A,B,7).








