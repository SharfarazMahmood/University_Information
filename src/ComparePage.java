import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ComparePage extends JFrame {
   private ArrayList<Information>list=new ArrayList<Information>();

   ComparePage(){
       super("Eligible list (Science Group Only)");
       setSize(500,600);
       setLocation(300,200);
       setResizable(true);

       JPanel cmppnl=new JPanel();
       cmppnl.setPreferredSize(new Dimension(500,600));
       cmppnl.setBackground(Color.darkGray);
       cmppnl.setLayout(new GridLayout(13,1));

       add(cmppnl);
       setVisible(true);

       //reading university list
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
           System.out.println("University info file read problem in compare page 1");
       }
       //System.out.println(list);

       /// reading student object and comparing with university data
       StdInformation info;
       try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Files/Last saved.myinfo"));
           info = (StdInformation) in.readObject();
           in.close();
           info.eligibility(list); //comparing with university data and making eligible list
       } catch (Exception ioe) {
           System.out.println("Student file read prblem in compare page" );
       }

       ///adding button according to eligible list
       try{
           BufferedReader br=new BufferedReader(new FileReader("src/Files/eligible.txt"));
           while (true) {
               String sn =br.readLine();
               if(sn==null){break;}
               for(Information i :list) {
                   if (sn.compareTo(i.getName())==0){
                       JButton b = new JButton(i.getName());
                       b.setBackground(Color.DARK_GRAY);
                       b.setForeground(Color.GREEN);
                       b.setFont(new Font("SansSerif", Font.PLAIN, 16));
                       b.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent actionEvent) {
                               openWebPage(i.getWedsite());
                           }
                       });
                       cmppnl.add(b);
                   }
               }
           }
           br.close();
       } catch (IOException e) {
           System.out.println("Eligible list file read problem in compare page 1");
       }
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
