package projetoBanco;
import java.util.*;
public class ContaBanco implements Conta{

    private Integer tipoDeConta;
    private Integer agencia;
    private Integer conta;
    private Double saldo;
    private Pessoa pessoa;

    private boolean status;
    private List<Extrato> extratos = new LinkedList<>();

    public ContaBanco(Integer tipoDeConta, Pessoa pessoa) {
        this.tipoDeConta = tipoDeConta;
        this.pessoa = pessoa;
        this.status = false;
    }

    public List<Extrato> getExtratos() {
        return extratos;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean getStatus() {
        return status;
    }

    public Integer getTipoDeConta() {
        if(this.tipoDeConta==1){
            System.out.println("Conta poupança");
            return 1;
        }else if(this.tipoDeConta==2){
            System.out.println("Conta correne");
            return 2;
        }else {
            return null;
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void retirar(Double valor){
        this.saldo-=valor;
        extratos.add(new Extrato("Transferencia",-valor));
    }
    public void adicionar(Double valor){
        this.saldo+=valor;
        extratos.add(new Extrato("Tranferencia",+valor));
    }

    @Override
    public void abrirConta(Pessoa pessoa){
        Random numeroAleatorio = new Random();
        this.setAgencia(numeroAleatorio.nextInt(100000));
        this.setConta(numeroAleatorio.nextInt(10000));
        this.setSaldo(0d);
        this.setStatus(true);
        System.out.println("Conta aberta");
        System.out.println("Bem vindo "+pessoa.getNome()+"!");
    }
    @Override
    public void depositarDinheiro(Double qntd){
        if(this.status) {
            this.saldo+=qntd;
            System.out.println("Voce depositou:R$"+ qntd);
            System.out.println("Saldo atual:R$"+ checarSaldo());
            this.extratos.add(new Extrato("Deposito",qntd));

        }else {
            System.out.println("Impossivel depositar ,sua conta esta fechada");
        }
    }
    @Override
    public double checarSaldo(){
        return this.saldo;
    }

    @Override
    public void sacarDinheiro(Double qntd){
        if(this.getStatus()) {
            if (this.saldo <= 0) {
                System.out.println("Voce nao possui saldo para sacar");
            } else {
                if (this.saldo - qntd >= 0) {
                    this.saldo -= qntd;
                    System.out.println("Voce sacou" + qntd);
                    extratos.add(new Extrato("Saque",qntd));
                } else {
                    System.out.println("Voce nao possui dinheiro suficiente para saque");
                }
            }
        }else{
            System.out.println("Sua conta esta fechada ,impossivel fazer operações");
        }
    }

    @Override
    public void fecharConta(){
        if(saldo>0){
            System.out.println("Voce nao pode fechar a conta ,pois há dinheiro");
        }else {
            this.setStatus(false);
            System.out.println("Sua conta foi fechada "+pessoa.getNome()+"!");
        }

    }


}
