
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface MetodologiaOrden {
 
    /* SET */
    
    abstract public void setNroMetodologiaOrden(int nroMetodologiaOrden);
    abstract public void setNombreMetodologiaOrden(String nombreMetodologiaOrden);
    
    /* GET */
    
    abstract public int getNroMetodologiaOrden();
    abstract public String getNombreMetodologiaOrden();
    
}
