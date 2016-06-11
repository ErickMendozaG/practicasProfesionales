
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CondicionImplementacion implements Condicion{
    
    private int nroCondicion;
    private String nombreCondicion;

    /* Métodos Implementados de la Interfaz Condicion*/
    
    /* SET */
    
    @Override
    public void setNroCondicion(int nroCondicion) {
        this.nroCondicion = nroCondicion;
    }

    @Override
    public void setNombreCondicion(String nombreCondicion) {
        this.nombreCondicion = nombreCondicion;
    }

    /* GET */
    
    @Override
    public int getNroCondicion() {
        return nroCondicion;
    }

    @Override
    public String getNombreCondicion() {
        return nombreCondicion;
    }
}
