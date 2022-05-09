#include <stdio.h>
#include <Inc.h>

Inc* comprimir_en_inc(int n, int* grupo){ // grupo es un arreglo y n la cantidad del arreglo.
    Inc inc;
    int x, r, k;
    int s = 0;
    inc.bits = (char*)malloc(x);
    inc.representaciones = (char*)malloc(k);
    inc.n = 0;
    char p = 0;
    char t = 1;

    int* grupo2 = (int*)malloc(r);
    for(int w = 0; w < n; w++){
        grupo2[w] = grupo[w];
    }

    for(int i = 0; i < n; i++){
        if(i == 0){
            inc.bits[i] = p;
            x++;
            int a = i + 1;
            for(int j = a; j < n; j++){
                if(grupo2[i] != 0){
                    if(grupo2[j] != NULL){
                        if(grupo2[i] == grupo2[j]){
                            inc.bits[j] = p;
                            x++;
                            grupo2[j] = 0;
                        }
                    }
                }
            }
            inc.n += 1;
            if(grupo2[i] != 0){
                for(int y = 0; y < grupo2[i]; y++){
                    inc.representaciones[s] = 1;
                    s++;
                }
                inc.representaciones[s] = 0;
                s++;
                inc.representaciones[s] = p;
                s++
            }
        }
        else{
            int a = i + 1;
            inc.bits[i] = t;
            x++;
            for(int j = a; j < n; j++){
                if(grupo2[i] != 0){
                    if(grupo2[j] != NULL){
                        inc.bits[i] += 0;
                        if(grupo2[i] == grupo2[j]){
                            inc.bits[j] = t;
                            x++;
                            grupo2[j] = 0;
                            if(grupo[i + 1] != NULL){
                                inc.bits[j] += 0;
                            }
                        }
                    }
                }
            }
            t += 1;
            inc.n += 1;
            if(grupo2[i] != 0){
                for(int y = 0; y < grupo2[i]; y++){
                    inc.representaciones[s] = 1;
                    s++;
                }
                inc.representaciones[s] = 0;
                s++;
                inc.representaciones[s] = p;
                if(grupo2[i +1] != NULL){
                    s++;
                    inc.representaciones[s] = 0;
                }
            }
        }
    grupo2[i] = 0;
    }
    
    char o = 0;
    char l = 1;
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

    return inc.bits;

}

int* descomprimir_en_inc(void* inc){
    Inc* incre = (Inc*) inc;
    int largobits = sizeof(incre->bits)/sizeof(char*);
    int largorepresentaciones = sizeof(incre->representaciones)/sizeof(char*);
    int largon = sizeof(incre->n)/sizeof(char*);
    int largoTotal = largobits + largorepresentaciones + largon;
    int* descom = (int*)malloc(largoTotal);
    for(int i = 0; i < largobits; i++){
          descom[i] = incre->bits[i];
    }
    for(int i = 0; i < largorepresentaciones; i++){
          descom[i] = incre->representaciones[i];
    }
    for(int i = 0; i < largon; i++){
          descom[i] = incre->n[i];
    }
    return descom;

}

int  donde_esta_inc(void* inc , int e, int i){
    Inc* incre = (Inc*) inc;
    int largobits = sizeof(incre->bits)/sizeof(char*);
    int q = 0;
    int p = 1;
    for(int x = 0; x < largobits, x++){
        if(incre->bits[x] == e + 0){
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
    Inc* incre = (Inc*) inc;
    int largobits = sizeof(incre->bits)/sizeof(char*);
    int x = y = 0; // y: cantidad mayor y x: contador
    for(int i = 0; i < largobits; i++){
        if(incre->bits[i] != 0){
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
    Inc* incre = (Inc*) inc;
    int largobits = sizeof(incre->bits)/sizeof(char*);
    int largorepresentaciones = sizeof(incre->representaciones)/sizeof(char*);
    int largon = sizeof(incre->n)/sizeof(char*);
    int largoTotal = largobits + largorepresentaciones + largon;
    return largoTotal;

}

void  mostrar_inc(void* inc){
    Inc* incre = (Inc*) inc;
    int largobits = sizeof(incre->bits)/sizeof(char*);
    int largorepresentaciones = sizeof(incre->representaciones)/sizeof(char*);
    int largon = sizeof(incre->n)/sizeof(char*);
    printf("Segun Incremento:");
    printf("\n");
    for(int i = 0; i < largobits; i++){
        printf(" %d",incre->bits[i]);
    }
    printf("\n");
    for(int j = 0; j < largorepresentaciones; j ++){
        printf(" %d", incre->representaciones[j]);
    }
    printf("\n");
    for(int j = 0; j < largon; j ++){
        printf(" %d", incre->n[j]);
    }
    return; 
    

}

