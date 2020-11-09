import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Information implements Serializable{
    private String name ,website;
    private double sscGpa , hscGpa ;
    private double totalGpa ;
    private  boolean  with4thSub;

    public Information(){};
    public Information(String n , double sg , double hg ,double tg) {
        name = n;
        sscGpa = sg;
        hscGpa = hg;
        totalGpa = tg;
    }
    public Information(String n , String webs, double sg , double hg , double tg , boolean with4ths) {
        this(n,sg,hg ,tg);
        website = webs;
        with4thSub = with4ths;
    }

    public String getName() {
        return name;
    }
    public String getWedsite(){
        return website;
    }
    public double getSscGpa(){
        return sscGpa;
    }
    public double getHscGpa(){
        return hscGpa;
    }
    public double getTotalGpa(){
        return totalGpa;
    }
    public  boolean get4thsubstatus (){
        return with4thSub;
    }

    public String toString(){
        return name+" "+website+" "+sscGpa+" "+" "+hscGpa+" "+totalGpa+" "+with4thSub;
    }
}


class StdInformation extends Information{
    private double sscWithout4th , hscWithout4th ;
    private double totalGpaWithout4th;

    public StdInformation(){};
    public StdInformation(String n , double sg, double sgwithout4 , double hg ,  double hgwithout4) {
        super(n,sg,hg , sg+hg);
        sscWithout4th = sgwithout4;
        hscWithout4th = hgwithout4;
        totalGpaWithout4th = sgwithout4 + hgwithout4;
    }

    public String getStdName() {
        return getName();
    }
    public double getStdSscGpa(){
        return getSscGpa();
    }
    public double getStdSscWithout4th(){
        return sscWithout4th;
    }
    public double getStdHscGpa(){
        return getHscGpa();
    }
    public double getStdHscWithout4th(){
        return hscWithout4th;
    }
    public double getStdTotalGpa(){
        return getTotalGpa();
    }
    public double getTotalGpaWithout4th(){
        return totalGpaWithout4th;
    }

    public void eligibility(ArrayList<Information> alist){

        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter("src/Files/eligible.txt"));

            for (Information i: alist){
                if (i.get4thsubstatus()){
                    if(this.getStdSscGpa()>=i.getSscGpa() && this.getStdHscGpa()>=i.getHscGpa() && this.getStdTotalGpa()>=i.getTotalGpa()) {
                        bw.write(i.getName());
                        bw.newLine();
                    }
                }
                else {
                    if(this.getStdSscWithout4th()>=i.getSscGpa() && this.getStdHscWithout4th()>=i.getHscGpa() && this.getTotalGpaWithout4th()>=i.getTotalGpa()) {
                        bw.write(i.getName());
                        bw.newLine();
                    }
                }

            }
            bw.close();
        }catch(Exception e){
            System.out.println("Eligible File writing problem in eligibility method");
        }
    }
}