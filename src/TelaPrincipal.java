import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private FilaEncadeada fila = new FilaEncadeada();
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> lista = new JList<>(modeloLista);
    private JTextField campoNome = new JTextField(15);
    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoAtender = new JButton("Atender");

    public TelaPrincipal() {
        super("Check-in Evento");
        JPanel painel = new JPanel();
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(botaoAdicionar);
        painel.add(botaoAtender);
        add(painel, "North");
        add(new JScrollPane(lista), "Center");

        botaoAdicionar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            if (!nome.isEmpty()) {
                fila.enfileirar(nome);
                modeloLista.addElement(nome);
                campoNome.setText("");
            }
        });

        botaoAtender.addActionListener(e -> {
            if (fila.estaVazia()) {
                JOptionPane.showMessageDialog(this, "Fila vazia.");
            } else {
                String atendido = fila.desenfileirar();
                modeloLista.remove(0);
                JOptionPane.showMessageDialog(this, "Atendendo: " + atendido);
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
