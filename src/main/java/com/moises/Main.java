package com.moises;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePath = "./src/main/resources/sample_file.xlsx";
        extractPeopleFromExcel(filePath);
    }

    public static List<Person> extractPeopleFromExcel(String filePath) {

        List<Person> people = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));

            // Using XSSF for xlsx format
            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            // Skip header row
            if(iterator.hasNext()) {
                iterator.next();
            }
            int rowNum = 1;

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                Long id = (long) rowNum;
                String firstName = currentRow.getCell(0).getStringCellValue();
                String lastName = currentRow.getCell(1).getStringCellValue();
                String gender = currentRow.getCell(2).getStringCellValue();
                String country = currentRow.getCell(3).getStringCellValue();
                Integer age = (int) currentRow.getCell(4).getNumericCellValue();
                String dob = currentRow.getCell(5).getStringCellValue();
                Integer registerNumber = (int) currentRow.getCell(6).getNumericCellValue();

                Person person = new Person(id, firstName, lastName, gender, country, age, dob, registerNumber);
                people.add(person);

                rowNum++;
            }

            for (Person person : people) {
                System.out.println(person + "\n");
            }

            System.out.println("Total number objects created: " + people.size());

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }


    public static void readExcel(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));

            // Using XSSF for xlsx format
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}