
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

public class IntermediarioPostulacionProyectoCargo extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM postulacion_proyecto_cargo WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM postulacion_proyecto_cargo WHERE OIDPostulacionProyectoCargo ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        PostulacionProyectoCargoAgente postulacionProyectoCargo = (PostulacionProyectoCargoAgente) entidad;
        
        String sql = "INSERT INTO postulacion_proyecto_cargo (OIDPostulacionProyectoCargo, prioridad, OIDProyecto, OIDProyectoCargo, OIDPostulacion) VALUE ('"+postulacionProyectoCargo.getOID()+"', '"+postulacionProyectoCargo.getPrioridad()+"', '"+postulacionProyectoCargo.getOIDProyecto()+"', '"+postulacionProyectoCargo.getOIDProyectoCargo()+"', '"+postulacionProyectoCargo.getOIDPostulacion()+"');";
        System.out.println(sql);
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        PostulacionProyectoCargoAgente postulacionProyectoCargo = (PostulacionProyectoCargoAgente) entidad;
        String sql = "UPDATE postulacion_proyecto_cargo SET prioridad='"+postulacionProyectoCargo.getPrioridad()+"' , OIDProyecto='"+postulacionProyectoCargo.getOIDProyecto()+"' , OIDProyectoCargo='"+postulacionProyectoCargo.getOIDProyectoCargo()+"' , OIDPostulacion='"+postulacionProyectoCargo.getOIDPostulacion()+"' WHERE OIDPostulacionProyectoCargo="+postulacionProyectoCargo.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        PostulacionProyectoCargoAgente postulacionProyectoCargo = (PostulacionProyectoCargoAgente) entidad;
        String sql = "DELETE FROM postulacion_proyecto_cargo WHERE OIDPostulacionProyectoCargo="+postulacionProyectoCargo.getOID()+" ;";
        System.out.println(sql);
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                PostulacionProyectoCargoAgente agente = new PostulacionProyectoCargoAgente();
                PostulacionProyectoCargoImplementacion implementacion = new PostulacionProyectoCargoImplementacion();
                agente.setPostProyCargo(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setprioridad(rs.getInt("prioridad"));
                }
                catch(SQLException e){
                    agente.setprioridad(0);
                }
                try{
                    agente.setOIDProyecto(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDProyecto(null);
                }
                try{
                    agente.setOIDProyectoCargo(rs.getString("OIDProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDProyectoCargo(null);
                }
                try{
                    agente.setOIDPostulacion(rs.getString("OIDPostulacion"));
                }
                catch(SQLException e){
                    agente.setOIDPostulacion(null);
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
            case "OIDPostulacion":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDProyectoCargo":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}