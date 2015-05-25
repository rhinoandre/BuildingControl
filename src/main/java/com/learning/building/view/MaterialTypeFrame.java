package com.learning.building.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.building.model.MaterialType;

@Component
public class MaterialTypeFrame extends JFrame {
	private static final long serialVersionUID = 1314267543710551856L;
	
	private JTextField nameTf;
	private JTextField idTf;
	private JButton save;
	private JButton cancel;
	private JButton delete;
	
	@Autowired
	private FormTwoColumnsUtility formUtility;
	
	public MaterialTypeFrame() {
		System.out.println("TypeSpentFormFrame has been created!");
		
		setTitle("New Type Spent");
		setSize(200, 200);
		setLocationRelativeTo(null);
	}
	
	@PostConstruct
	public void initialize(){
		nameTf = new JTextField();
		idTf = new JTextField();
		idTf.setEnabled(false);
		
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		delete = new JButton("Delete");
		delete.setVisible(false);
		
		JPanel form = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(form, BorderLayout.NORTH);
		
		form.setLayout(new GridBagLayout());
		formUtility.addLabel("ID", form);
		formUtility.addField(idTf, form);
		formUtility.addLabel("Nome", form);
		formUtility.addField(nameTf, form);
		
		JPanel buttons = new JPanel();
		buttons.add(save);
		buttons.add(cancel);
		buttons.add(delete);
		
		add(buttons, BorderLayout.SOUTH);
		
	}

	public JTextField getId() {
		return idTf;
	}
	
	public JTextField getTypeName() {
		return nameTf;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void resetForm() {
		nameTf.setText("");
	}

	public JButton getDelete() {
		return delete;
	}
	
	public MaterialType getMaterialType(){
		MaterialType materialType = new MaterialType();
		materialType.setName(nameTf.getText());
		if(!idTf.getText().isEmpty()){
			materialType.setId(Integer.parseInt(idTf.getText()));
		}
		
		return materialType;
	}
	
	public void setMaterialType(MaterialType materialType) {
		if(materialType != null){
			idTf.setText(materialType.getId().toString());
			nameTf.setText(materialType.getName());
			delete.setVisible(true);
		}
	}
}
