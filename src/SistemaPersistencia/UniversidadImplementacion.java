
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class UniversidadImplementacion implements Universidad{

    private int nroUniversidad;
    private String nombreUniversidad;
    private String direccionServidorWeb;
    private Date fechaInicioVigenciaUniversidad;
    private Date fechaFinVigenciaUniversidad;
    
    /*Métodos de la Clase UniversidadImplementacion*/
    
    /*SET*/
    @Override
    public void setNroUniversidad(int nroUniversidad) {
        this.nroUniversidad = nroUniversidad;
    }
    @Override
    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }
    @Override
    public void setDireccionServidorWeb(String direccionServidorWeb) {
        this.direccionServidorWeb = direccionServidorWeb;
    }
    @Override
    public void setFechaInicioVigenciaUniversidad(Date fechaInicioVigenciaUniversidad) {
        this.fechaInicioVigenciaUniversidad = fechaInicioVigenciaUniversidad;
    }
    @Override
    public void setFechaFinVigenciaUniversidad(Date fechaFinVigenciaUniversidad) {
        this.fechaFinVigenciaUniversidad = fechaFinVigenciaUniversidad;
    }
    /*GET*/
    @Override
    public int getNroUniversidad() {
        return nroUniversidad;
    }
    @Override
    public String getNombreUniversidad() {
        return nombreUniversidad;
    }
    @Override
    public String getDireccionServidorWeb() {
        return direccionServidorWeb;
    }
    @Override
    public Date getFechaInicioVigenciaUniversidad() {
        return fechaInicioVigenciaUniversidad;
    }
    @Override
    public Date getFechaFinVigenciaUniversidad() {
        return fechaFinVigenciaUniversidad;
    }
    
}
