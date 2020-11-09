import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JPanel implements ActionListener {
    private  String names[] = {"My info", "University List", "Comapre","About"};
    private  JButton buttons[] = new JButton[names.length];
    private  JPanel listPnl , outputPnl;
    private  CardLayout  cardLayout ;
    private  MyInfopage myInfopage;

    public MenuPage(){
        setPreferredSize(new Dimension(900 ,700));
        setLayout(new BorderLayout());

        //adding menu buttons
        listPnl = new JPanel();
        listPnl.setBackground(new Color(0,85,128));
        listPnl.setPreferredSize(new Dimension(200 ,700));
        listPnl.setLayout(new GridLayout(16,1 ,2,2));

        for (int i = 0 ; i<names.length ; i++){
            buttons[i] = new JButton(names[i]);
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            buttons[i].addActionListener(this);
            listPnl.add(buttons[i]);
        }
        add(listPnl,BorderLayout.WEST);

        ///showing MyInfo page for data input
        outputPnl = new JPanel();
        outputPnl.setPreferredSize(new Dimension(700 ,700));
        cardLayout = new CardLayout();
        outputPnl.setLayout(cardLayout);

        myInfopage = new MyInfopage(); // making MyInfo page object
        outputPnl.add(myInfopage);

        add(outputPnl,BorderLayout.CENTER);
        setVisible(true);
    }

    @Override// defining menu button action
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==buttons[0]) {
            //no action
        }
        if(event.getSource()==buttons[1]) {
            new UniversityListPage();
        }
        if(event.getSource()==buttons[2]){
            new ComparePage();
        }
        if(event.getSource()==buttons[3]){
            new About();
        }
    }

}
