package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton AddPeopleButton;
    private JLabel ListOfPeople;
    private JPanel MainPanel;

    /**
     * Actions for all the buttons
     */

    public GUI()
    {
        AddPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Test button clicked");
                ListOfPeople.setText("Button was clicked");
            }
        });
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
