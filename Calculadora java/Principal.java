import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal{

    public static JFrame frame;
    public static JButton[] boton;

    public static void main(String[] args) {
        String titulo = "Lab01: Introducción al lenguaje Java";

        String opciones[] = {"Calculadora consola", "Calculadora gráfica (Swing)"};

        final int nump = opciones.length;

        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 400, 110);
        frame.setLayout(new BorderLayout());

        JPanel Panelbuttons = new JPanel();
        Panelbuttons.setLayout(new GridLayout(nump,1));

        boton = new JButton[nump];

        for(int n = 0; n < nump; n++){
            final int index = n;
            boton[n] = new JButton(opciones[n]);
            boton[n].setBackground(Color.darkGray);
            boton[n].setForeground(Color.WHITE);
            boton[n].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            boton[index].setEnabled(!boton[index].isEnabled());
                            Consola consola = new Consola();
                            System.out.println(consola);
                            break;
                        case 1:
                            boton[index].setEnabled(!boton[index].isEnabled());
                            Grafica grafica = new Grafica();
                            grafica.setVisible(true);
                            break;
                    }
                }
            });

            Panelbuttons.add(boton[n]);
        }

        frame.add(Panelbuttons, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}