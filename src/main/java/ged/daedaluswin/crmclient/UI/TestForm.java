package ged.daedaluswin.crmclient.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import ged.daedaluswin.crmclient.jaxws.ContactManagement;
import ged.daedaluswin.crmclient.jaxws.TestWS;

/**
 * Created by TeoGia on 3/22/15.
 */
public class TestForm {
    private JTextArea textArea1;
    private JTextField InputField;
    private JButton button1;
    private JPanel TestJpanel;

    public TestForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("I've been clicked!!!:D");
                textArea1.setText(ContactManagement.contactList());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(new TestForm().TestJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
