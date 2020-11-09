import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AppInterface extends JFrame{

    private JPanel   logoPnl;
    private JLabel logoLbl1 ,logoLbl2 ;
    int x=0;
    MenuPage mp;

    public AppInterface (){
        super("THEORY of EVERYTHING");
        setSize(900,700);
        setLocation(200, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Clicked at x:"+e.getX()+", y:"+e.getY());
//            }
//        });

        setLayout(null);
        logoPnl = new JPanel();
        logoPnl.setBounds(0,0,900,700);
        logoPnl.setBackground(Color.DARK_GRAY);
        ImageIcon jc = new ImageIcon("src/java.png");
        logoLbl1 = new JLabel("",jc, JLabel.CENTER);
        logoLbl2 = new JLabel("       THEORY of EVERYTHING    Powerd by JAVA");
        logoLbl2.setForeground(Color.WHITE);
        logoLbl2.setFont(new Font("SansSerif", Font.BOLD, 18));
        logoPnl.add(logoLbl2);
        logoPnl.add(logoLbl1);

        add(logoPnl);

        setVisible(true);
        while (true){
            if(x==380)
            {
                x=0;
                super.repaint();
                break;
            }
            try{
                Thread.sleep(3);
            } catch(Exception e){ }
            x++;
            super.repaint();
        }
        remove(logoPnl);

        setLayout(new BorderLayout());
        mp = new MenuPage(); //making menu page object
        add(mp,BorderLayout.CENTER);
        setVisible(true);

    }
    ////drawing loading bar
    @Override
	public void paint(Graphics LoadBar)
    {
        super.paint(LoadBar);
        LoadBar.setColor( new Color(51, 255, 51) );
        LoadBar.fillRect(155,200,0+x,5);
    }

    ///launching the application
    public static void main(String[] args) {
        new AppInterface();

    }
}