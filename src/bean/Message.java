package bean;

/**
 * 账户信息类
 */
public class Message {

    /**
     * name 用户姓名 account 账号 password 密码 balance 余额
     */
    private String name;
    private String account;
    private String password;
    private Double balance;

    /**
     * 空构造方法
     */
    public Message() {
    }

    /**
     * 有参构造方法
     * @param name String
     * @param account String
     * @param password String
     * @param balance Double
     */
    public Message(String name, String account, String password, Double balance) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    /**
     * 获取用户姓名
     *
     * @return 用户的姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 传回用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户账号
     *
     * @return 用户的账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 传回用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户密码
     *
     * @return 用户的密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户余额
     *
     * @return 用户的余额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 设置用户余额
     *
     * @param balance 传回用户余额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 重写.toString()方法
     * @return "Message [name=" + name + ", account=" + account + ", password=" + password + ", balance=" + balance+ "]"
     */
    @Override
    public String toString() {
        return "Message [name=" + name + ", account=" + account + ", password=" + password + ", balance=" + balance+ "]";

    }

}
