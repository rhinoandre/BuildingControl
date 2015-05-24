package com.learning.building.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learning.building.view.MainFrame;
import com.learning.building.view.MaterialTypeFrame;

@Controller
public class MainFrameController {
	
	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private MaterialTypeController materialTypeController;
	
	public MainFrameController() {
		System.out.println("MainController has been created!");
	}
	
	@PostConstruct
	private void init(){
		mainFrame.getNewMaterial().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				materialTypeController.show();
			}
		});
		
		mainFrame.getNewSpent().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mainFrame, "Open spent form");
			}
		});
		
		mainFrame.setVisible(true);
	}
}
