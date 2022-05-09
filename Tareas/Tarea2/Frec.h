#include <stdio.h>
#include <makefile>

typedef struct Frec {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
} Frec;
//Su la Funcion de comprimir_en_frec es leer el arreglo int* grupo e ir comprimienolo hasta que quede en frecuencia.
Frec* comprimir_en_frec(int n, int* grupo);

//La funcion de descomrprimir retrona una arreglo donde podemos ver todos los elementos de la funcion coprimir.
int* descomprimir_en_frec(void* frec);

//la funcion donde_esta_frec retorna un entero que dice la posicion de donde esta i-esima de int e.
int  donde_esta_frec(void* frec , int e, int i);

//La funión cuantos-mas_frec retorna cuantos numero son más grande que e.
int  cuantos_mas_grande_frec(void* frec , int e);

//La funcion bits_frec retorna la cantidad de bits que contiene comprimir_en_frec.
int  bits_frec(void* frec);

//Muestra en pantalla el conjunto comprimido en frec.
void  mostrar_frec(void* frec);