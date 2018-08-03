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
    
    private String valor;
    
    public ModExcel(){
        this.valor = "";
    }
    
    /**
     * Modifica El valor de una celda con el valor que se le entrega
     * 
     * @param numFila número de la fila en donde se encuentra la celda en EXCEL.
     * @param numCol número de la columna en donde se encuentra la celda en EXCEL.
     * @param rutaExcel Ruta del Archivo EXCEL.
     * @throws IOException 
     */
    public void modificarCelda(int numFila, int numCol, String rutaExcel) { 
        rutaExcel = "";
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
        XSSFSheet sheet = wb.getSheetAt(0); 
        XSSFRow row; 
        XSSFCell cell; 
        
        if(valor.equals("END!")){
            sheet.createRow(numFila);
        }
        
        row = sheet.getRow(numFila);
        cell = row.getCell(numCol);
        
        try{
            cell.getStringCellValue();
        }catch (NullPointerException e){
            cell = sheet.getRow(numFila).createCell(numCol);
        }
        cell.setCellValue(valor); 
        try (FileOutputStream arcSalida = new FileOutputStream(rutaExcel)) {
            wb.write(arcSalida);
        }catch(IOException e){
            
        }
    }
    
}