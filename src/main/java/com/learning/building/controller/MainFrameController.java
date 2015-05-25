package com.learning.building.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learning.building.dao.GenericDAO;
import com.learning.building.dao.SpentDAO;
import com.learning.building.dao.SpentDAOImpl;
import com.learning.building.model.MaterialType;
import com.learning.building.model.Spent;
import com.learning.building.view.MainFrame;
import com.learning.building.view.MaterialTypeFrame;

@Controller
public class MainFrameController {
	
	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private MaterialTypeController materialTypeController;
	
	@Autowired
	private SpentDAO spentDAO;
	
	@Autowired
	private GenericDAO<MaterialType> materialTypeDAO;
	
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
		
		mainFrame.getReport().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					List<Spent> list = spentDAO.getAll();
					for (Spent spent : list) {
						System.out.println(spent.getId());
					}
					
					JasperReport pathJrxml = JasperCompileManager.compileReport("Reports//SpendList.jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(pathJrxml, null, new JRBeanCollectionDataSource(list));
					JasperExportManager.exportReportToPdfFile(jasperPrint, "relatorio/reportex.pdf");
					
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mainFrame.getMaterialReport().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					List<MaterialType> list = materialTypeDAO.getAll();
					for (MaterialType materialType : list) {
						System.out.println(materialType.getId());
					}
					
					JasperReport pathJrxml = JasperCompileManager.compileReport("Reports/MaterialList.jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(pathJrxml, null, new JRBeanCollectionDataSource(list));
					JasperExportManager.exportReportToPdfFile(jasperPrint, "relatorio/reportex.pdf");
					
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mainFrame.setVisible(true);
	}
}
