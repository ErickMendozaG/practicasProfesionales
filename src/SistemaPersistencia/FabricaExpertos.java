
package SistemaPersistencia;

import PracticasProfesionales.ExpertoAsignarPrioridad;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class FabricaExpertos {
    
    /*Singleton_Inicio*/
    private static FabricaExpertos instancia= new FabricaExpertos();
    private FabricaExpertos(){}
    public static FabricaExpertos getInstancia(){
        return instancia;
    }
    /*Singleton_Fin*/
    
    /*Metodos públicos*/
    public Object obtenerExperto(String nombreExperto){
        
        Object experto = null;
        switch (nombreExperto) {
            case "ExpertoRegistrarPostulacion":
                experto = new DecoradorExpertoRegistrarPostulacion();
                break;
            case "ExpertoAsignarPrioridad":
                experto = new DecoradorExpertoAsignarPrioridad();
                break;
            case "ExpertoConsultarPostulaciones":
                experto = new DecoradorExpertoConsultarPostulaciones();
                break;
            case "ExpertoAsignarPrioridadExtension" :
                experto = new ExpertoAsignarPrioridad();
                break;
        }
        
        return experto;
    }
}
