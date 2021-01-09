package App._2ATM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import App.Dao.DatabaseConnection02;
import bean.Message;
/**
 *
 * Atm界面类
 *
 */
public class Atm extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * contentPane JPanel
     */
    private JPanel contentPane;
    /**
     * lblNewLabel JLabel
     */
    JLabel lblNewLabel = new JLabel();
    /**
     * lblNewLabel_3v JLabel
     */
    JLabel lblNewLabel_3 = new JLabel();
    /**
     * lblNewLabel_5v JLabel
     */
    JLabel lblNewLabel_5 = new JLabel();
    /**
     * lblNewLabel_7 JLabel
     */
    JLabel lblNewLabel_7 = new JLabel();

    /**
     * 显示ATM界面主窗体
     * @param account String
     */
    public Atm(String account) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(510, 310, 640, 510);
        setIconImage(new ImageIcon("src/pictures/bitcoin.png").getImage());
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JButton btnCunkuan = new JButton("<html><CENTER>存款<br><Center>Deposit<html>");
        btnCunkuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Deposit(lblNewLabel_5.getText());
                frame.setVisible(true);
            }
        });
        btnCunkuan.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnCunkuan.setBounds(0, 70, 130, 50);
        panel.add(btnCunkuan);

        JButton btnQukuan = new JButton("<html><CENTER>取款<br><CENTER>Cash<html>");
        btnQukuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Cash(lblNewLabel_5.getText());
                frame.setVisible(true);
            }
        });
        btnQukuan.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnQukuan.setBounds(0, 140, 130, 50);
        panel.add(btnQukuan);

        JButton btnZhuanzhang = new JButton("<html><CENTER>转账<br><CENTER>Transfer<html>");
        btnZhuanzhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Transfer(lblNewLabel_5.getText());
                frame.setVisible(true);
            }
        });
        btnZhuanzhang.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnZhuanzhang.setBounds(474, 70, 130, 50);
        panel.add(btnZhuanzhang);

        JButton btnShuaxin = new JButton("<html><CENTER>刷新查询<br><CENTER>Query<html>");
        btnShuaxin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message str;
                try {
                    str = new DatabaseConnection02().getMessage(account);
                    lblNewLabel_7.setText(str.getBalance().toString());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnShuaxin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnShuaxin.setBounds(474, 140, 130, 50);
        panel.add(btnShuaxin);

        JButton btnZhuxiao = new JButton("<html><CENTER>注销<br><CENTER>Delete<html>");
        btnZhuxiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame frame = new Delete(lblNewLabel_5.getText());
                    frame.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnZhuxiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnZhuxiao.setBounds(0, 266, 130, 50);
        panel.add(btnZhuxiao);

        JButton btnTuichu = new JButton("<html><CENTER>退出<br><CENTER>Exit<html>");
        btnTuichu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnTuichu.setForeground(Color.BLACK);
        btnTuichu.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnTuichu.setBounds(474, 266, 130, 50);
        panel.add(btnTuichu);

        JLabel lblNewLabel_2 = new JLabel("您的姓名：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNewLabel_2.setBounds(188, 70, 100, 30);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_3.setBounds(288, 70, 80, 30);
        Message str_2 = null;
        try {
            str_2 = new DatabaseConnection02().getMessage(account);
            lblNewLabel_3.setText(str_2.getName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("您的账号：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNewLabel_4.setBounds(188, 104, 100, 30);
        panel.add(lblNewLabel_4);

        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_5.setBounds(288, 104, 80, 30);
        Message str_1;
        try {
            str_1 = new DatabaseConnection02().getMessage(account);
            lblNewLabel_5.setText(str_1.getAccount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("账户余额：");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNewLabel_6.setBounds(188, 138, 100, 30);
        panel.add(lblNewLabel_6);

        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_7.setForeground(Color.WHITE);
        lblNewLabel_7.setBounds(288, 138, 80, 30);
        panel.add(lblNewLabel_7);
        Message str_3;
        try {
            str_3 = new DatabaseConnection02().getMessage(account);
            lblNewLabel_7.setText(str_3.getBalance().toString());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setForeground(Color.WHITE);
        lblNewLabel_8.setIcon(new ImageIcon(Atm.class.getResource("/pictures/比特币单位.png")));
        lblNewLabel_8.setBounds(378, 138, 30, 30);
        panel.add(lblNewLabel_8);

    }
}
