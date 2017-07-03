package br.univel.controle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.univel.pojo.Produto;

public class LeitorProdutoUrl {
	
	private Pattern pattern = Pattern.compile("([0-9]+)(.*)US\\$(.*)");
	
	public List<Produto> lerProdutos(String strurl) throws Exception{
		List<Produto> lista = new ArrayList<>();
		URL url = new URL(strurl);
		URLConnection urlCon = url.openConnection();
		
		try (InputStream is = urlCon.getInputStream();
			 InputStreamReader isr = new InputStreamReader(is);
			 BufferedReader in = new BufferedReader(isr)) {
			
			
			String linha;
			while ((linha = in.readLine()) != null) {
				if(linha.matches("[0-9]+.*")){
					Produto p = lerProduto(linha);
					lista.add(p);
				}
			}
		}
		
		return lista;
	}
	
	
	private Produto lerProduto(String linha) {
		Matcher mat = pattern.matcher(linha);
		Produto produto = new Produto();
		
		if(mat.matches()){
			String strid = mat.group(1).trim();
			String desc = mat.group(2).trim();
			String strValorOrg = mat.group(3).trim();
			String strValorSemponto = strValorOrg.replaceAll("\\.", "");
			String strValorIngles = strValorSemponto.replaceAll(",", ".");
			
			produto.setPreco(new BigDecimal(strValorIngles));
			produto.setId(Long.parseLong(strid));
			produto.setDescricao(desc);
			
		}else{
			throw new RuntimeException("Linha Invalida: "+linha);
		}
		
		return produto;
	}
}
