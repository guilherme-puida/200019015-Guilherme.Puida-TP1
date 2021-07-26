public class Main {
    static Menu menu = new Menu();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            int op = menu.escolha();
            switch (op) {
                case 1 -> menu.cadastroCliente();
                case 2 -> menu.buscaCliente();
                case 3 -> menu.cadastroNovoProduto();
                case 4 -> menu.buscaProduto();
                case 5 -> menu.cadastroVenda();
                case 6 -> menu.mostrarProdutos();
                case 7 -> menu.mostrarVendas();
                case 8 -> running = false;
                default -> menu.opcaoInvalida();
            }
        }
    }
}
