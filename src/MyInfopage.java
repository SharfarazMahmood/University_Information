import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyInfopage extends JPanel {
    JLabel name , sscGpa ,hscGpa  , submitlable , lastsaved , lastname, lastsscGpa , lasthscGpa , lastsscWithout4th ,lasthscWithout4th,uinfo;
    JLabel sscWithout4th , hscWithout4th;
    JTextField nametf, sscGpatf, hscGpatf, sscWithout4thtf , hscWithout4thtf;
    JButton submit ;
    StdInformation info;

    public MyInfopage(){
        setPreferredSize(new Dimension(400,700));
        setLayout(null);

//        uinfo = new JLabel("Only for Science Group");
//        uinfo.setFont(new Font("SansSerif", Font.BOLD, 15));
//        uinfo.setBounds(250, 40, 220, 30);
//        uinfo.setForeground(new Color(0,85,128));
//        add(uinfo);

        name = new JLabel("Name  ");
        name.setFont(new Font("SansSerif", Font.BOLD, 15));
        name.setBounds(70, 100, 80, 30);
        nametf = new JTextField(150);
        nametf.setBounds(160, 100, 400, 30);
        add(name);
        add(nametf);

        sscGpa = new JLabel("SSC GPA  ");
        sscGpa.setFont(new Font("SansSerif", Font.BOLD, 15));
        sscGpa.setBounds(70, 160, 80, 30);
        sscGpatf = new JTextField(40);
        sscGpatf.setBounds(160, 160, 100, 30);
        add(sscGpa);
        add(sscGpatf);

        sscWithout4th = new JLabel("Without 4th  ");
        sscWithout4th.setFont(new Font("SansSerif", Font.BOLD, 15));
        sscWithout4th.setBounds(270, 160, 90, 30);
        sscWithout4thtf = new JTextField(40);
        sscWithout4thtf.setBounds(360, 160, 100, 30);
        add(sscWithout4th);
        add(sscWithout4thtf);

        hscGpa = new JLabel("HSC GPA  ");
        hscGpa.setFont(new Font("SansSerif", Font.BOLD, 15));
        hscGpa.setBounds(70, 200, 80, 30);
        hscGpatf = new JTextField(40);
        hscGpatf.setBounds(160, 200, 100, 30);
        add(hscGpa);
        add(hscGpatf);

        hscWithout4th = new JLabel("Without 4th  ");
        hscWithout4th.setFont(new Font("SansSerif", Font.BOLD, 15));
        hscWithout4th.setBounds(270, 200, 90, 30);
        hscWithout4thtf = new JTextField(40);
        hscWithout4thtf.setBounds(360, 200, 100, 30);
        add(hscWithout4th);
        add(hscWithout4thtf);

        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reading data prom the MyInfo page using submit button
                try {
                    String name = nametf.getText();
                    double sscGpa = Double.parseDouble(sscGpatf.getText());
                    double hscGpa = Double.parseDouble(hscGpatf.getText());
                    double sscWithout4th=Double.parseDouble(sscWithout4thtf.getText());
                    double hscWithout4th=Double.parseDouble(hscWithout4thtf.getText());
                    info = new StdInformation(name, sscGpa,sscWithout4th,hscGpa,hscWithout4th);
                    submitlable.setForeground(new Color(51, 255, 51));
                    submitlable.setText("Successful");

                    //writing student object file
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/Files/Last saved.myinfo"));
                        out.writeObject(info);
                        out.flush();
                        out.close();
                    } catch (Exception ioe) {
                        System.out.println("Student information file write prblem");
                    }

                } catch (Exception exc) {
                    submitlable.setForeground(Color.RED);
                    submitlable.setText("Unsuccessful!!!");
                } finally {
                    nametf.setText("");
                    sscGpatf.setText("");
                    hscGpatf.setText("");
                    sscWithout4thtf.setText("");
                    hscWithout4thtf.setText("");

                    //showing last read student information from student object file
                    try {
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Last saved.myinfo"));
                        info = (StdInformation) in.readObject();
                        in.close();
                    } catch (Exception ioe) {
                        System.out.println("Student information file read prblem" + ioe);
                    }
                    lastname.setText("Name     :  " + info.getStdName());
                    lastsscGpa.setText("SSC GPA  :  " + info.getStdSscGpa());
                    lastsscWithout4th.setText("Without 4th:  "+info.getStdSscWithout4th());
                    lasthscGpa.setText("HSC GPA  :  "+info.getStdHscGpa());
                    lasthscWithout4th.setText("Without 4th:  "+info.getStdHscWithout4th());
                }

            }
        });
        submit.setBounds(480, 250, 80, 30);
        add(submit);

        submitlable = new JLabel(""); //to show if saving is successful
        submitlable.setFont(new Font("SansSerif", Font.BOLD, 15));
        submitlable.setBounds(300, 300, 120, 30);
        add(submitlable);


        lastsaved = new JLabel("Last saved ");
        lastsaved.setFont(new Font("SansSerif", Font.BOLD, 15));
        lastsaved.setBounds(70 , 350 , 120,30);

        lastname = new JLabel("Name     :  ");
        lastname.setFont(new Font("SansSerif", Font.BOLD, 15));
        lastname.setBounds(70,400 , 300,30);

        lastsscGpa = new JLabel("SSC GPA  :  ");
        lastsscGpa.setFont(new Font("SansSerif", Font.BOLD, 15));
        lastsscGpa.setBounds(70,430 , 120,30);

        lastsscWithout4th = new JLabel("Without 4th:  ");
        lastsscWithout4th.setFont(new Font("SansSerif", Font.BOLD, 15));
        lastsscWithout4th.setBounds(270,430 , 120,30);

        lasthscGpa = new JLabel("HSC GPA  :  ");
        lasthscGpa.setFont(new Font("SansSerif", Font.BOLD, 15));
        lasthscGpa.setBounds(70,460 , 120,30);

        lasthscWithout4th = new JLabel("Without 4th:  ");
        lasthscWithout4th.setFont(new Font("SansSerif", Font.BOLD, 15));
        lasthscWithout4th.setBounds(270,460 , 120,30);

        //showing last saved student information if available
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Last saved.myinfo")); // read object
            info = (StdInformation) in.readObject();
            in.close();
            lastname.setText("Name     :  " + info.getStdName());
            lastsscGpa.setText("SSC GPA  :  " + info.getStdSscGpa());
            lastsscWithout4th.setText("Without 4th:  "+info.getStdSscWithout4th());
            lasthscGpa.setText("HSC GPA  :  "+info.getStdHscGpa());
            lasthscWithout4th.setText("Without 4th:  "+info.getStdHscWithout4th());

        }catch (Exception ioe){
            System.out.println("No student information file found"+ioe);
        }
        add(lastsaved);
        add(lastname);
        add(lastsscGpa);
        add(lastsscWithout4th);
        add(lasthscWithout4th);
        add(lasthscGpa);
    }

}
