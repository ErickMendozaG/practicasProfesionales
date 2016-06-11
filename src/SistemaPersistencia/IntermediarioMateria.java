
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

public class IntermediarioMateria extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM materia WHERE "+generarSQLCriterios(criterios.get(0));
        
        if((criterios.size()-1)>=1){
            
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+generarSQLCriterios(criterios.get(i));
            }
        }
        
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        String sql = "SELECT * FROM materia WHERE OIDMateria ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        MateriaAgente materia = (MateriaAgente) entidad;
        String sql;
        if(materia.getFechaFinVigenciaMateria() == null){
            sql = "INSERT INTO materia (OIDMateria, nombreMateria) VALUE ('"+materia.getOID()+"', '"+materia.getNombreMateria()+"');";
        }
        else{
            sql = "INSERT INTO materia (OIDMateria, fechaFinVigenciaMateria, nombreMateria) VALUE ('"+materia.getOID()+"', '"+materia.getFechaFinVigenciaMateria()+"', '"+materia.getNombreMateria()+"');";
        }
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        MateriaAgente materia = (MateriaAgente) entidad;
        String sql;
        if(materia.getFechaFinVigenciaMateria() == null){
           sql = "UPDATE materia SET fechaFinVigenciaMateria=null , nombreMateria='"+materia.getNombreMateria()+"' WHERE OIDMateria="+materia.getOID()+" ;"; 
        }
        else{
            sql = "UPDATE materia SET fechaFinVigenciaMateria='"+materia.getFechaFinVigenciaMateria()+"' , nombreMateria='"+materia.getNombreMateria()+"' WHERE OIDMateria="+materia.getOID()+" ;";
        }
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        MateriaAgente materia = (MateriaAgente) entidad;
        String sql = "DELETE FROM materia WHERE OIDMateria="+materia.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                MateriaAgente agente = new MateriaAgente();
                MateriaImplementacion implementacion = new MateriaImplementacion();
                agente.setMateria(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDMateria"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroMateria(rs.getInt("nroMateria"));
                }
                catch(SQLException e){
                    agente.setNroMateria(0);
                }
                try{
                    agente.setFechaFinVigenciaMateria(rs.getDate("fechaFinVigenciaMateria"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigenciaMateria(null);
                }
                try{
                    agente.setNombreMateria(rs.getString("nombreMateria"));
                }
                catch(SQLException e){
                    agente.setNombreMateria(null);
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