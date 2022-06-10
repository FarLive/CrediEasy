from msilib.schema import Error
import mysql.connector as sql

class DAO():

    def __init__(self):
        try:
            self.conexion = sql.connect(
                host = "localhost",
                port = "3306",
                user = "root",
                password = "root",
                db = "bank"
            )
            
            # self.conexion = sql.connect(
            #     host = input("Ingresae el nombre del host: "),
            #     port = input("Ingresa el nombre del puerto: "),
            #     user = input("Ingresa el nombre de usuario: "),
            #     password = input("Ingresa la contraseña: "),
            #     db = input("Nombre de la base de datos: ")
            # )
        except Error as ex:
            print("No se ha podido establecer la conexion: {0}".format(ex))

    def listarClientes(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM people ORDER BY id ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("No se ha podido establecer la conexion: {0}".format(ex))

    def listarUsuarios(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM users ORDER BY id ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("No se ha podido establecer la conexion: {0}".format(ex))

    def listarTarjetas(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM creditcards ORDER BY type ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("No se ha podido establecer la conexion: {0}".format(ex))

    # def registrarAdmin(self):
    #     if self.conexion.is_connected():
    #         try:
    #             cursor = self.conexion.cursor()
    #             cursor.execute("INSERT INTO users (username,email,password,id_role) VALUES ('Aria','guitarrasxli@live.com','12345',5)")
    #             #query1 = "INSERT INTO users (username) VALUES ('{1}')"
    #             #cursor.execute(query1.format(admin[0]))
    #             self.conexion.commit()

    #             print('¡Administrador registrado!\n')
    #             cursor.close()
    #         except Error as ex:
    #             print("No se ha podido establecer la conexion: {0}".format(ex))
                