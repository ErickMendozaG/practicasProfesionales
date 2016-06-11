
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

public class IntermediarioSeleccionPostulacionProyectoCargo extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM seleccion_postulacion_proyecto_cargo WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        
        String sql = "SELECT * FROM seleccion_postulacion_proyecto_cargo WHERE OIDSeleccionPostulacionProyectoCargo ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        SeleccionPostulacionProyectoCargoAgente sppc = (SeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "INSERT INTO seleccion_postulacion_proyecto_cargo (OIDSeleccionPostulacionProyectoCargo, ordenMerito, fechaSeleccionPostulacionProyectoCargo, horaSeleccionPostulacionProyectoCargo, OIDTipoEstadoSeleccionPostulacionProyectoCargo, OIDSeleccion,OIDPostulacionProyectoCargo ) VALUE ('"+sppc.getOID()+"', '"+sppc.getOrdenMerito()+"', '"+sppc.getFechaSeleccionPostulacionProyectoCargo()+"', '"+sppc.getHoraSeleccionPostulacionProyectoCargo()+"', '"+sppc.getOIDTipoEstadoSelecPostProyCargo()+"', '"+sppc.getOIDSelecion()+ "', '"+sppc.getOIDPostulacionProyectoCargo()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        SeleccionPostulacionProyectoCargoAgente sppc = (SeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "UPDATE seleccion_postulacion_proyecto_cargo SET ordenMerito='"+sppc.getOrdenMerito()+"' , fechaSeleccionPostulacionProyectoCargo='"+sppc.getFechaSeleccionPostulacionProyectoCargo()+"' , horaSeleccionPostulacionProyectoCargo='"+sppc.getHoraSeleccionPostulacionProyectoCargo()+"' , OIDTipoEstadoSeleccionPostulacionProyectoCargo='"+sppc.getOIDTipoEstadoSelecPostProyCargo()+"' , OIDSeleccion='"+sppc.getOIDSelecion()+"' , OIDPostulacionProyectoCargo='"+sppc.getOIDPostulacionProyectoCargo()+"' WHERE OIDSeleccionPostulacionProyectoCargo="+sppc.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        SeleccionPostulacionProyectoCargoAgente sppc = (SeleccionPostulacionProyectoCargoAgente) entidad;
        String sql = "DELETE FROM seleccion_postulacion_proyecto_cargo WHERE OIDSeleccionPostulacionProyectoCargo="+sppc.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                SeleccionPostulacionProyectoCargoAgente agente = new SeleccionPostulacionProyectoCargoAgente();
                SeleccionPostulacionProyectoCargoImplementacion implementacion = new SeleccionPostulacionProyectoCargoImplementacion();
                agente.setSelecPostProyCargo(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setOrdenMerito(rs.getInt("ordenMerito"));
                }
                catch(SQLException e){
                    agente.setOrdenMerito(0);
                }
                try{
                    agente.setFechaSeleccionPostulacionProyectoCargo(rs.getDate("fechaSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setFechaSeleccionPostulacionProyectoCargo(null);
                }
                try{
                    agente.setHoraSeleccionPostulacionProyectoCargo(rs.getTime("horaSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setHoraSeleccionPostulacionProyectoCargo(null);
                }
                try{
                    agente.setOIDTipoEstadoSelecPostProyCargo(rs.getString("OIDTipoEstadoSeleccionPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDTipoEstadoSelecPostProyCargo(null);
                }
                try{
                    agente.setOIDSelecion(rs.getString("OIDSeleccion"));
                }
                catch(SQLException e){
                    agente.setOIDSelecion(null);
                }
                try{
                    agente.setOIDPostulacionProyectoCargo(rs.getString("OIDPostulacionProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDPostulacionProyectoCargo(null);
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
            case "OIDTipoEstadoSeleccionPostulacionProyectoCargo" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDSeleccion":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDPostulacionProyectoCargo":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
