package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton AddPeopleButton;
    private JLabel ListOfPeople;
    private JPanel MainPanel;


    public GUI()
    {
        AddPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"hello world");
            }
        });
    }

    public void app()
    {
        JFrame frame = new JFrame("Money tracker");
        frame.setContentPane(new GUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
