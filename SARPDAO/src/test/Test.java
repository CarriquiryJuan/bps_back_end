package test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.repository.DisplayRepository;
import model.Display;

public class Test {
	public static void main(String[] args){
		//crearDisplay();
		//listarDisplays();
		modificarDisplay(8, "otraruta");
		System.out.println("FIN");
	}
	
	public static void crearDisplay(){
		System.out.println("1");
		DisplayRepository repo = new DisplayRepository();
		System.out.println("2");
		repo.crearDisplay("c:/ruta");
		
	}
	
	public static void listarDisplays(){
		System.out.println("1");
		DisplayRepository repo = new DisplayRepository();
		System.out.println("2");
		List<Display> lista = repo.listarDisplays();
	}
	
	public static void modificarDisplay(int codigo, String rutaArchivo){
		System.out.println("1");
		DisplayRepository repo = new DisplayRepository();
		System.out.println("2");
		try {
			repo.modificarDisplay(codigo, rutaArchivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
