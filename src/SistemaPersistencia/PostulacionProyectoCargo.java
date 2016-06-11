
package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface PostulacionProyectoCargo {
    
    /*SET*/
    public void setprioridad(int prioridad);
    public void addEstadoPostulacion(EstadoPostulacion estadoPostulacion);
    public void setProyecto(Proyecto proyecto);
    public void setProyectoCargo(ProyectoCargo proyCargo);
    
    /*GET*/
    public Vector<EstadoPostulacion> getEstadoPostulacion();
    public int getPrioridad();
    public Proyecto getProyecto();
    public ProyectoCargo getProyectoCargo();
    
}
