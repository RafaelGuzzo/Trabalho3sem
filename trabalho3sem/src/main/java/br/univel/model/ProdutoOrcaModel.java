package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.pojo.Produto;

public class ProdutoOrcaModel extends AbstractTableModel{
	private List<Produto> lista;

	public ProdutoOrcaModel() {
		this((List<Produto>) null);
	}

	public ProdutoOrcaModel(List<Produto> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;

		}

	}

	public void preencherResultado(List<Produto> resultado) {
		this.lista = resultado;

		// O comando abaixo solicita atualização da visão.
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 4;
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
			return "Descrição";
		case 2:
			return "Valor";
		case 3:
			return "Quantidade";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Produto a = this.lista.get(row);

		switch (column) {
		case 0:
			return a.getId();
		case 1:
			return a.getDescricao();
		case 2:
			return a.getPreco();
		case 3:
			return a.getQuantidade();
		}
		throw new RuntimeException("Erro na " + column + " coluna! iaaaaaaaaaaaaa");
	}

	public void adicionar(Produto c) {
		this.lista.add(c);
		super.fireTableDataChanged();
	}

	public void remove(Produto selecionado) {
		this.lista.remove(selecionado);
		super.fireTableDataChanged();
	}

	public Produto getLinhaProduto(int idx) {
		if (idx >= this.lista.size()) {
			return null;
		}
		return this.lista.get(idx);
	}

	public List<Produto> getListaProduto() {
		return this.lista;
	}
}
