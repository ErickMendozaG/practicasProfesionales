
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface EstadoMateria {
   
    /* SET */

    public void setNroEstadoMateria(int nroEstadoMateria);
    public void setNombreEstadoMateria(String nombreEstadoMateria);
        
    /* GET */

    public int getNroEstadoMateria();
    public String getNombreEstadoMateria();
    
}
