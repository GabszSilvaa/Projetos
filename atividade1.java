import java.util.Scanner;
import java.util.Locale;

public class atividade1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("====Análise de situação Acadêmica====");

        System.out.println("Digite o nome do aluno:");
        String nome = sc.nextLine();

        System.out.println("Digite a primeira nota:");
        double x = sc.nextDouble();

        System.out.println("Digite a segunda nota:");
        double y = sc.nextDouble();

        System.out.println("Digite a terceira nota:");
        double z = sc.nextDouble();

        System.out.println("Digite a frequência do aluno:");
        double frequencia = sc.nextDouble();

        System.out.println("Digite se o aluno tem pendência (false/true):");
        boolean pendencia = sc.nextBoolean();

        double media = (x + y + z) / 3;

        if (media >= 7 && frequencia >= 75 && !pendencia) {
            System.out.printf("O aluno %s está aprovado com média %.2f e frequência %.1f%%.%n",
                    nome, media, frequencia);
        } else if (media >= 5 && frequencia >= 75 && !pendencia) {
            System.out.printf("O aluno %s está em recuperação por nota com média %.2f e frequência %.1f%%.%n",
                    nome, media, frequencia);
        } else {
            System.out.printf("O aluno %s está reprovado com média %.2f e frequência %.1f%%.%n",
                    nome, media, frequencia);
        }

        sc.close();
    }
}
