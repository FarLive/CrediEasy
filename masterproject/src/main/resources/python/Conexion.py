from msilib.schema import Error
import mysql.connector as sql

class DAO():

    def __init__(self):
        try:
            self.conexion = sql.connect(
                host = 'localhost',
                port = 3306,
                user = 'root',
                password = 'root',
                db = 'banconuevo'
            )
        except Error as ex:
            print("No se ha podido establecer la conexion: {0}".format(ex))

    def listarClientes(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM people ORDER BY name ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("No se ha podido establecer la conexion: {0}".format(ex))

    def listarUsuarios(self):
        if self.conexion.is_connected():
            try:
                cursor = self.conexion.cursor()
                cursor.execute("SELECT * FROM users ORDER BY username ASC")
                resultados = cursor.fetchall()
                return resultados
            except Error as ex:
                print("No se ha podido establecer la conexion: {0}".format(ex))

    def registrarAdmin(self,admin):
        if self.conexion.is_connected():
            try:
                cursor = self.cursor()
                query1 = "INSERT INTO roles (name) VALUES ('{1}')"
                cursor.execute(query1.format(admin[1]))
                
                # query2 = "INSERT INTO users (username, email, password, idRole) VALUES ('{0}', '{1}', '{2}', {3})"
                # cursor.execute(query2.format(admin[0], admin[1], admin[2], admin[3]))
                # self.conexion.commit()
                
            except:
                print('')
        