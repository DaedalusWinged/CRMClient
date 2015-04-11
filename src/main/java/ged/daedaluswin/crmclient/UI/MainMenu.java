package ged.daedaluswin.crmclient.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ged.daedaluswin.crmclient.helper.IconMapping;

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
            public void actionPerformed(ActionEvent actionEvent) {
                new TestForm(frame);
            }
        });

    }
    private IconMapping iconMap(){
        IconMapping iconMapping = new IconMapping();
        iconMapping.loadIconMap();
        return iconMapping;

    }

    private static void _init(){

        //TODO theme needs to be changed according to user's OS (new function)
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    public static void main(String[] args) {
        _init();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {new MainMenu();}
        });

    }
}
