package automation.com.finca;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;


public class ExcelUtils {
	 XSSFWorkbook excelWorkbook = null;
	 XSSFSheet excelSheet = null;
	 XSSFRow row = null;
	 XSSFCell cell = null;
	 public Object[][] getData() throws IOException {
	 FileInputStream fis = new FileInputStream(Constants.EXCEL_PATH); 
	 excelWorkbook = new XSSFWorkbook(fis);
	 excelSheet = excelWorkbook.getSheet("finca");
	 // Find number of rows in excel file
	 int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
	 int colCount = excelSheet.getRow(0).getLastCellNum();
	 Object data[][] = new Object[rowCount-1][colCount];
	 for (int rNum = 2; rNum <= rowCount; rNum++) {
	 for (int cNum = 0; cNum < colCount; cNum++) {
	 data[rNum - 2][cNum] = getCellData("finca", cNum, rNum); //Your sheet name
	 }
	 System.out.println();
	 }
	 return data;
	 }
	 public String getCellData(String sheetName, int colNum, int rowNum) {
	 try {
	 if (rowNum <= 0)
	 return "";
	 int index = excelWorkbook.getSheetIndex(sheetName);
	 if (index == -1)
	 return "";
	 excelSheet = excelWorkbook.getSheetAt(index);
	 row = excelSheet.getRow(rowNum - 1);
	 if (row == null)
	 return "";
	 cell = row.getCell(colNum);
	 if (cell == null)
	 return "";
	 if (cell.getCellType() == CellType.STRING)
	 return cell.getStringCellValue();
	 else if (cell.getCellType() == CellType.NUMERIC
	 || cell.getCellType() == CellType.FORMULA) {
	 String cellText = String.valueOf(cell.getNumericCellValue());
	 return cellText;
	 } else if (cell.getCellType() == CellType.BLANK)
	 return "";
	 else
	 return String.valueOf(cell.getBooleanCellValue());
	 } catch (Exception e) {
	 e.printStackTrace();
	 return "row " + rowNum + " or column " + colNum
	 + " does not exist in xls";
	 }
	 }
	 
}