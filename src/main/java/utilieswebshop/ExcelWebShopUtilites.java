package utilieswebshop;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelWebShopUtilites {
	
	public static Object[][] getData(String filePath, String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object [][] data=new Object[rows][cols];
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		
		workbook.close();
		fis.close();
		return data;
		
	}
    
	public static String registeredEmail;
    public static String registeredPassword;
}
