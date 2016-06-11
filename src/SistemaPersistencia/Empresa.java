
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Empresa {
    
    /* Set */
    
    abstract public void setRazonSocial(String razonSocial);
    abstract public void setCuit(String cuit);
    abstract public void setDomicilioEmpresa(String domicilioEmpresa);
    abstract public void setTelefonoEmpresa(String telefonoEmpresa);
    abstract public void setFechaInicioVigenciaEmpresa(Date fechaInicioVigenciaEmpresa);
    abstract public void setFechaFinVigenciaEmpresa(Date fechaFinVigenciaEmpresa);
    abstract public void setSituacionFiscalDeEmpresa(SituacionFiscal situacionFiscalDeEmpresa);
    abstract public void setUniversidadDeEmpresa(Universidad universidadDeEmpresa);
    
    /* GET */
    
    abstract public String getRazonSocial();
    abstract public String getCuit();
    abstract public String getDomicilioEmpresa();
    abstract public String getTelefonoEmpresa();
    abstract public Date getFechaInicioVigenciaEmpresa();
    abstract public Date getFechaFinVigenciaEmpresa();
    abstract public SituacionFiscal getSituacionFiscalDeEmpresa();
    abstract public Universidad getUniversidadDeEmpresa();
    
}
