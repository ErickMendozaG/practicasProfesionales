
package SistemaPersistencia;

import java.sql.SQLException;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class FachadaPersistenciaInterna {
    
    /* <<Singleton>> */
    
    private static FachadaPersistenciaInterna instancia= new FachadaPersistenciaInterna();
    
    private FachadaPersistenciaInterna(){}
    
    public static FachadaPersistenciaInterna getInstancia(){
        return instancia;
    }
    
    /* Servicios internos del Sistema de Persistencia*/
    
    public Vector buscar(String nombreEntidad, Vector<Criterio> criterios){
        
        return FabricaIntermediarios.getInstancia().obtenerIntermediario(nombreEntidad).buscar(criterios);
        
    }
    
    public Object buscar(String nombreEntidad, String oid){
        
        return FabricaIntermediarios.getInstancia().obtenerIntermediario(nombreEntidad).buscar(oid);
               
    }
    
    public void guardar(String nombreEntidad, Object entidad){
        
        FabricaIntermediarios.getInstancia().obtenerIntermediario(nombreEntidad).guardar(entidad);
        
    }
    
    public void eliminar(String nombreEntidad, Object entidad){
        
        FabricaIntermediarios.getInstancia().obtenerIntermediario(nombreEntidad).eliminar(entidad);
        
    }
    
    /* Servicios de Transacciones */
    /* Aún por ver la implementacion de los métodos */
    
    public void iniciarTransaccion() throws SQLException{
        Conexion.getInstancia().iniciarTransaccion();
    }
    
    public void finalizarTransaccion(){
        Conexion.getInstancia().finalizarTransaccion();
    }
    
    public void confirmarTransaccion() throws SQLException{
        Conexion.getInstancia().confirmarTransaccion();
    }
    
    public void deshacerTransaccion() throws SQLException{
        Conexion.getInstancia().deshacerTransaccion();
    }
}
