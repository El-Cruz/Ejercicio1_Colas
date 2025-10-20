import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JButton btnR1;
    private JButton btnR2;
    private JButton btnR3;
    private JTextArea txtR1;
    private JTextArea txtR2;
    private JTextArea txtR3;
    private JTextArea textArea1;

    private ColaBarcos gestorDeCola;

    public Ventana() {
        gestorDeCola = new ColaBarcos();

        btnR1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorDeCola.R1_inicializar();

                txtR1.setText(gestorDeCola.toString());
            }
        });


        btnR2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reporteCostos = gestorDeCola.R2_calcularCostos();

                txtR2.setText(reporteCostos);
            }
        });


        btnR3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = txtR3.getText();

                if (marca.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese la marca a buscar");
                    return;
                }

                ColaBarcos colaCopiada = gestorDeCola.R3_copiarPorMarca(marca);
                txtR3.setText("--- COLA ORIGINAL ---\n" + gestorDeCola.toString());
                textArea1.setText("--- COLA COPIADA (Marca: " + marca + ") ---\n" + colaCopiada.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
