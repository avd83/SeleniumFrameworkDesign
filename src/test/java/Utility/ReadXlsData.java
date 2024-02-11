package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.io.File;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlsData {

	
	@DataProvider(name="readdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException
	{
 
		String excelsheetname = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = WorkbookFactory.create(fis);
		Sheet sheetname = w.getSheet(excelsheetname);
		
		int totalrows = sheetname.getLastRowNum();
		System.out.println(totalrows);
		Row rowcells = sheetname.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		System.out.println(totalcols);
		
		DataFormatter df = new DataFormatter();
		
		String testData[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				 testData[i-1][j]=df.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
		
	}

}
