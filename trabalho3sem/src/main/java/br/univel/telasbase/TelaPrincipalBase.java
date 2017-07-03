package br.univel.telasbase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.telas.TelaClienteImpl;
import br.univel.telas.TelaOrcamentoImpl;
import br.univel.telas.TelaProdutoImpl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLayeredPane;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;

public class TelaPrincipalBase extends JFrame {
	protected JLayeredPane layeredPane;
	protected JButton btnOrca;
	protected JButton btnClie;
	protected JButton btnProd;
	protected JLabel lblhora;
	protected JLabel lbldata;
	protected JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaPrincipalBase() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Date data = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
				lbldata.setText(formato.format(data));

				Timer timer = new Timer(1000, new hora());
				timer.start();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panelbotoes = new JPanel();
		GridBagConstraints gbc_panelbotoes = new GridBagConstraints();
		gbc_panelbotoes.insets = new Insets(0, 0, 0, 5);
		gbc_panelbotoes.fill = GridBagConstraints.BOTH;
		gbc_panelbotoes.gridx = 0;
		gbc_panelbotoes.gridy = 0;
		contentPane.add(panelbotoes, gbc_panelbotoes);
		GridBagLayout gbl_panelbotoes = new GridBagLayout();
		gbl_panelbotoes.columnWidths = new int[] { 0, 0 };
		gbl_panelbotoes.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelbotoes.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelbotoes.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelbotoes.setLayout(gbl_panelbotoes);

		btnOrca = new JButton("Orçamentos");

		GridBagConstraints gbc_btnOrca = new GridBagConstraints();
		gbc_btnOrca.anchor = GridBagConstraints.SOUTH;
		gbc_btnOrca.insets = new Insets(0, 0, 5, 0);
		gbc_btnOrca.gridx = 0;
		gbc_btnOrca.gridy = 0;
		panelbotoes.add(btnOrca, gbc_btnOrca);

		btnClie = new JButton("Clientes");

		GridBagConstraints gbc_btnClie = new GridBagConstraints();
		gbc_btnClie.insets = new Insets(0, 0, 5, 0);
		gbc_btnClie.gridx = 0;
		gbc_btnClie.gridy = 1;
		panelbotoes.add(btnClie, gbc_btnClie);

		btnProd = new JButton("Produtos");

		GridBagConstraints gbc_btnProd = new GridBagConstraints();
		gbc_btnProd.insets = new Insets(0, 0, 5, 0);
		gbc_btnProd.anchor = GridBagConstraints.NORTH;
		gbc_btnProd.gridx = 0;
		gbc_btnProd.gridy = 2;
		panelbotoes.add(btnProd, gbc_btnProd);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		panelbotoes.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lbldata = new JLabel("aaa");
		GridBagConstraints gbc_data = new GridBagConstraints();
		gbc_data.insets = new Insets(0, 0, 0, 5);
		gbc_data.gridx = 0;
		gbc_data.gridy = 0;
		panel.add(lbldata, gbc_data);

		lblhora = new JLabel("");
		lblhora.setMinimumSize(new Dimension(18, 14));
		lblhora.setMaximumSize(new Dimension(18, 14));
		GridBagConstraints gbc_hora = new GridBagConstraints();
		gbc_hora.gridx = 1;
		gbc_hora.gridy = 0;
		panel.add(lblhora, gbc_hora);

		layeredPane = new JLayeredPane();
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 1;
		gbc_layeredPane.gridy = 0;
		contentPane.add(layeredPane, gbc_layeredPane);

	}

	class hora implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Calendar now = Calendar.getInstance();
			lblhora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
		}

	}
}
