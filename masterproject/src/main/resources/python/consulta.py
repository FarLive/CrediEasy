# -*- coding: utf-8 -*-

import mysql.connector
import os

#Conexión con el servidor MySQL Server
conexionMySQL = mysql.connector.connect(
    host='localhost',
    user='root',
    passwd='root',
    db='banco'
)

def consultas(ruta):
    
    sqlSelect = f"""SELECT * FROM clientes"""
           
#Establecemos un cursor para la conexión con el servidor MySQL
    cursor = conexionMySQL.cursor()
#A partir del cursor, ejecutamos la consulta SQL
    cursor.execute(sqlSelect)
#Guardamos el resultado de la consulta en una variable
    resultadoSQL = cursor.fetchall()

#Cerramos el cursor y la conexión con MySQL
    cursor.close()
    conexionMySQL.close()

    x = 0
    resultadoString = '\n'.join(str(x) for x  in resultadoSQL)

    print(type(resultadoString))
    print(resultadoString)

    file = open(ruta + "\consultas.txt", "w")
    file.write(resultadoString)
    file.close()
        
    #Mostramos el resultado por pantalla
    #print(resultadoSQL)

#consultas("C:\\Users\\FarLive\\Desktop")