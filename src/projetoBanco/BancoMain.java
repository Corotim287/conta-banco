package projetoBanco;
import java.util.*;
public class BancoMain {
    private static Scanner input = new Scanner(System.in);
    private static Map<Pessoa,ContaBanco> contas = new HashMap<>();
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("");
        System.out.println("Bem vindo ao banco JavansCoders");
        System.out.println("===============================");
        System.out.println("|         1-Abrir conta       |");
        System.out.println("|          2-Operaçoes        |");
        System.out.println("|            3-Sair           |");
        System.out.println("===============================");

       int escolha = input.nextInt();

       switch (escolha){
           case 1:
               criarConta();
               break;
           case 2:
               operaçoes();
               break;
           case 3:
               break;
           default:
               System.out.println("Opção invalida");
               menu();

       }
    }
    public static Pessoa pessoa(){
        System.out.println("Digite seu nome");
        String nome= input.next();
        System.out.println("Digite seu cpf");
        Long cpf= input.nextLong();

        Pessoa pessoa = new Pessoa(nome,cpf);
        return pessoa;
    }


    public static void operaçoes() {

        System.out.println("             Operaçoes             ");
        System.out.println("===================================");
        System.out.println("|        1-Consultar saldo        |");
        System.out.println("|          2-Checar dados         |");
        System.out.println("|           3-Deposito            |");
        System.out.println("|             4-Saque             |");
        System.out.println("|        5-Transferencia          |");
        System.out.println("|            6-Extrato            |");
        System.out.println("|          7-Fechar conta         |");
        System.out.println("|             8-Voltar            |");
        System.out.println("==================================");

        int escolha = input.nextInt();

        switch (escolha) {
            case 1:
                consultaDeSaldo();
            case 2:
                dados();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacarDinheiro();
                break;
            case 5:
                tranferirDinheiro();
                break;
            case 6:
                extrato();
                break;
            case 7:
                fecharConta();
                break;
            case 8:
                menu();
                break;
            default:
                System.out.println("Opção invalida");
                operaçoes();

        }
    }

        public static void criarConta() {

            Integer tipoDeConta;
            Pessoa pessoa=pessoa();

                System.out.println("Escolha o tipo de conta");
                System.out.println("1-Poupança");
                System.out.println("2-Corrente");
                tipoDeConta = input.nextInt();

                ContaBanco conta = new ContaBanco(tipoDeConta, pessoa);

                contas.put(pessoa, conta);
                contas.get(pessoa).abrirConta(pessoa);
            menu();
        }
        public static void consultaDeSaldo(){

            Pessoa consulta = pessoa();

            if(contas.containsKey(consulta)){
                System.out.println("O seu saldo atual é de :R$"+contas.get(consulta).checarSaldo());
            }else{
                System.out.println("Dados incorretos,tente novamente");
            }
            menu();
        }
        public static void dados(){
            Pessoa consulta = pessoa();
            if(contas.containsKey(consulta)){
                if(contas.get(consulta).getStatus()) {
                    System.out.println("Nome:"+consulta.getNome());
                    System.out.println("Tipo de conta:"+ contas.get(consulta).getTipoDeConta());
                    System.out.println("Agencia:"+contas.get(consulta).getAgencia());
                    System.out.println("Conta:"+contas.get(consulta).getConta());
                    System.out.println("CPF:"+consulta.getCpf());
                    System.out.println("Saldo:"+contas.get(consulta).getSaldo());
                    System.out.println("Status:Conta ativa");
                }else {
                    System.out.println("Conta invativa");
                }
            }else{
                System.out.println("Conta nao encontrada ,voltando ao menu");
            }
            menu();
        }
        public static void depositar(){
            Pessoa conta = pessoa();
            System.out.println("Digite o valor do deposito");
            Double deposito = input.nextDouble();

            contas.get(conta).depositarDinheiro(deposito);
            menu();
        }
        public static void sacarDinheiro(){
            Pessoa conta = pessoa();
            System.out.println("Digite o valor do saque");
            Double saque= input.nextDouble();

            contas.get(conta).sacarDinheiro(saque);
            menu();
        }
        public static void tranferirDinheiro(){
        System.out.println("Conta que deseja tranferir");
        Pessoa pessoa1=pessoa();
        System.out.println("Para qual conta ?");
        Pessoa pessoa2=pessoa();

        System.out.println("Quanto quer transferir ?");
        Double valor = input.nextDouble();

        if(contas.get(pessoa1).getSaldo()-valor>=0) {
            contas.get(pessoa1).retirar(valor);
            contas.get(pessoa2).adicionar(valor);
            System.out.println("Dinheiro tranferido para :"+pessoa2.getNome());
            }else {
            System.out.println("Impossivel fazer a transferencia,saldo insuficiente");
        }
            menu();
        }

        public static void extrato(){
            Pessoa conta = pessoa();
             if(!contas.get(conta).getExtratos().isEmpty()) {
                 for (Extrato extrato : contas.get(conta).getExtratos()) {
                     System.out.println("Tipo de operação :" + extrato.getTipoDeOperaçao() + "Valor:" + extrato.getValorOperaçao());
                 }
             }else {
                 System.out.println("Voce nao possui extratos");
             }
            menu();
        }
        public static void fecharConta(){
           Pessoa conta = pessoa();

           if(contas.containsKey(conta)) {
               contas.get(conta).fecharConta();
           }else {
               System.out.println("Conta não existe !");
           }
           menu();
         }


}













