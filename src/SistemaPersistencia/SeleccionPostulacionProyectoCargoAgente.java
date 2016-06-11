
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class SeleccionPostulacionProyectoCargoAgente extends Agente implements SeleccionPostulacionProyectoCargo {
    
    private SeleccionPostulacionProyectoCargoImplementacion selecPostProyCargo;
    
    private String OIDSelecion;
    private String OIDPostulacionProyectoCargo;
    private String OIDTipoEstadoSelecPostProyCargo;
    private boolean heBuscadoPostulacionProyectoCargo;
    private boolean heBuscadoTipoEstadoSelecPostProyCargo;
   

    
    
    /* Metodos de la Clase */
    public String getOIDSelecion() {
        return OIDSelecion;
    }

    public void setOIDSelecion(String OIDSelecion) {
        this.OIDSelecion = OIDSelecion;
    }

       
    public String getOIDPostulacionProyectoCargo() {
        return OIDPostulacionProyectoCargo;
    }
    
    public void setOIDPostulacionProyectoCargo(String OIDPostulacionProyectoCargo) {
        this.OIDPostulacionProyectoCargo = OIDPostulacionProyectoCargo;
    }
    
    public String getOIDTipoEstadoSelecPostProyCargo() {
        return OIDTipoEstadoSelecPostProyCargo;
    }
    
    public void setOIDTipoEstadoSelecPostProyCargo(String OIDTipoEstadoSelecPostProyCargo) {
        this.OIDTipoEstadoSelecPostProyCargo = OIDTipoEstadoSelecPostProyCargo;
    }
    
    public boolean isHeBuscadoPostulacionProyectoCargo() {
        return heBuscadoPostulacionProyectoCargo;
    }
    
    public void setHeBuscadoPostulacionProyectoCargo(boolean heBuscadoPostulacionProyectoCargo) {
        this.heBuscadoPostulacionProyectoCargo = heBuscadoPostulacionProyectoCargo;
    }
    
    public boolean isHeBuscadoTipoEstadoSelecPostProyCargo() {
        return heBuscadoTipoEstadoSelecPostProyCargo;
    }
    
    public void setHeBuscadoTipoEstadoSelecPostProyCargo(boolean heBuscadoTipoEstadoSelecPostProyCargo) {
        this.heBuscadoTipoEstadoSelecPostProyCargo = heBuscadoTipoEstadoSelecPostProyCargo;
    }
    
    public SeleccionPostulacionProyectoCargoImplementacion getSelecPostProyCargo() {
        return selecPostProyCargo;
    }
    
    public void setSelecPostProyCargo(SeleccionPostulacionProyectoCargoImplementacion selecPostProyCargo) {
        this.selecPostProyCargo = selecPostProyCargo;
    }
        
    /* SET */
    
    @Override
    public void setOrdenMerito(int ordenMerito) {
        selecPostProyCargo.setOrdenMerito(ordenMerito);
        super.setModificado(true);
    }
    
    @Override
    public void setFechaSeleccionPostulacionProyectoCargo(Date fechaSeleccionPostulacionProyectoCargo) {
        selecPostProyCargo.setFechaSeleccionPostulacionProyectoCargo(fechaSeleccionPostulacionProyectoCargo);
        super.setModificado(true);
    }
    
    @Override
    public void setHoraSeleccionPostulacionProyectoCargo(Time horaSeleccionPostulacionProyectoCargo) {
        selecPostProyCargo.setHoraSeleccionPostulacionProyectoCargo(horaSeleccionPostulacionProyectoCargo);
        super.setModificado(true);
    }
    
    @Override
    public void setTipoEstadoSeleccionPostulacionProyectoCargo(TipoEstadoSeleccionPostulacionProyectoCargo tipoEstadoSeleccionPostulacionProyectoCargo) {
        Agente agente= (Agente)tipoEstadoSeleccionPostulacionProyectoCargo;
        this.OIDTipoEstadoSelecPostProyCargo = agente.getOID();
        selecPostProyCargo.setTipoEstadoSeleccionPostulacionProyectoCargo(tipoEstadoSeleccionPostulacionProyectoCargo);
        super.setModificado(true);
    }
    
    @Override
    public void setPostulacionProyectoCargo(PostulacionProyectoCargo postulacionProyectoCargo) { 
        Agente agente= (Agente)postulacionProyectoCargo;
        this.OIDPostulacionProyectoCargo = agente.getOID();
        selecPostProyCargo.setPostulacionProyectoCargo(postulacionProyectoCargo);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getOrdenMerito() {
        return selecPostProyCargo.getOrdenMerito();
    }
    
    @Override
    public Date getFechaSeleccionPostulacionProyectoCargo() {
        return selecPostProyCargo.getFechaSeleccionPostulacionProyectoCargo();
    }
    
    @Override
    public Time getHoraSeleccionPostulacionProyectoCargo() {
        return selecPostProyCargo.getHoraSeleccionPostulacionProyectoCargo();
    }
    
    @Override
    public TipoEstadoSeleccionPostulacionProyectoCargo getTipoEstadoSeleccionPostulacionProyectoCargo() {
        
        if(this.heBuscadoTipoEstadoSelecPostProyCargo==true){
          return selecPostProyCargo.getTipoEstadoSeleccionPostulacionProyectoCargo();  
        }
        else{
            TipoEstadoSeleccionPostulacionProyectoCargo tipoESPPC;
            tipoESPPC=(TipoEstadoSeleccionPostulacionProyectoCargo)FachadaPersistenciaInterna.getInstancia().buscar("PostulacionProyectoCargo", OIDPostulacionProyectoCargo);
            selecPostProyCargo.setTipoEstadoSeleccionPostulacionProyectoCargo(tipoESPPC);
            this.heBuscadoTipoEstadoSelecPostProyCargo=true; 
            return tipoESPPC;
        }
        
    }
    
    @Override
    public PostulacionProyectoCargo getPostulacionProyectoCargo() {
        
        if(this.heBuscadoPostulacionProyectoCargo==true){
            return selecPostProyCargo.getPostulacionProyectoCargo();
        }
        else{
            PostulacionProyectoCargo sppc;
            sppc=(PostulacionProyectoCargo) FachadaPersistenciaInterna.getInstancia().buscar("PostulacionProyectoCargo", OIDPostulacionProyectoCargo);
            selecPostProyCargo.setPostulacionProyectoCargo(sppc);
            this.heBuscadoPostulacionProyectoCargo=true;
            return sppc;
        }  
        
    }
    
}
