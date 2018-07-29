package aDiary_data;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonio
 */
import aDiary.Propietario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import my.jutils.poi.*;

/**
 *Esta clase es utilizada para leer el Excel en la ejecucion del programa.
 * Utilizando la libreria de Apache POI 3.17 ()
 * @author PCAMPOS
 */
public class LecturaExcel {
    
    private ArrayList<Dato> datos;
    private Dato data;
    private int valorUltimaFila;
    private String contenidoCelda;
    private boolean estadoLeerExcel;
    
    public LecturaExcel(){
        this.data= new Dato();
        contenidoCelda = "";
        this.valorUltimaFila=0;
        datos = new ArrayList<>();
    }
    /**
     * Lee una hoja (sheetName) de un Excel.
     * @param rutaFile Ruta del archivo (String)
     * @param sheetName Nombre de la hoja del excel (String).
     * @throws IOException 
     */
    public void readExcel(String rutaFile, String sheetName) throws IOException {
        String dataAux = "";
        File file = new File (""); 
        FileInputStream inputStream = new FileInputStream(file);  
        XSSFWorkbook excelWorkbook ; 
        excelWorkbook = new XSSFWorkbook(inputStream);
        Sheet excelSheet = excelWorkbook.getSheet(sheetName);
        this.valorUltimaFila = excelSheet.getLastRowNum();
        int filasCount = this.valorUltimaFila-excelSheet.getFirstRowNum();
        int cellNum;
        
        for (int i=0; i< filasCount+1 ; i++) { 
            Row filas;
            filas = excelSheet.getRow(i);
            cellNum = filas.getLastCellNum(); 
            for (int j=0 ; j < cellNum; j++) { 
                try{
                    dataAux += filas.getCell(j).getStringCellValue() + ";";
                } catch (NullPointerException e){
                    dataAux += "EMPTYCELL;";
                } 
            }
            dataAux += "%";
            
        }
        this.data.setContenido(dataAux);
    }
    
    /**
     * Este metodo lee el contenicdo de una celda solicitada
     * @param numFila número de la fila en donde se encuentra la celda en EXCEL
     * @param numColumna número de la columna en donde se encuentra la celda en EXCEL
     * @param rutaExcel ruta del archivo EXCEL
     * @throws IOException 
     */
    
    public void readContenidoCelda(int numFila, int numColumna, String rutaExcel) throws IOException{
        InputStream ExcelParaLeer = new FileInputStream(rutaExcel); 
        XSSFWorkbook wb = new XSSFWorkbook(ExcelParaLeer) ; 
        XSSFSheet sheet = wb.getSheetAt(0); 
        XSSFRow row = null ; 
        XSSFCell cell = null ;
        
        row = sheet.getRow(numFila);
        cell = row.getCell(numColumna);

        try{
            contenidoCelda = cell.getStringCellValue();
        }catch (NullPointerException e){
            
        }
    }
    
    public String getContenidoCelda(){
        return contenidoCelda;
    }
    
    /**
     * Obtiene el valor de la ultima Fila
     * @return el valor de la ultima fila (int)
     */
    
    public int getValorUltimaFila(){
        return this.valorUltimaFila;
    }
    
    /**
     * Obtiene los datos.
     * @return data (Dato)
     */
    
    public Dato getData(){
        return this.data;
    }
    
    public void leerExcel(Propietario usr, String rutaExcel){
        File file = new File(rutaExcel);
        FileInputStream inputStream = null;
        boolean noCatch = true;
        
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            noCatch = false;
            
        }
        
        if(noCatch){
            XSSFWorkbook excelWorkbook = null;
            try {
                excelWorkbook = new XSSFWorkbook(inputStream);
            } catch (IOException ex) {
                //Logger.getLogger(LecturaExcel.class.getName()).log(Level.SEVERE, null, ex);
                noCatch = false;
            }
            if(noCatch){
                Sheet excelSheet = excelWorkbook.getSheet("Hoja1");
                this.valorUltimaFila = excelSheet.getLastRowNum();
                int filasCount = this.valorUltimaFila-excelSheet.getFirstRowNum();
                int cellNum;
        
                for (int i=0; i< filasCount+1 ; i++) { 
                    Row filas;
                    filas = excelSheet.getRow(i);
                    cellNum = filas.getLastCellNum();
                    
                    for (int j=0 ; j < cellNum; j++) { 
                        Dato aux = new Dato();
                        this.datos.add(aux);
                        try{
                            aux.setContenido(filas.getCell(j).getStringCellValue());
                            //dataAux += filas.getCell(j).getStringCellValue() + ";";
                        } catch (NullPointerException e){
                            aux.setContenido("EMPTYCELL");
                            //dataAux += "EMPTYCELL;";
                        }
                        aux.setColumna(j);
                        aux.setFila(i);
                        System.out.println(aux);
                    }
            
                }
            }
        } else {
        	HashMap map = new HashMap<Object, Object>();
            CreateExcel nuevoExcel = new CreateExcel("./template.xlsx",0,rutaExcel,"Hoja1",(Map)map);
            if(nuevoExcel.execute()) {
            	leerExcel(usr, rutaExcel);
            }
        }
        
        
        this.estadoLeerExcel = noCatch;
        
    }
    
    
    public ArrayList<Dato> getDatos() {
        return datos;
    }

    public boolean isEstadoLeerExcel() {
        return estadoLeerExcel;
    }

    public void setDatos(ArrayList<Dato> datos) {
        this.datos = datos;
    }

    public void setData(Dato data) {
        this.data = data;
    }

    public void setValorUltimaFila(int valorUltimaFila) {
        this.valorUltimaFila = valorUltimaFila;
    }

    public void setContenidoCelda(String contenidoCelda) {
        this.contenidoCelda = contenidoCelda;
    }

    public void setEstadoLeerExcel(boolean estadoLeerExcel) {
        this.estadoLeerExcel = estadoLeerExcel;
    }
    
    
    
    
}
