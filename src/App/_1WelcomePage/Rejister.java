package App._1WelcomePage;

import java.awt.Color;
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
 * 账户注册类
 *
 */
public class Rejister extends JFrame{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * frame JFrame
     */
    private JFrame frame;
    /**
     * contentPane JPanel
     */
    private JPanel contentPane;
    /**
     * textXingming JTextField
     */
    private JTextField textXingming;
    /**
     * textZhanghao JTextField
     */
    private JTextField textZhanghao;
    /**
     * textMima JPasswordField
     */
    private JPasswordField textMima;
    /**
     * textMima_1 JPasswordField
     */
    private JPasswordField textMima_1;
    /**
     *
     */

    /**
     * 创建账户注册窗体
     */
    public Rejister() {
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

        JLabel lblNewLabel_1 = new JLabel("注册账号", JLabel.CENTER);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 26));
        lblNewLabel_1.setBounds(160, 0, 265, 60);
        panel.add(lblNewLabel_1);

        JLabel lblXingming = new JLabel("姓名：");
        lblXingming.setHorizontalAlignment(SwingConstants.CENTER);
        lblXingming.setForeground(Color.WHITE);
        lblXingming.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblXingming.setBounds(150, 80, 60, 35);
        panel.add(lblXingming);

        textXingming = new JTextField();
        textXingming.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textXingming.setBounds(220, 80, 196, 35);
        textXingming.setColumns(15);
        panel.add(textXingming);

        JLabel lblZhanghao = new JLabel("账号：");
        lblZhanghao.setHorizontalAlignment(SwingConstants.CENTER);
        lblZhanghao.setForeground(Color.WHITE);
        lblZhanghao.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblZhanghao.setBounds(150, 125, 60, 35);
        panel.add(lblZhanghao);

        textZhanghao = new JTextField();
        textZhanghao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textZhanghao.setBounds(220, 125, 196, 35);
        textZhanghao.setColumns(15);
        panel.add(textZhanghao);

        JLabel lblMima = new JLabel("密码：");
        lblMima.setHorizontalAlignment(SwingConstants.CENTER);
        lblMima.setForeground(Color.WHITE);
        lblMima.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblMima.setBounds(150, 170, 60, 35);
        panel.add(lblMima);

        textMima = new JPasswordField();
        textMima.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textMima.setBounds(220, 170, 196, 35);
        textMima.setColumns(20);
        panel.add(textMima);

        JLabel lblNewLabel_2 = new JLabel("再次输入以验证：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblNewLabel_2.setBounds(50, 215, 161, 35);
        panel.add(lblNewLabel_2);

        textMima_1 = new JPasswordField();
        textMima_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textMima_1.setBounds(220, 215, 196, 35);
        textMima_1.setColumns(20);
        panel.add(textMima_1);

        JButton btnNewButton = new JButton("确认");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textXingming.getText();
                    String account = textZhanghao.getText();
                    String password = new String(textMima.getPassword());
                    String password_1 = new String(textMima_1.getPassword());
                    DatabaseConnection02.register(name, account, password, password_1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 12));
        btnNewButton.setBounds(265, 260, 110, 35);
        panel.add(btnNewButton);

        JButton btnTuichu = new JButton("退出");
        btnTuichu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                frame.dispose();
            }
        });
        btnTuichu.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnTuichu.setBounds(489, 281, 105, 35);
        panel.add(btnTuichu);
    }

}
