
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

public class IntermediarioCarrera extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM carrera ";
        
        if(!"Carrera".equals(criterios.get(0).getAtributo())){
        
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
        
        String sql = "SELECT * FROM carrera WHERE OIDCarrera ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        CarreraAgente carrera = (CarreraAgente) entidad;
        String sql = "INSERT INTO carrera (OIDCarrera, fechaFinVigenciaCarrera, nombreCarrera, OIDUniversidad) VALUE ('"+carrera.getOID()+"', '"+carrera.getFechaFinVigenciaCarrera()+"', '"+carrera.getNombreCarrera()+"', '"+carrera.getOIDUniversidadDeCarrera()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        CarreraAgente carrera = (CarreraAgente) entidad;
        String sql = "UPDATE carrera SET fechaFinVigenciaCarrera='"+carrera.getFechaFinVigenciaCarrera()+"' , nombreCarrera='"+carrera.getNombreCarrera()+"' , OIDUniversidad='"+carrera.getOIDUniversidadDeCarrera()+"' WHERE OIDCarrera="+carrera.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        CarreraAgente carrera = (CarreraAgente) entidad;
        String sql = "DELETE FROM carrera WHERE OIDCarrera="+carrera.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                CarreraAgente agente = new CarreraAgente();
                CarreraImplementacion implementacion = new CarreraImplementacion();
                agente.setCarrera(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDCarrera"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroCarrera(rs.getInt("nroCarrera"));
                }
                catch(SQLException e){
                    agente.setNroCarrera(0);
                }
                try{
                    agente.setFechaFinVigenciaCarrera(rs.getDate("fechaFinVigenciaCarrera"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigenciaCarrera(null);
                }
                try{
                    agente.setNombreCarrera(rs.getString("nombreCarrera"));
                }
                catch(SQLException e){
                    agente.setNombreCarrera(null);
                }
                try{
                    agente.setOIDUniversidadDeCarrera(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOIDUniversidadDeCarrera(null);
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
            case "Universidad" :
                Agente a = (Agente) criterio.getValor();
                sqlCriterio = "OIDUniversidad"+criterio.getOperador()+a.getOID()+" ";
                break;
            case "OIDUniversidad" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}