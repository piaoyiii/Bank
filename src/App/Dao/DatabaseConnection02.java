package App.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import App._2ATM.Atm;
import App._3Admin.Admin;
import bean.Message;
/**
* 数据库操作类
*/
public class DatabaseConnection02 {
    /**
     * DBDRIVER String
     */
    // 定义SQLServer的数据库驱动程序
    public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    /**
     * DBURL String
     */
    // 定义SQLServer数据库的连接地址
    public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Users";
    /**
     * DBUSER String
     */
    // SQL数据库的连接用户名
    public static final String DBUSER = "sa";
    /**
     * DBPASS String
     */
    // MySQL数据库的连接密码
    public static final String DBPASS = "12345";
    /***
    * 取得或返回用户信息
    * @param account String
    * @return msg Message
    * @throws Exception getMessage
    */
    public Message getMessage(String account) throws Exception {
        Message msg = new Message();
        Connection conn = null; // 数据库连接
        PreparedStatement ps = null;// 数据库操作
        ResultSet rs = null;// 保存查询结果
        String sql = "SELECT name,account,balance FROM Users " + " WHERE account = ? ";// SQL语句
        Class.forName(DBDRIVER);// 加载驱动程序
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        ps = conn.prepareStatement(sql);// 实例化PreparedStatement
        ps.setString(1, account);// 为第一个问号赋值
        rs = ps.executeQuery();// 实例化ResultSet对象
        if (rs.next()) {
            msg.setName(rs.getString("name"));
            msg.setAccount(rs.getString("account"));
            msg.setBalance(rs.getDouble("balance"));
        }
        rs.close();// 关闭结果集
        ps.close();// 操作关闭
        conn.close();// 数据库关闭
        return msg;
    }

    /***
    * 存款
    * @param account String
    * @param money Double
    * @param password String
    * @throws Exception depositing
    */
    public static void depositing(String account, Double money, String password) throws Exception {
        if (money > 0) {
            Message msg = new Message();
            Connection conn = null;// 数据库连接
            PreparedStatement ps = null;// 数据库操作
            PreparedStatement ps_1 = null;
            ResultSet rs = null;// 保存查询结果
            String sql = "SELECT * FROM Users " + "WHERE account = ? AND password = ? ";// SQL语句
            Class.forName(DBDRIVER);// 加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
            ps = conn.prepareStatement(sql);// 实例化PreparedStatement
            ps.setString(1, account);// 为第二个问号赋值
            ps.setString(2, password);// 为第三个问号赋值
            rs = ps.executeQuery();
            if (rs.next()) {
                msg.setBalance(rs.getDouble("balance"));
                String sql_1 = "UPDATE Users " + "SET balance += ? WHERE account = ? ";// 实现本账户金额增加
                ps_1 = conn.prepareStatement(sql_1);
                ps_1.setDouble(1, money);
                ps_1.setString(2, account);
                if (ps_1.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "存款成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    conn.commit();
                    ps_1.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            ps.close();// 操作关闭
            conn.close();// 数据库关闭
        } else {
            JOptionPane.showMessageDialog(null, "请输入正确的存款额", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }

    /***
     * 取款
     * @param account String
     * @param money String
     * @param password String
     * @throws Exception cashing
     */
    public static void cashing(String account, Double money, String password) throws Exception {
        if (money > 0) {
            Message msg = new Message();
            Connection conn = null;// 数据库连接
            PreparedStatement ps = null;// 数据库操作
            PreparedStatement ps_1 = null;
            ResultSet rs = null;// 保存查询结果
            String sql = "SELECT * FROM Users " + "WHERE account = ? AND password = ? ";// SQL语句
            Class.forName(DBDRIVER);// 加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
            ps = conn.prepareStatement(sql);// 实例化PreparedStatement
            ps.setString(1, account);// 为第二个问号赋值
            ps.setString(2, password);// 为第三个问号赋值
            rs = ps.executeQuery();
            if (rs.next()) {
                msg.setBalance(rs.getDouble("balance"));
                if (msg.getBalance() >= money) {// 判断余额与所取金额的大小关系
                    String sql_1 = "UPDATE Users " + "SET balance -= ? WHERE account = ? ";// 实现本账户金额减少
                    ps_1 = conn.prepareStatement(sql_1);
                    ps_1.setDouble(1, money);
                    ps_1.setString(2, account);
                    if (ps_1.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "取款成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                        conn.commit();
                        ps_1.close();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "账户可用余额不足", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            ps.close();// 操作关闭
            conn.close();// 数据库关闭
        } else {
            JOptionPane.showMessageDialog(null, "请输入正确的存款额", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }

    /***
     * 转账
     * @param myAccount String
     * @param othersAccount String
     * @param othersName String
     * @param money Double
     * @param password String
     * @throws Exception transferring
     */
    public static void transferring(String myAccount, String othersAccount, String othersName, Double money,
            String password) throws Exception {
        if (money > 0) {
            Message msg = new Message();
            Connection conn = null;
            PreparedStatement ps = null;
            PreparedStatement ps_1 = null;
            PreparedStatement ps_2 = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM Users " + "WHERE account = ? AND password = ? ";
            Class.forName(DBDRIVER);// 加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
            ps = conn.prepareStatement(sql);
            ps.setString(1, myAccount);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                msg.setBalance(rs.getDouble("balance"));
                if (msg.getBalance() >= money) {// 判断余额与所取金额的大小关系
                    String sql_1 = "UPDATE Users " + "SET balance -= ? " + "WHERE account = ? ";// 实现本账户金额减少
                    ps_1 = conn.prepareStatement(sql_1);
                    ps_1.setDouble(1, money);
                    ps_1.setString(2, myAccount);
                    if (ps_1.executeUpdate() > 0) {
                        String sql_2 = "UPDATE Users " + "SET balance += ? " + "WHERE account = ? AND name = ? ";// 实现他人账户金额增加
                        ps_2 = conn.prepareStatement(sql_2);
                        ps_2.setDouble(1, money);
                        ps_2.setString(2, othersAccount);
                        ps_2.setString(3, othersName);
                        if (ps_2.executeUpdate() > 0) {
                            JOptionPane.showMessageDialog(null, "转账成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                            conn.commit();
                            ps_1.close();
                            ps_2.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "对方信息有误,正在还原操作", "错误", JOptionPane.ERROR_MESSAGE);
                            conn.rollback();
                            ps_1.close();
                            ps_2.close();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "账户可用余额不足", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            ps.close();
            conn.close();
        } else {
            JOptionPane.showMessageDialog(null, "请输入正确的存款额", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }

    /***
     * 注册账户
     * @param name String
     * @param account String
     * @param password String
     * @param password_1 String
     * @throws Exception register
     */
    public static void register(String name, String account, String password, String password_1) throws Exception {
        if (password_1.equals(password)) {
            Connection conn = null;
            PreparedStatement ps = null;
            PreparedStatement ps_1 = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM Users " + "WHERE account = ? ";
            Class.forName(DBDRIVER);// 加载驱动程序
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            if (rs.next() == false) {// 判断账号是否存在
                String sql_1 = "INSERT INTO Users " + " VALUES ( ?, ?, ?, '0' ) ";
                ps_1 = conn.prepareStatement(sql_1);
                ps_1.setString(1, name);
                ps_1.setString(2, account);
                ps_1.setString(3, password);
                if (ps_1.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    conn.commit();
                    ps_1.close();
                } else {
                    JOptionPane.showMessageDialog(null, "注册失败", "错误", JOptionPane.ERROR_MESSAGE);
                    conn.rollback();
                    ps_1.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "此账户已存在,创建失败", "错误", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            ps.close();
            conn.close();
        } else {
            JOptionPane.showMessageDialog(null, "密码验证失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * 登录账号
     * @param account String
     * @param password String
     * @throws Exception logOn
     */
    public static void logOn(String account, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps_1 = null;
        ResultSet rs = null;
        ResultSet rs_1 = null;
        String sql = "SELECT * FROM Users " + "WHERE account = ? ";
        Class.forName(DBDRIVER);// 加载驱动程序
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
        ps = conn.prepareStatement(sql);
        ps.setString(1, account);
        rs = ps.executeQuery();
        if (rs.next()) {// 判断账号是否存在
            String sql_1 = "SELECT * FROM Users " + "WHERE account = ? AND password = ? ";
            ps_1 = conn.prepareStatement(sql_1);
            ps_1.setString(1, account);
            ps_1.setString(2, password);
            rs_1 = ps_1.executeQuery();
            if (rs_1.next()) {
                JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                JFrame frmAtm = new Atm(account);
                frmAtm.setVisible(true);
                conn.commit();
                ps_1.close();
            } else {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
                ps_1.close();
            }
            rs_1.close();
        } else {
            JOptionPane.showMessageDialog(null, "该用户不存在", "错误", JOptionPane.ERROR_MESSAGE);
        }
        rs.close();
        ps.close();
        conn.close();
    }

    /***
     * 登录管理员账号
     * @param adminaccount String
     * @param adminpassword String
     * @throws Exception logOnAdmin
     */
    public static void logOnAdmin(String adminaccount, String adminpassword) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps_1 = null;
        ResultSet rs = null;
        ResultSet rs_1 = null;
        String sql = "SELECT * FROM Administrator " + "WHERE adminaccount = ? ";
        Class.forName(DBDRIVER);// 加载驱动程序
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
        ps = conn.prepareStatement(sql);
        ps.setString(1, adminaccount);
        rs = ps.executeQuery();
        if (rs.next()) {// 判断账号是否存在
            String sql_1 = "SELECT * FROM Administrator " + "WHERE adminaccount = ? AND adminpassword = ? ";
            ps_1 = conn.prepareStatement(sql_1);
            ps_1.setString(1, adminaccount);
            ps_1.setString(2, adminpassword);
            rs_1 = ps_1.executeQuery();
            if (rs_1.next()) {
                JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                JFrame frmAdmin = new Admin();
                frmAdmin.setVisible(true);
                conn.commit();
                ps_1.close();
            } else {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
                ps_1.close();
            }
            rs_1.close();
        } else {
            JOptionPane.showMessageDialog(null, "该用户不存在", "错误", JOptionPane.ERROR_MESSAGE);
        }
        rs.close();
        ps.close();
        conn.close();
    }

    /***
     * 注销账户
     * @param name String
     * @param account String
     * @param password String
     * @throws Exception delete
     */
    public static void delete(String name, String account, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps_1 = null;
        PreparedStatement ps_2 = null;
        ResultSet rs = null;
        ResultSet rs_1 = null;
        String sql = "SELECT * FROM Users " + "WHERE name = ? AND account = ? ";
        Class.forName(DBDRIVER);// 加载驱动程序
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        conn.setAutoCommit(false);// 将事物自动提交改为不自动提交
        ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, account);
        rs = ps.executeQuery();
        if (rs.next()) {// 判断账号是否存在
            String sql_1 = "SELECT * FROM Users " + "WHERE account = ? AND balance = 0 ";
            ps_1 = conn.prepareStatement(sql_1);
            ps_1.setString(1, account);
            rs_1 = ps_1.executeQuery();
            if (rs_1.next()) {
                String sql_2 = "DELETE FROM Users " + "WHERE name = ? AND account = ? AND password = ? ";
                ps_2 = conn.prepareStatement(sql_2);
                ps_2.setString(1, name);
                ps_2.setString(2, account);
                ps_2.setString(3, password);
                if (ps_2.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    conn.commit();
                    ps_2.close();
                    System.exit(1);
                } else {
                    JOptionPane.showMessageDialog(null, "注销失败", "错误", JOptionPane.ERROR_MESSAGE);
                    conn.rollback();
                    ps_2.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "账户还有余额,无法注销,请将余额取完后再试", "警告", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "姓名验证失败失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
