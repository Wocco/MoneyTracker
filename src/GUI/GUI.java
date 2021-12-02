package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JPanel MainPanel;
    private JTabbedPane Tabbedpane;
    private JLabel welcomeTextField;

    /**
     * Actions for all the buttons
     */

    public GUI()
    {

    }

    /**
     * Initialize the gui
     *
     */
    public void app()
    {
        JFrame frame = new JFrame("Money tracker");
        frame.setContentPane(new GUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
    }
}
