
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

public class IntermediarioPostulacion extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM postulacion WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM postulacion WHERE OIDPostulacion ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        PostulacionAgente postulacion = (PostulacionAgente) entidad;
        String sql;
        if(postulacion.getfechaAnulacionPostulacion() == null){
            sql = "INSERT INTO postulacion (OIDPostulacion, fechaPostulacion, horaPostulacion, OIDEstudiante, OIDEstadoAcademicoGeneral) VALUE ('"+postulacion.getOID()+"', '"+postulacion.getfechaPostulacion()+"', '"+postulacion.gethoraPostulacion()+"', '"+postulacion.getOIDEstudiante()+"', '"+postulacion.getOIDEstadoAcademicoGeneral()+"');";
        }
        else{
            sql = "INSERT INTO postulacion (OIDPostulacion, fechaPostulacion, horaPostulacion, fechaAnulacionPostulacion, OIDEstudiante, OIDEstadoAcademicoGeneral) VALUE ('"+postulacion.getOID()+"', '"+postulacion.getfechaPostulacion()+"', '"+postulacion.gethoraPostulacion()+"', '"+postulacion.getfechaAnulacionPostulacion()+"', '"+postulacion.getOIDEstudiante()+"', '"+postulacion.getOIDEstadoAcademicoGeneral()+"');";
        }
        System.out.println(sql);
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        PostulacionAgente postulacion = (PostulacionAgente) entidad;
        String sql = "UPDATE postulacion SET fechaPostulacion='"+postulacion.getfechaPostulacion()+"' , horaPostulacion='"+postulacion.gethoraPostulacion()+"' , fechaAnulacionPostulacion='"+postulacion.getfechaAnulacionPostulacion()+"' , OIDEstudiante='"+postulacion.getOIDEstudiante()+"', OIDEstadoAcademicoGeneral='"+postulacion.getOIDEstadoAcademicoGeneral()+"' WHERE OIDPostulacion="+postulacion.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        PostulacionAgente postulacion = (PostulacionAgente) entidad;
        String sql = "DELETE FROM postulacion WHERE OIDPostulacion="+postulacion.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                PostulacionAgente agente = new PostulacionAgente();
                PostulacionImplementacion implementacion = new PostulacionImplementacion();
                agente.setPostulacion(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDPostulacion"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setnroPostulacion(rs.getInt("nroPostulacion"));
                }
                catch(SQLException e){
                    agente.setnroPostulacion(0);
                }
                try{
                    agente.setfechaPostulacion(rs.getDate("fechaPostulacion"));
                }
                catch(SQLException e){
                    agente.setfechaPostulacion(null);
                }
                try{
                    agente.sethoraPostulacion(rs.getTime("horaPostulacion"));
                }
                catch(SQLException e){
                    agente.sethoraPostulacion(null);
                }
                try{
                    agente.setfechaAnulacionPostulacion(rs.getDate("fechaAnulacionPostulacion"));
                }
                catch(SQLException e){
                    agente.setfechaAnulacionPostulacion(null);
                }
                try{
                    agente.setOIDEstudiante(rs.getString("OIDEstudiante"));
                }
                catch(SQLException e){
                    agente.setOIDEstudiante(null);
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
    protected Object convertirRegistroAObjetoOID(ResultSet rs) {
        
        Vector v = this.convertirRegistroAObjeto(rs);
        
        return v.get(0);
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            case "OIDEstudiante" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDEstadoAcademicoGeneral":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "Estudiante":
                Agente ag = (Agente)criterio.getValor();
                sqlCriterio = "OIDEstudiante"+criterio.getOperador()+ag.getOID()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}