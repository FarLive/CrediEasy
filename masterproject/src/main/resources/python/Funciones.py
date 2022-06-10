def listarClientes(clientes):
    print('\nClientes: \n')
    for customer in clientes:
        datos = "{0}. ID User: {4} | Nombre: {1} | Direccion: {2} | Telefono: {3}"
        print(datos.format(customer[0],customer[1],customer[2],customer[3],customer[4]))

    print("")

def listarUsuarios(usuarios):
    print('\nUsuarios: \n')
    for users in usuarios:
        datos = "{0}. ID Role: {4} | Usuario: {1} | Correo: {2} | Contraseña: {3}"
        print(datos.format(users[0],users[1],users[2],users[3],users[4]))

    print("")

def listarTarjetas(tarjetas):
    print('\nTarjetas: \n')
    for creditcards in tarjetas:
        datos = "{0}. ID Customer: {5} | Tipo: {1} | Numero de Tarjeta: {2} | Fecha de expiracion: {3} | Codigo de seguridad: {4}"
        print(datos.format(creditcards[0],creditcards[1],creditcards[2],creditcards[3],creditcards[4],creditcards[5]))

    print("")

# def datosAdmin():
    
#     usuario = input("Ingresa el nombre de usuario: ")
#     #contraseña = input("Ingresa la contraseña: ")
#     #correo = input("Ingresa el correo: ")
#     #people = 

#     return usuario