package com.sri.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;


public class CommonUtilities extends TestBase{
	
public void validateErrormsg(String actualmsg, String errormsg) {
	
	if(actualmsg.equals(errormsg))
	{
		System.out.println("TestCase is passed");
		logger.log(LogStatus.PASS,  "TestCase is passed" );
	}else
    {
	System.out.println("TestCase is failed");
	logger.log(LogStatus.FAIL,  "TestCase is failed" );
    }
}

public  String[][] readXlData() throws IOException{
	String path = System.getProperty("user.dir")+"\\Resources\\check.xls";
	System.out.println(path);
	FileInputStream fs=new FileInputStream(new File(path));
	System.out.println(fs);
	HSSFWorkbook wb=new HSSFWorkbook(fs);
	//System.out.println("work book : " + wb);
	HSSFSheet sheet=wb.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum()+1;
	int colCount=sheet.getRow(0).getLastCellNum();
	String[][] data=new String[rowCount][colCount];
	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	for(int i=0;i<rowCount;i++){
		for(int j=0;j<colCount;j++){
			System.out.println(i + " " +j);
			int cellType=sheet.getRow(i).getCell(j).getCellType();
			if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
				int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
				data[i][j]=String.valueOf(val);
			}
			else
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(data[i][j]);
		}
	}
	return (data);
}


}
