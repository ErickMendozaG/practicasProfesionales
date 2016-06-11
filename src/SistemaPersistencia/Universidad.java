
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Universidad {
    
    /*SET*/
    abstract public void setNroUniversidad(int nroUniversidad);
    abstract public void setNombreUniversidad(String nombreUniversidad);
    abstract public void setDireccionServidorWeb(String direccionServidorWeb);
    abstract public void setFechaInicioVigenciaUniversidad(Date fechaInicioVigenciaUniversidad);
    abstract public void setFechaFinVigenciaUniversidad(Date fechaFinVigenciaUniversidad);
    
    /*GET*/
    abstract public int getNroUniversidad();
    abstract public String getNombreUniversidad();
    abstract public String getDireccionServidorWeb();
    abstract public Date getFechaInicioVigenciaUniversidad();
    abstract public Date getFechaFinVigenciaUniversidad();
    
}
