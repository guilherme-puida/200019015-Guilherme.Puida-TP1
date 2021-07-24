import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produtos {

    public Produtos() {
        Random random = new Random();
        for (int i = 1; i < 11; i++) {
            String nome = String.format("P%d", i);
            String desc = String.format("Desc%d", i);
            double valor = random.nextDouble() * 10 + 20;
            double lucro = valor - random.nextDouble() * 15 - 10;
            int qtd = random.nextInt(101);

            adicionarProduto(nome, desc, valor, lucro, qtd);
        }
    }

    static class Produto {
        public String nome, desc;
        public double valor, lucro;
        public int qtd;

        public Produto(String nome, String desc, double valor, double lucro, int qtd) {
            this.nome = nome;
            this.desc = desc;
            this.valor = valor;
            this.lucro = lucro;
            this.qtd = qtd;
        }

        public boolean fazerVenda(int qtd) {
            if (qtd > this.qtd || qtd < 0) {
                return false;
            }

            this.qtd -= qtd;
            return true;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s | Descrição: %s | Valor: %,.2f | Lucro: %,.2f | Estoque: %d",
                    this.nome, this.desc, this.valor, this.lucro, this.qtd);
        }
    }

    private final List<Produto> listaProdutos = new ArrayList<>();

    public void adicionarProduto(String nome, String desc, double valor, double lucro, int qtd) {
        Produto produto = new Produto(nome, desc, valor, lucro, qtd);
        listaProdutos.add(produto);
    }


    public Produto checarProduto(String nome) {
        for (Produto produto : listaProdutos) {
            if (produto.nome.equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public String listarProdutos() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (Produto produto : listaProdutos) {
            s.append(i).append(" | ").append(produto).append("\n");
            i++;
        }
        return s.toString();
    }

    public int quantidadeProdutos() {
        return listaProdutos.size();
    }

    public Produto produtoPorIndex(int index) {
        return listaProdutos.get(index);
    }

}
