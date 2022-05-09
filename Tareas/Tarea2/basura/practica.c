#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Frec {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
} Frec;


Frec* comprimir_en_frec(int n, int* grupo){ //revisar kien cual deke ser su retorno
    int x;
    Frec* p_frec;
    p_frec = (Frec*)malloc(n*sizeof(Frec*));
    

    int* grupo2 = (int*)malloc(n*sizeof(int*));
    x = 0;
    for(int w = 0; w < n; w++){
        grupo2[w] = grupo[w];
    }
    if(n > 0){
        x++;
    }
    for(int i = 0; i < n; i++){
        int a = i + 1;
        if(grupo2[i] != 0){
            if(grupo[a] == 0){
                x++;
                grupo2[i] = 0;
            }
            for(int j = a; j < n; j++){
                if( grupo[i] != grupo2[j]){
                    x++;
                    for(int y = 0; y < n; y++){
                        if(grupo[i] == grupo2[y]){
                            grupo2[y] = 0;
                        }
                        if(grupo[j] == grupo2[y]){
                            grupo2[y] = 0;
                        }
                    }
                }      
            }          
        }
                 
    }
    free((void*)grupo2);
    
    int* numerosdiferentes = (int*)malloc(x*sizeof(int*));
    int* cantidadNumero = (int*)malloc(x*sizeof(int*));
    int* cantidadNumero2 = (int*)malloc(x*sizeof(int*));

    int* grupo3 = (int*)malloc(n*sizeof(int*));
    for(int w = 0; w < n; w++){
        grupo3[w] = grupo[w];
    }
    int s = 0;
    
    for(int i = 0; i < n; i++){
        int a = i + 1;
        if(grupo3[i] != 0){
            if(grupo[a] == 0){
                s++;
                numerosdiferentes[s];
                grupo2[i] = 0;
            }
            for(int j = a; j < n; j++){
                if( grupo[i] != grupo3[j]){
                    numerosdiferentes[s] = grupo[i];
                    s++;
                    numerosdiferentes[s] = grupo[j];
                    for(int y = 0; y < n; y++){
                        if(grupo[i] == grupo3[y]){
                            grupo2[y] = 0;
                        }
                        if(grupo[j] == grupo3[y]){
                            grupo2[y] = 0;
                        }
                    }
                }      
            }        
        }           
    }
    for(int i = 0; i < x; i++){
        int q = 0;
        for(int j = 0; j < n; j++){
            if(numerosdiferentes[i] == grupo[j]){
                q++;
            }
        }
        cantidadNumero[i] = q;
        cantidadNumero2[i] = q;
    }

    free((void*)grupo3);
    int e = 1;
    int k, v;
    k = 0;
    v = 0;


    
     for(int m = 0; m < x; m++){
        int mayor = 0;
        for(int u = 0; u < x; u++){
            if(cantidadNumero[u]>mayor){
                mayor = cantidadNumero[u];
            }
        }
        for(int o = 0; o < x; o++){ // p_frec->representaciones
            if(cantidadNumero[o] == mayor){
                for(int t = 0; t < numerosdiferentes[o]; t++){
                    k++;
                }
                // k++ por el 0
                k++;
                // k++ por la representacion
                k += e;
                cantidadNumero[o] = 0; 
            }
            for(int z = 0; z < n; z++){//frec.bits
                if(mayor == grupo[z]){
                    v += e;
                }
                if(grupo[z + 1] != 0){

                    v++;
                }
            }
            
        }
        if(cantidadNumero[m + 1] != 0){
            k++; // 0 divisor
        }
        
        e += 1;
    }
    free((void*)cantidadNumero);

    p_frec->representaciones = (char*)malloc(k*sizeof(char*));
    p_frec->bits = (char*)malloc(v*sizeof(char*));
    int b = 0;
    int d = 0;
    char r = 1;
    
    
    for(int m = 0; m < x; m++){
        int mayor;
        for(int u = 0; u < x; u++){
            if(cantidadNumero2[u]>mayor){
                mayor = cantidadNumero2[u];
            }
        }
        for(int o = 0; o < x; o++){ // p_frec->representaciones
            if(cantidadNumero2[o] == mayor){
                for(int t = 0; t < numerosdiferentes[o]; t++){
                    p_frec->representaciones[b] = 1;
                    b++;
                }
                p_frec->representaciones[b] = 0;
                b++;

                p_frec->representaciones[b] = r;
                b++;

                cantidadNumero2[o] = 0;
                
            }
            for(int z = 0; z < n; z++){//frec.bits
                if(mayor == grupo[z]){
                    p_frec->bits[d] = r;
                    d++;
                }
                if(grupo[z + 1] != 0){
                    p_frec->bits[d + 1] = 0;
                    d++;
                }
            } 
        }
        if(p_frec->representaciones[0] == 1){
            p_frec->representaciones[b] = 0;
            b++;
        }
        
        
        r += 1;
    }
    free((void*)cantidadNumero2);
    free((void*)numerosdiferentes);
    

    //for(int h; h < k; h++){ //se une al arreglo bits
    //    p_frec->bits[v] = p_frec->representaciones[h];
    //    v++;
    //}
    
    return p_frec;
}

int* descomprimir_en_frec(void* frec){
    Frec* frecu = (Frec*)frec;
    int* descom = (int*)malloc(39*sizeof(int*));
    for(int i = 0; i < 15; i++){
        if(frecu->bits[i] == 1){
            descom[i] = 1;
        }
        if(frecu->bits[i] == 0){
            descom[i] = 0;
        }
    }
    for(int i = 0; i < 24; i++){
        if(frecu->representaciones[i] == 1){
            descom[i] = 1;
        }
        if(frecu->representaciones[i] == 0){
            descom[i] = 0;
        }
    }
    return descom;
}

int main(){
     int g, c; //c: cantidad de numeros en un conjunto y g: la cantidad de numeros por grupo en el cojunto
    printf("c: ");
    scanf(" %d", &c);
    printf("g: ");
    scanf(" %d", &g);

    printf("Numker1 = %d\n", c);
    printf("Numker2 = %d\n", g);

    int* Conjunto = (int*)malloc(c);

    for(int i = 0; i<c; i++){
        printf("Ingrese numero dentro del conjunto: ");
        scanf(" %d", &Conjunto[i]);
    };

    for(int i = 0; i<c; i++){
        printf(" %d", Conjunto[i]);
    };
    
    printf("\n");

    for(int j = 0; j < 15; j++){
        printf(" %d", comprimir_en_frec(c, Conjunto)->bits[j]); 
    }
    printf("\n");
    for(int j = 0; j < 24; j++){
        printf(" %d", comprimir_en_frec(c, Conjunto)->representaciones[j]);
        
    }
    printf("\n");

    
    
    for(int j = 0; j < 39; j++){
        printf(" %d", descomprimir_en_frec(comprimir_en_frec(c,Conjunto))[j]);
        
    }
        
    
    printf("\n");
    /*
    printf(" %d", donde_esta_frec(comprimir_en_frec(c, Conjunto), 2, 2));
    printf("\n");
    printf(" %d", cuantos_mas_grande_frec(comprimir_en_frec(c, Conjunto), 2));
    printf("\n");
    printf(" %d", bits_frec(comprimir_en_frec(c, Conjunto)));
    printf("\n");
    mostrar_frec(comprimir_en_frec(c, Conjunto));
    printf("\n");
    */

    free((void*)descomprimir_en_frec(comprimir_en_frec(c, Conjunto)));
    free((void*)comprimir_en_frec(c, Conjunto));
    printf("\n");
    
    

    
    return 0;
}