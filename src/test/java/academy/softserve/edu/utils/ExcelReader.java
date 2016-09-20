package academy.softserve.edu.utils;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {


    public static String[][] saveDataInToArrayFromExcel(final String linkExcelData) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(linkExcelData);

        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet1 = workBook
                .getSheetAt(0);

        final int numberOfRows = sheet1
                .getPhysicalNumberOfRows();
        final int numberOfCells = sheet1
                .getRow(0)
                .getPhysicalNumberOfCells();

        //I appoint the array size by the number of rows and cells of Excel document
        final String[][] loginData = new String[numberOfRows][numberOfCells];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCells; j++) {

                loginData[i][j] = sheet1
                        .getRow(i)
                        .getCell(j)
                        .getStringCellValue();
            }
        }
        fileSystem.close();

        return loginData;
    }


    public static String[][] getColumnByName(final String linkExcelData, final String cellName) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(linkExcelData);

        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet1 = workBook
                .getSheetAt(0);
        final Row row = sheet1.getRow(0);
        final int numberOfRows = sheet1
                .getPhysicalNumberOfRows() - 1;
        final int numberOfCells = row
                .getPhysicalNumberOfCells();

        final String[][] columnArray = new String[numberOfRows][1];
        int cellColumn = 0;

        for (int j = 0; j < numberOfCells; j++) {
            if (cellName
                    .equals(row.getCell(j)
                            .getStringCellValue())) {
                cellColumn = j;
            }
        }
        int j = 1;
        for (int i = 0; i < numberOfRows; i++) {
            columnArray[i][0] = sheet1
                    .getRow(j)
                    .getCell(cellColumn)
                    .getStringCellValue();
            j++;
        }
        fileSystem.close();
        return columnArray;
    }

}
