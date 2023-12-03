import Utils.UIUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AnalystPanel extends JPanel {
    private MainFrame mainFrame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public AnalystPanel(MainFrame  mainFrame) {
        // 设定布局管理器为边界布局
        setLayout(new BorderLayout());

        // 初始化菜单面板和内容面板
        menuPanel = createMenuPanel();
        contentPanel = new JPanel(); // 这里可以进一步定制，比如添加卡片布局等
        contentPanel.setBackground(UIUtils.COLOR_BACKGROUND);

        // 创建一个分隔窗格来分割菜单和内容区域
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, contentPanel);
        splitPane.setDividerLocation(200); // 可以调整分隔条的初始位置
        splitPane.setOneTouchExpandable(true); // 允许展开/折叠

        // 将分隔窗格添加到主面板
        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 垂直排列
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 边距

        JButton customerButton = new JButton("Customer");
        JButton salesButton = new JButton("Sales");
        JButton inventoryButton = new JButton("Inventory");

        // 设置按钮的最大和预期大小以保持一致性
        Dimension buttonSize = new Dimension(120, 40); // 按钮的推荐大小
        customerButton.setMaximumSize(buttonSize);
        customerButton.setPreferredSize(buttonSize);
        salesButton.setMaximumSize(buttonSize);
        salesButton.setPreferredSize(buttonSize);
        inventoryButton.setMaximumSize(buttonSize);
        inventoryButton.setPreferredSize(buttonSize);

        // 为按钮添加间隔
        panel.add(Box.createVerticalStrut(20));
        panel.add(customerButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(salesButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(inventoryButton);
        panel.add(Box.createVerticalGlue()); // 在按钮之后添加一个可拉伸的空白区域

        // 假设这是按钮的事件处理器
        customerButton.addActionListener(e -> {
            // 从数据库中获取数据模型
            DefaultTableModel customerModel = DatabaseConnector.getCustomerData();
            // 创建一个表格来显示这些数据
            JTable customerTable = new JTable(customerModel);
            // 在滚动面板中放置表格
            JScrollPane scrollPane = new JScrollPane(customerTable);
            // 更新分析面板的内容区域以显示表格
            this.setContentComponent(scrollPane);
        });

        return panel;

    }




    // 一个方法来更新内容面板的显示
    public void setContentComponent(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
