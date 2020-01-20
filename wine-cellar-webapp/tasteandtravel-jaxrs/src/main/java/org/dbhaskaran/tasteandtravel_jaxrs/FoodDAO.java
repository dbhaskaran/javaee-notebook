package org.dbhaskaran.tasteandtravel_jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Bhaskaran
 */
public class FoodDAO {

	public List<Food> findAll() {
		List<Food> list = new ArrayList<Food>();
		Connection c = null;
		String sql = "SELECT * FROM food ORDER BY name";
		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}

	public List<Food> findByName(String name) {
		List<Food> list = new ArrayList<Food>();
		Connection c = null;
		String sql = "SELECT * FROM food as e " + "WHERE UPPER(name) LIKE ? " + "ORDER BY name";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + name.toUpperCase() + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}

	public Food findById(int id) {
		String sql = "SELECT * FROM food WHERE id = ?";
		Food wine = null;
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				wine = processRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return wine;
	}

	public Food save(Food wine) {
		return wine.getId() > 0 ? update(wine) : create(wine);
	}

	public Food create(Food wine) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(
					"INSERT INTO food (name, category, country, rating, description, picture) VALUES (?, ?, ?, ?, ?, ?)",
					new String[] { "ID" });
			ps.setString(1, wine.getName());
			ps.setString(2, wine.getCategory());
			ps.setString(3, wine.getCountry());
			ps.setFloat(4, wine.getRating());
			ps.setString(5, wine.getDescription());
			ps.setString(6, wine.getPicture());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be
			// returned to the client.
			int id = rs.getInt(1);
			wine.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return wine;
	}

	public Food update(Food wine) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE wine SET name=?, category=?, country=?, rating=?, description=?, picture=? WHERE id=?");
			ps.setString(1, wine.getName());
			ps.setString(2, wine.getCategory());
			ps.setString(3, wine.getCountry());
			ps.setFloat(4, wine.getRating());
			ps.setString(5, wine.getDescription());
			ps.setString(6, wine.getPicture());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return wine;
	}

	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM wine WHERE id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
	}

	protected Food processRow(ResultSet rs) throws SQLException {
		Food wine = new Food();
		wine.setId(rs.getInt("id"));
		wine.setName(rs.getString("name"));
		wine.setCategory(rs.getString("category"));
		wine.setCountry(rs.getString("country"));
		wine.setRating(rs.getFloat("rating"));
		wine.setDescription(rs.getString("description"));
		wine.setPicture(rs.getString("picture"));
		return wine;
	}

}
