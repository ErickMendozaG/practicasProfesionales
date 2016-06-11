
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

public class IntermediarioEstudiante extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estudiante WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM estudiante WHERE OIDEstudiante ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstudianteAgente estudiante = (EstudianteAgente) entidad;
        String sql = "INSERT INTO estudiante (OIDEstudiante, nroDocumento, legajo, nombreEstudiante, apellidoEstudiante, domicilioEstudiante, OIDUniversidad, OIDTipoDocumento) VALUE ('"+estudiante.getOID()+"', '"+estudiante.getNroDocumento()+"', '"+estudiante.getLegajo()+"', '"+estudiante.getNombreEstudiante()+"', '"+estudiante.getApellidoEstudiante()+"', '"+estudiante.getDomicilioEstudiante()+"', '"+estudiante.getOIDUniversidadDeEstudiante()+"', '"+estudiante.getOIDTipoDocumento()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstudianteAgente estudiante = (EstudianteAgente) entidad;
        String sql = "UPDATE estudiante SET legajo='"+estudiante.getLegajo()+"' , nombreEstudiante='"+estudiante.getNombreEstudiante()+"' , apellidoEstudiante='"+estudiante.getApellidoEstudiante()+"' , domicilioEstudiante='"+estudiante.getDomicilioEstudiante()+"' , OIDUniversidad='"+estudiante.getOIDUniversidadDeEstudiante()+"' , OIDTipoDocumento='"+estudiante.getOIDUniversidadDeEstudiante()+"' WHERE OIDEstudiante="+estudiante.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstudianteAgente estudiante = (EstudianteAgente) entidad;
        String sql = "DELETE FROM estudiante WHERE OIDEstudiante="+estudiante.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                EstudianteAgente agente = new EstudianteAgente();
                EstudianteImplementacion implementacion = new EstudianteImplementacion();
                agente.setEstudiante(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstudiante"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroDocumento(rs.getInt("nroDocumento"));
                }
                catch(SQLException e){
                    agente.setNroDocumento(0);
                }
                try{
                    agente.setLegajo(rs.getInt("legajo"));
                }
                catch(SQLException e){
                    agente.setLegajo(0);
                }
                try{
                    agente.setNombreEstudiante(rs.getString("nombreEstudiante"));
                }
                catch(SQLException e){
                    agente.setNombreEstudiante(null);
                }
                try{
                    agente.setApellidoEstudiante(rs.getString("apellidoEstudiante"));
                }
                catch(SQLException e){
                    agente.setApellidoEstudiante(null);
                }
                try{
                    agente.setDomicilioEstudiante(rs.getString("domicilioEstudiante"));
                }
                catch(SQLException e){
                    agente.setDomicilioEstudiante(null);
                }
                try{
                    agente.setOIDUniversidadDeEstudiante(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOIDUniversidadDeEstudiante(null);
                }
                try{
                    agente.setOIDTipoDocumento(rs.getString("OIDTipoDocumento"));
                }
                catch(SQLException e){
                    agente.setOIDTipoDocumento(null);
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
            case "tipoDocumento" :
                Agente ag = (Agente)criterio.getValor();
                sqlCriterio = " OIDTipoDocumento="+ag.getOID()+" ";
                
                break;
            case "OIDUniversidad" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDTipoDocumento":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "Universidad" :
                Agente a = (Agente) criterio.getValor();
                sqlCriterio = "OIDUniversidad="+a.getOID()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}