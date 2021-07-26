import java.util.ArrayList;
import java.util.List;

public class Clientes {


    /**
     * Construtor. Gera 10 clientes iniciais e os insere na lista de clientes.
     */
    public Clientes() {
        for (int i = 1; i < 11; i++) {
            String nome = String.format("Cl%d", i);
            String endereco = String.format("End%d", i);
            String telefone = String.format("Tel%d", i);

            adicionarCliente(nome, endereco, telefone);
        }
    }

    /**
     *  Classe representando um cliente. Armazena nome, endereço e telefone.
     */
    static class Cliente {
        public String nome, endereco, telefone;

        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        /**
         * Representação em string de um cliente.
         */
        @Override
        public String toString() {
            return String.format("Nome: %s | Endereço: %s | Telefone: %s", this.nome, this.endereco, this.telefone);
        }
    }

    private final List<Cliente> listaClientes = new ArrayList<>();

    /**
     * Checa se um já existe um cliente com determinado nome. Se ele já existir, retorna o cliente. Caso contrário,
     * retona null.
     */
    public Cliente checarCliente(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente.nome.equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Adiciona um novo cliente na lista de clientes.
     */
    public void adicionarCliente(String nome, String endereco, String telefone) {
        listaClientes.add(new Cliente(nome, endereco, telefone));
    }

    /**
     * Retorna a representação em string da lista de clientes.
     */
    public String listarClientes() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (Cliente cliente : listaClientes) {
            s.append(i).append(" | ").append(cliente).append("\n");
            i++;
        }
        return s.toString();
    }

    /**
     * Retorna a quantidade de clientes cadastrados.
     */
    public int quantidadeClientes() {
        return listaClientes.size();
    }

    /**
     * Retorna o cliente em um index determinado na lista de clientes cadastrados.
     */
    public Cliente clientePorIndex(int index) {
        return listaClientes.get(index);
    }
}
