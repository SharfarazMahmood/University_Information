import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UniversityListPage extends JFrame{
    private ArrayList<Information> list=new ArrayList<Information>();

    public UniversityListPage(){
        super("University List");
        setSize(500,600);
        setLocation(200, 200);
        setResizable(true);

        //reading university list (13 at the moment)
        try{
            BufferedReader br =new BufferedReader(new FileReader("src/Files/UniversityInfo.txt"));
            Information uni;
            while (true)
            {
                String sn =br.readLine();
                if(sn==null){break;}
                String sw=br.readLine();
                double ssc=Double.parseDouble(br.readLine());
                double hsc=Double.parseDouble(br.readLine());
                double total=Double.parseDouble(br.readLine());
                boolean sub4=Boolean.parseBoolean(br.readLine());

                uni=new Information(sn,sw,ssc,hsc,total,sub4);
                list.add(uni);
            }
            br.close();
        }
        catch(IOException ioe){
            System.out.println("University info problem");
        }

        //adding button according to number of university
        setLayout(new GridLayout(13,1));
        int count=0;
        for(Information i : list){
            JButton b = new JButton(i.getName());
            b.setBackground(Color.DARK_GRAY);
            b.setForeground(Color.WHITE);
            b.setFont(new Font("SansSerif", Font.PLAIN, 16));
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    openWebPage(i.getWedsite());
                }
            });

            add(b);
        }
        setVisible(true);
    }

    public void openWebPage(String url){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

