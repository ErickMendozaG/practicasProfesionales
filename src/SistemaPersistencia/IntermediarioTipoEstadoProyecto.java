
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

public class IntermediarioTipoEstadoProyecto extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
       
        String sql = "SELECT * FROM tipo_estado_proyecto WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        String sql = "SELECT * FROM tipo_estado_proyecto WHERE OIDTipoEstadoProyecto ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        TipoEstadoProyectoAgente tipEstProy = (TipoEstadoProyectoAgente) entidad;
        String sql = "INSERT INTO tipo_estado_proyecto (OIDTipoEstadoProyecto, nombreTipoEstadoProyecto) VALUE ('"+tipEstProy.getOID()+"', '"+tipEstProy.getNombreTipoEstadoProyecto()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        TipoEstadoProyectoAgente tipEstProy = (TipoEstadoProyectoAgente) entidad;
        String sql = "UPDATE tipo_estado_proyecto SET nombreTipoEstadoProyecto='"+tipEstProy.getNombreTipoEstadoProyecto()+"' WHERE OIDTipoEstadoProyecto="+tipEstProy.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        TipoEstadoProyectoAgente tipEstProy = (TipoEstadoProyectoAgente) entidad;
        String sql = "DELETE FROM tipo_estado_proyecto WHERE OIDTipoEstadoProyecto="+tipEstProy.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                TipoEstadoProyectoAgente agente = new  TipoEstadoProyectoAgente();
                TipoEstadoProyectoImplementacion implementacion = new TipoEstadoProyectoImplementacion();
                agente.setTipoEstadoProyecto(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDTipoEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNombreTipoEstadoProyecto(rs.getString("nombreTipoEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setNombreTipoEstadoProyecto(null);
                }
                try{
                    agente.setNroTipoEstadoProyecto(rs.getInt("nroTipoEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setNroTipoEstadoProyecto(0);
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
