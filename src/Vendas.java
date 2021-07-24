import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class Vendas {
     class Venda {
         Clientes.Cliente cliente;
         Map<Produtos.Produto, Integer> produtosVendidos;

         public Venda(Clientes.Cliente cliente) {
             this.cliente = cliente;
             this.produtosVendidos = new HashMap<Produtos.Produto, Integer>();
         }

         public void adicionarProduto(Produtos.Produto produto, int qtd) {
             if (produtosVendidos.containsKey(produto)) {
                 produtosVendidos.put(produto, produtosVendidos.get(produto) + qtd);
             } else {
                 produtosVendidos.put(produto, qtd);
             }
         }

         @Override
         public String toString() {
             StringBuilder s = new StringBuilder();
             s.append(String.format("%s ", cliente.nome));
             for (Produtos.Produto produto: produtosVendidos.keySet()) {
                 s.append(String.format("| %s: %d unidades", produto.nome, produtosVendidos.get(produto)));
             }
             return s.toString();
         }

     }

     private final List<Venda> listaVendas = new ArrayList<Venda>();

     public Venda criarVenda(Clientes.Cliente cliente) {
         return new Venda(cliente);
     }

     public void adicionarVenda(Venda venda) {
         listaVendas.add(venda);
     }

     public String listarVendas() {
         StringBuilder s = new StringBuilder();
         int i = 1;
         for (Venda venda: listaVendas) {
             s.append(String.format("%d | %s\n", i, venda));
             i++;
         }
         return s.toString();
     }

}
