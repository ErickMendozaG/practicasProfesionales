
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

public interface Postulacion {
    
    public void addPostProyCargo(PostulacionProyectoCargo ppc);
    public void setEstadoAcademicoGeneral(EstadoAcademicoGeneral estAcaGral);
    public void setEstudiante(Estudiante estudiante);
    public void setfechaAnulacionPostulacion( Date fechaAnulacionPostulacion);
    public void setfechaPostulacion(Date fechaPostulacion);
    public void sethoraPostulacion(Time horaPostulacion);
    public void setnroPostulacion(int nroPostulacion);
 
    public Vector<PostulacionProyectoCargo> getPostProyCargo();
    public EstadoAcademicoGeneral getEstadoAcademicoGeneral();
    public Estudiante getEstudiante();
    public Date getfechaAnulacionPostulacion();
    public Time gethoraPostulacion();
    public int getnroPostulacion();
    public Date getfechaPostulacion();
 
}