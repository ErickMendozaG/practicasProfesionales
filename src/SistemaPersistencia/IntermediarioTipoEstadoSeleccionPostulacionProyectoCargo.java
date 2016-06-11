
package SistemaPersistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class IntermediarioTipoEstadoSeleccionPostulacionProyectoCargo extends IntermediarioRelacional{

   @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
       
       
        String sql = "SELECT * FROM tipo_estado_seleccion_postulacion_proyecto_cargo WHERE "+generarSQLCriterios(criterios.get(0));
        
        
        if(criterios.size()>1){
            
            
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+generarSQLCriterios(criterios.get(i));
            }
        }
        
        
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
       
        String sql = "SELECT * FROM tipo_estado_seleccion_postulacion_proyecto_cargo WHERE OIDTipoEstadoSeleccionPostulacionProyectoCargo ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        TipoEstadoSeleccionPostulacionProyectoCargoAgente tipEstSPPC = (TipoEstadoSeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "INSERT INTO tipo_estado_seleccion_postulacion_proyecto_cargo (OIDTipoEstadoSeleccionPostulacionProyectoCargo,nombreTipoEstadoSeleccionPostulacionProyectoCargo) VALUE ('"+tipEstSPPC.getOID()+"', '"+tipEstSPPC.getNombreTipoEstadoSeleccionPostulacionProyectoCargo()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        TipoEstadoSeleccionPostulacionProyectoCargoAgente tipEstSPPC = (TipoEstadoSeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "UPDATE tipo_estado_seleccion_postulacion_proyecto_cargo SET nombreTipoEstadoSeleccionPostulacionProyectoCargo='"+tipEstSPPC.getNombreTipoEstadoSeleccionPostulacionProyectoCargo()+"'  WHERE OIDTipoEstadoSeleccionPostulacionProyectoCargo="+tipEstSPPC.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        TipoEstadoSeleccionPostulacionProyectoCargoAgente tipEstSPPC = (TipoEstadoSeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "DELETE FROM tipo_estado_seleccion_postulacion_proyecto_cargo WHERE OIDTipoEstadoSeleccionPostulacionProyectoCargo="+tipEstSPPC.getOID()+" ;";
        return sql;
        
    }
    

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                TipoEstadoSeleccionPostulacionProyectoCargoAgente agente = new   TipoEstadoSeleccionPostulacionProyectoCargoAgente();
                TipoEstadoSeleccionPostulacionProyectoCargoImplementacion implementacion = new   TipoEstadoSeleccionPostulacionProyectoCargoImplementacion();
                agente.setTipoEstadoSeleccionPostulacionProyectoCargo(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDTipoEstadoSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroTipoEstadoSeleccionPostulacionProyectoCargo(rs.getInt("nroTipoEstadoSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setNroTipoEstadoSeleccionPostulacionProyectoCargo(0);
                }
                try{
                    agente.setNombreTipoEstadoSeleccionPostulacionProyectoCargo(rs.getString("nombreTipoEstadoSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setNombreTipoEstadoSeleccionPostulacionProyectoCargo(null);
                }
                
                    agente.setModificado(false);
                agente.setNuevo(false);
                resultados.add(agente);
            }
        } catch (SQLException ex) {
            System.out.println("Error en while de rs.next");
            
        }
        return resultados;
        
    }

    
    @Override
    protected Object convertirRegistroAObjetoOID(ResultSet rs) {       
      Vector v=this.convertirRegistroAObjeto(rs);
        return v.get(0);
        
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
