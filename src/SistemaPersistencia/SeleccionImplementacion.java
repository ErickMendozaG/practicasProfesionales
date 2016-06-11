
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

public class SeleccionImplementacion implements Seleccion {
    
    private Vector<SeleccionPostulacionProyectoCargo> seleccionPostulacionProyectoCargo = new Vector();
    private Proyecto proy;
    private TipoEstadoSeleccion tipoEstSelec;
    private Date fechaSeleccion;
    private Time horaSeleccion;
    private int nroSeleccion;

    @Override
    public void addSeleccionPostProyCargo(SeleccionPostulacionProyectoCargo sppc) {
        this.seleccionPostulacionProyectoCargo.add(sppc);
    }

    @Override
    public void setFechaSeleccion(Date fechaSeleccion) {
        this.fechaSeleccion=fechaSeleccion;
    }

    @Override
    public void setHoraSeleccion(Time horaSeleccion) {
        this.horaSeleccion=horaSeleccion;
    }

    @Override
    public void setNroSeleccion(int nroSeleccion) {
        this.nroSeleccion=nroSeleccion;
    }

    @Override
    public void setProyecto(Proyecto proyecto) {
        this.proy=proyecto;
    }

    @Override
    public void setTipoEstadoSeleccion(TipoEstadoSeleccion tipoEstSeleccion) {
        this.tipoEstSelec=tipoEstSeleccion;
    }
    
    

    @Override
    public Vector<SeleccionPostulacionProyectoCargo> getSeleccionPostulacionProyectoCargo() {  
        return this.seleccionPostulacionProyectoCargo;
    }

    @Override
    public Date getFechaSeleccion() {
      return fechaSeleccion;
    }

    @Override
    public Time getHoraSeleccion() {
         return horaSeleccion;
    }

    @Override
    public int getNroSeleccion() {
        return nroSeleccion;
    }

    @Override
    public Proyecto getProyecto() {
        return proy;
    }

    @Override
    public TipoEstadoSeleccion getTipoEstadoSeleccion() {
      return tipoEstSelec;
    }
    
}
