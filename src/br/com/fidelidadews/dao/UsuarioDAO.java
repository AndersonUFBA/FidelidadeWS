package br.com.fidelidadews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fidelidadews.conexao.ConectaMySql;
import br.com.fidelidadews.model.Usuario;

public class UsuarioDAO {

	public boolean inserirUsuario(Usuario usuario) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "INSERT INTO usuario VALUES ( ?, ?, ?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setString(1, usuario.getCpf());
			ppStm.setString(2, usuario.getSenha());
			ppStm.setString(3, usuario.getNome());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean atualizarUsuario(Usuario usuario) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "UPDATE usuario SET senha= ?, nome = ? WHERE cpf = ? ";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setString(3, usuario.getCpf());
			ppStm.setString(2, usuario.getSenha());
			ppStm.setString(1, usuario.getNome());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirUsuario(Usuario usuario) {
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "DELETE FROM usuario WHERE cpf = ?";

			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setString(1, usuario.getCpf());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirUsuario(String cpf) {
		return excluirUsuario(new Usuario(cpf, "", ""));
	}

	public ArrayList<Usuario> buscarTodosUsuarios() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM usuario";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ResultSet resultSet = ppStm.executeQuery();

			while (resultSet.next()) {
				Usuario usr = new Usuario();

				usr.setCpf(resultSet.getString(1));
				usr.setSenha(resultSet.getString(2));
				usr.setNome(resultSet.getString(3));

				lista.add(usr);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Usuario buscarUsuarioPorId(int cpf) {
		Usuario usr = null;

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM usuario WHERE cpf = ?";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setInt(1, cpf);

			ResultSet resultSet = ppStm.executeQuery();

			if (resultSet.next()) {
				usr = new Usuario();

				usr.setCpf(resultSet.getString(1));
				usr.setSenha(resultSet.getString(2));
				usr.setNome(resultSet.getString(3));
			} else {
				return usr;
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usr;
	}

}