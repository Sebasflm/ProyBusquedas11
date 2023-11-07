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
    private JPanel Buscar;
    private JPanel Listar;
    private JPanel Ingreso;
    private JTextField origenField;
    private JTextField pesoField;
    private JTextField remitenteField;
    private JTextField destinoField;
    private JLabel titulo;
    private JTextField codigoField;
    private JButton btnAgregarPaquete;
    private Lista paquetes= new Lista();
    public Ventana() {
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paquetes.ordenarPaquetesPorCodigo();
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
        btnAgregarPaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int codigo1= Integer.parseInt(codigoField.getText());
                if (codigoField.getText().isEmpty() || origenField.getText().isEmpty() ||
                        destinoField.getText().isEmpty() || remitenteField.getText().isEmpty() || pesoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese informacion en todos los campos para ingresar un nuevo paquete");
                }
                try {
                    if (paquetes.comprobarUnicidad(codigo1)){

                        paquetes.getListado().add(new Paquete(Integer.parseInt(codigoField.getText()), origenField.getText(),
                                destinoField.getText(), remitenteField.getText(), Float.parseFloat(pesoField.getText()) ));
                        paquetes.ordenarPaquetesPorCodigo();
                        JOptionPane.showMessageDialog(null, "El paquete ha sido agregado con exito");


                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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
