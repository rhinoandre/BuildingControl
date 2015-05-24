package com.learning.building.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

@org.springframework.stereotype.Component
public class FormTwoColumnsUtility {
	private GridBagConstraints leftConstraints = null;
	private GridBagConstraints rightConstraints = null;
	
	public FormTwoColumnsUtility() {
		rightConstraints = new GridBagConstraints();
		rightConstraints.fill = GridBagConstraints.HORIZONTAL;
		rightConstraints.anchor = GridBagConstraints.NORTHWEST;
		rightConstraints.weightx = 1.0;
		rightConstraints.gridwidth = GridBagConstraints.REMAINDER;
		rightConstraints.insets = new Insets(1, 1, 1, 1);
		
		leftConstraints = (GridBagConstraints) rightConstraints.clone();
		leftConstraints.gridwidth = 1;
	}
	
	/**
     * Adds a field component. Any component may be used. The 
     * component will be stretched to take the remainder of 
     * the current row.
     */
	public void addLabel(Component c, Container parent){
		GridBagLayout gbl = (GridBagLayout) parent.getLayout();
		gbl.setConstraints(c, leftConstraints);
		parent.add(c);
	}
	
	public JLabel addLabel(String text, Container parent){
		JLabel jLabel = new JLabel(text);
		addLabel(jLabel, parent);
		return jLabel;
	}
	
	public void addField(Component c, Container parent){
		GridBagLayout gbl = (GridBagLayout) parent.getLayout();
		gbl.setConstraints(c, rightConstraints);
		parent.add(c);
	}
}
