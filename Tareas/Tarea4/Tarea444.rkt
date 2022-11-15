#lang scheme

(define (suma_especial l a)
    (define (suma l)
      (if(empty? l) 0
        (+ (car l) (suma(cdr l)))))
            (truncate(/ (suma l) a)))

(define (merge_simple l1 l2 ops)
  (cond
    ((empty? ops) (append null))
    ((equal? (first ops) #\S) (append (list(+ (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
    ((equal? (first ops) #\R) (append (list(- (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
    ((equal? (first ops) #\M) (append (list(* (car l1) (car l2))) (merge_simple (cdr l1) (cdr l2) (cdr ops))))))
        
          

(define (merge_cola l1 l2 ops)
      (let lista ((a ops) (b l1) (c l2) (d '()))
        (if (empty? a)
            d
            (cond
              ((equal? (car a) #\S) (lista (cdr a) (cdr b) (cdr c) (append d (list (+ (car b) (car c))))))
              ((equal? (car a) #\R) (lista (cdr a) (cdr b) (cdr c) (append d (list (- (car b) (car c))))))
              ((equal? (car a) #\M) (lista (cdr a) (cdr b) (cdr c) (append d (list(* (car b) (car c))))))))))
              
(define (demerge_simple l f)
  (let lista ((a l) (b f) (c '()) (d '()))
    (if (empty? a)
        (list c d)
        (lista (cdr a) b (append c (list (b (car a)))) (append d (list (- (car a) (f (car a)))))))))

(define (demerge_cola l f)
  (let lista ((a l) (b f) (c '()) (d '()) (e '()))
    (if (empty? a)
    c
    (lista (cdr a) b (list(append d (list (b (car a)))) (append e (list (- (car a) (f (car a)))))) (append d (list (b (car a)))) (append e (list (- (car a) (f (car a))))) ))))

(define (superior l ops f num)
  (let ((l1 l) (l2 l) (l3 ops) (f1 f) (n num))
    (let ((merge_res (merge_simple l1 l2 l3)))
      (let ((demerge_res (demerge_simple merge_res f1)))
        (let ((r1 (* (suma_especial l1 n) 2)))
          (let ((r2 (+ (suma_especial (first demerge_res) n) (suma_especial (second demerge_res) n))))
            (if (> r1 r2) 1
                0)))))))
          
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
; Casos de ejemplos
; Cabe destacar que su tarea debe funcionar para cualquier
; caso, hay mas casos de prueba para la correccion

; Funcion 1
(suma_especial '(1 2 3 4) 4)

; Funcion 2
(merge_simple '(1 2 3) '(4 5 6) '(#\S #\M #\R))
(merge_cola '(1 2 3) '(4 5 6) '(#\S #\M #\R))

; Funcion 3
(demerge_simple '(1 2 3 4 5 6) '(lambda (x) (quotient x 2)))
(demerge_simple '(1 2 3 4 5 6) '(lambda (x) (modulo x 2)))
(demerge_cola '(1 2 3 4 5 6) '(lambda (x) (quotient x 2)))
(demerge_cola '(1 2 3 4 5 6) '(lambda (x) (modulo x 2)))

; Funcion 4
(superior '(1 2 3) '(#\S #\M #\R) (lambda (x) (- x 2)) 2)
(superior '(1 2 3) '(#\S #\S #\M) (lambda (x) (modulo x 2)) 2)

; Funcion 5
(all_superior
 '(((1 2 3) (1 1 1)) ((2 2 2) (3 4 5)))
 '(((#\S #\M #\R) (#\S #\S #\S)) ((#\R #\R #\R) (#\S #\S #\M)))'
 '(((lambda (x) (- x 2)) (lambda (x) (modulo x 2))) ((lambda (x) (quotient x 2)) (lambda (x) (modulo x 2))))
 '((2 3) (2 2))
 2 2
 )