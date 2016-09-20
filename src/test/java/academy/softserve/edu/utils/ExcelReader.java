package academy.softserve.edu.utils;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {


    public static String[][] saveDataInToArrayFromExcel( final String linkExcelData) throws IOException {

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
}
