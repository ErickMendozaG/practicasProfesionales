
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoDocumentoAgente extends Agente implements TipoDocumento{
    
    private TipoDocumentoImplementacion tipoDocumento;

    /* Métodos de la Clase TipoDocumentoAgente */
    
    public void setTipoDocumento(TipoDocumentoImplementacion tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public TipoDocumentoImplementacion getTipoDocumento() {
        return tipoDocumento;
    }
    
    /* Métodos Implementados de la Interfaz TipoDocumento */
    
    /* SET */
    
    @Override
    public void setNroTipoDocumento(int nroTipoDocumento) {
        tipoDocumento.setNroTipoDocumento(nroTipoDocumento);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        tipoDocumento.setNombreTipoDocumento(nombreTipoDocumento);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getNroTipoDocumento() {
        return tipoDocumento.getNroTipoDocumento();
    }
    
    @Override
    public String getNombreTipoDocumento() {
        return tipoDocumento.getNombreTipoDocumento();
    }
    
}
