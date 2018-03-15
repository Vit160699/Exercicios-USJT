package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;


public class PaisDAO {
	

	

		//METODO C R U D
			
			public int criar(Pais pais) {
				String sqlInsert = "INSERT INTO pais(nomePais, populacaoPais, areaPais) VALUES (?, ?, ?)";
			
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setString(1, pais.getNome());
					stm.setLong(2, pais.getPopulacao());
					stm.setDouble(3, pais.getArea());
					stm.execute();
					String sqlQuery  = "SELECT LAST_INSERT_ID()";
					try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
						if(rs.next()){
							pais.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return pais.getId();
			}
			
			public void excluir(int id) {
				String sqlDelete = "DELETE FROM pais WHERE idPais = ?";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, id);
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void atualizar(Pais pais) {
				String sqlUpdate = "UPDATE pais SET nomePais=?, populacaoPais=?, areaPais=? WHERE idPais=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, pais.getNome());
					stm.setLong(2, pais.getPopulacao());
					stm.setDouble(3, pais.getArea());
					stm.setInt(4, pais.getId());
				stm.execute();
				} catch (Exception e) {
				e.printStackTrace();
				}
				}
			
			
			
			public Pais carregar(Pais pais) {
				String sqlSelect = "SELECT nomePais, populacaoPais, areaPais FROM pais WHERE pais.idPais = ?";
				
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, pais.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							pais.setNome(rs.getString("nomePais"));
							pais.setPopulacao(rs.getLong("populacaoPais"));
							pais.setArea(rs.getDouble("areaPais"));
						} else {
							pais.setId(-1);
							pais.setNome(null);
							/*setPopulacao(null);
							setArea(null);*/
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
			}
				return pais;
			}
			
			public void maiorPopulacao(Pais pais){
				String sqlSelect = "SELECT * FROM pais WHERE populacaoPais = (SELECT MAX(populacaoPais) FROM pais )";
				
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						ResultSet rs = stm.executeQuery();
					
						if (rs.next()) {
							pais.setNome(rs.getString("nomePais"));
							pais.setPopulacao(rs.getLong("populacaoPais"));
							
						} else {
							System.out.println("Deu pau");
						}
					
					} catch (SQLException e) {
						System.out.print(e);
					}
			}
			
			public void menorArea(Pais pais){
				String sqlSelect = "SELECT * FROM pais WHERE areaPais = (SELECT MIN(areaPais) FROM  pais)";
				
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
						ResultSet rs = stm.executeQuery();
					
						if (rs.next()) {
							pais.setNome(rs.getString("nomePais"));
							pais.setPopulacao(rs.getLong("populacaoPais"));
							
						} else {
							System.out.println("Deu pau");
						}
					
					} catch (SQLException e) {
						System.out.print(e);
					}
			}
			
			public String[] vetorTresPaises(Pais pais) {
				
				String sqlSelect = "SELECT nomePais FROM pais ORDER BY nomePais";
				String[] vet = new String[3];
				int j = 0 ;
				
				
				try (Connection conn = ConnectionFactory.obtemConexao();
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
		
		/*	@SuppressWarnings({ "rawtypes", "unchecked" })
			public ArrayList carregar(int id) {
			ArrayList retorno = new ArrayList();
			String sqlSelect = "SELECT nomePais, populacaoPais,areaPais FROM pais WHERE idPais= ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
			retorno.add(rs.getString("nomePais"));
			retorno.add(rs.getLong("populacaoPais"));
			retorno.add(rs.getDouble("areaPais"));
			} else {
			retorno.add(null);
			retorno.add(null);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			} return retorno;
			}*/
			
			
}
