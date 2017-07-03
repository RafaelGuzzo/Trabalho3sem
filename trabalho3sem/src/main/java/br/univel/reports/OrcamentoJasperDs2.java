package br.univel.reports;

import java.util.Iterator;
import java.util.List;

import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class OrcamentoJasperDs2 implements JRDataSource {
	private Iterator<Produto> iterator;
	private Produto selecionado;
	private Orcamento orc;
	
	public OrcamentoJasperDs2(Orcamento orc, List<Produto> lista) {
		this.iterator = lista.iterator();
		this.orc = orc;
	}

	@Override
	public Object getFieldValue(JRField field) throws JRException {
		if ("Cliente".equals(field.getName())) {
			return orc.getCliente().getNome();
		}
		if ("Validade".equals(field.getName())) {
			return orc.getDataValidade();
		}
		if ("Id".equals(field.getName())) {
			return orc.getId();
		}
		if ("Produto".equals(field.getName())) {
			return selecionado.getDescricao();
		}
		if ("Valor".equals(field.getName())) {
			return selecionado.getPreco();
		}
		if ("Quantidade".equals(field.getName())) {
			return selecionado.getQuantidade();
		}
		if ("Total".equals(field.getName())) {
			return orc.getValorTotal();
		}
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

