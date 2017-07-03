package br.univel.principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JComponent;

import br.univel.banco.ProdutoDao;
import br.univel.controle.GlassPaneController;
import br.univel.controle.LeitorProdutoUrl;
import br.univel.controle.TelaController;
import br.univel.pojo.Produto;
import br.univel.telas.TelaBuscarProduto;
import br.univel.telas.TelaClienteImpl;
import br.univel.telas.TelaOrcamentoImpl;
import br.univel.telas.TelaProdutoImpl;
import br.univel.telasbase.TelaClienteBase;
import br.univel.telasbase.TelaOrcamentoBase;
import br.univel.telasbase.TelaPrincipalBase;
import br.univel.telasbase.TelaProdutoBase;

public class Principal extends TelaPrincipalBase implements GlassPaneController {
	private TelaOrcamentoImpl orcamentos;
	private TelaClienteImpl cliente;
	private TelaProdutoImpl produto;
	private ProdutoDao prodDao = new ProdutoDao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					TelaController.getInstance().setController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		super();
		configuraTela();
		ConfiguraBotoes();
		inicaLista();
	}

	private void inicaLista() {
		LeitorProdutoUrl leitor = new LeitorProdutoUrl();
		try {
			prodDao.adicionarVarios(leitor.lerProdutos("http://www.master10.com.py/lista-txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configuraTela() {
		produto = new TelaProdutoImpl();
		produto.setBounds(0, 0, 648, 411);
		super.layeredPane.add(produto);

		orcamentos = new TelaOrcamentoImpl();
		orcamentos.setBounds(0, 0, 648, 411);
		super.layeredPane.add(orcamentos);

		cliente = new TelaClienteImpl();
		cliente.setBounds(0, 0, 648, 411);
		super.layeredPane.add(cliente);
		
		
		orcamentos.setVisible(true);
		produto.setVisible(false);
		cliente.setVisible(false);
	}

	private void ConfiguraBotoes() {
		super.btnOrca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				orcamentos.setVisible(true);
				produto.setVisible(false);
				cliente.setVisible(false);

			}
		});

		super.btnClie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cliente.setVisible(true);
				orcamentos.setVisible(false);
				produto.setVisible(false);

			}
		});

		super.btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				produto.setVisible(true);
				orcamentos.setVisible(false);
				cliente.setVisible(false);

			}
		});
	
	}
	

	@Override
	public void setGlassPane(JComponent comp) {
		super.setGlassPane(comp);
		
	}
}
