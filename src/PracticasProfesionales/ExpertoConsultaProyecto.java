
package PracticasProfesionales;

import SistemaPersistencia.Criterio;
import SistemaPersistencia.FachadaPersistencia;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ExpertoConsultaProyecto {
    
    public DTO buscarProyectos(){
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("Proyecto");
        c.setOperador("=");
        c.setValor(null);
        criterios.add(c);
        
        Vector busqueda = FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        
        
        return null;
    }
    
}
