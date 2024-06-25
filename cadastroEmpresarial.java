package janela;

import aplicacao.ACMERobots;
import dados.Cliente;
import dados.Empresarial;
import dados.Individual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class cadastroEmpresarial {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Cliente> clienteList;
    private JPanel painel3;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldAno;
    private JButton confirmarButton;
    private JButton retornarButton;
    private JButton limparButton;
    private JTextArea textArea2;


    public cadastroEmpresarial(App app, ACMERobots clientes) {
        acmeRobots = clientes;
        clienteList = acmeRobots.getListCliente();

        // try/catch variaveis e armazenar cadastro na clienteList
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //verificar string nome está recebendo caracteres
                //verificar string cpf está recebendo os 10 digitos
                //verificar int codigo está recebendo valor inteiro e se o codigo já existe na clienteList
                try{
                    String nome = textFieldNome.getText();
                    int ano = Integer.parseInt(textFieldCodigo.getText());
                    int codigo = Integer.parseInt(textFieldCodigo.getText());


                    if (textFieldNome.getText().isEmpty() || textFieldAno.getText().isEmpty() || textFieldCodigo.getText().isEmpty()){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;
                    } else if (!textFieldNome.getText().matches("[a-zA-ZÀ-ÖØ-öø-ÿ\\\\s]+")) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Nome inválido");
                        textFieldNome.setText("");
                        return;
                    } else if (textFieldAno.getText().length() < 4){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Ano inválido");
                        textFieldAno.setText("");
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


                    Empresarial novoCliente = new Empresarial(codigo,nome,ano);

                    if (acmeRobots.adicionarCliente(novoCliente)){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Cadastro concluído");
                    }


                    textFieldNome.setText("");
                    textFieldAno.setText("");
                    textFieldCodigo.setText("");

                } catch (NumberFormatException e){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir código");
                    textFieldCodigo.setText("");

                }

            }
        });

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                app.mudaPainel(1);
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textFieldNome.setText("");
                textFieldCodigo.setText("");
                textFieldAno.setText("");
                textArea2.setText("");
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea2;
    }

    public JPanel getPainel() {
        return painel3;
    }
}
