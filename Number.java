import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
class MyFrame extends Frame implements ActionListener,TextListener{
    Label l1,l2,l3;
    TextField t1,t2;
    Button b;
   // int res;
   // String str= " ";
    public MyFrame(){
        super("task2");
        l1=new Label("The number is");
        l2=new Label("Enter your guess");
        l3=new Label(" no tries ");
        b=new Button("Generate");
        t1=new TextField(" ");
        t2=new TextField(" ");
        t1.setEchoChar('*');

        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(b);
        add(l2);
        add(t2);
        add(l3);

        b.addActionListener(this);
        t2.addTextListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        String r=" ";
        if(e.getSource()==b){
            Random rr=new Random();
             int n1=rr.nextInt(100)+1;
             r=r+n1;
            t1.setText(r);
        }
    }
    public void textValueChanged(TextEvent te){
        int count=0;
        if(te.getSource()==t2){
           /*int r=Integer.parseInt(t1.getText());
            int r2=Integer.parseInt(t2.getText());*/
            String str=" ";
        if(t1.getText().compareTo(t2.getText())==0){
               // l3.setText("Try Lower");
                str=str+"Bingo ";
            }
            else if(t1.getText().compareTo(t2.getText())>0){
                //l3.setText("Bingo");
                str=str+"Try Higher";
            }
            else if(t1.getText().compareTo(t2.getText())<0){
                //l3.setText("Try Higher");
                str=str+"Try Lower";
            }
            l3.setText(str);
        }
    }
}


public class Number {
    public static void main(String args []){
        MyFrame f=new MyFrame();
        f.setSize(300,300);
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
