package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			
			
			
			public Pais carregar(int id) {
				
				Pais pais = new Pais();
				pais.setId(id);
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
							/*pais.setPopulacao(0);
							pais.setArea(0);*/
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
				try {
					
					String sqlQuery =  "Select * from pais where populacaoPais = (Select Max(populacaoPais) from pais)";
					Connection conn  = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlQuery);
					
					ResultSet rs = stm.executeQuery();
					
					if(rs.next()) {
						pais.setId(rs.getInt("idPais"));
						pais.setNome(rs.getString("nomePais"));
						pais.setArea(rs.getDouble("areaPais"));
						pais.setPopulacao(rs.getLong("populacaoPais"));
					}
					
					}catch(SQLException e) {
						
						System.out.println(e);
					}
					
			}
			
			public void menorArea(Pais pais){
				try {
					String sqlQuery = "Select * from pais where areaPais = (Select Min(areaPais) from pais)";
					Connection conn  = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlQuery);
					
					
					ResultSet rs = stm.executeQuery();
					
					if(rs.next()) {
						pais.setId(rs.getInt("idPais"));
						pais.setNome(rs.getString("nomePais"));
						pais.setArea(rs.getDouble("areaPais"));
						pais.setPopulacao(rs.getLong("populacaoPais"));
					}
					
					}catch(SQLException e) {
						
						System.out.println(e);
					}
			}
			
			public String[] vetorTresPaises() {
				
				String[] vet = new String[3];
				int cont = 0;
				
				try {
				String sqlQuery = "SELECT nomePais FROM pais ORDER BY nomePais";
				Connection conn = ConnectionFactory.obtemConexao();
				
				PreparedStatement stm = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm.executeQuery();
				
				while(rs.next() && cont < 3) {
					vet[cont] = rs.getString("nomePais");
					cont++;
				}
				
				}catch(SQLException e) {
					System.out.println(e);
				}
				
				return vet;
			
			}
			
			public ArrayList<Pais> listarPaises() {
				Pais pais;
				ArrayList<Pais> lista = new ArrayList<>();
				String sqlSelect = "SELECT idPais, nomePais, populacaoPais, areaPais FROM pais";
			
				try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
				pais = new Pais();
				pais.setId(rs.getInt("idPais"));
				pais.setNome(rs.getString("nomePais"));
				pais.setPopulacao(rs.getLong("populacaoPais"));
				pais.setArea(rs.getDouble("areaPais"));
				lista.add(pais);
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				}
				return lista;
				}
			
			
			public ArrayList<Pais> listarPais(String chave) {
				Pais pais;
				ArrayList<Pais> lista = new ArrayList<>();
				String sqlSelect = "SELECT idPais, nomePais, populacaoPais, areaPais FROM pais where upper(nomePais) like ?";
				
				try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					pais = new Pais();
					pais.setId(rs.getInt("idPais"));
					pais.setNome(rs.getString("nomePais"));
					pais.setPopulacao(rs.getLong("populacaoPais"));
					pais.setArea(rs.getDouble("areaPais"));
					lista.add(pais);
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
				}
				return lista;
				}

}	
		
			
			

