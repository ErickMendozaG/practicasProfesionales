
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

public class IntermediarioProyectoCargoCarrera extends IntermediarioRelacional{

      @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        
        String sql = "SELECT * FROM proyecto_cargo_carrera WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        
        String sql = "SELECT * FROM proyecto_cargo_carrera WHERE OIDProyectoCargoCarrera ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        ProyectoCargoCarreraAgente proyCagoCarrera = (ProyectoCargoCarreraAgente) entidad;
        String sql = "INSERT INTO proyecto_cargo_carrera (OIDProyectoCargoCarrera, cantidadMateriasRegulares, cantidadMateriasRendidas, OIDProyectoCargo, OIDCarrera ) VALUE ('"+proyCagoCarrera.getOID()+"', '"+proyCagoCarrera.getCantMateriasReg()+"', '"+proyCagoCarrera.getCantMateriasRend()+"', '"+proyCagoCarrera.getOIDProyectoCargo()+"', '"+proyCagoCarrera.getOIDCarrera()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        ProyectoCargoCarreraAgente proyCagoCarrera = (ProyectoCargoCarreraAgente) entidad;
        String sql = "UPDATE proyecto_cargo_carrera SET cantidadMateriasRegulares='"+proyCagoCarrera.getCantMateriasReg()+"' , cantidadMateriasRendidas='"+proyCagoCarrera.getCantMateriasRend()+"' , OIDProyectoCargo='"+proyCagoCarrera.getOIDProyectoCargo()+"' , OIDCarrera='"+proyCagoCarrera.getOIDCarrera()+"' WHERE OIDSeleccion="+proyCagoCarrera.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        ProyectoCargoCarreraAgente proyCagoCarrera = (ProyectoCargoCarreraAgente) entidad;
        String sql = "DELETE FROM proyecto_cargo_carrera WHERE OIDProyectoCargoCarrera="+proyCagoCarrera.getOID()+" ;";
        return sql;
        
    }
    
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                ProyectoCargoCarreraAgente agente = new ProyectoCargoCarreraAgente();
                ProyectoCargoCarreraImplementacion implementacion = new ProyectoCargoCarreraImplementacion();
                agente.setProyectoCargoCarrera(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDProyectoCargoCarrera"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setCantMateriasReg(rs.getInt("cantidadMateriasRegulares"));
                }
                catch(SQLException e){
                    agente.setCantMateriasReg(0);
                }
                try{
                    agente.setCantMateriasRend(rs.getInt("cantidadMateriasRendidas"));
                }
                catch(SQLException e){
                    agente.setCantMateriasRend(0);
                }
                try{
                    agente.setOIDProyectoCargo(rs.getString("OIDProyectoCargo"));
                }
                catch(SQLException e){
                    agente.setOIDProyectoCargo(null);
                }
                try{
                    agente.setOIDCarrera(rs.getString("OIDCarrera"));
                }
                catch(SQLException e){
                    agente.setOIDCarrera(null);
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
            case "OIDProyectoCargo" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDCarrera":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
