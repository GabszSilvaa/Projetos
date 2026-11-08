
public class ConsultarSaldo {
    private double saldo;

    public ConsultarSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
    public double calcularSaldoRestante(double totalPedido) {
        return saldo - totalPedido;
    }
   public void adicionarSaldo(double valor) {
        saldo += valor;
   }
}
