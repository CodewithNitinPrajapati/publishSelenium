package com.selenium.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TempData implements Iterator<Object[]> {

	
	public TempData() throws IOException {
		List<String> list = new ArrayList<String>();
        String path = ("./src/test/java/com/selenium/testData/SampleData.xlsx");
		
		int rownum = XLUtils.getRowCount(path , "AddProduct");
		int colcount = XLUtils.getCellCount(path , "AddProduct");
		
		String data[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j] = XLUtils.getCellData(path , "AddProduct", i ,j);
			}
		}
		Arrays.asList(data);
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] next() {
		// TODO Auto-generated method stub
		return null;
	}
}
