
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoPostulacionImplementacion implements EstadoPostulacion{
 
    private Date fechaEstadoPostulacion;
    private Time horaEstadoPostulacion;
    
    private TipoEstadoPostulacion tipoEstadoPostulacion;

    /* Métodos de la Interface EstadoPostulacionAgente */

    /* SET */
    
    @Override
    public void setFechaEstadoPostulacion(Date fechaEstadoPostulacion) {
        this.fechaEstadoPostulacion = fechaEstadoPostulacion;
    }
    
    @Override
    public void setHoraEstadoPostulacion(Time horaEstadoPostulacion) {
        this.horaEstadoPostulacion = horaEstadoPostulacion;
    }
    
    @Override
    public void setTipoEstadoPostulacion(TipoEstadoPostulacion tipoEstadoPostulacion) {
        this.tipoEstadoPostulacion = tipoEstadoPostulacion;
    }
    
    /* GET */
    
    @Override
    public Date getFechaEstadoPostulacion() {
        return fechaEstadoPostulacion;
    }
    
    @Override
    public Time getHoraEstadoPostulacion() {
        return horaEstadoPostulacion;
    }
    
    @Override
    public TipoEstadoPostulacion getTipoEstadoPostulacion() {
        return tipoEstadoPostulacion;
    }
    
}
