
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

public class IntermediarioProyectoCargo extends IntermediarioRelacional{
    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM proyecto_cargo WHERE "+generarSQLCriterios(criterios.get(0));
        
        
        if(criterios.size()>1){
            
            
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+generarSQLCriterios(criterios.get(0));
            }
        }
        
       
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        
        String sql = "SELECT * FROM proyecto_cargo WHERE OIDProyectoCargo ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        ProyectoCargoAgente proyCago = (ProyectoCargoAgente) entidad;
        String sql = "INSERT INTO proyecto_cargo (OIDProyectoCargo, horasEstimadas, cantidadPuestos, cantidadLimitePostulaciones, OIDProyecto,  OIDCargo) VALUE ('"+proyCago.getOID()+"', '"+proyCago.getHorasEstimadas()+"', '"+proyCago.getCantPuestos()+"', '"+proyCago.getCdadLimPost()+"', '"+proyCago.getOIDProyecto()+"', '"+proyCago.getOIDCargo()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        ProyectoCargoAgente proyCago = (ProyectoCargoAgente) entidad;
        String sql = "UPDATE proyecto_cargo SET horasEstimadas='"+proyCago.getHorasEstimadas()+"' , cantidadPuestos='"+proyCago.getCantPuestos()+"' , cantidadLimitePostulaciones='"+proyCago.getCdadLimPost()+"' , OIDProyecto='"+proyCago.getOIDProyecto()+"' , OIDCargo='"+proyCago.getOIDCargo()+"' WHERE OIDProyectoCargo="+proyCago.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        ProyectoCargoAgente proyCago = (ProyectoCargoAgente) entidad;
        String sql = "DELETE FROM proyecto_cargo WHERE OIDProyectoCargo="+proyCago.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                ProyectoCargoAgente agente = new ProyectoCargoAgente();
                ProyectoCargoImplementacion implementacion = new ProyectoCargoImplementacion();
                agente.setProyectoCargo(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setHorasEstimadas(rs.getInt("horasEstimadas"));
                }
                catch(SQLException e){
                    agente.setHorasEstimadas(0);
                }
                try{
                    agente.setCantPuestos(rs.getInt("cantidadPuestos"));
                }
                catch(SQLException e){
                    agente.setCantPuestos(0);
                }
                try{
                    agente.setCdadLimPost(rs.getInt("cantidadLimitePostulaciones"));
                }
                catch(SQLException e){
                    agente.setCdadLimPost(0);
                }
                try{
                    agente.setOIDProyecto(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDProyecto(null);
                }
                try{
                    agente.setOIDCargo(rs.getString("OIDCargo"));
                }
                catch(SQLException e){
                    agente.setOIDCargo(null);
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
            case "OIDCargo":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
