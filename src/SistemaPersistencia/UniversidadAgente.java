
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class UniversidadAgente  extends Agente implements Universidad{
    
    private UniversidadImplementacion universidad;
    
    /* Métodos de la Clase UniversidadAgente */
    
    public void setUniversidad(UniversidadImplementacion universidad) {
        this.universidad = universidad;
    }    
    public UniversidadImplementacion getUniversidad() {
        return universidad;
    }
    
    /* Métodos Implementados de la Interfaz Universidad */
    
    /*SET*/
    
    @Override
    public void setNroUniversidad(int nroUniversidad){
        universidad.setNroUniversidad(nroUniversidad);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreUniversidad(String nombreUniversidad){
        universidad.setNombreUniversidad(nombreUniversidad);
        super.setModificado(true);
    }
    
    @Override
    public void setDireccionServidorWeb(String direccionServidorWeb){
        universidad.setDireccionServidorWeb(direccionServidorWeb);
        super.setModificado(true);
    }
    
    @Override
    public void setFechaInicioVigenciaUniversidad(Date fechaInicioVigenciaUniversidad){
        universidad.setFechaInicioVigenciaUniversidad(fechaInicioVigenciaUniversidad);
        super.setModificado(true);
    }
    
    @Override
    public void setFechaFinVigenciaUniversidad(Date fechaFinVigenciaUniversidad){
        universidad.setFechaFinVigenciaUniversidad(fechaFinVigenciaUniversidad);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getNroUniversidad(){
        return universidad.getNroUniversidad();
    }
    
    @Override
    public String getNombreUniversidad(){
        return universidad.getNombreUniversidad();
    }
    
    @Override
    public String getDireccionServidorWeb(){
        return universidad.getDireccionServidorWeb();
    }
    
    @Override
    public Date getFechaInicioVigenciaUniversidad(){
        return universidad.getFechaInicioVigenciaUniversidad();
    }
    
    @Override
    public Date getFechaFinVigenciaUniversidad(){
        return universidad.getFechaFinVigenciaUniversidad();
    }
    
}
