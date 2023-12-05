import Utils.UIUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class AnalystPanel extends JPanel {
    private MainFrame mainFrame;
    private JPanel menuPanel;
    private JPanel contentPanel;

    public AnalystPanel(MainFrame  mainFrame) {
        this.mainFrame = mainFrame;
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

        JButton customerButton = new JButton("ShowCountry");
        JButton orderButton = new JButton("ShowOrder");
        JButton inventoryButton = new JButton("ShowProduct");
        JButton backButton = new JButton("back");

        // 设置按钮的最大和预期大小以保持一致性
        Dimension buttonSize = new Dimension(120, 40); // 按钮的推荐大小
        customerButton.setMaximumSize(buttonSize);
        customerButton.setPreferredSize(buttonSize);
        orderButton.setMaximumSize(buttonSize);
        orderButton.setPreferredSize(buttonSize);
        inventoryButton.setMaximumSize(buttonSize);
        inventoryButton.setPreferredSize(buttonSize);
        backButton.setMaximumSize(buttonSize);
        backButton.setPreferredSize(buttonSize);

        // 为按钮添加间隔
        panel.add(Box.createVerticalStrut(20));
        panel.add(customerButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(orderButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(inventoryButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);
        panel.add(Box.createVerticalGlue()); // 在按钮之后添加一个可拉伸的空白区域

        backButton.addActionListener(e -> {
            mainFrame.switchToCard("LoginUI");
        });

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
            showCountryPieChart();
        });

        orderButton.addActionListener(e -> {
            // 从数据库中获取数据模型
            DefaultTableModel orderData = DatabaseConnector.getOrderData();
            // 创建一个表格来显示这些数据
            JTable orderTable = new JTable(orderData);
            // 在滚动面板中放置表格
            JScrollPane scrollPane = new JScrollPane(orderTable);
            // 更新分析面板的内容区域以显示表格
            this.setContentComponent(scrollPane);
            createBarChart();
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

    public void createBarChart() {
        System.out.println("output bar");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // 获取订单数据
        DefaultTableModel orderData = DatabaseConnector.getOrderData();
        Map<String, Integer> orderCounts = getOrderCounts(orderData);

        // 将数据添加到数据集
        for (Map.Entry<String, Integer> entry : orderCounts.entrySet()) {
            dataset.addValue(entry.getValue(), "Orders", entry.getKey());
        }

        // 创建柱状图
        JFreeChart barChart = ChartFactory.createBarChart(
                "Order Price Intervals",
                "Price Range",
                "Number of Orders",
                dataset);

        // 将图表添加到面板
        ChartPanel chartPanel = new ChartPanel(barChart);
        setContentComponent(chartPanel);
    }

    // 获取每个价格区间的订单数量
// 获取每个价格区间的订单数量
    private Map<String, Integer> getOrderCounts(DefaultTableModel model) {
        Map<String, Integer> counts = new HashMap<>();
        int rowCount = model.getRowCount();
        DefaultTableModel orderData = DatabaseConnector.getOrderData();
        int totalAColumnIndex = orderData.findColumn("TotalAmount");

        for (int i = 0; i < rowCount; i++) {
            // 获取TotalAmount列的值，并将其转换为Double
            String totalAmountStr = (String) model.getValueAt(i, totalAColumnIndex);
            double totalAmount = Double.parseDouble(totalAmountStr);
            String range = getPriceRange(totalAmount);
            counts.put(range, counts.getOrDefault(range, 0) + 1);
        }

        return counts;
    }


    // 根据总金额获取价格区间
    private String getPriceRange(double amount) {
        int rangeStart = ((int) amount / 100) * 100;
        int rangeEnd = rangeStart + 99;
        return rangeStart + "-" + rangeEnd;
    }
    // 新方法：生成并显示国家数据的饼图
    public void showCountryPieChart() {
        DefaultTableModel customerModel = DatabaseConnector.getCustomerData();
        Map<String, Integer> countryCount = new HashMap<>();

// 假设 country 是在第 n 列
        int countryColumnIndex = customerModel.findColumn("Country");

        for (int i = 0; i < customerModel.getRowCount(); i++) {
            String country = (String) customerModel.getValueAt(i, countryColumnIndex);
            countryCount.put(country, countryCount.getOrDefault(country, 0) + 1);
        }

// 现在 countryCount 包含了国家名称和对应的客户数
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : countryCount.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

// 创建饼图
        JFreeChart chart = ChartFactory.createPieChart(
                "Customer Distribution by Country",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
        );

// 显示饼图
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentComponent(chartPanel);
    }
}
