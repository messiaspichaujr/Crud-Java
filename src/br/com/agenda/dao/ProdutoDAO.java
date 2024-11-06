package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Produto;

public class ProdutoDAO {

    public void save(Produto produto) {
        String sql = "INSERT INTO produtos(descricao, preco, data_cadastro) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql)) {

            pstm.setString(1, produto.getDescricao());
            pstm.setDouble(2, produto.getPreco());
            pstm.setDate(3, new Date(produto.getDataCadastro().getTime()));
            pstm.execute();
            System.out.println("Produto salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Produto produto) {
        String sql = "UPDATE produtos SET descricao = ?, preco = ?, data_cadastro = ? WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql)) {

            pstm.setString(1, produto.getDescricao());
            pstm.setDouble(2, produto.getPreco());
            pstm.setDate(3, new Date(produto.getDataCadastro().getTime()));
            pstm.setInt(4, produto.getCodigo());
            pstm.execute();
            System.out.println("Produto atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(int codigo) {
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql)) {

            pstm.setInt(1, codigo);
            pstm.execute();
            System.out.println("Produto deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rset.getInt("codigo"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setPreco(rset.getDouble("preco"));
                produto.setDataCadastro(rset.getDate("data_cadastro"));
                produtos.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
