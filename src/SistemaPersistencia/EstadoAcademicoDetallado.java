
package SistemaPersistencia;


import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface  EstadoAcademicoDetallado {
    
    /* SET */
    
    public void setFechaEstado(Date fechaEstado) ;
    public void setNotaFinal(float notaFinal);
    public void setEstadoMateria(EstadoMateria estadoMateria);
    public void setMateria(Materia materia);

    /* GET */
    
    public Date getFechaEstado();
    public float getNotaFinal();
    public EstadoMateria getEstadoMateria();
    public Materia getMateria();
    
}
