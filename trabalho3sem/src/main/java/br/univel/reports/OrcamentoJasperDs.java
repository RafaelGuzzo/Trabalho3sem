package br.univel.reports;

import java.util.Iterator;
import java.util.List;

import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class OrcamentoJasperDs implements JRDataSource {
	private Iterator<Orcamento> iterator;
	private Orcamento selecionado;
	private List<Produto> lista1 = selecionado.getProdutos();
	
	public OrcamentoJasperDs(List<Orcamento> lista) {
		this.iterator = lista.iterator();
		for (Produto p : lista1) {
			System.out.println(p.getDescricao());
		}
	}

	@Override
	public Object getFieldValue(JRField field) throws JRException {
		if ("Cliente".equals(field.getName())) {
			return selecionado.getCliente();
		}
		if ("Validade".equals(field.getName())) {
			return selecionado.getDataValidade();
		}
		if ("Id".equals(field.getName())) {
			return selecionado.getId();
		}/*
		if ("apelido".equals(field.getName())) {
			return selecionado.getApelido();
		}
		if ("cor".equals(field.getName())) {
			return selecionado.getCor();
		}
		if ("raca".equals(field.getName())) {
			return selecionado.getRaca();
		}
		if ("peso".equals(field.getName())) {
			return selecionado.getPeso();
		}*/
		return null;
		
	}

	@Override
	public boolean next() throws JRException {
		if (iterator.hasNext()) {
			this.selecionado = iterator.next();
			return true;
		}

		return false;
	}
	

}
