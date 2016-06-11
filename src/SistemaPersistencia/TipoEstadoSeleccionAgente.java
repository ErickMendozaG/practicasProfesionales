
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoSeleccionAgente extends Agente implements TipoEstadoSeleccion{
    
    private TipoEstadoSeleccionImplementacion tipoEstadoSeleccion;

    /* Métodos de la Clase TipoEstadoSeleccionAgente */
    
    public void setTipoEstadoSeleccion(TipoEstadoSeleccionImplementacion tipoEstadoSeleccion) {
        this.tipoEstadoSeleccion = tipoEstadoSeleccion;
    }
    
    public TipoEstadoSeleccionImplementacion getTipoEstadoSeleccion() {
        return tipoEstadoSeleccion;
    }
    
    /* Métodos Implementados de la Interfaz TipoEstadoSeleccion */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoSeleccion(int nroTipoEstadoSeleccion){
        tipoEstadoSeleccion.setNroTipoEstadoSeleccion(nroTipoEstadoSeleccion);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoEstadoSeleccion(String nombreTipoEstadoSeleccion){
        tipoEstadoSeleccion.setNombreTipoEstadoSeleccion(nombreTipoEstadoSeleccion);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoSeleccion(){
        return tipoEstadoSeleccion.getNroTipoEstadoSeleccion();
    }
    
    @Override
    public String getNombreTipoEstadoSeleccion(){
        return tipoEstadoSeleccion.getNombreTipoEstadoSeleccion();
    }
    
}
