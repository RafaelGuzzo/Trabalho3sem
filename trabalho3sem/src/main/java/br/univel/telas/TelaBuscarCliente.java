package br.univel.telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import br.univel.banco.ClienteDao;
import br.univel.model.ClienteModel;
import br.univel.pojo.Cliente;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaBuscarCliente extends JPanel {
	private JTextField textField;
	private JTable table;
	private ClienteDao clieDao = new ClienteDao();
	private Consumer<Cliente> consumerOK;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public TelaBuscarCliente() {
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
		ClienteModel model = new ClienteModel();
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
					if (TelaBuscarCliente.this.runnableOnCancel != null) {
						TelaBuscarCliente.this.runnableOnCancel.run();
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
						Cliente clie = ((ClienteModel) table.getModel()).getLinhaCliente(idx);
						if (clie == null) {
							return;
						}
						TelaBuscarCliente.this.consumerOK.accept(clie);
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (TelaBuscarCliente.this.runnableOnCancel != null) {
						TelaBuscarCliente.this.runnableOnCancel.run();
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
		
		List<Cliente> lista2 = clieDao.buscaNoBanco(palavra.toUpperCase());		
		((ClienteModel) table.getModel()).preencherResultado(lista2);

	}

	public void setOnOk(Consumer<Cliente> a) {
		this.consumerOK = a;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

}
