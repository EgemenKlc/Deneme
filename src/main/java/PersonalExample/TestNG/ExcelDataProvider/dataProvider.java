package PersonalExample.TestNG.ExcelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataProvider {

    @Test
    public void TestCaseData(){

    }

    // multiple sets of data to our test
    // arraypublic

   @DataProvider(name = "driveTest")
    public Object [][] getData() throws IOException {


        FileInputStream fis = new FileInputStream("C:\\Users\\10132817\\Desktop\\Data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();

        Object Data [][]= new Object[rowCount-1][colCount];

        for(int i = 0; i<rowCount-1; i++)
        {
            row = sheet.getRow(i+1);
            for(int j=0; j<colCount; j++)
            {
                Data[i][j] = row.getCell(j);
            }
        }


        return Data;
    }


}
