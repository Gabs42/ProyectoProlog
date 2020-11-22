:- use_module(library(lists)).


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

%Metodo para obtener el largo de una lista de cartas
my_lenC([], 0).
my_lenC([_,_|Lc], N) :-
    my_lenC(Lc, M),
    N is M+1.

%Metodo para obtener el largo de una lista cualquiera
my_len([], 0).
my_len([_|Lc], N):-
    my_len(Lc, M),
    N is M+1.

%-------------------------------

%--------------------------------- Comienzan las reglas de las cartas

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
%Recibe una lista de cartas, debe tener el formato numero, color.
%Retorna en H el numero y en X el color de la carta mayor.
maxCl([H,X],H,X).
maxCl([H,X|T],Num,Col):-
    maxCl(T,Num1,Col1),
    maxC(Num1,H,Col1,X,Num,Col).

%--------------------------------

%Cuenta las apariciones de un numero
% Recibe la lista y en X el numero, retorna en Y la cantidad de
% apariciones
count([],_,0).
count([X|T],X,Y):-
    count(T,X,Z),
    Y is 1+Z.
count([X1|T],X,Z):-
    X1\=X,
    count(T,X,Z).

%Obtiene el numero con mas repeticiones
% Recibe una lista de solo numeros y la misma lista aplicandole
% sort, retorna en N el numero, y R la cantidad de apariciones
% Ejemplo: L = [2,1,1,4,3,5]
% sort(L, Y),
% mostNum(L,Y,N,R).
mostNum([],[],_,0).
mostNum([X|T],[H|G],N,R):-
    count(X,H,R),
    N is H,
    mostNum([X|T],G,N,R).

%-------------------------------

%Cuenta las apariciones de un color
%Recibe una lista de colores, retorna en X el numero del color
%y en Y la cantidad de apariciones.
countColor([],_,0).
countColor([X|T],X,Y):- countColor(T,X,Z), Y is 1+Z.
countColor([X1|T],X,Z):- X1\=X,countColor(T,X,Z).


mostCol([],0,0).
mostCol([X,F|T],C,R):-
    countColor([X,F|T],F,Y),
    maxC(C,F,R,Y),
    mostCol(T,F,Y).

mostCol([_,_|T],N,R):-
    mostCol(T,N,R).

%--------------------------------

%Metodo para obtener la cantidad de cartas pares
% Recibe una lista de numeros sin colores,
%retorna la cantidad de pares en N
evenCount([], 0).
evenCount([H|T],N):-
    H rem 2 =:=0,
    evenCount(T,M),
    N is M+1;
    evenCount(T,N).

%------------------------------

%Metodo para obtener la cantidad de colores distintos,
%recibe la lista de colores solamente y en X retorna
%la cantidad de colores
difColors([],0).
difColors(H,X):-
    sort(H,L),
    my_len(L,X).

%------------------------------

%Para conseguir la mayor cantidad de numeros consecutivos
%Falta arreglar
numRun([],_,0).
numRun([H|T],H,R):-
    numRun(T,H1,R1),
    H is 1+H1,
    R is 1+R1.
numRun([H|T],_,_):-
    numRun(T,H,1).

%-------------------------------

%Metodo para obtener la cantidad de cartas menores a 4
below4([],0).
below4([X,_|T],Y):-
    X < 4,
    below4(T,Z),
    Y is 1+Z.
below4([_,_|T],Z):-
    below4(T,Z).

%-------------------------------



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





%----------------------------------------



countall(List,X,C) :-
    sort(List,List1),
    member(X,List1),
    count(List,X,C).










































