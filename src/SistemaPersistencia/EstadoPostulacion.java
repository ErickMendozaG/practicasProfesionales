
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface EstadoPostulacion {
    
     /* SET */
    
    abstract public void setFechaEstadoPostulacion(Date fechaEstadoPostulacion);
    abstract public void setHoraEstadoPostulacion(Time horaEstadoPostulacion);
    abstract public void setTipoEstadoPostulacion(TipoEstadoPostulacion tipoEstadoPostulacion);
    
    /* GET */
    
    abstract public Date getFechaEstadoPostulacion();
    abstract public Time getHoraEstadoPostulacion();
    abstract public TipoEstadoPostulacion getTipoEstadoPostulacion();
    
}
