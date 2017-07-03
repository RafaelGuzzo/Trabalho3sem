package br.univel.telasbase;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class TelaOrcamentoBase extends JPanel {
	protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alteração";
	protected JTable tableorcamento;
	protected JTextField txfIdOrca;
	protected JTextField txfClienteOrca;
	protected JTextField txfDataVal;
	protected JLabel lblAlerta;
	protected JLabel lblvalor;
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnExcluir;
	protected JButton btnBuscar;
	protected JLabel lblProduto;
	protected JLabel lblQuantidade;
	protected JTextField txfProduto;
	protected JTextField txfQtd;
	protected JButton btnGravar;
	protected JButton btnRemover;
	protected JLabel lblvalortotal;

	/**
	 * Create the panel.
	 */
	public TelaOrcamentoBase() {
		setBorder(new TitledBorder(null, "Or\u00E7amento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txfIdOrca = new JTextField();
		GridBagConstraints gbc_txfIdOrca = new GridBagConstraints();
		gbc_txfIdOrca.anchor = GridBagConstraints.WEST;
		gbc_txfIdOrca.insets = new Insets(0, 0, 5, 5);
		gbc_txfIdOrca.gridx = 1;
		gbc_txfIdOrca.gridy = 0;
		panel.add(txfIdOrca, gbc_txfIdOrca);
		txfIdOrca.setColumns(5);
		
		lblAlerta = new JLabel(CARREGADO_PARA_ALTERACAO);
		lblAlerta.setForeground(Color.RED);
		GridBagConstraints gbc_lblCarregadoParaAlterao = new GridBagConstraints();
		gbc_lblCarregadoParaAlterao.anchor = GridBagConstraints.WEST;
		gbc_lblCarregadoParaAlterao.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarregadoParaAlterao.gridx = 2;
		gbc_lblCarregadoParaAlterao.gridy = 0;
		panel.add(lblAlerta, gbc_lblCarregadoParaAlterao);
		
		JLabel lblCliente = new JLabel("Cliente (F2)");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		panel.add(lblCliente, gbc_lblCliente);
		
		txfClienteOrca = new JTextField();
		GridBagConstraints gbc_txfClienteOrca = new GridBagConstraints();
		gbc_txfClienteOrca.gridwidth = 2;
		gbc_txfClienteOrca.insets = new Insets(0, 0, 5, 0);
		gbc_txfClienteOrca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfClienteOrca.gridx = 1;
		gbc_txfClienteOrca.gridy = 1;
		panel.add(txfClienteOrca, gbc_txfClienteOrca);
		txfClienteOrca.setColumns(10);
		
		lblProduto = new JLabel("Produto (F3)");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 2;
		panel.add(lblProduto, gbc_lblProduto);
		
		txfProduto = new JTextField();
		GridBagConstraints gbc_txfProduto = new GridBagConstraints();
		gbc_txfProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfProduto.gridwidth = 2;
		gbc_txfProduto.insets = new Insets(0, 0, 5, 5);
		gbc_txfProduto.gridx = 1;
		gbc_txfProduto.gridy = 2;
		panel.add(txfProduto, gbc_txfProduto);
		txfProduto.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 3;
		panel.add(lblQuantidade, gbc_lblQuantidade);
		
		txfQtd = new JTextField();
		GridBagConstraints gbc_txfQtd = new GridBagConstraints();
		gbc_txfQtd.anchor = GridBagConstraints.WEST;
		gbc_txfQtd.gridwidth = 2;
		gbc_txfQtd.insets = new Insets(0, 0, 5, 5);
		gbc_txfQtd.gridx = 1;
		gbc_txfQtd.gridy = 3;
		panel.add(txfQtd, gbc_txfQtd);
		txfQtd.setColumns(10);
		txfQtd.setText("1");
		
		JLabel lblValidade = new JLabel("Validade");
		GridBagConstraints gbc_lblValidade = new GridBagConstraints();
		gbc_lblValidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblValidade.gridx = 0;
		gbc_lblValidade.gridy = 4;
		panel.add(lblValidade, gbc_lblValidade);
		
		txfDataVal = new JTextField();
		GridBagConstraints gbc_txfDataVal = new GridBagConstraints();
		gbc_txfDataVal.anchor = GridBagConstraints.WEST;
		gbc_txfDataVal.gridwidth = 2;
		gbc_txfDataVal.gridx = 1;
		gbc_txfDataVal.gridy = 4;
		panel.add(txfDataVal, gbc_txfDataVal);
		txfDataVal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNovo = new JButton("Novo");
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.anchor = GridBagConstraints.EAST;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		panel_1.add(btnNovo, gbc_btnNovo);
		
		btnGravar = new JButton("Gravar");
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGravar.gridx = 1;
		gbc_btnGravar.gridy = 0;
		panel_1.add(btnGravar, gbc_btnGravar);
		
		btnRemover = new JButton("Remover");
		GridBagConstraints gbc_btnRemover = new GridBagConstraints();
		gbc_btnRemover.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemover.gridx = 2;
		gbc_btnRemover.gridy = 0;
		panel_1.add(btnRemover, gbc_btnRemover);
		
		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 0;
		panel_1.add(btnExcluir, gbc_btnExcluir);
		
		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 4;
		gbc_btnBuscar.gridy = 0;
		panel_1.add(btnBuscar, gbc_btnBuscar);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.gridx = 5;
		gbc_btnSalvar.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		tableorcamento = new JTable();
		scrollPane.setViewportView(tableorcamento);
		
		lblvalor = new JLabel("Total U$:");
		GridBagConstraints gbc_lblvalor = new GridBagConstraints();
		gbc_lblvalor.insets = new Insets(0, 0, 0, 5);
		gbc_lblvalor.anchor = GridBagConstraints.EAST;
		gbc_lblvalor.gridx = 0;
		gbc_lblvalor.gridy = 3;
		add(lblvalor, gbc_lblvalor);
		
		lblvalortotal = new JLabel("New label");
		GridBagConstraints gbc_lblvalortotal = new GridBagConstraints();
		gbc_lblvalortotal.anchor = GridBagConstraints.WEST;
		gbc_lblvalortotal.gridx = 1;
		gbc_lblvalortotal.gridy = 3;
		add(lblvalortotal, gbc_lblvalortotal);

	}

}
