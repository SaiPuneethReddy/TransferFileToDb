package com.experiment.TransferFileToDb.helper;

import com.experiment.TransferFileToDb.datamodel.Tutorial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelHelper {
    public static List <Tutorial> excelToTutotial(InputStream is){
        List<Tutorial> tutorialList =new ArrayList<>();
        try{
            DataFormatter df = new DataFormatter();
           Workbook workbook= new XSSFWorkbook(is);
           Sheet sheet= workbook.getSheet("tutorial");
            Iterator<Row> rows=  sheet.iterator();
            int rowNumber=0;
            while(rows.hasNext()){
                Row currentRow=rows.next();
                System.out.println("rowNumber: "+rowNumber);
                if(rowNumber==0){
                    rowNumber++;
                    continue;
                }
             Iterator<Cell> cells= currentRow.iterator();
                Tutorial eachTutorial =new Tutorial();
                int columnNumber=0;
                while(cells.hasNext()){
                    Cell currentCell =cells.next();
                    System.out.println("columnNumber: "+columnNumber);
                    switch (columnNumber){
                        case 0:
                           eachTutorial.setId(Long.parseLong(df.formatCellValue(currentCell)));
                            break;
                        case 1:
                            eachTutorial.setTitle(df.formatCellValue(currentCell));
                            break;
                        case 2:
                            eachTutorial.setDiscription(df.formatCellValue(currentCell));
                            break;
                        case 3:
                            eachTutorial.setPublishedOn(LocalDate.parse(df.formatCellValue(currentCell)));
                            break;
                        default:
                            break;

                    }
                    columnNumber++;
                }
                tutorialList.add(eachTutorial);
                rowNumber++;
            }

        }
        catch(Exception e){
            System.out.println("Exception in excelToTutorail "+e);
        }
     return tutorialList;
    }
}
