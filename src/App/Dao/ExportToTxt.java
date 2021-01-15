package App.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 生成txt文件类
 */
public class ExportToTxt {
    /**
     * 将xlsx文件转为txt文件
     * @throws IOException getText
     */
    @SuppressWarnings("deprecation")
    public static void getText() throws IOException {
        ArrayList<String> listMsg = new ArrayList<String>();
        File file = new File("users.xlsx");
        FileWriter filewriter = new FileWriter("users.txt");
        try {
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0); // 取得“测试.xlsx”中的第一个表单
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            Row row = null;
            Cell cell_a = null;
            Cell cell_b = null;
            Cell cell_c = null;
            Cell cell_d = null;
            for (int i = firstRowNum; i <= lastRowNum; i++) {
                row = sheet.getRow(i); // 取得第i行 （从第二行开始取，因为第一行是表头）
                cell_a = row.getCell(0); // 取得i行的第一列
                cell_b = row.getCell(1);// 取得i行的第二列
                cell_c = row.getCell(2);// 取得i行的第三列
                cell_d = row.getCell(3);// 取得i行的第四列
                cell_d.setCellType(CellType.STRING);
                String cellValue_1 = cell_a.getStringCellValue().trim();
                String cellValue_2 = cell_b.getStringCellValue().trim();
                String cellValue_3 = cell_c.getStringCellValue().trim();
                String cellValue_4 = cell_d.getStringCellValue().trim();
                filewriter.write("姓名:" + cellValue_1 + "\t账号:" + cellValue_2 + "\t密码:" + cellValue_3 + "\t余额:"
                        + cellValue_4 + "\r\n"); // 将取出的.xlsx表中的数据写入到txt文件中
                listMsg.add(cellValue_1);
            }
            filewriter.flush();
            filewriter.close();
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}