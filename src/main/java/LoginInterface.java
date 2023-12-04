// 确保导入以下包
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public LoginInterface() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Walmart Ecommerce System Login");
        setSize(800, 600); // 设置窗口大小
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel loginPanel = createLoginPanel();
        cardPanel.add(loginPanel, "LoginPanel");

        // 添加用户面板
        for (String user : new String[]{"zch", "BellaR", "Harper", "IsaC", "Julia"}) {
            cardPanel.add(createUserPanel(user), user);
        }

        add(cardPanel);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(new Color(255, 255, 255, 123)); // 半透明背景
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (DatabaseConnector.validateUser(username, password)) {
                    cardLayout.show(cardPanel, username);
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(createLabeledField("Username:", usernameField));
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(createLabeledField("Password:", passwordField));
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(loginButton);

        return loginPanel;
    }

    private JPanel createLabeledField(String label, JComponent field) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel jLabel = new JLabel(label);
        panel.add(jLabel);
        panel.add(field);
        return panel;
    }

    private JPanel createUserPanel(String username) {
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.add(new JLabel("Welcome, " + username), BorderLayout.CENTER);
        return userPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginInterface frame = new LoginInterface();
            frame.setVisible(true);
        });
    }
}
