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
 * 转账界面类
 *
 */
public class Transfer extends JFrame {

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
     * textField_1JTextField
     */
    private JTextField textField_1;
    /**
     * textField_2 JTextField
     */
    private JTextField textField_2;
    /**
     * passwordField JPasswordField
     */
    private JPasswordField passwordField;

    /**
     * 创建转账窗体
     * @param myAccount String
     */
    public Transfer(String myAccount) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 300, 300, 200);
        setIconImage(new ImageIcon("src/pictures/bitcoin.png").getImage());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("请输入对方账号：");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 10, 130, 20);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 12));
        textField.setBounds(140, 10, 130, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("请输入对方姓名：");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 35, 130, 20);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("微软雅黑", Font.BOLD, 12));
        textField_1.setBounds(140, 35, 130, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("请输入转账金额：");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 60, 130, 20);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
        textField_2.setBounds(140, 60, 130, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("请输入密码：");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(10, 85, 130, 20);
        contentPane.add(lblNewLabel_3);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("微软雅黑", Font.BOLD, 12));
        passwordField.setBounds(140, 85, 130, 20);
        contentPane.add(passwordField);

        JButton btnQueren = new JButton("确认");
        btnQueren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String othersAccount = textField.getText();
                    String othersName = textField_1.getText();
                    Double money = Double.parseDouble(textField_2.getText());
                    String password = new String(passwordField.getPassword());
                    DatabaseConnection02.transferring(myAccount, othersAccount, othersName, money, password);
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
