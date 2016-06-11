
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

public class IntermediarioEstadoProyecto extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_proyecto WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM estado_proyecto WHERE OIDEstadoProyecto ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoProyectoAgente estadoProyecto = (EstadoProyectoAgente) entidad;
        String sql = "INSERT INTO estado_proyecto (OIDEstadoProyecto, fechaCambioEstadoProyecto, horaCambioEstadoProyecto, OIDTipoEstadoProyecto, OIDProyecto) VALUE ('"+estadoProyecto.getOID()+"', '"+estadoProyecto.getFechaEstadoProyecto()+"', '"+estadoProyecto.getHoraEstadoProyecto()+"', '"+estadoProyecto.getOIDTipoEstadoProyecto()+"', '"+estadoProyecto.getOIDProyecto()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoProyectoAgente estadoProyecto = (EstadoProyectoAgente) entidad;
        String sql = "UPDATE estado_proyecto SET fechaCambioEstadoProyecto='"+estadoProyecto.getFechaEstadoProyecto()+"' , horaCambioEstadoProyecto='"+estadoProyecto.getHoraEstadoProyecto()+"' , OIDTipoEstadoProyecto='"+estadoProyecto.getOIDTipoEstadoProyecto()+"' , OIDProyecto='"+estadoProyecto.getOIDProyecto()+"'  WHERE OIDEstadoProyecto="+estadoProyecto.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoProyectoAgente estadoProyecto = (EstadoProyectoAgente) entidad;
        String sql = "DELETE FROM estado_proyecto WHERE OIDEstadoProyecto="+estadoProyecto.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                EstadoProyectoAgente agente = new EstadoProyectoAgente();
                EstadoProyectoImplementacion implementacion = new EstadoProyectoImplementacion();
                agente.setEstadoProyecto(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setFechaEstadoProyecto(rs.getDate("fechaCambioEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setFechaEstadoProyecto(null);
                }
                try{
                    agente.setHoraEstadoProyecto(rs.getTime("horaCambioEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setHoraEstadoProyecto(null);
                }
                try{
                    agente.setOIDTipoEstadoProyecto(rs.getString("OIDTipoEstadoProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDTipoEstadoProyecto(null);
                }
                try{
                    agente.setOIDProyecto(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDProyecto(null);
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
        
        Vector v = this.convertirRegistroAObjeto(rs);
        
        return v.get(0);
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            case "OIDProyecto" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDTipoEstadoProyecto":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}