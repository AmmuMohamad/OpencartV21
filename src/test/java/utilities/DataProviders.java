package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/testData/Opencart_Testdata.xlsx";
		
		ExcelUtils.loadExcel(path, "Sheet1");
		int rowCount=ExcelUtils.getRowCount();
		Object[][] data=new Object[rowCount-1][2];
		
		for(int i=1;i<rowCount;i++) {
				
				data[i-1][0]=ExcelUtils.getCellDataString(i, 0);   //username
				data[i-1][1]=ExcelUtils.getCellDataString(i, 1);   //password
				
		}
		
		return data;//returning two dimension array
		
	}

}
