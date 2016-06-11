package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class PostulacionProyectoCargoImplementacion implements PostulacionProyectoCargo {
    private int prioridad;
    private Proyecto proyecto;
    private ProyectoCargo proyectoCargo;
    private Vector<EstadoPostulacion> estadoPostulacion = new Vector();

    /*Metodos IMplementados de la Interface*/
    /*SET*/
    @Override
    public void setprioridad(int prioridad) {
        this.prioridad=prioridad;
    }

    @Override
    public void addEstadoPostulacion(EstadoPostulacion estadoPostulacion) {
        this.estadoPostulacion.add(estadoPostulacion);
    }

    @Override
    public void setProyecto(Proyecto proyecto) {
        this.proyecto=proyecto;
    }

    @Override
    public void setProyectoCargo(ProyectoCargo proyCargo) {
       this.proyectoCargo=proyCargo;
    }

    /*GET*/
    @Override
    public Vector<EstadoPostulacion> getEstadoPostulacion() {
        
        return this.estadoPostulacion;
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public Proyecto getProyecto() {
        return proyecto;
    }

    @Override
    public ProyectoCargo getProyectoCargo() {
        return proyectoCargo;
    }
    
}
