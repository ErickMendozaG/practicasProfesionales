
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

public class PostulacionAgente extends Agente implements Postulacion {
    
    private PostulacionImplementacion postulacion;
    
    private boolean heBuscadoEstadoAcademicoGeneral;
    private boolean heBuscadoEstudiante;
    private boolean heBuscadoPostulacionProyectoCargo;
    private String OIDEstadoAcademicoGeneral;
    private String OIDEstudiante;

    /* Metodos de la Clase PostulacionAgente */
    
    public PostulacionImplementacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(PostulacionImplementacion postulacion) {
        this.postulacion = postulacion;
    }
    
    public void setheBuscadoEstadoAcademicoGeneral(boolean hebuscado ){
        this.heBuscadoEstadoAcademicoGeneral=hebuscado;
    }
    
    public boolean getheBuscadoEstadoAcademicoGeneral(){
        return heBuscadoEstadoAcademicoGeneral;
    }
    
    public void setheBuscadoEstudiante(boolean hebuscado){
        this.heBuscadoEstudiante=hebuscado;
    }
    
    public boolean getheBuscadoEstudiante(){
        return heBuscadoEstudiante;
    }
    
    public void setheBuscadoPostulacionProyectoCargo(boolean hebuscado){
        this.heBuscadoPostulacionProyectoCargo=hebuscado;
    }
    
    public boolean getheBuscadoPostulacionProyectoCargo(){
        return heBuscadoPostulacionProyectoCargo;
    }
    
    public void setOIDEstadoAcademicoGeneral(String oidEstAcaGral){
        this.OIDEstadoAcademicoGeneral=oidEstAcaGral;
    }
    
    public String getOIDEstadoAcademicoGeneral(){
        return OIDEstadoAcademicoGeneral;
    }
    
    public void setOIDEstudiante(String oidEstudiante){
        this.OIDEstudiante=oidEstudiante;
    }
    
    public String getOIDEstudiante(){
        return OIDEstudiante;
    }
 
    /* Métodos Implementados de la Interfaz Postulacion */
    
    /* SET */
    
    @Override
    public void addPostProyCargo(PostulacionProyectoCargo ppc) {
        PostulacionProyectoCargoAgente postPC = (PostulacionProyectoCargoAgente)ppc;
        postPC.setOIDPostulacion(this.getOID());
        postulacion.addPostProyCargo(postPC);
        super.setModificado(true);
    }

    @Override
    public void setEstadoAcademicoGeneral(EstadoAcademicoGeneral estAcaGral) {
        postulacion.setEstadoAcademicoGeneral(estAcaGral);
        Agente agente = (Agente) estAcaGral;
        this.OIDEstadoAcademicoGeneral = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setEstudiante(Estudiante estudiante) {
        postulacion.setEstudiante(estudiante);
        Agente agente = (Agente) estudiante;
        this.OIDEstudiante = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setfechaAnulacionPostulacion(Date fechaAnulacionPostulacion) {
        postulacion.setfechaAnulacionPostulacion(fechaAnulacionPostulacion);
        super.setModificado(true);
    }

    @Override
    public void setfechaPostulacion(Date fechaPostulacion) {
        postulacion.setfechaPostulacion(fechaPostulacion);
        super.setModificado(true);
    }

    @Override
    public void sethoraPostulacion(Time horaPostulacion) {
       postulacion.sethoraPostulacion(horaPostulacion);
        super.setModificado(true);
    }

    @Override
    public void setnroPostulacion(int nroPostulacion) {
       postulacion.setnroPostulacion(nroPostulacion);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public Vector<PostulacionProyectoCargo> getPostProyCargo() {
        
        if (heBuscadoPostulacionProyectoCargo == true){
            return postulacion.getPostProyCargo();
        }
        else{ 
            Vector criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDPostulacion");
            c.setOperador("=");
            c.setValor(this.getOID());
            criterios.add(c);
            Vector<PostulacionProyectoCargo> postProyCar = FachadaPersistenciaInterna.getInstancia().buscar("PostulacionProyectoCargo", criterios);
            int i = postProyCar.size() - 1;
            while(i>=0){
                postulacion.addPostProyCargo(postProyCar.get(i));
                i = i-1;
            }
            this.setheBuscadoPostulacionProyectoCargo(true);
            return postulacion.getPostProyCargo();
        }
        
    }

    @Override
    public EstadoAcademicoGeneral getEstadoAcademicoGeneral() {
        
        if (heBuscadoEstadoAcademicoGeneral == true){
            return postulacion.getEstadoAcademicoGeneral();
        }
        else{
            EstadoAcademicoGeneral estAcGral = (EstadoAcademicoGeneral) FachadaPersistenciaInterna.getInstancia().buscar("EstadoAcademicoGeneral", OIDEstadoAcademicoGeneral);
            postulacion.setEstadoAcademicoGeneral(estAcGral);
            setheBuscadoEstadoAcademicoGeneral(true);
            return estAcGral;
        }
        
    }

    @Override
    public Estudiante getEstudiante() {
        
        if (heBuscadoEstudiante == true){
            return postulacion.getEstudiante();
        }
        else{
            Estudiante est = (Estudiante) FachadaPersistenciaInterna.getInstancia().buscar("Estudiante", OIDEstudiante);
            postulacion.setEstudiante(est);
            this.setheBuscadoEstudiante(true);
            return est;
        }
       
    }

    @Override
    public Date getfechaAnulacionPostulacion() {
        return postulacion.getfechaAnulacionPostulacion();
    }

    @Override
    public Time gethoraPostulacion() {
        return postulacion.gethoraPostulacion();
    }

    @Override
    public int getnroPostulacion() {
       return postulacion.getnroPostulacion();
    } 

    @Override
    public Date getfechaPostulacion() {
        return postulacion.getfechaPostulacion();
    }
    
}
