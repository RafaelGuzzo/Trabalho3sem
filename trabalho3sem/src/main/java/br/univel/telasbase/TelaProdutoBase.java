package br.univel.telasbase;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class TelaProdutoBase extends JPanel {
	protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alteração";
	protected JTextField txfidproduto;
	protected JTextField descproduto;
	protected JTextField valproduto;
	protected JLabel lblAlerta;
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnExcluir;
	protected JButton btnBuscar;
	protected JTable tableproduto;

	/**
	 * Create the panel.
	 */
	public TelaProdutoBase() {
		setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		txfidproduto = new JTextField();
		GridBagConstraints gbc_txfidproduto = new GridBagConstraints();
		gbc_txfidproduto.insets = new Insets(0, 0, 5, 5);
		gbc_txfidproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfidproduto.gridx = 1;
		gbc_txfidproduto.gridy = 0;
		panel.add(txfidproduto, gbc_txfidproduto);
		txfidproduto.setColumns(5);
		
		lblAlerta = new JLabel(CARREGADO_PARA_ALTERACAO);
		lblAlerta.setForeground(Color.RED);
		GridBagConstraints gbc_lblCarregadoParaAlterao = new GridBagConstraints();
		gbc_lblCarregadoParaAlterao.anchor = GridBagConstraints.WEST;
		gbc_lblCarregadoParaAlterao.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarregadoParaAlterao.gridx = 2;
		gbc_lblCarregadoParaAlterao.gridy = 0;
		panel.add(lblAlerta, gbc_lblCarregadoParaAlterao);
		
		JLabel lblDesc = new JLabel("Descrição");
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 1;
		panel.add(lblDesc, gbc_lblDesc);
		
		descproduto = new JTextField();
		GridBagConstraints gbc_descproduto = new GridBagConstraints();
		gbc_descproduto.gridwidth = 2;
		gbc_descproduto.insets = new Insets(0, 0, 5, 5);
		gbc_descproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_descproduto.gridx = 1;
		gbc_descproduto.gridy = 1;
		panel.add(descproduto, gbc_descproduto);
		descproduto.setColumns(10);
		
		JLabel lblValorU = new JLabel("Valor U$");
		GridBagConstraints gbc_lblValorU = new GridBagConstraints();
		gbc_lblValorU.insets = new Insets(0, 0, 0, 5);
		gbc_lblValorU.gridx = 0;
		gbc_lblValorU.gridy = 2;
		panel.add(lblValorU, gbc_lblValorU);
		
		valproduto = new JTextField();
		GridBagConstraints gbc_valproduto = new GridBagConstraints();
		gbc_valproduto.anchor = GridBagConstraints.WEST;
		gbc_valproduto.gridwidth = 2;
		gbc_valproduto.insets = new Insets(0, 0, 0, 5);
		gbc_valproduto.gridx = 1;
		gbc_valproduto.gridy = 2;
		panel.add(valproduto, gbc_valproduto);
		valproduto.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNovo = new JButton("Novo");
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.anchor = GridBagConstraints.EAST;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		panel_1.add(btnNovo, gbc_btnNovo);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel_1.add(btnExcluir, gbc_btnExcluir);
		
		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 0;
		panel_1.add(btnBuscar, gbc_btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		tableproduto = new JTable();
		scrollPane.setViewportView(tableproduto);

	}

}
