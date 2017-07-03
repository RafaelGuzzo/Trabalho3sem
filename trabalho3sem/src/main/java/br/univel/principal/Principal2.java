package br.univel.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.banco.ProdutoDao;
import br.univel.controle.GlassPaneController;
import br.univel.controle.LeitorProdutoUrl;
import br.univel.controle.TelaController;
import br.univel.telas.TelaClienteImpl;
import br.univel.telas.TelaOrcamentoImpl;
import br.univel.telas.TelaProdutoImpl;
import br.univel.telasbase.PainelWrapper;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal2 extends JFrame implements GlassPaneController{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private ProdutoDao prodDao = new ProdutoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2();
					TelaController.getInstance().setController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal2() {
		inicaLista();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnOramentos = new JButton("Orçamentos");
		btnOramentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAbaOrcamento();
			}
		});
		GridBagConstraints gbc_btnOramentos = new GridBagConstraints();
		gbc_btnOramentos.anchor = GridBagConstraints.EAST;
		gbc_btnOramentos.insets = new Insets(0, 0, 0, 5);
		gbc_btnOramentos.gridx = 0;
		gbc_btnOramentos.gridy = 0;
		panel.add(btnOramentos, gbc_btnOramentos);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAbaCliente();
			}
		});
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnClientes.gridx = 1;
		gbc_btnClientes.gridy = 0;
		panel.add(btnClientes, gbc_btnClientes);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduto();
			}
		});
		GridBagConstraints gbc_btnProdutos = new GridBagConstraints();
		gbc_btnProdutos.anchor = GridBagConstraints.WEST;
		gbc_btnProdutos.gridx = 2;
		gbc_btnProdutos.gridy = 0;
		panel.add(btnProdutos, gbc_btnProdutos);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void inicaLista() {
		LeitorProdutoUrl leitor = new LeitorProdutoUrl();
		try {
			prodDao.adicionarVarios(leitor.lerProdutos("http://www.master10.com.py/lista-txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void addProduto() {
		TelaProdutoImpl  produto = new TelaProdutoImpl();
		PainelWrapper wrapper = new PainelWrapper();
		wrapper.setConteudo(produto);
		wrapper.btnPdf.setEnabled(false);

		wrapper.setTitulo("Cadastro de Produtos");

		wrapper.setAcaoFechar(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		tabbedPane.add("Produtos", wrapper);
	}

	protected void addAbaCliente() {
		TelaClienteImpl  cliente = new TelaClienteImpl();
		PainelWrapper wrapper = new PainelWrapper();
		wrapper.setConteudo(cliente);
		wrapper.btnPdf.setEnabled(false);
		wrapper.setTitulo("Cadastro de Clientes");

		wrapper.setAcaoFechar(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		tabbedPane.add("Clientes", wrapper);
		
	}

	protected void addAbaOrcamento() {
		TelaOrcamentoImpl  orcamento = new TelaOrcamentoImpl();
		PainelWrapper wrapper = new PainelWrapper();
		wrapper.setConteudo(orcamento);

		wrapper.setTitulo("Cadastro de Orçamentos");

		wrapper.setAcaoFechar(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		tabbedPane.add("Orçamentos", wrapper);
		
	}
	
	@Override
	public void setGlassPane(JComponent comp) {
		super.setGlassPane(comp);

	}

}
