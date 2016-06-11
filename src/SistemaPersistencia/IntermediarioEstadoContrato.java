
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

public class IntermediarioEstadoContrato extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_contrato WHERE "+this.generarSQLCriterios(criterios.get(0))+" ";
        
        if(criterios.size()>1){
            
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+generarSQLCriterios(criterios.get(i))+" ";
            }
        }
        
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        String sql = "SELECT * FROM estado_contrato WHERE OIDEstadoContrato ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoContratoAgente estadoContrato = (EstadoContratoAgente) entidad;
        String sql = "INSERT INTO estado_contrato (OIDEstadoContrato, fechaCambioEstadoContrato, horaCambioEstadoContrato, OIDTipoEstadoContrato, OIDContrato) VALUE ('"+estadoContrato.getOID()+"', '"+estadoContrato.getFechaEstadoContrato()+"', '"+estadoContrato.getHoraEstadoContrato()+"', '"+estadoContrato.getOIDTipoEstadoContrato()+"', '"+estadoContrato.getOIDContrato()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoContratoAgente estadoContrato = (EstadoContratoAgente) entidad;
        String sql = "UPDATE estado_contrato SET fechaCambioEstadoContrato='"+estadoContrato.getFechaEstadoContrato()+"' , horaCambioEstadoContrato='"+estadoContrato.getHoraEstadoContrato()+"' , OIDTipoEstadoContrato='"+estadoContrato.getOIDTipoEstadoContrato()+"' , OIDContrato='"+estadoContrato.getOIDContrato()+"' WHERE OIDEstadoContrato="+estadoContrato.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoContratoAgente estadoContrato = (EstadoContratoAgente) entidad;
        String sql = "DELETE FROM estado_contrato WHERE OIDEstadoContrato="+estadoContrato.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                EstadoContratoAgente agente = new EstadoContratoAgente();
                EstadoContratoImplementacion implementacion = new EstadoContratoImplementacion();
                agente.setEstadocontrato(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setFechaEstadoContrato(rs.getDate("fechaCambioEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setFechaEstadoContrato(null);
                }
                try{
                    agente.setHoraEstadoContrato(rs.getTime("horaCambioEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setHoraEstadoContrato(null);
                }
                try{
                    agente.setOIDTipoEstadoContrato(rs.getString("OIDTipoEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setOIDTipoEstadoContrato(null);
                }
                try{
                    agente.setOIDContrato(rs.getString("OIDContrato"));
                }
                catch(SQLException e){
                    agente.setOIDContrato(null);
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
    protected Object convertirRegistroAObjetoOID(ResultSet rs){
       
        Vector v = this.convertirRegistroAObjeto(rs);
       
        return v.get(0);
    }
    
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            case "OIDContrato" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDTipoEstadoContrato":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}

