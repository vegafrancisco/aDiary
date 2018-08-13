package aDiary_data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Esta clase puede modificar un excel por celda si se instancia y se llama su unico método.
 * @author PCampos
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ModExcel {
    
    private String valorACambiar;
    private String valorNuevo;
    
    
    public ModExcel(String valorNuevo, String valorACambiar){
        this.valorNuevo = valorNuevo;
        this.valorACambiar = valorACambiar;
    }
    
    public ModExcel() {
    	this.valorNuevo = "";
    	this.valorACambiar = "";
    }
    
    
    private int[] obtenerPosicionDato(String rutaExcel) {
    	//init
    	int[] pos = new int[2];
    	BusquedaDatos busqueda = new BusquedaDatos(this.valorACambiar);
    	
    	if(busqueda.buscarCoincidencia(rutaExcel)) {
    		pos[0] = busqueda.getDatoBusqueda().getFila();
    		pos[1] = busqueda.getDatoBusqueda().getColumna();
    		
    		return pos;
    	}
    	
    	
    	return null;
    	
    }
    
    /**
     * Modifica El valor de una celda con el valor que se le entrega
     * 
     * @param hoja - valor de la posicion de la hoja
     * @param rutaExcel Ruta del Archivo EXCEL.
     */
    
    public boolean modificarCelda(String rutaExcel, int hoja) { 
    	
    	XSSFWorkbook wb = iniciarWorkbook(rutaExcel);
        XSSFSheet sheet = wb.getSheetAt(hoja); 
        XSSFRow row; 
        XSSFCell cell;
        
        /*if(valor.equals("END!")){
            sheet.createRow(numFila);
        }*/
        
        int[] posicionDato = obtenerPosicionDato(rutaExcel);
        
        if(posicionDato != null) {
        	
        	row = sheet.getRow(posicionDato[0]); //fila
            cell = row.getCell(posicionDato[1]); //columna
        	cell.setCellValue(this.valorNuevo); 
        	writeExcel(wb, rutaExcel);
        	
        }else {
        	return false;
        }
        
        closeWorkbook(wb);
        
        return true;
       
    
    }
    
    public void prepararCeldas(String rutaExcel, int cantidadDatos, int hoja) {
		XSSFWorkbook wb = iniciarWorkbook(rutaExcel);
		XSSFSheet sheet = wb.getSheetAt(hoja);
		XSSFRow row; 
		XSSFCell cell;
		sheet.createRow(sheet.getLastRowNum()+1);
		row = sheet.getRow(sheet.getLastRowNum());
         
		for(int i = 0; i<cantidadDatos; i++) {
			cell = row.createCell(i);
		}
         
         
		writeExcel(wb, rutaExcel);
        
        closeWorkbook(wb);
    }
    
    public void moldearExcel(String rutaExcel, int moldeoCeldas,int hoja) {
    	XSSFWorkbook wb = iniciarWorkbook(rutaExcel);
        XSSFSheet sheet = wb.getSheetAt(hoja);
        XSSFRow row; 
        XSSFCell cell;
        row = sheet.getRow(0);
        for(int i = 1; i<moldeoCeldas; i++) {
        	cell = row.createCell(i);
        }
        
    	writeExcel(wb, rutaExcel);
        
        closeWorkbook(wb);
        
    }
    
    public void prepararHoja(String rutaExcel) {
    	XSSFWorkbook wb = iniciarWorkbook(rutaExcel);
        XSSFSheet sheet = wb.createSheet();
        XSSFRow row; 
        XSSFCell cell;
        row = sheet.createRow(0);
        cell = row.createCell(0);
        
        writeExcel(wb, rutaExcel);
        
        closeWorkbook(wb);
        
    }
    
    private void closeWorkbook(XSSFWorkbook wb) {
    	try {
			wb.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void writeExcel(XSSFWorkbook wb, String rutaExcel) {
    	try (FileOutputStream arcSalida = new FileOutputStream(rutaExcel)) {
            wb.write(arcSalida);
        }catch(IOException e){
                
        }
    }
    
    private XSSFWorkbook iniciarWorkbook(String rutaExcel) {
    	InputStream ExcelParaLeer = null; 
        try {
            ExcelParaLeer = new FileInputStream(rutaExcel);
        } catch (FileNotFoundException ex) {
            //https://pastebin.com/kKfLTwcY
            Logger.getLogger(ModExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        XSSFWorkbook wb = null; 
        try {
            wb = new XSSFWorkbook(ExcelParaLeer);
        } catch (IOException ex) {
            Logger.getLogger(ModExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wb;
    }

	public String getValorNuevo() {
		return valorNuevo;
	}


	public void setValorNuevo(String valor) {
		this.valorNuevo = valor;
	}


	public String getValorACambiar() {
		return valorACambiar;
	}


	public void setValorACambiar(String valorACambiar) {
		this.valorACambiar = valorACambiar;
	}
	
	
    
    
    
}