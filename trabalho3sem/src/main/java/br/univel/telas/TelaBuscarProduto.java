package br.univel.telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import br.univel.banco.ProdutoDao;
import br.univel.model.ProdutoModel;
import br.univel.pojo.Produto;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaBuscarProduto extends JPanel {
	private JTextField textField;
	private JTable table;
	private ProdutoDao proDao = new ProdutoDao();
	private Consumer<Produto> consumerOK;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public TelaBuscarProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Descrição");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		configuraTela();

	}

	private void configuraTela() {
		ProdutoModel model = new ProdutoModel();
		table.setModel(model);

		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						busca(textField.getText().trim());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					table.getSelectionModel().setSelectionInterval(0, 0);
					textField.transferFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (TelaBuscarProduto.this.runnableOnCancel != null) {
						TelaBuscarProduto.this.runnableOnCancel.run();
					}
				}

			}

		});

		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					e.consume();
					table.transferFocusBackward();
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();

					int idx = table.getSelectedRow();
					if (idx != -1) {
						Produto pet = ((ProdutoModel) table.getModel()).getLinhaProduto(idx);
						if (pet == null) {
							return;
						}
						TelaBuscarProduto.this.consumerOK.accept(pet);
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (TelaBuscarProduto.this.runnableOnCancel != null) {
						TelaBuscarProduto.this.runnableOnCancel.run();
					}
				}
			}

		});
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				textField.requestFocusInWindow();
			}
		});
	}

	protected void busca(String palavra) throws Exception {
		
		List<Produto> lista2 = proDao.buscaNoBanco(palavra.toUpperCase());		
		((ProdutoModel) table.getModel()).preencherResultado(lista2);

	}

	public void setOnOk(Consumer<Produto> a) {
		this.consumerOK = a;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

}
