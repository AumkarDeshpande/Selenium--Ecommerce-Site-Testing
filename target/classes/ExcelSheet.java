package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	
public ArrayList<String> getData() throws IOException {
		
		ArrayList<String> data = new ArrayList<String>();
		
		//create an object for FileInputStream to get the excel path
		FileInputStream fis = new FileInputStream("F:\\Eclipse -Photon\\Amazon_Testing\\Data.xlsx");
		
		//create an object for XSSF workbook class
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//count totalNumberOFSheets in that excel file
		int totalSheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<totalSheets; i++) {	
			//compare selected sheet with "Sheet1"
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {		
				
				//get access to required sheet --> "Sheet1"
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Identify Testcases column by scanning all the rows starting from first row
				//get access to all row of sheet
				Iterator<Row> rows = sheet.iterator();
				Row presentRow = rows.next();		//firstRow conatins titleName --> no use here
				while(rows.hasNext()) {
					//access to specific row  from all rows
					presentRow = rows.next();		//enter first row i.e "1"

					//get access to all cells of row
					Iterator<Cell> cells = presentRow.cellIterator();
				
					while(cells.hasNext()) {
						Cell value = cells.next();	//enter first column i.e "A" --> now we are @A1
						data.add(value.getStringCellValue());	//extract the value and store in data
					}
					
				}
			}
		}
		workbook.close();
		return data;
	}

}
