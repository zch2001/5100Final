import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class OrderPanel extends JPanel {
    private MainFrame mainFrame;
    private JTable orderTable;
    private JTextField[] orderTextFields; // 用于存储订单信息的文本框数组

    public OrderPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        JPanel menuPanel = createMenuPanel();
        JPanel contentPanel = createContentPanel();
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        displayOrders(); // 初始时显示所有订单
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this::deleteSelectedOrder);
        menuPanel.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(this::updateSelectedOrder);
        menuPanel.add(updateButton);

        return menuPanel;
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        orderTable = new JTable();
        orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 设置单行选择
        orderTable.getSelectionModel().addListSelectionListener(e -> updateTextFieldsWithSelectedOrder());

        contentPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);
        contentPanel.add(createOrderInfoPanel(), BorderLayout.SOUTH);
        return contentPanel;
    }

    private void updateTextFieldsWithSelectedOrder() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            for (int i = 0; i < orderTable.getColumnCount(); i++) {
                Object value = orderTable.getValueAt(selectedRow, i);
                orderTextFields[i].setText(value != null ? value.toString() : "");
            }
        }
    }


    private JPanel createOrderInfoPanel() {
        JPanel orderInfoPanel = new JPanel(new FlowLayout());
        String[] fieldNames = {"OID", "CustomerID", "OrderDate", "Status", "TotalAmount", "PaymentMethod", "ShippingAddress", "BillingAddress", "Notes"};
        orderTextFields = new JTextField[fieldNames.length];

        for (int i = 0; i < fieldNames.length; i++) {
            orderInfoPanel.add(new JLabel(fieldNames[i]));
            JTextField textField = new JTextField(10); // 根据需要调整文本框大小
            orderTextFields[i] = textField;
            orderInfoPanel.add(textField);
        }

        return orderInfoPanel;
    }


    private void displayOrders() {
        DefaultTableModel model = DatabaseConnector.getOrderData();
        orderTable.setModel(model);
    }

    private void deleteSelectedOrder(ActionEvent e) {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow >= 0) {
            int orderId = (Integer) orderTable.getValueAt(selectedRow, 0);
            if (DatabaseConnector.deleteOrder(orderId)) {
                JOptionPane.showMessageDialog(this, "Order deleted successfully.");
                displayOrders(); // Refresh the order list
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateSelectedOrder(ActionEvent e) {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow >= 0) {
            // 获取订单信息
            try {
                int orderId = Integer.parseInt(orderTextFields[0].getText()); // OID
                String customerId = orderTextFields[1].getText();
                String orderDate = orderTextFields[2].getText();
                String status = orderTextFields[3].getText();
                BigDecimal totalAmount = new BigDecimal(orderTextFields[4].getText());
                String paymentMethod = orderTextFields[5].getText();
                String shippingAddress = orderTextFields[6].getText();
                String billingAddress = orderTextFields[7].getText();
                String notes = orderTextFields[8].getText();

                // 调用数据库连接器中的更新方法
                if (DatabaseConnector.updateOrder(orderId, customerId, orderDate, status, totalAmount, paymentMethod, shippingAddress, billingAddress, notes)) {
                    JOptionPane.showMessageDialog(this, "Order updated successfully.");
                    displayOrders(); // 刷新订单列表
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update order.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid data format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to update.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
