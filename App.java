package janela;

import aplicacao.ACMERobots;
import javax.swing.*;

public class App extends JFrame {
    private ACMERobots acmeRobots = new ACMERobots();
    private selecionaCliente painel1;
    private cadastroIndividual painel2;
    private cadastroEmpresarial painel3;


    public App(){
        super();
        setTitle("Cadastramento de Cliente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

        // Inicializações dos painéis
        painel1 = new selecionaCliente(this, acmeRobots);
        painel2 = new cadastroIndividual(this, acmeRobots);
        painel3 = new cadastroEmpresarial(this, acmeRobots);


        // Adiciona o painel inicial ao JFrame
        setContentPane(painel1.getPainel());

        setVisible(true); // Mostra a janela
    }

    public void mudaPainel(int painel){
        switch (painel){
            case 1:
                this.setContentPane(painel1.getPainel());
                this.pack();
                break;
            case 2:
                this.setContentPane(painel2.getPainel());
                this.pack();
               break;
            case 3:
                this.setContentPane(painel3.getPainel());
                this.pack();
                break;
            default:
                throw new IllegalArgumentException("Número de painel inválido: " + painel);
        }
        pack();
        setSize(800, 500);
    }

}
