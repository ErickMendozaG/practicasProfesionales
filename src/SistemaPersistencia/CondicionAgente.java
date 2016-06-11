
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CondicionAgente extends Agente implements Condicion{

    private CondicionImplementacion condicion;

    /* Métodos de la Clase CondicionAgente */
    
    public CondicionImplementacion getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionImplementacion condicion) {
        this.condicion = condicion;
    }
    
    /* Métodos Implementados de la Interfaz Condicion*/
    
    /* SET */
    
    @Override
    public void setNroCondicion(int nroCondicion) {
        condicion.setNroCondicion(nroCondicion);
        super.setModificado(true);
    }

    @Override
    public void setNombreCondicion(String nombreCondicion) {
        condicion.setNombreCondicion(nombreCondicion);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public int getNroCondicion() {
        return condicion.getNroCondicion();
    }

    @Override
    public String getNombreCondicion() {
        return condicion.getNombreCondicion();
    }
}
