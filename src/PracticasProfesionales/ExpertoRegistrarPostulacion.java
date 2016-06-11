
package PracticasProfesionales;

import SistemaPersistencia.*;
import java.util.Vector;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class ExpertoRegistrarPostulacion {
    
    private Postulacion postulacionNueva = (Postulacion) FabricaEntidades.getInstancia().obtenerEntidad("Postulacion");
    private Universidad universidadInstanciada;

    public Postulacion getPostulacionNueva() {
        return postulacionNueva;
    }

    public void setPostulacionNueva(Postulacion postulacionNueva) {
        this.postulacionNueva = postulacionNueva;
    }

    public Universidad getUniversidadInstanciada() {
        return universidadInstanciada;
    }

    public void setUniversidadInstanciada(Universidad universidadInstanciada) {
        this.universidadInstanciada = universidadInstanciada;
    }
    
    public DTO buscarTiposDeDocumentos(String universidadI){
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        /* Busca la Universidad instanciada que se pasó como parámetro */
        c.setAtributo("nombreUniversidad");
        c.setOperador("=");
        c.setValor(universidadI);
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("Universidad", criterios);
        
        this.universidadInstanciada = (Universidad) v.get(0);
        
        criterios.clear();
        
        c.setAtributo("TipoDocumento");
        c.setOperador("=");
        c.setValor(null);
        criterios.add(c);
        
        /* Busca todos los Tipos de Documentos en la BD */
        Vector<TipoDocumento> busqueda = FachadaPersistencia.getInstancia().buscar("TipoDocumento", criterios);
        
        DTO dto = new DTO();
        
        if(busqueda.isEmpty()){ 
            /*Error si no encontró nada en la BD*/
            dto.setExito(false);
            dto.setDetalleResultado("No se encontró ningún Tipo de Documento: Por favor informar al Administrador");
        }
        else{
            
            /* Se setea el éxito de la busqueda de los Tipos de Documento */
            dto.setExito(true);
            dto.setDetalleResultado("Tipos de Documentos buscados");
            
            /* Por cada Tipo de Documento encontrado se crea un DTOTipoDocumento y se le setean los datos de cada TipoDocumento */
            for (int i=0; i<busqueda.size(); i++){
                DTOTipoDocumento tipoD = new DTOTipoDocumento();
                tipoD.setNroTipoDocumento(busqueda.get(i).getNroTipoDocumento());
                tipoD.setNombreTipoDocumento(busqueda.get(i).getNombreTipoDocumento());
                dto.add(tipoD);
            }
        }
        return dto;
    }
    
    public DTO buscarProyecto(int nroDocumento, String tipoDocumento){
        
        DTO dto = new DTO();
        /* Se crea el criterio de la Universidad */
        Criterio universidadCriterio = new Criterio();
        universidadCriterio.setAtributo("Universidad");
        universidadCriterio.setOperador("=");
        universidadCriterio.setValor(this.universidadInstanciada);
        
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        c.setAtributo("nombreTipoDocumento");
        c.setOperador("=");
        c.setValor(tipoDocumento);
        criterios.add(c);
        
        /* Se busca en la BD el TipoDocumento ingresado */
        Vector busqueda = FachadaPersistencia.getInstancia().buscar("TipoDocumento", criterios);
        
        TipoDocumento tipoD = (TipoDocumento) busqueda.get(0);
        
        criterios.clear();
        busqueda.clear();
        
        c.setAtributo("nroDocumento");
        c.setOperador("=");
        c.setValor(nroDocumento);
        criterios.add(c);
        Criterio c2 = new Criterio();
        c2.setAtributo("tipoDocumento");
        c2.setOperador("=");
        c2.setValor(tipoD);
        criterios.add(c2);
        criterios.add(universidadCriterio);  
        
        /* Se busca en la BD al Estudiante con el TipoDocumento y el nro de Documento ingresado */
        busqueda = FachadaPersistencia.getInstancia().buscar("Estudiante", criterios);
        
        if(busqueda.size() != 1){ 
            /* Se setea error si no hay exactamente un estudiante con los datos y retorna el DTO*/
            dto.setExito(false);
            dto.setDetalleResultado("Error en Estudiante: Por favor comuníquese con el Administrador");
            return dto;
        }
        
        Estudiante estudiante = (Estudiante) busqueda.get(0);
        
        /* Se verifica que la Universidad del Estudiante esté vigente */
        if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(estudiante.getUniversidadDeEstudiante().getFechaFinVigenciaUniversidad()) == false){
            /* Se setea error si la Universidad del Estudiante no está vigente y retorna el DTO*/
            dto.setExito(false);
            dto.setDetalleResultado("Error en Estudiante: La Universidad del Estudiante no se encuentra Disponible");
            return dto;
        }
        
        this.postulacionNueva.setEstudiante(estudiante);
        
        criterios.clear();
        busqueda.clear();
        
        c.setAtributo("Estudiante");
        c.setOperador("=");
        c.setValor(estudiante);
        criterios.add(c);
        
        /* Se busca en la BD todas las Postulaciones del Estudiante buscado */
        busqueda = FachadaPersistencia.getInstancia().buscar("Postulacion", criterios);
        
        /* Por cada Postulación encontrada */
        for(int i=0 ; i<busqueda.size() ; i++){
            
            Postulacion historialP = (Postulacion)busqueda.get(i);
            /* Se obtiene las PostulacionProyectoCargo */
            Vector<PostulacionProyectoCargo> ppC = historialP.getPostProyCargo();
            /* Por cada PostulaciónProyectoCargo */
            for(int j=0 ; j<ppC.size() ; j++){
                
                /* Se obtiene los estados de la PostulacionProyectoCargo */
                Vector<EstadoPostulacion> estadoP = ppC.get(j).getEstadoPostulacion();
                /* Por cada EstadoPostulación */
                for(int z=0 ; z<estadoP.size() ; z++){
                    
                    /* Si el TipoEstadoPostulacion es igual a "Aceptada" */
                    if("Aceptada".equals(estadoP.get(z).getTipoEstadoPostulacion().getNombreTipoEstadoPostulacion())){
                        /* Se setea error en el DTO y se devuelve */
                        dto.setExito(false);
                        dto.setDetalleResultado("Error en Postulación: Postulación Aceptada, no se puede postular");
                        return dto;
                        
                    }
                    
                }
                
            }
            
        }
        
        /* Se comunica con el Sistema Académico de la Universidad del Estudiante*/
        IAdaptadorUniversidad adaptador = FabricaAdaptadorUniversidad.getInstancia().obtenerAdaptadorUniversidad(this.universidadInstanciada);
        
        /* Se solicita el EstadoAcademicoGeneral del Estudiante con el nroDocumento y el tipoDocumento ingresados */
        Vector<DTOEstadoAcademicoGeneral> dtoEAG = new Vector();
        try{
            dtoEAG= adaptador.obtenerEstadoAcademicoGeneral(nroDocumento, tipoDocumento);
        }
        catch(Exception e){
            dto.setExito(false);
            dto.setDetalleResultado("Error al obtener el Estado Académico General: Por favor comuníquese con el Administrador");
            return dto;
        }
        
        
        
        if(dtoEAG.isEmpty()){
            /* Si no se devuelve nada se setea error al DTO y se devuelve */
            dto.setExito(false);
            dto.setDetalleResultado("Error al obtener el Estado Académico General: Por favor comuníquese con el Administrador");
            return dto;
        }
        
        /* Por cada DTOEstadoAcademicoGeneral */
        for(int i=0 ; i<dtoEAG.size() ; i++){
            
            /* Si el estadoAcadémico del EstadoAcademicoGeneral es Regular */
            if("Regular".equals(dtoEAG.get(i).getEstadoAcademico())){
                
                /* Se crea un EstadoAcademicoGeneral */
                EstadoAcademicoGeneral nuevoEstAcadGeneral = (EstadoAcademicoGeneral)FabricaEntidades.getInstancia().obtenerEntidad("EstadoAcademicoGeneral");
                
                criterios.clear();
                busqueda.clear();
                
                c.setAtributo("nombreCondicion");
                c.setOperador("=");
                c.setValor("Regular");
                criterios.add(c);
                
                busqueda = FachadaPersistencia.getInstancia().buscar("Condicion", criterios);
                
                /* Se setea la condición 'Regular' en el EstadoAcademicoGeneral */
                nuevoEstAcadGeneral.setCondicion((Condicion)busqueda.get(0));
                
                criterios.clear();
                busqueda.clear();
                
                c.setAtributo("nombreCarrera");
                c.setOperador("=");
                c.setValor(dtoEAG.get(i).getCarrera());
                criterios.add(c);
                
                /* Se buscan las Carreras con el nombre de la Carrera del EstadoAcademicoGeneral recibido*/
                busqueda = FachadaPersistencia.getInstancia().buscar("Carrera", criterios);
                
                /* Por cada Carrera buscada */
                for(int ii=0; ii<busqueda.size(); ii++){
                    
                    Carrera carrera = (Carrera)busqueda.get(ii);
                    Universidad uniCarrera = carrera.getUniversidadDeCarrera();
                    boolean iguales = false;
                    
                    if(universidadInstanciada.getNombreUniversidad().equals(uniCarrera.getNombreUniversidad())){
                        iguales = true;
                    }
                    
                    /* Se verifica que la Carrera buscada esté Vigente y sea de  la Universidad */
                    if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(carrera.getFechaFinVigenciaCarrera()) && iguales){
                        /* Se setea la carrera del EstadoAcademicoGeneral recibido en el EstadoAcademicoGeneral nuevo */
                        nuevoEstAcadGeneral.setCarrera(carrera);
                        break;
                    }
                    else if(ii == busqueda.size()-1){
                        /* Si no se devuelve nada se setea error al DTO y se devuelve */
                        dto.setExito(false);
                        dto.setDetalleResultado("Error en Estudiante: La Carrera del Estudiante no se encuentra Disponible");
                        return dto;
                    }
                }
                
                criterios.clear();
                busqueda.clear();
                
                c.setAtributo("nombrePlanEstudio");
                c.setOperador("=");
                c.setValor(dtoEAG.get(i).getPlanEstudio());
                criterios.add(c);
                
                /* Se buscan los PlanEstudio con el nombre de la Carrera del EstadoAcademicoGeneral recibido*/
                busqueda = FachadaPersistencia.getInstancia().buscar("PlanEstudio", criterios);
                
                /* Por cada PlanEstudio buscado */
                for(int ii=0; ii<busqueda.size(); ii++){
                    
                    PlanEstudio planEstudio = (PlanEstudio)busqueda.get(i);
                
                    /* Se verifica que el PlanEstudio buscada esté Vigente */
                    if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(planEstudio.getFechaFinVigenciaPlanEstudio())){
                        /* Se setea el PlanEstudio del EstadoAcademicoGeneral recibido en el EstadoAcademicoGeneral nuevo */
                        nuevoEstAcadGeneral.setPlanEstudio(planEstudio);
                        break;
                    }
                    else if(ii == busqueda.size()-1){
                        /* Si no se devuelve nada se setea error al DTO y se devuelve */
                        dto.setExito(false);
                        dto.setDetalleResultado("Error en Estudiante: El PlanEstudio del Estudiante no se encuentra Disponible");
                        return dto;
                    }
                }
                
                /* Se setea la fechaBaja del EstadoAcademicoGeneral recibido en el EstadoAcademicoGeneral nuevo */
                nuevoEstAcadGeneral.setFechaBaja(dtoEAG.get(i).getFechaBaja());
                
                /* Se setea la fechaIngreso del EstadoAcademicoGeneral recibido en el EstadoAcademicoGeneral nuevo */
                nuevoEstAcadGeneral.setFechaIngreso(dtoEAG.get(i).getFechaIngreso());
                
                /* Se guarda el nuevo EstadoAcademicoGeneral */
                FachadaPersistencia.getInstancia().guardar("EstadoAcademicoGeneral", nuevoEstAcadGeneral);
                
                /* Se solicita al Sistema Académico de la Universidad el EstadoAcademicoDetallado con el legajo */
                Vector<DTOEstadoAcademicoDetallado> dtoEAD = adaptador.obtenerEstadoAcademicoDetallado(dtoEAG.get(i).getLegajo());
                
                /* Por cada EstadoAcademicoDetallado recibido */
                for(int j=0 ; j<dtoEAD.size() ; j++){
                    
                    /* Se crea un nuevo EstadoAcademicoDetallado */
                    EstadoAcademicoDetallado nuevoEstAcadDetallado = (EstadoAcademicoDetallado) FabricaEntidades.getInstancia().obtenerEntidad("EstadoAcademicoDetallado");
                    
                    /* Se setea la fechaEstado del EstadoAcademicoDetallado recibido al nuevo EstadoAcademicoDetallado */
                    nuevoEstAcadDetallado.setFechaEstado(dtoEAD.get(j).getFechaEstado());
                    
                    /* Se setea la notaFinal del EstadoAcademicoDetallado recibido al nuevo EstadoAcademicoDetallado */
                    nuevoEstAcadDetallado.setNotaFinal(dtoEAD.get(j).getNotaFinal());
                    
                    criterios.clear();
                    busqueda.clear();

                    c.setAtributo("nombreEstadoMateria");
                    c.setOperador("=");
                    c.setValor(dtoEAD.get(j).getEstado());
                    criterios.add(c);

                    busqueda = FachadaPersistencia.getInstancia().buscar("EstadoMateria", criterios);
                    
                    /* Se setea el estadoMateria del EstadoAcademicoDetallado recibido al nuevo EstadoAcademicoDetallado */
                    nuevoEstAcadDetallado.setEstadoMateria((EstadoMateria)busqueda.get(0));
                    
                    criterios.clear();
                    busqueda.clear();

                    c.setAtributo("nombreMateria");
                    c.setOperador("=");
                    c.setValor(dtoEAD.get(j).getMateria());
                    criterios.add(c);

                    /* Se buscan las Materia con el nombre de la Materia del EstadoAcademicoDetallado recibido*/
                    busqueda = FachadaPersistencia.getInstancia().buscar("Materia", criterios);
                    
                    /* Por cada Materia buscada */
                    for(int ii=0; ii<busqueda.size(); ii++){
                        
                        Materia materia = (Materia)busqueda.get(ii);
                        /* Se verifica que la Materia buscada esté Vigente */
                        if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(materia.getFechaFinVigenciaMateria())){
                            /* Se setea la Materia del EstadoAcademicoDetallado recibido al nuevo EstadoAcademicoDetallado */
                            nuevoEstAcadDetallado.setMateria((Materia)busqueda.get(0));
                            break;
                        }
                        else if(ii == busqueda.size()-1){
                            /* Si no se devuelve nada se setea error al DTO y se devuelve */
                            dto.setExito(false);
                            dto.setDetalleResultado("Error en Estudiante: La Materia "+materia.getNombreMateria()+" del Estudiante no se encuentra Disponible");
                            return dto;
                        }
                    }
                    
                    /* Se agrega el nuevo EstadoAcademicoDetallado al nuevo EstadoAcademicoGeneral */
                    nuevoEstAcadGeneral.addEstadoAcademicoDetallado(nuevoEstAcadDetallado);
                    
                    /* Se guarda el nuevo EstadoAcademicoDetallado */
                    FachadaPersistencia.getInstancia().guardar("EstadoAcademicoDetallado", nuevoEstAcadDetallado);
                    
                }
                
                /* Se setea a la nueva Postulacion el nuevo EstadoAcademicoGeneral */
                this.postulacionNueva.setEstadoAcademicoGeneral(nuevoEstAcadGeneral);
                
                break;
            }
            
            /* Sino si es el último EstadoAcademicoGeneral y no es egular */
            else if(i == (dtoEAG.size()-1)){
                /* Se setea error y se develve */
                dto.setExito(false);
                dto.setDetalleResultado("Error en Estado Académico General: No existe un Estado Académico regular");
                return dto;
            }
            
        }
        
        /* Fin Guardar el Estado Academico */
        
        criterios.clear();
        busqueda.clear();
        
        criterios.add(universidadCriterio);
        
        /* Se buscan en la BD todos los Proyecto de la Universidad del Estudiante */
        busqueda = FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        /* Por cada Proyecto */
        for(int i=0 ; i<busqueda.size() ; i++){
            
            Proyecto proyecto = (Proyecto) busqueda.get(i);
            
            /* Se obtienen los estados del Proyecto */
            Vector<EstadoProyecto> estadoP = proyecto.getEstadoproyecto();
            
            /* Si el Proyecto tiene dos EstadoProyecto */
            if(estadoP.size() == 2){
                
                /* Si alguno de los EstadoProyecto es del TipoEstadoProyecto == "Abierto a las Postulaciones" */
                if("Abierto a las Postulaciones".equals(estadoP.get(0).getTipoEstadoProyecto().getNombreTipoEstadoProyecto()) || "Abierto a las Postulaciones".equals(estadoP.get(1).getTipoEstadoProyecto().getNombreTipoEstadoProyecto()) ){
                    
                    /* Se obtiene la Empresa del proyecto */
                    /* Si la SituacionFiscal de la Empresa es "Sin Deuda" Y la Empresa está vigente en nuestra BD */
                    if("Sin Deuda".equals(proyecto.getEmpresa().getSituacionFiscalDeEmpresa().getNombreSituacionFiscal()) && PracticasProfesionales.FechaHora.getInstancia().estaVigente(proyecto.getEmpresa().getFechaFinVigenciaEmpresa()) ){
                        
                        /* Se crea un DTOProyecto */
                        DTOProyecto dtoP = new DTOProyecto();
                        
                        /* Se setea el nroProyecto, nombreProyecto, domicilio de la Empresa, la fechaInicioInscripcion, fechaInicioProyecto, fechaLimittePostulacion, razonSocial y tiempoDuracion al nuevo DTOProyecto */
                        dtoP.setNroProyecto(proyecto.getNroProyecto());
                        dtoP.setNombreProyecto(proyecto.getNombreProyecto());
                        dtoP.setDomicilioEmpresa(proyecto.getEmpresa().getDomicilioEmpresa());
                        dtoP.setFechaInicioInspcripcion(proyecto.getFechaInicioInscripcion());
                        dtoP.setFechaInicioProyecto(proyecto.getFechaInicioProyecto());
                        dtoP.setFechaLimitePostulacion(proyecto.getFechaLimiteDePostulacion());
                        dtoP.setRazonSocial(proyecto.getEmpresa().getRazonSocial());
                        dtoP.setTiempoDuracion(proyecto.getTiempoDuracionProyecto());
                        
                        /* Se obtienen los proyectoCargo */
                        Vector<ProyectoCargo> proyectoCargo = proyecto.getProyectoCargo();
                        
                        /* Por cada ProyectoCargo */
                        for(int j=0 ; j<proyectoCargo.size() ; j++){
                            
                            /* Si el Cargo del ProyectoCargo está vigente */
                            if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(proyectoCargo.get(j).getCargo().getFechaFinVigencia())==true){
                            
                                /* Si la universidad del Cargo del ProyectoCargo es igual a la UniversidadInstanciada*/
                                if(proyectoCargo.get(j).getCargo().getUniversidadDeCargo().getNombreUniversidad().equals(this.universidadInstanciada.getNombreUniversidad())){
                                    
                                    /* Se crea un nuevo DTOProyectoCargo */
                                    DTOProyectoCargo dtoPC = new DTOProyectoCargo();
                                    /* Se setean al nuevo DTOProyectoCargo el nroCargo, nombreCargo, cantidadPuestos y horasEstimadas */
                                    dtoPC.setNroCargo(proyectoCargo.get(j).getCargo().getNroCargo());
                                    dtoPC.setNombrecargo(proyectoCargo.get(j).getCargo().getNombreCargo());
                                    dtoPC.setCantidadPuestos(proyectoCargo.get(j).getCantPuestos());
                                    dtoPC.setHorasEstimadas(proyectoCargo.get(j).getHorasEstimadas());

                                    /* Se obtienen los ProyectoCargoCarrera */
                                    Vector<ProyectoCargoCarrera> pcc = proyectoCargo.get(j).getProyectoCargoCarrera();

                                    /* Por cada ProyectoCargoCarrera */
                                    for(int z=0 ; z<pcc.size() ; z++){

                                        /* Si la Carrera del ProyectoCargoCarrera está vigente */
                                        if(PracticasProfesionales.FechaHora.getInstancia().estaVigente(pcc.get(z).getCarrera().getFechaFinVigenciaCarrera()) == true){

                                            /* Se crea un nuevo DTORequisitosPorCarrera */
                                            DTORequisitosPorCarrera dtoRPC = new DTORequisitosPorCarrera();
                                            /* Se setean al nuevo DTORequisitosPorCarrera el nroCarrera, nombreCarrera, canMateriagReg y cantMateriasRend */
                                            dtoRPC.setNroCarrera(pcc.get(z).getCarrera().getNroCarrera());
                                            dtoRPC.setNombreCarrera(pcc.get(z).getCarrera().getNombreCarrera());
                                            dtoRPC.setCantidadMateriasRegulares(pcc.get(z).getCantMateriasReg());
                                            dtoRPC.setCantidadMateriasRendidas(pcc.get(z).getCantMateriasRend());
                                            /* Se agrega el nuevo DTORequisitosPorCarera al DTOProyectoCargo */
                                            dtoPC.addDtoRequisitosPorCarrera(dtoRPC);

                                        }/* Fin ProyectoCargoCarrera */

                                    } 
                                    /* Se agrega el nuevo DTOProyectoCargo al DTOProyecto*/
                                    dtoP.addDtoProyectoCargo(dtoPC);
                                }
                                
                            }/* Fin si el cargo está vigente */
                            
                        }/*Fin ProyectoCargo */
                        
                        /* Se agrega el nuevo DTOProyecto al DTO */
                        dto.add(dtoP);
                        
                    }/* Fin Si la SituacionFiscal es 'Sin deuda'*/
                    
                }/* Fin si el estado es "Abierto a las Postulaciones"*/
                
            }/* Fin si el proyecto tiene 2 estados actuales */
            
        }/* Fin por cada Proyecto encontrado */
        
        /*Se setea el exito al dto y retorna*/
        dto.setExito(true);
        dto.setDetalleResultado("Proyectos Buscados satisfactoriamente");
        
        return dto;
        
    }
    
    public DTO enviarPostulacion(String nombreCargoSeleccionado, int nroProyectoSeleccionado){
        
        /* Se crea una nueva PostulacionProyectoCargo */
        PostulacionProyectoCargo ppcNueva = (PostulacionProyectoCargo) FabricaEntidades.getInstancia().obtenerEntidad("PostulacionProyectoCargo");
        /* Se crea un nuevo EstadoPostulacion */
        EstadoPostulacion estadoPNueva = (EstadoPostulacion) FabricaEntidades.getInstancia().obtenerEntidad("EstadoPostulacion");
        
        /* Se le setea prioridad 0 a la nueva PostulacionProyectoCargo  */
        ppcNueva.setprioridad(0);
        
        DTO dto = new DTO();
        
        Vector<Criterio> criterios = new Vector();
        Vector busqueda;
        
        Criterio c = new Criterio();
        c.setAtributo("Estudiante");
        c.setOperador("=");
        c.setValor(postulacionNueva.getEstudiante());
        criterios.add(c);
        
        /* Se busca en la BD todas las Postulaciones del Estudiante */
        busqueda = FachadaPersistencia.getInstancia().buscar("Postulacion", criterios);
        
        /* Por cada Postulación encontrada */
        for(int i=0 ; i<busqueda.size() ; i++){
            
            Postulacion historialPostulacion = (Postulacion) busqueda.get(i);
            
            /* Se obtiene las PostulaciónProyectoCargo */
            Vector<PostulacionProyectoCargo> ppc = historialPostulacion.getPostProyCargo();
            
            /* Por cada PostulaciónProyectoCargo */
            for(int j=0 ; j<ppc.size() ; j++){
                
                /* Se verifica si el nroProyecto es igual al nroProyecto ingresado */
                
                if(ppc.get(j).getProyecto().getNroProyecto() == nroProyectoSeleccionado){
                    /* Si es igual se verifica si el nombre del Cargo es igual al nombre del cargo ingresado */
                    if(ppc.get(j).getProyectoCargo().getCargo().getNombreCargo().equals(nombreCargoSeleccionado)){
                        
                        /* Si es verdadero se Registra la Postulación fallida, setea en el DTO error con su detalle y se devuelve */
                        ppcNueva.setProyecto(ppc.get(j).getProyecto());
                        ppcNueva.setProyectoCargo(ppc.get(j).getProyectoCargo());

                        criterios.clear();
                        c.setAtributo("nombreTipoEstadoPostulacion");
                        c.setOperador("=");
                        c.setValor("Fallida");
                        criterios.add(c);

                        Vector<TipoEstadoPostulacion> tep = FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);

                        /* Se le setea el TipoEstadoPostulacion "Creada" al nuevo EstadoPostulacion */
                        estadoPNueva.setTipoEstadoPostulacion(tep.get(0));

                        /* Se le setea la fecha y hora actual al nuevo EstadoPostulacion */
                        estadoPNueva.setFechaEstadoPostulacion(FechaHora.getInstancia().obtenerFechaActual());
                        estadoPNueva.setHoraEstadoPostulacion(FechaHora.getInstancia().obtenerHoraActual());

                        /* Se le agrega a al nueva PostulacionProyectoCargo el nuevo EstadoPostulacion */
                        ppcNueva.addEstadoPostulacion(estadoPNueva);

                        /* Se le agrega a la nueva Postulacion la nueva PostulacionProyectoCargo */
                        postulacionNueva.addPostProyCargo(ppcNueva);
                        
                        dto.setExito(false);
                        dto.setDetalleResultado("Ya se registró una postulación al mismo Cargo del mismo Proyecto");
                        
                        return dto;
                        
                    }
                    
                }
                
            }
            
        }
        
        /* Se obtiene las PostulacionProyectoCargo de la nueva Postulacion */
        Vector<PostulacionProyectoCargo> ppcRegistrados = postulacionNueva.getPostProyCargo();
        
        /* Por cada PostulacionProyectoCargo */
        for(int i=0 ; i<ppcRegistrados.size() ; i++){
            
            /* Se verifica si el nroProyecto es igual al nroProyecto ingresado */
            if(ppcRegistrados.get(i).getProyecto().getNroProyecto() == nroProyectoSeleccionado){
                
                /* Si es igual se verifica si el nombre del Cargo es igual al nombre del cargo ingresado */
                if(ppcRegistrados.get(i).getProyectoCargo().getCargo().getNombreCargo().equals(nombreCargoSeleccionado)){
                    
                    /* Si es verdadero se Registra la Postulación fallida, setea en el DTO error con su detalle y se devuelve */
                    ppcNueva.setProyecto(ppcRegistrados.get(i).getProyecto());
                    ppcNueva.setProyectoCargo(ppcRegistrados.get(i).getProyectoCargo());

                    criterios.clear();
                    c.setAtributo("nombreTipoEstadoPostulacion");
                    c.setOperador("=");
                    c.setValor("Fallida");
                    criterios.add(c);

                    Vector<TipoEstadoPostulacion> tep = FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);

                    /* Se le setea el TipoEstadoPostulacion "Creada" al nuevo EstadoPostulacion */
                    estadoPNueva.setTipoEstadoPostulacion(tep.get(0));

                    /* Se le setea la fecha y hora actual al nuevo EstadoPostulacion */
                    estadoPNueva.setFechaEstadoPostulacion(FechaHora.getInstancia().obtenerFechaActual());
                    estadoPNueva.setHoraEstadoPostulacion(FechaHora.getInstancia().obtenerHoraActual());

                    /* Se le agrega a al nueva PostulacionProyectoCargo el nuevo EstadoPostulacion */
                    ppcNueva.addEstadoPostulacion(estadoPNueva);

                    /* Se le agrega a la nueva Postulacion la nueva PostulacionProyectoCargo */
                    postulacionNueva.addPostProyCargo(ppcNueva);

                    dto.setExito(false);
                    dto.setDetalleResultado("Ya se registró una postulación al mismo Cargo del mismo Proyecto");

                    return dto;
                    
                }
                
            }
            
        }
        
        criterios.clear();
        busqueda.clear();
        
        c.setAtributo("nroProyecto");
        c.setOperador("=");
        c.setValor(nroProyectoSeleccionado);
        criterios.add(c);
        
        /* Se busca en la BD el Proyecto con el nroProyecto ingresado */
        busqueda = FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        /* Si existen más de un Proyecto con el mismo nroProyecto*/
        if(busqueda.size() != 1){ /* hay error si no hay exactamente un proyecto con ese nroProyecto */
            dto.setExito(false);
            dto.setDetalleResultado("Error en Proyecto: Por favor comuníquese con el Administrador");
            return dto;
        }
        
        Proyecto proyecto = (Proyecto)busqueda.get(0);
        
        /* Se obtiene los ProyectoCargo del Proyecto buscado */
        Vector<ProyectoCargo> proyectoCargo = proyecto.getProyectoCargo();
        
        /* Por cada ProyectoCargo */
        for(int i=0 ; i<proyectoCargo.size() ; i++){
            
            /* Se verifica si el nombre del Cargo es igual al nombre del cargo ingresado */
            if(proyectoCargo.get(i).getCargo().getNombreCargo().equals(nombreCargoSeleccionado)){
                
                /* Si es igual se obtiene el nombre de la carrera del estudiante */
                String carreraEstudiante = postulacionNueva.getEstadoAcademicoGeneral().getCarrera().getNombreCarrera();
                
                /* Se obtiene todos los ProyectoCargoCarrera del ProyectoCargo */
                Vector<ProyectoCargoCarrera> pcc = proyectoCargo.get(i).getProyectoCargoCarrera();
                
                /* Por cada ProyectoCargoCarrera */
                for(int j=0 ; j<pcc.size() ; j++){
                    
                    /* Si la carrera del ProyectoCargoCarrera es igual a la carrera del Estudiante */
                    if(pcc.get(j).getCarrera().getNombreCarrera().equals(carreraEstudiante)){
                        
                        /* Se calcula la cantidad de Materias regulares y rendidas del estudiante del EstadoAcademico guargado relacionado con la nueva Postulacion */
                        int cantidadMateriasRegularesE = 0 , cantidadMateriasRendidasE = 0;
                        
                        Vector<EstadoAcademicoDetallado> estAcadDet = postulacionNueva.getEstadoAcademicoGeneral().getEstadoAcademicoDetallado();
                        
                        for(int z=0 ; z<estAcadDet.size() ; z++){
                            if("Aprobado".equals(estAcadDet.get(z).getEstadoMateria().getNombreEstadoMateria())){
                                cantidadMateriasRendidasE = cantidadMateriasRendidasE+1;
                            }
                            if("Regular".equals(estAcadDet.get(z).getEstadoMateria().getNombreEstadoMateria())){
                                cantidadMateriasRegularesE = cantidadMateriasRegularesE+1;
                            }
                        }
                        /* Fin del Calculo de Materias regulares y rendidas del estudiante */
                        
                        /* Si la cantidadMateriasRegulares del ProyectoCargoCarrea >= cantidadMateriasRegularesEstudiante Y  cantidadMateriasRendidas del ProyectoCargoCarrera <= cantidadMateriasEstudiante
                         * Cumple con los requisitos */
                        if(pcc.get(j).getCantMateriasReg()>= cantidadMateriasRegularesE && pcc.get(j).getCantMateriasRend()<= cantidadMateriasRendidasE){
                            
                            /* Se setea el ProyectoCargo y el Proyecto a la nueva PostulacionProyectoCargo */
                            ppcNueva.setProyecto(proyecto);
                            ppcNueva.setProyectoCargo(proyectoCargo.get(i));
                            
                            criterios.clear();
                            c.setAtributo("nombreTipoEstadoPostulacion");
                            c.setOperador("=");
                            c.setValor("Creada");
                            criterios.add(c);

                            Vector<TipoEstadoPostulacion> tep = FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);

                            /* Se le setea el TipoEstadoPostulacion "Creada" al nuevo EstadoPostulacion */
                            estadoPNueva.setTipoEstadoPostulacion(tep.get(0));
                            
                            /* Se le setea la fecha y hora actual al nuevo EstadoPostulacion */
                            estadoPNueva.setFechaEstadoPostulacion(FechaHora.getInstancia().obtenerFechaActual());
                            estadoPNueva.setHoraEstadoPostulacion(FechaHora.getInstancia().obtenerHoraActual());
                            
                            /* Se le agrega a al nueva PostulacionProyectoCargo el nuevo EstadoPostulacion */
                            ppcNueva.addEstadoPostulacion(estadoPNueva);
                            
                            /* Se le agrega a la nueva Postulacion la nueva PostulacionProyectoCargo */
                            postulacionNueva.addPostProyCargo(ppcNueva);

                        }
                        else{
                            
                            /* Si es verdadero se Registra la Postulación fallida, setea en el DTO error con su detalle y se devuelve */
                            ppcNueva.setProyecto(proyecto);
                            ppcNueva.setProyectoCargo(proyectoCargo.get(i));

                            criterios.clear();
                            c.setAtributo("nombreTipoEstadoPostulacion");
                            c.setOperador("=");
                            c.setValor("Fallida");
                            criterios.add(c);

                            Vector<TipoEstadoPostulacion> tep = FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);

                            /* Se le setea el TipoEstadoPostulacion "Creada" al nuevo EstadoPostulacion */
                            estadoPNueva.setTipoEstadoPostulacion(tep.get(0));

                            /* Se le setea la fecha y hora actual al nuevo EstadoPostulacion */
                            estadoPNueva.setFechaEstadoPostulacion(FechaHora.getInstancia().obtenerFechaActual());
                            estadoPNueva.setHoraEstadoPostulacion(FechaHora.getInstancia().obtenerHoraActual());

                            /* Se le agrega a al nueva PostulacionProyectoCargo el nuevo EstadoPostulacion */
                            ppcNueva.addEstadoPostulacion(estadoPNueva);

                            /* Se le agrega a la nueva Postulacion la nueva PostulacionProyectoCargo */
                            postulacionNueva.addPostProyCargo(ppcNueva);

                            dto.setExito(false);
                            dto.setDetalleResultado("No cumple con los requisitos de este cargo");
                            return dto;
                            
                        }
                        
                    }
                    
                    else if(j == (pcc.size()-1)){
                        
                        /* Sino la Carrera del Estudiante no es requerida en el Cargo */
                        ppcNueva.setProyecto(proyecto);
                        ppcNueva.setProyectoCargo(proyectoCargo.get(i));

                        criterios.clear();
                        c.setAtributo("nombreTipoEstadoPostulacion");
                        c.setOperador("=");
                        c.setValor("Fallida");
                        criterios.add(c);

                        Vector<TipoEstadoPostulacion> tep = FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);

                        /* Se le setea el TipoEstadoPostulacion "Creada" al nuevo EstadoPostulacion */
                        estadoPNueva.setTipoEstadoPostulacion(tep.get(0));

                        /* Se le setea la fecha y hora actual al nuevo EstadoPostulacion */
                        estadoPNueva.setFechaEstadoPostulacion(FechaHora.getInstancia().obtenerFechaActual());
                        estadoPNueva.setHoraEstadoPostulacion(FechaHora.getInstancia().obtenerHoraActual());

                        /* Se le agrega a al nueva PostulacionProyectoCargo el nuevo EstadoPostulacion */
                        ppcNueva.addEstadoPostulacion(estadoPNueva);

                        /* Se le agrega a la nueva Postulacion la nueva PostulacionProyectoCargo */
                        postulacionNueva.addPostProyCargo(ppcNueva);

                        dto.setExito(false);
                        dto.setDetalleResultado("Error de Postulación: La Carrera no es igual a la del Estudiante");
                        return dto;
                        
                    }
                    
                }
                
            }
            
        }
        
        dto.setExito(true);
        dto.setDetalleResultado("Postulación registrada");
        return dto;
        
    }
    
    public DTO registrarPostulacion(){
        
        DTO dto = new DTO();
        
        if(postulacionNueva.getPostProyCargo().size() > 0){
        
            int postulacionesNoFallidas= 0;

            /* Se calcula si existen postulaciones no fallidas */
            /* Se obtienen las PostulacionProyectoCargo de la nueva Postulacion */
            Vector<PostulacionProyectoCargo> ppc1 = postulacionNueva.getPostProyCargo();

            /* Por cada PostulacionProyectoCargo */
            for(int i=0; i<ppc1.size(); i++){

                /* Si el TipoEstadoPostulación es distinta de Fallida */
                if(!"Fallida".equals(ppc1.get(i).getEstadoPostulacion().get(0).getTipoEstadoPostulacion().getNombreTipoEstadoPostulacion())){

                    /* Se cuentan las postulaciones no fallidas */
                    postulacionesNoFallidas = postulacionesNoFallidas+1;

                }

            }

            /* Se setea la fecha y hora actual a la Postulacion nueva */
            postulacionNueva.setfechaPostulacion(FechaHora.getInstancia().obtenerFechaActual());
            postulacionNueva.sethoraPostulacion(FechaHora.getInstancia().obtenerHoraActual());

            /* Se guarda la Postulacion nueva */
            FachadaPersistencia.getInstancia().guardar("Postulacion", postulacionNueva);

            /* Se obtienen las nuevas PostulacionProyectoCargo de la nueva Postulacion */
            Vector<PostulacionProyectoCargo> ppc = postulacionNueva.getPostProyCargo();

            /* Por cada nueva PostulacionProyectoCargo */
            for(int i=0; i<ppc.size(); i++){

                /* Se guarda la PostulacionProyectoCargo */
                FachadaPersistencia.getInstancia().guardar("PostulacionProyectoCargo", ppc.get(i));

                /* Se obtiene los EstadoPostulacion de la nueva PostulacionProyectoCargo */
                Vector<EstadoPostulacion> eP = ppc.get(i).getEstadoPostulacion();

                /* Por cada EstadoPostulacon */
                for(int j=0; j<eP.size(); j++){

                    /* Se guarda el EstadoPostulacion */
                    FachadaPersistencia.getInstancia().guardar("EstadoPostulacion", eP.get(j));

                }

            }

            /* Si no existen postulaciones no fallidas  */
            if(postulacionesNoFallidas == 0){

                /* Se setea el detalle del resultado la postulación ha sido guardada pero no se postuló a ningún cargo */
                dto.setExito(true);
                dto.setDetalleResultado("La Postulación ha sido guardada satisfactoriamente: el Estudiante no se ha postulado a ningún Cargo\n----_Gracias por utilizar nuestro sistema_----\nMACROSOFT");

            }
            else{

                /* Sino se setea el detalle del resultado la Postulación ha sido guardada */
                dto.setExito(true);
                dto.setDetalleResultado("La Postulación ha sido guardada satisfactoriamente\n----_Gracias por utilizar nuestro sistema_----\nMACROSOFT");

            }
            
        }
        else{
            
            dto.setExito(false);
            dto.setDetalleResultado("No se ha Postulado a ningún cargo de ningún Proyecto \n----_Gracias por utilizar nuestro sistema_----\nMACROSOFT");
            
        }
        
        
        /* Se devuelve el DTO */
        return dto;
        
    }
    
    public DTO cancelarPostulacion(){
        
        DTO dto = new DTO();
        
        dto.setExito(false);
        dto.setDetalleResultado("Postulación cancelada \n----_Gracias por utilizar nuestro sistema_----\nMACROSOFT");
        
        return dto;
    }
    
    public DTO sincronizarAsignaciones(){
        
        DTO dto = new DTO();
        
        Vector<PostulacionProyectoCargo> ppc = this.postulacionNueva.getPostProyCargo();
        for(int i=0; i<ppc.size(); i++){
            
            
            Vector<EstadoPostulacion> eP = ppc.get(i).getEstadoPostulacion();
            if("Creada".equals(eP.get(0).getTipoEstadoPostulacion().getNombreTipoEstadoPostulacion())){
                DTOPostulacion dtoo = new DTOPostulacion();
                dtoo.setPrioridad(ppc.get(i).getPrioridad());
                dtoo.setNombreProyecto(ppc.get(i).getProyecto().getNombreProyecto());
                dtoo.setNombrecargo(ppc.get(i).getProyectoCargo().getCargo().getNombreCargo());
                dto.add(dtoo);
            }
        }
        dto.setExito(false);
        dto.setDetalleResultado("Postulación Cancelada");
        return dto;
    }
    
    public void sincronizarAsignaciones(DTO dto){
        
        Vector<PostulacionProyectoCargo> ppc = this.postulacionNueva.getPostProyCargo();
        for(int i=0; i<ppc.size(); i++){
            
            for(int j=0; j<dto.size(); j++){
                
                DTOPostulacion post = (DTOPostulacion) dto.get(j);
                
                if( (ppc.get(i).getProyecto().getNombreProyecto().equals(post.getNombreProyecto())) && (ppc.get(i).getProyectoCargo().getCargo().getNombreCargo().equals(post.getNombrecargo())) ){
                    
                    ppc.get(i).setprioridad(post.getPrioridad());
                    
                }
                
            }
            
        }
        
    }
    
    public DTOcantidadesMaterias obtenerCantidades(){
        
        DTOcantidadesMaterias dto = new DTOcantidadesMaterias();
        
        /* Se calcula la cantidad de Materias regulares y rendidas del estudiante del EstadoAcademico guargado relacionado con la nueva Postulacion */
        int cantidadMateriasRegularesE = 0 , cantidadMateriasRendidasE = 0;

        Vector<EstadoAcademicoDetallado> estAcadDet = postulacionNueva.getEstadoAcademicoGeneral().getEstadoAcademicoDetallado();

        for(int z=0 ; z<estAcadDet.size() ; z++){
            if("Aprobado".equals(estAcadDet.get(z).getEstadoMateria().getNombreEstadoMateria())){
                cantidadMateriasRendidasE = cantidadMateriasRendidasE+1;
            }
            if("Regular".equals(estAcadDet.get(z).getEstadoMateria().getNombreEstadoMateria())){
                cantidadMateriasRegularesE = cantidadMateriasRegularesE+1;
            }
        }
        /* Fin del Calculo de Materias regulares y rendidas del estudiante */

        dto.setCanReg(cantidadMateriasRegularesE);
        dto.setCantRend(cantidadMateriasRendidasE);
        
        return dto;
    }
    
}
