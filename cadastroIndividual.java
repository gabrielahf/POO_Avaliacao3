package janela;

import aplicacao.ACMERobots;
import dados.Cliente;
import dados.Individual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class cadastroIndividual {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Cliente> clienteList;
    private JLabel tituloTela2;
    private JTextField textFieldNome;
    private JTextField textFieldCpf;
    private JTextField textFieldCodigo;
    private JButton confirmarButton;
    private JPanel painel2;
    private JButton RetornarButton;
    private JButton limparButton;
    private JTextArea textArea1;


    public cadastroIndividual(App app, ACMERobots clientes) {
        acmeRobots = clientes;
        clienteList = acmeRobots.getListCliente();


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //verificar string nome está recebendo caracteres
                //verificar string cpf está recebendo os 10 digitos
                //verificar int codigo está recebendo valor inteiro e se o codigo já existe na clienteList
                try{
                    String nome = textFieldNome.getText();
                    String cpf = textFieldCpf.getText();
                    int codigo = Integer.parseInt(textFieldCodigo.getText());


                    if (textFieldNome.getText().isEmpty() || textFieldCpf.getText().isEmpty() || textFieldCodigo.getText().isEmpty()){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;
                    } else if (!textFieldNome.getText().matches("[a-zA-ZÀ-ÖØ-öø-ÿ\\\\s]+")) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Nome inválido");
                        textFieldNome.setText("");
                        return;
                    } else if (textFieldCpf.getText().length() < 11){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("CPF inválido");
                        textFieldCpf.setText("");
                        return;
                    } else{
                         Cliente codExiste = acmeRobots.consultaPorCodigo(codigo);
                         if (codExiste != null){
                             getTextAreaMensagem().setText("");
                             getTextAreaMensagem().append("Código existente");
                             textFieldCodigo.setText("");
                             return;
                         }

                    }


                    Individual novoCliente = new Individual(codigo,nome,cpf);

                    if (acmeRobots.adicionarCliente(novoCliente)){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Cadastro concluído");
                    }


                    textFieldNome.setText("");
                    textFieldCpf.setText("");
                    textFieldCodigo.setText("");

                } catch (NumberFormatException e){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir código");
                    textFieldCodigo.setText("");
                }

            }
        });


        RetornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                app.mudaPainel(1);
            }
        });


        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldNome.setText("");
                textFieldCpf.setText("");
                textFieldCodigo.setText("");
                textArea1.setText("");
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel2;
    }
}
