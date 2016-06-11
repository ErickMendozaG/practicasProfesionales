
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CarreraImplementacion implements Carrera {
    
    private int nroCarrera;
    private String nombreCarrera;
    private Date fechaFinVigenciaCarrera;
    
    private PlanEstudio planEstudioDeCarrera;
    private Universidad universidadDeCarrera;

    /* Métodos de la Clase CarreraImplementacion */
    
    /* SET */
    
    @Override
    public void setNroCarrera(int nroCarrera) {
        this.nroCarrera = nroCarrera;
    }
    
    @Override
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
    @Override
    public void setFechaFinVigenciaCarrera(Date fechaFinVigenciaCarrera) {
        this.fechaFinVigenciaCarrera = fechaFinVigenciaCarrera;
    }
    
    @Override
    public void setPlanEstudioDeCarrera(PlanEstudio planEstudioDeCarrera) {
        this.planEstudioDeCarrera = planEstudioDeCarrera;
    }
    
    @Override
    public void setUniversidadDeCarrera(Universidad universidadDeCarrera) {
        this.universidadDeCarrera = universidadDeCarrera;
    }
    
    /* GET */
    
    @Override
    public int getNroCarrera() {
        return nroCarrera;
    }
    
    @Override
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    
    @Override
    public Date getFechaFinVigenciaCarrera() {
        return fechaFinVigenciaCarrera;
    }
    
    @Override
    public PlanEstudio getPlanEstudioDeCarrera() {
        return planEstudioDeCarrera;
    }
    
    @Override
    public Universidad getUniversidadDeCarrera() {
        return universidadDeCarrera;
    }
    
}
