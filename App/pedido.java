package App;

import java.util.ArrayList;
import java.util.List;

public class pedido {
    private List<ItemMenu> itens;

    public pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
        System.out.println("-> " + item.getNome() + " adicionado ao pedido!");
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemMenu item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void exibirResumo() {
        System.out.println("\n--- RESUMO DO PEDIDO ---");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item adicionado.");
            return;
        }

        for (ItemMenu item : itens) {
            System.out.printf("- %-20s : R$ %.2f\n", item.getNome(), item.getPreco());
        }
        System.out.println("------------------------");
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", calcularTotal());
        System.out.println("------------------------");
    }
}