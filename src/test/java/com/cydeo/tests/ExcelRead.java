package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";
        //to rea from excel we need to load it to FileInput Stream
        FileInputStream fileInputStream= new FileInputStream(path);

        //workbook>sheet>row>cell

        //<1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //<2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3> Select row and cell
        //Print out MAry's cell
        //Indexes start from 0!!!!!

        System.out.println(sheet.getRow(1).getCell(0));
        //print out Developer
        System.out.println(sheet.getRow(3).getCell(2));
        System.out.println("Linda search by row/cell: " + sheet.getRow(4).getCell(0));

        //Return the count of used cells only

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows: "+usedRows);

        //Return the number from top cell to bottom cell
        //It doesn't care if the cell is empty or not
        //Starts counting from 0

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUSedRow: " +  lastUsedRow);
        
        //TODO: Create a logic to print Vinod's name

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }

        }

        //TODO: Create a logic to print out Mary's Job_ID

        //Check if name is Mary --> print out Job_ID of Mary

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println("Mary's JOB_ID is " + sheet.getRow(rowNum).getCell(2));
            }
        }


    }


}
