
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

public class IntermediarioUniversidad extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM universidad WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        
        String sql = "SELECT * FROM universidad WHERE OIDUniversidad ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        UniversidadAgente universidad = (UniversidadAgente) entidad;
        String sql = "INSERT INTO universidad (OIDUniversidad, fechaInicioVigenciaUniversidad, fechaFinVigenciaUniversidad, direccionServidorWeb, nombreUniversidad) VALUE ('"+universidad.getOID()+"', '"+universidad.getFechaInicioVigenciaUniversidad()+"', '"+universidad.getFechaFinVigenciaUniversidad()+"', '"+universidad.getDireccionServidorWeb()+"', '"+universidad.getNombreUniversidad()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        UniversidadAgente universidad = (UniversidadAgente) entidad;
        String sql = "UPDATE univercidad SET fechaInicioVigenciaUniversidad='"+universidad.getFechaInicioVigenciaUniversidad()+"' , fechaFinVigenciaUniversidad='"+universidad.getFechaFinVigenciaUniversidad()+"' , direccionServidorWeb='"+universidad.getDireccionServidorWeb()+"' , nombreUniversidad='"+universidad.getNombreUniversidad()+"' WHERE OIDUniversidad="+universidad.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        UniversidadAgente universidad = (UniversidadAgente) entidad;
        String sql = "DELETE FROM universidad WHERE OIDUniversidad="+universidad.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                UniversidadAgente agente = new UniversidadAgente();
                UniversidadImplementacion implementacion = new UniversidadImplementacion();
                agente.setUniversidad(implementacion);
                try{
                    agente.setOID(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setDireccionServidorWeb(rs.getString("direccionServidorWeb"));
                }
                catch(SQLException e){
                    agente.setDireccionServidorWeb(null);
                }
                try{
                    agente.setFechaInicioVigenciaUniversidad(rs.getDate("fechaInicioVigenciaUniversidad"));
                }
                catch(SQLException e){
                    agente.setFechaInicioVigenciaUniversidad(null);
                }
                try{
                    agente.setFechaFinVigenciaUniversidad(rs.getDate("fechaFinVigenciaUniversidad"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigenciaUniversidad(null);
                }
                try{
                    agente.setNombreUniversidad(rs.getString("nombreUniversidad"));
                }
                catch(SQLException e){
                    agente.setNombreUniversidad(null);
                }
                try{
                    agente.setNroUniversidad(rs.getInt("nroUniversidad"));
                }
                catch(SQLException e){
                    agente.setNroUniversidad(0);
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
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
        
}
