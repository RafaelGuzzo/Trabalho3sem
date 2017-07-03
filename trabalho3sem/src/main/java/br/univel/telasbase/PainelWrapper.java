package br.univel.telasbase;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Insets;
import java.awt.event.ActionListener;

public class PainelWrapper extends JPanel {
	private JButton btnX;
	private JLabel lblTitulo;
	public JButton btnPdf;

	/**
	 * Create the panel.
	 */
	public PainelWrapper() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblTitulo = new JLabel("New label");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);

		btnPdf = new JButton("PDF");
		GridBagConstraints gbc_btnPdf = new GridBagConstraints();
		gbc_btnPdf.insets = new Insets(0, 0, 0, 5);
		gbc_btnPdf.gridx = 1;
		gbc_btnPdf.gridy = 0;
		panel.add(btnPdf, gbc_btnPdf);

		btnX = new JButton("X");
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.gridx = 2;
		gbc_btnX.gridy = 0;
		panel.add(btnX, gbc_btnX);
	}

	public void setTitulo(String titulo) {
		this.lblTitulo.setText(titulo);
	}

	public void setAcaoFechar(ActionListener action) {
		this.btnX.addActionListener(action);
	}

	public void setAcaoPdf(ActionListener action2) {
		this.btnPdf.addActionListener(action2);
	}

	public void setConteudo(JPanel painel) {
		add(painel, BorderLayout.CENTER);

	}

}
