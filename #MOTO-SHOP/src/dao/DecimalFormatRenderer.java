package dao;

import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Lê Hoàng Hiện
 * Class DecimalFormatRenderer
 * Chuyển định dạng kiểu dữ liệu x.yEz sang decimal.
 */
public class DecimalFormatRenderer extends DefaultTableCellRenderer {
    private static final DecimalFormat formatter = new DecimalFormat("#.##");

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            Number numberValue = (Number) value;
            cellComponent = super.getTableCellRendererComponent(table, formatter.format(numberValue), isSelected, hasFocus, row, column);
        }
        return cellComponent;
    }
}

