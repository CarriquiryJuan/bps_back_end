package org.controllers;

import java.util.LinkedList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.RepositoryIdFactory;

import dao.repository.NumeroRepository;
import dao.repository.SectorRepository;
import dao.repository.TramiteRepository;
import dataTypes.Sector;
import model.Numero;
import model.Sector;
import model.Tramite;

//import org.dao.repository.NumeroRepository;

public class SectorControlador {
	
	public void crearSector(String nom) throws Exception{
		System.out.println("hola desde crearSector");
		RepositoryFactory factory = RepositoryFactory.getInstance();
		SectorRepository sectorRepository = factory.getSectorRepositoryInstance();
		sectorRepository.crearSector(nom);
	}

	public List<Sector> listarSectores() {
		RepositoryFactory factory = RepositoryFactory.getInstance();
		SectorRepository sectorRepository = factory.getSectorRepositoryInstance();
		List<Sector> list = sectorRepository.listarSectores();
		List<Sector> ret = new LinkedList<Sector>();
		for (Sector s : list){
			Sector dt = new Sector(s.getSectorid(),s.getNombre());
			ret.add(dt);
		}
		
		return ret;
	}
	

}
