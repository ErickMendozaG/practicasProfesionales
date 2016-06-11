
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

public class IntermediarioTipoEstadoSeleccion extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
       
        String sql = "SELECT * FROM tipo_estado_seleccion WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        String sql = "SELECT * FROM tipo_estado_seleccion WHERE OIDTipoEstadoSeleccion ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        TipoEstadoSeleccionAgente tipEstSelec = (TipoEstadoSeleccionAgente) entidad;
        String sql = "INSERT INTO tipo_estado_seleccion (OIDTipoEstadoSeleccion, nombreTipoEstadoSeleccion) VALUE ('"+tipEstSelec.getOID()+"', '"+tipEstSelec.getNombreTipoEstadoSeleccion()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        TipoEstadoSeleccionAgente tipEstSelec = (TipoEstadoSeleccionAgente) entidad;
        String sql = "UPDATE tipo_estado_seleccion SET nombreTipoEstadoProyecto='"+tipEstSelec.getNombreTipoEstadoSeleccion()+"' WHERE OIDTipoEstadoSeleccion="+tipEstSelec.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        TipoEstadoSeleccionAgente tipEstSelec = (TipoEstadoSeleccionAgente) entidad;
        String sql = "DELETE FROM tipo_estado_seleccion WHERE OIDTipoEstadoSeleccion="+tipEstSelec.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                TipoEstadoSeleccionAgente agente = new TipoEstadoSeleccionAgente();
                TipoEstadoSeleccionImplementacion implementacion = new TipoEstadoSeleccionImplementacion();
                agente.setTipoEstadoSeleccion(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDTipoEstadoSeleccion"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNombreTipoEstadoSeleccion(rs.getString("nombreTipoEstadoSeleccion"));
                }
                catch(SQLException e){
                    agente.setNombreTipoEstadoSeleccion(null);
                }
                try{
                    agente.setNroTipoEstadoSeleccion(rs.getInt("nroTipoEstadoSeleccion"));
                }
                catch(SQLException e){
                    agente.setNroTipoEstadoSeleccion(0);
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
        Vector v=this.convertirRegistroAObjeto(rs);
        return v.get(0);
        
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }    
    
}
