
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Carrera {
    
    /* SET */
    
    abstract public void setNroCarrera(int nroCarrera);
    abstract public void setNombreCarrera(String nombreCarrera);
    abstract public void setFechaFinVigenciaCarrera(Date fechaFinVigenciaCarrera);
    abstract public void setPlanEstudioDeCarrera(PlanEstudio planEstudioDeCarrera);
    abstract public void setUniversidadDeCarrera(Universidad universidadDeCarrera);
    
    /* GET */
    
    abstract public int getNroCarrera();
    abstract public String getNombreCarrera();
    abstract public Date getFechaFinVigenciaCarrera();
    abstract public PlanEstudio getPlanEstudioDeCarrera();
    abstract public Universidad getUniversidadDeCarrera();
    
}
