package com.learning.building.view.frag;

import java.util.List;

import javax.swing.JTable;

import com.learning.building.model.Spent;

public class SpentTable extends JTable {
	
	private SpentTableModel model;
	
	public SpentTable() {
		model = new SpentTableModel();
		setModel(model);
	}
	
	public Spent getSpentSelected(){
		int i = getSelectedRow();
		if(i<0){
			return null;
		}
		
		return model.getSpentAt(i);
	}
	
	public void reload(List<Spent> spents){
		model.reload(spents);
	}
}
