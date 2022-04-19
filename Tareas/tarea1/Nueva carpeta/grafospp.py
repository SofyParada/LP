import re

def callecreada(calle):
    if len(re.findall('[.]', calle)) < 2:
        errores.write(elemento + '\n')
    nombre_calle, ID_calle, persona = re.split('[.]', calle)
    if len(re.findall('_', persona)) < 2:
        errores.write(calle + '\n')
    nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
    if re.findall('^[^A-ZÁÉÍÓÚ]', nombre_calle):
        errores.write(calle + '\n')
    elif re.findall('([^#][A-Z]{2}[0-9]{2})', ID_calle):
        errores.write(calle+ '\n')
    elif re.findall('([#][^A-Z]{2}[0-9]{2})', ID_calle):
        errores.write(calle + '\n')
    elif re.findall('([#][A-Z]{2}[^0-9]{2})', ID_calle):
        errores.write(calle + '\n')
    elif re.findall('(^[^A-Z])', nombre_persona):
        errores.write(calle + '\n')
    elif re.findall('^[^A-Z]', apellido_persona):
        errores.write(calle + '\n')
    elif re.findall('([^+][1-9][0-9]{5})', telefono):
        errores.write(calle + '\n')
    elif re.findall('([+][0][0-9]{5})', telefono):
        errores.write(calle + '\n')
    elif re.findall('([+][1-9][0-9]{0,4}$)', telefono):
        errores.write(calle + '\n')
    elif re.findall('([+][1-9][0-9]{6,})', telefono):
        errores.write(calle + '\n')
    elif re.findall('(^[0][0-9]*?[-][0-9Kk])', rut):
        errores.write(calle + '\n')
    elif re.findall('([^-][0-9Kk])$', rut):
        errores.write(calle + '\n')
    elif re.findall('([1-9][0-9]*?[-][^0-9Kk])', rut):
        errores.write(calle + '\n')
    elif re.findall('([1-9][0-9]*?[-][0-9Kk])$', rut):
        numeroEncntrado = re.search('([1-9][0-9]*?[-][0-9Kk])$', rut)
        numero = rut[numeroEncntrado.start():numeroEncntrado.end()-2]
        verificador = rut[numeroEncntrado.end()-1:]
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
            digito_verificador = '0'

        elif resto2 == 10:
            digito_verificador = "Kk"

        else:
            digito_verificador = str(resto2)

        if verificador in digito_verificador:
            return calle
        else:
            errores.write(calle + '\n')

'''
callecreada
———————–
calle : string
————————
Tiene la función de identificar si el parametro calle tiene algun error se ira al archivo de texto errores.txt y si esta todo correcto con la calle
 se retornara la calle.
'''
def caminocreado(elemento, calles, caminos, IDs):
    caminos += [elemento]
    camino_actual = elemento[1:len(elemento) - 1]  # para sacar los parentesis de los extremos
    separar_camino = re.split(':', camino_actual)
    for elemento2 in separar_camino:
        if re.findall('([A-ZÁÉÍÓÚ].*?[.].*?[.].*?[0-9Kk])', elemento2):
            if re.findall('[(]', elemento2):
                calleEncontrada = re.search('([A-ZÁÉÍÓÚ].*?[.].*?[.].*?[0-9Kk]$)', elemento2)
                calle = elemento2[calleEncontrada.start():]
            elif re.findall('[)]', elemento2):
                calleEncontrada = re.search('([A-ZÁÉÍÓÚ].*?[.].*?[.].*?[0-9Kk]$)', elemento2)
                calle = elemento2[calleEncontrada.start():calleEncontrada.end()]
            else:
                calle = elemento2
            calleencamino = callecreada(calle)
            if calleencamino != None:
                calles += [calleencamino]
            else:
                errores.write(elemento + '\n')
                caminos.remove(elemento)
                break


        elif re.findall('(#[A-Z]{2}[0-9]{2})', elemento2):
            calles1 = []
            for calle in calles:
                if elemento2 in calle:  # En caso de que el ID no se encuentre en alguna calle
                    if re.findall('[(]', elemento2):
                        IDEncontarda = re.search('(#[A-Z]{2}[0-9]{2})', elemento2)
                        ID = elemento2[IDEncontarda.start():]
                        IDs += [ID]
                    elif re.findall('[)]', elemento2):
                        IDEncontarda = re.search('(#[A-Z]{2}[0-9]{2})', elemento2)
                        ID = elemento2[:IDEncontarda.end()]
                        IDs += [ID]
                    else:
                        ID = elemento2
                        IDs += [ID]
                else:
                    calles1 += [calle]
            if calles1 == calles:
                errores.write(elemento + '\n')
                caminos.remove(elemento)
                break
        else:
            errores.write(elemento + '\n')
            caminos.remove(elemento)
            break
    if elemento in caminos:
        if re.findall('([(].*?[:].*?[)])', camino_actual):
            caminos += re.findall('([(].*?[:].*?[)])', camino_actual)
'''
caminocreado
———————–
elemento : string
calles : Lista
caminos : Lista
IDs : Lista
————————
Tiene la función de identificar un camino y separar sus componentes para ver si estan correctos y si no los manda al archivo errores.txt.
'''

def print_ID_calle(elemento, calles):
    IDEncontrado = re.search('(#[A-Z]{2}[0-9]{2})$', elemento)
    ID = elemento[IDEncontrado.start():]
    callemalas = []
    if None in calles:
        calles.remove(None)
    if re.findall('(#[A-Z]{2}[0-9]{2})$', elemento):
        for calle in calles:
            nombre_calle, ID_calle, persona = re.split('[.]', calle)
            nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
            if ID == ID_calle:
                print('CALLE:')
                print(nombre_calle)
                print(ID_calle)
                print(nombre_persona)
                print(apellido_persona)
                print(telefono)
                print(rut)
            else:
                callemalas += [calle]
        if calles == callemalas:
            print('No existe esa calle')
    else:
        errores.write(elemento + '\n')
'''
print_ID_calle
———————–
elemento : string
calles : lista 
————————
Su función es que imprima todos los elementos de la calle solo del respectivo ID y si este no existe se imprimira que no existe la calle.
'''

def print_all(calles):
    if None in calles:
        calles.remove(None)
    for calle in calles:
        nombre_calle, ID_calle, persona = re.split('[.]', calle)
        nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
        print('CALLE:')
        print(nombre_calle)
        print(ID_calle)
        print(nombre_persona)
        print(apellido_persona)
        print(telefono)
        print(rut)
'''
print_all
———————–
calles : Lista
————————
Tiene la función de imprimir los elementos de todas las calles que el progama a leido hasta el momento.
'''

def print_caminos_ID_calle(elemento, caminos, IDs): #no supe como convertirlo en función
    IDEncontrado = re.search('(#[A-Z]{2}[0-9]{2})$', elemento)
    ID = elemento[IDEncontrado.start():]
    if re.findall('(#[A-Z]{2}[0-9]{2})$', elemento):
        if ID in IDs:
            print('CAMINOS DESDE ' + ID + ':')
            caminosmalos = []
            for camino in caminos:
                camino = camino[1:len(camino) - 1]
                if len(re.findall(':', camino)) == 1:
                    info1, info2 = re.split(':', camino)

                    if re.findall('([A-ZÁÉÍÓÚ].*?[.].*?[.].*?[0-9kK]$)', info1):  # si el camino es calle
                        _, ID_calle1, _ = re.split('[.]', info1)
                        if ID_calle1 == ID:
                            if re.findall('([A-ZÁÉÍÓÚ].*?[.].*?[.].*?[0-9kK]$)', info2):
                                _, ID_calle2, _ = re.split('[.]', info2)
                                print(ID_calle1 + '-->' + ID_calle2)

                            elif re.findall('(#[A-Z]{2}[0-9]{2})$', info2):
                                priny(ID_calle1 + '-->' + info2)

                            else:
                                print('')


                    elif re.findall('(#[A-Z]{2}[0-9]{2})$', info1):  # si el camino es ID
                        if info1 == ID:
                            if re.findall('(.*?[.].*?[.].*?[0-9kK]$)', info2):
                                _, ID_calle2, _ = re.split('[.]', info2)
                                print(info1 + '-->' + ID_calle2)


                            elif re.findall('(#[A-Z]{2}[0-9]{2}?)$', info2):
                                print(info1 + '-->' + info2)

                            else:
                                print('')

                    else:  # si el ID de la primera parte de los caminos que pasan no es el que piden
                        caminosmalos += [camino]

            if caminos == caminosmalos:
                print('No existe esa calle')
        else:
            errores.write(elemento + '\n')

    else:
        errores.write(elemento + '\n')
'''
print_caminos_ID_calle
———————–
elemento : string
caminos : Lista
ids : Lista
————————
Tiene la función de imprimir a que IDs va el ID pedido.
'''


def print_by_nombrenombre(elemento, calles):
    nombreEncontrado = re.search('(?!.* (?: |$))[A-Z][a-z- ]+$', elemento)
    nombre = elemento[nombreEncontrado.start():]
    if None in calles:
        calles.remove(None)
    if re.findall('(?!.* (?: |$))[A-Z][a-z- ]+$', elemento):
        print('CALLES CON PERSONAS DE NOMBRE ' + nombre + ':')
        callemalas = []
        for calle in calles:
            nombre_calle, ID_calle, persona = re.split('[.]', calle)
            nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
            if nombre in nombre_persona:  # porque puede existir más de un nombe de persona
                print(nombre_calle)
            else:
                callemalas = [calle]

        if calles == callemalas:
            print('No existen calles con personas con ese nombre')
    else:
        errores.write(elemento + '\n')
'''
print_by_nombrenombre
———————–
elemento : string
calles : Lista
————————
Tiene la función de imprimir el nombre de la calle donde se encuentra el nombre de la respectiva persona. 
'''
def print_by_apellidoapellido(elemento, calles):
    apellidoEncontrado = re.search('(?!.* (?: |$))[A-Z][a-z- ]+$', elemento)
    apellido = elemento[apellidoEncontrado.start():]
    if None in calles:
        calles.remove(None)
    if re.findall('(?!.* (?: |$))[A-Z][a-z- ]+$', elemento):
        print('CALLES CON PERSONAS DE APELLIDO ' + apellido + ':')
        callemalas = []
        for calle in calles:
            nombre_calle, ID_calle, persona = re.split('[.]', calle)
            nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
            if apellido in apellido_persona:  # porque puede existir más de un apellido de persona
                print(nombre_calle)
            else:
                callemalas = [calle]

        if callemalas == calles:
            print('No existen calles con personas con ese apellido')
    else:
        errores.write(elemento + '\n')
'''
rint_by_apellidoapellido
———————–
elemento : string
calles : Lista
————————
Tiene la función de imprimir el nombre de la calle donde se encuentra el apellido de la respectiva persona  
'''

def print_by_rutrut(elemento, calles):
    rut1Encontrado = re.search('([1-9][0-9]*?[-][0-9Kk])$', elemento)
    rut1 = elemento[rut1Encontrado.start():]
    if None in calles:
        calles.remove(None)
    if re.findall('([1-9][0-9]*?[-][0-9Kk])$', elemento):
        print('CALLES CON PERSONAS DE RUT ' + rut1 + ':')
        callemalas = []
        for calle in calles:
            nombre_calle, ID_calle, persona = re.split('[.]', calle)
            nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
            if rut1 == rut:
                print(nombre_calle)
            else:
                callemalas = [calle]

        if callemalas == calles:
            print('No existen calles con personas con ese rut')
    else:
        errores.write(elemento + '\n')
'''
print_by_rutrut
———————–
elemento : string
calles : Lista
————————
Tiene la función de imprimir el nombre de la calle donde se encuentra el rut de la respectiva persona 
'''
def print_by_telefonotelefono(elemento, calles):
    telefono1Encontado = re.search('([+][1-9][0-9]{5}?)$', elemento)
    telefono1 = elemento[telefono1Encontado.start():]
    print('CALLES CON PERSONAS DE TELEFONO ' + telefono1 + ':')
    callemalas = []
    if None in calles:
        calles.remove(None)
    if re.findall('([+][1-9][0-9]{5}?)$', elemento):
        for calle in calles:
            nombre_calle, ID_calle, persona = re.split('[.]', calle)
            nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
            if telefono1 == telefono:
                print(nombre_calle)
            else:
                callemalas = [calle]

        if callemalas == calles:
            print('No existen calles con personas con ese telefono')
    else:
        errores.write(elemento + '\n')
'''
print_by_telefonotelefono
———————–
elemento : string
calles : Lista
————————
Tiene la función de imprimir el nombre de la calle donde se encuentra el telefono de la respectiva persona.
'''
def update_ID_callecalle(elemento, calles, caminos):
    IDEncontrado = re.search('(#[A-Z]{2}[0-9]{2})\s', elemento)
    ID = elemento[IDEncontrado.start(): IDEncontrado.end() - 1]
    calle = elemento[IDEncontrado.end():]
    calle1 = callecreada(calle)
    if calle1 != None:
        calles += [callecreada(calle)]
    caminopasado = []
    if calle1 == calle:
        nombre_calle, ID_calle, persona = re.split('[.]', calle1)
        for calle2 in calles:
            if ID in calle2:
                calles.remove(calle2)
        for camino in caminos:
            camino1 = camino[1:len(camino) - 1]
            info1, info2 = re.split(':', camino1)
            if ID == info1:
                actualizacion = '(' + ID_calle + ':' + info2 + ')'
                caminos += [actualizacion]
                caminopasado += [camino]
            elif ID == info2:
                actualizacion = '(' + info1 + ':' + ID_calle + ')'
                caminos += [actualizacion]
                caminopasado += [camino]
            elif ID in info1:
                actualizacion = '(' + calle1 + ':' + info2 + ')'
                caminos += [actualizacion]
                caminopasado += [camino]
            elif ID in info2:
                actualizacion = '(' + info2 + ':' + calle1 + ')'
                caminos += [actualizacion]
                caminopasado += [camino]
        for caminop in caminopasado:
            caminos.remove(caminop)
'''
update_ID_callecalle
———————–
elemento : string
calles : Lista
caminos : Lista
————————
Tiene la función de actualizar la información de la calle que contiene ID_calle por la nueva calle que dan y no retorna nada.
'''
def valid_caminoID_calle_1ID_calle_2(elemento, calles, caminos):
    ID1Encontrado = re.search('(#[A-Z]{2}[0-9]{2})\s', elemento)
    ID1 = elemento[ID1Encontrado.start(): ID1Encontrado.end() - 1]
    ID2 = elemento[ID1Encontrado.end():]
    ID1existe = ''
    ID2existe = ''
    for calle in calles:
        if ID1 in calle:
            ID1existe += 'ID1 existe'
        if ID2 in calle:
            ID2existe += 'ID2 existe'
    x = ''
    if ID1existe == 'ID1 existe' and ID2existe == 'ID2 existe':
        for camino in caminos:
            inf1, inf2 = re.split(':', camino)
            if ID1 in inf1:
                if ID2 in inf2:
                    x += 'Si se puede'
                    print('Si se puede')
        if x != 'Si se puede':
            print('No se puede')

    else:
        print('No existe ' + ID1 + ' o ' + ID2)
'''
valid_caminoID_calle_1ID_calle_2
———————–
elemento : string
calles : Lista
caminos : Lista
————————
Tiene la función de imprimir por pantalla si puede llegar ID_calle1 a ID_calle2 y una e las dos no existe se imprimira ue no existe ID1 o ID2.
'''

archivoInput = open('input.txt')

errores = open('errores.txt', 'w')

calles = []
caminos = []
IDs = []

for linea in archivoInput:
    separar = re.split(';', linea)
    #print(separar)
    for elemento in separar:

        if re.findall('^[(](.*?[:].*?)[)]$', elemento): #caminos (para caminos en caminos en caminos se debe hacer una funcion aparte
            caminocreado(elemento, calles, caminos, IDs)

        elif re.findall('^[^update](.*?[.].*?[.].*?)', elemento): #calles
            calles += [callecreada(elemento)]

        elif re.match('^print\s', elemento): #print_ID
            print_ID_calle(elemento, calles)

        elif re.match('print_all', elemento): #print_all
            print_all(calles)

        elif re.match('print_caminos\s', elemento):
            print_caminos_ID_calle(elemento, caminos, IDs)

        elif re.match('print_by_nombre\s', elemento):
            print_by_nombrenombre(elemento, calles)

        elif re.match('print_by_apellido\s', elemento):
            print_by_apellidoapellido(elemento, calles)

        elif re.match('print_by_rut\s', elemento):
            print_by_rutrut(elemento, calles)

        elif re.match('print_by_telefono\s', elemento):
            print_by_telefonotelefono(elemento, calles)

        elif re.match('update\s', elemento):
            update_ID_callecalle(elemento, calles, caminos)


        elif re.match('valid_camino\s', elemento):
            valid_caminoID_calle_1ID_calle_2(elemento, calles, caminos)

        else:
            errores.write(elemento + '\n')

#print(calles)
#print(caminos)
#print(IDs)


archivoInput.close()
errores.close()









