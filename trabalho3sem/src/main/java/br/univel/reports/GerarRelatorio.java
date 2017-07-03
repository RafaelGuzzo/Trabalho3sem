package br.univel.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import br.univel.pojo.Orcamento;
import br.univel.pojo.Produto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GerarRelatorio {
	private JasperPrint pdf;

	public void gerar(Orcamento orc) {
		String file = "src\\main\\resources\\orcamento.jasper";

		try {
			JRDataSource custom = new OrcamentoJasperDs(orc,orc.getProdutos());
			pdf = JasperFillManager.fillReport(file, null, custom);
			JasperExportManager.exportReportToPdfFile(pdf, "teste.pdf");

			Desktop.getDesktop().open(new File("teste.pdf"));
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
}
