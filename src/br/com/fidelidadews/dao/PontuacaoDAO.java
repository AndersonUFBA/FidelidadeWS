package br.com.fidelidadews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fidelidadews.conexao.ConectaMySql;

public class PontuacaoDAO {

	public boolean inserirPontuacao(Pontuacao pontuacao) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "INSERT INTO pontuacao VALUES (null, ?, ?, ?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setDouble(1, pontuacao.getPontos());
			ppStm.setString(2, pontuacao.getUsuario_cpf());
			ppStm.setString(3, pontuacao.getEmpresa_cnpj());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean atualizarPontuacao(Pontuacao pontuacao) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "UPDATE pontuacao SET senha= ?, usuario_cpf = ? WHERE id = ? ";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setInt(1, pontuacao.getId());
			ppStm.setDouble(2, pontuacao.getPontos());
			ppStm.setString(3, pontuacao.getUsuario_cpf());
			ppStm.setString(4, pontuacao.getEmpresa_cnpj());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirPontuacao(Pontuacao pontuacao) {
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "DELETE FROM pontuacao WHERE  usuario_cpf = ?";

			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setString(1, pontuacao.getUsuario_cpf());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirPontuacao(String cpf) {
		return excluirPontuacao(new Pontuacao(0, 0, cpf, ""));
	}

	public ArrayList<Pontuacao> buscarTodosPontuacaos() {

		ArrayList<Pontuacao> lista = new ArrayList<Pontuacao>();

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM pontuacao";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ResultSet resultSet = ppStm.executeQuery();

			while (resultSet.next()) {
				Pontuacao usr = new Pontuacao();

				usr.setId(resultSet.getInt(1));
				usr.setPontos(resultSet.getDouble(2));
				usr.setUsuario_cpf(resultSet.getString(3));
				usr.setEmpresa_cnpj(resultSet.getString(4));

				lista.add(usr);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Pontuacao buscarPontuacaoPorId(String cpf) {
		Pontuacao usr = null;

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM pontuacao WHERE id = ?";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setString(1, cpf);

			ResultSet resultSet = ppStm.executeQuery();

			if (resultSet.next()) {
				usr = new Pontuacao();

				usr.setId(resultSet.getInt(1));
				usr.setPontos(resultSet.getDouble(2));
				usr.setUsuario_cpf(resultSet.getString(3));
				usr.setEmpresa_cnpj(resultSet.getString(4));

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
