from Conexion import DAO
import Funciones

def menuPrincipal():

    continuar = True
    while(continuar):
        opcionCorrecta = False
        while(not opcionCorrecta):
            print(">>>>>>>> MENU PRINCIPAL <<<<<<<<")
            print('1.- Listar clientes')
            print('2.- Listar usuarios')
            print('3.- Listar tarjetas')
            print('4.- Registrar administradores')
            print('5.- Salir')
            opcion = int(input("Selecciona una opcion:  "))

            if opcion < 1 or opcion > 5:
                print("Opcion incorreta, ingresa nuevamente...")
            elif opcion == 5:
                continuar = False
                print('¡Gracias por usar este sistema!')
                break
            else:
                opcionCorrecta = True
                ejecutarOpcion(opcion)

def ejecutarOpcion(opcion):
    dao = DAO()

    if opcion == 1:
        try:
            clientes = dao.listarClientes()
            if len(clientes) > 0:
                Funciones.listarClientes(clientes)
            else:
                print('No se encontraron clientes...')
        except:
            print('Ha ocurrido un error...')

    elif opcion == 2:
        try:
            usuarios = dao.listarUsuarios()
            if len(usuarios) > 0:
                Funciones.listarUsuarios(usuarios)
            else:
                print('No se encontraron usuarios...')
        except:
            print('Ha ocurrido un error...')
    
    elif opcion == 3:
        print("Tarjetas")
        
    elif opcion == 4:
        admin = Funciones.datosAdmin()
        
        try:
            dao.registrarAdmin(admin)
        except:
            print('Ha ocurrido un error...')
    else:
        print("Opcion no valida")

menuPrincipal()