import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Funcionalidade não obrigatória, mas recomendada pela professora.
 * https://aprender3.unb.br/mod/forum/discuss.php?d=138461#p373245
 */


 class Vendas {
     /**
      * Registra uma venda individual. Pode conter múltiplos produtos vendidos, mas somente um cliente.
      */
     static class Venda {
         Clientes.Cliente cliente;
         Map<Produtos.Produto, Integer> produtosVendidos;

         /**
          * Construtor.
          */
         public Venda(Clientes.Cliente cliente) {
             this.cliente = cliente;
             this.produtosVendidos = new HashMap<>();
         }

         /**
          * Adiciona um produto na venda atual.
          */
         public void adicionarProduto(Produtos.Produto produto, int qtd) {
             if (produtosVendidos.containsKey(produto)) {
                 produtosVendidos.put(produto, produtosVendidos.get(produto) + qtd);
             } else {
                 produtosVendidos.put(produto, qtd);
             }
         }

         /**
          * Representação em string de uma venda.
          */
         @Override
         public String toString() {
             StringBuilder s = new StringBuilder();
             s.append(String.format("Cliente: %s ", cliente.nome));
             for (Produtos.Produto produto: produtosVendidos.keySet()) {
                 s.append(String.format("| %s: %d unidades", produto.nome, produtosVendidos.get(produto)));
             }
             return s.toString();
         }

     }

     private final List<Venda> listaVendas = new ArrayList<>();

     /**
      *  Cria uma nova venda e a retorna.
      */
     public Venda criarVenda(Clientes.Cliente cliente) {
         return new Venda(cliente);
     }

     /**
      * Adiciona uma venda na lista de vendas realizadas
      */
     public void adicionarVenda(Venda venda) {
         listaVendas.add(venda);
     }

     /**
      * Retorna uma string com todas as vendas realizadas.
      */
     public String listarVendas() {
         if (listaVendas.size() == 0) {
             return null;
         }

         StringBuilder s = new StringBuilder();
         int i = 1;
         for (Venda venda: listaVendas) {
             s.append(String.format("%d | %s\n", i, venda));
             i++;
         }
         return s.toString();
     }

}
