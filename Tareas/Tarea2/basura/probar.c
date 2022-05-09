#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Unario {
    // arreglo de ’0’ y ’1’
    char* bits;
} Unario;


Unario* comprimir_en_unario(int n, int* grupo){
    int x = 0;
    int y = 0;
    Unario* p_una;
    p_una = (Unario*)malloc(n*sizeof(Unario*));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < grupo[i]; j++){
            y++;
        }
        if(i + 1 != n){
            y++;
        }
        
    }
    p_una->bits = (char*)malloc(y);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < grupo[i]; j++){
            p_una->bits[x] = 1;
            x++;
        }
    
        p_una->bits[x] = 0;
        x++;
        
    }
     p_una->bits[x] = '\0';
    
    return p_una;
}

int* descomprimir_en_unario(void* unario){
    Unario *unari = (Unario*)unario;
    int tamano = sizeof(unario)/sizeof(char*);
    int* descom = (int*)malloc(36*sizeof(int*));
    for(int i = 0; i < 36; i++){
        if(unari->bits[i] == 1){
            descom[i] = 1;
        }
        else{
            descom[i] = 0;
        }   
    }
    free((void*)unari);
    return descom;
}

int  donde_esta_unario(void* unario , int e, int i){
    int q = 0;
    int p = 0;
    int donde = 0;
    Unario* unari = (Unario*)unario;
    for(int x = 0; x < 36; x++){
        if(unari->bits[x] != 0 ){
            p++;
        }
        else{
            donde++;
            if(p == e){
                q++;
                p = 0;
                if(q == i){
                    return donde -1;
                    
                }
            }
            else{
                p = 0;
            }
        }
    }
    
    return -1;
}

int  cuantos_mas_grande_unario(void* unario , int e){
    int x = 0; // y: cantidad mayor y x: contador
    int y = 0;
    Unario * unari = (Unario*) unario;
    for(int i = 0; i < 36; i++){
        if(unari->bits[i] != 0 ){
            x++;
        }
        if(unari->bits[i] == 0 || unari->bits[i + 1] == 0 ){
            if(x > e){
                y++;
                x = 0;
            }
            else{
                x = 0;
            }
        }
    }
    return y;

}

int  bits_unario(void* unario){ //esta malo
    Unario* unari = (Unario*) unario;
    return strlen(unari->bits)/sizeof(char*);

}

void mostrar_unario(void* unario){
    Unario* unari = (Unario*) unario;
    printf("Unario:");
    printf("\n");
    for(int i = 0; i < 36; i++){
        printf(" %d",unari->bits[i]);
    }
    
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
    int x = 0;
    for(int i = 0; i<c; i++){
        printf(" %d", Conjunto[i]);
    };
    printf("\n");
    int y = 0;
    for(int i = 0; i< c; i++){
        for(int j = 0; j < Conjunto[i]; j++){
            y++;
        }
        if(i+1 != c){
            y++;
        }
        
    }


    for(int j = 0; j < y; j++){
        printf(" %d", comprimir_en_unario(c, Conjunto)->bits[j]);
        
    }
    printf("\n");
    char * compri = comprimir_en_unario(c, Conjunto)->bits;

    
    
    for(int j = 0; j < y; j++){
        printf(" %d", descomprimir_en_unario(comprimir_en_unario(c,Conjunto))[j]);
        
    }
        
    
    printf("\n");

    printf(" %d", donde_esta_unario(comprimir_en_unario(c, Conjunto), 2, 2));
    printf("\n");
    printf(" %d", cuantos_mas_grande_unario(comprimir_en_unario(c, Conjunto), 2));
    printf("\n");
    printf(" %d", bits_unario(comprimir_en_unario(c, Conjunto)));
    printf("\n");
    mostrar_unario(comprimir_en_unario(c, Conjunto));

    
    printf("\n");
    free((void*)descomprimir_en_unario(comprimir_en_unario(c, Conjunto)));
    free((void*)comprimir_en_unario(c, Conjunto)->bits);
    printf("\n");
    
    
    
    
    return 0;

}