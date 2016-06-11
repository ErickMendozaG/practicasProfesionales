
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Materia {
 
    /* SET */
    
    abstract public void setNroMateria(int nroMateria);
    abstract public void setNombreMateria(String nombreMateria);
    abstract public void setFechaFinVigenciaMateria(Date fechaFinVigenciaMateria);
    
    /* GET */
    
    abstract public int getNroMateria();
    abstract public String getNombreMateria();
    abstract public Date getFechaFinVigenciaMateria();
    
}
