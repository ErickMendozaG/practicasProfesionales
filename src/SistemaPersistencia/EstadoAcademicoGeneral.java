
package SistemaPersistencia;


import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface EstadoAcademicoGeneral {
   
    /* SET */
    
    abstract public void setFechaBaja(Date fechaBaja);
    abstract public void setFechaIngreso(Date fechaIngreso);
    abstract public void setCondicion(Condicion condicion);
    abstract public void addEstadoAcademicoDetallado(EstadoAcademicoDetallado estadoAcademicoDetallado);
    abstract public void setCarrera(Carrera carrera);
    abstract public void setPlanEstudio(PlanEstudio planEstudio);
    
    /* GET */
    
    abstract public Date getFechaBaja();
    abstract public Date getFechaIngreso();
    abstract public Condicion getCondicion();
    abstract public Vector<EstadoAcademicoDetallado> getEstadoAcademicoDetallado();
    abstract public Carrera getCarrera();
    abstract public PlanEstudio getPlanEstudio();
    
}
