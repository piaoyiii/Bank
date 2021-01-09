package App._1WelcomePage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import App.Dao.DatabaseConnection02;
/**
 *
 * @author 1804507673@qq.com
 *
 */
public class WelcomePage extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * contentPane JPanel
     */
    private JPanel contentPane;
    /**
     * frame WelcomePage
     */
    public static WelcomePage frame = new WelcomePage();

    /**
     * 程序入口,显示欢迎界面
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建欢迎界面窗体
     */
    public WelcomePage() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 300, 640, 510);
        setIconImage(new ImageIcon("src/pictures/bitcoin.png").getImage());
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-workspace\\Bank\\src\\pictures\\bitcoinbank.png"));
        lblNewLabel.setBounds(10, 10, 604, 115);
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(10, 135, 604, 326);
        contentPane.add(panel);
        panel.setBackground(new Color(52, 80, 164));
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("请选择所需服务", JLabel.CENTER);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 26));
        lblNewLabel_1.setBounds(160, 0, 265, 60);
        panel.add(lblNewLabel_1);

        JLabel lblZhanghao = new JLabel("账号：");
        lblZhanghao.setHorizontalAlignment(SwingConstants.CENTER);
        lblZhanghao.setForeground(Color.WHITE);
        lblZhanghao.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblZhanghao.setBounds(150, 125, 60, 35);
        panel.add(lblZhanghao);

        JTextField textZhanghao = new JTextField();
        textZhanghao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textZhanghao.setBounds(220, 125, 195, 35);
        textZhanghao.setColumns(15);
        panel.add(textZhanghao);

        JLabel lblMima = new JLabel("密码：");
        lblMima.setHorizontalAlignment(SwingConstants.CENTER);
        lblMima.setForeground(Color.WHITE);
        lblMima.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblMima.setBounds(150, 170, 60, 35);
        panel.add(lblMima);

        JPasswordField textMima = new JPasswordField();
        textMima.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textMima.setBounds(220, 170, 195, 35);
        textMima.setColumns(20);
        panel.add(textMima);

        JButton btnDenglu = new JButton("登录");
        btnDenglu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String account = textZhanghao.getText();
                    String password = new String(textMima.getPassword());
                    DatabaseConnection02.logOn(account, password);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnDenglu.setFont(new Font("微软雅黑", Font.BOLD, 12));
        btnDenglu.setBounds(220, 215, 95, 35);
        panel.add(btnDenglu);

        JButton btnGuanliyuan = new JButton("管理员登录");
        btnGuanliyuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String adminaccount = textZhanghao.getText();
                    String adminpassword = new String(textMima.getPassword());
                    DatabaseConnection02.logOnAdmin(adminaccount, adminpassword);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnGuanliyuan.setFont(new Font("微软雅黑", Font.BOLD, 12));
        btnGuanliyuan.setBounds(320, 215, 95, 35);
        panel.add(btnGuanliyuan);

        JButton btnChuangjian = new JButton("<html>未拥有账户？<br>点击此处注册<html>");
        btnChuangjian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frmRejister = new Rejister();
                frmRejister.setVisible(true);
            }
        });
        btnChuangjian.setFont(new Font("微软雅黑", Font.BOLD, 12));
        btnChuangjian.setBounds(265, 260, 110, 35);
        panel.add(btnChuangjian);

        JButton btnTuichu = new JButton("退出");
        btnTuichu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        btnTuichu.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnTuichu.setBounds(489, 281, 105, 35);
        panel.add(btnTuichu);
    }
}
