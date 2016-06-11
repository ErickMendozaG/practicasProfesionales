
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CargoImplementacion implements Cargo {
    
    private int nroCargo;
    private String nombreCargo;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    
    private Universidad universidadDeCargo;
    
    /* Métodos de la Clase CargoImplementacion */
    
    /* SET */
    
    @Override
    public void setNroCargo(int nroCargo) {
        this.nroCargo = nroCargo;
    }
    
    @Override
    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }  
    
    @Override
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    
    @Override
    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }
    
    @Override
    public void setUniversidadDeCargo(Universidad universidadDecargo) {
        this.universidadDeCargo = universidadDecargo;
    }
    
    /* GET */
    
    @Override
    public int getNroCargo() {
        return nroCargo;
    }
    
    @Override
    public String getNombreCargo() {
        return nombreCargo;
    }
    
    @Override
    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    
    @Override
    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }
    
    @Override
    public Universidad getUniversidadDeCargo() {
        return universidadDeCargo;
    }
    
}
