package models;

import DB.ProdutosDB;
import DB.UsuariosDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ProdutosDB produtosDB = new ProdutosDB();
    static UsuariosDB usuariosDB = new UsuariosDB();

    public static void main(String[] args) throws Exception {
        System.out.println("---Pedido de Vendas ---");

        int option;

        do{
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos cadastrados: ");
            System.out.println("3 - Cadastrar usuário ADMINISTRADOR");
            System.out.println("4 - Cadastrar usuário CLIENTE");
            System.out.println("5 - Listar todos os usuários");
            System.out.println("0 - Sair");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual operação deseja realizar: ");
            option = scanner.nextInt();

            process(option);
        }    while ((option !=0));
    }

    public static void process(int option) throws Exception {
        switch (option){
            case 1: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual a descrição que você deseja dar ao produto: ");
                String descricao = scanner.nextLine();

                System.out.print("Qual ID você deseja dar ao produto: ");
                int id = scanner.nextInt();

                System.out.print("Qual o preço: ");
                double preço = scanner.nextDouble();

                System.out.print("Qual a data de validade: ");
                String dataString = scanner.next();

                Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                Produto novoProduto = new Produto(id, descricao, preço,dataValidade);

                produtosDB.addNovoProduto(novoProduto);

                break;

            }

            case 2: {
                List<Produto> listaDeProdutos = produtosDB.getProdutosList();

            for(Produto produto: listaDeProdutos) {
                System.out.println("--- ID: " + produto.getId());
                System.out.println("---Descrição: " + produto.getDescricao());
                System.out.println("---Preço: " + produto.getPreço());
                System.out.println("---Data de Validade: " + produto.getDataValidade());
                System.out.println("-----------------------------");
            }
            break;
            }
            case 3: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual nome do Usuário ADMINISTRADOR: ");
                String nome = scanner.nextLine();

                Admin novoAdmin = new Admin(nome);
                usuariosDB.addNovoUsuario(novoAdmin);
                break;
            }
            case 4: {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Qual nome do Usuário CLIENTE: ");
                String nome = scanner.nextLine();

                Cliente novoCliente = new Cliente(nome);
                usuariosDB.addNovoUsuario(novoCliente);
                break;

            }
            case 5: {
                System.out.println("----------------------------------------");
                System.out.println("-----LISTANDO USUÁRIOS CADASTRADOS------");
                System.out.println("----------------------------------------");
                for (Usuario usuario: usuariosDB.getUsuarioList()) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("NOME: " + usuario.getNome());
                    System.out.println("TIPO: " + usuario.getTipoUsuario());
                    System.out.println("----------------------------------------");
                }

                break;
            }

        }
    }


}
