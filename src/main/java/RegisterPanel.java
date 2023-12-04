import Utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class RegisterPanel extends JPanel {
    private  MainFrame mainFrame;
    private TextFieldUsername usernameField;
    private TextFieldPassword passwordField;


    public RegisterPanel(MainFrame mainFrame) {
        setLayout(new GridLayout(3, 1)); // 使用网格布局

        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        JPanel mainJPanel = getMainJPanel();
        add(mainJPanel, BorderLayout.CENTER);

        // 添加组件
        // Comment out to avoid null pointer exception due to logo image not found. Need to figure out why this failed.
//        addLogo(mainJPanel);
        addSeparator(mainJPanel);
        addUsernameTextField(mainJPanel);
        addPasswordTextField(mainJPanel);
        addRegisterButton(mainJPanel);
        addLoginButton(mainJPanel);


//        // 创建返回按钮
//        JButton backButton = new JButton("返回登录");
//        backButton.addActionListener(e -> mainFrame.switchToCard("LoginUI"));
//        add(backButton);
    }

    private JPanel getMainJPanel() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
        // 其他面板设置

        return panel1;
    }

    private void addSeparator(JPanel panel1) {
        JSeparator separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.VERTICAL);
        separator1.setForeground(UIUtils.COLOR_OUTLINE);
        panel1.add(separator1);
        separator1.setBounds(310, 80, 1, 240);
    }

    private void addLogo(JPanel panel1) {
        JLabel label1 = new JLabel();
//        label1.setFocusable(false);
////        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Logo.jpg")).getFile()));
//        label1.setIcon(new ImageIcon(getClass().getResource("/Logo.jpg")));
//        panel1.add(label1);
//        label1.setBounds(55, 146, 500, 110);
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Logo.jpg")));
        int width = 200; // 或您希望的宽度
        int height = (originalIcon.getIconHeight() * width) / originalIcon.getIconWidth(); // 计算新的高度以保持宽高比

        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label1.setIcon(new ImageIcon(scaledImage));
        panel1.add(label1);
        label1.setBounds(55, 146, 500, 110);

    }

    private void addUsernameTextField(JPanel panel1) {
        usernameField = new TextFieldUsername();

        usernameField.setBounds(423, 109, 250, 44);
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals(UIUtils.PLACEHOLDER_TEXT_USERNAME)) {
                    usernameField.setText("");
                }
                usernameField.setForeground(Color.white);
                usernameField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText(UIUtils.PLACEHOLDER_TEXT_USERNAME);
                }
                usernameField.setForeground(UIUtils.COLOR_OUTLINE);
                usernameField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(usernameField);
    }

    private void addPasswordTextField(JPanel panel1) {
        passwordField = new TextFieldPassword();

        passwordField.setBounds(423, 168, 250, 44);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setForeground(Color.white);
                passwordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                passwordField.setForeground(UIUtils.COLOR_OUTLINE);
                passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER)
                    RegisterEventHandler();
            }
        });

        panel1.add(passwordField);
    }

    private void addRegisterButton(JPanel panel1) {
        final Color[] RegisterButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        JLabel RegisterButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(RegisterButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(RegisterButtonColors[1]);
                g2.drawString(UIUtils.BUTTON_TEXT_Register_forr, x2, y2);
            }
        };

        RegisterButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                RegisterEventHandler();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                RegisterButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                RegisterButtonColors[1] = UIUtils.OFFWHITE;
                RegisterButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RegisterButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
                RegisterButtonColors[1] = Color.white;
                RegisterButton.repaint();
            }
        });

        RegisterButton.setBackground(UIUtils.COLOR_BACKGROUND);
        RegisterButton.setBounds(423, 247, 250, 44);
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(RegisterButton);
    }
    private void addLoginButton(JPanel panel1) {
        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_Login_forr, 631, 300, () -> {
            // 假设 MainFrame 实例存储在一个名为 mainFrame 的成员变量中
            mainFrame.switchToCard("LoginUI");
        }));
    }


    private void RegisterEventHandler() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        // 这里调用 DatabaseConnector 的方法来注册用户，该方法需要您自己实现
        DatabaseConnector.registerNewUser(username, password);
    }
}
