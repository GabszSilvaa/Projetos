package App;

import java.util.ArrayList;
import java.util.List;

public class Cancelamento {
    private int id;

    public Cancelamento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void cancelarItem(ItemMenu item) {
        System.out.println("-> " + item.getNome() + " cancelado do pedido!");
    }
}

class GerenciadorPedidos {
    public List<Cancelamento> listaPedidos = new ArrayList<>();

    // Método que cancela e faz o pedido desaparecer
    public void cancelarPedido(int id) {

        // O removeIf varre a lista e deleta instantaneamente o objeto que tiver o ID correspondente
        boolean removido = listaPedidos.removeIf(pedido -> pedido.getId() == id);

        if (removido) {
            System.out.println("Pedido cancelado e removido do sistema com sucesso.");
        } else {
            System.out.println("Erro: Pedido não encontrado.");
        }
    }
}
