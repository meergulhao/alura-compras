import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variáveis
        Scanner scanner = new Scanner(System.in);
        String menuOpcoes = "Digite 0 para sair ou 1 para continuar comprando";
        int opcao = 1;

        // Início
        System.out.println("Vamos fazer as compras!");

        // Crio o cartão atribuindo um limite
        System.out.println("Digite o limite do cartão:");
        Cartao cartao = new Cartao(scanner.nextDouble());

        // Crio a lista de compras
        List<Compra> listaCompras = new ArrayList<>();

        // Loop para continuar enquanto não escolher sair
        while (opcao != 0) {
            if (opcao != 1) { // Esse if impede opções inválidas
                System.out.println("Opção inválida! " + menuOpcoes);
                opcao = scanner.nextInt();
            } else {
                System.out.println("Digite a descrição da compra:");
                listaCompras.add(new Compra()); // Crio o objeto Compra
                listaCompras.getLast().setDescricao(scanner.next()); // Adiciono a descrição, apontando para o último
                System.out.println("Digite o valor da compra:");
                listaCompras.getLast().setValor(scanner.nextDouble()); // Adiciono o valor, apontando para o último
                if (cartao.getLimite() < listaCompras.getLast().getValor()) { // Se o limite não for suficiente
                    System.out.println("Saldo insuficiente!\nSaldo atual: R$" + cartao.getLimite());
                    listaCompras.removeLast(); // removo o adicionado
                    System.out.println(menuOpcoes);
                    opcao = scanner.nextInt(); // Chamo o menu de opções, pois outra compra pode ser adicionada
                } else { // Limite suficiente, Compra adicionada
                    cartao.descontarLimite(listaCompras.getLast().getValor());
                    System.out.println("Compra realizada!");
                    System.out.println(menuOpcoes);
                    opcao = scanner.nextInt(); // Chamo o menu de opções
                }
            }
        }

        // Listo as compras
        System.out.println("""
                ******************************
                COMPRAS REALIZADAS:
                """);
        Collections.sort(listaCompras); // Organizo a lista por valor
        for (Compra item : listaCompras) { // Exibo os itens
            System.out.println(item);
        }
        System.out.println("\n******************************");
        System.out.println("Limite do cartão: R$" + cartao.getLimite());
    }
}