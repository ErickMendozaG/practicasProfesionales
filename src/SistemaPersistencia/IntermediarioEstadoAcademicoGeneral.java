
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

public class IntermediarioEstadoAcademicoGeneral extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_academico_general WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM estado_academico_general WHERE OIDEstadoAcademicoGeneral ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoAcademicoGeneralAgente estadoAcademicoGeneral = (EstadoAcademicoGeneralAgente) entidad;
        String sql = null;
        if(estadoAcademicoGeneral.getFechaBaja() == null){
            sql = "INSERT INTO estado_academico_general (OIDEstadoAcademicoGeneral, fechaIngreso, OIDCondicion, OIDCarrera, OIDPlanEstudio) VALUE ('"+estadoAcademicoGeneral.getOID()+"', '"+estadoAcademicoGeneral.getFechaIngreso()+"', '"+estadoAcademicoGeneral.getOIDcondicion()+"', '"+estadoAcademicoGeneral.getOIDcarrera()+"', '"+estadoAcademicoGeneral.getOIDplanEstudio()+"');";
        
        }
        else{
            sql = "INSERT INTO estado_academico_general (OIDEstadoAcademicoGeneral, fechaBaja, fechaIngreso, OIDCondicion, OIDCarrera, OIDPlanEstudio) VALUE ('"+estadoAcademicoGeneral.getOID()+"', '"+estadoAcademicoGeneral.getFechaBaja()+"', '"+estadoAcademicoGeneral.getFechaIngreso()+"', '"+estadoAcademicoGeneral.getOIDcondicion()+"', '"+estadoAcademicoGeneral.getOIDcarrera()+"', '"+estadoAcademicoGeneral.getOIDplanEstudio()+"');";
        }
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoAcademicoGeneralAgente estadoAcademicoGeneral = (EstadoAcademicoGeneralAgente) entidad;
        String sql = "UPDATE estado_academico_general SET fechaBaja='"+estadoAcademicoGeneral.getFechaBaja()+"' , fechaIngreso='"+estadoAcademicoGeneral.getFechaIngreso()+"' , OIDCondicion='"+estadoAcademicoGeneral.getOIDcondicion()+"' , OIDCarrera='"+estadoAcademicoGeneral.getOIDcarrera()+"' , OIDPlanEstudio='"+estadoAcademicoGeneral.getOIDplanEstudio()+"'  WHERE OIDEstadoAcademicoGeneral="+estadoAcademicoGeneral.getOID()+" ;";
        
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoAcademicoGeneralAgente estadoAcademicoGeneral = (EstadoAcademicoGeneralAgente) entidad;
        String sql = "DELETE FROM estado_academico_general WHERE OIDEstadoAcademicoGeneral="+estadoAcademicoGeneral.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                EstadoAcademicoGeneralAgente agente = new EstadoAcademicoGeneralAgente();
                EstadoAcademicoGeneralImplementacion implementacion = new EstadoAcademicoGeneralImplementacion();
                agente.setEstadoAcademicoGeneral(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoAcademicoGeneral"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setFechaBaja(rs.getDate("fechaBaja"));
                }
                catch(SQLException e){
                    agente.setFechaBaja(null);
                }
                try{
                    agente.setFechaIngreso(rs.getDate("fechaIngreso"));
                }
                catch(SQLException e){
                    agente.setFechaIngreso(null);
                }
                try{
                    agente.setOIDcondicion(rs.getString("OIDCondicion"));
                }
                catch(SQLException e){
                    agente.setOIDcondicion(null);
                }
                try{
                    agente.setOIDcarrera(rs.getString("OIDCarrera"));
                }
                catch(SQLException e){
                    agente.setOIDcarrera(null);
                }
                try{
                    agente.setOIDplanEstudio(rs.getString("OIDPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setOIDplanEstudio(null);
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
            case "OIDCondicion" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDCarrera":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDPlanEstudio":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
   
}


