
package SistemaPersistencia;


import java.sql.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoAcademicoGeneralAgente extends Agente implements EstadoAcademicoGeneral{

    private EstadoAcademicoGeneralImplementacion estadoAcademicoGeneral;
    
    private String OIDcondicion;
    private String OIDcarrera;
    private String OIDplanEstudio;
    private boolean heBuscadocondicion;
    private boolean heBuscadoestadoAcademicoDetallado;
    private boolean heBuscadocarrera;
    private boolean heBuscadoplanEstudio;

    /* Métodos de la Clase EstadoAcademicoGeneralAgente */
    
    /* SET */
    
    public void setEstadoAcademicoGeneral(EstadoAcademicoGeneralImplementacion estadoAcademicoGeneral) {
        this.estadoAcademicoGeneral = estadoAcademicoGeneral;
    }

    public void setOIDcondicion(String OIDcondicion) {
        this.OIDcondicion = OIDcondicion;
    }

    public void setOIDcarrera(String OIDcarrera) {
        this.OIDcarrera = OIDcarrera;
    }

    public void setOIDplanEstudio(String OIDplanEstudio) {
        this.OIDplanEstudio = OIDplanEstudio;
    }

    public void setHeBuscadocondicion(boolean heBuscadocondicion) {
        this.heBuscadocondicion = heBuscadocondicion;
    }

    public void setHeBuscadoestadoAcademicoDetallado(boolean heBuscadoestadoAcademicoDetallado) {
        this.heBuscadoestadoAcademicoDetallado = heBuscadoestadoAcademicoDetallado;
    }

    public void setHeBuscadocarrera(boolean heBuscadocarrera) {
        this.heBuscadocarrera = heBuscadocarrera;
    }

    public void setHeBuscadoplanEstudio(boolean heBuscadoplanEstudio) {
        this.heBuscadoplanEstudio = heBuscadoplanEstudio;
    }
        
    /* GET */
    
    public EstadoAcademicoGeneralImplementacion getEstadoAcademicoGeneral() {
        return estadoAcademicoGeneral;
    }

    public String getOIDcondicion() {
        return OIDcondicion;
    }

    public String getOIDcarrera() {
        return OIDcarrera;
    }

    public String getOIDplanEstudio() {
        return OIDplanEstudio;
    }

    public boolean isHeBuscadocondicion() {
        return heBuscadocondicion;
    }

    public boolean getHeBuscadoestadoAcademicoDetallado() {
        return heBuscadoestadoAcademicoDetallado;
    }

    public boolean isHeBuscadocarrera() {
        return heBuscadocarrera;
    }

    public boolean isHeBuscadoplanEstudio() {
        return heBuscadoplanEstudio;
    }
    
    /* Métodos Implementados de la Interfaz EstadoAcademicoGeneral*/
    
    /* SET */
    
    @Override
    public void setFechaBaja(Date fechaBaja) {
        estadoAcademicoGeneral.setFechaBaja(fechaBaja);
        super.setModificado(true);
    }

    @Override
    public void setFechaIngreso(Date fechaIngreso) {
        estadoAcademicoGeneral.setFechaIngreso(fechaIngreso);
        super.setModificado(true);
    }

    @Override
    public void setCondicion(Condicion condicion) {
        estadoAcademicoGeneral.setCondicion(condicion);
        Agente agente = (Agente) condicion;
        this.OIDcondicion = agente.getOID();
        super.setModificado(true);
    }
    
    @Override
    public void addEstadoAcademicoDetallado(EstadoAcademicoDetallado estadoAcademicoDetallado) {
        EstadoAcademicoDetalladoAgente agente = (EstadoAcademicoDetalladoAgente) estadoAcademicoDetallado;
        agente.setOIDEstadoAcademicoGeneral(this.getOID());
        estadoAcademicoGeneral.addEstadoAcademicoDetallado(agente);
        super.setModificado(true);
    }

    @Override
    public void setCarrera(Carrera carrera) {
        estadoAcademicoGeneral.setCarrera(carrera);
        Agente agente = (Agente) carrera;
        this.OIDcarrera = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setPlanEstudio(PlanEstudio planEstudio) {
        estadoAcademicoGeneral.setPlanEstudio(planEstudio);
        Agente agente = (Agente) planEstudio;
        this.OIDplanEstudio = agente.getOID();
        super.setModificado(true);
    }

    /* GET */ 
    
    @Override
    public Date getFechaBaja() {
        return estadoAcademicoGeneral.getFechaBaja();
    }
    
    @Override
    public Date getFechaIngreso() {
        return estadoAcademicoGeneral.getFechaIngreso();
    }

    @Override
    public Condicion getCondicion() {
        
        if (heBuscadocondicion == true){
            return estadoAcademicoGeneral.getCondicion();
        }
        else{
            Condicion cond = (Condicion) FachadaPersistenciaInterna.getInstancia().buscar("Condicion", OIDcondicion);
            estadoAcademicoGeneral.setCondicion(cond);
            setHeBuscadocondicion(true);
            return cond;
        }
        
    }

    @Override
    public Vector<EstadoAcademicoDetallado> getEstadoAcademicoDetallado() {
        
        if (heBuscadoestadoAcademicoDetallado == true){
            return estadoAcademicoGeneral.getEstadoAcademicoDetallado();
        }
        else{ 
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDEstadoAcademicoGeneral");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<EstadoAcademicoDetallado> estAcadDet = FachadaPersistenciaInterna.getInstancia().buscar("EstadoAcademicoDetallado", criterios);
            int i = estAcadDet.size() - 1;
            while(i>=0){
                estadoAcademicoGeneral.addEstadoAcademicoDetallado(estAcadDet.get(i));
                i = i-1;
            }
            setHeBuscadoestadoAcademicoDetallado(true);
            return estAcadDet;
        }
        
   }

    @Override
    public Carrera getCarrera() {
        
        if (heBuscadocarrera == true){
            return estadoAcademicoGeneral.getCarrera();
        }
        else{
            Carrera carr = (Carrera) FachadaPersistenciaInterna.getInstancia().buscar("Carrera", OIDcarrera);
            estadoAcademicoGeneral.setCarrera(carr);
            setHeBuscadocarrera(true);
            return carr;
        }
        
    }

    @Override
    public PlanEstudio getPlanEstudio() {
        
        if (heBuscadoplanEstudio == true){
            return estadoAcademicoGeneral.getPlanEstudio();
        }
        else{
            PlanEstudio planEst = (PlanEstudio) FachadaPersistenciaInterna.getInstancia().buscar("PlanEstudio", OIDplanEstudio);
            estadoAcademicoGeneral.setPlanEstudio(planEst);
            setHeBuscadoplanEstudio(true);
            return planEst;
        }
        
    }
    
}
