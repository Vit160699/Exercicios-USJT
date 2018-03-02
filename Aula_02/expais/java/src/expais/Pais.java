package expais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class Pais {
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
			}
		}
	
	
	int id;
	String nome;
	long populacao;
	double area;
	
	public Pais(){
		
	}


	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	// Faz a conexao com o banco de dados
		public Connection obtemConexao() throws SQLException {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/Pais?user=root&password=160699");
		}
		

	// CRUD	
		
		public void criar() {
			String sqlInsert = "INSERT INTO pais(nomePais, populacaoPais, areaPais) VALUES (?, ?, ?)";
		
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.execute();
				String sqlQuery  = "SELECT LAST_INSERT_ID()";
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
					if(rs.next()){
						setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void atualizar() {
			String sqlUpdate = "UPDATE pais SET nomePais=?, populacaoPais=?, areaPais=? WHERE idPais=?";
			
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.setInt(4, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void excluir() {
			String sqlDelete = "DELETE FROM pais WHERE idPais = ?";
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void carregar() {
			String sqlSelect = "SELECT nomePais, populacaoPais, areaPais FROM pais WHERE pais.idPais = ?";
			
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						setNome(rs.getString("nomePais"));
						setPopulacao(rs.getLong("populacaoPais"));
						setArea(rs.getDouble("areaPais"));
					} else {
						setId(-1);
						setNome(null);
						/*setPopulacao(null);
						setArea(null);*/
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}

	
		public int getId() {
			return id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public long getPopulacao() {
			return populacao;
		}
		
		public double getArea() {
			return area;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public void setPopulacao(long populacao) {
			this.populacao = populacao;
		}
		
		public void setArea(double area) {
			this.area = area;
		}
		
			public void maiorPopulacao(){
				String sqlSelect = "SELECT * FROM pais WHERE populacaoPais = (SELECT MAX(populacaoPais) FROM pais )";
				
				try (Connection conn = obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						ResultSet rs = stm.executeQuery();
					
						if (rs.next()) {
							setNome(rs.getString("nomePais"));
							setPopulacao(rs.getLong("populacaoPais"));
							
						} else {
							System.out.println("Deu pau");
						}
					
					} catch (SQLException e) {
						System.out.print(e);
					}
			}
			
			public void menorArea(){
				String sqlSelect = "SELECT * FROM pais WHERE areaPais = (SELECT MIN(areaPais) FROM  pais)";
				
				try (Connection conn = obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						ResultSet rs = stm.executeQuery();
					
						if (rs.next()) {
							setNome(rs.getString("nomePais"));
							setPopulacao(rs.getLong("populacaoPais"));
							
						} else {
							System.out.println("Deu pau");
						}
					
					} catch (SQLException e) {
						System.out.print(e);
					}
			}
			
			public String[] vetorTresPaises() {
				
				String sqlSelect = "Select nome from paises order by nome";
				String[] vet = new String[3];
				int j = 0 ;
				
				
				try (Connection conn = obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						ResultSet rs = stm.executeQuery();
					
						while(rs.next()&& j < 3) {
							vet[j] = rs.getString("nomePais");
							j++;
							
						}}catch (SQLException e) {
							System.out.print(e);
						}
				return vet;
			}	
		


		@Override
		public String toString() {
			return "Id= " + id + ", \nNome= " + nome + "\nPopulacao= " + populacao
					+ "\nArea= " + area + "\n-------------";
		}
		
		
		


		
		





		
}		
