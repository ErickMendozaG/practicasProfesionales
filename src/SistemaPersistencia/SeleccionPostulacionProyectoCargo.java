
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface SeleccionPostulacionProyectoCargo {
    
    /*SET*/
    public void setOrdenMerito(int ordenMerito);
    public void setFechaSeleccionPostulacionProyectoCargo(Date fechaSeleccionPostulacionProyectoCargo);
    public void setHoraSeleccionPostulacionProyectoCargo(Time horaSeleccionPostulacionProyectoCargo);
    public void setTipoEstadoSeleccionPostulacionProyectoCargo(TipoEstadoSeleccionPostulacionProyectoCargo tipoEstadoSeleccionPostulacionProyectoCargo);
    public void setPostulacionProyectoCargo(PostulacionProyectoCargo postulacionProyectoCargo);
    
    /*GET*/
    public int getOrdenMerito();
    public Date getFechaSeleccionPostulacionProyectoCargo();
    public Time getHoraSeleccionPostulacionProyectoCargo();
    public TipoEstadoSeleccionPostulacionProyectoCargo getTipoEstadoSeleccionPostulacionProyectoCargo();
    public PostulacionProyectoCargo getPostulacionProyectoCargo();
}
