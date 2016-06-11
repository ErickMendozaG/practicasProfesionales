
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

public class IntermediarioPlanEstudioMateria extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM materia_plan_estudio WHERE "+generarSQLCriterios(criterios.get(0));
        
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
        
        String sql = "SELECT * FROM materia_plan_estudio WHERE OIDMateriaPlanEstudio ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        
        PlanEstudioMateriaAgente planEstudioMateria = (PlanEstudioMateriaAgente) entidad;
        String sql = "INSERT INTO materia_plan_estudio (OIDMateriaPlanEstudio, OIDPlanEstudio, OIDMateria) VALUE ('"+planEstudioMateria.getOID()+"', '"+planEstudioMateria.getOIDPlanEstudio()+"', '"+planEstudioMateria.getOIDMateria()+"');";
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        PlanEstudioMateriaAgente planEstudioMateria = (PlanEstudioMateriaAgente) entidad;
        String sql = "UPDATE materia_plan_estudio SET OIDPlanEstudio='"+planEstudioMateria.getOIDPlanEstudio()+"' , OIDMateria='"+planEstudioMateria.getOIDMateria()+"' WHERE OIDMateriaPlanEstudio="+planEstudioMateria.getOID()+" ;";
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        PlanEstudioMateriaAgente planEstudioMateria = (PlanEstudioMateriaAgente) entidad;
        String sql = "DELETE FROM materia_plan_estudio WHERE OIDMateriaPlanEstudio="+planEstudioMateria.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                PlanEstudioMateriaAgente agente = new PlanEstudioMateriaAgente();
                
                try{
                    agente.setOID(rs.getString("OIDMateriaPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setOIDPlanEstudio(rs.getString("OIDPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setOIDPlanEstudio(null);
                }
                try{
                    agente.setOIDMateria(rs.getString("OIDMateria"));
                }
                catch(SQLException e){
                    agente.setOIDMateria(null);
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
            case "OIDPlanEstudio" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            case "OIDMateria":
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
    
}
