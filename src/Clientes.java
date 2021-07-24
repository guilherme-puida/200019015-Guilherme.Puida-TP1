import java.util.ArrayList;
import java.util.List;

public class Clientes {

    public Clientes() {
        for (int i = 1; i < 11; i++) {
            String nome = String.format("Cl%d", i);
            String endereco = String.format("End%d", i);
            String telefone = String.format("Tel%d", i);

            adicionarCliente(nome, endereco, telefone);
        }
    }

    
    static class Cliente {
        public String nome, endereco, telefone;

        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s | Endereço: %s | Telefone: %s", this.nome, this.endereco, this.telefone);
        }
    }

    private final List<Cliente> listaClientes = new ArrayList<>();

    public Cliente checarCliente(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente.nome.equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void adicionarCliente(String nome, String endereco, String telefone) {
        listaClientes.add(new Cliente(nome, endereco, telefone));
    }

    public String listarClientes() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (Cliente cliente : listaClientes) {
            s.append(i).append(" | ").append(cliente).append("\n");
            i++;
        }
        return s.toString();
    }

    public int quantidadeClientes() {
        return listaClientes.size();
    }

    public Cliente clientePorIndex(int index) {
        return listaClientes.get(index);
    }
}
