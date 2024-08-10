package com.selenium.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "AddProduct")
	public Iterator<Object[]> getDataadd() throws IOException {
        String path = ("./src/test/java/com/selenium/testData/SampleData.xlsx");
		
		int rownum = XLUtils.getRowCount(path , "AddProduct");
		int colcount = XLUtils.getCellCount(path , "AddProduct");
		
		//String logindata[][] = new String[rownum][colcount];
		List<Object[]> lst = new ArrayList<Object[]>();
		//Object[] arr = new Object[rownum];
		
		String[] arr = new String[rownum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				arr[i-1] = XLUtils.getCellData(path , "AddProduct", i ,j);
				//lst.add(new Object[] {XLUtils.getCellData(path , "AddProduct", i ,j)});
			}
		}
		lst.add(new Object[] {arr});
		
		return lst.iterator();
		
	  //return

	}




}
