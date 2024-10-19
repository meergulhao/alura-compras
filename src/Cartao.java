public class Cartao {
    // Variável limite
    private double limite;

    // Construtor que recebe o limite
    public Cartao(double limite) {
        this.limite = limite;
    }

    // Getter
    public double getLimite() {
        return this.limite;
    }

//     Metodo para descontar um valor do limite
    public void descontarLimite(double valor) {
        this.limite -= valor;
    }
}
