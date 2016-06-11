
package SistemaPersistencia;

import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CarreraAgente extends Agente implements Carrera{
    
    private CarreraImplementacion carrera;
    
    private String OIDUniversidadDeCarrera;
    private boolean heBuscadoPlanEstudioDeCarrera;
    private boolean heBuscadoUniversidadDeCarrera;

    /* Métodos de la Clase CarrreraAgente */
    
    /* SET */
    
    public void setCarrera(CarreraImplementacion carrera) {
        this.carrera = carrera;
    }
    
    public void setOIDUniversidadDeCarrera(String OIDUniversidadDeCarrera) {
        this.OIDUniversidadDeCarrera = OIDUniversidadDeCarrera;
    }
    
    public void setHeBuscadoPlanEstudioDeCarrera(boolean heBuscadoPlanEstudioDeCarrera) {
        this.heBuscadoPlanEstudioDeCarrera = heBuscadoPlanEstudioDeCarrera;
    }
    
    public void setHeBuscadoUniversidadDeCarrera(boolean heBuscadoUniversidadDeCarrera) {
        this.heBuscadoUniversidadDeCarrera = heBuscadoUniversidadDeCarrera;
    }
    
    /* GET */
    
    public CarreraImplementacion getCarrera() {
        return carrera;
    }

    public String getOIDUniversidadDeCarrera() {
        return OIDUniversidadDeCarrera;
    }

    public boolean isHeBuscadoPlanEstudioDeCarrera() {
        return heBuscadoPlanEstudioDeCarrera;
    }

    public boolean isHeBuscadoUniversidadDeCarrera() {
        return heBuscadoUniversidadDeCarrera;
    }    
       
    /* Metodos implementados de la Interface Carrera */
    
    /* SET */
    
    @Override
    public void setNroCarrera(int nroCarrera) {
        carrera.setNroCarrera(nroCarrera);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreCarrera(String nombreCarrera) {
        carrera.setNombreCarrera(nombreCarrera);
        super.setModificado(true);
    }
    
    @Override
    public void setFechaFinVigenciaCarrera(Date fechaFinVigenciaCarrera) {
        carrera.setFechaFinVigenciaCarrera(fechaFinVigenciaCarrera);
        super.setModificado(true);
    }
    
    @Override
    public void setPlanEstudioDeCarrera(PlanEstudio planEstudioDeCarrera) {
        
        PlanEstudioAgente agente = (PlanEstudioAgente)planEstudioDeCarrera;
        agente.setOIDCarrera(this.getOID());
        carrera.setPlanEstudioDeCarrera(agente);
        super.setModificado(true);
        
    }
    
    @Override
    public void setUniversidadDeCarrera(Universidad universidadDeCarrera) {
        
        Agente agente= (Agente)universidadDeCarrera;
        this.OIDUniversidadDeCarrera = agente.getOID();
        carrera.setUniversidadDeCarrera(universidadDeCarrera);
        super.setModificado(true);
        
    }

    /* GET */
    
    @Override
    public int getNroCarrera() {
        return carrera.getNroCarrera();
    }
    
    @Override
    public String getNombreCarrera() {
        return carrera.getNombreCarrera();
    }
    
    @Override
    public Date getFechaFinVigenciaCarrera() {
        return carrera.getFechaFinVigenciaCarrera();
    }
    
    @Override
    public PlanEstudio getPlanEstudioDeCarrera() {
        
        if (heBuscadoUniversidadDeCarrera == true){
            return carrera.getPlanEstudioDeCarrera();
        }
        else{
            Vector<Criterio> criterio = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDCarrera");
            c.setOperador("=");
            c.setValor(this.getOID());
            PlanEstudio planest = (PlanEstudio) FachadaPersistenciaInterna.getInstancia().buscar("PlanEstudio", criterio).get(0);
            carrera.setPlanEstudioDeCarrera(planest);
            this.setHeBuscadoPlanEstudioDeCarrera(true);
            return planest;
        }
        
    }
    
    @Override
    public Universidad getUniversidadDeCarrera() {
        
        if (heBuscadoUniversidadDeCarrera == true){
            return carrera.getUniversidadDeCarrera();
        }
        else{
            Universidad univ = (Universidad) FachadaPersistenciaInterna.getInstancia().buscar("Universidad", OIDUniversidadDeCarrera);
            carrera.setUniversidadDeCarrera(univ);
            this.setHeBuscadoUniversidadDeCarrera(true);
            return univ;
        }
        
    } 
    
}
