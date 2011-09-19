package tenacity.GUI;

import javax.swing.*;
import javax.swing.text.*;

//import tenacity.Network.EntryActionListener;

import java.awt.*;
import java.awt.event.*;

public class GUI {	
	
	static Container pane;
	static JFrame frame;
	static StyledDocument doc;
	static StyleManager styleManager;
	static JTextPane textArea;
	static JScrollPane textAreaScroll;
	static JMenuBar menuBar;
	static JMenu menu, submenu;
	static JMenuItem menuItem;
	static JTextField entry;
	static JLabel timeLabel;
	static Font font = new Font("Arial",Font.PLAIN,12);
	//static EntryActionListener entryListener = new EntryActionListener();
	
	public static void initGUI() {
		    	
		    	frame = new JFrame("Tenacity Server");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        
		        pane = frame.getContentPane();
		        
		        pane.setLayout(new GridBagLayout());
		        GridBagConstraints c = new GridBagConstraints();
		        
		        menuBar = new JMenuBar();
		        
		        menu = new JMenu("A Menu");
		        menu.setMnemonic(KeyEvent.VK_A);
		        menu.getAccessibleContext().setAccessibleDescription(
		                "The only menu in this program that has menu items");
		        menuBar.add(menu);
		        
		        menuItem = new JMenuItem("A text-only menu item",
                        KeyEvent.VK_T);
				menuItem.setAccelerator(KeyStroke.getKeyStroke(
				       KeyEvent.VK_1, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription(
				       "This doesn't really do anything");
				menu.add(menuItem);
		        
		        frame.setJMenuBar(menuBar);
		
		        textArea = new JTextPane();
		        textAreaScroll = new JScrollPane(textArea);
		        textAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        textAreaScroll.setAutoscrolls(true);
		        textArea.setBackground(StyleManager.bgColor);
		        textArea.setForeground(StyleManager.fgColor);
		        //ta1.setEditable(false);
		        //ta1.setLineWrap(true);
		        //ta1.setWrapStyleWord(true);
		        c.fill = GridBagConstraints.BOTH;
		        c.weightx = 1.0;
		        c.weighty = 1.0;
		        c.gridx = 0;
		        c.gridy = 0;
		        c.gridwidth = 3;
		        c.gridheight = 1;
		        doc = textArea.getStyledDocument();
		        pane.add(textAreaScroll, c);
		        
		        entry = new JTextField();
		        //entry.addActionListener(entryListener);
		        //entryListener.start();
		        entry.setBackground(StyleManager.bgColor);
		        entry.setForeground(StyleManager.fgColor);
		        c.fill = GridBagConstraints.BOTH;
		        c.weightx = 1.0;
		        c.weighty = 0.005;
		        c.gridx = 0;
		        c.gridy = 2;
		        c.gridwidth = 1;
		        c.gridheight = 1;
		        pane.add(entry, c);
		        
		        //Size and display the window.
		        frame.setSize(800,600);
		        frame.setVisible(true);
		        
		        styleManager = new StyleManager();
		    }
		    
	public static void print(String str) {
	        try {
	        	System.out.println(str+" printed");
				doc.insertString(doc.getLength(), str, doc.getStyle("regular"));
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
    public static void print(String str, boolean newline) {
        try {
			doc.insertString(doc.getLength(), str, doc.getStyle("regular"));
			if (newline) {
				doc.insertString(doc.getLength(), "\n", null);
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void printColor(String col, String str) {
        try {
        	System.out.println(str+" printed with color "+col);
			doc.insertString(doc.getLength(), str, doc.getStyle(col));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void printColor(String col, String str, boolean newline) {
        try {
			doc.insertString(doc.getLength(), str, doc.getStyle(col));
			if (newline) {
				doc.insertString(doc.getLength(), "\n", null);
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //This method is pretty cool, just saying. If you pass any text to it with the string "\\_STYLE\" inside of it where "style"
    //is any of the styles from StyleManager in addStylesToDocument, it applies the styles to them. Pretty sexy if you ask me.
    public static void printParseColor(String str) {
        try {
        	//str = ENTIRE string
        	String styleStr = null; // String that will hold the name of the style
        	String segment = str; // INITIALIZES SEGMENT VAR TO STRING INPUTED
        	int indBegin = 0;
        	int indEnd = 0;
        	if (segment.contains("\\_")) {
        		doc.insertString(doc.getLength(), str.substring(0,str.indexOf("\\_")), doc.getStyle("regular")); // Is there regular text before a colorcode tag? If so, this prints it normally
	        	while (segment.contains("\\_")) {
	        		indBegin = segment.indexOf("\\_")+2; // Sets an index beginning here for 2 after \_, the place where the style string begins
	        		indEnd = segment.substring(indBegin+1).indexOf("\\")+indBegin+1; // Sets the end to be at the end of the closing \
	        		styleStr = segment.substring(indBegin,indEnd); // Sets the styleStr to be whatever is between indBegin and indEnd
	        		String tmpSeg = segment.substring(indEnd+1); // Sets tmpSeg to grab the end of the closing colorcode tag (\), or the beginning of actual text
	        		if (tmpSeg.contains("\\_"))  tmpSeg = tmpSeg.substring(0,tmpSeg.indexOf("\\_")); // If there's another colorcode coming up, set the tmpSeg to end before it
	        		doc.insertString(doc.getLength(), tmpSeg, doc.getStyle(styleStr));
	        		segment = segment.substring(indEnd+1);
	        	}
        	} else doc.insertString(doc.getLength(), str, doc.getStyle("regular")); // Is there no color code defined? Just print whatever, then (though this shouldn't happen!)
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
    }
    
    public static void printParseColor(String str, boolean newline) { // ParseColor with optional newline argument
        try {
        	//str = ENTIRE string
        	String styleStr = null; // String that will hold the name of the style
        	String segment = str; // INITIALIZES SEGMENT VAR TO STRING INPUTED
        	int indBegin = 0;
        	int indEnd = 0;
        	if (segment.contains("\\_")) {
        		doc.insertString(doc.getLength(), str.substring(0,str.indexOf("\\_")), doc.getStyle("regular")); // Is there regular text before a colorcode tag? If so, this prints it normally
	        	while (segment.contains("\\_")) {
	        		indBegin = segment.indexOf("\\_")+2; // Sets an index beginning here for 2 after \_, the place where the style string begins
	        		indEnd = segment.substring(indBegin+1).indexOf("\\")+indBegin+1; // Sets the end to be at the end of the closing \
	        		styleStr = segment.substring(indBegin,indEnd); // Sets the styleStr to be whatever is between indBegin and indEnd
	        		String tmpSeg = segment.substring(indEnd+1); // Sets tmpSeg to grab the end of the closing colorcode tag (\), or the beginning of actual text
	        		if (tmpSeg.contains("\\_"))  tmpSeg = tmpSeg.substring(0,tmpSeg.indexOf("\\_")); // If there's another colorcode coming up, set the tmpSeg to end before it
	        		doc.insertString(doc.getLength(), tmpSeg, doc.getStyle(styleStr));
	        		segment = segment.substring(indEnd+1);
	        	}
        	} else doc.insertString(doc.getLength(), str, doc.getStyle("regular"));// Is there no color code defined? Just print whatever, then (though this shouldn't happen!)
			if (newline==true) doc.insertString(doc.getLength(), "\n", doc.getStyle("regular"));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
    }
    
    public static void printColoredVariable(String color, String str, String var) {
        try {
			doc.insertString(doc.getLength(), str, doc.getStyle(color));
			doc.insertString(doc.getLength(), " "+var+"\n", doc.getStyle("regular"));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void printColoredVariable(String color, String str, String var, boolean newline) {
        try {
			doc.insertString(doc.getLength(), str, doc.getStyle(color));
			doc.insertString(doc.getLength(), " "+var, doc.getStyle("regular"));
			if (newline) {
				doc.insertString(doc.getLength(), "\n", null);
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void println(String str) {
        try {
			doc.insertString(doc.getLength(), str+"\n", doc.getStyle("regular"));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		    
    public static JTextField getEntryField() {
    	return entry;
    }
    
    public static String getEntryText(){
		return entry.getText();
    }
    
    public static void setEntryText(String str){
    	entry.setText(str);
    }
    
    public static void clearEntry(){
    	entry.setText("");
    }
    
}