package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

@Test
    public void red_from_excel_file() throws IOException {
    String path="SampleData.xlsx";
    File file=new File(path);
    //to read from excel we need it to FileInput Stream
    FileInputStream fileInputStream=new FileInputStream(file);

    //workbook>sheet>row>cell
    //<1>Create a workbook

    XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

    //<2> We need to specific sheet from currently opened workbook
    XSSFSheet sheet=workbook.getSheet("Employees");

    //<3> Select row and cell
    //printout Mary's cell
    //index start from zero

    System.out.println(sheet.getRow(1).getCell(0));
    //print out Developer
    System.out.println(sheet.getRow(3).getCell(2));

    //Return the count of used cells only
    //starts counting  from1
    int usedRows=sheet.getPhysicalNumberOfRows();
    System.out.println("usedRows = " + usedRows);

    //return the number from top cell to bottom cell
    //it doesnt care if cell is empty or not
    //starts from counting from zero
    int lastUsedRow=sheet.getLastRowNum();
    System.out.println("lastUsedRow = " + lastUsedRow);

    //TODO: create logic to print Vinod's name
    for (int rowNum=0; rowNum<usedRows ; rowNum++) {
        if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
            System.out.println(sheet.getRow(rowNum).getCell(0));
        }

    }
    
    //TODO: create logic to printout Linda's jobID
    
    //chek if name is Linda and it will print out jobID of Linda
    for (int rowNum = 0; rowNum < usedRows; rowNum++) {
        if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
            System.out.println("linda's jobID "+sheet.getRow(rowNum).getCell(2));
        }
        
    }

}
}
