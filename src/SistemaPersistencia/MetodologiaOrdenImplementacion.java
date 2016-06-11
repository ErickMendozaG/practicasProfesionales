
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class MetodologiaOrdenImplementacion implements MetodologiaOrden{
    
    private int nroMetodologiaOrden;
    private String nombreMetodologiaOrden;
    
    /* Métodos Implementados de la Interfaz MetodologiaOrden */
    
    /* SET */
    
    @Override
    public void setNroMetodologiaOrden(int nroMetodologiaOrden) {
        this.nroMetodologiaOrden = nroMetodologiaOrden;
    }
    
    @Override
    public void setNombreMetodologiaOrden(String nombreMetodologiaOrden) {
        this.nombreMetodologiaOrden = nombreMetodologiaOrden;
    }
    
    /* GET */
    
    @Override
    public int getNroMetodologiaOrden() {
        return nroMetodologiaOrden;
    }
    
    @Override
    public String getNombreMetodologiaOrden() {
        return nombreMetodologiaOrden;
    }
}
