
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EmpresaAgente extends Agente implements Empresa{
    
    private EmpresaImplementacion empresa;
    
    private String OIDSituacionFiscalDeEmpresa;
    private String OIDUniversidadDeEmpresa;
    private boolean heBuscadoSituacionFiscalDeEmpresa;
    private boolean heBuscadoUniversidadDeEmpresa;

    /* Métodos de la Clase EmpresaAgente */

    /* SET */
    
    public void setEmpresa(EmpresaImplementacion empresa) {
        this.empresa = empresa;
    }

    public void setOIDSituacionFiscalDeEmpresa(String OIDSituacionFiscalDeEmpresa) {
        this.OIDSituacionFiscalDeEmpresa = OIDSituacionFiscalDeEmpresa;
    }

    public void setOIDUniversidadDeEmpresa(String OIDUniversidadDeEmpresa) {
        this.OIDUniversidadDeEmpresa = OIDUniversidadDeEmpresa;
    }

    public void setHeBuscadoSituacionFiscalDeEmpresa(boolean heBuscadoSituacionFiscalDeEmpresa) {
        this.heBuscadoSituacionFiscalDeEmpresa = heBuscadoSituacionFiscalDeEmpresa;
    }

    public void setHeBuscadoUniversidadDeEmpresa(boolean heBuscadoUniversidadDeEmpresa) {
        this.heBuscadoUniversidadDeEmpresa = heBuscadoUniversidadDeEmpresa;
    }
        
    /* GET */
    
    public EmpresaImplementacion getEmpresa() {
        return empresa;
    }

    public String getOIDSituacionFiscalDeEmpresa() {
        return OIDSituacionFiscalDeEmpresa;
    }

    public String getOIDUniversidadDeEmpresa() {
        return OIDUniversidadDeEmpresa;
    }

    public boolean isHeBuscadosituacionFiscalDeEmpresa() {
        return heBuscadoSituacionFiscalDeEmpresa;
    }

    public boolean isHeBuscadouniversidadDeEmpresa() {
        return heBuscadoUniversidadDeEmpresa;
    }
    
    /* Métodos Implementados de la Interfaz Empresa */
    
    /* SET */
    
    @Override
    public void setRazonSocial(String razonSocial) {
        empresa.setRazonSocial(razonSocial);
        super.setModificado(true);
    }

    @Override
    public void setCuit(String cuit) {
        empresa.setCuit(cuit);
        super.setModificado(true);
    }

    @Override
    public void setDomicilioEmpresa(String domicilioEmpresa) {
        empresa.setDomicilioEmpresa(domicilioEmpresa);
        super.setModificado(true);
    }

    @Override
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        empresa.setTelefonoEmpresa(telefonoEmpresa);
        super.setModificado(true);
    }

    @Override
    public void setFechaInicioVigenciaEmpresa(Date fechaInicioVigenciaEmpresa) {
        empresa.setFechaInicioVigenciaEmpresa(fechaInicioVigenciaEmpresa);
        super.setModificado(true);
    }

    @Override
    public void setFechaFinVigenciaEmpresa(Date fechaFinVigenciaEmpresa) {
        empresa.setFechaFinVigenciaEmpresa(fechaFinVigenciaEmpresa);
        super.setModificado(true);
    }

    @Override
    public void setSituacionFiscalDeEmpresa(SituacionFiscal situacionFiscalDeEmpresa) {
        empresa.setSituacionFiscalDeEmpresa(situacionFiscalDeEmpresa);
        Agente agente = (Agente) situacionFiscalDeEmpresa;
        this.OIDSituacionFiscalDeEmpresa = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setUniversidadDeEmpresa(Universidad universidadDeEmpresa) {
        empresa.setUniversidadDeEmpresa(universidadDeEmpresa);
        Agente agente = (Agente) universidadDeEmpresa;
        this.OIDUniversidadDeEmpresa = agente.getOID();
        super.setModificado(true);
    }

    /* GET */
    @Override
    public String getRazonSocial() {
        return empresa.getRazonSocial();
    }

    @Override
    public String getCuit() {
        return empresa.getCuit();
    }

    @Override
    public String getDomicilioEmpresa() {
        return empresa.getDomicilioEmpresa();
    }

    @Override
    public String getTelefonoEmpresa() {
        return empresa.getTelefonoEmpresa();
    }

    @Override
    public Date getFechaInicioVigenciaEmpresa() {
        return empresa.getFechaInicioVigenciaEmpresa();
    }

    @Override
    public Date getFechaFinVigenciaEmpresa() {
        return empresa.getFechaFinVigenciaEmpresa();
    }

    @Override
    public SituacionFiscal getSituacionFiscalDeEmpresa() {
        if (heBuscadoSituacionFiscalDeEmpresa == true){
            return empresa.getSituacionFiscalDeEmpresa();
        }
        else{
            SituacionFiscal sitFiscal = (SituacionFiscal) FachadaPersistenciaInterna.getInstancia().buscar("SituacionFiscal", OIDSituacionFiscalDeEmpresa);
            empresa.setSituacionFiscalDeEmpresa(sitFiscal);
            this.setHeBuscadoSituacionFiscalDeEmpresa (true);
            return sitFiscal;
        }
    }

    @Override
    public Universidad getUniversidadDeEmpresa() {
        if (heBuscadoUniversidadDeEmpresa == true){
            return empresa.getUniversidadDeEmpresa();
        }
        else{
            Universidad univ = (Universidad) FachadaPersistenciaInterna.getInstancia().buscar("Universidad", OIDUniversidadDeEmpresa);
            empresa.setUniversidadDeEmpresa(univ);
            this.setHeBuscadoUniversidadDeEmpresa (true);
            return univ;
        }
    }
   
}
