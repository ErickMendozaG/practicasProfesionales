
package SistemaPersistencia;

import java.sql.*;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public abstract class IntermediarioRelacional extends Intermediario{

    /*Variables Globales*/
    
    private ResultSet rs;
    private String sql;
    
    /*Métodos Implementados*/
    /*matrializar: es la búsqueda a la BD*/
    @Override
    protected Vector materializar(Vector<Criterio> criterios) {
        
        sql=generarSQLBuscar(criterios);
        try {
            rs = Conexion.getInstancia().obtenerConexion().createStatement().executeQuery(sql);
        } catch (SQLException ex) {
            rs=null;
        }
        
        Vector vector = convertirRegistroAObjeto(rs);
        return vector;
        
    }
    
    @Override
    protected Object materializar(String oid) {
        
        sql=generarSQLBuscar(oid);
        try {
            rs = Conexion.getInstancia().obtenerConexion().createStatement().executeQuery(sql);
        } catch (SQLException ex) {
            rs=null;
        }
        
        Object o = convertirRegistroAObjetoOID(rs);
        
        return o;
        
    }
    
    /*desmaterializar: guarda una entidad */
    @Override
    protected void desmaterializar(Object entidad) {
        
        Agente agente = (Agente) entidad;
        if(agente.isNuevo() == true){
            
            desmaterializarNuevo(entidad);
        }
        else {
            if(agente.isModificado() == false){
            /* No hace nada --->
             * Entidad Ya Buscada y depositada en Caché
             * Entidad no modificada, no se guarda nada
             */
            }
            else{
                desmaterializarActualizar(entidad);
            }
        }
    }
    
    /*desmaterializarActualizar: guarda los datos en un registro nuevo en la BD */    
    
    protected void desmaterializarNuevo(Object entidad){
        
        sql=generarSQLGuardar(entidad);
        try {
            Conexion.getInstancia().obtenerConexion().createStatement().execute(sql);
        } catch (SQLException ex) {
            System.out.println("Error en conexión a la BD: No se pudo guardar un nuevo registro");
        }
    }
    
    /* desmaterializarActualizar: actualiza los datos de un registro existente en la BD */
    protected void desmaterializarActualizar(Object entidad) {
        
        sql=generarSQLActualizar(entidad);
        try {
            Conexion.getInstancia().obtenerConexion().createStatement().execute(sql);
        } catch (SQLException ex) {
            System.out.println("Error en conexión a la BD: No se pudo actualizar registro");
        }
        
    }
    
    /*desmaterializarEliminar: elimina un registro en la BD*/
        @Override
    protected void desmaterializarEliminar(Object entidad){
        
        sql=generarSQLEliminar(entidad);
        try {
            Conexion.getInstancia().obtenerConexion().createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error en conexión a la BD: No se pudo eliminar registro");
        }
    }
    
    protected abstract String generarSQLBuscar(Vector<Criterio> criterios);
    protected abstract String generarSQLBuscar(String oid);
    protected abstract Vector convertirRegistroAObjeto(ResultSet rs);
    protected abstract Object convertirRegistroAObjetoOID(ResultSet rs);
    protected abstract String generarSQLGuardar(Object entidad);
    protected abstract String generarSQLActualizar(Object entidad);
    protected abstract String generarSQLEliminar(Object entidad);
         
}
