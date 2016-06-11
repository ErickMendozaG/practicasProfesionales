
package SistemaPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public  class Conexion {
    private final String url = "jdbc:mysql://";
    private final String servidor = "localhost" ;
    private final String db = "practicasprofesionales";
    private final String usuario = "root";
    private final String clave = "root";
    private final String driver = "com.mysql.jdbc.Driver";
    
    
    private static Conexion conexion = new Conexion();
    private Connection conn= null;
    
    private Conexion(){}
    public static Conexion getInstancia(){
        return conexion;
    }
   
    private void conectar(){
        
        if(conn == null){
            try{
                Class.forName(driver);
                conn= DriverManager.getConnection(url + servidor + "/" + db , usuario, clave);
                System.out.println("La BD está conectada satisfactoriamente");
                conn.setAutoCommit(false);
                
            }
            catch(SQLException e){
                System.out.println("Error en conexión a la BD: No se pudo conectar");
                
            }
            catch (ClassNotFoundException ex) {
                System.out.println("Falta una clase");
                
            }
        } 
    }
    
    public void iniciarTransaccion() throws SQLException{
        conectar();
        conn.createStatement().execute("BEGIN;");
        System.out.println("Inicia Transacción");
        
    }
    
    public void confirmarTransaccion() throws SQLException{        
        conn.createStatement().execute("COMMIT;");  
        System.out.println("COnfirma Transacción");
    }
    
    public void deshacerTransaccion() throws SQLException{
        conn.createStatement().execute("ROLLBACK;");
        System.out.println("Deshace Transacción");
    }
    
    private void desconectar(){
        
        try{
            conn.close();
            conn=null;
        }
        catch(SQLException e){
            System.out.println("Error en conexión a la BD: No se pudo desconectar");
        }
        
    }
    
    public Connection obtenerConexion() throws SQLException{
        conectar();
        return this.conn;
    }
    
    public void finalizarTransaccion(){
        
        desconectar();
        System.out.println("Finaliza Transacción");
    }
    
}

