
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface TipoDocumento {
    
    /* SET */
    
    public void setNroTipoDocumento(int nroTipoDocumento);
    public void setNombreTipoDocumento(String nombreTipoDocumento);
    
    /* GET */
    
    public int getNroTipoDocumento();
    public String getNombreTipoDocumento();
}
