import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

class MarcoGridLayout extends JFrame implements ActionListener {
    private final JButton[] botones;
    private static final String[] nombres = {
        "uno", "dos", "tres", "cuatro", "cinco", "seis"
    };
    private boolean alternar = true;
    private Container contenedor;
    private GridLayout cuadricula1;
    private GridLayout cuadricula2;

    public MarcoGridLayout() {
        super("Buleje Bravo Salet - Cazorla Macedo Irvin");
        cuadricula1 = new GridLayout(2, 3, 5, 5);
        cuadricula2 = new GridLayout(3, 2);
        contenedor = getContentPane();
        setLayout(cuadricula1);
        botones = new JButton[nombres.length];

        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {
            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this);
            add(botones[cuenta]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (alternar) {
            contenedor.setLayout(cuadricula2);
        } else {
            contenedor.setLayout(cuadricula1);
        }

        alternar = !alternar;
        contenedor.validate();
    }
}
public class DemoGridLayout {
    public static void main(String[] args) {
        MarcoGridLayout marcoGridLayout = new MarcoGridLayout();
        marcoGridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoGridLayout.setSize(300, 200);
        marcoGridLayout.setVisible(true);
    }
}
