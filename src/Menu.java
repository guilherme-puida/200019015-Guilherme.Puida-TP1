import java.util.Scanner;

public class Menu {
    static Clientes clientes = new Clientes();
    static Produtos produtos = new Produtos();
    static Vendas vendas = new Vendas();

    static private final Scanner input = new Scanner(System.in);


    private static int receberInt() {
        int ans;
        while (true) {
            try {
                ans = input.nextInt();
                input.nextLine();
                return ans;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira um número válido.");
                input.nextLine();
            }
        }
    }

    private static double receberDouble() {
        double ans;
        while (true) {
            try {
                ans = input.nextDouble();
                input.nextLine();
                return ans;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira um número decimal válido.");
                input.nextLine();
            }
        }
    }


    public int escolha() {
        System.out.print("""

                \t\t\tMenu\t\t\t
                1 - Cadastro de novo cliente
                2 - Busca por cliente
                3 - Cadastro de novo produto
                4 - Busca por produto
                5 - Cadastro de venda
                6 - Mostrar produtos em estoque
                7 - Sair

                Escolha uma opção do menu (1-7):""");

        return receberInt();
    }


    public void cadastroCliente() {
        System.out.println("Insira a quantidade de clientes que deseja cadastrar:");
        int qtd = receberInt();

        if (qtd < 0) return;

        for (int i = 0; i < qtd; i++) {
            System.out.printf("Insira o nome do cliente %d%n", i + 1);
            String nome = input.nextLine();

            System.out.printf("Insira o endereço do cliente %d%n", i + 1);
            String endereco = input.nextLine();

            System.out.printf("Insira o telefone do cliente %d%n", i + 1);
            String telefone = input.nextLine();

            clientes.adicionarCliente(nome, endereco, telefone);
            System.out.printf("Cliente %d cadastrado%n", i + 1);

            if (i < qtd - 1) {
                System.out.println("Pressione 'Enter' para continuar");
                input.nextLine();
            }
        }

        System.out.println("Pressione 'Enter' para voltar ao menu.");
    }

    public void buscaCliente() {
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o nome do cliente:");
        String nome = input.nextLine();

        Clientes.Cliente cliente = clientes.checarCliente(nome);

        if (cliente == null) {
            System.out.printf("O cliente %s não está registrado.%n", nome);
            System.out.println("Pressione 'Enter' para voltar ao menu.");
            return;
        }

        System.out.println(cliente);
        System.out.println("Deseja alterar as informações do cliente? (S/N)");
        char c = input.next().charAt(0);
        input.nextLine();

        if (c != 'S' && c != 's') return;

        String ans;

        System.out.println("Deseja alterar o nome do cliente? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira o novo nome do cliente: ");
            ans = input.nextLine();
            cliente.nome = ans;
        }

        System.out.println("Deseja alterar o endereço do cliente? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira o novo endereço do cliente:");
            ans = input.nextLine();
            cliente.endereco = ans;
        }

        System.out.println("Deseja alterar o telefone do cliente? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira o novo telefone do cliente:");
            ans = input.nextLine();
            cliente.telefone = ans;
        }

        System.out.println("Cliente alterado com sucesso. Pressione 'Enter' para voltar ao menu.");
        input.nextLine();
    }

    public void cadastroNovoProduto() {

        System.out.println("Insira a quantidade de produtos que deseja cadastrar:");
        int num = receberInt();

        if (num < 0) return;

        for (int i = 0; i < num; i++) {
            System.out.printf("Insira o nome do produto %d%n", i + 1);
            String nome = input.nextLine();

            System.out.printf("Insira a descrição do produto %d%n", i + 1);
            String desc = input.nextLine();

            System.out.printf("Insira o valor de compra do produto %d%n", i + 1);
            double valor = receberDouble();

            System.out.printf("Insira a porcentagem de lucro do produto %d (somente números)%n", i + 1);
            double lucro = receberDouble();

            System.out.printf("Insira a quantidade em estoque do produto %d%n", i + 1);
            int qtd = receberInt();

            produtos.adicionarProduto(nome, desc, valor, lucro, qtd);
            System.out.printf("Produto %d cadastrado.%n", i + 1);

            if (i < qtd - 1) {
                System.out.println("Pressione 'Enter' para continuar.");
                input.nextLine();
            }
        }
        System.out.println("Pressione 'Enter' para voltar ao menu.");
        input.nextLine();
    }

    public void buscaProduto() {
        System.out.println("Insira o nome do produto:");
        String n = input.nextLine();

        Produtos.Produto produto = produtos.checarProduto(n);

        if (produto == null) {
            System.out.printf("O produto %s não está cadastrado.%n", n);
            return;
        }
        System.out.println(produto);
        System.out.println("Deseja alterar as informações do produto? (S/N)");
        char c = input.next().charAt(0);
        input.nextLine();

        if (c != 's' && c != 'S') return;

        System.out.println("Deseja alterar o nome do produto? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira o nome do produto:");
            produto.nome = input.nextLine();
        }

        System.out.println("Deseja alterar a descrição do produto? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira a descrição do produto:");
            produto.desc = input.nextLine();
        }

        System.out.println("Deseja alterar o valor de venda do produto? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira o valor de venda do produto:");
            produto.valor = receberDouble();
        }

        System.out.println("Deseja alterar a porcentagem de lucro do produto? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira a porcentagem de lucro do produto:");
            produto.lucro = receberDouble();
        }

        System.out.println("Deseja alterar a quantidade em estoque do produto? (S/N)");
        c = input.next().charAt(0);
        input.nextLine();

        if (c == 'S' || c == 's') {
            System.out.println("Insira a quantidade em estoque do produto:");
            produto.qtd = receberInt();
        }

        System.out.println("Produto alterado com sucesso. Pressione 'Enter' para voltar ao menu.");
        input.nextLine();
    }

    public void cadastroVenda() {
        int escolha;

        do {
            System.out.println("\t\t\tLista de Clientes");
            System.out.println(clientes.listarClientes());
            System.out.printf("Escolha o cliente (1-%d) ou digite 0 para sair:\n", clientes.quantidadeClientes());
            escolha = receberInt();

            if (escolha < 0) return;

            if (escolha > clientes.quantidadeClientes()) {
                System.out.printf("Escolha um cliente válido (1-%d)%n", clientes.quantidadeClientes());
            }
        } while(escolha < 1 || escolha > clientes.quantidadeClientes());

        Clientes.Cliente cliente = clientes.clientePorIndex(escolha - 1);
        System.out.printf("Cliente escolhido: %s.%n", cliente.nome);

        Vendas.Venda venda = vendas.criarVenda(cliente);

        do {
            System.out.printf("\t\t\tLista de produtos\tCliente: %s\t\n", cliente.nome);
            System.out.println(produtos.listarProdutos());
            System.out.printf("Escolha o produto (1-%d) ou digite 0 para sair.\n",
                    produtos.quantidadeProdutos());
            escolha = receberInt();

            if (escolha > 0 && escolha < produtos.quantidadeProdutos() + 1) {
                Produtos.Produto produto = produtos.produtoPorIndex(escolha - 1);

                System.out.printf("Existem %d unidades de %s em estoque.\nQuantas unidades serão vendidas?\n",
                        produto.qtd, produto.nome);
                int qtd = receberInt();

                if (!produto.fazerVenda(qtd)) {
                    System.out.printf("Não foi possível fazer a venda de %d unidades.\n", qtd);
                    System.out.println("Pressione 'Enter' para continuar.");
                    input.nextLine();
                } else {
                    venda.adicionarProduto(produto, qtd);
                }
            }

        } while (escolha > 0);

        vendas.adicionarVenda(venda);
        System.out.println("Venda realizada. Pressione 'Enter' para voltar ao menu");
        input.nextLine();
    }

    public void mostrarProdutos() {
        System.out.println("\n\t\t\t\t\t\t\t\tProdutos");
        System.out.println(produtos.listarProdutos());
        System.out.println("Pressione 'Enter' para voltar ao menu.");
        input.nextLine();
    }
}
