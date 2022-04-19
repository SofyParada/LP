#include <stdio.h>

typedef struct Unario {
    // arreglo de ’0’ y ’1’
    char* bits;
} Unario;

typedef struct Frec {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
} Frec;

typedef struct Inc {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
    // cantidad de numeros distintos en el conjunto
    char* n;
} Inc;

typedef struct Representacion {
    // puntero a la representacion creada
    void* representacion;
    // punteros a funciones
    int* (* su_descomprimir)(void*);
    int (* su_donde_esta)(void*, int , int);
    int (* su_cuanto_mas_grande)(void*, int , int);
    int (* su_bits)(void*);
    void (* su_imprimir)(void*)
} Representacion;

typedef struct Conjunto_comprimido {
    // arreglo de representaciones de grupos de numeros dentro del conjunto
    void* representaciones;
} Conjunto_comprimido;

int main()
{
    int g, c; //c: cantidad de numeros en un conjunto y g: la cantidad de numeros por grupo en el cojunto
    printf("c: ");
    scanf("%d", &c);
    printf("g: ");
    scanf("%d", &g);

    printf("Number1 = %d\n", c);
    printf("Number2 = %d\n", g);



    return 0;

}
