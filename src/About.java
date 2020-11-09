import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        super("About");
        setSize(500,600);
        setLocation(400,200);
        setResizable(false);
        setLayout(null);

        String str= ("\n\n\tDeveloped by : \n"+
                     "\t\t Sharfaraz Mahmood Jamee\n" +
                     "\t\t ID : 011 161 183\tND\n" +
                     "\t\t Sayed Mehedi Azim\n"+
                     "\t\t ID : 011 162 097\tND\n"+
                     "\n\n\t Under the supervision of :\n" +
                     "\t\t Abdullah AL Zishan\n"+
                     "\t\t Lecturer\n" +
                     "\t\t United International University"+
                     "\n\n\n\n\tApplication Last updated 15-01-2018\n");

        JTextArea ta=new JTextArea(10,20);
        JScrollPane jsp=new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ta.setForeground(Color.CYAN);
        ta.setFont(new Font("SansSerif", Font.PLAIN, 14));
        jsp.setBounds(0,0,495,575);
        ta.setBackground(Color.DARK_GRAY);
        ta.setText(str);
        ta.setEditable(false);

        add(jsp);

        setVisible(true);
    }
}
