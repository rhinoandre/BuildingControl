package com.learning.building.view;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import org.springframework.stereotype.Component;

import com.learning.building.view.frag.SpentTable;

@Component
public class MainFrame extends JFrame {
	private static final long serialVersionUID = -2707369074070763299L;
	
	private SpentTable spentTable;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem newMaterial;
	private JMenuItem newSpent;
	
	public MainFrame() {
		System.out.println("MainFrame has been created");
	}
	
	@PostConstruct
	public void initializeComponents(){
		spentTable = new SpentTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(spentTable);
		
		newMaterial = new JMenuItem("Novo Material");
		newSpent = new JMenuItem("Novo Gasto");
		
		menu = new JMenu("File");
		menu.add(newMaterial);
		menu.add(newSpent);
		
		menuBar = new JMenuBar();
		menuBar.add(menu);

		menu = new JMenu("Reports");
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
		
		pack();
		setSize(600, 600);
		setTitle("Building Control");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addAllToFrame(){
		add(scrollPane);
	}
	
	public JMenu getMenu() {
		return menu;
	}
	public JMenuItem getNewMaterial() {
		return newMaterial;
	}
	public JMenuItem getNewSpent() {
		return newSpent;
	}
	
	
	
}
