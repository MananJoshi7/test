import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBarExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("MenuBar Example");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);

        fileMenu.addSeparator();

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");

        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);

        fileMenu.addSeparator();
  
        JMenuItem printItem = new JMenuItem("Print");

        fileMenu.add(printItem);

        JMenu editMenu = new JMenu("Edit");

        JRadioButtonMenuItem lineItem = new JRadioButtonMenuItem("Line");
        JRadioButtonMenuItem rectangleItem = new JRadioButtonMenuItem("Rectangle");
        JRadioButtonMenuItem circleItem = new JRadioButtonMenuItem("Circle");

        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(lineItem);
        shapeGroup.add(rectangleItem);
        shapeGroup.add(circleItem);

        editMenu.add(lineItem);
        editMenu.add(rectangleItem);
        editMenu.add(circleItem);

        editMenu.addSeparator();
        
        JCheckBoxMenuItem redItem = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem greenItem = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem blueItem = new JCheckBoxMenuItem("Blue");
        
        editMenu.add(redItem);
        editMenu.add(greenItem);
        editMenu.add(blueItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        frame.setJMenuBar(menuBar);
        

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
