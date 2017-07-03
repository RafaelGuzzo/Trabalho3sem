package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;

public class OrcamentoDao {
	/*
	private final static String SQL_BUSCA_TODOS = "SELECT * FROM orcamento";
	private Connection con = ConexaoDB.getInstance().getConnection();;

	public List<Orcamento> getTodos() {
		List<Orcamento> lista = new ArrayList<>();
		// con = ConexaoDB.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				
				Orcamento a = new Orcamento();
				a.setId(rs.getLong(1));
				a.setDescricao(rs.getString(2));
				a.setPreco(rs.getBigDecimal(3));

				lista.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Produto> buscaNoBanco(String palavra) {
		String sql = "SELECT * FROM produto WHERE descricao like '%" + palavra + "%'";
		List<Produto> _lista = new ArrayList<>();
		// con = ConexaoDB.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Produto a = new Produto();
				a.setId(rs.getLong(1));
				a.setDescricao(rs.getString(2));
				a.setPreco(rs.getBigDecimal(3));

				_lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return _lista;

	}

	public void adicionarUm(Produto a) {
		String sql = "INSERT INTO produto (id_produto, descricao, valor) VALUES (?,?,?)";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, a.getId());
			ps.setString(2, a.getDescricao());
			ps.setBigDecimal(3, a.getPreco());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void adicionarVarios(List<Produto> lista) {
		String sql = "INSERT INTO produto (id_produto, descricao, valor) VALUES (?,?,?)";
		PreparedStatement ps;

		try {
			for (Produto p : lista) {
				if (!verifica(p.getId())) {
					ps = con.prepareStatement(sql);
					ps.setLong(1, p.getId());
					ps.setString(2, p.getDescricao());
					ps.setBigDecimal(3, p.getPreco());
					ps.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verifica(long id) {
		String sql = "SELECT id_produto FROM produto WHERE id_produto =" + id;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("ooooooooooooooo");
	}

	public void atualiza(long id, Produto a) {
		String sql = "UPDATE produto SET id_produto = ?, descricao = ?, valor= ? WHERE id_produto =" + id + ";";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);

			ps.setLong(1, a.getId());
			ps.setString(2, a.getDescricao());
			ps.setBigDecimal(3, a.getPreco());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void exclui(long id) {
		String sql = "DELETE FROM  produto WHERE id_produto = ?";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Id nao encontrado!!!");
		}
	}

	public String somaValor() {
		String sql = "SELECT SUM(valor) as soma FROM produto";
		String valor = null;
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			valor = String.valueOf(rs.getBigDecimal("SOMA"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;
	}

	public void dropTable() {
		String sql = "DELETE FROM produto";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}*/
}
