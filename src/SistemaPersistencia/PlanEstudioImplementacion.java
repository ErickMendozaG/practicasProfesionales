
package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;


/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class PlanEstudioImplementacion implements PlanEstudio{
   
    private int nroPlanEstudio;
    private String nombrePlanEstudio;
    private Date fechaFinVigenciaPlanEstudio;
    
    private Vector<Materia> materia = new Vector();
    
    /*Métodos de la Clase PlanEstudioImplementacion*/
    
    /*SET*/
    @Override
    public void setNroPlanEstudio(int nroPlanEstudio) {
        this.nroPlanEstudio = nroPlanEstudio;
    }
    @Override
    public void setNombrePlanEstudio(String nombrePlanEstudio) {
        this.nombrePlanEstudio = nombrePlanEstudio;
    }
    @Override
    public void setFechaFinVigenciaPlanEstudio(Date fechaFinVigenciaPlanEstudio) {
        this.fechaFinVigenciaPlanEstudio = fechaFinVigenciaPlanEstudio;
    }
    @Override
    public void addMateria(Materia materia) {
        this.materia.add(materia);
    }
    
    /*GET*/
    @Override
    public int getNroPlanEstudio() {
        return nroPlanEstudio;
    }
    @Override
    public String getNombrePlanEstudio() {
        return nombrePlanEstudio;
    }
    @Override
    public Date getFechaFinVigenciaPlanEstudio() {
        return fechaFinVigenciaPlanEstudio;
    }
    @Override
    public Vector<Materia> getMateria() {
        return this.materia;
    }
}
