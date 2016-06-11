
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
public class PostulacionImplementacion implements Postulacion {
    
    private Vector<PostulacionProyectoCargo> postulacionProyCargo = new Vector();
    private EstadoAcademicoGeneral estadoAcademicoGeneral;
    private Estudiante estudiante;
    private Date fechaAnulacionPostulacion;
    private Date fechaPostulacion;
    private Time horaPostulacion;
    private int nroPostulacion;

    @Override
    public void addPostProyCargo(PostulacionProyectoCargo ppc) {
       this.postulacionProyCargo.add(ppc);
    }

    @Override
    public void setEstadoAcademicoGeneral(EstadoAcademicoGeneral estAcaGral) {
        this.estadoAcademicoGeneral=estAcaGral;
    }

    @Override
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante=estudiante;
    }

    @Override
    public void setfechaAnulacionPostulacion(Date fechaAnulacionPostulacion) {
        this.fechaAnulacionPostulacion=fechaAnulacionPostulacion;
    }

    @Override
    public void setfechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion=fechaPostulacion;
    }

    @Override
    public void sethoraPostulacion(Time horaPostulacion) {
        this.horaPostulacion=horaPostulacion;
    }

    @Override
    public void setnroPostulacion(int nroPostulacion) {
        this.nroPostulacion=nroPostulacion;
    }

    @Override
    public Vector<PostulacionProyectoCargo> getPostProyCargo() {
        return this.postulacionProyCargo;
    }

    @Override
    public EstadoAcademicoGeneral getEstadoAcademicoGeneral() {
       return estadoAcademicoGeneral;
    }

    @Override
    public Estudiante getEstudiante() {
       return estudiante;
    }

    @Override
    public Date getfechaAnulacionPostulacion() {
        return fechaAnulacionPostulacion;
    }

    @Override
    public Time gethoraPostulacion() {
       return horaPostulacion;
    }

    @Override
    public int getnroPostulacion() {
       return nroPostulacion;
    }

    @Override
    public Date getfechaPostulacion() {
        return this.fechaPostulacion;
    }
    
}
