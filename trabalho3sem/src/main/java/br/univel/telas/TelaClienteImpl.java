package br.univel.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import br.univel.banco.ClienteDao;
import br.univel.controle.GlassPaneController;
import br.univel.controle.TelaController;
import br.univel.model.ClienteModel;
import br.univel.pojo.Cliente;
import br.univel.telasbase.TelaClienteBase;

public class TelaClienteImpl extends TelaClienteBase {
	private Cliente clienteselecionado;
	private ClienteModel modelo;
	private ClienteDao dao = new ClienteDao();

	public TelaClienteImpl() {
		super();
		limparCampos();
		configuraBotoes();
		configuraTabela();

	}

	private void configuraTabela() {
		this.modelo = new ClienteModel(dao.getTodos());
		super.tablecliente.setModel(modelo);

		super.tablecliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					int idx = tablecliente.getSelectedRow();
					Cliente c = modelo.getLinhaCliente(idx);
					preencherCampos(c);
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
		TelaBuscarCliente telabusca = new TelaBuscarCliente();
		
		telabusca.setOnOk(new Consumer<Cliente>() {
			
			@Override
			public void accept(Cliente t) {
				telabusca.setVisible(false);
				//dao.adicionar(t);
				//modelo.preencherResultado(dao.getTodos());//gambs para atualizar table
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

	protected void preencherCampos(Cliente c) {
		this.clienteselecionado = c;
		super.txfidcliente.setText(String.valueOf(c.getId()));
		super.txfnomeclie.setText(c.getNome());
		super.lblAlerta.setText(CARREGADO_PARA_ALTERACAO);

		super.btnExcluir.setEnabled(true);
	}

	protected void excluir() {
		this.modelo.remove(this.clienteselecionado);
		dao.exclui(this.clienteselecionado.getId());
		limparCampos();

	}

	protected void salvar() {
		String strId = super.txfidcliente.getText().trim();
		String strNome = super.txfnomeclie.getText().trim();
		long lgid = Long.parseLong(strId);


		if (clienteselecionado == null) {
			Cliente c = new Cliente();
			c.setId(lgid);
			c.setNome(strNome);

			this.modelo.adicionar(c);
			dao.adicionar(c);
			limparCampos();

		} else {
			this.clienteselecionado.setId(lgid);
			this.clienteselecionado.setNome(strNome);

			// dao.atualiza(lgid, this.produtoselecionado);
			// lblTotal.setText(dao.somaValor());
			// this.modelo.preencherResultado(dao.getTodos());//tive que fazer
			// essa bambis para atualizar
			this.modelo.fireTableDataChanged();
			limparCampos();

		}
	}

	protected void novo() {
		this.clienteselecionado = null;
		limparCampos();
	}

	private void limparCampos() {
		this.clienteselecionado = null;
		super.txfidcliente.setText("");
		super.txfnomeclie.setText("");
		super.lblAlerta.setText("");
		super.btnExcluir.setEnabled(false);

	}
}
