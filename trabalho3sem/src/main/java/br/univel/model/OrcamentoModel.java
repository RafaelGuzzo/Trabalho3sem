package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;

public class OrcamentoModel extends AbstractTableModel {
	private List<Orcamento> lista;

	public OrcamentoModel() {
		this((List<Orcamento>) null);
	}

	public OrcamentoModel(List<Orcamento> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;

		}

		super.fireTableDataChanged();

	}

	public void preencherResultado(List<Orcamento> resultado) {
		this.lista = resultado;
		super.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 5;
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
			return "Cliente";
		case 2:
			return "Data";
		case 3:
			return "Validade";
		case 4:
			return "Total";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Orcamento a = this.lista.get(row);

		switch (column) {
		case 0:
			return a.getId();
		case 1:
			return a.getCliente().getNome();
		case 2:
			return a.getData();
		case 3:
			return a.getDataValidade();
		case 4:
			return a.getValorTotal();
		}
		throw new RuntimeException("Erro na " + column + " coluna! iaaaaaaaaaaaaa");
	}

	public void adicionar(Orcamento c) {
		this.lista.add(c);
		super.fireTableDataChanged();
	}

	public void remove(Orcamento selecionado) {
		this.lista.remove(selecionado);
		super.fireTableDataChanged();
	}

	public Orcamento getLinhaOrcamento(int idx) {
		if (idx >= this.lista.size()) {
			return null;
		}
		return this.lista.get(idx);
	}

	public List<Orcamento> getListaOrcamento() {
		return this.lista;
	}
}
