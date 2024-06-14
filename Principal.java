//package progeto_in;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\033[1;36m\n     [ Sistema Bancário ] ");
            System.out.println("----------------------------------");
            System.out.println("| 1 - Adicionar Cliente          |");
            System.out.println("| 2 - Depositar                  |");
            System.out.println("| 3 - Levantar                   |");
            System.out.println("| 4 - Consultar Saldo            |");
            System.out.println("| 5 - Listar Todos os Clientes   |");
            System.out.println("| 6 - Transferir                 |");
            System.out.println("| 7 - Sair                       |");
            System.out.println("----------------------------------");
            System.out.print("[~] Escolha uma opção:\033[31m ");
            opcao = scanner.nextInt();
            System.out.println("\033[0m");

            double valor;
			switch (opcao) {
                case 1:
                    System.out.print("[~] Nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("[~] Número da conta: ");
                    int numeroDeConta = scanner.nextInt();
                    banco.adicionarCliente(nome, numeroDeConta);
                    System.out.println("\033[1;31m[!]\033[0m Novo cliente registado no banco");
                    break;
                case 2:
                    System.out.print("\n[~] Número da conta: ");
                    numeroDeConta = scanner.nextInt();
                    Cliente clienteDeposito = banco.encontrarCliente(numeroDeConta);
                    if (clienteDeposito != null) {
                        System.out.print("[~] Valor a depositar: ");
                        double valor1 = scanner.nextDouble();
                        clienteDeposito.depositar(valor1);
                        banco.salvarDados();
                    } else {
                        System.out.println("[~] Cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("\n[~] Número da conta: ");
                    numeroDeConta = scanner.nextInt();
                    Cliente clienteLevantamento = banco.encontrarCliente(numeroDeConta);
                    if (clienteLevantamento != null) {
                        System.out.print("[~] Valor a levantar: ");
                        double valor1 = scanner.nextDouble();
                        clienteLevantamento.levantar(valor1);
                        banco.salvarDados();
                    } else {
                        System.out.println("[~] Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("\n[~] Número da conta: ");
                    numeroDeConta = scanner.nextInt();
                    Cliente clienteConsulta = banco.encontrarCliente(numeroDeConta);
                    if (clienteConsulta != null) {
                        clienteConsulta.consultarSaldo();
                    } else {
                        System.out.println("[~] Cliente não encontrado.");
                    }
                    break;
                case 5:
                	System.out.println("");
                    banco.listarClientes();
                    break;
                case 6:
                    System.out.print("\n[~] Número da conta de origem: ");
                    int numeroContaOrigem = scanner.nextInt();
                    System.out.print("[~] Número da conta de destino: ");
                    int numeroContaDestino = scanner.nextInt();
                    System.out.print("[+] Valor a transferir: ");
                    valor = scanner.nextDouble();
                    banco.transferir(numeroContaOrigem, numeroContaDestino, valor);
                    break;
                case 7:
                    System.out.println("\n[~] Ate mais Logo\n[!] Saindo do sistema...");
                    break;
                default:
                    System.out.println("\n[~] Opção inválida.");
                    break;
            }
        } while (opcao != 7);
        scanner.close();
        /// 
    }
}
