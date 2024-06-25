package aplicacao;

import dados.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ACMERobots {
    private List<Cliente> clienteList;

    public ACMERobots(){
        clienteList = new ArrayList<>();
    }


    public List<Cliente> getListCliente(){
        return clienteList;
    }

    public boolean adicionarCliente(Cliente cliente){
        if (consultaPorCodigo(cliente.getCodigo()) == null){
            clienteList.add(cliente);
            return true;
        } else
            return false;
    }

    public Cliente consultaPorCodigo(int codigo){
        for (Cliente cliente : clienteList){
            if (cliente.getCodigo() == codigo){
                return cliente;
            }
        }
        return null;
    }

}
