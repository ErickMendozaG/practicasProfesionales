/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaPersistencia;

import PracticasProfesionales.DTO;
import PracticasProfesionales.ExpertoConsultarPostulaciones;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

/**
 *
 * @author erick
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
         /*PRUEBAS CON FECHAS*//*
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
        // java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
/*
        System.out.println(sqlTime);
        System.out.println(sqlDate);*/
        
        /* PRUEBAS CON GENERARSQL CON CRITERIOS
        Criterio c= new Criterio();
        c.setAtributo("nroCargo");
        c.setOperador("=");
        int i=1;
        c.setValor(i);
        Criterio c2= new Criterio();
        c2.setAtributo("nombreCargo");
        c2.setOperador("=");
        c2.setValor("Pepe");
        Criterio c3= new Criterio();
        c3.setAtributo("reCargo");
        c3.setOperador("=");
        c3.setValor("PepePEPE");
        Vector<Criterio> vector= new Vector();
        vector.add(c);
        vector.add(c2);
        vector.add(c3);
        IntermediarioCargo e= new IntermediarioCargo();
        System.out.println(e.generarSQLBuscar(vector));
        */
         /*PRUEBA GENERARSQL GUARDAR*//*
        CargoAgente cargo = new CargoAgente();
        CargoImplementacion cargoI = new CargoImplementacion();
        cargo.setCargo(cargoI);
        
        
        cargo.setNroCargo(20);
        cargo.setNombreCargo("Gerente");
        cargo.setFechaInicioVigencia(sqlDate);
        cargo.setFechaFinVigencia(sqlDate);
        
        UniversidadAgente u = new UniversidadAgente();
        cargo.setUniversidadDeCargo(u);
        
        
        IntermediarioCargo inter= new IntermediarioCargo();
        
        System.out.println(inter.generarSQLGuardar(cargo));
        System.out.println(inter.generarSQLActualizar(cargo));
        */
        /*
        Vector<Criterio> q= new Vector();
        Criterio c= new Criterio();
        c.setAtributo("nroContrato");
        c.setOperador("=");
        int i=1;
        c.setValor(i);
        Criterio c2= new Criterio();
        c2.setAtributo("OIDContrato");
        c2.setOperador("=");
        c2.setValor("123456789987654321123456789");
        q.add(c);
        //q.add(c2);
        Conexion.getInstancia().conectar();
        Vector ve = FachadaPersistencia.getInstancia().buscar("Contrato", q);
        Contrato car = (Contrato)ve.get(0);
        System.out.println(car.getNroContrato());
        System.out.println(car.getHoraCreacionContrato());
        System.out.println(car.getFechaCreacionContrato());
        
                
        
        Vector vb = car.getEstadosDeContrato();
        EstadoContrato esp = (EstadoContrato)vb.get(0);
        System.out.println("El get:");
        System.out.println(esp.getFechaEstadoContrato());
        System.out.println(esp.getHoraEstadoContrato());
        /*
        q.clear();
        
        Criterio c4 = new Criterio();
        c4.setAtributo("nroMateria");
        c4.setOperador("=");
        c4.setValor("1");
        q.add(c4);
        
        ve = FachadaPersistencia.getInstancia().buscar("Materia", q);
        
        System.out.println(ve.size());
        Materia ma = (Materia)ve.get(0);
        
        System.out.println(ma.getFechaFinVigenciaMateria());
        System.out.println(ma.getNombreMateria());
        System.out.println(ma.getNroMateria());
        System.out.println("Esto es todo amigos! :)");
        
        q.clear();
        
        c4.setAtributo("cuit");
        c4.setOperador("=");
        c4.setValor("23-27456345-6");
        q.add(c4);
        System.out.println("----------");
        ve = FachadaPersistencia.getInstancia().buscar("Empresa", q);
        System.out.println(ve.size());
        Empresa con = (Empresa) ve.get(0);
        
        System.out.println(con.getDomicilioEmpresa());
        System.out.println(con.getTelefonoEmpresa());
        System.out.println("Esto es todo amigos! :)");
        */
        /*
        CargoAgente agente = new CargoAgente();
        CargoImplementacion impl = new CargoImplementacion();
        agente.setOID("26262626262626");
        agente.setCargo(impl);
        //agente.setFechaFinVigencia((java.sql.Date) new Date());
        //agente.setFechaInicioVigencia((java.sql.Date) new Date());
        agente.setNroCargo(1);
        agente.setNombreCargo("HolaMundo");
        CargoAgente agente2 = new CargoAgente();
        CargoImplementacion impl2 = new CargoImplementacion();
        agente2.setOID("36363636363636");
        agente2.setCargo(impl2);
        //agente2.setFechaFinVigencia((java.sql.Date) new Date());
        //agente2.setFechaInicioVigencia((java.sql.Date) new Date());
        agente2.setNroCargo(2);
        agente2.setNombreCargo("AdiosMundo");
        Vector<Agente> vector = new Vector();
        vector.add(agente);
        vector.add(agente2);
        Cache.getInstancia().depositarEnCache(vector);
        if(Cache.getInstancia().seEncuentra("262626262626286")){
            System.out.println("Cache guardada");
        }
        else{
            //Cache.getInstancia().depositarEnCache(agente2);
        }
        Agente a = (Agente)Cache.getInstancia().obtenerDeCache("36363636363636");
        System.out.println(a.getOID());
        *//*
        Vector<Criterio> crit= new Vector();
        Criterio c = new Criterio();
        c.setAtributo("nroContrato");
        c.setOperador("=");
        c.setValor(1);
        Vector v = FachadaPersistencia.getInstancia().buscar("Contrato", crit);
        //System.out.println(v.size());
        //Contrato contrato = (Contrato) v.get(0);
        *//*
        Vector criterios = new Vector();
        Criterio c = new Criterio();
        c.setAtributo("OIDContrato");
        c.setOperador("=");
        c.setValor("450258605121934147381926553070724827");
        
        IntermediarioEstadoContrato tt = new IntermediarioEstadoContrato();
        String fg = tt.generarSQLCriterios(c);
        System.out.println(fg);
        */
        /*
        Vector estContrato = FachadaPersistenciaInterna.getInstancia().buscar("EstadoContrato", criterios);
            int i = estContrato.size() - 1;
            while(i>=0){
                EstadoContrato d = (EstadoContrato) estContrato.get(i);
                System.out.println(d.getFechaEstadoContrato());
                i = i-1;
            }
        */
        /*
        PlanEstudioImplementacion planI = new PlanEstudioImplementacion();
        PlanEstudioAgente plan = new PlanEstudioAgente();
        plan.setPlanEstudio(planI);
        
        MateriaAgente  a = new MateriaAgente();
        a.setOID("123");
        MateriaAgente  b = new MateriaAgente();
        b.setOID("321");
        MateriaAgente  c = new MateriaAgente();
        c.setOID("258");
        MateriaAgente  d = new MateriaAgente();
        d.setOID("852");
        
        Materia as = (Materia)a;
        Materia bs = (Materia)b;
        Materia cs = (Materia)c;
        Materia ds = (Materia)d;
        
        plan.addMateria(as);
        plan.addMateria(bs);
        plan.addMateria(cs);
        plan.addMateria(ds);
        plan.addMateria(cs);
        plan.addMateria(cs);
        plan.addMateria(cs);
        plan.addMateria(as);
        
        */
        /*
        Universidad nuevaU = (Universidad) FabricaEntidades.getInstancia().obtenerEntidad("Universidad");
        
        nuevaU.setNombreUniversidad("OTRA");
        nuevaU.setDireccionServidorWeb("www.unc.edu.ar");
        nuevaU.setFechaInicioVigenciaUniversidad(new Date(2013, 01, 01));
        Date hasta = new Date(2014, 01, 10);
        nuevaU.setFechaFinVigenciaUniversidad(hasta);
        FachadaPersistencia.getInstancia().guardar("Universidad", nuevaU);
        System.out.println("Universidad guardada");
        */
        
         /*
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        c.setAtributo("nroUniversidad");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        Vector<Universidad> universidades = FachadaPersistencia.getInstancia().buscar("Universidad", criterios);
        
        System.out.println(universidades.get(0).getFechaFinVigenciaUniversidad());
        Universidad universidad = (Universidad)FachadaPersistenciaInterna.getInstancia().buscar("Universidad", "466238197293624163161039775954297392");
        //IntermediarioUniversidad i = new IntermediarioUniversidad();
        
        //System.out.println(i.generarSQLBuscar(criterios));
        
        System.out.println("Estado de Caché:");
        Cache.getInstancia().verContenidoCache();
        */
        /*
        Vector<Criterio> criterios = new Vector();
        Criterio c = new Criterio();
        c.setAtributo("nroSituacionFiscal");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        Vector<SituacionFiscal> sitF = FachadaPersistencia.getInstancia().buscar("SituacionFiscal", criterios);
        
        sitF.get(0).setNombreSituacionFiscal("Sin Deuda");
        
        FachadaPersistencia.getInstancia().guardar("SituacionFiscal", sitF.get(0));
        */
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        EstadoMateria tipo = (EstadoMateria)FabricaEntidades.getInstancia().obtenerEntidad("EstadoMateria");
        
        tipo.setNombreEstadoMateria("Regular");
        EstadoMateriaAgente ag = (EstadoMateriaAgente) tipo;
        System.out.println(ag.getOID());
        
        FachadaPersistencia.getInstancia().guardar("EstadoMateria", tipo);
        Conexion.getInstancia().confirmarTransaccion();
        * */
        /* Prueba de guardar un nuevo Estudiante*/
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        
        Estudiante estudiante = (Estudiante) FabricaEntidades.getInstancia().obtenerEntidad("Estudiante");
        
        estudiante.setLegajo(33479);
        estudiante.setNombreEstudiante("Erick");
        estudiante.setApellidoEstudiante("Mendoza");
        estudiante.setNroDocumento(94190053);
        estudiante.setDomicilioEstudiante("Reconquista 1448 - Godoy Cruz");
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("nombreUniversidad");
        c.setOperador("=");
        c.setValor("UTN FRM");
        criterios.add(c);
        
        Vector<Universidad> vector = FachadaPersistencia.getInstancia().buscar("Universidad", criterios);
        
        estudiante.setUniversidadDeEstudiante(vector.get(0));
        
        criterios.clear();
        vector.clear();
        
        c.setAtributo("nombreTipoDocumento");
        c.setOperador("=");
        c.setValor("DNI");
        criterios.add(c);
        
        Vector<TipoDocumento> ve =FachadaPersistencia.getInstancia().buscar("TipoDocumento", criterios);
        
        
        estudiante.setTipoDocumento(ve.get(0));
        
        FachadaPersistencia.getInstancia().guardar("Estudiante", estudiante);
        
        Conexion.getInstancia().confirmarTransaccion();
        */
        /* FIN Prueba de guardar un nuevo Estudiante*/
        /* Prueba de un get simple de Materialización Perezosa*/
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("legajo");
        c.setOperador("=");
        c.setValor(33479);
        criterios.add(c);
        
        Vector vector = FachadaPersistencia.getInstancia().buscar("Estudiante", criterios);
        
        Estudiante e = (Estudiante) vector.get(0);
        
        System.out.println(e.getLegajo());
        System.out.println(e.getNombreEstudiante());
        System.out.println(e.getApellidoEstudiante());
        System.out.println(e.getTipoDocumento().getNombreTipoDocumento());
        System.out.println(e.getNroDocumento());
        System.out.println(e.getDomicilioEstudiante());
        System.out.println(e.getUniversidadDeEstudiante().getNombreUniversidad());
        */
        /* Prueba de un get simple de Materialización Perezosa*/
        /* Prueba Buscar algo que no esta en la BD */
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("legajo");
        c.setOperador("=");
        c.setValor(123);
        criterios.add(c);
        
        Vector v = FachadaPersistencia.getInstancia().buscar("Estudiante", criterios);
        if(v.size()==0){
            System.out.println("No se enconttró Estudiante");
        }
        else{
            Estudiante e = (Estudiante)v.get(0);
            System.out.println(e.getLegajo());
        }
        */
        /* FIN_Prueba Buscar algo que no esta en la BD */
        
        /* Prueba en las entidades PlanEstudio y Materia */
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("nombrePlanEstudio");
        c.setOperador("=");
        c.setValor("PLAN 95");
        criterios.add(c);
        Vector v = FachadaPersistencia.getInstancia().buscar("PlanEstudio", criterios);
        
        PlanEstudio planE= (PlanEstudio)v.get(0);
        
        System.out.println(planE.getMateria().get(0).getNombreMateria());
        
        criterios.clear();
        v.clear();
        
        c.setAtributo("nroMateria");
        c.setOperador("=");
        c.setValor(2);
        criterios.add(c);
        //System.out.println("3");
        v= FachadaPersistencia.getInstancia().buscar("Materia", criterios);
        //System.out.println("2");
        planE.addMateria((Materia)v.get(0));
        //System.out.println("1");
        //FachadaPersistencia.getInstancia().guardar("PlanEstudio", planE);
       // System.out.println("Guardado los cambios");
        
        //Conexion.getInstancia().confirmarTransaccion();
        //System.out.println("Guardado los cambios2");
        
        IntermediarioPlanEstudio inter = new IntermediarioPlanEstudio();
        System.out.println(inter.generarSQLActualizar(planE));
        
        */
        /*
        Vector<Criterio> criterios = new Vector();
            Criterio c = new Criterio();
            c.setAtributo("OIDPlanEstudio");
            c.setOperador("=");
            c.setValor("968309261171274008376717826877105125");
            criterios.add(c);
            Vector<PlanEstudioMateriaAgente> planEstudioMateria = FachadaPersistenciaInterna.getInstancia().buscar("PlanEstudioMateria", criterios);
            //IntermediarioPlanEstudioMateria i = new IntermediarioPlanEstudioMateria();
            //System.out.println(i.generarSQLBuscar(criterios));
            System.out.println(planEstudioMateria.get(0).getOIDMateria());
        */
        /*
        Conexion.getInstancia().conectar();
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        c.setAtributo("fechaInicioInscripcion");
        c.setOperador("<");
        c.setValor(new java.util.Date());
        criterios.add(c);
        
        Vector vector = FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        Proyecto p = (Proyecto) vector.get(0);
        
        System.out.println(p.getFechaInicioInscripcion());
        System.out.println(p.getNroProyecto());
        System.out.println(new java.util.Date());
        */
        /* Guardado de Proyecto
        */
        
        /*Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Vector v = new Vector();
        
        Criterio c = new Criterio();
        
        c.setAtributo("razonSocial");
        c.setOperador("=");
        c.setValor("Pocket Track S.A.");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Empresa", criterios);
        
        Empresa pocket = (Empresa)v.get(0);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nombreMetodologiaOrden");
        c.setOperador("=");
        c.setValor("Clasica");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("MetodologiaOrden", criterios);
        
        MetodologiaOrden clasica = (MetodologiaOrden)v.get(0);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nombreTipoEstadoProyecto");
        c.setOperador("=");
        c.setValor("Creado");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("TipoEstadoProyecto", criterios);
        
        TipoEstadoProyecto creado = (TipoEstadoProyecto)v.get(0);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nombreUniversidad");
        c.setOperador("=");
        c.setValor("UTN FRM");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Universidad", criterios);
        
        Universidad frm = (Universidad) v.get(0);
              
        v.clear();
        criterios.clear();
        
        Proyecto nProyecto = (Proyecto)FabricaEntidades.getInstancia().obtenerEntidad("Proyecto");
        
        EstadoProyecto nEstadoP = (EstadoProyecto) FabricaEntidades.getInstancia().obtenerEntidad("EstadoProyecto");
        
        nEstadoP.setTipoEstadoProyecto(creado);
        nEstadoP.setFechaEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(27, 9, 2013));
        nEstadoP.setHoraEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerHoraActual());
        
        nProyecto.setEmpresa(pocket);
        nProyecto.setMetodologiaOrden(clasica);
        nProyecto.setUniversidad(frm);
        nProyecto.addEstadoProyecto(nEstadoP);
        
        nProyecto.setFechaInicioInscripcion(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(19, 10, 2013));
        nProyecto.setFechaInicioProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(15, 11, 2013));
        nProyecto.setFechaLimiteDePostulacion(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(30, 10, 2013));
        nProyecto.setNombreProyecto("Aplicacion Android");
        nProyecto.setTiempoDuracionProyecto(100);
        
        FachadaPersistencia.getInstancia().guardar("Proyecto", nProyecto);
        FachadaPersistencia.getInstancia().guardar("EstadoProyecto", nEstadoP);
        
        Conexion.getInstancia().confirmarTransaccion();
        /* Agrega el primer ProyectoCargo*//*
        ProyectoCargo nPC = (ProyectoCargo) FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargo");
        
        nPC.setCantPuestos(2);
        nPC.setCdadLimPost(5);
        nPC.setHorasEstimadas(4);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nroCargo");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        v=FachadaPersistencia.getInstancia().buscar("Cargo", criterios);
        
        nPC.setCargo((Cargo)v.get(0));
        
        ProyectoCargoCarrera nPCC = (ProyectoCargoCarrera) FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargoCarrera");
        
        nPCC.setCantMateriasReg(2);
        nPCC.setCantMateriasRend(24);
        
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nroCarrera");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        v = FachadaPersistencia.getInstancia().buscar("Carrera", criterios);
        System.out.println(v.size());
        nPCC.setCarrera((Carrera)v.get(0));
        
        nPC.addProyectoCargoCarrera(nPCC);
        
        /* Va por el segundo ProyectoCargo *//*
        ProyectoCargo nPC2 = (ProyectoCargo) FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargo");
        
        nPC2.setCantPuestos(1);
        nPC2.setCdadLimPost(5);
        nPC2.setHorasEstimadas(5);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nroCargo");
        c.setOperador("=");
        c.setValor(5);
        criterios.add(c);
        
        v=FachadaPersistencia.getInstancia().buscar("Cargo", criterios);
        
        nPC2.setCargo((Cargo)v.get(0));
        
        ProyectoCargoCarrera nPCC2 = (ProyectoCargoCarrera) FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargoCarrera");
        
        nPCC2.setCantMateriasReg(0);
        nPCC2.setCantMateriasRend(26);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nroCarrera");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        v = FachadaPersistencia.getInstancia().buscar("Carrera", criterios);
        System.out.println(v.size());
        nPCC2.setCarrera((Carrera)v.get(0));
        
        nPC2.addProyectoCargoCarrera(nPCC2);
        
        nProyecto.addProyectoCargo(nPC);
        nProyecto.addProyectoCargo(nPC2);
        
        FachadaPersistencia.getInstancia().guardar("Proyecto", nProyecto);
        System.out.println("dos");
        FachadaPersistencia.getInstancia().guardar("ProyectoCargo", nPC);
        System.out.println("cuatro");
        FachadaPersistencia.getInstancia().guardar("ProyectoCargo", nPC2);
        System.out.println("uno");
        FachadaPersistencia.getInstancia().guardar("ProyectoCargoCarrera", nPCC);
        System.out.println("tres");
        FachadaPersistencia.getInstancia().guardar("ProyectoCargoCarrera", nPCC2);
        System.out.println("cinco");
        
        FachadaPersistencia.getInstancia().guardar("EstadoProyecto",nEstadoP);
        System.out.println("seis");
        
        
        Conexion.getInstancia().confirmarTransaccion();
        
        System.out.println("Guardado con exito");
        */
        /*
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Vector v = new Vector();
        
        Criterio c = new Criterio();
        
        c.setAtributo("nombreUniversidad");
        c.setOperador("=");
        c.setValor("UTN FRM");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Universidad", criterios);
        
        Universidad frm = (Universidad) v.get(0);
        
        Estudiante erick = (Estudiante) FabricaEntidades.getInstancia().obtenerEntidad("Estudiante");
        
        erick.setApellidoEstudiante("Mendoza");
        erick.setDomicilioEstudiante("Piedras Duras 177, Los Atunvez, Marsella");
        erick.setLegajo(33479);
        erick.setNombreEstudiante("Erick");
        erick.setNroDocumento(94190053);
        
        erick.setUniversidadDeEstudiante(frm);
        
        v.clear();
        criterios.clear();
        
        c.setAtributo("nroTipoDocumento");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        IntermediarioTipoDocumento i = new IntermediarioTipoDocumento();
        
        System.out.println(i.generarSQLBuscar(criterios));
        
        v=FachadaPersistencia.getInstancia().buscar("TipoDocumento", criterios);
        
        erick.setTipoDocumento((TipoDocumento)v.get(0));
        
        FachadaPersistencia.getInstancia().guardar("Estudiante", erick);
        
        Conexion.getInstancia().confirmarTransaccion();
        
        System.out.println("Guardado con exito");
        */
        /*
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector<Criterio> criterios = new Vector();
        
        Vector v = new Vector();
        
        Criterio c = new Criterio();
        
        c.setAtributo("nroProyecto");
        c.setOperador("=");
        c.setValor(11);
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        Proyecto p = (Proyecto) v.get(0);
        
        EstadoProyecto eP = (EstadoProyecto) FabricaEntidades.getInstancia().obtenerEntidad("EstadoProyecto");
        
        criterios.clear();
        v.clear();
        
        c.setAtributo("nroTipoEstadoProyecto");
        c.setOperador("=");
        c.setValor(1);
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("TipoEstadoProyecto", criterios);
        
        eP.setTipoEstadoProyecto((TipoEstadoProyecto)v.get(0) );
        eP.setFechaEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerFechaActual());
        eP.setHoraEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerHoraActual());
        
        p.addEstadoProyecto(eP);
        
        FachadaPersistencia.getInstancia().guardar("Proyecto", p);
        
        FachadaPersistencia.getInstancia().guardar("EstadoProyecto", eP);
        
        Conexion.getInstancia().confirmarTransaccion();
        
        System.out.println("Guardado con exito");
        */
        /*
        Conexion.getInstancia().iniciarTransaccion();
        Criterio c =new Criterio();
        Vector<Criterio> cr=new Vector();
        Vector v=new Vector();
        
        c.setValor(5);
        c.setOperador("=");
        c.setAtributo("nroTipoEstadoProyecto");
        cr.add(c);
        v=FachadaPersistencia.getInstancia().buscar("TipoEstadoProyecto",cr);
        EstadoProyecto est=(EstadoProyecto)FabricaEntidades.getInstancia().obtenerEntidad("EstadoProyecto");
         
        est.setTipoEstadoProyecto((TipoEstadoProyecto)v.get(0));
        est.setFechaEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerFechaActual());
        est.setHoraEstadoProyecto(PracticasProfesionales.FechaHora.getInstancia().obtenerHoraActual());
        
        c.setAtributo("nroProyecto");
        c.setOperador("=");
        c.setValor(17);
       cr.clear();
       cr.add(c);
       
       Proyecto p= (Proyecto)FachadaPersistencia.getInstancia().buscar("Proyecto", cr).get(0);
       p.addEstadoProyecto(est);
       FachadaPersistencia.getInstancia().guardar("Proyecto", p);
      
       FachadaPersistencia.getInstancia().guardar("EstadoProyecto", est);
       
       Conexion.getInstancia().confirmarTransaccion();
       *//*
        
        //ProyectoCargo
        Conexion.getInstancia().iniciarTransaccion();
        ProyectoCargo pc=(ProyectoCargo) FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargo");
        pc.setCantPuestos(1);
        pc.setCdadLimPost(10);
        pc.setHorasEstimadas(6);
        
        Criterio c=new Criterio();
        Vector<Criterio> v=new Vector();
        c.setAtributo("nroCargo");
        c.setOperador("=");
        c.setValor(7);
        v.add(c);
        Cargo car=(Cargo)FachadaPersistencia.getInstancia().buscar("Cargo", v).get(0);
        v.clear();
        
        //Proyecto
        c.setAtributo("nroProyecto");
        c.setOperador("=");
        c.setValor(15);
        v.add(c);
        Proyecto proy=(Proyecto)FachadaPersistencia.getInstancia().buscar("Proyecto", v).get(0);
        
        pc.setCargo(car);
        proy.addProyectoCargo(pc);
        FachadaPersistencia.getInstancia().guardar("ProyectoCargo", pc);
        Conexion.getInstancia().confirmarTransaccion();
            */ //ProyectoCargoCarrera
        
        /*Conexion.getInstancia().iniciarTransaccion();
        ProyectoCargoCarrera pcc=(ProyectoCargoCarrera)FabricaEntidades.getInstancia().obtenerEntidad("ProyectoCargoCarrera");
        pcc.setCantMateriasReg(5);
        pcc.setCantMateriasRend(19);
        Criterio c= new Criterio();
        Vector v= new Vector();
        
        c.setAtributo("nroCarrera");
        c.setOperador("=");
        c.setValor(1);
        v.add(c);
        Carrera car= (Carrera)FachadaPersistencia.getInstancia().buscar("Carrera", v).get(0);
        pcc.setCarrera(car);
        
        ProyectoCargo pc =(ProyectoCargo)FachadaPersistenciaInterna.getInstancia().buscar("ProyectoCargo", "325317275162834754597526148317192535");
        pc.addProyectoCargoCarrera(pcc);
        FachadaPersistencia.getInstancia().guardar("ProyectoCargoCarrera", pcc);
       Conexion.getInstancia().confirmarTransaccion();
       
        
        
        
        
        /*
        http://192.168.30.225:8080/Univerisada_FRM_UTN/EstadoAcademicoEstudiante?wsdl        
        */
        /*
        Conexion.getInstancia().iniciarTransaccion();
        
        Vector v = new Vector();
        Vector<Criterio> criterios = new Vector();
        
        Criterio c = new Criterio();
        
        c.setAtributo("legajo");
        c.setOperador("=");
        c.setValor(33479);
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Estudiante", criterios);
        
        Estudiante erick = (Estudiante)v.get(0);
        
        Postulacion nPost = (Postulacion) FabricaEntidades.getInstancia().obtenerEntidad("Postulacion");
        
        PostulacionProyectoCargo nPPC = (PostulacionProyectoCargo) FabricaEntidades.getInstancia().obtenerEntidad("PostulacionProyectoCargo");
        
        EstadoPostulacion eP = (EstadoPostulacion) FabricaEntidades.getInstancia().obtenerEntidad("EstadoPostulacion");
        
        criterios.clear();
        v.clear();
        
        c.setAtributo("nombreTipoEstadoPostulacion");
        c.setOperador("=");
        c.setValor("Aceptada");
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("TipoEstadoPostulacion", criterios);
        
        eP.setFechaEstadoPostulacion(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(25, 11, 2014));
        eP.setHoraEstadoPostulacion(PracticasProfesionales.FechaHora.getInstancia().obtenerHoraActual());
        
        eP.setTipoEstadoPostulacion((TipoEstadoPostulacion)v.get(0));
        
        nPPC.addEstadoPostulacion(eP);
        
        criterios.clear();
        v.clear();
        
        c.setAtributo("nroProyecto");
        c.setOperador("=");
        c.setValor(15);
        criterios.add(c);
        
        v= FachadaPersistencia.getInstancia().buscar("Proyecto", criterios);
        
        Proyecto p = (Proyecto)v.get(0);
        
        criterios.clear();
        v.clear();
        
        ProyectoCargo pc = (ProyectoCargo) FachadaPersistenciaInterna.getInstancia().buscar("ProyectoCargo", "325317275162834754597526148317192535");
        
        EstadoAcademicoGeneral es= (EstadoAcademicoGeneral)FachadaPersistenciaInterna.getInstancia().buscar("EstadoAcademicoGeneral", "723061745062724712945775984279190253");
        
        nPost.setEstadoAcademicoGeneral(es);
        
        nPPC.setProyecto(p);
        nPPC.setProyectoCargo(pc);
        
        nPost.addPostProyCargo(nPPC);
        nPost.setfechaPostulacion(PracticasProfesionales.FechaHora.getInstancia().obtenerFecha(01, 11, 2013));
        nPost.sethoraPostulacion(PracticasProfesionales.FechaHora.getInstancia().obtenerHoraActual());
        nPost.setEstudiante(erick);
        
        FachadaPersistencia.getInstancia().guardar("Postulacion", nPost);
        FachadaPersistencia.getInstancia().guardar("PostulacionProyectoCargo", nPPC);
        FachadaPersistencia.getInstancia().guardar("EstadoPostulacion", eP);
        
        Conexion.getInstancia().confirmarTransaccion();
        
        * 
        * 
        * 
        **/
        
        ExpertoConsultarPostulaciones e=new ExpertoConsultarPostulaciones();
        
        DTO dto = e.buscarPostulaciones(33479);
        
        System.out.println(dto.size());
        
        
        //Conexion.getInstancia().confirmarTransaccion();
        
    }
    
}
