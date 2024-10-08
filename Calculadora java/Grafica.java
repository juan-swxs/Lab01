import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafica extends JFrame{

    private JPanel panel; 
    private JPanel buttonPanel;
    private String operator = "";
    private double PrimeOperand = 0;
    private boolean isOperatorSelected = false;
    private JButton[] buttons;
    private JTextField screen;
    private String[] buttonLabels = {
        "7", "8", "9", "AC", 
        "4", "5", "6", "*", 
        "1", "2", "3", "-",
        "0", "/", "=", "+"
    };
    private String[] buttonMetric = {
        "sin", "cos", "tan", "IVA",
        "in", "log", "1/x", "x^n",
        "√", "sin-1", "cos-1","tan-1",
        "(",")", ".", "="
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

       panel.setBackground(Color.DARK_GRAY);

       panel.setLayout(null);
       this.getContentPane().add(panel);

    }

    private void pantalla(){
        screen = new JTextField();

        screen.setBackground(Color.GRAY);
        screen.setForeground(Color.WHITE);

        screen.setBounds(50, 50, 300, 50);

        panel.add(screen);
    }

    private void Botones(){
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBounds(50, 110, 300, 300);
        ActualizeButton();
        panel.add(buttonPanel);
    }

    private void ChangeButton(){
        JButton Change = new JButton("to exchange");
        Change.setBackground(Color.GRAY);
        Change.setForeground(Color.WHITE);
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
            buttons[n].setBackground(Color.GRAY);
            buttons[n].setForeground(Color.WHITE);

            buttons[n].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton hold_down = (JButton) e.getSource();
                    String text = hold_down.getText();
                    try{
                        if("0123456789-.".contains(text)){
                            if(isOperatorSelected){
                                screen.setText("");
                                isOperatorSelected = false;
                            }
                            screen.setText(screen.getText() + text);
    
                        }else if(text.equals("AC")){
                            screen.setText("");
                            operator = "";
                            PrimeOperand = 0;
                            isOperatorSelected = false;
    
                        }else if(text.equals("=")){
                            double resultado = 0;
                            double SecoundOperator = Double.parseDouble(screen.getText());
    
                            switch (operator) {
                                case "+":   
                                    resultado = Funciones.additon(PrimeOperand,SecoundOperator);
                                    break;
                                case "-":
                                    resultado = Funciones.remaind(PrimeOperand,SecoundOperator);
                                    break;
                                case "*":
                                    resultado = Funciones.multiply(PrimeOperand, SecoundOperator);
                                    break;
                                case "/":
                                    if(SecoundOperator != 0){
                                        resultado = Funciones.split(PrimeOperand, SecoundOperator);
                                    }else{
                                        screen.setText("Error: division por 0 no permitida");
                                        return;
                                    }
                                    break;
                                case "x^n":
                                    resultado = Funciones.Power(PrimeOperand, SecoundOperator);
                                    break;
                                case "IVA":
                                    resultado = Funciones.iva(PrimeOperand, SecoundOperator);
                                    break;
                                default:
                                    screen.setText("¡¡..Error opcion no valida..!!");
                                    return;
                            }
                            screen.setText(String.valueOf(resultado));
                            operator = "";
    
                        }else if(text.equals("sin")){
                            screen.setText(String.valueOf(Funciones.Sen(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("cos")){
                            screen.setText(String.valueOf(Funciones.Cos(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("√")){
                            if(Double.parseDouble(screen.getText()) < 0){
                                screen.setText("Error: Raíz cuadrada de un número negativo no es un número real.");
                            }else{
                                screen.setText(String.valueOf(Funciones.radical(Double.parseDouble(screen.getText()))));
                            }  
                        }else if(text.equals("tan")){
                            screen.setText(String.valueOf(Funciones.tang(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("log")){
                            screen.setText(String.valueOf(Funciones.Ln(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("sin-1")){
                            screen.setText(String.valueOf(Funciones.Antsen(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("cos-1")){
                            screen.setText(String.valueOf(Funciones.Antcon(Double.parseDouble(screen.getText()))));
                        }else if(text.equals("tan-1")){
                            screen.setText(String.valueOf(Funciones.AntTangh(Double.parseDouble(screen.getText()))));
                        }else if("+-*/x^nIVA".contains(text)){
                            operator = text;
                            PrimeOperand = Double.parseDouble(screen.getText());
                            isOperatorSelected = true;
                        }
                    }catch(NumberFormatException ex){
                        screen.setText("...Error...");
                    }
                   
                }
            });

            buttonPanel.add(buttons[n]);
        }

        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
 }

    

