import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private static final String FILENAME = "clientes.txt";

    public Banco() {
        clientes = new ArrayList<>();
        carregarDados();
    }

    public void adicionarCliente(String nome, int numeroDeConta) {
        Cliente cliente = new Cliente(nome, numeroDeConta);
        clientes.add(cliente);
        salvarDados();
    }

    public Cliente encontrarCliente(int numeroDeConta) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumeroDeConta() == numeroDeConta) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Cliente clienteOrigem = encontrarCliente(numeroContaOrigem);
        Cliente clienteDestino = encontrarCliente(numeroContaDestino);

        if (clienteOrigem != null && clienteDestino != null) {
            if (clienteOrigem.getSaldo() >= valor) {
                clienteOrigem.levantar(valor);
                clienteDestino.depositar(valor);
                salvarDados();
                System.out.println(" [~] Transferência realizada com sucesso.");
            } else {
                System.out.println(" [~] Saldo insuficiente para a transferência.");
            }
        } else {
            System.out.println(" [~] Uma ou ambas as contas não foram encontradas.");
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            clientes = (List<Cliente>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(" [~] Arquivo não encontrado, criando um novo...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" [~] Erro ao carregar os dados: " + e.getMessage());
        }
    }

    public void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(clientes);
        } catch (IOException e) {
            System.out.println(" [~] Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
