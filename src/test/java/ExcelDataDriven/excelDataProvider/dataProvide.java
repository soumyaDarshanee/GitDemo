package excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	DataFormatter formatter = new DataFormatter();
	
	

	@Test(dataProvider = "driverTest")
	public void testCaseData(String greetings, String name, String id) {
		System.out.println(greetings + name + id);
	}

	@DataProvider(name = "driverTest")
	public Object[][] getData() throws IOException {
		// Object[][] data
		// ={{"Hello","Saumya","1"},{"Bye","Debesh","420"},{"Namaste","India","143"}};
		// return data;
		FileInputStream fis = new FileInputStream("C:\\Users\\soumy\\Downloads\\Soumya docs\\TestCases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		//for (int i = 0; i < sheets; i++) {
			//if (workbook.getSheetName(i).equalsIgnoreCase("demo")) {
				XSSFSheet sheet = workbook.getSheetAt(0);
				int rowCount = sheet.getPhysicalNumberOfRows();
				XSSFRow row = sheet.getRow(0);
				int colCount = row.getLastCellNum();
				Object data[][] = new Object[rowCount - 1][colCount];
				for (int j = 0; j < rowCount-1; j++) {
					row = sheet.getRow(j + 1);
					for (int k = 0; k < colCount; k++) {
						XSSFCell cell = row.getCell(k);
						data[j][k] = formatter.formatCellValue(cell);
					}
				}
				
		return data;
	}
}
