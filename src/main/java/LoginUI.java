import Toaster.Toaster;
import Utils.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class LoginUI extends JPanel {

    private MainFrame mainFrame;

    private final Toaster toaster;

    private TextFieldUsername usernameField;
    private TextFieldPassword passwordField;

//    private LoginUI() {
//        JPanel mainJPanel = getMainJPanel();
//
//        addLogo(mainJPanel);
//
//        addSeparator(mainJPanel);
//
//        addUsernameTextField(mainJPanel);
//
//        addPasswordTextField(mainJPanel);
//
//        addLoginButton(mainJPanel);
//
//        addForgotPasswordButton(mainJPanel);
//
//        addRegisterButton(mainJPanel);
//
//        this.add(mainJPanel);
//        this.pack();
//        this.setVisible(true);
//        this.toFront();
//
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
//
//        toaster = new Toaster(mainJPanel);
//    }
public LoginUI(MainFrame mainFrame) {
    // 初始化面板
    this.mainFrame = mainFrame;
    setLayout(new BorderLayout());
    JPanel mainJPanel = getMainJPanel();
    add(mainJPanel, BorderLayout.CENTER);

    // 添加组件
    // Comment out to avoid null pointer exception due to logo image not found. Need to figure out why this failed.
//    addLogo(mainJPanel);
    addSeparator(mainJPanel);
    addUsernameTextField(mainJPanel);
    addPasswordTextField(mainJPanel);
    addLoginButton(mainJPanel);
    addForgotPasswordButton(mainJPanel);
    addRegisterButton(mainJPanel);

    // 设置Toaster（如果需要）
    toaster = new Toaster(mainJPanel);
}

    private JPanel getMainJPanel() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
        // 其他面板设置

        return panel1;
    }

//    private JPanel getMainJPanel() {
//        //设置关闭按钮
//        this.setUndecorated(false);
//
//        Dimension size = new Dimension(800, 400);
//
//        JPanel panel1 = new JPanel();
//        panel1.setSize(size);
//        panel1.setPreferredSize(size);
//        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
//        panel1.setLayout(null);
//
//        MouseAdapter ma = new MouseAdapter() {
//            int lastX, lastY;
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                lastX = e.getXOnScreen();
//                lastY = e.getYOnScreen();
//            }
//
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                int x = e.getXOnScreen();
//                int y = e.getYOnScreen();
//                setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
//                lastX = x;
//                lastY = y;
//            }
//        };
//
//        panel1.addMouseListener(ma);
//        panel1.addMouseMotionListener(ma);
//
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//
//        return panel1;
//    }

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
                    loginEventHandler();
            }
        });

        panel1.add(passwordField);
    }

    private void addLoginButton(JPanel panel1) {
        final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        JLabel loginButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(loginButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(loginButtonColors[1]);
                g2.drawString(UIUtils.BUTTON_TEXT_LOGIN, x2, y2);
            }
        };

        loginButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                loginEventHandler();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                loginButtonColors[1] = UIUtils.OFFWHITE;
                loginButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
                loginButtonColors[1] = Color.white;
                loginButton.repaint();
            }
        });

        loginButton.setBackground(UIUtils.COLOR_BACKGROUND);
        loginButton.setBounds(423, 247, 250, 44);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(loginButton);
    }

    private void addForgotPasswordButton(JPanel panel1) {
        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_FORGOT_PASS, 423, 300, () -> {
            toaster.error("Forgot password event");
        }));
    }

//    private void addRegisterButton(JPanel panel1) {
//        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_REGISTER, 631, 300, () -> {
//            toaster.success("Register event");
//        }));
//    }
private void addRegisterButton(JPanel panel1) {
    panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_REGISTER, 631, 300, () -> {
        // 假设 MainFrame 实例存储在一个名为 mainFrame 的成员变量中
        mainFrame.switchToCard("RegisterPanel");
    }));
}

    private void loginEventHandler() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (DatabaseConnector.validateUser(username, password)) {
            if ("zch".equals(username)) {
                // 如果用户名是 'zch'，则显示 AnalystPanel
                mainFrame.switchToCard("OrdersManagementPanel");
            } else {
                // 对于其他用户，显示相应的界面
                // 例如：mainFrame.switchToCard("SomeOtherPanel");
            }
            // 登录成功
//            switchToUserPage(username); // 根据用户名跳转到相应的页面
            toaster.success("Successful");
            mainFrame.switchToCard("OrdersManagementPanel");
        } else {
            // 登录失败
            toaster.error("Invalid password");
        }
    }
}