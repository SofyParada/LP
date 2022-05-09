

out.o: Unario.o Frec.o Inc.o main.out 
	gcc Unario.o Frec.o Inc.o main.out -o out.o -Wall -lm

Unario.o: Unario.c Unario.h
	gcc Unario.c -Wall -lm

Frec.o: Frec.c Frec.h
	gcc Frec.c -Wall -lm

Inc.o: Inc.c Inc.h
	gcc Inc.c -Wall -lm

main.out: main.c
	gcc main.c -Wall -lm


	