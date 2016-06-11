/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ProyectoCargoCarreraAgente extends Agente implements ProyectoCargoCarrera  {

    private ProyectoCargoCarreraImplementacion proyectoCargoCarrera;
    
    private boolean heBuscadoCarrera;
    private String OIDCarrera;
    private String OIDProyectoCargo;

    public String getOIDProyectoCargo() {
        return OIDProyectoCargo;
    }

    public void setOIDProyectoCargo(String OIDProyectoCargo) {
        this.OIDProyectoCargo = OIDProyectoCargo;
    }

    /* Métodos de la Clase ProyectoCargoCarreraAgente */
    
    public ProyectoCargoCarreraImplementacion getProyectoCargoCarrera() {
        return proyectoCargoCarrera;
    }

    public void setProyectoCargoCarrera(ProyectoCargoCarreraImplementacion proyectoCargoCarrera) {
        this.proyectoCargoCarrera = proyectoCargoCarrera;
    }
    
    public boolean isHeBuscadoCarrera() {
        return heBuscadoCarrera;
    }

    public void setHeBuscadoCarrera(boolean heBuscadoCarrera) {
        this.heBuscadoCarrera = heBuscadoCarrera;
    }

    public String getOIDCarrera() {
        return OIDCarrera;
    }

    public void setOIDCarrera(String OIDCarrera) {
        this.OIDCarrera = OIDCarrera;
    }
   
    
    /* Métodos Implementados de la Interfaz ProyectoCargoCarrera */
    
    /* SET */
    
    @Override
    public void setCantMateriasReg(int cantMateriasReg) {
        this.proyectoCargoCarrera.setCantMateriasReg(cantMateriasReg);
        super.setModificado(true);
    }

    @Override
    public void setCantMateriasRend(int cantMateriasRend) {
        this.proyectoCargoCarrera.setCantMateriasRend(cantMateriasRend);
        super.setModificado(true);
    }

    @Override
    public void setCarrera(Carrera carrera) {
        Agente agente= (Agente)carrera;
        this.OIDCarrera=agente.getOID();
        this.proyectoCargoCarrera.setCarrera(carrera);
        super.setModificado(true);
    }

    /* GET */
    @Override
    public int getCantMateriasReg() {
        return this.proyectoCargoCarrera.getCantMateriasReg();
    }

    @Override
    public int getCantMateriasRend() {
        return this.proyectoCargoCarrera.getCantMateriasRend();
    }

    @Override
    public Carrera getCarrera() {
        
        if(heBuscadoCarrera==true){
            return this.proyectoCargoCarrera.getCarrera();
        }
        else{
            Carrera carrera;
            carrera=(Carrera)FachadaPersistenciaInterna.getInstancia().buscar("Carrera", OIDCarrera);
            proyectoCargoCarrera.setCarrera(carrera);
            this.heBuscadoCarrera=true;
            return carrera;
        }
        
    }
    
}
