import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JButton btnListar;
    private JTextArea txtListar;
    private JButton btnCodigo;
    private JTextArea txtResultado;
    private JComboBox cboDestino;
    private JButton btnDestino;
    private JSpinner spCodigo;
    private Lista paquetes= new Lista();
    public Ventana() {
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Paquete p: paquetes.getListado()){
                    txtListar.append(p.toString());
                }
            }
        });
        btnCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo= Integer.parseInt(spCodigo.getValue().toString());
                try{
                    txtResultado.setText("");
                    txtResultado.setText(paquetes.buscarCodigo(codigo).toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                String destino= cboDestino.getSelectedItem().toString();
                for(Paquete p: paquetes.paqueteConDestino(destino)){
                    txtResultado.append(p.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
