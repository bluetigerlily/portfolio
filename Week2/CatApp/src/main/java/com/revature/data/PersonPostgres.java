package com.revature.data;

<<<<<<< HEAD
import java.beans.Statement;
=======
>>>>>>> 21ed6427d5de47694bab72e46cbd04bcc732accc
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.beans.Cat;
import com.revature.beans.Person;
<<<<<<< HEAD
import com.revature.beans.Role;
=======
>>>>>>> 21ed6427d5de47694bab72e46cbd04bcc732accc
import com.revature.exceptions.NonUniqueUsernameException;
import com.revature.utils.ConnectionUtil;

public class PersonPostgres implements PersonDAO {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private Logger log = Logger.getLogger(PersonPostgres.class);
	
<<<<<<< HEAD
	private PersonPostgres() {
		HashSet<Person> Persons = new HashSet<Person>();
	}
	@Override
	public Person getById(Integer id) throws Exception {
		
		Person newPerson = new Person();
		try (Connection conn = cu.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "select from person values (default, ?, ?, ?)";
			String[] keys = {"id"};
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			
	
			
			while (rs.next()) {
				
				newPerson.setId(rs.getInt("id"));
				newPerson.setUsername(rs.getString("username"));
				newPerson.setPassword(rs.getString("password"));
			} 
			
		} catch (Exception e) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			}
			e.printStackTrace();
		}
		
		return newPerson;
=======
	@Override
	public Person getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 21ed6427d5de47694bab72e46cbd04bcc732accc
	}

	@Override
	public Set<Person> getAll() {
<<<<<<< HEAD
		
		try (Connection conn = cu.getConnection()) {
		
			
			
			
		
	}

	@Override
		public void update(Person p) {
			try(Connection conn = cu.getConnection()){
				conn.setAutoCommit(false);
				String sql= "update person set username = ?, passwd = ?,user_role_id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, p.getUsername());
				pstmt.setString(2, p.getPassword());
				pstmt.setInt(3, p.getRole().getId());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}

		}



	@Override
	public void delete(Person t) throws Exception {
		
		try (Connection conn = cu.getConnection()) {
			conn.setAutoCommit(false);
		String sql = "delete from person where values (default, ?, ?, ?)";
		String[] keys = {"id"};
		PreparedStatement pstmt = conn.prepareStatement(sql, keys);
		pstmt.setString(1, t.getUsername());
		pstmt.setString(2, t.getPassword());
		pstmt.setInt(3, t.getRole().getId());
		
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		
		
		
		if (rs.next()) {
			t.setId(rs.getInt(1));
			t.setUsername(rs.getString(2));
			t.setPassword(rs.getString(3));
					conn.commit();
	} else {
		conn.rollback();
	}
	
} catch (Exception e) {
	if (e.getMessage().contains("violates unique constraint")) {
		throw new NonUniqueUsernameException();
	}
	e.printStackTrace();
			}

			return;
	}
	
		
		
		
=======
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person t) {
		// TODO Auto-generated method stub

	}
>>>>>>> 21ed6427d5de47694bab72e46cbd04bcc732accc

	@Override
	public Person add(Person p) throws NonUniqueUsernameException {
		Person newPerson = null;
		
		try (Connection conn = cu.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into person values (default, ?, ?, ?)";
			String[] keys = {"id"};
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, p.getUsername());
			pstmt.setString(2, p.getPassword());
			pstmt.setInt(3, p.getRole().getId());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				newPerson = p;
				newPerson.setId(rs.getInt(1));
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			if (e.getMessage().contains("violates unique constraint")) {
				throw new NonUniqueUsernameException();
			}
			e.printStackTrace();
		}
		
		return newPerson;
	}

	@Override
<<<<<<< HEAD
	public Person getByUsername(String username)  {
		// TODO Auto-generated method stub
		try {
			Connection conn = cu.getConnection();
			String sql = "select * from person where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			ResultSet rs = pstmt.executeQuery();
			Person pers =  new Person();
			   pers.setId(rs.getInt("id"));
			   pers.setUsername(rs.getString("username"));
			   Role role = new Role();
			   role.setId(rs.getInt("id"));
			   role.setName(rs.getString("name"));
			   pers.setRole(role);
			  
			   
			
			return pers;
		}catch(Exception e) {e.printStackTrace();}
	    return null;

}
		}
=======
	public Person getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Set<Cat> getCatsByPersonId(Integer id, Connection conn) throws SQLException {
		Set<Cat> cats = new HashSet<>();
		CatDAO catDao = new CatPostgres();
		
		String sql = "select * from person_cat where person_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Cat pet = catDao.getById(rs.getInt("cat_id"));
			cats.add(pet);
		}
		
		return cats;
	}

}
>>>>>>> 21ed6427d5de47694bab72e46cbd04bcc732accc
