
package SistemaPersistencia;

import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoCargoAgente extends Agente implements ProyectoCargo {
    
    
    private ProyectoCargoImplementacion proyectoCargo;
    
    private boolean heBuscadoCargo;
    private boolean heBuscadoProyectoCargoCarrera;
    private String OIDCargo;
    private String OIDProyecto;
    
    
    public String getOIDProyecto() {
        return OIDProyecto;
    }

    public void setOIDProyecto(String OIDProyecto) {
        this.OIDProyecto = OIDProyecto;
    }
    

    /* Métodos de la Clase ProyectoCargoAgente */
    
    public ProyectoCargoImplementacion getProyectoCargo() {
        return proyectoCargo;
    }

    public void setProyectoCargo(ProyectoCargoImplementacion proyectoCargo) {
        this.proyectoCargo = proyectoCargo;
    }

    public boolean isHeBuscadoCargo() {
        return heBuscadoCargo;
    }

    public void setHeBuscadoCargo(boolean heBuscadoCargo) {
        this.heBuscadoCargo = heBuscadoCargo;
    }

    public boolean isHeBuscadoProyectoCargoCarrera() {
        return heBuscadoProyectoCargoCarrera;
    }

    public void setHeBuscadoProyectoCargoCarrera(boolean heBuscadoProyectoCargoCarrera) {
        this.heBuscadoProyectoCargoCarrera = heBuscadoProyectoCargoCarrera;
    }

    public String getOIDCargo() {
        return OIDCargo;
    }

    public void setOIDCargo(String OIDCargo) {
        this.OIDCargo = OIDCargo;
    }
    
    /* Métodos Implementados de la Interfaz ProyectoCargo */
    
    /* SET */
    
    @Override
    public void setCargo(Cargo cargo) {
        Agente agente= (Agente)cargo;
        this.OIDCargo=agente.getOID();
        this.proyectoCargo.setCargo(cargo);
        super.setModificado(true);
    }

    @Override
    public void addProyectoCargoCarrera(ProyectoCargoCarrera proyectoCargoCarrera) {
        ProyectoCargoCarreraAgente agente= (ProyectoCargoCarreraAgente)proyectoCargoCarrera;
        agente.setOIDProyectoCargo(this.getOID());
        this.proyectoCargo.addProyectoCargoCarrera(agente);
        super.setModificado(true);
    }

    @Override
    public void setCantPuestos(int cantPuestos) {
        this.proyectoCargo.setCantPuestos(cantPuestos);
        super.setModificado(true);
    }

    @Override
    public void setCdadLimPost(int cdadLimPost) {
       this.proyectoCargo.setCdadLimPost(cdadLimPost);
        super.setModificado(true);
    }

    @Override
    public void setHorasEstimadas(int horasEstimadas) {
        this.proyectoCargo.setHorasEstimadas(horasEstimadas);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Cargo getCargo() {
        
        if(this.heBuscadoCargo==true){
          return proyectoCargo.getCargo();  
        }
        else{
            Cargo cargo;
            cargo=(Cargo)FachadaPersistenciaInterna.getInstancia().buscar("Cargo", OIDCargo);
            proyectoCargo.setCargo(cargo);
            this.heBuscadoCargo=true;
            return cargo;
        }
        
    }

    @Override
    public int getHorasEstimadas() {
        return this.proyectoCargo.getHorasEstimadas();
    }

    @Override
    public int getCantPuestos() {
        return this.proyectoCargo.getCantPuestos();
    }

    @Override
    public int getCdadLimPost() {
        return this.proyectoCargo.getCdadLimPost();
    }

    @Override
    public Vector<ProyectoCargoCarrera> getProyectoCargoCarrera() {
        
        if(this.heBuscadoProyectoCargoCarrera==true){
            return this.proyectoCargo.getProyectoCargoCarrera();
        }
        else{
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDProyectoCargo");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<ProyectoCargoCarrera> proyCarCarrera = FachadaPersistenciaInterna.getInstancia().buscar("ProyectoCargoCarrera", criterios);
            int i = proyCarCarrera.size() - 1;
            while(i>=0){
                proyectoCargo.addProyectoCargoCarrera(proyCarCarrera.get(i));
                i = i-1;
            }
            this.heBuscadoProyectoCargoCarrera=true;
            return this.proyectoCargo.getProyectoCargoCarrera();
        }
        
    }
        
}
