package org.msg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

@Component
public class ReadFileCsv {

	List<String> mailList;
	
	public ReadFileCsv() {
		mailList= new ArrayList<String>();
	}

	public Map<String,String> getAllMailList() throws IOException
	{
		InputStream inputStream=null;
		 Map<String,String> map1= new HashMap<String,String>();
		try {
		ClassLoader classLoader = this.getClass().getClassLoader();
		   // Getting resource(File) from class loader
		   File configFile=new File(classLoader.getResource("email.xls").getFile());
		 System.out.println("file name is"+configFile);
		   inputStream = new FileInputStream(configFile);
		   HSSFWorkbook  wb = new HSSFWorkbook (inputStream);  
		 
		   HSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
		   int i=1;
		   Cell cell;
		   Cell cell1;
		   do {
			   Row row= sheet.getRow(i);
			 cell=row.getCell(0) ;
			 cell1=row.getCell(1);
			 System.out.println(cell1);
			 if(cell!=null)
			 {
			mailList.add(cell.toString());
			 map1.put(cell.toString(), cell1.toString());
			 }
			i++;
		   }
		   while(cell!=null);
		   
		  } catch (FileNotFoundException e) {
		 
		   e.printStackTrace();
		  }catch (IOException e) {
		 
		   e.printStackTrace();
		  }
		  finally {
		   inputStream.close();
		  }
	
		System.out.println("************"+map1);
		return map1;
	}
}
