package janela;

import aplicacao.ACMERobots;
import dados.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class selecionaCliente {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Cliente> clienteList;
    private JPanel painel1;
    private JLabel tituloTela1;
    private JButton INDIVIDUALButton;
    private JButton EMPRESARIALButton;
    private JButton clientesCadastradosButton;
    private JButton fecharButton;
    private JTextArea textAreaMensagem;
    private JButton limparButton;


    public selecionaCliente(App app, ACMERobots clientes){
        acmeRobots = clientes;
        clienteList = acmeRobots.getListCliente();

        //ao selecionar deve mudar para pagina de cadastramento de cliente individual
        INDIVIDUALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                app.mudaPainel(2);
            }
        });

        //ao selecionar deve mudar para pagina de cadastramento de cliente empresarial
        EMPRESARIALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                app.mudaPainel(3);
            }
        });

        //mostrar o registro de clientes
        clientesCadastradosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaMensagem.setText("");
                clienteList.sort((c1,c2)-> Integer.compare(c1.getCodigo(), c2.getCodigo()));

                for (Cliente cliente : clienteList){
                    textAreaMensagem.append(cliente.toString() +  "\n");
                }
            }
        });

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textAreaMensagem.setText("");
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textAreaMensagem;
    }

    public JPanel getPainel() {
        return painel1;
    }
}
