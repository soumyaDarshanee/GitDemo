

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	
	public ArrayList<String> getData(String TestCaseName) throws IOException
	{
		ArrayList<String> aList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\soumy\\Downloads\\Soumya docs\\TestCases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("test")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// identify the sheet column by scanning entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row fisrtRow = rows.next();
				Iterator<Cell> cells = fisrtRow.cellIterator();// row is collection of cells
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell cellValue = cells.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;// get the index of column
					}
					k++;

					// once column is identified , scan the entire column to find the testcase row

					while (rows.hasNext()) {
						Row rowValue = rows.next();
						if (rowValue.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)) {

							// once row is identified - pull all the data from row and feed to testcase
							Iterator<Cell> cellVal = rowValue.iterator();
							while (cellVal.hasNext()) {
								Cell c = cellVal.next();
								if(c.getCellType()==CellType.STRING)
								{
								aList.add(c.getStringCellValue());
								}
								else {
									aList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
									
								}
							}

						}

					}

				}
			}
					}
		
		return aList;

	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
	}
}
