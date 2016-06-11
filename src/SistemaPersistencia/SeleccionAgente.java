
package SistemaPersistencia;

import java.sql.Time;
import java.util.Date;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class SeleccionAgente extends Agente implements Seleccion {
    
    private SeleccionImplementacion seleccionImplementacion;
    
    private boolean heBuscadoProyecto;
    private boolean heBuscadoSeleccionPostulaccionProyectoCargo;
    private boolean heBuscadoTipoEstadoSeleccion;
    private String OIDProyecto;
    private String OIDTipoEstadoSeleccion;
    
    /* Métodos de la Clase SeleccionAgente */
    
    public SeleccionImplementacion getSeleccionImplementacion() {
        return seleccionImplementacion;
    }

    public void setSeleccion(SeleccionImplementacion seleccionImpl) {
        this.seleccionImplementacion = seleccionImpl;
    }
    
    public boolean isHeBuscadoProyecto() {
        return heBuscadoProyecto;
    }

    public void setHeBuscadoProyecto(boolean heBuscadoProyecto) {
        this.heBuscadoProyecto = heBuscadoProyecto;
    }

    public boolean isHeBuscadoSeleccionPostulaccionProyectoCargo() {
        return heBuscadoSeleccionPostulaccionProyectoCargo;
    }

    public void setHeBuscadoSeleccionPostulaccionProyectoCargo(boolean heBuscadoSeleccionPostulaccionProyectoCargo) {
        this.heBuscadoSeleccionPostulaccionProyectoCargo = heBuscadoSeleccionPostulaccionProyectoCargo;
    }

    public boolean isHeBuscadoTipoEstadoSeleccion() {
        return heBuscadoTipoEstadoSeleccion;
    }

    public void setHeBuscadoTipoEstadoSeleccion(boolean heBuscadoTipoEstadoSeleccion) {
        this.heBuscadoTipoEstadoSeleccion = heBuscadoTipoEstadoSeleccion;
    }

    public String getOIDProyecto() {
        return OIDProyecto;
    }

    public void setOIDProyecto(String OIDProyecto) {
        this.OIDProyecto = OIDProyecto;
    }

    public String getOIDTipoEstadoSeleccion() {
        return OIDTipoEstadoSeleccion;
    }

    public void setOIDTipoEstadoSeleccion(String OIDTipoEstadoSeleccion) {
        this.OIDTipoEstadoSeleccion = OIDTipoEstadoSeleccion;
    }
    
    /* Métodos de la Interfaz */
    
    /* SET */
    
    @Override
    public void addSeleccionPostProyCargo(SeleccionPostulacionProyectoCargo sppc) {
        SeleccionPostulacionProyectoCargoAgente agente= (SeleccionPostulacionProyectoCargoAgente)sppc;
        agente.setOIDSelecion(this.getOID());
        this.seleccionImplementacion.addSeleccionPostProyCargo(agente);
        super.setModificado(true);
    }

    @Override
    public void setFechaSeleccion(Date fechaSeleccion) {
        this.seleccionImplementacion.setFechaSeleccion(fechaSeleccion);
        super.setModificado(true);
    }

    @Override
    public void setHoraSeleccion(Time horaSeleccion) {
        this.seleccionImplementacion.setHoraSeleccion(horaSeleccion);
        super.setModificado(true);
    }

    @Override
    public void setNroSeleccion(int nroSeleccion) {
        this.seleccionImplementacion.setNroSeleccion(nroSeleccion);
        super.setModificado(true);
    }

    @Override
    public void setProyecto(Proyecto proyecto) {
        Agente agente= (Agente)proyecto;
        this.OIDProyecto = agente.getOID();
        this.seleccionImplementacion.setProyecto(proyecto);
        super.setModificado(true);
    }

    @Override
    public void setTipoEstadoSeleccion(TipoEstadoSeleccion tipoEstSeleccion) {
        Agente agente= (Agente)tipoEstSeleccion;
        this.OIDTipoEstadoSeleccion = agente.getOID();
        this.seleccionImplementacion.setTipoEstadoSeleccion(tipoEstSeleccion);
        super.setModificado(true);
    }

    /* GET */
    @Override
    public Vector<SeleccionPostulacionProyectoCargo> getSeleccionPostulacionProyectoCargo() {
        
        if( heBuscadoSeleccionPostulaccionProyectoCargo==true){
            return this.seleccionImplementacion.getSeleccionPostulacionProyectoCargo();
        }
        else{
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDSeleccion");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<SeleccionPostulacionProyectoCargo> seleccionPPC = FachadaPersistenciaInterna.getInstancia().buscar("SeleccionPostulacionProyectoCargo", criterios);
            int i = seleccionPPC.size() - 1;
            while(i>=0){
                seleccionImplementacion.addSeleccionPostProyCargo(seleccionPPC.get(i));
                i = i-1;
            } 
            this.heBuscadoSeleccionPostulaccionProyectoCargo = true;
            return this.seleccionImplementacion.getSeleccionPostulacionProyectoCargo();
        }
        
    }

    @Override
    public Date getFechaSeleccion() {
       return this.seleccionImplementacion.getFechaSeleccion();
    }

    @Override
    public Time getHoraSeleccion() {
       return this.seleccionImplementacion.getHoraSeleccion();
    }

    @Override
    public int getNroSeleccion() {
       return this.seleccionImplementacion.getNroSeleccion();
    }

    @Override
    public Proyecto getProyecto() {
        
        if(heBuscadoProyecto=true){
            return this.seleccionImplementacion.getProyecto();  
        }
        else{
            Proyecto proy;
            proy=(Proyecto)FachadaPersistenciaInterna.getInstancia().buscar("Proyecto", OIDProyecto);
            seleccionImplementacion.setProyecto(proy);
            this.heBuscadoProyecto=true;
            return proy;
        } 
        
    }

    @Override
    public TipoEstadoSeleccion getTipoEstadoSeleccion() {
        
        if(heBuscadoTipoEstadoSeleccion=true){
         return  this.seleccionImplementacion.getTipoEstadoSeleccion();   
        }
        else{
            TipoEstadoSeleccion tipoEstSelec;
            tipoEstSelec=(TipoEstadoSeleccion)FachadaPersistenciaInterna.getInstancia().buscar("TipoEstadoSeleccion", OIDTipoEstadoSeleccion);
            seleccionImplementacion.setTipoEstadoSeleccion( tipoEstSelec);
            this.heBuscadoTipoEstadoSeleccion=true;
            return tipoEstSelec;
        }
        
    }
    
}
