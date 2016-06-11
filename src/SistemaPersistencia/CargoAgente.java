
package SistemaPersistencia;

import java.sql.Date;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class CargoAgente extends Agente implements Cargo{

    private CargoImplementacion cargo;
    
    private String OIDUniversidadDecargo;
    private boolean heBuscadoUniversidadDeCargo;
    
    /* Métodos de la Clase CargoAgente */
    
    /* SET */
    
    public void setCargo(CargoImplementacion cargo) {
        this.cargo = cargo;
    }

    public void setOIDUniversidadDecargo(String OIDUniversidadDecargo) {
        this.OIDUniversidadDecargo = OIDUniversidadDecargo;
    }

    public void setHeBuscadoUniversidadDeCargo(boolean heBuscadouniversidadDecargo) {
        this.heBuscadoUniversidadDeCargo = heBuscadouniversidadDecargo;
    }
    
    /* GET */
    
    public CargoImplementacion getCargo() {
        return cargo;
    }
    
    public String getOIDUniversidadDecargo() {
        return OIDUniversidadDecargo;
    }

    public boolean isHeBuscadouniversidadDeCargo() {
        return heBuscadoUniversidadDeCargo;
    }
    
    /* Métodos Implementados de la Interfaz Cargo */
    
    /* SET */
    
    @Override
    public void setNroCargo(int nroCargo) {
        cargo.setNroCargo(nroCargo);
        super.setModificado(true);
    }

    @Override
    public void setNombreCargo(String nombreCargo) {
        cargo.setNombreCargo(nombreCargo);
        super.setModificado(true);
    }

    @Override
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        cargo.setFechaInicioVigencia(fechaInicioVigencia);
        super.setModificado(true);
    }

    @Override
    public void setFechaFinVigencia(Date fechaFinVigencia) {
        cargo.setFechaFinVigencia(fechaFinVigencia);
        super.setModificado(true);
    }

    @Override
    public void setUniversidadDeCargo(Universidad universidadDecargo) {
        
        /* Instancia el agente de la Entidad para poder guardar el OID */
        Agente agente= (Agente)universidadDecargo;
        this.OIDUniversidadDecargo = agente.getOID();
        cargo.setUniversidadDeCargo(universidadDecargo);
        super.setModificado(true);
        
    }

    /* GET */
    
    @Override
    public int getNroCargo() {
        return cargo.getNroCargo();
    }

    @Override
    public String getNombreCargo() {
        return cargo.getNombreCargo();
    }

    @Override
    public Date getFechaInicioVigencia() {
        return cargo.getFechaInicioVigencia();
    }

    @Override
    public Date getFechaFinVigencia() {
        return cargo.getFechaFinVigencia();
    }

    @Override
    public Universidad getUniversidadDeCargo() {
        
        if (heBuscadoUniversidadDeCargo == true){
            return cargo.getUniversidadDeCargo();
        }
        else{
            Universidad univ = (Universidad) FachadaPersistenciaInterna.getInstancia().buscar("Universidad", OIDUniversidadDecargo);
            cargo.setUniversidadDeCargo(univ);
            this.setHeBuscadoUniversidadDeCargo(true); 
            return univ;
        }
        
    }  
    
}
