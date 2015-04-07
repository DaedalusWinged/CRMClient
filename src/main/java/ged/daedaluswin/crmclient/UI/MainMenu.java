package ged.daedaluswin.crmclient.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TeoGia on 04 April 2015.
 */
public class MainMenu extends JFrame{
    private JPanel mainMenuPanel;
    private JButton contactManagementButton;
    private JButton activityManagementButton;

    public MainMenu() {

        contactManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainMenu.this.setVisible(false);
                //new TestForm().setVisible(true);

            }
        });

        activityManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainMenu");
        frame.setContentPane(new MainMenu().mainMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
