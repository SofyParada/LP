#include <stdio.h>
#include <stdlib.h>
#include <makefile>
#include <Unario.h>
#include <Frec.h>
#include <Inc.h>


typedef struct Representacion {
    // puntero a la representacion creada
    void* representacion;
    // punteros a funciones
    int* (* su_descomprimir)(void*);
    int (* su_donde_esta)(void*, int , int);
    int (* su_cuanto_mas_grande)(void*, int);
    int (* su_bits)(void*);
    void (* su_imprimir)(void*);
} Representacion;

typedef struct Conjunto_comprimido {
    // arreglo de representaciones de grupos de numeros dentro del conjunto
    void* representaciones;
} Conjunto_comprimido;



//tiene la funcion de comprimir una conjunto co la catidad de c, el cual se divide en c/g conjuntos y se verifica si cada conjunto es unario, de frecuencia o de incremento y todo eso se comprime en uno.
Conjunto_comprimido* comprimir(int c, int* numeros , int g){
    int cantidadGrupos = c/g;
    int x = 0;
    int p = 0;
    Conjunto_comprimido* p_compri;
    p_compri = (Conjunto_comprimido*)malloc(c*sizeof(Conjunto_comprimido*));
    char* represen = (char*)p_compri->representaciones;
    represen = (char*)malloc(c*sizeof(char*));
    
    int* tipoCompresion = (int*)malloc(g*sizeof(int*));

    for(int i = 0; i < cantidadGrupos; i++){
        for(int j = 0; j < g; j++){
            tipoCompresion[j] = numeros[x];
            x++;         
        }
        
        char* unario = comprimir_en_unario(g, tipoCompresion);
        char* frecuencia = comprimir_en_frec(g, tipoCompresion);
        char* incremento = comprimir_en_inc(g, tipoCompresion);
        //primero tengo que ver cuanto pesa cada una de estas para elegir su representacion.
        int bitsunario = bits_unario(unario);
        int bitsfrec = bits_frec(frecuencia);
        int bitsinc = bits_inc(incremento);

        
        if(bitsunario > bitsfrec && bitsunario > bitsinc){
            for(int y = 0; y < bitsunario; y++){
                represen[p] = unario[y];
                p++;   
            }
            represen[p] = '\0';
        }
        if(bitsfrec > bitsunario && bitsfrec > bitsinc){
            for(int y = 0; y < bitsfrec; y++){
                represen[p] = frecuencia[y];
                p++;
            }
            represen[p] = '\0';
        }
        if(bitsinc > bitsunario && bitsinc > bitsfrec){
            for(int y = 0; y < bitsinc; y++){
                represen[p] = incremento[y];
                p++;
            }
            represen[p] = '\0';
        }
    }
    free((void*)unario);
    free((void*)frecuencia);
    free((void*)incremento);

    return p_compri;
}

//Su funcion es retornar un arreglo descomprimida de la funcion comprimir.
int* descomprimir(Conjunto_comprimido* conjunto_comprimido){
    int tamano = sizeof(conjunto_comprimido->representaciones)/sizeof(char*);
    int descom = (int*)malloc(119*sizeof(int*));
    for(int i = 0; i< 119; i++){
        descom[i] = conjunto_comprimido->representaciones[i];
    }
    return descom;

}

//Tinene la funion de buscar la i-esima posicion de e.
int  donde_esta(Conjunto_comprimido* conjunto_comprimido , int e, int i){
    int unario = donde_esta_unario(conjunto_comprimido->representaciones);
    int frecuencia = donde_esta_frec(conjunto_comprimido->representaciones);
    int incremento = donde_esta_inc(conjunto_comprimido->representaciones);
    int total = unario + frecuencia + incremento;
    return total;

}

//Tiene la funcion de retornar cuantos numeros son más grandes que e.
int  cuantos_mas_grande(Conjunto_comprimido* conjunto_comprimido , int e){
    int unario = cuantos_mas_grande(conjunto_comprimido->representaciones);
    int frecuencia = uantos_mas_grande(conjunto_comprimido->representaciones);
    int  incremento = cuantos_mas_grande(conjunto_comprimido->representaciones);
    int total = unario + frecuencia +incremento;
    return total;
}

//retorna la cantidad total de bits que contiene el conjunto comprimido.
int  bits_total(Conjunto_comprimido* conjunto_comprimido){
    int largo = sizeof(conjunto_comprimido->representaciones)/sizeof(char*)
    return largo;

}

//tiene la funcion de mostrar por pantalla 
void  mostrar(Conjunto_comprimido* conjunto_comprimido){
    mostrar_unario(conjunto_comprimido->representaciones);
    mostrar_frec(conjunto_comprimido->representaciones);
    mostrar_inc(conjunto_comprimido->representaciones);
    return;


}


int main()
{
    
    int g, c; //c: cantidad de numeros en un conjunto y g: la cantidad de numeros por grupo en el cojunto
    printf("c: ");
    scanf("%d", &c);
    printf("g: ");
    scanf("%d", &g);

    printf("Number1 = %d\n", c);
    printf("Number2 = %d\n", g);

    int* Conjunto = (int*)malloc(c);

    for(int i = 0; i<c; i++){
        printf("Ingrese numero dentro del conjunto: ");
        scanf("%d", &Conjunto[i]);
    };

    for(int i = 0; i<c; i++){
        printf(" %d", Conjunto[i]);
    };
    printf("\n");

    
     
     printf(descomprimir(comprimir(c,Conjunto, g));
     printf("\n");
     printf(" %d", donde_esta(comprimir(c, Conjunto, g), e, i));
     printf("\n");
     printf(" %d", cuantos_mas_grande(comprimir(c, Conjunto, g), e));
     printf("\n");
     printf("%d", bits_total(comprimir(c, Conjunto, g)));
     printf("\n");
     mostrar(comprimir(c, Conjunto, g));

     free((void*)descomprimir(comprimir(c, Conjunto, g )));

    
    
    
    return 0;

}
