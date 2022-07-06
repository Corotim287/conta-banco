package projetoBanco;

public interface Conta {

    public void abrirConta(Pessoa pessoa);
    public double checarSaldo();
    public void depositarDinheiro(Double qntd);
    public void sacarDinheiro(Double qntd);
    public void fecharConta();



}
