
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

public class IntermediarioSeleccion extends IntermediarioRelacional{

     @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM seleccion WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        
        String sql = "SELECT * FROM seleccion WHERE OIDSeleccion ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        SeleccionAgente seleccion = (SeleccionAgente) entidad;
        String sql = "INSERT INTO seleccion (OIDSeleccion, fechaSeleccion, horaSeleccion, OIDProyecto, OIDTipoEstadoSeleccion ) VALUE ('"+seleccion.getOID()+"', '"+seleccion.getFechaSeleccion()+"', '"+seleccion.getHoraSeleccion()+"', '"+seleccion.getOIDProyecto()+"', '"+seleccion.getOIDTipoEstadoSeleccion()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        SeleccionAgente seleccion = (SeleccionAgente) entidad;
        String sql = "UPDATE seleccion SET fechaSeleccion='"+seleccion.getFechaSeleccion()+"' , horaSeleccion='"+seleccion.getHoraSeleccion()+"' , OIDProyecto='"+seleccion.getOIDProyecto()+"' , OIDTipoEstadoSeleccion='"+seleccion.getOIDTipoEstadoSeleccion()+"' WHERE OIDSeleccion="+seleccion.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        SeleccionAgente seleccion = (SeleccionAgente) entidad;
        String sql = "DELETE FROM seleccion WHERE OIDSeleccion="+seleccion.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                SeleccionAgente agente = new SeleccionAgente();
                SeleccionImplementacion implementacion = new SeleccionImplementacion();
                agente.setSeleccion(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDSeleccion"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroSeleccion(rs.getInt("nroSeleccion"));
                }
                catch(SQLException e){
                    agente.setNroSeleccion(0);
                }
                try{
                    agente.setFechaSeleccion(rs.getDate("fechaSeleccion"));
                }
                catch(SQLException e){
                    agente.setFechaSeleccion(null);
                }
                try{
                    agente.setHoraSeleccion(rs.getTime("horaSeleccion"));
                }
                catch(SQLException e){
                    agente.setHoraSeleccion(null);
                }
                try{
                    agente.setOIDProyecto(rs.getString("OIDProyecto"));
                }
                catch(SQLException e){
                    agente.setOIDProyecto(null);
                }
                try{
                    agente.setOIDTipoEstadoSeleccion(rs.getString("OIDTipoEstadoSeleccion"));
                }
                catch(SQLException e){
                    agente.setOIDTipoEstadoSeleccion(null);
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
            case "OIDTipoEstadoSeleccion":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
