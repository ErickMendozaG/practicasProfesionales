
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

public class IntermediarioEmpresa extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM empresa ";
        
        if(!"Empresa".equals(criterios.get(0).getAtributo())){
        
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
        
        String sql = "SELECT * FROM empresa WHERE OIDEmpresa ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        EmpresaAgente empresa = (EmpresaAgente) entidad;
        String sql = "INSERT INTO empresa (OIDEmpresa, cuit, razonSocial, domicilioEmpresa, telefonoEmpresa, fechaInicioVigencia, fechaFinVigencia, OIDSituacionFiscal, OIDUniversidad) VALUE ('"+empresa.getOID()+"', '"+empresa.getCuit()+"', '"+empresa.getRazonSocial()+"', '"+empresa.getDomicilioEmpresa()+"', '"+empresa.getTelefonoEmpresa()+"', '"+empresa.getFechaInicioVigenciaEmpresa()+"', '"+empresa.getFechaFinVigenciaEmpresa()+"', '"+empresa.getOIDSituacionFiscalDeEmpresa()+"', '"+empresa.getOIDUniversidadDeEmpresa()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        EmpresaAgente empresa = (EmpresaAgente) entidad;
        String sql = "UPDATE empresa SET cuit='"+empresa.getCuit()+"' , razonSocial='"+empresa.getRazonSocial()+"' , domicilioEmpresa='"+empresa.getDomicilioEmpresa()+"' , telefonoEmpresa='"+empresa.getTelefonoEmpresa()+"' , fechaInicioVigencia='"+empresa.getFechaInicioVigenciaEmpresa()+"' , fechaFinVigencia='"+empresa.getFechaFinVigenciaEmpresa()+"' , OIDSituacionFiscal='"+empresa.getOIDSituacionFiscalDeEmpresa()+"' , OIDUniversidad='"+empresa.getOIDUniversidadDeEmpresa()+"'  WHERE OIDEmpresa="+empresa.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        EmpresaAgente empresa = (EmpresaAgente) entidad;
        String sql = "DELETE FROM empresa WHERE OIDEmpresa="+empresa.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
       
        Vector resultados = new Vector();
       
        try {
            while(rs.next()){
                EmpresaAgente agente = new EmpresaAgente();
                EmpresaImplementacion implementacion = new EmpresaImplementacion();
                agente.setEmpresa(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDEmpresa"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setCuit(rs.getString("cuit"));
                }
                catch(SQLException e){
                    agente.setCuit(null);
                }
                try{
                    agente.setRazonSocial(rs.getString("razonSocial"));
                }
                catch(SQLException e){
                    agente.setRazonSocial(null);
                }
                try{
                    agente.setDomicilioEmpresa(rs.getString("domicilioEmpresa"));
                }
                catch(SQLException e){
                    agente.setDomicilioEmpresa(null);
                }
                try{
                    agente.setTelefonoEmpresa(rs.getString("telefonoEmpresa"));
                }
                catch(SQLException e){
                    agente.setTelefonoEmpresa(null);
                }
                try{
                    agente.setFechaInicioVigenciaEmpresa(rs.getDate("fechaInicioVigencia"));
                }
                catch(SQLException e){
                    agente.setFechaInicioVigenciaEmpresa(null);
                }
                try{
                    agente.setFechaFinVigenciaEmpresa(rs.getDate("fechaFinVigencia"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigenciaEmpresa(null);
                }
                try{
                    agente.setOIDSituacionFiscalDeEmpresa(rs.getString("OIDSituacionFiscal"));
                }
                catch(SQLException e){
                    agente.setOIDSituacionFiscalDeEmpresa(null);
                }
                try{
                    agente.setOIDUniversidadDeEmpresa(rs.getString("OIDUniversidad"));
                }
                catch(SQLException e){
                    agente.setOIDUniversidadDeEmpresa(null);
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
            case "OIDUniversidad" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDSituacionFiscal":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}
