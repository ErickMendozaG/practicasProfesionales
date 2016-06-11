
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

public class IntermediarioContrato extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM contrato WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM contrato WHERE OIDContrato = "+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        ContratoAgente contrato = (ContratoAgente) entidad;
        String sql = "INSERT INTO contrato (OIDContrato, fechaCreacionContrato, horaCreacionContrato, fechaVigenciaHastaContrato, OIDProyecto, OIDPostulacionProyectoCargo, OIDPostulacion) VALUE ('"+contrato.getOID()+"', '"+contrato.getFechaCreacionContrato()+"', '"+contrato.getHoraCreacionContrato()+"', '"+contrato.getFechaVigenciaDeContrato()+"', '"+contrato.getOIDProyectoDeContrato()+"', '"+contrato.getOIDPostulacionProyectoCargoDeContrato()+"', '"+contrato.getOIDPostulacionDeContrato()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        ContratoAgente contrato = (ContratoAgente) entidad;
        String sql = "UPDATE contrato SET fechaCreacionContrato='"+contrato.getFechaCreacionContrato()+"' , horaCreacionContrato='"+contrato.getHoraCreacionContrato()+"' , fechaVigenciaHastaContrato='"+contrato.getFechaVigenciaDeContrato()+"' , OIDProyecto='"+contrato.getOIDProyectoDeContrato()+"' , OIDPostulacionProyectoCargo='"+contrato.getOIDPostulacionProyectoCargoDeContrato()+"' , OIDPostulacion='"+contrato.getOIDPostulacionDeContrato()+"' WHERE OIDContrato="+contrato.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        ContratoAgente contrato = (ContratoAgente) entidad;
        String sql = "DELETE FROM contrato WHERE OIDContrato="+contrato.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                ContratoAgente agente = new ContratoAgente();
                ContratoImplementacion implementacion = new ContratoImplementacion();
                agente.setContrato(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDContrato"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroContrato(rs.getInt("nroContrato"));
                }
                catch(SQLException e){
                    agente.setNroContrato(0);
                }
                try{
                    agente.setFechaCreacionContrato(rs.getDate("fechaCreacionContrato"));
                }
                catch(SQLException e){
                    agente.setFechaCreacionContrato(null);
                }
                try{
                    agente.setHoraCreacionContrato(rs.getTime("horaCreacionContrato"));
                }
                catch(SQLException e){
                    agente.setHoraCreacionContrato(null);
                }
                try{
                    agente.setFechaVigenciaDeContrato(rs.getDate("fechaVigenciaHastaContrato"));
                }
                catch(SQLException e){
                    agente.setFechaVigenciaDeContrato(null);
                }
                try{
                    agente.setOIDProyectoDeContrato(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDProyectoDeContrato(null);
                }
                try{
                    agente.setOIDPostulacionProyectoCargoDeContrato(rs.getString("OIDPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDPostulacionProyectoCargoDeContrato(null);
                }
                try{
                    agente.setOIDPostulacionDeContrato(rs.getString("OIDPostulacion"));
                }
                catch(SQLException e){
                    agente.setOIDPostulacionDeContrato(null);
                }
                agente.setModificado(false);
                agente.setNuevo(false);
                resultados.add(agente);
            }
        } catch (SQLException ex) {
            System.out.println("Error1");
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
            case "OIDProyecto" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDPostulacionProyectoCargo":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDPostulacion":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
