package ged.daedaluswin.crmclient.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ged.daedaluswin.crmclient.helper.IconMapping;
import ged.daedaluswin.crmclient.helper.Init;

/**
 * Created by TeoGia on 04 April 2015.
 */
public class MainMenu extends JFrame{
    private JPanel mainMenuPanel;
    private JButton buttonContactManagements;
    private JLabel title;

    public MainMenu() {
        IconMapping iconMapping = iconMap();//Gets the instance of the IconMapping object

        JFrame frame = new JFrame("MainMenu");
        frame.setContentPane(mainMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        buttonContactManagements.setIcon(iconMapping.getMyIcon("buttonContactManagements"));
        title.setIcon(iconMapping.getMyIcon("title"));
        frame.pack();
        frame.setVisible(true);


        buttonContactManagements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {new TestForm(frame, iconMapping);}
        });
    }

    /**
     * Responsible for instantiating the IconMapping Object
     * @return Returns the Icon Mapping, after having instantiated it as an Object
     */
    private IconMapping iconMap(){
        IconMapping iconMapping = new IconMapping();
        iconMapping.loadIconMap();
        return iconMapping;

    }

    public static void main(String[] args)  {
        Init._init();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu();
                Init.keepRunning = false;
            }
        });

    }
}
