package App;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.InputMismatchException;

public class SistemadeRestaurante {

    // Small value object to represent a product
    static class Produto {
        private final int id;
        private final String nome;
        private final double preco;

        Produto(int id, String nome, double preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }

        public double getPreco() {
            return preco;
        }

        @Override
        public String toString() {
            return String.format("%d - %s: $%.2f", id, nome, preco);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao Mentes Binários de Restaurante! ===");

        List<Produto> produtos = new ArrayList<>();
        int nextId = 1;

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1) Adicionar produto");
            System.out.println("2) Listar produtos");
            System.out.println("3) Calcular total");
            System.out.println("4) Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine().trim();
                        System.out.print("Preco: ");
                        double preco = sc.nextDouble();
                        sc.nextLine(); // consume newline
                        produtos.add(new Produto(nextId++, nome, preco));
                        System.out.println("Produto adicionado.");
                        break;
                    case 2:
                        if (produtos.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado.");
                        } else {
                            produtos.forEach(System.out::println);
                        }
                        break;
                    case 3:
                        double total = produtos.stream()
                            .mapToDouble(Produto::getPreco)
                            .sum();
                        System.out.printf(Locale.US, "Total: $%.2f%n", total);
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Tente novamente.");
                sc.nextLine(); // discard invalid token
            }
        }

        sc.close();
        System.out.println("Obrigado por usar o sistema. Ate logo!");
    }
}
