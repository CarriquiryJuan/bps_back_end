
package com.sarp.services;


import java.util.List;


import com.sarp.classes.BusinessPuesto;
import com.sarp.classes.BusinessSector;
import com.sarp.classes.BusinessTramite;
import com.sarp.dao.controllers.DAOPuestoController;
import com.sarp.dao.controllers.DAOSectorController;
import com.sarp.dao.controllers.DAOTramiteController;
import com.sarp.dao.factory.DAOFactory;
import com.sarp.dao.factory.DAOServiceFactory;
import com.sarp.enumerados.EstadoPuesto;
import com.sarp.factory.Factory;


public class AdminService {
	
	
	public void altaPuesto(String nombreMaquina) throws Exception{	
		DAOServiceFactory daoServiceFactory = DAOServiceFactory.getInstance();
		DAOPuestoController controladorPuesto = daoServiceFactory.getDAOPuestoController();
		BusinessPuesto puesto = new BusinessPuesto();
		puesto.setNombreMaquina(nombreMaquina);
		//INSERT en DaoService
		controladorPuesto.crearPuesto(puesto);
	}
	
	public void bajaPuesto(String nombreMaquina) throws Exception{
		DAOServiceFactory daoServiceFactory = DAOServiceFactory.getInstance();
		DAOPuestoController controladorPuesto = daoServiceFactory.getDAOPuestoController();
		//DELETE en DaoService
		controladorPuesto.eliminarPuesto(nombreMaquina);
	}
	
	public void modificarPuesto(String nombreMaquina,String estado,String usuarioId) throws Exception {
		//Si se modifico algun campo del puesto entonces se llama a DaoService y se hace Update
		if(estado != null || usuarioId != null){
			DAOServiceFactory daoServiceFactory = DAOServiceFactory.getInstance();
			DAOPuestoController controladorPuesto = daoServiceFactory.getDAOPuestoController();
			BusinessPuesto puesto = controladorPuesto.obtenerPuesto(nombreMaquina);
		
			if(estado != null){
				EstadoPuesto estonuevo = EstadoPuesto.getEnum(estado);
				puesto.setEstado(estonuevo);
			}
			if(usuarioId != null){
				puesto.setUsuarioId(usuarioId);
			}
			//Se delega a DaoService
			controladorPuesto.modificarPuesto(puesto);
		}
	}
		
	public List<BusinessPuesto> listarPuestos(BusinessSector sector) throws Exception{
		DAOServiceFactory daoServiceFactory = DAOServiceFactory.getInstance();
		DAOPuestoController controladorPuesto = daoServiceFactory.getDAOPuestoController();
		List<BusinessPuesto> puestos;
		//Traigo los puestos de un sector desde DaoService
		//si sector es null entonces traigo todos los puestos del sistema		
		if(sector != null){
			DAOSectorController controladorSector = daoServiceFactory.getDAOSectorController();
			puestos = controladorSector.selectPuestoSector(sector);
		}else{
			puestos = controladorPuesto.listarPuestos();
		}
		
		return puestos;
		
	}
	
	/****** Alta, Baja & Modificacion de Tramite ******/
	
	public void altaTramite(BusinessTramite tramite) throws Exception{	
		/* primero se pide el controlador de tramites mediante la factory */
		
		DAOServiceFactory factory = DAOServiceFactory.getInstance();
		DAOTramiteController tramCtrl = factory.getDAOTramiteController();
		
		/* Finalmente se persiste en la base mediante el llamado del controlador */
		tramCtrl.crearTramite(tramite);
	}
	
	public void bajaTramite(int codigo){
		/* primero se pide el controlador de tramites mediante la factory */
		
		DAOServiceFactory factory = DAOServiceFactory.getInstance();
		DAOTramiteController tramCtrl = factory.getDAOTramiteController();
		
		/* Finalmente se persiste en la base mediante el llamado del controlador */
		tramCtrl.eliminarTramite(codigo);
	}
	
	public void modificarTramite(BusinessTramite tramite){
		/* primero se pide el controlador de tramites mediante la factory */
		
		DAOServiceFactory factory = DAOServiceFactory.getInstance();
		DAOTramiteController tramCtrl = factory.getDAOTramiteController();
		
		/* Finalmente se persiste en la base mediante el llamado del controlador */
		tramCtrl.modificarTramite(tramite);
	}
	
}
