
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

public class IntermediarioEstadoAcademicoDetallado extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_academico_detallado WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM estado_academico_detallado WHERE OIDEstadoAcademicoDetallado ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoAcademicoDetalladoAgente estadoAcademicoDetallado = (EstadoAcademicoDetalladoAgente) entidad;
        String sql = "INSERT INTO estado_academico_detallado (OIDEstadoAcademicoDetallado, fechaEstadoAcademicoDetallado, notaFinal, OIDEstadoMateria, OIDMateria, OIDEstadoAcademicoGeneral) VALUE ('"+estadoAcademicoDetallado.getOID()+"', '"+estadoAcademicoDetallado.getFechaEstado()+"', '"+estadoAcademicoDetallado.getNotaFinal()+"', '"+estadoAcademicoDetallado.getOIDEstadoMateria()+"', '"+estadoAcademicoDetallado.getOIDMateria()+"', '"+estadoAcademicoDetallado.getOIDEstadoAcademicoGeneral()+"');";
        
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoAcademicoDetalladoAgente estadoAcademicoDetallado = (EstadoAcademicoDetalladoAgente) entidad;
        String sql = "UPDATE estado_academico_detallado SET fechaEstadoAcademicoDetallado='"+estadoAcademicoDetallado.getFechaEstado()+"' , notaFinal='"+estadoAcademicoDetallado.getNotaFinal()+"' , OIDEstadoMateria='"+estadoAcademicoDetallado.getOIDEstadoMateria()+"' , OIDMateria='"+estadoAcademicoDetallado.getOIDMateria()+"' , OIDEstadoAcademicoGeneral='"+estadoAcademicoDetallado.getOIDEstadoAcademicoGeneral()+"' WHERE OIDEstadoAcademicoDetallado="+estadoAcademicoDetallado.getOID()+" ;";
        
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoAcademicoDetalladoAgente estadoAcademicoDetallado = (EstadoAcademicoDetalladoAgente) entidad;
        String sql = "DELETE FROM estado_academico_detallado WHERE OIDEstadoAcademicoDetallado="+estadoAcademicoDetallado.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                EstadoAcademicoDetalladoAgente agente = new EstadoAcademicoDetalladoAgente();
                EstadoAcademicoDetalladoImplementacion implementacion = new EstadoAcademicoDetalladoImplementacion();
                agente.setEstadoAcademicoDetallado(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoAcademicoDetallado"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setFechaEstado(rs.getDate("fechaEstadoAcademicoDetallado"));
                }
                catch(SQLException e){
                    agente.setFechaEstado(null);
                }
                try{
                    agente.setNotaFinal(rs.getFloat("notaFinal"));
                }
                catch(SQLException e){
                    agente.setNotaFinal(0);
                }
                try{
                    agente.setOIDEstadoMateria(rs.getString("OIDEstadoMateria"));
                }
                catch(SQLException e){
                    agente.setOIDEstadoMateria(null);
                }
                try{
                    agente.setOIDMateria(rs.getString("OIDMateria"));
                }
                catch(SQLException e){
                    agente.setOIDMateria(null);
                }
                try{
                    agente.setOIDEstadoAcademicoGeneral(rs.getString("OIDEstadoAcademicoGeneral"));
                }
                catch(SQLException e){
                    agente.setOIDEstadoAcademicoGeneral(null);
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
            case "OIDEstadoAcademicoGeneral" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDEstadoMateria":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDMateria":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
   
}

