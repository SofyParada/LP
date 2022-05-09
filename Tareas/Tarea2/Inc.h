#include <stdio.h>
#include <makefile>

typedef struct Inc {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
    // cantidad de numeros distintos en el conjunto
    char* n;
} Inc;

//Su la Funcion de comprimir_en_inc es leer el arreglo int* grupo e ir comprimienolo hasta que quede en Incremento.
Inc* comprimir_en_inc(int n, int* grupo);

//La funcion de descomrprimir retrona una arreglo donde podemos ver todos los elementos de la funcion coprimir.
int* descomprimir_en_inc(void* inc);

//la funcion donde_esta_inc retorna un entero que dice la posicion de donde esta i-esima de int e.
int  donde_esta_inc(void* inc , int e, int i);

//La funión cuantos_mas_inc retorna cuantos numero son más grande que e.
int  cuantos_mas_grande_inc(void* inc , int e);

//La funcion bits_inc retorna la cantidad de bits que contiene comprimir_en_inc.
int  bits_inc(void* inc);

//Muestra en pantalla el conjunto comprimido en inc.
void  mostrar_inc(void* inc);