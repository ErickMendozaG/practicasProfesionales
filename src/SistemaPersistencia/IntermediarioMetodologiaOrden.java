
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

public class IntermediarioMetodologiaOrden extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM metodologia_orden WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM metodologia_orden WHERE OIDMetodologiaOrden ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        MetodologiaOrdenAgente metodologiaOrden = (MetodologiaOrdenAgente) entidad;
        String sql = "INSERT INTO metodologia_orden (OIDMetodologiaOrden, nombreMetodologiaOrden) VALUE ('"+metodologiaOrden.getOID()+"', '"+metodologiaOrden.getNombreMetodologiaOrden()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        MetodologiaOrdenAgente metodologiaOrden = (MetodologiaOrdenAgente) entidad;
        String sql = "UPDATE metodologia_orden SET nombreMetodologiaOrden='"+metodologiaOrden.getNombreMetodologiaOrden()+"' WHERE OIDMetodologiaOrden="+metodologiaOrden.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        MetodologiaOrdenAgente metodologiaOrden = (MetodologiaOrdenAgente) entidad;
        String sql = "DELETE FROM metodologia_orden WHERE OIDMetodologiaOrden="+metodologiaOrden.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                MetodologiaOrdenAgente agente = new MetodologiaOrdenAgente();
                MetodologiaOrdenImplementacion implementacion = new MetodologiaOrdenImplementacion();
                agente.setMetodologiaOrden(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDMetodologiaOrden"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroMetodologiaOrden(rs.getInt("nroMetodologiaOrden"));
                }
                catch(SQLException e){
                    agente.setNroMetodologiaOrden(0);
                }
                try{
                    agente.setNombreMetodologiaOrden(rs.getString("nombreMetodologiaOrden"));
                }
                catch(SQLException e){
                    agente.setNombreMetodologiaOrden(null);
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