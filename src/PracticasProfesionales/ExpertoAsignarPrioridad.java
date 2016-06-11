
package PracticasProfesionales;

import SistemaPersistencia.*;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ExpertoAsignarPrioridad {
    
    private Vector<PostulacionProyectoCargo> ppc = new Vector();
    
    public DTO buscarPostulaciones(int legajoE){
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        c.setAtributo("legajo");
        c.setOperador("=");
        c.setValor(legajoE);
        criterios.add(c);
        
        Vector busqueda = FachadaPersistencia.getInstancia().buscar("Estudiante", criterios);
        
        if(busqueda.isEmpty()){
            DTO retorno = new DTO();
            retorno.setExito(false);
            retorno.setDetalleResultado("Error en Estudiante: No existe");
            DTOPostulacion o = new DTOPostulacion();
            o.setNombreProyecto("---");
            o.setNombrecargo("---");
            o.setPrioridad(0);
            return retorno;
        }
        Estudiante estudiante = (Estudiante) busqueda.get(0);
        
        busqueda.clear();
        criterios.clear();
        
        c.setAtributo("Estudiante");
        c.setOperador("=");
        c.setValor(estudiante);
        criterios.add(c);
        
        busqueda = FachadaPersistencia.getInstancia().buscar("Postulacion", criterios);
        
        DTO retorno = new DTO();
        
        if(busqueda.isEmpty()){
            retorno.setExito(false);
            retorno.setDetalleResultado("Error de Postulación: No existe Postulaciones para modificar prioridad");
            return retorno;
        }
        else{
        for(int index=0; index<busqueda.size(); index++){
            
            Postulacion postulacion = (Postulacion) busqueda.get(index);
            
            Vector<PostulacionProyectoCargo> ppc2 =postulacion.getPostProyCargo();
            /*
            for(int i=0; i<ppc2.size(); i++){
                ppc.add(ppc2.get(i));
            }
            */
            
            for(int index2=0; index2<ppc2.size(); index2++){
                
                Vector<EstadoPostulacion> estadoP = ppc2.get(index2).getEstadoPostulacion();
                
                if( estadoP.size() == 1 ){
                    
                    if("Creada".equals(estadoP.get(0).getTipoEstadoPostulacion().getNombreTipoEstadoPostulacion())){
                        
                        ppc.add(ppc2.get(index2));
                        DTOPostulacion dto = new DTOPostulacion();
                        dto.setPrioridad(ppc2.get(index2).getPrioridad());
                        dto.setNombreProyecto(ppc2.get(index2).getProyecto().getNombreProyecto());
                        dto.setNombrecargo(ppc2.get(index2).getProyectoCargo().getCargo().getNombreCargo());
                        retorno.add(dto);
                        
                    }
                }
                
                
            }
            
        }
        }
        if(ppc.size()==0){
            retorno.setExito(false);
            retorno.setDetalleResultado("Error de Postulación: No existe Postulaciones para modificar prioridad");
        }else{
            retorno.setExito(true);
            retorno.setDetalleResultado("Postulaciones Buscadas");
        }
        
        return retorno;
    }
    
    public DTO buscarPostulaciones(int legajoE, DTO asignaciones){
        
        DTO retorno = buscarPostulaciones(legajoE);
        
        if(retorno.isExito() == false){
            retorno.setExito(true);
            retorno.setDetalleResultado("Postulaciones Buscadas");
        }
        
        if(asignaciones.size() != 0){
            for(int i=0; i<asignaciones.size(); i++){

                DTOPostulacion dto = (DTOPostulacion) asignaciones.get(i);
                retorno.add(dto);

            }
            retorno.setExito(true);
        }
        else{
            retorno.setExito(false);
            retorno.setDetalleResultado("Error de Postulación: No existe Postulaciones para modificar prioridad");
        }
        return retorno;
    }
    
    public DTO guardarPrioridades(Vector<DTOPostulacion> dtoPostulacion){
        
        for(int i=0 ; i<ppc.size(); i++){
            
            if(!"Fallida".equals(ppc.get(i).getEstadoPostulacion().get(0).getTipoEstadoPostulacion().getNombreTipoEstadoPostulacion())){
                
                for( int j=0; j<dtoPostulacion.size(); j++){
                    
                    if((ppc.get(i).getProyecto().getNombreProyecto().equals(dtoPostulacion.get(j).getNombreProyecto())) && (ppc.get(i).getProyectoCargo().getCargo().getNombreCargo().equals(dtoPostulacion.get(j).getNombrecargo()))){
                        
                        ppc.get(i).setprioridad(dtoPostulacion.get(j).getPrioridad());
                        FachadaPersistencia.getInstancia().guardar("PostulacionProyectoCargo", ppc.get(i));
                        
                        break; 
                    }
                    
                }
                
                
            }
            
        }
        
        DTO dto = new DTO();
        dto.setExito(true);
        dto.setDetalleResultado("Cambios guardados satisfactoriamente");
        
        return dto;
        
    }
    
    
}
