
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface ProyectoCargoCarrera {
    
    /*SET*/
    public void setCantMateriasReg(int cantMateriasReg);
    public void setCantMateriasRend(int cantMateriasRend);
    public void setCarrera(Carrera carrera);
    
    /*GET*/
    public int getCantMateriasReg();
    public int getCantMateriasRend();
    public Carrera getCarrera();
    
}
