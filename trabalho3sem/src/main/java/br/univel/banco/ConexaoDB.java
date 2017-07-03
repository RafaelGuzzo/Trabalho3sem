package br.univel.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	private static ConexaoDB self;
	private Connection con;

	public ConexaoDB() {		
		try {
			Class.forName("org.postgresql.Driver");
			//this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/batata", "postgres", "123");
			this.con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
			
			
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						ConexaoDB.this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
		} catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
	}
	
	public final static synchronized ConexaoDB getInstance(){
		if(self == null){
			self = new ConexaoDB();
		}
		return self;
	}
	
	public Connection getConnection(){
		return this.con;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("E permitida apenas uma conexao!");
	}
	
	

}
