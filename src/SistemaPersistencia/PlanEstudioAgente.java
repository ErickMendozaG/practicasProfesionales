
package SistemaPersistencia;


import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class PlanEstudioAgente extends Agente implements PlanEstudio{

    private PlanEstudioImplementacion planEstudio;
    
    private String OIDCarrera; /*es para la relacion*/
    
    private Vector<PlanEstudioMateriaAgente> materias = new Vector();
    private boolean heBuscadoMateria;
    
    /* Métodos de la Clase PlanEstudioAgente */
    
    /* SET */
    
    public void setPlanEstudio(PlanEstudioImplementacion planEstudio) {
        this.planEstudio = planEstudio;
    }

    public void setHeBuscadoMateria(boolean heBuscadoMateria) {
        this.heBuscadoMateria = heBuscadoMateria;
    }

    public void setOIDCarrera(String OIDCarrera) {
        this.OIDCarrera = OIDCarrera;
    }

    public void addMaterias(PlanEstudioMateriaAgente materia) {
        this.materias.add(materia);
    }
        
    /* GET */
    
    public PlanEstudioImplementacion getPlanEstudio() {
        return planEstudio;
    }

    public boolean getHeBuscadoMateria() {
        return heBuscadoMateria;
    }    

    public String getOIDCarrera() {
        return OIDCarrera;
    }

    public Vector<PlanEstudioMateriaAgente> getMaterias() {
        return materias;
    }
    
    /* Métodos Implementados de la Interfaz PlanEstudio */
    
    /* SET */
    
    @Override
    public void setNroPlanEstudio(int nroPlanEstudio) {
        planEstudio.setNroPlanEstudio(nroPlanEstudio);
        super.setModificado(true);
    }

    @Override
    public void setNombrePlanEstudio(String nombrePlanEstudio) {
        planEstudio.setNombrePlanEstudio(nombrePlanEstudio);
        super.setModificado(true);
    }

    @Override
    public void setFechaFinVigenciaPlanEstudio(Date fechaFinVigenciaPlanEstudio) {
        planEstudio.setFechaFinVigenciaPlanEstudio(fechaFinVigenciaPlanEstudio);
        super.setModificado(true);
    }

    @Override
    public void addMateria(Materia materia) {
        
        MateriaAgente agente = (MateriaAgente) materia;
        if(this.verificarAgregarMaterias(agente)){
            PlanEstudioMateriaAgente agentePEM = new PlanEstudioMateriaAgente();
            agentePEM.setOIDMateria(agente.getOID());
            agentePEM.setOIDPlanEstudio(this.getOID());
            agentePEM.generarOID();
            this.materias.add(agentePEM);
            planEstudio.addMateria(materia);
            super.setModificado(true);
        }
    }

    /* GET */
    
    @Override
    public int getNroPlanEstudio() {
        return planEstudio.getNroPlanEstudio();
    }

    @Override
    public String getNombrePlanEstudio() {
        return planEstudio.getNombrePlanEstudio();
    }

    @Override
    public Date getFechaFinVigenciaPlanEstudio() {
        return planEstudio.getFechaFinVigenciaPlanEstudio();
    }

    /* A poner a prueba al rojo vivo la integridad de este método */
    @Override
    public Vector<Materia> getMateria() {
        
        if (heBuscadoMateria == true){
            return planEstudio.getMateria();
        }
        else{ 
            Vector<Criterio> criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDPlanEstudio");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<PlanEstudioMateriaAgente> planEstudioMateria = FachadaPersistenciaInterna.getInstancia().buscar("PlanEstudioMateria", criterios);
            
            int i = planEstudioMateria.size() - 1;
            while(i>=0){
                Materia mat = (Materia) FachadaPersistenciaInterna.getInstancia().buscar("Materia", planEstudioMateria.get(i).getOIDMateria());
                
                if(this.verificarAgregarMaterias((Agente)mat) == false){
                    int it =this.materias.size() - 1;
                    Agente ag = (Agente)mat;
                    while(it >=0){
                        if(this.materias.get(it).getOIDMateria() == ag.getOID()){
                            this.materias.get(it).setOID(planEstudioMateria.get(i).getOID());
                        }
                    }
                } 
                else{
                    this.materias.add(planEstudioMateria.get(i));
                    this.planEstudio.addMateria(mat);
                }
                i=i-1;
            }
            this.heBuscadoMateria = true;
            return planEstudio.getMateria();
            }
        
        }
    
    private boolean verificarAgregarMaterias(Agente materiaNueva){
        
        boolean ret= true;
        if(getMaterias().size() > 0){
            int i= this.getMaterias().size()-1;
            while(i>=0){
                PlanEstudioMateriaAgente materiaLocal = this.materias.get(i);
                if(materiaLocal.getOIDMateria() == materiaNueva.getOID()){
                    ret=false;
                    break;
                }
                i= i-1;
            }
        }
        return ret;
    }
    
}
