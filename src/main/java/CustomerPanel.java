import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanel extends JPanel {
    private MainFrame mainFrame;
    private JPanel menubarPanel;
    private JPanel contentPanel;


    // 文本框的声明
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipCodeField;
    private JTextField countryField;
    public void setContentComponent(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public CustomerPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        // 创建侧边栏和内容面板
        menubarPanel = createMenuPanel();
        createContentPanel();

        // 添加侧边栏和内容面板到 CustomerPanel
        add(menubarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 垂直排列
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 边距

        JButton customerButton = new JButton("Customer");
        JButton purchaseButton = new JButton("Purchase");
        JButton inventoryButton = new JButton("Cart");

        // 设置按钮的最大和预期大小以保持一致性
        Dimension buttonSize = new Dimension(120, 40); // 按钮的推荐大小
        customerButton.setMaximumSize(buttonSize);
        customerButton.setPreferredSize(buttonSize);
        purchaseButton.setMaximumSize(buttonSize);
        purchaseButton.setPreferredSize(buttonSize);
        inventoryButton.setMaximumSize(buttonSize);
        inventoryButton.setPreferredSize(buttonSize);

        // 创建提交按钮并添加事件监听器
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 从文本框获取数据
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String zipCode = zipCodeField.getText();
                String country = countryField.getText();

                // 调用 DatabaseConnector.addCustomer 方法插入数据
                boolean success = DatabaseConnector.addCustomer(name, email, phone, address, city, state, zipCode, country);

                // 根据操作结果显示提示信息
                if (success) {
                    JOptionPane.showMessageDialog(CustomerPanel.this, "Customer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(CustomerPanel.this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 为按钮添加间隔
        panel.add(Box.createVerticalStrut(20));
        panel.add(customerButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(purchaseButton);
        panel.add(Box.createVerticalStrut(20));
        panel.add(inventoryButton);
        panel.add(Box.createVerticalGlue()); // 在按钮之后添加一个可拉伸的空白区域
//        contentPanel.add(submitButton);



        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 从文本框获取数据
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String zipCode = zipCodeField.getText();
                String country = countryField.getText();

                // 调用 DatabaseConnector.addCustomer 方法插入数据
                boolean success = DatabaseConnector.addCustomer(name, email, phone, address, city, state, zipCode, country);

                // 根据操作结果显示提示信息
                if (success) {
                    JOptionPane.showMessageDialog(CustomerPanel.this, "Customer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(CustomerPanel.this, "Failed to add customer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        purchaseButton.addActionListener(e -> {
            displayProducts();
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTopFiveProducts();
            }
        });

        return panel;

    }

    private void displayTopFiveProducts() {
        DefaultTableModel model = DatabaseConnector.getTopFiveProducts();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当点击 Checkout 按钮时执行的操作
                JOptionPane.showMessageDialog(CustomerPanel.this, "Checkout successful!", "Checkout", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        contentPanel.removeAll();
        // 将 Checkout 按钮添加到购物车面板
        contentPanel.add(checkoutButton, BorderLayout.SOUTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout()); // 或者选择其他布局管理器
        contentPanel.setBackground(Color.WHITE);

        // 初始化文本框
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        addressField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        zipCodeField = new JTextField(20);
        countryField = new JTextField(20);



        // 添加文本框和按钮到内容面板
        contentPanel.add(new JLabel("Name:"));
        contentPanel.add(nameField);
        contentPanel.add(new JLabel("Email:"));
        contentPanel.add(emailField);
        contentPanel.add(new JLabel("Phone:"));
        contentPanel.add(phoneField);
        contentPanel.add(new JLabel("Address:"));
        contentPanel.add(addressField);
        contentPanel.add(new JLabel("City:"));
        contentPanel.add(cityField);
        contentPanel.add(new JLabel("State:"));
        contentPanel.add(stateField);
        contentPanel.add(new JLabel("Zip Code:"));
        contentPanel.add(zipCodeField);
        contentPanel.add(new JLabel("Country:"));
        contentPanel.add(countryField);
    }
    private void displayProducts() {
        DefaultTableModel model = DatabaseConnector.getProductData();
        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                // 第5列（"Purchase" 按钮列）可以点击
                return column == 4;
            }
        };

        // 添加一个按钮列
        if (model.getColumnCount() < 5) {
            model.addColumn("Purchase");
        }

        TableColumn purchaseColumn = table.getColumnModel().getColumn(4);
        purchaseColumn.setCellRenderer(new ButtonRenderer());
        purchaseColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.removeAll();
        contentPanel.add(scrollPane);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

}
// 按钮渲染器
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Purchase" : value.toString());
        return this;
    }
}

// 按钮编辑器
class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        isPushed = true;
        button.setText((value == null) ? "Purchase" : value.toString());
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // TODO: 实现购买逻辑
            // 您可以在这里添加代码以处理购买操作，例如更新购买商品列表
            JOptionPane.showMessageDialog(button, "Product purchased!");
        }
        isPushed = false;
        return "Purchase";
    }
}






    // ... 其他方法和类的内容

