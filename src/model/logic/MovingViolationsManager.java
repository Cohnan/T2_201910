package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import api.IMovingViolationsManager;
import model.vo.VOMovingViolations;
import model.data_structures.LinkedList;

public class MovingViolationsManager implements IMovingViolationsManager {

	private LinkedList<VOMovingViolations> listaInfracciones;
	
	public void loadMovingViolations(String movingViolationsFile){
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("data/Moving_Violations_Issued_in_January_2018.csv"));
			listaInfracciones = new LinkedList<VOMovingViolations>(); 
			VOMovingViolations infraccion;
			System.out.println(reader.readNext()[0]); // Handle header
			
		    for (String[] row : reader) {
		    	infraccion = new VOMovingViolations(row);
		    	listaInfracciones.anadir(infraccion);
		    	//System.out.println("Se ha annadido la fila identificada por " + row[0] + "\n"); // TEST
		    }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

		
	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByViolationCode (String violationCode) {
		
		LinkedList<VOMovingViolations> lista = new LinkedList<>();
		
		listaInfracciones.reiniciarRecorrido();
		VOMovingViolations infraccion;
		try {
			infraccion = listaInfracciones.darActual();
		} catch (Exception e) {
			if (listaInfracciones.darTamano() != 0) {
				e.printStackTrace();
			}
			
			return new LinkedList<VOMovingViolations>();
		}
		//for (VOMovingViolations infraccion : listaInfracciones) {
		while (true) {
			//System.out.println("\nMirando a la infraccion para mirar su violatiocode: " + infraccion.objectId()); // TEST
			//System.out.println("El violation code de esta infraccion es: " + infraccion.getViolationCode()); // TEST
			if (infraccion.getViolationCode().equals(violationCode)) {
				lista.anadir(infraccion);
			}
			if (!listaInfracciones.tieneSiguiente()) break;
			infraccion = listaInfracciones.avanzar();
		}
		
		return lista;
	}

	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByAccident(String accidentIndicator) {
		
		LinkedList<VOMovingViolations> lista = new LinkedList<>();

		listaInfracciones.reiniciarRecorrido();
		VOMovingViolations infraccion;
		try {
			infraccion = listaInfracciones.darActual();
		} catch (Exception e) {
			if (listaInfracciones.darTamano() != 0) {
				e.printStackTrace();
			}
			
			return new LinkedList<VOMovingViolations>();
		}

		while (true) {
			if (infraccion.getAccidentIndicator().equals(accidentIndicator)) {
				lista.anadir(infraccion);
			}
			if (!listaInfracciones.tieneSiguiente()) break;
			infraccion = listaInfracciones.avanzar();
		}
		
		return lista;
	}	


}
