import re

def callecreada(elemento):
    if len(re.findall('[.]', elemento)) < 2:
        errores.write(elemento + '\n')
    nombre_calle, ID_calle, persona = re.split('[.]', elemento)
    if len(re.findall('_', persona)) < 2:
        errores.write(elemento + '\n')
    nombre_persona, apellido_persona, telefono, rut = re.split('_', persona)
    if re.findall('^[^A-ZÁÉÍÓÚ]', nombre_calle):
        errores.write(elemento + '\n')
    elif re.findall('([^#][A-Z]{2}[0-9]{2})', ID_calle):
        errores.write(elemento + '\n')
    elif re.findall('([#][^A-Z]{2}[0-9]{2})', ID_calle):
        errores.write(elemento + '\n')
    elif re.findall('([#][A-Z]{2}[^0-9]{2})', ID_calle):
        errores.write(elemento + '\n')
    elif re.findall('(^[^A-Z])', nombre_persona):
        errores.write(elemento + '\n')
    elif re.findall('^[^A-Z]', apellido_persona):
        errores.write(elemento + '\n')
    elif re.findall('([^+][1-9][0-9]{5})', telefono):
        errores.write(elemento + '\n')
    elif re.findall('([+][0][0-9]{5})', telefono):
        errores.write(elemento + '\n')
    elif re.findall('([+][1-9][0-9]{0,4}$)', telefono):
        errores.write(elemento + '\n')
    elif re.findall('([+][1-9][0-9]{6,})', telefono):
        errores.write(elemento + '\n')
    elif re.findall('([0][0-9]*?[-][0-9Kk])', rut):
        errores.write(elemento + '\n')
    elif re.findall('([^-][0-9Kk])$', rut):
        errores.write(elemento + '\n')
    elif re.findall('([1-9][0-9]*?[-][^0-9Kk])', rut):
        errores.write(elemento + '\n')
    else:
        return elemento

def camino(elemento):
    si : 10

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

def print_caminos_ID_calle(elemento, caminos): #no supe como convertirlo en función
    IDEncontrado = re.search('(#[A-Z]{2}[0-9]{2})$', elemento)
    ID = elemento[IDEncontrado.start():]
    if re.findall('(#[A-Z]{2}[0-9]{2})$', elemento):
        print('CAMINOS DESDE ' + ID + ':')
        caminosmalos = []
        for camino in caminos:
            camino = camino[1:len(camino) - 1]
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
        print('No existe con ' + ID1 + ' o ' + ID2)


archivoInput = open('input.txt')

errores = open('errores.txt', 'w')

calles = []
caminos = []
IDs = []

for linea in archivoInput:
    separar = re.split(';', linea)
    print(separar)
    for elemento in separar:

        if re.findall('^[(](.*?[:].*?)[)]$', elemento): #caminos (para caminos en caminos en caminos se debe hacer una funcion aparte
            camino_actual = elemento
            caminos += [elemento]
            camino_actual = camino_actual[1:len(camino_actual) - 1] #para sacar los parentesis de los extremos
            separar_camino = re.split(':', camino_actual)
            for elemento2 in separar_camino:
                if re.findall('(.*?[.].*?[.].*?)', elemento2):
                    calles += [callecreada(elemento2)]

                elif re.findall('(#[A-Z]{2}[0-9]{2})$', elemento2):
                        IDs += [elemento2]



        elif re.findall('^[^update](.*?[.].*?[.].*?)', elemento): #calles
            calles += [callecreada(elemento)]

        elif re.match('^print\s', elemento): #print_ID
            print_ID_calle(elemento, calles)

        elif re.match('print_all', elemento): #print_all
            print_all(calles)

        elif re.match('print_caminos\s', elemento):
            print_caminos_ID_calle(elemento, caminos)

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
            errores.write(elemento)

print(calles)
print(caminos)
print(IDs)


archivoInput.close()
errores.close()