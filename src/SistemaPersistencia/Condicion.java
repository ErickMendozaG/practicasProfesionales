
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Condicion {
    
    /* SET */
    
    public void setNroCondicion(int nroCondicion);
    public void setNombreCondicion(String nombreCondicion);

    /* GET */
    
    public int getNroCondicion();
    public String getNombreCondicion();
}
