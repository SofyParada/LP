#lang scheme

(define (suma_especial l a)
  (if (pair? l)
     (truncate(* (apply + l)a))
     (0)))

(define (merge_simple l1 l2 ops)
  (cond
       ((null? ops) '())
       ((eq? #\S (car ops)) (cons (+ (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
       ((eq? #\M (car ops)) (cons (* (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
       ((eq? #\R (car ops)) (cons (- (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
       
       ))

(define (merge_cola l1 l2 ops)
  (let aux ((x ops) (y l1) (z l1) (a '()))
    (cond
      ((null? ops) '())
      ((eq? #\S (car ops)) (cons (+ (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
      ((eq? #\M (car ops)) (cons (* (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
      ((eq? #\R (car ops)) (cons (- (car l1) (car l2)) (merge_simple (cdr l1) (cdr l2) (cdr ops))))
       
      )))
;;(revertir l)
;;A partir de append, va creando una lista nueva donde la ultima parte de la lista antigua es la primera, asi hasta revertirla, usando recursividad.
;;Retorna la lista con los valores invertidos
(define (revertir l)
         (if (null? l)
            '()
          (append (revertir (cdr l)) (list(car l)))))  

(define (demerge_simple l f)
  (let aux ((x  l) (z (map f l)) (p (map f l)) (y 0) (m '()) )
    (cond
      ((null? z) (list p  (revertir m)))
      ((pair? l) (set! m(cons (- (car x) (car z)) m )) (aux (cdr x) (cdr z) p (- (car x) (car z)) m))
      )
    )
  )


(define (demerge_cola l f)
  (let aux ((x  l) (z (map f l)) (p (map f l)) (y 0) (m '()) )
    (cond
      ((null? z) (list p  (revertir m)))
      ((pair? l) (set! m(cons (- (car x) (car z)) m )) (aux (cdr x) (cdr z) p (- (car x) (car z)) m))
      )
    )
  )

; Casos de ejemplos
; Cabe destacar que su tarea debe funcionar para cualquier
; caso, hay mas casos de prueba para la correccion

; Funcion 1
(suma_especial '(1 2 3 4) 4)

; Funcion 2
(merge_simple '(1 2 3) '(4 5 6) '(#\S #\M #\R))
(merge_cola '(1 2 3) '(4 5 6) '(#\S #\M #\R))

; Funcion 3
(demerge_simple '(1 2 3 4 5 6) (lambda (x) (quotient x 2)))
(demerge_simple '(1 2 3 4 5 6) (lambda (x) (modulo x 2)))
(demerge_cola '(1 2 3 4 5 6) (lambda (x) (quotient x 2)))
(demerge_cola '(1 2 3 4 5 6) (lambda (x) (modulo x 2)))
