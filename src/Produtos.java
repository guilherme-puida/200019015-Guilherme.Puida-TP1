import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produtos {

    /**
     * Construtor. Gera 10 produtos inciais.
     */
    public Produtos() {
        Random random = new Random();
        for (int i = 1; i < 11; i++) {
            String nome = String.format("P%d", i);
            String desc = String.format("Desc%d", i);
            double valor = random.nextDouble() * 10 + 20;
            double lucro = random.nextDouble() * 10 + 10;
            int qtd = random.nextInt(101);

            adicionarProduto(nome, desc, valor, lucro, qtd);
        }
    }

    /**
     * Classe que representando um produto. Armazena nome, descrição, valor, margem de lucro e quantidade.
     */
    static class Produto {
        public String nome, desc;
        public double valor, lucro;
        public int qtd;

        /**
         * Construtor.
         */
        public Produto(String nome, String desc, double valor, double lucro, int qtd) {
            this.nome = nome;
            this.desc = desc;
            this.valor = valor;
            this.lucro = lucro;
            this.qtd = qtd;
        }

        /**
         * Retira a quantidade de produtos vendidos caso haja estoque.
         */
        public boolean fazerVenda(int qtd) {
            if (qtd > this.qtd || qtd < 0) {
                return false;
            }

            this.qtd -= qtd;
            return true;
        }

        /**
         * Representação em string de um produto.
         */
        @Override
        public String toString() {
            return String.format("Nome: %s | Descrição: %s | Valor: %,.2f | Lucro: %,.2f%% | Estoque: %d",
                    this.nome, this.desc, this.valor, this.lucro, this.qtd);
        }
    }

    private final List<Produto> listaProdutos = new ArrayList<>();

    /**
     * Adiciona um novo produto na lista de produtos.
     */
    public void adicionarProduto(String nome, String desc, double valor, double lucro, int qtd) {
        Produto produto = new Produto(nome, desc, valor, lucro, qtd);
        listaProdutos.add(produto);
    }


    /**
     * Checa se existe um produto com determinado nome. Caso ele exista, retorna o produto. Caso contrário, retorna null.
     */
    public Produto checarProduto(String nome) {
        for (Produto produto : listaProdutos) {
            if (produto.nome.equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    /**
     * Representação em string da lista de produtos.
     */
    public String listarProdutos() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (Produto produto : listaProdutos) {
            s.append(i).append(" | ").append(produto).append("\n");
            i++;
        }
        return s.toString();
    }

    /**
     * Retorna a quantidade de produtos cadastrados.
     */
    public int quantidadeProdutos() {
        return listaProdutos.size();
    }


    /**
     * Retorna o produto em um index determinado na lista de produtos cadastrados.
     */
    public Produto produtoPorIndex(int index) {
        return listaProdutos.get(index);
    }

}
