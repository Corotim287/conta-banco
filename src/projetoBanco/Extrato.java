package projetoBanco;

public class Extrato {
    private String tipoDeOperaçao;
    private Double valorOperaçao;

    public Extrato(String tipoDeOperaçao, Double valorOperaçao) {
        this.tipoDeOperaçao = tipoDeOperaçao;
        this.valorOperaçao = valorOperaçao;
    }

    public String getTipoDeOperaçao() {
        return tipoDeOperaçao;
    }

    public Double getValorOperaçao() {
        return valorOperaçao;
    }

    @Override
    public String toString() {
        return "Extrato{" +
                "tipoDeOperaçao='" + tipoDeOperaçao + '\'' +
                ", valorOperaçao=" + valorOperaçao +
                '}';
    }
}
