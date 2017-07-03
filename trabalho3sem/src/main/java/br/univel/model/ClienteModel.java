package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.pojo.Cliente;
import br.univel.pojo.Produto;

public class ClienteModel extends AbstractTableModel {
	private List<Cliente> lista;

	public ClienteModel() {
		this((List<Cliente>) null);
	}

	public ClienteModel(List<Cliente> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;

		}
		super.fireTableDataChanged();
	}

	public void preencherResultado(List<Cliente> resultado) {
		this.lista = resultado;
		super.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ID";
		case 1:
			return "Nome";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente c = this.lista.get(row);

		switch (column) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		}
		throw new RuntimeException("Erro na " + column + " coluna! iaaaaaaaaaaaaa");
	}

	public void adicionar(Cliente c) {
		this.lista.add(c);
		super.fireTableDataChanged();
	}

	public void remove(Cliente selecionado) {
		this.lista.remove(selecionado);
		super.fireTableDataChanged();
	}

	public Cliente getLinhaCliente(int idx) {
		if (idx >= this.lista.size()) {
			return null;
		}
		return this.lista.get(idx);
	}

	public List<Cliente> getListaCliente() {
		return this.lista;
	}
}
