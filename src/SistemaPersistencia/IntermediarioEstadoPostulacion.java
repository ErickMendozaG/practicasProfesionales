
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

public class IntermediarioEstadoPostulacion extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_postulacion WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM estado_postulacion WHERE OIDEstadoPostulacion ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoPostulacionAgente estadoPostulacion = (EstadoPostulacionAgente) entidad;
        String sql = "INSERT INTO estado_postulacion (OIDEstadoPostulacion, fechaEstadoPostulacion, horaEstadoPostulacion, OIDTipoEstadoPostulacion, OIDPostulacionProyectoCargo) VALUE ('"+estadoPostulacion.getOID()+"', '"+estadoPostulacion.getFechaEstadoPostulacion()+"', '"+estadoPostulacion.getHoraEstadoPostulacion()+"', '"+estadoPostulacion.getOIDTipoEstadoPostulacion()+"', '"+estadoPostulacion.getOIDPostulacionProyectoCargo()+"');";
        System.out.println(sql);
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoPostulacionAgente estadoPostulacion = (EstadoPostulacionAgente) entidad;
        String sql = "UPDATE estado_postulacion SET fechaEstadoPostulacion='"+estadoPostulacion.getFechaEstadoPostulacion()+"' , horaEstadoPostulacion='"+estadoPostulacion.getHoraEstadoPostulacion()+"' , OIDTipoEstadoPostulacion='"+estadoPostulacion.getOIDTipoEstadoPostulacion()+"' , OIDPostulacionProyectoCargo='"+estadoPostulacion.getOIDPostulacionProyectoCargo()+"' WHERE OIDEstadoPostulacion="+estadoPostulacion.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoPostulacionAgente estadoPostulacion = (EstadoPostulacionAgente) entidad;
        String sql = "DELETE FROM estado_postulacion WHERE OIDEstadoPostulacion="+estadoPostulacion.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                EstadoPostulacionAgente agente = new EstadoPostulacionAgente();
                EstadoPostulacionImplementacion implementacion = new EstadoPostulacionImplementacion();
                agente.setEstadopostulacion(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoPostulacion"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setFechaEstadoPostulacion(rs.getDate("fechaEstadoPostulacion"));
                }
                catch(SQLException e){
                    agente.setFechaEstadoPostulacion(null);
                }
                try{
                    agente.setHoraEstadoPostulacion(rs.getTime("horaEstadoPostulacion"));
                }
                catch(SQLException e){
                    agente.setHoraEstadoPostulacion(null);
                }
                try{
                    agente.setOIDTipoEstadoPostulacion(rs.getString("OIDTipoEstadoPostulacion"));
                }
                catch(SQLException e){
                    agente.setOIDTipoEstadoPostulacion(null);
                }
                try{
                    agente.setOIDPostulacionProyectoCargo(rs.getString("OIDPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDPostulacionProyectoCargo(null);
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
        
        Vector v = convertirRegistroAObjeto(rs);
        
        return v.get(0);
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            case "OIDPostulacionProyectoCargo" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDTipoEstadoPostulacion":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}