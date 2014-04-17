package OptionDialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

import Components.CButton;
import Gui.JEditor;
import Layouts.FlowCustomLayout;
import Utility.SpringUtilities;

public class SearchDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private static SearchDialog instance = null;
	private JLabel sLabel,rLabel;
	private JTextField sField,rField;
	private CButton search, sreplace, replace,replaceAll,close;
	private JCheckBox cSensitive,wholeword,wrapsearch;
	
	public static SearchDialog getInstance(){
		if(instance == null){
			instance = new SearchDialog();
		}
		return instance;
	}
	
	private SearchDialog(){
		init();
		addToDialog();
	}
	
	public void init(){
		setTitle("Search");
		setSize(new Dimension(500,400));
		setLocationRelativeTo(JEditor.frame);
	}
	
	public void addToDialog(){
		setLayout(new BorderLayout());
		add(getFieldPanel() , BorderLayout.NORTH);
		add(getOptionsPanel() , BorderLayout.CENTER);
		add(getClosePanel() , BorderLayout.SOUTH);
	}
	
	public JPanel getOptionsPanel(){
		JPanel main = new JPanel(new FlowCustomLayout(FlowLayout.LEFT));
		cSensitive = new JCheckBox("Case sensitive");
		wrapsearch = new JCheckBox("Wrap word");
		wholeword = new JCheckBox("Whole word");
		
		
		main.add(cSensitive);
		main.add(wrapsearch);
		main.add(wholeword);
		
		return main;
	}
	
	public JPanel getFieldPanel(){
		JPanel main = new JPanel();
		main.setLayout(new SpringLayout());
		
		sLabel = new JLabel("Search:");
		rLabel = new JLabel("Replace:");
		sField = new JTextField(10);
		rField = new JTextField(10);
		
		main.add(sLabel);
		main.add(sField);
		main.add(rLabel);
		main.add(rField);
		
		SpringUtilities.makeCompactGrid(main, 2, 2, 6, 6, 6, 6);
		
		return main;
	}
	
	public JPanel getClosePanel(){
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JPanel up = new JPanel(new FlowCustomLayout(FlowLayout.RIGHT));
		JPanel down = new JPanel(new FlowCustomLayout(FlowLayout.RIGHT));
		
		search = new CButton("Search", "search the text in the field", 'S', KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), null);
		
		sreplace = new CButton("Search/replace", "search and replace and move to the next item", '0', null, null);
		
		replace = new CButton("Replace", "replace the text", 'R', null, null);
		
		replaceAll = new CButton("Replace all", "replace all the text", 'a', null, null);
		
		close = new CButton("Close", "dispose the dialog", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		sreplace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		replace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		replaceAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		up.add(search);
		up.add(sreplace);
		down.add(replace);
		down.add(replaceAll);
		main.add(up);
		main.add(down);
		main.add(close);
		
		return main;
	}

}
