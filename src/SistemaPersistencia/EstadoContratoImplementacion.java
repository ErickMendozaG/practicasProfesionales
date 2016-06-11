
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoContratoImplementacion implements EstadoContrato{
    
    private Date fechaEstadoContrato;
    private Time horaEstadoContrato;
    
    private TipoEstadoContrato tipoEstadoContrato;
    
    /* Métodos de la Clase EstadoContratoImplementacion */
    
    /* SET */
    
    @Override
    public void setFechaEstadoContrato(Date fechaEstadoContrato) {
        this.fechaEstadoContrato = fechaEstadoContrato;
    }
    
    @Override
    public void setHoraEstadoContrato(Time horaEstadoContrato) {
        this.horaEstadoContrato = horaEstadoContrato;
    }
    
    @Override
    public void setTipoEstadoContrato(TipoEstadoContrato tipoEstadoContrato) {
        this.tipoEstadoContrato = tipoEstadoContrato;
    }
    
    /* GET */
    
    @Override
    public Date getFechaEstadoContrato() {
        return fechaEstadoContrato;
    }
    
    @Override
    public Time getHoraEstadoContrato() {
        return horaEstadoContrato;
    }
    
    @Override
    public TipoEstadoContrato getTipoEstadoContrato() {
        return tipoEstadoContrato;
    }
    
}
