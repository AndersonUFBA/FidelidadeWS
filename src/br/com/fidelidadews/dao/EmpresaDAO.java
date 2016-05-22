package br.com.fidelidadews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fidelidadews.conexao.ConectaMySql;
import br.com.fidelidadews.model.Empresa;

public class EmpresaDAO {
	
	public boolean inserirEmpresa(Empresa empresa) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "INSERT INTO empresa VALUES ( ?, ?, ?, ?, ?)";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setString(1, empresa.getCnpj());
			ppStm.setString(2, empresa.getSenha());
			ppStm.setString(3, empresa.getDescricao());
			ppStm.setString(4, empresa.getLatitude());
			ppStm.setString(5, empresa.getLongitude());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean atualizarEmpresa(Empresa empresa) {

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "UPDATE empresa SET senha= ?, descricao = ?, latitude = ?, longitude WHERE cnpj = ? ";

			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setString(5, empresa.getCnpj());
			ppStm.setString(1, empresa.getSenha());
			ppStm.setString(2, empresa.getDescricao());
			ppStm.setString(3, empresa.getLatitude());
			ppStm.setString(4, empresa.getLongitude());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirEmpresa(Empresa empresa) {
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "DELETE FROM empresa WHERE cnpj = ?";

			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setString(1, empresa.getCnpj());

			ppStm.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluirEmpresa(String cnpj) {
		return excluirEmpresa(new Empresa(cnpj, "", "", "", ""));
	}

	public ArrayList<Empresa> buscarTodosEmpresas() {

		ArrayList<Empresa> lista = new ArrayList<Empresa>();

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM empresa";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ResultSet resultSet = ppStm.executeQuery();

			while (resultSet.next()) {
				Empresa usr = new Empresa();

				usr.setCnpj(resultSet.getString(1));
				usr.setSenha(resultSet.getString(2));
				usr.setDescricao(resultSet.getString(3));
				usr.setLatitude(resultSet.getString(4));
				usr.setLongitude(resultSet.getString(5));

				lista.add(usr);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Empresa buscarEmpresaPorId(int cnpj) {
		Empresa usr = null;

		try {
			Connection conn = ConectaMySql.obtemConexao();
			String query = "SELECT * FROM empresa WHERE cnpj = ?";
			PreparedStatement ppStm = conn.prepareStatement(query);

			ppStm.setInt(1, cnpj);

			ResultSet resultSet = ppStm.executeQuery();

			if (resultSet.next()) {
				usr = new Empresa();

				usr.setCnpj(resultSet.getString(1));
				usr.setSenha(resultSet.getString(2));
				usr.setDescricao(resultSet.getString(3));
				usr.setLatitude(resultSet.getString(4));
				usr.setLongitude(resultSet.getString(5));
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
