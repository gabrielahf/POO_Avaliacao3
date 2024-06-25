package dados;

public class Individual extends Cliente{
    private String cpf;

    public Individual(int codigo, String nome, String cpf) {
        super(codigo, nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public double calculaDesconto() {
        return 0;
    }
}