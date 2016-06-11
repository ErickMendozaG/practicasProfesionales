
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

public class IntermediarioTipoEstadoContrato extends IntermediarioRelacional{

   @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
       
        String sql = "SELECT * FROM tipo_estado_contrato WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        String sql = "SELECT * FROM tipo_estado_contrato WHERE OIDTipoEstadoContrato ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        TipoEstadoContratoAgente tipEstContrato = (TipoEstadoContratoAgente) entidad;
        String sql = "INSERT INTO tipo_estado_contrato (OIDTipoEstadoContrato, nombreTipoEstadoContrato) VALUE ('"+tipEstContrato.getOID()+"', '"+tipEstContrato.getNombreTipoEstadoContrato()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        TipoEstadoContratoAgente tipEstContrato = (TipoEstadoContratoAgente) entidad;
        String sql = "UPDATE tipo_estado_contrato SET nombreTipoEstadoContrato='"+tipEstContrato.getNombreTipoEstadoContrato()+"' WHERE OIDTipoEstadoContrato="+tipEstContrato.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        TipoEstadoContratoAgente tipEstContrato = (TipoEstadoContratoAgente) entidad;
        String sql = "DELETE FROM tipo_estado_contrato WHERE OIDTipoEstadoContrato="+tipEstContrato.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                TipoEstadoContratoAgente agente = new  TipoEstadoContratoAgente();
                TipoEstadoContratoImplementacion implementacion = new TipoEstadoContratoImplementacion();
                agente.setTipoEstadoContrato(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDTipoEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNombreTipoEstadoContrato(rs.getString("nombreTipoEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setNombreTipoEstadoContrato(null);
                }
                try{
                    agente.setNroTipoEstadoContrato(rs.getInt("nroTipoEstadoContrato"));
                }
                catch(SQLException e){
                    agente.setNroTipoEstadoContrato(0);
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
