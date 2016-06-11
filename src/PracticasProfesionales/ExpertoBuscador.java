
package PracticasProfesionales;

import SistemaPersistencia.Carrera;
import SistemaPersistencia.Criterio;
import SistemaPersistencia.Empresa;
import SistemaPersistencia.EstadoProyecto;
import SistemaPersistencia.FachadaPersistencia;
import SistemaPersistencia.PlanEstudio;
import SistemaPersistencia.Proyecto;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ExpertoBuscador {
    
    public DTO buscarProyectos(){
        
        DTO dto = new DTO();
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        
        c.setAtributo("Proyecto");
        c.setOperador("=");
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        for(int i=0; i<v.size(); i++){
            
            Proyecto proyecto = (Proyecto)v.get(i);
            
            DTOProyectoBuscados d = new DTOProyectoBuscados();
            d.setNombreProyecto(proyecto.getNombreProyecto());
            
            int cantidadEstados = proyecto.getEstadoproyecto().size();
            
            switch(cantidadEstados){
                
                case 1:
                    d.setEstado("Creado");
                    break;
                case 2:
                    Vector<EstadoProyecto> est = proyecto.getEstadoproyecto();
                    for(int j=0; j<est.size(); j++){
                        if("Abierto a las Postulaciones".equals(est.get(j).getTipoEstadoProyecto().getNombreTipoEstadoProyecto())){
                            d.setEstado("Abierto a las Postulaciones");
                        }
                        if("Suspendido a las Postulaciones".equals(est.get(j).getTipoEstadoProyecto().getNombreTipoEstadoProyecto())){
                            d.setEstado("Suspendido a las Postulaciones");
                        }
                        if("Anulado".equals(est.get(j).getTipoEstadoProyecto().getNombreTipoEstadoProyecto())){
                            d.setEstado("Anulado");
                        }
                    }
                    break;
                case 3:
                    d.setEstado("Cerrado a las Postulaciones");
                    break;
                case 4:
                    d.setEstado("Confirmado");
                    break;
            }
            dto.add(d);
        }
        
        return dto;
    }
    
    public DTO buscarEmpresas(){
        
        DTO dto = new DTO();
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        
        c.setAtributo("Empresa");
        c.setOperador("=");
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("Empresa", criterios);
        
        for(int i=0; i<v.size(); i++){
            
            Empresa empresa = (Empresa)v.get(i);
            
            DTOEmpresaBuscados d = new DTOEmpresaBuscados();
            d.setNombreEmpresa(empresa.getRazonSocial());
            d.setEstado(empresa.getSituacionFiscalDeEmpresa().getNombreSituacionFiscal());
            if(FechaHora.getInstancia().estaVigente(empresa.getFechaFinVigenciaEmpresa())==true){
                
                d.setVigente("Empresa Vigente");
            }
            else{
                d.setVigente("Empresa no Vigente");
            }
            
            dto.add(d);
        }
        
        return dto;
    }
    
    public DTO buscarCarreras(){
        
        DTO dto = new DTO();
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        
        c.setAtributo("Carrera");
        c.setOperador("=");
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("Carrera", criterios);
        
        for(int i=0; i<v.size(); i++){
            
            Carrera carrera = (Carrera)v.get(i);
            
            DTOCarreraBuscadas d = new DTOCarreraBuscadas();
            d.setNombreCarrera(carrera.getNombreCarrera());
            if(FechaHora.getInstancia().estaVigente(carrera.getFechaFinVigenciaCarrera())==true){
                
                d.setEstado("Carrera Vigente");
            }
            else{
                d.setEstado("Carrera no Vigente");
            }
            
            dto.add(d);
        }
        
        return dto;
    }
    
    public DTO buscarPlanEstudio(){
        
        DTO dto = new DTO();
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        
        c.setAtributo("PlanEstudio");
        c.setOperador("=");
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("PlanEstudio", criterios);
        
        for(int i=0; i<v.size(); i++){
            
            PlanEstudio planEstudio = (PlanEstudio)v.get(i);
            
            DTOPlanEstudioBuscados d = new DTOPlanEstudioBuscados();
            d.setNombrePlanEstudio(planEstudio.getNombrePlanEstudio());
            if(FechaHora.getInstancia().estaVigente(planEstudio.getFechaFinVigenciaPlanEstudio())==true){
                
                d.setEstado("Plan de Estudio Vigente");
            }
            else{
                d.setEstado("Plan de Estudio no Vigente");
            }
            
            dto.add(d);
        }
        
        return dto;
    }
    
}
