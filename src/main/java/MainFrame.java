import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 添加 LoginUI 作为第一个卡片
        cardPanel.add(new LoginUI(this), "LoginUI");
        cardPanel.add(new RegisterPanel(this), "RegisterPanel");
        cardPanel.add(new AnalystPanel(this),"AnalystPanel");
        // For Bella testing purpose
        //cardPanel.add(new OrdersManagementPanel(this),"OrdersManagementPanel");


        // 添加其他页面
        // 例如: cardPanel.add(new AnotherPanel(), "AnotherPanel");

        add(cardPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // 或者您需要的尺寸
        setLocationRelativeTo(null); // 居中窗口
    }

    // 一个方法来切换卡片
    public void switchToCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
