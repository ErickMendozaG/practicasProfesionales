
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

public class IntermediarioTipoDocumento extends IntermediarioRelacional{
@Override
    public String generarSQLBuscar(Vector<Criterio> criterios) {
        
       
        String sql = "SELECT * FROM tipo_documento";
        
        if(!"TipoDocumento".equals(criterios.get(0).getAtributo())){
        
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
        
        String sql = "SELECT * FROM tipo_documento WHERE OIDTipoDocumento ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        TipoDocumentoAgente tipoDocumento = (TipoDocumentoAgente) entidad;
        String sql = "INSERT INTO tipo_documento (OIDTipoDocumento, nombreTipoDocumento) VALUE ('"+tipoDocumento.getOID()+"', '"+tipoDocumento.getNombreTipoDocumento()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        TipoDocumentoAgente tipoDocumento = (TipoDocumentoAgente) entidad;
        String sql = "UPDATE tipo_documento SET nombreTipoDocumento='"+tipoDocumento.getNombreTipoDocumento()+"' WHERE OIDTipoDocumento="+tipoDocumento.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        TipoDocumentoAgente tipoDocumento = (TipoDocumentoAgente) entidad;
        String sql = "DELETE FROM tipo_documento WHERE OIDTipoDocumento="+tipoDocumento.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        try {
            while(rs.next()){
                TipoDocumentoAgente agente = new  TipoDocumentoAgente();
                TipoDocumentoImplementacion implementacion = new TipoDocumentoImplementacion();
                agente.setTipoDocumento(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDTipoDocumento"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNombreTipoDocumento(rs.getString("nombreTipoDocumento"));
                }
                catch(SQLException e){
                    agente.setNombreTipoDocumento(null);
                }
                try{
                    agente.setNroTipoDocumento(rs.getInt("nroTipoDocumento"));
                }
                catch(SQLException e){
                    agente.setNroTipoDocumento(0);
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
