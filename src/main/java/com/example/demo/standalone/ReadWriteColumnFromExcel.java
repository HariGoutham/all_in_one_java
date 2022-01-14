package com.example.demo.standalone;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadWriteColumnFromExcel {

	// In run configuration , program arguments give path of excel, it will be passed in main method args
	// Example Path : C:\Users\User\Desktop\Numbers.xlsx
	// Format column in excel to be text other wise if numbers alone are given exception will thrown	
	public static void main(String[] args) {
		Workbook workbook;
		List<String> asns = new ArrayList<>();
		try {
			File file = new File(args[0]);
			FileInputStream fileInputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(fileInputStream);
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			Sheet sheet = sheetIterator.next();
			Iterator<Row> rowIterator = sheet.rowIterator();
			int count = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					System.out.println(cell.getStringCellValue());
					asns.add(cell.getStringCellValue());
				}
				count++;
			}
			System.out.println("Total msgs " + count);
			fileInputStream.close();

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ignore");
		}

		System.out.println(asns);

	}

}
