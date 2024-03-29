package com.sss.MasterController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class MasterControler implements ActionListener {
	JFrame frame = new JFrame("Master Controller");
	Container selection = new Container();
	Container items = new Container();
	Container values = new Container();
	JButton[] selectors;
	JButton[] itemButton;
    JPanel buttonPanel = new JPanel();
    JScrollPane pane = new JScrollPane();
	int selectorsNum = 4;
	int itemsNum = 10;
	int optionsNum = 4;
	int num;
	boolean[] isSelected;
	boolean[] isItemSelected;
	int selectedNum = 0;
	int selectedItemNum = 0;
	private Enemies e;
	private InternalProblems ip;
	private Events ev;
	
	//main constructor method.
	public MasterControler() {
		e = new Enemies();
		ip = new InternalProblems();
		ev = new Events();
		
		//ready up the frame
		frame.setUndecorated(true);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize stuff
		initContainers();
		initButtons();
		addButtons();
		initItems(0);
		//set frame visible
		frame.setVisible(true);
	}
	//initialize the items layout for the items section
	private void initItems(int btAmount) {
		// the panel
	    buttonPanel.setLayout(new GridBagLayout());
	    buttonPanel.setSize(400, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	    // the scroll pane
	    pane.setSize(400, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	    // GridBagConstraint for button
	    GridBagConstraints constraint = new GridBagConstraints();
	    constraint.anchor = GridBagConstraints.CENTER;
	    constraint.fill = GridBagConstraints.NONE;
	    constraint.gridx = 0;
	    constraint.gridy = GridBagConstraints.RELATIVE;
	    constraint.weightx = 1.0f;
	    constraint.weighty = 0.5f;
	    //the buttons
    	itemButton = new JButton[btAmount];
	    for(int i = 0; i < btAmount; i++) {
	    	if (selectedNum == 0) { //enemies
	    		itemButton[i] = new JButton(e.getEnemy(i));
		        // other attributes you will set
		        buttonPanel.add(itemButton[i], constraint);
	    	} else if (selectedNum == 1) { //internal problems
	    		itemButton[i] = new JButton(ip.getInternalProblem(i));
		        // other attributes you will set
		        buttonPanel.add(itemButton[i], constraint);
	    	} else if (selectedNum == 2) { //events
	    		itemButton[i] = new JButton(ev.getEvent(i));
		        // other attributes you will set
		        buttonPanel.add(itemButton[i], constraint);
	    	}
	    	itemButton[i].setBackground(Color.LIGHT_GRAY);
	    	itemButton[i].setForeground(Color.BLACK);
    		itemButton[i].addActionListener(this);
	    }
	    //add it
	    pane.setViewportView(buttonPanel);
	    frame.add(pane, BorderLayout.CENTER);
	    //update
	    pane.updateUI();
	}
	//initialize all the used Containers before giving them buttons and labels, ex...
	private void initContainers() {
		selection.setLayout(new GridLayout(selectorsNum, 1));
		selection.setVisible(true);
		items.setLayout(new GridLayout(itemsNum, 1));
		items.setVisible(false);
		values.setLayout(new GridLayout(optionsNum, 2));
		values.setVisible(true);
	}
	//initialize all the used buttons to give them names, values, ex...
	private void initButtons() {
		selectors = new JButton[selectorsNum]; //there will be `selectorsNum` amount of buttons
		isSelected = new boolean[selectorsNum]; //there will be `selectorsNum` amount of booleans
		isItemSelected = new boolean[num]; //there will be `num` amount of booleans
		
		selectors[0] = new JButton("Enemies");
		selectors[1] = new JButton("Internal Problems");
		selectors[2] = new JButton("Events");
		selectors[3] = new JButton("Exit");
		
		for (int i = 0; i < selectors.length; i++) {
			selection.add(selectors[i]);
			selectors[i].addActionListener(this);
			selectors[i].setBackground(Color.LIGHT_GRAY);
			isSelected[i] = false;
		}
		
		for (int i = 0; i < isItemSelected.length; i++) {
			isItemSelected[i] = false;
		}
		
	}
	//add the buttons to their specific container, the add that container to the frame
	private void addButtons() {
		frame.add(selection, BorderLayout.WEST);
		frame.add(items, BorderLayout.CENTER);
		frame.add(values, BorderLayout.EAST);
	}
	public static void main(String[] args) {
		new MasterControler();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//selectors buttons test
		for (int i = 0; i < selectors.length; i++) {
			if (event.getSource().equals(selectors[i])) {
				if (selectors[i].getBackground().equals(Color.BLUE)) {
					//it is already selected, de-select it.
					for (int j = 0; j < selectors.length; j++) {
						selectors[i].setBackground(Color.LIGHT_GRAY);
						selectors[i].setForeground(Color.BLACK);
						isSelected[j] = false;
					}
					//give the items section to the user
					clearItems();
					selectedNum = -1;
				} else {
					for (int j = 0; j < selectors.length; j++) {
						if (j != i) {
							selectors[j].setBackground(Color.LIGHT_GRAY);
							selectors[j].setForeground(Color.BLACK);
							isSelected[j] = false;
						} else {
							selectors[i].setBackground(Color.BLUE);
							selectors[i].setForeground(Color.WHITE);
							isSelected[i] = true;
						}
					}
					selectedNum = i;
					//clean the items button slate
					clearItems();
					//give the items section to the user
					showItems(i);
				}
			}
		}
		//items buttons test
		for (int i = 0; i < num; i++) {
			if (event.getSource().equals(itemButton[i])) {
				if (itemButton[i].getBackground().equals(new Color(60, 60, 200))) {
					//it is already selected, de-select it.
					for (int j = 0; j < itemButton.length; j++) {
						itemButton[i].setBackground(Color.LIGHT_GRAY);
						itemButton[i].setForeground(Color.BLACK);
					}
					selectedItemNum = -1;
				} else {
					for (int j = 0; j < itemButton.length; j++) {
						if (j != i) {
							itemButton[j].setBackground(Color.LIGHT_GRAY);
							itemButton[j].setForeground(Color.BLACK);
						} else {
							itemButton[i].setBackground(new Color(60, 60, 200));
							itemButton[i].setForeground(Color.WHITE);
						}
					}
					selectedItemNum = i;
					//give the new values section to the user
					showValues(i);
				}
			}
		}
	}
	private void showItems(int i) {
		if (i == 0) { //show enemies buttons
			num = 17;
			initItems(num);
		} else if (i == 1) { //show internal problems buttons
			num = 11;
			initItems(num);
		} else if (i == 2) { //show events buttons
			num = 5;
			initItems(num);
		} else if (i == 3) {
			System.exit(0);
		} else { //some how there was an error
			System.err.println("For some weird reason there was an error on the selection you have tried to make, try choosing the option again.");
		}
	}
	private void clearItems() {
		for (int i = 0; i < itemButton.length; i++) {
			itemButton[i].setVisible(false);
			itemButton[i].setEnabled(false);
		}
	}
	private void showValues(int i) {
		frame.setEnabled(false);
		if (selectedNum == 0) { //enemies tab
			Values v = new Values();
			v.definition.setText(e.getDef(i));
			v.frame.setTitle(itemButton[i].getText() + " Values.");
			v.setEnemy();
		} else if (selectedNum == 1) { //internal problems tab
			Values v = new Values();
			v.definition.setText(ip.getDef(i));
			v.frame.setTitle(itemButton[i].getText() + " Values.");
			v.setIP();
		} else if (selectedNum == 2) { //events tab
			Values v = new Values();
			v.definition.setText(ev.getDef(i));
			v.frame.setTitle(itemButton[i].getText() + " Values.");
			v.setEvent();
		} else {
			System.err.println("For some reason you are still running when you pressed exit button...");
		}
	}
}