
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface EstadoProyecto {
    
    /* SET */
    
    abstract public void setFechaEstadoProyecto(Date fechaEstadoProyecto);
    abstract public void setHoraEstadoProyecto(Time horaEstadoProyecto);
    abstract public void setTipoEstadoProyecto(TipoEstadoProyecto tipoEstadoProyecto);

    /* GET */
    
    abstract public Date getFechaEstadoProyecto();
    abstract public Time getHoraEstadoProyecto();
    abstract public TipoEstadoProyecto getTipoEstadoProyecto();
    
}
