public class Compra implements Comparable<Compra>{ // Implementa Comparable para poder usar a ordenação
    // Variáveis
    private String descricao;
    private Double valor;

    // Getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Implementando o compareTo para ordenar por valor
    @Override
    public int compareTo(Compra outraCompra) {
        return this.getValor().compareTo(outraCompra.getValor());
    }

    // Sobrescrevendo o toString pra retorno amigável
    @Override
    public String toString() {
        return getDescricao() + " - R$" + getValor();
    }
}
