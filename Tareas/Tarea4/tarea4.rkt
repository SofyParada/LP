#lang scheme

;;(suma_especial l a)
;;Hace una suma de los elementos de la lista l y luego lo divide por el numero a.
;;Entrega un entero.
(define (suma_especial l a)
    (define (suma l)
      (if(empty? l) 0
        (+ (car l) (suma(cdr l)))))
            (truncate(/ (suma l) a)))

;;(merger_simple l1 l2 ops)
;;Tiene la función de generar una lista con recursión simple que sume, reste o multiplique (dependiendo del caracter en la pocisión i) la posición i de l1 y de l2.
;;Entrega una lista de enteros.
(define (merge_simple l1 l2 ops)
  (cond
    ((empty? ops) (append null))
    ((equal? (first ops) #\S) (append (list(+ (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
    ((equal? (first ops) #\R) (append (list(- (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
    ((equal? (first ops) #\M) (append (list(* (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))))

;;(merge_cola l1 l2 ops)
;;Tiene la función de generar una lista con recursión de cola que sume, reste o multiplique (dependiendo del caracter en la pocisión i) la posición i de l1 y l2.
;;Entrega una lista de enteros.
(define (merge_cola l1 l2 ops)
      (let lista ((a ops) (b l1) (c l2) (d '()))
        (if (empty? a)
            d
            (cond
              ((equal? (car a) #\S) (lista (cdr a) (cdr b) (cdr c) (append d (list (+ (car b) (car c))))))
              ((equal? (car a) #\R) (lista (cdr a) (cdr b) (cdr c) (append d (list (- (car b) (car c))))))
              ((equal? (car a) #\M) (lista (cdr a) (cdr b) (cdr c) (append d (list(* (car b) (car c))))))))))


;;(demerge_simple l f)
;;Tiene la función de generar una lista con recursion simple con dos listas dentro de esta, donde la primera se le aplicar la funcion lambda f a cada uno de los numeros de la lista l y en la segunda lista se le resta los caracteres de la primera lista con la lista l.
;;Entrega una lista compuesto por listas que estan cmpuestas por enteros.
(define (demerge_simple l f)
  (let lista((l1 l) (f1 f) (l2 '()) (l3 '()) (a (lambda (x y) (list (y (car x))))) ( b (lambda (i j) (list (- (car i) (j (car i)))))))
    (if (empty? l1)
        (list l2 l3)
        (append '() (lista (cdr l1) f1 (append l2 (a l1 f)) (append l3 (b l1 f1)) a b)))))

     
     

;;(demerge_cola l f)
;;Tiene la función de generar una lista con recursion cola con dos listas dentro de esta, donde la primera se le aplicar la funcion lambda f a cada uno de los numeros de la lista l y en la segunda lista se le resta los caracteres de la primera lista con la lista l.
;;Entrega una lista compuesto por listas que estan cmpuestas por enteros.
(define (demerge_cola l f)
  (let lista((l1 l) (f1 f) (l2 '()) (l3 '()) (a (lambda (x y) (list (y (car x))))) ( b (lambda (i j) (list (- (car i) (j (car i)))))))
    (if (empty? l1)
        (list l2 l3)
        (lista (cdr l1) f1 (append l2 (a l1 f)) (append l3 (b l1 f1)) a b))))
        

;;(superior l ops f nums)
;;Tiene la función de retornar un numero 1 o 0, donde le numero 1 significa que es un conjunto si mismo superior y el numero 0 significa que no es un conjunto si mismo superior.
;;Entrega un entero.
(define (superior l ops f num)
  (let ((l1 l) (l2 l) (l3 ops) (f1 f) (n num))
    (let ((merge_res ((lambda (x y z) (merge_cola x y z)) l1 l2 l3)))
      (let ((demerge_res ((lambda (i j) (demerge_cola i j)) merge_res f1)))
        (let ((r1 ((lambda (p q) (* (suma_especial p q) 2)) l1 n)))
          (let ((r2 ((lambda (d c)(+ (suma_especial (first d) c) (suma_especial (second d) c))) demerge_res n)))
            (if (> r1 r2) 1
                0)))))))
          
;;(all_superior matriz_ls matriz_ops matriz_f matriz_nums c f)
;;Tiene la función de generar una lista que contiene una cantidad de lista que da el resultado de la funcion superior de cada fila de la matriz.++
;;Entraga una lista que contiene listas que contienen dos enteros cada una.
(define (all_superior matriz_ls matriz_ops matriz_f matriz_nums c f)
  (let lista((ls matriz_ls) (ops matriz_ops) (f matriz_f) (nums matriz_nums) (col c) (fil f) (i 0) (j 0) (l '()) (l2 '()))
       (if (< i fil)
           (if (< j col)
                  (lista ls ops f nums col fil i (+ 1 j) (append l (list(superior (list-ref (list-ref ls j) i) (list-ref (list-ref ops j) i) (list-ref (list-ref f j) i) (list-ref (list-ref nums j) i)))) l2) 
                  (lista ls ops f nums col fil (+ i 1) 0 '() (append l2 (list l))))
            
           (let listafinal((l3 (first l2)) (l4 (second l2)) (l5 '()))
             (if (or (empty? l3) (empty? l4))
                 l5
                 (listafinal (cdr l3) (cdr l4) (append l5 (list(list (car l3) (car l4)))))))))) 
                                              
                                        
  
  
    
                 
        