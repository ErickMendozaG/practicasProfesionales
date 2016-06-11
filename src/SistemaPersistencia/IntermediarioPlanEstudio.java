
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

public class IntermediarioPlanEstudio extends IntermediarioRelacional{

    @Override
    protected String generarSQLBuscar(Vector<Criterio> criterios) {
        
        String sql = "SELECT * FROM plan_estudio ";
        
        if(!"PlanEstudio".equals(criterios.get(0).getAtributo())){
        
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
        
        String sql = "SELECT * FROM plan_estudio WHERE OIDPlanEstudio ="+oid+" ;";
        return sql;
        
    }
    
    @Override
    protected String generarSQLGuardar(Object entidad) {
        /* Mal implementado */
        PlanEstudioAgente planEstudio = (PlanEstudioAgente) entidad;
        String sql = "INSERT INTO plan_estudio (OIDPlanEstudio, nroPlanEstudio, fechaFinVigenciaPlanEstudio, nombrePlanEstudio, OIDCarrera) VALUE ('"+planEstudio.getOID()+"', '"+planEstudio.getNroPlanEstudio()+"', '"+planEstudio.getFechaFinVigenciaPlanEstudio()+"', '"+planEstudio.getNombrePlanEstudio()+"' ,'"+planEstudio.getOIDCarrera()+"');";
        Vector<PlanEstudioMateriaAgente> pEMA = planEstudio.getMaterias();
        for(int i=0; i<pEMA.size(); i++){
            //PlanEstudioMateriaAgente p = (PlanEstudioMateriaAgente) FabricaEntidades.getInstancia().obtenerEntidad("PlanEstudioMateriaAgente");
            //p.setOIDMateria(pEMA.get(i).getOID());
            //p.setOIDPlanEstudio(planEstudio.getOID());
            FachadaPersistenciaInterna.getInstancia().guardar("PlanEstudioMateria", pEMA.get(i));
        }
        return sql;
        
    }

    @Override
    protected String generarSQLActualizar(Object entidad) {
        
        PlanEstudioAgente planEstudio = (PlanEstudioAgente) entidad;
        Vector<PlanEstudioMateriaAgente> pEMA = planEstudio.getMaterias();
        String sql = "UPDATE plan_estudio SET OIDCarrera='"+planEstudio.getOIDCarrera()+"' , fechaFinVigenciaPlanEstudio='"+planEstudio.getFechaFinVigenciaPlanEstudio()+"' , nombrePlanEstudio='"+planEstudio.getNombrePlanEstudio()+"' WHERE OIDPlanEstudio="+planEstudio.getOID()+" ; ";
        for(int i=0; i<pEMA.size(); i++){
            FachadaPersistenciaInterna.getInstancia().guardar("PlanEstudioMateria", pEMA.get(i));
        }
        
        
        /*
        if(pEMA.size()>=1){
            int i = pEMA.size()-1;
            IntermediarioPlanEstudioMateria in = new IntermediarioPlanEstudioMateria();
            while(i>=0){
                if(pEMA.get(i).isNuevo() == true){
                    sql = sql+in.generarSQLGuardar(pEMA.get(i))+" ";
                }
                else if(pEMA.get(i).isModificado() == true){
                    sql = sql+in.generarSQLActualizar(pEMA.get(i))+" ";
                }
                i=i-1;
            }
        }
        */
        
        return sql;
        
    }

    @Override
    protected String generarSQLEliminar(Object entidad) {
        
        PlanEstudioAgente planEstudio = (PlanEstudioAgente) entidad;
        String sql = "DELETE FROM plan_estudio WHERE OIDPlanEstudio="+planEstudio.getOID()+" ;";
        return sql;
        
    }
    
    @Override
    protected Vector convertirRegistroAObjeto(ResultSet rs) {
        
        Vector resultados = new Vector();
        
        try {
            while(rs.next()){
                PlanEstudioAgente agente = new PlanEstudioAgente();
                PlanEstudioImplementacion implementacion = new PlanEstudioImplementacion();
                agente.setPlanEstudio(implementacion);
                
                try{
                    agente.setOID(rs.getString("OIDPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setOID(null);
                }
                try{
                    agente.setNroPlanEstudio(rs.getInt("nroPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setNroPlanEstudio(0);
                }
                try{
                    agente.setFechaFinVigenciaPlanEstudio(rs.getDate("fechaFinVigenciaPlanEstudio"));
                }
                catch(SQLException e){
                    agente.setFechaFinVigenciaPlanEstudio(null);
                }
                try{
                    agente.setNombrePlanEstudio(rs.getString("nombrePlanEstudio"));
                }
                catch(SQLException e){
                    agente.setNombrePlanEstudio(null);
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
            case "OIDCarrera" :
                sqlCriterio = criterio.getAtributo()+criterio.getOperador()+criterio.getValor()+" ";
                break;
            default:
                sqlCriterio = criterio.getAtributo()+" "+criterio.getOperador()+" '"+criterio.getValor()+"' ";
                break;
                
        }
        return sqlCriterio;
    }
    
}