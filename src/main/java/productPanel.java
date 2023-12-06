import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class productPanel extends JPanel {
    private MainFrame   mainFrame;
    private JTable productTable;
    private JTextField[] productTextFields; // 存储产品信息的文本框

    public productPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        JPanel menuPanel = createMenuPanel();
        JPanel contentPanel = createContentPanel();
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        displayProducts(); // 初始时显示所有产品
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this::deleteSelectedProduct);
        menuPanel.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(this::updateSelectedProduct);
        menuPanel.add(updateButton);

        return menuPanel;
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        productTable = new JTable();
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 设置单行选择
        productTable.getSelectionModel().addListSelectionListener(e -> updateTextFieldsWithSelectedProduct());

        JScrollPane scrollPane = new JScrollPane(productTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(createProductInfoPanel(), BorderLayout.SOUTH);
        return contentPanel;
    }


    private JPanel createProductInfoPanel() {
        JPanel productInfoPanel = new JPanel(new FlowLayout());
        String[] fieldNames = {"ProductID", "Name", "Price", "Quantity"};
        productTextFields = new JTextField[fieldNames.length];

        for (int i = 0; i < fieldNames.length; i++) {
            productInfoPanel.add(new JLabel(fieldNames[i]));
            JTextField textField = new JTextField(10);
            productTextFields[i] = textField;
            productInfoPanel.add(textField);
        }

        return productInfoPanel;
    }

    private void displayProducts() {
        DefaultTableModel model = DatabaseConnector.getProductData(); // 这个方法需要实现
        productTable.setModel(model);
    }

    private void updateTextFieldsWithSelectedProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1 && !productTable.getSelectionModel().isSelectionEmpty()) {
            for (int i = 0; i < productTable.getColumnCount(); i++) {
                Object value = productTable.getValueAt(selectedRow, i);
                if (i < productTextFields.length) {
                    productTextFields[i].setText(value != null ? value.toString() : "");
                }
            }
        }
    }


    private void deleteSelectedProduct(ActionEvent e) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            int productId = (Integer) productTable.getValueAt(selectedRow, 0);
            if (DatabaseConnector.deleteProduct(productId)) {
                JOptionPane.showMessageDialog(this, "Product deleted successfully.");
                displayProducts(); // 刷新产品列表
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateSelectedProduct(ActionEvent e) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int productId = Integer.parseInt(productTextFields[0].getText());
                String name = productTextFields[1].getText();
                BigDecimal price = new BigDecimal(productTextFields[2].getText());
                int quantity = Integer.parseInt(productTextFields[3].getText());

                if (DatabaseConnector.updateProduct(productId, name, price, quantity)) {
                    JOptionPane.showMessageDialog(this, "Product updated successfully.");
                    displayProducts(); // 刷新产品列表
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update product.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid data format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to update.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}