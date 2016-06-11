
package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface ProyectoCargo {
    
    /*SET*/
    public void setCargo(Cargo cargo);
    public void addProyectoCargoCarrera(ProyectoCargoCarrera proyectoCargoCarrera);
    public void setCantPuestos(int cantPuestos);   
    public void setCdadLimPost(int cdadLimPost);
    public void setHorasEstimadas(int horasEstimadas);
    
    /*GET*/
    public Cargo getCargo(); 
    public int getHorasEstimadas();
    public int getCantPuestos();
    public int getCdadLimPost();
    public Vector<ProyectoCargoCarrera> getProyectoCargoCarrera();
    
}
