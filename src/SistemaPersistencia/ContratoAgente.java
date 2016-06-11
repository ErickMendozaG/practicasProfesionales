
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ContratoAgente extends Agente implements Contrato{
    
    private ContratoImplementacion contrato;
    
    private String OIDProyectoDeContrato;
    private String OIDPostulacionProyectoCargoDeContrato;
    private String OIDPostulacionDeContrato;
    private boolean heBuscadoProyectoDeContrato;
    private boolean heBuscadoPostulacionProyectoCargoDeContrato;
    private boolean heBuscadoPostulacionDeContrato;
    private boolean heBuscadoEstadosDeContrato;
    
    /* Métodos de la Clase ContratoAgente */

    public void setContrato(ContratoImplementacion contrato) {
        this.contrato = contrato;
    }

    public void setOIDProyectoDeContrato(String OIDProyectoDeContrato) {
        this.OIDProyectoDeContrato = OIDProyectoDeContrato;
    }

    public void setOIDPostulacionProyectoCargoDeContrato(String OIDPostulacionProyectoCargoDeContrato) {
        this.OIDPostulacionProyectoCargoDeContrato = OIDPostulacionProyectoCargoDeContrato;
    }

    public void setOIDPostulacionDeContrato(String OIDPostulacionDeContrato) {
        this.OIDPostulacionDeContrato = OIDPostulacionDeContrato;
    }

    public void setHeBuscadoProyectoDeContrato(boolean heBuscadoProyectoDeContrato) {
        this.heBuscadoProyectoDeContrato = heBuscadoProyectoDeContrato;
    }

    public void setHeBuscadoPostulacionProyectoCargoDeContrato(boolean heBuscadoPostulacionProyectoCargoDeContrato) {
        this.heBuscadoPostulacionProyectoCargoDeContrato = heBuscadoPostulacionProyectoCargoDeContrato;
    }

    public void setHeBuscadoPostulacionDeContrato(boolean heBuscadoPostulacionDeContrato) {
        this.heBuscadoPostulacionDeContrato = heBuscadoPostulacionDeContrato;
    }

    public void setHeBuscadoEstadosDeContrato(boolean heBuscadoEstadosDeContrato) {
        this.heBuscadoEstadosDeContrato = heBuscadoEstadosDeContrato;
    }
   
    public ContratoImplementacion getContrato() {
        return contrato;
    }

    public String getOIDProyectoDeContrato() {
        return OIDProyectoDeContrato;
    }

    public String getOIDPostulacionProyectoCargoDeContrato() {
        return OIDPostulacionProyectoCargoDeContrato;
    }

    public String getOIDPostulacionDeContrato() {
        return OIDPostulacionDeContrato;
    }

    public boolean isHeBuscadoproyectoDeContrato() {
        return heBuscadoProyectoDeContrato;
    }

    public boolean isHeBuscadopostulacionProyectoCargoDeContrato() {
        return heBuscadoPostulacionProyectoCargoDeContrato;
    }

    public boolean isHeBuscadopostulacionDeContrato() {
        return heBuscadoPostulacionDeContrato;
    }

    public boolean isHeBuscadoestadosDeContrato() {
        return heBuscadoEstadosDeContrato;
    }
    
    /* Métodos Implementados de la Interfaz Contrato */   
    
    /* SET */
    
    @Override
    public void setNroContrato(int nroContrato) {
       contrato.setNroContrato(nroContrato);
        super.setModificado(true);
    }

    @Override
    public void setFechaCreacionContrato(Date fechaCreacionContrato) {
        contrato.setFechaCreacionContrato(fechaCreacionContrato);
        super.setModificado(true);
    }
    
    @Override
    public void setHoraCreacionContrato(Time horaCreacionContrato) {
        contrato.setHoraCreacionContrato(horaCreacionContrato);
        super.setModificado(true);
    }

    @Override
    public void setFechaVigenciaDeContrato(Date fechaVigenciaDeContrato) {
        contrato.setFechaVigenciaDeContrato(fechaVigenciaDeContrato);
        super.setModificado(true);
    }

    @Override
    public void setProyectoDeContrato(Proyecto proyectoDeContrato) {
        contrato.setProyectoDeContrato(proyectoDeContrato);
        Agente agente = (Agente) proyectoDeContrato;
        this.OIDProyectoDeContrato = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setPostulacionProyectoCargoDeContrato(PostulacionProyectoCargo postulacionProyectoCargoDeContrato) {
        contrato.setPostulacionProyectoCargoDeContrato(postulacionProyectoCargoDeContrato);
        Agente agente = (Agente) postulacionProyectoCargoDeContrato;
        this.OIDPostulacionProyectoCargoDeContrato = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setPostulacionDeContrato(Postulacion postulacionDeContrato) {
        contrato.setPostulacionDeContrato(postulacionDeContrato);
        Agente agente = (Agente) postulacionDeContrato;
        this.OIDPostulacionDeContrato = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void addEstadosDeContrato(EstadoContrato estadosDeContrato) {
        EstadoContratoAgente agente =(EstadoContratoAgente)estadosDeContrato;
        agente.setOIDContrato(this.getOID());
        contrato.addEstadosDeContrato(agente);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public int getNroContrato() {
        return contrato.getNroContrato();
    }

    @Override
    public Date getFechaCreacionContrato() {
       return contrato.getFechaCreacionContrato();
    }

    @Override
    public Time getHoraCreacionContrato() {
        return contrato.getHoraCreacionContrato();
    }

    @Override
    public Date getFechaVigenciaDeContrato() {
        return contrato.getFechaVigenciaDeContrato();
    }

    @Override
    public Proyecto getProyectoDeContrato() {
        if (heBuscadoProyectoDeContrato == true){
            return contrato.getProyectoDeContrato();
        }
        else{
            Proyecto proy = (Proyecto) FachadaPersistenciaInterna.getInstancia().buscar("Proyecto", OIDProyectoDeContrato);
            contrato.setProyectoDeContrato(proy);
            this.setHeBuscadoProyectoDeContrato(true);
            return proy;
        }
    }

    @Override
    public PostulacionProyectoCargo getPostulacionProyectoCargoDeContrato() {
        if (heBuscadoPostulacionProyectoCargoDeContrato == true){
            return contrato.getPostulacionProyectoCargoDeContrato();
        }
        else{
            PostulacionProyectoCargo postProyCar = (PostulacionProyectoCargo) FachadaPersistenciaInterna.getInstancia().buscar("PostulacionProyectoCargo", OIDPostulacionProyectoCargoDeContrato);
            contrato.setPostulacionProyectoCargoDeContrato(postProyCar);
            this.setHeBuscadoPostulacionProyectoCargoDeContrato(true);
            return postProyCar;
        }
    }

    @Override
    public Postulacion getPostulacionDeContrato() {
        if (heBuscadoPostulacionDeContrato == true){
            return contrato.getPostulacionDeContrato();
        }
        else{
            Postulacion post = (Postulacion) FachadaPersistenciaInterna.getInstancia().buscar("Postulacion", OIDPostulacionDeContrato);
            contrato.setPostulacionDeContrato(post);
            this.setHeBuscadoPostulacionDeContrato (true);
            return post;
        }
    }

    @Override
        public Vector<EstadoContrato> getEstadosDeContrato() {
        if (heBuscadoEstadosDeContrato == true){
            return contrato.getEstadosDeContrato();
        }
        else{ 
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDContrato");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<EstadoContrato> estContrato = FachadaPersistenciaInterna.getInstancia().buscar("EstadoContrato", criterios);
            int i = estContrato.size() - 1;
            while(i>=0){
                contrato.addEstadosDeContrato(estContrato.get(i));
                i = i-1;
            }
            this.setHeBuscadoEstadosDeContrato (true);
            return contrato.getEstadosDeContrato();
        }
    }
    
}
