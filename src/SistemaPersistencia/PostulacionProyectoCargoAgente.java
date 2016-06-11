package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class PostulacionProyectoCargoAgente extends Agente implements PostulacionProyectoCargo {
    
    private PostulacionProyectoCargoImplementacion postProyCargo;
    
    private boolean heBuscadoEstadoPostulacion;
    private boolean heBuscadoProyecto;
    private boolean heBuscadoProyectoCargo;
    private String OIDProyecto;
    private String OIDProyectoCargo;
    
    private String OIDPostulacion;
    
    /* Métodos de la Clase PostulacionProyectoCargoAgente */
    public void setPostProyCargo(PostulacionProyectoCargoImplementacion postProyCargo) {
        this.postProyCargo = postProyCargo;
    }

    public PostulacionProyectoCargoImplementacion getPostProyCargo() {
        return postProyCargo;
    }
    
    public void setheBuscadoEstadoPostulacion(boolean hebuscado){
        this.heBuscadoEstadoPostulacion=hebuscado;
    }
    
    public boolean getheBuscadoEstadoPostulacion(){
        return heBuscadoEstadoPostulacion;
    }
    
    public void setheBuscadoProyecto(boolean hebuscado){
        this.heBuscadoProyecto=hebuscado;
    }
    
    public boolean getheBuscadoProyecto(){
        return heBuscadoProyecto;
    }
    
    public void setheBuscadoProyectoCargo(boolean hebuscado){
        this.heBuscadoProyectoCargo=hebuscado;
    }
    
    public boolean getheBuscadoProyectoCargo(){
        return heBuscadoProyectoCargo;
    }
    
    public void setOIDProyecto(String oidProyecto){
        this.OIDProyecto=oidProyecto;
    }
    public String getOIDProyecto(){
        return OIDProyecto;
    }
    
    public void setOIDProyectoCargo(String oidProyCargo){
        this.OIDProyectoCargo=oidProyCargo;
    }
    
    public String getOIDProyectoCargo(){
        return OIDProyectoCargo;
    }        

    public String getOIDPostulacion() {
        return OIDPostulacion;
    }

    public void setOIDPostulacion(String OIDPostulacion) {
        this.OIDPostulacion = OIDPostulacion;
    }
       
    /* Métodos Implementados de la Interfaz PostulacionProyectoCargo */
    
    /* SET */
    
    @Override
    public void setprioridad(int prioridad) {
        postProyCargo.setprioridad(prioridad);
        super.setModificado(true);
    }

    @Override
    public void addEstadoPostulacion(EstadoPostulacion estadoPostulacion) {
        EstadoPostulacionAgente agente = (EstadoPostulacionAgente)estadoPostulacion;
        agente.setOIDPostulacionProyectoCargo(this.getOID());
        postProyCargo.addEstadoPostulacion(estadoPostulacion);
        super.setModificado(true);
    }

    @Override
    public void setProyecto(Proyecto proyecto) {
        postProyCargo.setProyecto(proyecto);
        Agente agente = (Agente) proyecto;
        this.OIDProyecto = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setProyectoCargo(ProyectoCargo proyCargo) {
        postProyCargo.setProyectoCargo(proyCargo);
        Agente agente = (Agente)proyCargo;
        this.OIDProyectoCargo = agente.getOID();
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Vector<EstadoPostulacion> getEstadoPostulacion() {
        
        if (heBuscadoEstadoPostulacion == true){
        return postProyCargo.getEstadoPostulacion();
        }
        else{ 
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDPostulacionProyectoCargo");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<EstadoPostulacion> estPostulacion = FachadaPersistenciaInterna.getInstancia().buscar("EstadoPostulacion", criterios);
            int i = estPostulacion.size() - 1;
            while(i>=0){
                postProyCargo.addEstadoPostulacion(estPostulacion.get(i));
                i = i-1;
            }
            this.setheBuscadoEstadoPostulacion(true);
            return postProyCargo.getEstadoPostulacion();
        }
       
    }

    @Override
    public int getPrioridad() {
       return postProyCargo.getPrioridad();
    }

    @Override
    public Proyecto getProyecto() {
        
        if (heBuscadoProyecto == true){
            return postProyCargo.getProyecto();
        }
        else{
            Proyecto proy = (Proyecto) FachadaPersistenciaInterna.getInstancia().buscar("Proyecto", OIDProyecto);
            postProyCargo.setProyecto(proy);
            heBuscadoProyecto = true;
            return postProyCargo.getProyecto();
        }
        
    }

    @Override
    public ProyectoCargo getProyectoCargo() {
        
        if (heBuscadoProyectoCargo == true){
            return postProyCargo.getProyectoCargo();
        }
        else{
            ProyectoCargo proyCar = (ProyectoCargo) FachadaPersistenciaInterna.getInstancia().buscar("ProyectoCargo", OIDProyectoCargo);
            postProyCargo.setProyectoCargo(proyCar);
            heBuscadoProyectoCargo = true;
            return proyCar;
        }
        
    }
    
}
