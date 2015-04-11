package ged.daedaluswin.crmclient.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ged.daedaluswin.crmclient.jaxws.ContactManagement;


/**
 * Created by TeoGia on 3/22/15.
 */
public class TestForm extends JFrame {
    private JTextArea textArea1;
    private JTextField InputField;
    private JButton button1;
    private JPanel TestJpanel;

    public TestForm(JFrame parentFrame) {
        JFrame frame = parentFrame;
        frame.setContentPane(TestJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("I've been clicked!!!:D");
                textArea1.setText(ContactManagement.contactList());
            }
        });
    }
}
