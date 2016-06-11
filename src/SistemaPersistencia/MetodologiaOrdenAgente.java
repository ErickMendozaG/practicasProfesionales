
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class MetodologiaOrdenAgente extends Agente implements MetodologiaOrden{

    private MetodologiaOrdenImplementacion metodologiaOrden;
    
    /* Métodos de la Clase MetodologiaOrdenAgente */

    public MetodologiaOrdenImplementacion getMetodologiaOrden() {
        return metodologiaOrden;
    }

    public void setMetodologiaOrden(MetodologiaOrdenImplementacion metodologiaOrden) {
        this.metodologiaOrden = metodologiaOrden;
    }
        
    /* Métodos Implementados de la Interfaz MetodologiaOrden */
    
    /* SET */
    
    @Override
    public void setNroMetodologiaOrden(int nroMetodologiaOrden) {
        metodologiaOrden.setNroMetodologiaOrden(nroMetodologiaOrden);
        super.setModificado(true);
    }

    @Override
    public void setNombreMetodologiaOrden(String nombreMetodologiaOrden) {
        metodologiaOrden.setNombreMetodologiaOrden(nombreMetodologiaOrden);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public int getNroMetodologiaOrden() {
        return metodologiaOrden.getNroMetodologiaOrden();
    }

    @Override
    public String getNombreMetodologiaOrden() {
        return metodologiaOrden.getNombreMetodologiaOrden();
    }
    
}
