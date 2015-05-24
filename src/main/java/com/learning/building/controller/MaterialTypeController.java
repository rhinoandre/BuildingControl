package com.learning.building.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.building.model.MaterialType;
import com.learning.building.view.MaterialTypeFrame;

@Component
public class MaterialTypeController {
	
	@Autowired
	private MaterialTypeFrame frame;
	
	public MaterialTypeController() {
		System.out.println("TypeSpentController has been created!");
	}
	
	@PostConstruct
	private void initializer(){
		frame.getSave().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(frame.getTypeName().getText()) || frame.getTypeName().getText().isEmpty()){
					JOptionPane.showMessageDialog(frame, "You should fill TYPE NAME field");
				} else {
					JOptionPane.showMessageDialog(frame, "Preciso arrumar o hibernate pra gravar");
				}
			}
		});
		
		frame.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cleanUp();
			}
		});
		
		frame.getDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(frame.getId().getText()) || frame.getId().getText().isEmpty()){
					JOptionPane.showMessageDialog(frame, "This register hasn't been created to be deleted");
				} else {
					if(JOptionPane.showConfirmDialog(frame, "Do you really want to delete this Material Type?") == 1){
						JOptionPane.showMessageDialog(frame, "Preciso arrumar o hibernate pra gravar");
					}
				}
			}
		});
	}
	
	public void show(MaterialType materialType){
		frame.setMaterialType(materialType);
		frame.setVisible(true);
	}
	
	public void show(){
		frame.setVisible(true);
	}
	
	public void cleanUp(){
		frame.setVisible(false);
		frame.resetForm();
	}
}
