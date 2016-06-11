
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface EstadoContrato {
    
     /* SET */
    
    abstract public void setFechaEstadoContrato(Date fechaEstadoContrato);
    abstract public void setHoraEstadoContrato(Time horaEstadoContrato);
    abstract public void setTipoEstadoContrato(TipoEstadoContrato tipoEstadoContrato);
    
    /* GET */
    
    abstract public Date getFechaEstadoContrato();
    abstract public Time getHoraEstadoContrato();
    abstract public TipoEstadoContrato getTipoEstadoContrato();
    
}
