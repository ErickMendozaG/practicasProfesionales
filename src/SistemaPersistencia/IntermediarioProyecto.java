
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

public class IntermediarioProyecto extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM proyecto";
        
        if(!"Proyecto".equals(criterios.get(0).getAtributo())){
        
            sql = sql +" WHERE "+generarSQLCriterios(criterios.get(0));


            if(criterios.size()>1){


                for(int i=1; i < criterios.size(); i++){
                    sql = sql+ "AND "+generarSQLCriterios(criterios.get(i));
                }
            }
        }
        
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        
        String sql = "SELECT * FROM proyecto WHERE OIDProyecto ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        ProyectoAgente proyecto = (ProyectoAgente) entidad;
        String sql = "INSERT INTO proyecto (OIDProyecto, nombreProyecto, fechaInicioInscripcion, fechaInicioProyecto, fechaLimitePostulacion,  tiempoDuracion, OIDEmpresa, OIDUniversidad, OIDMetodologiaOrden) VALUE ('"+proyecto.getOID()+"', '"+proyecto.getNombreProyecto()+"', '"+proyecto.getFechaInicioInscripcion()+"', '"+proyecto.getFechaInicioProyecto()+"', '"+proyecto.getFechaLimiteDePostulacion()+"', '"+proyecto.getTiempoDuracionProyecto()+"', '"+proyecto.getOIDEmpresa()+"', '"+proyecto.getOIDUniversidad()+"', '"+proyecto.getOIDMetodologiaOrden()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        ProyectoAgente proyecto = (ProyectoAgente) entidad;
        String sql = "UPDATE proyecto SET nombreProyecto='"+proyecto.getNombreProyecto()+"' , fechaInicioInscripcion='"+proyecto.getFechaInicioInscripcion()+"' , fechaInicioProyecto='"+proyecto.getFechaInicioProyecto()+"' , fechaLimitePostulacion='"+proyecto.getFechaLimiteDePostulacion()+"' , tiempoDuracion='"+proyecto.getTiempoDuracionProyecto()+"' , OIDEmpresa='"+proyecto.getOIDEmpresa()+"' , OIDUniversidad='"+proyecto.getOIDUniversidad()+"' , OIDMetodologiaOrden='"+proyecto.getOIDMetodologiaOrden()+"' WHERE OIDProyecto="+proyecto.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        ProyectoCargoAgente proyCago = (ProyectoCargoAgente) entidad;
        String sql = "DELETE FROM proyecto WHERE OIDProyecto="+proyCago.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                ProyectoAgente agente = new ProyectoAgente();
                ProyectoImplementacion implementacion = new ProyectoImplementacion();
                agente.setProyecto(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroProyecto(rs.getInt("nroProyecto"));
                }
                catch(SQLException e){
                    agente.setNroProyecto(0);
                }
                try{
                    agente.setNombreProyecto(rs.getString("nombreProyecto"));
                }
                catch(SQLException e){
                    agente.setNombreProyecto(null);
                }
                try{
                    agente.setFechaInicioInscripcion(rs.getDate("fechaInicioInscripcion"));
                }
                catch(SQLException e){
                    agente.setFechaInicioInscripcion(null);
                }
                try{
                    agente.setFechaInicioProyecto(rs.getDate("fechaInicioProyecto"));
                }
                catch(SQLException e){
                    agente.setFechaInicioProyecto(null);
                }
                try{
                    agente.setFechaLimiteDePostulacion(rs.getDate("fechaLimitePostulacion"));
                }
                catch(SQLException e){
                    agente.setFechaLimiteDePostulacion(null);
                }
                try{
                    agente.setTiempoDuracionProyecto(rs.getInt("tiempoDuracion"));
                }
                catch(SQLException e){
                    agente.setTiempoDuracionProyecto(0);
                }
                try{
                    agente.setOIDEmpresa(rs.getString("OIDEmpresa"));
                }
                catch(SQLException e){
                    agente.setOIDEmpresa(null);
                }
                try{
                    agente.setOIDUniversidad(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOIDUniversidad(null);
                }
                try{
                    agente.setOIDMetodologiaOrden(rs.getString("OIDMetodologiaOrden"));
                }
                catch(SQLException e){
                    agente.setOIDMetodologiaOrden(null);
                }
                /*agente.setHeBuscadoEmpresa(false);
                agente.setHeBuscadoEstadoProyecto(false);
                agente.setHeBuscadoMetodologiaOrden(false);
                agente.setHeBuscadoProyectoCargo(false);
                agente.setHeBuscadoUniversidad(false);
                agente.setModificado(false);*/
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
        
      Vector v= this.convertirRegistroAObjeto(rs);
       
        return v.get(0);
        
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            case "Universidad" :
                Agente ag = (Agente) criterio.getValor();
                sqlCriterio = "OIDUniversidad = "+ag.getOID()+" ";
                break;
            case "OIDEmpresa" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDUniversidad":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDMetodologiaOrden":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
