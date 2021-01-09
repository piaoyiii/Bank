package App.Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Message;

/**
 *
 * 生成表格文件类
 *
 */
public class GetExcel {
    /**
     *
     * @param listMsg List
     * @throws IOException getExcel
     */
    @SuppressWarnings({ "rawtypes", "unused" })
    public static void getExcel(List<Message> listMsg) throws IOException {
        Vector<Vector> rows = new Vector<Vector>();// 定义要返回的所有记录集合
        File file = new File("users.xlsx");// 定位要操作的excel文件
        Workbook workbook = new XSSFWorkbook();// 创建工作簿对象
        Sheet sheet = workbook.createSheet("users");// 创建工作表对象
        Message msg = new Message();
        DatabaseConnection01 dbcs = new DatabaseConnection01();// 使用1中定义的连接数据库的类
        ResultSet rs = null;
        try (Connection conn = dbcs.getConnection(); // 获取数据库接
                PreparedStatement pstmt = conn.prepareStatement("select * from Users");) {
            rs = pstmt.executeQuery();
            if (rs.next()) {
                msg.setName(rs.getString("name"));
                msg.setAccount(rs.getString("account"));
                msg.setPassword(rs.getString("password"));
                msg.setBalance(rs.getDouble("balance"));
                int i = 0;
                for (Message msg1 : listMsg) {
                    Row row = sheet.createRow(i);// 创建行对象，下标从0开始
                    Cell cell1 = row.createCell(0);// 创建单元格，从0开始
                    cell1.setCellValue(msg1.getName());
                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue(msg1.getAccount());
                    Cell cell3 = row.createCell(2);
                    cell3.setCellValue(msg1.getPassword());
                    Cell cell4 = row.createCell(3);
                    cell4.setCellValue(msg1.getBalance());
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(file);) {
            workbook.write(fos);// 将内容写入到指定的excel文档
        } catch (IOException e) {
            e.printStackTrace();
        }
        workbook.close();
    }

    /**
     * 生成表格文件
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Message> listMsg = new ArrayList<Message>();
        try {
            getExcel(listMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
