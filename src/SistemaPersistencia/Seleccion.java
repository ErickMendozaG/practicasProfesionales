
package SistemaPersistencia;

import java.sql.Time;
import java.util.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Seleccion {
    
    public void addSeleccionPostProyCargo(SeleccionPostulacionProyectoCargo sppc);
    public void setFechaSeleccion(Date fechaSeleccion);
    public void setHoraSeleccion(Time horaSeleccion);
    public void setNroSeleccion(int nroSeleccion);
    public void setProyecto(Proyecto proyecto);
    public void setTipoEstadoSeleccion(TipoEstadoSeleccion tipoEstSeleccion);
    
    public Vector<SeleccionPostulacionProyectoCargo> getSeleccionPostulacionProyectoCargo();
    public Date getFechaSeleccion();
    public Time getHoraSeleccion();
    public int getNroSeleccion();
    public Proyecto getProyecto();
    public TipoEstadoSeleccion getTipoEstadoSeleccion();
    
}
