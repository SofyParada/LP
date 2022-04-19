import re
def caminoEncamino(elemento):
    camino = re.finditer('([(].*?[:].*?[)])', elemento)

archivoInput = open('input.txt', )

calles = []
caminos = []
Prints = []
IDs = []
for linea in archivoInput:
    separar = re.split(';', linea)
    print(separar)
    for elemento in separar:
        camino = re.finditer('([(].*?[:].*?[)])', elemento)
        print(camino)





'''
nombre_calle = str(input("Nombre de la calle: "))


if re.findall('([A-Z][a-z]|[A-Z]|\d|[-]|[ ]{len(nombre) - 1})', nombre_calle):
    print('nombre de calle correcto')
else:
    print('nombre de calle incorrecto')


ID_calle = str(input("ID de la calle: "))

if re.findall('(#[A-Z]{2}[0-9]{2})', ID_calle): #listo
    print("id de calle correcta")
else:
    print("id de calle incorrecta")


nombre_persona = str(input("Nombre de la persona: "))

if re.findall('([A-Z][a-z]|[A-Z]|[-]|[ ]{len(nombre) - 1})', nombre_persona):
    print('nombre de persona correcto')
else:
    print('nombre de persona incorrecto')

apellido_persona = str(input("apellido de la persona: "))

if re.findall('([A-Z][a-z]|[A-Z]|[-]|[ ]{len(nombre) - 1})', apellido_persona):
    print('apellido de persona correcto')
else:
    print('apellido de persona incorrecto')


telefono = str(input("Telefono: "))

if re.findall('([+][1-9][0-9]{5})', telefono):
    print('telefono correcto')
else:
    print('telefono incorrecto')


rut = str(input("rut: ")) #20809629-K

if re.findall('([1-9][0-9]{7}[-]\d|K)', rut):
    print("formato de rut correcto")
    numeroEncntrado = re.match('([1-9][0-9]{7})', rut)
    numero = numeroEncntrado.group()
    numerolista = re.findall('\d', numero)
    numerolista.reverse()
    suma = 0
    i = 2
    for digito in numerolista:
        if i != 7:
            multi = int(digito) * i
            suma += multi
            i += 1
        else:
            multi = int(digito) * i
            suma += multi
            i = 2
    entero = suma // 11
    resto = suma - (11 * entero)
    resto2 = 11 - resto
    if resto2 == 11:
        digito_verificador = 0
        if re.findall('0$', rut):
            print('rut correcto')

    elif resto2 == 10:
        digito_verificador = "K"
        if re.findall('K$', rut):
            print('rut correcto')

    else:
        digito_verificador = resto2
        if re.findall('[1-9]$', rut):
            print('rut correcto')
'''







