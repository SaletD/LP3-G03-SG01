import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

class MarcoSeleccionMultiple extends JFrame {
    private final JList<String> listaJListColores;
    private final JList<String> listaJListCopia;
    private JButton botonJButtonCopiar;
    private static final String[] nombresColores = {
        "Negro", "Azul", "Cyan", "Gris oscuro", "Gris", "Verde", "Gris claro",
        "Magenta", "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    public MarcoSeleccionMultiple() {
        super("Buleje Bravo Salet - Cazorla Macedo Irvin");
        setLayout(new FlowLayout());

        listaJListColores = new JList<String>(nombresColores);
        listaJListColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListColores));

        botonJButtonCopiar = new JButton("Copiar >>>");
        botonJButtonCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                listaJListCopia.setListData(
                    listaJListColores.getSelectedValuesList().toArray(new String[0])
                );
            }
        });

        add(botonJButtonCopiar);

        listaJListCopia = new JList<String>();
        listaJListCopia.setVisibleRowCount(5);
        listaJListCopia.setFixedCellWidth(100);
        listaJListCopia.setFixedCellHeight(15);
        listaJListCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListCopia));
    }
}
public class PruebaSeleccionMultiple {
    public static void main(String[] args) {
        MarcoSeleccionMultiple marcoSeleccionMultiple = new MarcoSeleccionMultiple();
        marcoSeleccionMultiple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoSeleccionMultiple.setSize(350, 140);
        marcoSeleccionMultiple.setVisible(true);
    }
}
