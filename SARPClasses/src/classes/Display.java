package classes;

import java.util.Date;
import java.util.List;

public class Display {
	private String rutaArchivo;
	private Date fechaCreacion;
	private Date fechaUltModificaion;

	public Display(){
	}

	public Display(String rutaArchivo ){
		this.fechaCreacion = new Date();
		this.fechaUltModificaion= new Date();
		this.rutaArchivo=rutaArchivo;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public Date getFechaUltModificaion() {
		return fechaUltModificaion;
	}

	public void setFechaUltModificaion(Date fechaUltModificaion) {
		this.fechaUltModificaion = fechaUltModificaion;
	}
	
	
}

