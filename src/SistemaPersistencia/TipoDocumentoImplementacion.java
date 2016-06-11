
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoDocumentoImplementacion implements TipoDocumento{
    
    private int nroTipoDocumento;
    private String nombreTipoDocumento;
    
    /* Métodos de la Clase TipoDocumentoImplementacion */
    
    /* SET */
    
    @Override
    public void setNroTipoDocumento(int nroTipoDocumento) {
        this.nroTipoDocumento = nroTipoDocumento;
    }
    
    @Override
    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }
    
    /* GET */
    
    @Override
    public int getNroTipoDocumento() {
        return nroTipoDocumento;
    }
    
    @Override
    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }
    
}
