package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.pojo.Cliente;

public class ClienteDao {
	private final static String SQL_BUSCA_TODOS = "SELECT * FROM cliente";
	private Connection con = ConexaoDB.getInstance().getConnection();;

	public List<Cliente> getTodos() {
		List<Cliente> lista = new ArrayList<>();
		// con = ConexaoDB.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				
				lista.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Cliente> buscaNoBanco(String palavra) {
		String sql = "SELECT * FROM cliente WHERE nome like '%" + palavra + "%'";
		List<Cliente> _lista = new ArrayList<>();
		// con = ConexaoDB.getInstance().getConnection();
		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				
				_lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return _lista;

	}

	public void adicionar(Cliente c) {
		String sql = "INSERT INTO cliente  (id, nome) VALUES (?,?)";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualiza(long id, Cliente c) {
		String sql = "UPDATE cliente SET id = ?, nome = ? WHERE id =" + id + ";";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);

			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			System.out.println(ps.toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void exclui(long id) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Id nao encontrado!!!");
		}
	}

}
