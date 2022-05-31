#include <iostream>
#include <mysql.h>
int q_estado;

using namespace std;

int main()
{
    MYSQL* conectar;
    MYSQL_ROW fila;
    MYSQL_RES* resultado;

    const string user = "root";
    string pass = "root";

    if (strcmp(pass,"root") = "root") {
        cout << "No es posible la conexion";
    }
    else {
        cout << "bienvenido" << endl;
    }
    
    conectar = mysql_init(0);
    conectar = mysql_real_connect(conectar,"localhost","root","root","banco",3306,NULL,0);

    if (conectar) {
        cout << "Conexion exitosa..." << endl;

        cout << "\t\t\tBienvenido a la vista de administrador" << endl;
        cout << "\t\t\t--------------------------------------" << endl;
        

        /*string consulta = "select * from clientes";
        const char* c = consulta.c_str();
        q_estado = mysql_query(conectar, c);
        
        if (!q_estado) {
            resultado = mysql_store_result(conectar);
            while (fila = mysql_fetch_row(resultado)) {
                cout << fila[0] << ", " << fila[1] << ", " << fila[2] << ", " << fila[3] << ", " << fila[4] << ", " << fila[5] << ", " << fila[6] << endl;
            }
        }
        else {
            cout << "xxx Error al consultar xxx" << endl;
        }*/
    }
    else {
        cout << "Error en la conexion..." << endl;
    }



    system("pause");
}