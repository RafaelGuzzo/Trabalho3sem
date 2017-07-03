package br.univel.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import br.univel.banco.ClienteDao;
import br.univel.banco.ProdutoDao;
import br.univel.controle.GlassPaneController;
import br.univel.controle.TelaController;
import br.univel.model.OrcamentoModel;
import br.univel.model.ProdutoOrcaModel;
import br.univel.pojo.Cliente;
import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;
import br.univel.telasbase.TelaOrcamentoBase;

public class TelaOrcamentoImpl extends TelaOrcamentoBase {
	private Orcamento orcamentoselecionado;
	private Produto produtoselecionado;
	private Cliente clienteselecionado;
	private OrcamentoModel modeloOrcamento;
	private ProdutoOrcaModel modeloProduto;
	private List<Orcamento> listaOrcamento = new ArrayList<>();
	private List<Produto> listaproduto = new ArrayList<>();
	private ClienteDao daoCliente = new ClienteDao();
	private ProdutoDao daoProduto = new ProdutoDao();

	public TelaOrcamentoImpl() {
		super();
		limparCampos();
		configuraBotoes();
		configuraTabela();
		configuraField();
	}

	private void configuraField() {
		super.txfClienteOrca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2)
					buscaCliente();
			}
		});

		super.txfProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F3)
					buscaProduto();
			}
		});

	}

	private void configuraTabela() {
		this.modeloOrcamento = new OrcamentoModel();
		super.tableorcamento.setModel(modeloOrcamento);
		if (super.tableorcamento.getModel().equals(modeloOrcamento)) {
			super.tableorcamento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getClickCount() == 2) {
						int idx = tableorcamento.getSelectedRow();
						Orcamento o = modeloOrcamento.getLinhaOrcamento(idx);
						preencherCampos(o);
					}
					super.mouseClicked(e);
				}

			});
		}

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

		super.btnGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gravar();
			}
		});
		
		super.btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});

	}

	

	protected void buscaProduto() {
		GlassPaneController control = TelaController.getInstance().getController();
		TelaBuscarProduto telabusca = new TelaBuscarProduto();

		telabusca.setOnOk(new Consumer<Produto>() {

			@Override
			public void accept(Produto p) {
				produtoselecionado = p;
				txfProduto.setText(p.getDescricao());
				telabusca.setVisible(false);

				// dao.adicionarUm(t);
				// modelo.preencherResultado(dao.getTodos());//gambs para
				// atualizar table
				// preencherCampos(t);
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

	protected void buscaCliente() {
		GlassPaneController control = TelaController.getInstance().getController();
		TelaBuscarCliente telabusca = new TelaBuscarCliente();

		telabusca.setOnOk(new Consumer<Cliente>() {

			@Override
			public void accept(Cliente c) {
				telabusca.setVisible(false);
				// dao.adicionar(t);
				// modelo.preencherResultado(dao.getTodos());//gambs para
				// atualizar table
				clienteselecionado = c;
				txfClienteOrca.setText(c.getNome());
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

	protected void abreBusca() {
		/*
		 * GlassPaneController control =
		 * TelaController.getInstance().getController();
		 * System.out.println(control); TelaBuscar telabusca = new TelaBuscar();
		 * 
		 * telabusca.setOnOk(new Consumer<Produto>() {
		 * 
		 * @Override public void accept(Produto t) {
		 * telabusca.setVisible(false); dao.adicionar(t);
		 * lblTotal.setText(dao.somaValor());
		 * modelo.preencherResultado(dao.getTodos());//gambs para atualizar
		 * table //preencherCampos(t); } });
		 * 
		 * telabusca.setOnCancel(new Runnable() {
		 * 
		 * @Override public void run() { limparCampos();
		 * telabusca.setVisible(false); } });
		 * 
		 * control.setGlassPane(telabusca); telabusca.setVisible(true);
		 */
	}

	protected void gravar() {
		String strQtd = super.txfQtd.getText().trim();
		int qtd = Integer.parseInt(strQtd);

		if (produtoselecionado != null) {
			Produto p = new Produto();
			p.setId(produtoselecionado.getId());
			p.setDescricao(produtoselecionado.getDescricao());
			p.setPreco(produtoselecionado.getPreco());
			p.setQuantidade(qtd);

			listaproduto.add(p);
			alteraModeloTabel(listaproduto);
		}
		limparCamposProduto();
	}
	
	protected void remover() {
		if(super.tableorcamento.getModel().equals(modeloProduto)){
			int idx = super.tableorcamento.getSelectedRow();
			Produto p = this.listaproduto.get(idx);
			this.listaproduto.remove(idx);
			alteraModeloTabel(listaproduto);
		}
	}

	protected void preencherCampos(Orcamento o) {
		this.orcamentoselecionado = o;
		this.listaproduto = o.getProdutos();
		this.clienteselecionado = o.getCliente();

		super.txfIdOrca.setText(String.valueOf(o.getId()));
		super.txfClienteOrca.setText(o.getCliente().getNome());
		super.txfDataVal.setText(String.valueOf(o.getData()));

		super.lblAlerta.setText(CARREGADO_PARA_ALTERACAO);

		super.btnExcluir.setEnabled(true);

		modeloProduto = new ProdutoOrcaModel(listaproduto);
		super.tableorcamento.setModel(modeloProduto);
	}

	protected void excluir() {
		this.modeloOrcamento.remove(this.orcamentoselecionado);
		super.tableorcamento.setModel(modeloOrcamento);
		// dao.exclui(this.produtoselecionado.getId());
		limparCampos();

	}

	protected void salvar() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");

		String strId = super.txfIdOrca.getText().trim();
		String dataval = super.txfDataVal.getText().trim();
		String dataAtual = formato.format(new Date());

		long lgid = Long.parseLong(strId);

		if (orcamentoselecionado == null) {
			Orcamento o = new Orcamento();
			o.setId(lgid);
			o.setDataValidade(dataval);
			o.setData(dataAtual);
			o.setCliente(clienteselecionado);
			o.setProdutos(listaproduto);
			// o.setValorTotal(valorTotal);

			this.modeloOrcamento.adicionar(o);
			listaOrcamento.add(o);
			// dao.adicionar(p);

			novo();// vai limpa tudo e espera um novo orcamento

		} else {
			// this.clienteselecionado = orcamentoselecionado.getCliente();
			// this.listaproduto = orcamentoselecionado.getProdutos();

			this.orcamentoselecionado.setId(lgid);
			this.orcamentoselecionado.setDataValidade(dataval);
			this.orcamentoselecionado.setData(dataAtual);
			this.orcamentoselecionado.setCliente(clienteselecionado);
			this.orcamentoselecionado.setProdutos(listaproduto);
			// this.orcamentoselecionado.setValorTotal(valorTotal);

			listaOrcamento.add(orcamentoselecionado);
			this.modeloOrcamento.fireTableDataChanged();

			novo();// vai limpa tudo e espera um novo orcamento

		}
		super.tableorcamento.setModel(modeloOrcamento);
	}

	protected void novo() {
		this.orcamentoselecionado = null;
		this.produtoselecionado = null;
		this.clienteselecionado = null;
		this.listaproduto = new ArrayList<>();
		this.modeloProduto = new ProdutoOrcaModel();
		limparCampos();
	}

	private void limparCamposProduto() {
		super.txfProduto.setText("");
		super.txfQtd.setText("1");
		super.txfClienteOrca.setEnabled(false);
		super.txfDataVal.setEnabled(false);
		super.txfIdOrca.setEnabled(false);
		super.btnExcluir.setEnabled(false);
	}

	private void limparCampos() {
		this.orcamentoselecionado = null;
		super.txfProduto.setText("");
		super.txfIdOrca.setText("");
		super.txfDataVal.setText("");
		super.txfClienteOrca.setText("");
		super.lblAlerta.setText("");

		super.btnExcluir.setEnabled(false);
		super.txfClienteOrca.setEnabled(true);
		super.txfDataVal.setEnabled(true);
		super.txfIdOrca.setEnabled(true);

	}

	private void alteraModeloTabel(List<Produto> lista) {
		this.modeloProduto = new ProdutoOrcaModel(lista);
		super.tableorcamento.setModel(modeloProduto);
	}
}
