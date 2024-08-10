import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafica extends JFrame{

    private JPanel panel; 
    private JPanel buttonPanel;
    private JButton[] buttons;
    private JTextField screen;
    private String[] buttonLabels = {
        "7", "8", "9", "/", 
        "4", "5", "6", "*", 
        "1", "2", "3", "-", 
        "0", ".", "=", "+"
    };
    private String[] buttonMetric = {
        "sin", "cos", "tan", "%",
        "in", "log", "1/x", "x^n",
        "√ ", "sin-1", "cos-1","tan-1",
        "(",")", ",", "="
    };
    private boolean isNumeric = true; 


    public Grafica(){

        setBounds(500, 100, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculadora.");

        IniciarComp();

    }

    private void IniciarComp(){
        Paneles();
        pantalla();
        Botones();
        ChangeButton();

    }


    private void Paneles(){
       panel = new JPanel();

       panel.setLayout(null);
       this.getContentPane().add(panel);

    }

    private void pantalla(){
        screen = new JTextField();

        screen.setBounds(50, 50, 300, 50);

        panel.add(screen);
    }

    private void Botones(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBounds(50, 100, 300, 300);
        ActualizeButton();
        panel.add(buttonPanel);
    }

    private void ChangeButton(){
        JButton Change = new JButton("to exchange");
        Change.setBounds(50, 420, 300, 30);
        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isNumeric = !isNumeric;
                ActualizeButton();
            }
        });
        
        panel.add(Change);

    }

    private void ActualizeButton(){
        buttonPanel.removeAll();
        String [] condition = isNumeric ? buttonLabels : buttonMetric;

        buttons = new JButton [condition.length];

        for(int n = 0; n < condition.length ; n++){
            buttons[n] = new JButton(condition[n]);
            buttons[n].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
            });

            buttonPanel.add(buttons[n]);
        }

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
 }

    

