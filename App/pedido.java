
import java.util.ArrayList;
import java.util.List;

public class pedido {

    private List<ItemMenu> itens = new ArrayList<>();

    
    public void adicionarItem(ItemMenu item) {

        for (ItemMenu existente : itens) {

            if (existente.getId() == item.getId()) {

                existente.aumentarQuantidade();

                System.out.println("Quantidade atualizada!");

                return;
            }
        }

        ItemMenu novoItem = new ItemMenu(
            item.getId(),
            item.getNome(),
            item.getPreco()
        );

        itens.add(novoItem);
 
    }

    
    public double calcularTotal() {

        double total = 0;

        for (ItemMenu item : itens) {

            total += item.getPreco() * item.getQuantidade();
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

            System.out.printf(
                "- %-25s x%d : R$ %.2f%n",
                item.getNome(),
                item.getQuantidade(),
                item.getPreco() * item.getQuantidade()
            );
        }

        System.out.println("------------------------------");
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }

    
    public List<ItemMenu> getItens() {

        return itens;
    }

    
    public int calcularQuantidadeTotal() {

        int quantidadeTotal = 0;

        for (ItemMenu item : itens) {

            quantidadeTotal += item.getQuantidade();
        }

        return quantidadeTotal;
    }
}
