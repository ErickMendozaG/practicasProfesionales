
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoSeleccionPostulacionProyectoCargoAgente extends Agente implements TipoEstadoSeleccionPostulacionProyectoCargo{
    
    private TipoEstadoSeleccionPostulacionProyectoCargoImplementacion tipoEstadoSeleccionPostulacionProyectoCargo;

    /*Métodos de la Clase TipoEstadoSeleccionPostulacionProyectoCargoAgente */
    
    public void setTipoEstadoSeleccionPostulacionProyectoCargo(TipoEstadoSeleccionPostulacionProyectoCargoImplementacion tipoEstadoSeleccionPostulacionProyectoCargo) {
        this.tipoEstadoSeleccionPostulacionProyectoCargo = tipoEstadoSeleccionPostulacionProyectoCargo;
    }
    public TipoEstadoSeleccionPostulacionProyectoCargoImplementacion getTipoEstadoSeleccionPostulacionProyectoCargo() {
        return tipoEstadoSeleccionPostulacionProyectoCargo;
    }
    
    /* Métodos Implementados de la Interfaz TipoEstadoSeleccionPostulacionProyectoCargo */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoSeleccionPostulacionProyectoCargo(int nroTipoEstadoSeleccionPostulacionProyectoCargo){
        tipoEstadoSeleccionPostulacionProyectoCargo.setNroTipoEstadoSeleccionPostulacionProyectoCargo(nroTipoEstadoSeleccionPostulacionProyectoCargo);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoEstadoSeleccionPostulacionProyectoCargo(String nombreTipoEstadoSeleccionPostulacionProyectoCargo){
        tipoEstadoSeleccionPostulacionProyectoCargo.setNombreTipoEstadoSeleccionPostulacionProyectoCargo(nombreTipoEstadoSeleccionPostulacionProyectoCargo);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoSeleccionPostulacionProyectoCargo(){
        return tipoEstadoSeleccionPostulacionProyectoCargo.getNroTipoEstadoSeleccionPostulacionProyectoCargo();
    }
    
    @Override
    public String getNombreTipoEstadoSeleccionPostulacionProyectoCargo(){
        return tipoEstadoSeleccionPostulacionProyectoCargo.getNombreTipoEstadoSeleccionPostulacionProyectoCargo();
    }
    
}
