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
maxCl([H],H).
maxCl([H|T],M):-
    maxCl(T,M1), maxC(M1,H,M).

%--------------------------------

%Metodo para obtener el elemento con mas repeticiones de una lista
element_count(X,N,L) :-
    aggregate(count,member(X,L),N).

max_element_count(X,N,L) :-
    aggregate(max(N1,X1),element_count(X1,N1,L),max(N,X)).


%--------------------------------

%Metodo para obtener la cantidad de cartas menores a 4
below4([],0).
below4([X|T],Y):-
    X < 4,
    below4(T,Z),
    Y is 1+Z.
below4([_|T],Z):-
    below4(T,Z).

%-------------------------------

%Metodo para obtener la cantidad de cartas pares

evenCount([], 0).
evenCount([H|T],N):-
    H rem 2 =:=0,
    evenCount(T,M),
    N is M+1;
    evenCount(T,N).

%------------------------------

%Metodo para obtener el largo de una lista
my_len([], 0).
my_len([H|Lc], N) :-
    my_len(Lc, M),
    N is M+1.

%------------------------------

%Metodo para


deck([(1,red),(2,red),(3,red),(4,red),(5,red),(6,red),(7,red),
      (1,orange),(2,orange),(3,orange),(4,orange),(5,orange),
      (6,orange),(7,orange),
      (1,yellow),(2,yellow),(3,yellow),(4,yellow),(5,yellow),
      (6,yellow),(7,yellow),
      (1,green),(2,green),(3,green),(4,green),(5,green),
      (6,green),(7,green),
      (1,blue),(2,blue),(3,blue),(4,blue),(5,blue),(6,blue),
      (7,blue),
      (1,indigo),(2,indigo),(3,indigo),(4,indigo),(5,indigo),
      (6,indigo),(7,indigo),
      (1,violet),(2,violet),(3,violet),(4,violet),(5,violet),
      (6,violet),(7,violet)]).



%Reparte cierta cantidad de elementos en dos listas
%La cantidad a repartir es el ultimo parametro de dealer.
dealer(_,_,_,0).

dealer([C1,C2|Cards],[C1],[C2],N) :-
    N>0,
    N1 is N-1,
    write("A: "), write(C1), nl,
    write("B: "), write(C2), nl,
    dealer(Cards,C1,C2,N1).


dealer([C1,C2|Cards],[C1|H1],[C2|H2],N) :-
    N>0,
    N1 is N-1,
    write("A: "), write(C1), nl,
    write("B: "), write(C2), nl,
    dealer(Cards,H1,H2,N1).

deal(_,A,B) :-
    deck(Deck),
    random_permutation(Deck, ShuffledDeck),
    dealer(ShuffledDeck,A,B,7).



