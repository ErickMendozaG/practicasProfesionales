
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

public class IntermediarioSituacionFiscal extends IntermediarioRelacional{

   @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
       
        String sql = "SELECT * FROM situacion_fiscal WHERE "+generarSQLCriterios(criterios.get(0));
        
        
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
        
        String sql = "SELECT * FROM situacion_fiscal WHERE OIDSituacionFiscal ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        SituacionFiscalAgente situacionFiscal = (SituacionFiscalAgente) entidad;
        String sql = "INSERT INTO situacion_fiscal (OIDSituacionFiscal, nombreSituacionFiscal) VALUE ('"+situacionFiscal.getOID()+"', '"+situacionFiscal.getNombreSituacionFiscal()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        SituacionFiscalAgente situacionFiscal = (SituacionFiscalAgente) entidad;
        String sql = "UPDATE situacion_fiscal SET nombreSituacionFiscal='"+situacionFiscal.getNombreSituacionFiscal()+"' WHERE OIDSituacionFiscal="+situacionFiscal.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        SituacionFiscalAgente situacionFiscal = (SituacionFiscalAgente) entidad;
        String sql = "DELETE FROM situacion_fiscal WHERE OIDSituacionFiscal="+situacionFiscal.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                SituacionFiscalAgente agente = new  SituacionFiscalAgente();
                SituacionFiscalImplementacion implementacion = new SituacionFiscalImplementacion();
                agente.setSituacionFiscal(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDSituacionFiscal"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNombreSituacionFiscal(rs.getString("nombreSituacionFiscal"));
                }
                catch(SQLException e){
                    agente.setNombreSituacionFiscal(null);
                }
                try{
                    agente.setNroSituacionFiscal(rs.getInt("nroSituacionFiscal"));
                }
                catch(SQLException e){
                    agente.setNroSituacionFiscal(0);
                }
                agente.setModificado(false);
                agente.setNuevo(false);
                resultados.add(agente);
            }
        } catch (SQLException ex) {
            System.out.println("Error en while de rs.next");
            return null;
            
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
