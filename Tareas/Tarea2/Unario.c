#include <stdio.h>
#include <Unario.h>

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

int  bits_unario(void* unario){
    return sizeof(unario)/sizeof(unario[0]);

}

void  mostrar_unario(void* unario){
    Unario* unari = (Unario*) unario;
    printf("Unario:");
    printf("\n");
    for(int i = 0; i < 36; i++){
        printf(" %d",unari->bits[i]);
    }
    
    return;

}
