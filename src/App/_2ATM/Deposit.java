package App._2ATM;

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
 * 存款界面类
 *
 */
public class Deposit extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * contentPane JPanel
     */
    private JPanel contentPane;
    /**
     * textField JTextField
     */
    private JTextField textField;
    /**
     * passwordField JPasswordField
     */
    private JPasswordField passwordField;

    /**
     * 创建存款窗体
     * @param account String
     */
    public Deposit(String account) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 300, 300, 200);
        setIconImage(new ImageIcon("src/pictures/bitcoin.png").getImage());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("请输入存款额：");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 23, 130, 20);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 12));
        textField.setBounds(140, 23, 130, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("请输入密码：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 73, 130, 20);
        contentPane.add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("微软雅黑", Font.BOLD, 12));
        passwordField.setBounds(140, 73, 130, 20);
        contentPane.add(passwordField);

        JButton btnQueren = new JButton("确认");
        btnQueren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double money = Double.parseDouble(textField.getText());
                    String password = new String(passwordField.getPassword());
                    DatabaseConnection02.depositing(account, money, password);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnQueren.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnQueren.setBounds(28, 119, 93, 20);
        contentPane.add(btnQueren);

        JButton btnNewButton = new JButton("取消");
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        btnNewButton.setBounds(163, 119, 93, 20);
        contentPane.add(btnNewButton);
    }
}
