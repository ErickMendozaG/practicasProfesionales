
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class FabricaEntidades {
    
    /* <<Singleton>> */
    
    private static FabricaEntidades instancia = new FabricaEntidades();
    
    private FabricaEntidades(){}
    
    public static FabricaEntidades getInstancia(){
        return instancia;
    }
    
    /* Métodos públicos */
    
    public Object obtenerEntidad(String nombreEntidad){
        
        Agente retorno = new Agente();
        retorno.setNuevo(true);
        retorno.setModificado(false);
        
        if("Cargo".equals(nombreEntidad)){
            CargoAgente agente = new CargoAgente();
            CargoImplementacion cargo = new CargoImplementacion();
            agente.setCargo(cargo);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Carrera".equals(nombreEntidad)){
            CarreraAgente agente = new CarreraAgente();
            CarreraImplementacion carrera = new CarreraImplementacion();
            agente.setCarrera(carrera);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Contrato".equals(nombreEntidad)){
            ContratoAgente agente = new ContratoAgente();
            ContratoImplementacion contrato = new ContratoImplementacion();
            agente.setContrato(contrato);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Condicion".equals(nombreEntidad)){
            CondicionAgente agente = new CondicionAgente();
            CondicionImplementacion condicion = new CondicionImplementacion();
            agente.setCondicion(condicion);
            agente.generarOID();
            retorno = agente;
        }
        
        
        if("Empresa".equals(nombreEntidad)){
            EmpresaAgente agente = new EmpresaAgente();
            EmpresaImplementacion empresa = new EmpresaImplementacion();
            agente.setEmpresa(empresa);
            agente.generarOID();
            retorno = agente;
        }
        
        
        if("EstadoAcademicoGeneral".equals(nombreEntidad)){
            EstadoAcademicoGeneralAgente agente = new EstadoAcademicoGeneralAgente();
            EstadoAcademicoGeneralImplementacion estAcadGeneral = new EstadoAcademicoGeneralImplementacion();
            agente.setEstadoAcademicoGeneral(estAcadGeneral);
            agente.generarOID();
            retorno = agente;
        }
        
        
        if("EstadoAcademicoDetallado".equals(nombreEntidad)){
            EstadoAcademicoDetalladoAgente agente = new EstadoAcademicoDetalladoAgente();
            EstadoAcademicoDetalladoImplementacion estAcadDetallado = new EstadoAcademicoDetalladoImplementacion();
            agente.setEstadoAcademicoDetallado(estAcadDetallado);
            agente.generarOID();
            retorno = agente;
        }
        
        if("EstadoContrato".equals(nombreEntidad)){
            EstadoContratoAgente agente = new EstadoContratoAgente();
            EstadoContratoImplementacion estadoContrato = new EstadoContratoImplementacion();
            agente.setEstadocontrato(estadoContrato);
            agente.generarOID();
            retorno = agente;
        }
        
        if("EstadoPostulacion".equals(nombreEntidad)){
            EstadoPostulacionAgente agente = new EstadoPostulacionAgente();
            EstadoPostulacionImplementacion estadoPostulacion = new EstadoPostulacionImplementacion();
            agente.setEstadopostulacion(estadoPostulacion);
            agente.generarOID();
            retorno = agente;
        }
        
        
        if("EstadoMateria".equals(nombreEntidad)){
            EstadoMateriaAgente agente = new EstadoMateriaAgente();
            EstadoMateriaImplementacion estadoMateria = new EstadoMateriaImplementacion();
            agente.setEstadoMateria(estadoMateria);
            agente.generarOID();
            retorno = agente;
        }
        
        if("EstadoProyecto".equals(nombreEntidad)){
            EstadoProyectoAgente agente = new EstadoProyectoAgente();
            EstadoProyectoImplementacion estadoProyecto = new EstadoProyectoImplementacion();
            agente.setEstadoProyecto(estadoProyecto);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Estudiante".equals(nombreEntidad)){
            EstudianteAgente agente = new EstudianteAgente();
            EstudianteImplementacion estudiante = new EstudianteImplementacion();
            agente.setEstudiante(estudiante);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Materia".equals(nombreEntidad)){
            MateriaAgente agente = new MateriaAgente();
            MateriaImplementacion materia = new MateriaImplementacion();
            agente.setMateria(materia);
            agente.generarOID();
            retorno = agente;
        }
        
        if("MetodologiaOrden".equals(nombreEntidad)){
            MetodologiaOrdenAgente agente = new MetodologiaOrdenAgente();
            MetodologiaOrdenImplementacion metodoloagiaOrden = new MetodologiaOrdenImplementacion();
            agente.setMetodologiaOrden(metodoloagiaOrden);
            agente.generarOID();
            retorno = agente;
        }
        
        if("PlanEstudio".equals(nombreEntidad)){
            PlanEstudioAgente agente = new PlanEstudioAgente();
            PlanEstudioImplementacion planEstudio = new PlanEstudioImplementacion();
            agente.setPlanEstudio(planEstudio);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Postulacion".equals(nombreEntidad)){
            PostulacionAgente agente = new PostulacionAgente();
            PostulacionImplementacion postulacion = new PostulacionImplementacion();
            agente.setPostulacion(postulacion);
            agente.generarOID();
            retorno = agente;
        }
        
        if("PostulacionProyectoCargo".equals(nombreEntidad)){
            PostulacionProyectoCargoAgente agente = new PostulacionProyectoCargoAgente();
            PostulacionProyectoCargoImplementacion postulacionProyectoCargo = new PostulacionProyectoCargoImplementacion();
            agente.setPostProyCargo(postulacionProyectoCargo);
            agente.generarOID();
            retorno = agente;
        } 
        
        if("Proyecto".equals(nombreEntidad)){
            ProyectoAgente agente = new ProyectoAgente();
            ProyectoImplementacion proyecto = new ProyectoImplementacion();
            agente.setProyecto(proyecto);
            agente.generarOID();
            retorno = agente;
        }
        
        if("ProyectoCargo".equals(nombreEntidad)){
            ProyectoCargoAgente agente = new ProyectoCargoAgente();
            ProyectoCargoImplementacion proyectoCargo = new ProyectoCargoImplementacion();
            agente.setProyectoCargo(proyectoCargo);
            agente.generarOID();
            retorno = agente;
        }
        
        if("ProyectoCargoCarrera".equals(nombreEntidad)){
            ProyectoCargoCarreraAgente agente = new ProyectoCargoCarreraAgente();
            ProyectoCargoCarreraImplementacion proyectoCargoCarrera = new ProyectoCargoCarreraImplementacion();
            agente.setProyectoCargoCarrera(proyectoCargoCarrera);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Seleccion".equals(nombreEntidad)){
            SeleccionAgente agente = new SeleccionAgente();
            SeleccionImplementacion seleccion = new SeleccionImplementacion();
            agente.setSeleccion(seleccion);
            agente.generarOID();
            retorno = agente;
        }
        
        if("SeleccionPostulacionProyectoCargo".equals(nombreEntidad)){
            SeleccionPostulacionProyectoCargoAgente agente = new SeleccionPostulacionProyectoCargoAgente();
            SeleccionPostulacionProyectoCargoImplementacion seleccionPostulacionProyectoCargo = new SeleccionPostulacionProyectoCargoImplementacion();
            agente.setSelecPostProyCargo(seleccionPostulacionProyectoCargo);
            agente.generarOID();
            retorno = agente;
        }
        
        if("SituacionFiscal".equals(nombreEntidad)){
            SituacionFiscalAgente agente = new SituacionFiscalAgente();
            SituacionFiscalImplementacion SituacionFiscal = new SituacionFiscalImplementacion();
            agente.setSituacionFiscal(SituacionFiscal);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoDocumento".equals(nombreEntidad)){
            TipoDocumentoAgente agente = new TipoDocumentoAgente();
            TipoDocumentoImplementacion tipoDocumento = new TipoDocumentoImplementacion();
            agente.setTipoDocumento(tipoDocumento);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoEstadoContrato".equals(nombreEntidad)){
            TipoEstadoContratoAgente agente = new TipoEstadoContratoAgente();
            TipoEstadoContratoImplementacion tipoEstadoContrato = new TipoEstadoContratoImplementacion();
            agente.setTipoEstadoContrato(tipoEstadoContrato);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoEstadoPostulacion".equals(nombreEntidad)){
            TipoEstadoPostulacionAgente agente = new TipoEstadoPostulacionAgente();
            TipoEstadoPostulacionImplementacion tipoEstadoPostulacion = new TipoEstadoPostulacionImplementacion();
            agente.setTipoEstadoPostulacion(tipoEstadoPostulacion);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoEstadoProyecto".equals(nombreEntidad)){
            TipoEstadoProyectoAgente agente = new TipoEstadoProyectoAgente();
            TipoEstadoProyectoImplementacion tipoEstadoProyecto = new TipoEstadoProyectoImplementacion();
            agente.setTipoEstadoProyecto(tipoEstadoProyecto);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoEstadoSeleccion".equals(nombreEntidad)){
            TipoEstadoSeleccionAgente agente = new TipoEstadoSeleccionAgente();
            TipoEstadoSeleccionImplementacion TipoEstadoSeleccion = new TipoEstadoSeleccionImplementacion();
            agente.setTipoEstadoSeleccion(TipoEstadoSeleccion);
            agente.generarOID();
            retorno = agente;
        }
        
        if("TipoEstadoSeleccionPostulacionProyectoCargo".equals(nombreEntidad)){
            TipoEstadoSeleccionPostulacionProyectoCargoAgente agente = new TipoEstadoSeleccionPostulacionProyectoCargoAgente();
            TipoEstadoSeleccionPostulacionProyectoCargoImplementacion tipoEstadoSeleccionPostulacionProyectoCargo = new TipoEstadoSeleccionPostulacionProyectoCargoImplementacion();
            agente.setTipoEstadoSeleccionPostulacionProyectoCargo(tipoEstadoSeleccionPostulacionProyectoCargo);
            agente.generarOID();
            retorno = agente;
        }
        
        if("Universidad".equals(nombreEntidad)){
            UniversidadAgente agente = new UniversidadAgente();
            UniversidadImplementacion universidad = new UniversidadImplementacion();
            agente.setUniversidad(universidad);
            agente.generarOID();
            retorno = agente;
        }
        
        return retorno;
    }
    
}
