package com.learning.building.view.frag;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.building.model.Spent;

public class SpentTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4580921786331532996L;

	@Autowired
	private List<Spent> spents;
	
	private String[] colNames = {"Data", "Tipo", "Valor total", "Descrição"};
	private Class<?>[] colClasses = {String.class, String.class, Double.class, String.class};
	
	public SpentTableModel() {}
	
	public void reload(List<Spent> spents){
		this.spents = spents;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int column) {
		return colClasses[column];
	}

	@Override
	public int getRowCount() {
		if(spents == null)
			return 0;
		
		return spents.size();
	}

	@Override
	public Object getValueAt(int line, int column) {
		Spent s = spents.get(line);
		
		switch (column) {
		case 0:
			return s.getRegisterDate().toString();
		case 1:
			return s.getMaterialType().getName();
		case 2:
			return s.getPriceFormated();
		case 3: 
			return s.getDescription();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Spent getSpentAt(int index){
		return spents.get(index);
	}
	
	
}
