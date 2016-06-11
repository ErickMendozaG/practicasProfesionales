
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

public class IntermediarioEstadoMateria extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM estado_materia WHERE "+this.generarSQLCriterios(criterios.get(0));
        
        if(criterios.size()>1){
            
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+this.generarSQLCriterios(criterios.get(i));
            }
        }
        
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        String sql = "SELECT * FROM estado_materia WHERE OIDEstadoMateria ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EstadoMateriaAgente estadoMateria = (EstadoMateriaAgente) entidad;
        String sql = "INSERT INTO estado_materia (OIDEstadoMateria, nombreEstadoMateria) VALUE ('"+estadoMateria.getOID()+"', '"+estadoMateria.getNombreEstadoMateria()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EstadoMateriaAgente estadoMateria = (EstadoMateriaAgente) entidad;
        String sql = "UPDATE estado_materia SET  nombreEstadoMateria='"+estadoMateria.getNombreEstadoMateria()+"' WHERE OIDEstadoMateria="+estadoMateria.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EstadoMateriaAgente estadoMateria = (EstadoMateriaAgente) entidad;
        String sql = "DELETE FROM estado_materia WHERE OIDEstadoMateria="+estadoMateria.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                EstadoMateriaAgente agente = new EstadoMateriaAgente();
                EstadoMateriaImplementacion implementacion = new EstadoMateriaImplementacion();
                agente.setEstadoMateria(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEstadoMateria"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroEstadoMateria(rs.getInt("nroEstadoMateria"));
                }
                catch(SQLException e){
                    agente.setNroEstadoMateria(0);
                }
                try{
                    agente.setNombreEstadoMateria(rs.getString("nombreEstadoMateria"));
                }
                catch(SQLException e){
                    agente.setNombreEstadoMateria(null);
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
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}

