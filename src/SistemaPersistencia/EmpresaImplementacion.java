
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EmpresaImplementacion implements Empresa{
 
    private String razonSocial;
    private String cuit;
    private String domicilioEmpresa;
    private String telefonoEmpresa;
    private Date fechaInicioVigenciaEmpresa;
    private Date fechaFinVigenciaEmpresa;
    
    private SituacionFiscal situacionFiscalDeEmpresa;
    private Universidad universidadDeEmpresa;
    
    /* Métodos de la Clase EmpresaImplementacion */
    
    /* SET */
    
    @Override
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    @Override
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    @Override
    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }
    
    @Override
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
    
    @Override
    public void setFechaInicioVigenciaEmpresa(Date fechaInicioVigenciaEmpresa) {
        this.fechaInicioVigenciaEmpresa = fechaInicioVigenciaEmpresa;
    }
    
    @Override
    public void setFechaFinVigenciaEmpresa(Date fechaFinVigenciaEmpresa) {
        this.fechaFinVigenciaEmpresa = fechaFinVigenciaEmpresa;
    }
    
    @Override
    public void setSituacionFiscalDeEmpresa(SituacionFiscal situacionFiscalDeEmpresa) {
        this.situacionFiscalDeEmpresa = situacionFiscalDeEmpresa;
    }
    
    @Override
    public void setUniversidadDeEmpresa(Universidad universidadDeEmpresa) {
        this.universidadDeEmpresa = universidadDeEmpresa;
    }
    
    /* GET */
    
    @Override
    public String getRazonSocial() {
        return razonSocial;
    }
    
    @Override
    public String getCuit() {
        return cuit;
    }
    
    @Override
    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }
    
    @Override
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }
    
    @Override
    public Date getFechaInicioVigenciaEmpresa() {
        return fechaInicioVigenciaEmpresa;
    }
    
    @Override
    public Date getFechaFinVigenciaEmpresa() {
        return fechaFinVigenciaEmpresa;
    }
    
    @Override
    public SituacionFiscal getSituacionFiscalDeEmpresa() {
        return situacionFiscalDeEmpresa;
    }
    
    @Override
    public Universidad getUniversidadDeEmpresa() {
        return universidadDeEmpresa;
    }
    
}
