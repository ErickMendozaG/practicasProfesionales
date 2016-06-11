
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

public class IntermediarioCargo extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        /*Si hay problemas en la generacion de sentencias SQL identificar cuales son numericos y cuales son con ''*/
        /* String sql: 
         * -> Inicializado: sentencia básica sql que genera el intermediario para el caso de que exista un criterio */
        String sql = "SELECT * FROM cargo WHERE "+this.generarSQLCriterios(criterios.get(0));
        
        /* Si el vector de criterios tiene más de un elemento*/
        if(criterios.size()>1){
            
            /* Se agregan a la sentencia sql los demás criterios obviando el primer Criterio */
            for(int i=1; i < criterios.size(); i++){
                sql = sql+ "AND "+this.generarSQLCriterios(criterios.get(i));
            }
        }
        
        /*Al final se agrega para terminar la sentencia sql el ';' */
        sql=sql+";";
        return sql;
        
    }

    @Override
    protected String generarSQLBuscar(String oid) {
        
        /* Sentencia simple de búsqueda sql por OID */
        String sql = "SELECT * FROM cargo WHERE OIDCargo ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        CargoAgente cargo = (CargoAgente) entidad;
        String sql = "INSERT INTO cargo (OIDCargo, nroCargo, fechaInicioVigenciaCargo, fechaFinVigenciaCargo, nombreCargo, OIDUniversidad) VALUE ('"+cargo.getOID()+"', '"+cargo.getNroCargo()+"', '"+cargo.getFechaInicioVigencia()+"', '"+cargo.getFechaFinVigencia()+"', '"+cargo.getNombreCargo()+"', '"+cargo.getOIDUniversidadDecargo()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        CargoAgente cargo = (CargoAgente) entidad;
        String sql = "UPDATE cargo SET nroCargo='"+cargo.getNroCargo()+"' , fechaInicioVigenciaCargo='"+cargo.getFechaInicioVigencia()+"' , fechaFinVigenciaCargo='"+cargo.getFechaFinVigencia()+"' , nombreCargo='"+cargo.getNombreCargo()+"' , OIDUniversidad='"+cargo.getOIDUniversidadDecargo()+"' WHERE OIDCargo="+cargo.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        CargoAgente cargo = (CargoAgente) entidad;
        String sql = "DELETE FROM cargo WHERE OIDCargo="+cargo.getOID()+" ;";
        return sql;
        
    }
    
    /*No olvidar poner al agente como no modificado*/
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                CargoAgente agente = new CargoAgente();
                CargoImplementacion implementacion = new CargoImplementacion();
                agente.setCargo(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDCargo"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroCargo(rs.getInt("nroCargo"));
                }
                catch(SQLException e){
                    agente.setNroCargo(0);
                }
                try{
                    agente.setFechaInicioVigencia(rs.getDate("fechaInicioVigenciaCargo"));
                }
                catch(SQLException e){
                    agente.setFechaInicioVigencia(null);
                }
                try{
                    agente.setFechaFinVigencia(rs.getDate("fechaFinVigenciaCargo"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigencia(null);
                }
                try{
                    agente.setNombreCargo(rs.getString("nombreCargo"));
                }
                catch(SQLException e){
                    agente.setNombreCargo(null);
                }
                try{
                    agente.setOIDUniversidadDecargo(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOIDUniversidadDecargo(null);
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

    /*No olvidar poner al agente como no modificado*/
    
    @Override
    protected Object convertirRegistroAObjetoOID(ResultSet rs){
        
        Vector v = this.convertirRegistroAObjeto(rs);
        
        return v.get(0);
    }
   
    private String generarSQLCriterios (Criterio criterio){
        String sqlCriterio;
        String c = criterio.getAtributo();
        switch (c){
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