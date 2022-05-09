#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Inc {
    // arreglo de ’0’ y ’1’
    char* bits;
    // arreglo para recordar que representacion tiene cada numero
    char* representaciones;
    // cantidad de numeros distintos en el conjunto
    char* n;
} Inc;

Inc* comprimir_en_inc(int n, int* grupo){ // grupo es un arreglo y n la cantidad del arreglo.
    Inc* p_inc;
    int x, k;
    int s = 0;
    inc.bits = (char*)malloc(x);
    inc.representaciones = (char*)malloc(k);
    inc.n = 0;
    char p = 0;
    char t = 1;

    int* grupo2 = (int*)malloc(n);
    for(int w = 0; w < n; w++){
        grupo2[w] = grupo[w];
    }

    for(int i = 0; i < n; i++){
        if(i == 0){
            p_inc->bits[i] = p;
            x++;
            int a = i + 1;
            for(int j = a; j < n; j++){
                if(grupo2[i] != 0){
                    if(grupo2[j] != NULL){
                        if(grupo2[i] == grupo2[j]){
                            p_inc->bits[j] = p;
                            x++;
                            grupo2[j] = 0;
                        }
                    }
                }
            }
            p_inc->n += 1;
            if(grupo2[i] != 0){
                for(int y = 0; y < grupo2[i]; y++){
                    p_inc->representaciones[s] = 1;
                    s++;
                }
                p_inc->representaciones[s] = '0';
                s++;
                p_inc->representaciones[s] = p;
                s++
            }
        }
        else{
            int a = i + 1;
            p_inc->bits[i] = t;
            x++;
            for(int j = a; j < n; j++){
                if(grupo2[i] != 0){
                    if(grupo2[j] != NULL){
                        p_inc->bits[i + 1] = 0;
                        if(grupo2[i] == grupo2[j]){
                            p_inc->bits[j] = t;
                            x++;
                            grupo2[j] = 0;
                            if(grupo[i + 1] != NULL){
                                p_inc->bits[j+1] = 0;
                            }
                        }
                    }
                }
            }
            t = 1;
            inc.n += 1;
            if(grupo2[i] != 0){
                for(int y = 0; y < grupo2[i]; y++){
                    inc.representaciones[s] = '1';
                    s++;
                }
                inc.representaciones[s] = '0';
                s++;
                inc.representaciones[s] = p;
                if(grupo2[i +1] != NULL){
                    s++;
                    inc.representaciones[s] = '0';
                }
            }
        }
    grupo2[i] = 0;
    }
    
    char o = '0';
    char l = '1';
    char CantidadEnBinario[inc.n];
    if(inc.n == 1){
            CantidadEnBinario[0] = o;
        }
    if(inc.n > 1){
        for(int f = 0; f < inc.n - 1; f++){
            CantidadEnBinario[f] = l;
        }
    }

    x++;
    for(int b = 0; b < s; b++){
        inc.bits[x] = inc.representaciones[b];
    }
    x++;
    for(int u = 0; u < inc.n; u++){
        inc.bits[x] = CantidadEnBinario[u];
    }
    x++;
    inc.bits[x] = '\0'

    return p_inc;

}

int* descomprimir_en_inc(void* inc){
    int* descom = (int*)malloc(sizeof(inc)/sizeof(inc[0]));
    for(int i = 0; i = sizeof(inc)/sizeof(inc[0]); i++){
        if(inc[i] == '1'){
            descom[i] = 1;
        }
        if(inc[i] == 0){
            descom[i] = 0;
        }   
    }
    return descom;

}

int  donde_esta_inc(void* inc , int e, int i){
    int q = 0;
    int p = 1;
    for(int x = 0; x < sizeof(inc)/sizeof(inc[0]) i, x++){
        if(inc[x] == e + '0'){
            p++;
            q++;
            if(q == i){
                return p;
            }
        }
        else{
            p++;
        }
    }
    return -1;

}

int  cuantos_mas_grande_inc(void* inc , int e){
    int x = y = 0; // y: cantidad mayor y x: contador
    for(int i = 0; i < sizeof(inc)/sizeof(inc[0]); i++){
        if(inc[i] != '0' ){
            x++;
        }
        else{
            if(x > e){
                y++;
                x = 0;
            }
        }
    }
    return x;

}

int  bits_inc(void* inc){
    return sizeof(inc)/sizeof(inc[0]);

}

void  mostrar_inc(void* inc){

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

    for(int j = 0; j < 9; j++){
        printf(" %d", comprimir_en_inc(c, Conjunto)->bits[j]); 
    }
    printf("\n");
    for(int j = 0; j < 21; j++){
        printf(" %d", comprimir_en_inc(c, Conjunto)->representaciones[j]);
        
    }
    printf("\n");

    
    
    for(int j = 0; j < 2; j++){
        printf(" %d", comprimir_en_inc(c,Conjunto)->n[j]);
        
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