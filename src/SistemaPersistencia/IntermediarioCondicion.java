
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

public class IntermediarioCondicion extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM condicion WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM condicion WHERE OIDCondicion ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        CondicionAgente condicion = (CondicionAgente) entidad;
        String sql = "INSERT INTO condicion (OIDCondicion, nombreCondicion) VALUE ('"+condicion.getOID()+"', '"+condicion.getNombreCondicion()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        CondicionAgente condicion = (CondicionAgente) entidad;
        String sql = "UPDATE condicion SET nombreCondicion='"+condicion.getNombreCondicion()+"' WHERE OIDCondicion="+condicion.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        CondicionAgente condicion = (CondicionAgente) entidad;
        String sql = "DELETE FROM condicion WHERE OIDCondicion="+condicion.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                CondicionAgente agente = new CondicionAgente();
                CondicionImplementacion implementacion = new CondicionImplementacion();
                agente.setCondicion(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDCondicion"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroCondicion(rs.getInt("nroCondicion"));
                }
                catch(SQLException e){
                    agente.setNroCondicion(0);
                }
                try{
                    agente.setNombreCondicion(rs.getString("nombreCondicion"));
                }
                catch(SQLException e){
                    agente.setNombreCondicion(null);
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
