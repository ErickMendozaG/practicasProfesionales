package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoAgente extends Agente implements Proyecto {
    
    private ProyectoImplementacion proyecto;

    private boolean heBuscadoEmpresa;
    private boolean heBuscadoEstadoProyecto;
    private boolean heBuscadoMetodologiaOrden;
    private boolean heBuscadoProyectoCargo;
    private boolean heBuscadoUniversidad;
    private String OIDEmpresa;
    private String OIDMetodologiaOrden;
    private String OIDUniversidad;

    /* Métodos de la Clase ProyectoAgente */
    
    public ProyectoImplementacion getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoImplementacion proyecto) {
        this.proyecto = proyecto;
    }

    public boolean isHeBuscadoEmpresa() {
        return heBuscadoEmpresa;
    }

    public void setHeBuscadoEmpresa(boolean heBuscadoEmpresa) {
        this.heBuscadoEmpresa = heBuscadoEmpresa;
    }

    public boolean isHeBuscadoEstadoProyecto() {
        return heBuscadoEstadoProyecto;
    }

    public void setHeBuscadoEstadoProyecto(boolean heBuscadoEstadoProyecto) {
        this.heBuscadoEstadoProyecto = heBuscadoEstadoProyecto;
    }

    public boolean isHeBuscadoMetodologiaOrden() {
        return heBuscadoMetodologiaOrden;
    }

    public void setHeBuscadoMetodologiaOrden(boolean heBuscadoMetodologiaOrden) {
        this.heBuscadoMetodologiaOrden = heBuscadoMetodologiaOrden;
    }

    public boolean isHeBuscadoProyectoCargo() {
        return heBuscadoProyectoCargo;
    }

    public void setHeBuscadoProyectoCargo(boolean heBuscadoProyectoCargo) {
        this.heBuscadoProyectoCargo = heBuscadoProyectoCargo;
    }

    public boolean isHeBuscadoUniversidad() {
        return heBuscadoUniversidad;
    }

    public void setHeBuscadoUniversidad(boolean heBuscadoUniversidad) {
        this.heBuscadoUniversidad = heBuscadoUniversidad;
    }

    public String getOIDEmpresa() {
        return OIDEmpresa;
    }

    public void setOIDEmpresa(String OIDEmpresa) {
        this.OIDEmpresa = OIDEmpresa;
    }

    public String getOIDMetodologiaOrden() {
        return OIDMetodologiaOrden;
    }

    public void setOIDMetodologiaOrden(String OIDMetodologiaOrden) {
        this.OIDMetodologiaOrden = OIDMetodologiaOrden;
    }

    public String getOIDUniversidad() {
        return OIDUniversidad;
    }

    public void setOIDUniversidad(String OIDUniversidad) {
        this.OIDUniversidad = OIDUniversidad;
    }
   
   
    /* Métodos Implementados de la Interfaz Proyecto */
    
    /* SET */
    
    @Override
    public void setEmpresa(Empresa empresa) {
        Agente agente= (Agente)empresa;
        this.OIDEmpresa=agente.getOID();
        this.proyecto.setEmpresa(empresa);
        super.setModificado(true);
    }

    @Override
    public void addEstadoProyecto(EstadoProyecto estadoProyecto) {
        EstadoProyectoAgente agente= (EstadoProyectoAgente)estadoProyecto;
        agente.setOIDProyecto(this.getOID());
        this.proyecto.addEstadoProyecto(agente);
        super.setModificado(true);
    }

    @Override
    public void setFechaInicioInscripcion(Date fechaInicioInscr) {
       this.proyecto.setFechaInicioInscripcion(fechaInicioInscr);
        super.setModificado(true);
    }

    @Override
    public void setFechaInicioProyecto(Date fechaInicioProy) {
        this.proyecto.setFechaInicioProyecto(fechaInicioProy);
        super.setModificado(true);
    }

    @Override
    public void setFechaLimiteDePostulacion(Date fechaLimPost) {
        this.proyecto.setFechaLimiteDePostulacion(fechaLimPost);
        super.setModificado(true);
    }

    @Override
    public void setMetodologiaOrden(MetodologiaOrden metodologia) {
        Agente agente= (Agente)metodologia;
        this.OIDMetodologiaOrden=agente.getOID();
        this.proyecto.setMetodologiaOrden(metodologia);
        super.setModificado(true);
    }

    @Override
    public void setNombreProyecto(String nombreProyecto) {
        this.proyecto.setNombreProyecto(nombreProyecto);
        super.setModificado(true);
    }

    @Override
    public void setNroProyecto(int nroProyecto) {
        this.proyecto.setNroProyecto(nroProyecto);
        super.setModificado(true);
    }

    @Override
    public void addProyectoCargo(ProyectoCargo proyectoCargo) {
        ProyectoCargoAgente agente= (ProyectoCargoAgente)proyectoCargo;
        agente.setOIDProyecto(this.getOID());
        this.proyecto.addProyectoCargo(agente);
        super.setModificado(true);
    }

    @Override
    public void setTiempoDuracionProyecto(int tiempo) {
        
        this.proyecto.setTiempoDuracionProyecto(tiempo);
        super.setModificado(true);
    }

    @Override
    public void setUniversidad(Universidad universidad) {
        Agente agente= (Agente)universidad;
        this.OIDUniversidad=agente.getOID();
        this.proyecto.setUniversidad(universidad);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Empresa getEmpresa() {
        
        if(this.heBuscadoEmpresa==true){
            return this.proyecto.getEmpresa();   
        }
        else{
            Empresa empresa;
            empresa=(Empresa)FachadaPersistenciaInterna.getInstancia().buscar("Empresa", OIDEmpresa);
            proyecto.setEmpresa(empresa);
            this.heBuscadoEmpresa=true;
            return empresa;
        }
        
    }

    @Override
    public Vector<EstadoProyecto> getEstadoproyecto() {
        
        if(this.heBuscadoEstadoProyecto==true){
            return this.proyecto.getEstadoproyecto();  
        }
        else{
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDProyecto");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<EstadoProyecto> estProyecto = FachadaPersistenciaInterna.getInstancia().buscar("EstadoProyecto", criterios);
            for(int i=0 ; i<estProyecto.size() ; i++){
                proyecto.addEstadoProyecto(estProyecto.get(i));
            }
            this.heBuscadoEstadoProyecto=true;
            return this.proyecto.getEstadoproyecto(); 
        }
        
    }

    @Override
    public Date getFechaInicioInscripcion() {
       return this.proyecto.getFechaInicioInscripcion();
    }

    @Override
    public Date getFechaInicioProyecto() {
       return this.proyecto.getFechaInicioProyecto();
    }

    @Override
    public Date getFechaLimiteDePostulacion() {
        return this.proyecto.getFechaLimiteDePostulacion();
    }

    @Override
    public MetodologiaOrden getMetodologiaOrden() {
        
        if(this.heBuscadoMetodologiaOrden==true){
            return this.proyecto.getMetodologiaOrden(); 
        }
        else{
            MetodologiaOrden metOrden;
            metOrden=(MetodologiaOrden)FachadaPersistenciaInterna.getInstancia().buscar("MetodologiaOrden", OIDMetodologiaOrden);
            proyecto.setMetodologiaOrden(metOrden);
            this.heBuscadoMetodologiaOrden=true;
            return metOrden;
        } 
        
    }

    @Override
    public String getNombreProyecto() {
        return this.proyecto.getNombreProyecto();
    }

    @Override
    public int getNroProyecto() {
        return this.proyecto.getNroProyecto();
    }

    @Override
    public Vector<ProyectoCargo> getProyectoCargo() {
        
        if(this.heBuscadoProyectoCargo==true){
            return this.proyecto.getProyectoCargo();   
        }
        else{
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDProyecto");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<ProyectoCargo> proyCargo = FachadaPersistenciaInterna.getInstancia().buscar("ProyectoCargo", criterios);
            int i = proyCargo.size() - 1;
            while(i>=0){
                proyecto.addProyectoCargo(proyCargo.get(i));
                i = i-1;
            }
            this.heBuscadoProyectoCargo=true;
            return this.proyecto.getProyectoCargo();   
        }
        
    }

    @Override
    public int getTiempoDuracionProyecto() {
        return this.proyecto.getTiempoDuracionProyecto();
    }

    @Override
    public Universidad getUniversidad() {
        
        if(this.heBuscadoUniversidad==true){
           return this.proyecto.getUniversidad(); 
        } 
        else{
            Universidad u;
            u=(Universidad)FachadaPersistenciaInterna.getInstancia().buscar("Universidad", OIDEmpresa);
            proyecto.setUniversidad(u);
            this.heBuscadoUniversidad=true;
            return u;
        }
        
    }
    
}
