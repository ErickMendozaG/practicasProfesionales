
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoSeleccionPostulacionProyectoCargoImplementacion implements TipoEstadoSeleccionPostulacionProyectoCargo{
    
    private int nroTipoEstadoSeleccionPostulacionProyectoCargo;
    private String nombreTipoEstadoSeleccionPostulacionProyectoCargo;
    
    /* Métodos de la Clase TipoEstadoSeleccionPostulacionProyectoCargoImplementacion */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoSeleccionPostulacionProyectoCargo(int nroTipoEstadoSeleccionPostulacionProyectoCargo) {
        this.nroTipoEstadoSeleccionPostulacionProyectoCargo = nroTipoEstadoSeleccionPostulacionProyectoCargo;
    }
    
    @Override
    public void setNombreTipoEstadoSeleccionPostulacionProyectoCargo(String nombreTipoEstadoSeleccionPostulacionProyectoCargo) {
        this.nombreTipoEstadoSeleccionPostulacionProyectoCargo = nombreTipoEstadoSeleccionPostulacionProyectoCargo;
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoSeleccionPostulacionProyectoCargo() {
        return nroTipoEstadoSeleccionPostulacionProyectoCargo;
    }
    @Override
    public String getNombreTipoEstadoSeleccionPostulacionProyectoCargo() {
        return nombreTipoEstadoSeleccionPostulacionProyectoCargo;
    }
}
