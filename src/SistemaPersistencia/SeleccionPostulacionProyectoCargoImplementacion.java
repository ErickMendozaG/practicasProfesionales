
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class SeleccionPostulacionProyectoCargoImplementacion implements SeleccionPostulacionProyectoCargo{
    
    private int ordenMerito;
    private Date fechaSeleccionPostulacionProyectoCargo;
    private Time horaSeleccionPostulacionProyectoCargo;
    
    private TipoEstadoSeleccionPostulacionProyectoCargo tipoEstadoSeleccionPostulacionProyectoCargo;
    private PostulacionProyectoCargo postulacionProyectoCargo;
    
    /*SET*/
    @Override
    public void setOrdenMerito(int ordenMerito) {
        this.ordenMerito = ordenMerito;
    }
    @Override
    public void setFechaSeleccionPostulacionProyectoCargo(Date fechaSeleccionPostulacionProyectoCargo) {
        this.fechaSeleccionPostulacionProyectoCargo = fechaSeleccionPostulacionProyectoCargo;
    }
    @Override
    public void setHoraSeleccionPostulacionProyectoCargo(Time horaSeleccionPostulacionProyectoCargo) {
        this.horaSeleccionPostulacionProyectoCargo = horaSeleccionPostulacionProyectoCargo;
    }
    @Override
    public void setTipoEstadoSeleccionPostulacionProyectoCargo(TipoEstadoSeleccionPostulacionProyectoCargo tipoEstadoSeleccionPostulacionProyectoCargo) {
        this.tipoEstadoSeleccionPostulacionProyectoCargo = tipoEstadoSeleccionPostulacionProyectoCargo;
    }
    @Override
    public void setPostulacionProyectoCargo(PostulacionProyectoCargo postulacionProyectoCargo) {
        this.postulacionProyectoCargo = postulacionProyectoCargo;
    }
    
    
    /*GET*/
    @Override
    public int getOrdenMerito() {
        return ordenMerito;
    }
    @Override
    public Date getFechaSeleccionPostulacionProyectoCargo() {
        return fechaSeleccionPostulacionProyectoCargo;
    }
    @Override
    public Time getHoraSeleccionPostulacionProyectoCargo() {
        return horaSeleccionPostulacionProyectoCargo;
    }
    @Override
    public TipoEstadoSeleccionPostulacionProyectoCargo getTipoEstadoSeleccionPostulacionProyectoCargo() {
        return tipoEstadoSeleccionPostulacionProyectoCargo;
    }
    @Override
    public PostulacionProyectoCargo getPostulacionProyectoCargo() {
        return postulacionProyectoCargo;
    }
}
