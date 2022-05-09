#include <stdio.h>
#include <makefile>


typedef struct Unario {
    // arreglo de ’0’ y ’1’
    char* bits;
} Unario;

//Su la Funcion de comprimir_en_unario es leer el arreglo int* grupo e ir comprimienolo hasta que quede en unario
Unario* comprimir_en_unario(int n, int* grupo);

//La funcion de descomrprimir retrona una arreglo donde podemos ver todos los elementos de la funcion coprimir
int* descomprimir_en_unario(void* unario);

//la funcion donde_esta_unario retorna un entero que dice la posicion de donde esta i-esima de int e
int  donde_esta_unario(void* unario , int e, int i);

//La funión cuantos-mas_unario retorna cuantos numero son más grande que e
int  cuantos_mas_grande_unario(void* unario , int e);

//La funcion bits_unario retorna la cantidad de bits que contiene comprimir-en_unario
int  bits_unario(void* unario);

//Muestra en pantalla el conjunto comprimido en unario
void  mostrar_unario(void* unario);


