import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

class MarcoCasillaVerificacion extends JFrame {
    private JTextField campoTexto;
    private JCheckBox negritaJCheckBox;
    private JCheckBox cursivaJCheckBox;

    public MarcoCasillaVerificacion() {
        super("Buleje Bravo Salet - Cazorla Macedo Irvin");
        setLayout(new FlowLayout());

        campoTexto = new JTextField("Observe cómo cambia el estilo de tipo de letra", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        negritaJCheckBox = new JCheckBox("Negrita");
        cursivaJCheckBox = new JCheckBox("Cursiva");
        add(negritaJCheckBox);
        add(cursivaJCheckBox);

        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negritaJCheckBox.addItemListener(manejador);
        cursivaJCheckBox.addItemListener(manejador);
    }

    private class ManejadorCheckBox implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evento) {
            Font tipoLetra = null;

            if (negritaJCheckBox.isSelected() && cursivaJCheckBox.isSelected())
                tipoLetra = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (negritaJCheckBox.isSelected())
                tipoLetra = new Font("Serif", Font.BOLD, 14);
            else if (cursivaJCheckBox.isSelected())
                tipoLetra = new Font("Serif", Font.ITALIC, 14);
            else
                tipoLetra = new Font("Serif", Font.PLAIN, 14);

            campoTexto.setFont(tipoLetra);
        }
    }
}
public class PruebaCasillaVerificacion {
    public static void main(String[] args) {
        MarcoCasillaVerificacion marcoCasillaVerificacion = new MarcoCasillaVerificacion();
        marcoCasillaVerificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoCasillaVerificacion.setSize(275, 100);
        marcoCasillaVerificacion.setVisible(true);
    }
} // fin de la clase PruebaCasillaVerificacion

