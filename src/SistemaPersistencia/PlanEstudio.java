
package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface PlanEstudio {
   
    /*SET*/
    abstract public void setNroPlanEstudio(int nroPlanEstudio);
    abstract public void setNombrePlanEstudio(String nombrePlanEstudio);
    abstract public void setFechaFinVigenciaPlanEstudio(Date fechaFinVigenciaPlanEstudio);
    abstract public void addMateria(Materia materia);
    
    /*GET*/
    abstract public int getNroPlanEstudio();
    abstract public String getNombrePlanEstudio();
    abstract public Date getFechaFinVigenciaPlanEstudio();
    abstract public Vector<Materia> getMateria();
}
