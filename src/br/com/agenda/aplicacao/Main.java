package br.com.agenda.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.ProdutoDAO;
import br.com.agenda.model.Produto;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        ProdutoDAO produtoDao = new ProdutoDAO();

        // Opção para criar um novo produto
        
        System.out.println("Deseja adicionar um novo produto? (s/n)");
        String resposta = scanner.nextLine();
        
        if (resposta.equalsIgnoreCase("s")) {
            Produto produto = new Produto();
            System.out.print("Digite a descrição do produto: ");
            produto.setDescricao(scanner.nextLine());

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(scanner.nextDouble());
            produto.setDataCadastro(new Date());

            // Salvar produto - CREATE
            produtoDao.save(produto);
            System.out.println("Produto adicionado com sucesso!");
        }

        // Opção para atualizar um produto existente
        System.out.println("Deseja atualizar um produto existente? (s/n)");
        resposta = scanner.next();

        if (resposta.equalsIgnoreCase("s")) {
            Produto p1 = new Produto();
            System.out.print("Digite o código do produto a atualizar: ");
            p1.setCodigo(scanner.nextInt());
            scanner.nextLine(); 

            System.out.print("Digite a nova descrição do produto: ");
            p1.setDescricao(scanner.nextLine());

            System.out.print("Digite o novo preço do produto: ");
            p1.setPreco(scanner.nextDouble());
            p1.setDataCadastro(new Date());

            // Atualizar produto - UPDATE
            produtoDao.update(p1);
            System.out.println("Produto atualizado com sucesso!");
        }

        // Opção para deletar um produto
        System.out.println("Deseja deletar um produto? (s/n)");
        resposta = scanner.next();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o código do produto a deletar: ");
            int codigo = scanner.nextInt();
            // Deletar produto pelo código - DELETE
            produtoDao.deleteByID(codigo);
            System.out.println("Produto deletado com sucesso!");
        }

        // Visualizar todos os produtos - READ
        System.out.println("Produtos cadastrados:");
        for (Produto p : produtoDao.getProdutos()) {
            System.out.println("Produto: " + p.getDescricao() + " | Preço: " + p.getPreco());
        }

        // Fechar o scanner
        scanner.close();
    }
}
