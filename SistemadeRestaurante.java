package App;
import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Locale;

public class SistemadeRestaurante {
    private static final List<MenuItem> CARDAPIO = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        System.out.println("===Bem-vindo ao Mentes binários de Restaurante!===");
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar item ao cardápio");
            System.out.println("2. Exibir cardápio");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do item: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linhahttps://forms.cloud.microsoft/r/vgSUj9Pn9s
                    CARDAPIO.add(new MenuItem(nome, preco));
                    System.out.println("Item adicionado ao cardápio!");
                    break;
                case 2:
                    System.out.println("===Cardápio===");
                    for (MenuItem item : CARDAPIO) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
