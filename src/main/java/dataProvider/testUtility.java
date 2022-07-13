package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import com.excel.utility.XLS_Reader;

public class testUtility {
	
	static XLS_Reader reader;
	

	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		try {
			reader = new XLS_Reader(System.getProperty("user.dir")+"/ExleFiles/addressdataprovider.xlsx");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		for (int rowNum =2; rowNum<=reader.getRowCount("Address"); rowNum++) {
			
			    String country = reader.getCellData("Address","country", rowNum);
				String fullName = reader.getCellData("Address", "fullName",rowNum);
				String phoneNumber = reader.getCellData("Address", "phoneNumber", rowNum);
				String addressLine1 = reader.getCellData("Address", "addressLine1",rowNum);
				String addressLine2 = reader.getCellData("Address", "addressLine2",rowNum);
				String City = reader.getCellData("Address", "City",rowNum);
				String Provience= reader.getCellData("Address", "Provience", rowNum);				
				String postalCode = reader.getCellData("Address", "postalCode",rowNum);
				
				Object  ab[] = {country,fullName,phoneNumber,addressLine1,addressLine2,City,Provience,postalCode};
				myData.add(ab);
				
				
			
			
			}
		return myData;
		}
	  
	   
	}
	

/*
		public static long PAGE_LOAD_TIMEOUT = 20;
		public static long IMPLICIT_WAIT = 20;

		public static String TESTDATA_SHEET_PATH = "C:\\Users\\dipro\\eclipse-workspace\\"
				+ "AmazonYouraccount\\ExleFiles\\addressdataprovider.xlsx";

		static Workbook book;
		static Sheet sheet;
		static JavascriptExecutor js;

		

		public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}
	
	*/
	
	


	
