package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;
import br.univel.banco.ProdutoDao;
import br.univel.controle.GlassPaneController;
import br.univel.controle.TelaController;
import br.univel.model.ProdutoModel;
import br.univel.pojo.Produto;
import br.univel.telasbase.TelaProdutoBase;

public class TelaProdutoImpl extends TelaProdutoBase {
	private Produto produtoselecionado;
	private ProdutoModel modelo;
	private ProdutoDao dao = new ProdutoDao();

	
	

	public TelaProdutoImpl() {
		super();
		configuraTabela();
		limparCampos();
		configuraBotoes();
		
		
	}


	private void configuraTabela() {
		this.modelo = new ProdutoModel(dao.getTodos());
		super.tableproduto.setModel(modelo);
		
		super.tableproduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					int idx = tableproduto.getSelectedRow();
					Produto p = modelo.getLinhaProduto(idx);
					preencherCampos(p);
				}
				super.mouseClicked(e);
			}

		});
	}

	

	private void configuraBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});

		super.btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		super.btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		
		super.btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abreBusca();
			}
		});
		
		
	}

	

	protected void abreBusca() {		
		GlassPaneController control = TelaController.getInstance().getController();
		TelaBuscarProduto telabusca = new TelaBuscarProduto();
		
		telabusca.setOnOk(new Consumer<Produto>() {
			
			@Override
			public void accept(Produto t) {
				telabusca.setVisible(false);
				preencherCampos(t);
			}
		});
		
		telabusca.setOnCancel(new Runnable() {
			
			@Override
			public void run() {
				limparCampos();
				telabusca.setVisible(false);
			}
		});
		
		control.setGlassPane(telabusca);
		telabusca.setVisible(true);	
	}
	

	protected void preencherCampos(Produto t) {
		this.produtoselecionado = t;
		super.txfidproduto.setText(String.valueOf(t.getId()));
		super.descproduto.setText(t.getDescricao());
		super.valproduto.setText(String.valueOf(t.getPreco()));
	
		super.lblAlerta.setText(CARREGADO_PARA_ALTERACAO);

		super.btnExcluir.setEnabled(true);
	}


	protected void excluir() {
		this.modelo.remove(this.produtoselecionado);
		dao.exclui(this.produtoselecionado.getId());
		limparCampos();

	}

	protected void salvar() {
		String strId = super.txfidproduto.getText().trim();
		String strDesc = super.descproduto.getText().trim();
		String strvalor = super.valproduto.getText().trim();
		String strValorSemponto = strvalor.replaceAll("\\.", "");
		String strValorIngles = strValorSemponto.replaceAll(",", ".");
		
		long lgid = Long.parseLong(strId);
		
		BigDecimal bgvalor = new BigDecimal(strValorIngles);
		

		if (produtoselecionado == null) {
			Produto p = new Produto();
			p.setId(lgid);
			p.setDescricao(strDesc);
			p.setPreco(bgvalor);

			this.modelo.adicionar(p);
			dao.adicionarUm(p);
			limparCampos();
			
			

		} else {
			this.produtoselecionado.setId(lgid);
			this.produtoselecionado.setDescricao(strDesc);
			this.produtoselecionado.setPreco(bgvalor);
			
			dao.atualiza(lgid, this.produtoselecionado);
			
			this.modelo.fireTableDataChanged();
			limparCampos();
			
		}
	}

	protected void novo() {
		this.produtoselecionado = null;
		limparCampos();
	}

	private void limparCampos() {
		this.produtoselecionado = null;
		super.txfidproduto.setText("");
		super.descproduto.setText("");
		super.valproduto.setText("");
		super.lblAlerta.setText("");
		super.btnExcluir.setEnabled(false);
		
	}

}
