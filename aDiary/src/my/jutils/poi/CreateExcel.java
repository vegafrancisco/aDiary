package my.jutils.poi;

import java.io.*;
import java.util.*;

import org.apache.poi.xssf.usermodel.*;

/**
 * Process all data that will be written to the Excel file.
 * The process starts from reading the template Excel files. <br />
 * This will process the replacement of <b>placeholders</b> from the template file.
 * After the process from template, the Excel file will be written to the specified <b>save path</b>. <br /> <br />
 * <br />
 * <i>
 * Version history: <br />
 * <ul>
 *  <li> Version 1.0 - This has to be the simplest solution, but cell style was the problem. <br />
 *  <li> Version 1.5 - No methods added, just some logic. Cell style problem was fixed,
 *               but doesn't support the multiple detail placeholder. <br />
 *  <li>Version 2.0 - This version supports the detail placeholder, which works almost the same as the JasperReports. <br />
 *               But the current version only supports fixed column size, which means you can't exceed to your <br />
 *               template's number of columns, but row is capable of dynamic count. Methods were added to support <br />
 *               the new placeholder. Moved the old logic to the bottom most this class. <br />
 *               See Detail Placeholder sample @ http://pastebin.com/ZMLLGAMp, <br />
 *               and https://www.dropbox.com/s/kiluqafq8ofmxo8/template.xlsx for sample template file.
 * </ul>
 * </i>
 * <br />
 * Note: <i> Please see the JXLSUtil.java @ http://pastebin.com/Rf4FW9ir, this was for the mergeExcelFiles() method.</i> <br />
 * <br />
 * If you have questions or feedback, please don't hesitate to contact me. This will help us and others a lot!
 * Contact me at <i>erieze.lagera@gmail.com</i>
 * 
 * @author Erieze Lagera
 */
public class CreateExcel {

    /**
     * Path of the template Excel file.
     */
    private final String file_path;
    /**
     * Sheet index of your template.
     */
    private final int sheet_index;
    /**
     * Path for the resulting Excel file.
     */
    private final String save_path;
    /**
     * Sheet name for the resulting Excel workbook.
     */
    private final String sheet_name;
    /**
     * Contains the placeholders together with their value. <br />
     * <i> Note that the placeholder from the template should starts
     * with dollar sign (<b>$</b>). But dollar sign when putting placeholder
     * in HashMap is not necessary.
     */
    private final Map<String, Object> placeholders;
    
    /**
     * Create an Excel file that will contains the process data.
     * You must have the template Excel file before invoking this method,
     * because this is an dependent processing of Excel file. This needs a template file
     * to create a resulting Excel file.<br /> <br />
     * <i>
     * Note: If save path is null or empty, it will be moved to your <b>Desktop</b> directory.
     * And for file path, null or empty value will be handled by the IOException. <br /> <br />
     * Also the placeholder from the template should starts with dollar sign (<b>$</b>),
     * but not necessary when putting in the Hashmap. <br />
     * Ex. map.put("replaceMe", "Hello");
     * </i>
     * @param file_path Path of the template Excel file
     * @param sheet_index Sheet index of your template
     * @param save_path Path for the resulting Excel file
     * @param sheet_name Sheet name for the resulting Excel workbook
     * @param placeholders Contains the placeholders together with their value.
     */
    public CreateExcel(String file_path, int sheet_index, String save_path, String sheet_name, Map<String, Object> placeholders) {
        this.file_path = file_path;
        this.sheet_index = sheet_index;
        this.save_path = checkSavePath(save_path);
        this.sheet_name = sheet_name;
        this.placeholders = placeholders;
    }
    
    /**
     * Process the creation of the Excel report.
     * @return True if no error occurred during process, otherwise false.
     * @since 1.0
     */
    public boolean execute() {
        try (FileInputStream file = new FileInputStream(new File(file_path))) {
            // Load the template file
            final XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(sheet_index);
            XSSFRow row;
            XSSFCell cell;
            // For resulting Excel file
            XSSFWorkbook wb_new = new XSSFWorkbook();
            
            int row_index = 0;
            int cell_index = 0;
            String cell_str = "";
            
            /*** New: Cell index of the detail placeholder ***/
            int temp_cell_index = 0;
            
            /*** New: User must place #end to tell the program that it is the last row ***/
            // Get row until it reaches the #end
            while (true) {
                row = sheet.getRow(row_index);
                
                if (row == null) {
                    row = sheet.createRow(row_index++);
                }
                
                // We only support fixed column length and expanding row.
                for (cell_index = 0; cell_index < row.getPhysicalNumberOfCells(); cell_index++) {
                    cell = row.getCell(cell_index);
                    cell_str = cell.toString();
                    
                    if (isPlaceholder(cell_str)) {
                        cell.setCellValue(getValue(cell_str));
                    }
                    else if (isDetailPlaceholder(cell_str)) {
                        /* 
                         * Replace the detail placeholder with anything you want, 
                         * for now let's replace it with blank.
                         */
                        cell.setCellValue("");
                        
                        /*
                         * This will give a free row for the detail placeholder, 
                         * moving the existing rows based on detail row count.
                         */
                        int detail_count = getValueArr(cell_str).size();
                        sheet.shiftRows(row_index, row_index + detail_count, detail_count);
                        
                        temp_cell_index = cell_index;
                        for (ArrayList<String> valuesArr : getValueArr(cell_str)) {
                            row = sheet.createRow(row_index++);
                            for (String value : valuesArr) {
                                cell = row.createCell(cell_index++);
                                cell.setCellValue(value);
                            }
                            cell_index = temp_cell_index;
                        }
                    }
                    // To check if next row is the end
                    cell_str = sheet.getRow(row_index).getCell(0).toString();
                }
                // End the iteration
                if (isEndingCell(cell_str)) {
                    /*
                     * Replace the ending cell placeholder with anything you want, 
                     * for now let's replace it with blank.
                     */
                    row.getCell(0).setCellValue("");
                    break;
                }
                row_index++;
            }
            
            wb_new = JXLSUtil.mergeExcelFiles(wb_new, wb, sheet_name, 0);
            file.close();
            return doSaveExcelFile(wb_new);
        } catch (IOException e) { 
            System.out.println("[ERROR] " + e.getLocalizedMessage());
            return false;
        } catch (Exception e ) {
            e.printStackTrace();
            System.exit(0);
            return false;
        }
    }
    
    /**
     * Checks if the cell is a placeholder.
     * A placeholder always starts with a <i>dollar sign (<b>$</b>)</i>.
     * @param cell A cell in instance of String
     * @return True if the cell is a placeholder
     * @since 1.0
     */
    private boolean isPlaceholder(String cell) {
        return !cell.isEmpty() && cell.charAt(0) == '$';
    }
    
    /**
     * Check if the cell is a detail placeholder.
     * A detail placeholder always starts with <i>percent sign (<b>%</b>)</i>.
     * @param cell A cell in instance of String
     * @return True if the cell is a detail placeholder
     * @since 2.0
     */
    private boolean isDetailPlaceholder(String cell) {
        return !cell.isEmpty() && cell.charAt(0) == '%';
    }
    
    /**
     * Check if the cell is the ending cell (<b>#end</b>).
     * @param cell A cell in instance of String
     * @return True if the cell is the ending cell
     * @since 2.0
     */
    private boolean isEndingCell(String cell) {
        return cell.equalsIgnoreCase("#end");
    }
    
    /**
     * Get the value from the Hashmap by key.
     * The <b>key</b> is the placeholder from your template Excel file.
     * @param cell A cell in instance of String
     * @return The specified value for the specified placeholder
     * @since 1.0
     */
    private String getValue(String cell) {
        if (placeholders.containsKey(cell.substring(1))) {
            return (String) placeholders.get(cell.substring(1));
        }
        else {
            return cell;
        }
    }
    
    /**
     * Get the value in ArrayList from the Hashmap by key.
     * The <b>key</b> is the placeholder from your template Excel file.
     * @param cell A cell in instance of String
     * @return The specified value for the specified placeholder
     * @since 2.0
     */
    private ArrayList<ArrayList> getValueArr(String cell) {
        if (placeholders.containsKey(cell.substring(1))) {
            return (ArrayList<ArrayList>) placeholders.get(cell.substring(1));
        }
        else {
            // Just create an empty ArrayList to avoid NullPointerException
            ArrayList<ArrayList> a = new ArrayList<>();
            ArrayList<String> b = new ArrayList<>();
            b.add("");
            a.add(b);
            return a;
        }
    }
    
    /**
     * Save/Write the resulting excel file to the specified file path. <br />
     * Any caught exception such as <b>IOException</b> will interrupt the saving of file. <br /> <br />
     * <i>
     * Warning: This will replace the old file if there's already exists!
     * If you want to avoid overwritten of file, please do a simple evaluation first
     * before calling this method.
     * </i>
     * @param wb An instance of XSSFWorkbook, a class for MS Excel <b>2007</b> support.
     *           This must contain the rows and cell that is ready for saving.
     * @return True if no error occurs in process of saving, otherwise false.
     * @since 1.0
     */
    private boolean doSaveExcelFile(XSSFWorkbook wb) {
        try (FileOutputStream writeFile = new FileOutputStream(save_path)) {
            wb.write(writeFile);
            writeFile.flush();
            writeFile.close();
            return true;
        } catch (IOException e) {
            System.out.println("[ERROR] Encountered an error while saving the file.\n" + e.getLocalizedMessage());
            return false;
        }
    }
    
    /**
     * Check the nullity or emptiness value of save path. <br /> <br />
     * <i>
     * Note: File name will be out.xlsx by default.
     * </i>
     * @return If null or empty, the directory will be moved to your Desktop,
     *         otherwise return the user-specified path.
     * @since 1.0
     */
    private String checkSavePath(String save_path) {
        if (save_path == null || save_path.isEmpty()) {
            String path;
            path = System.getenv("userprofile") + "/Desktop/out.xlsx";
            System.out.println("[WARNING] save_path has null or empty value! This will be moved to " + path);
            return path;
        }
        else {
            return save_path;
        }
    }
    
}

/*** OLD VERSIONS ***/
/* Version 1.5
// Iterate the row from template
for (int row_i = 0; row_i < sheet.getPhysicalNumberOfRows(); row_i++) {
    row = sheet.getRow(row_i);
    // Iterate the cell of the current row from the template
    for (int cell_i = 0; cell_i < row.getPhysicalNumberOfCells(); cell_i++) {
        cell = row.getCell(cell_i);
        String cell_str = cell.toString();
        if (isPlaceholder(cell_str)) {
            cell.setCellValue(getValue(cell_str));
        }
    }
}
*/

/* Version 1.0
// Iterate the row
while (row_iter.hasNext()) { 
    XSSFRow xrow = (XSSFRow) row_iter.next(); 
    Iterator cell_iter = xrow.cellIterator();
    row = sheet_new.createRow(row_index++);

    // Iterate the cell from current row
    while (cell_iter.hasNext()) { 
        XSSFCell xcell = (XSSFCell) cell_iter.next();
        String cell_str = xcell.toString();
        cell = row.createCell(cell_index);

        // Search for available placeholder
        if (isPlaceholder(cell_str)) {
            cell.setCellValue(getValue(cell_str));
        }
        else {
            cell.setCellValue(cell_str);
        }
        cell_index++;
    }
    cell_index = 0;
}
*/
