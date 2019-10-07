package org.platter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.platter.dto.DishDTO;
import org.platter.utils.ConnectionHelper;

public class DishDAO {

	public List<DishDTO> findAll() {
		List<DishDTO> list = new ArrayList<DishDTO>();
		Connection c = null;
		String sql = "SELECT * FROM dish ORDER BY name";
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

	public List<DishDTO> findByName(String name) {
		List<DishDTO> list = new ArrayList<DishDTO>();
		Connection c = null;
		String sql = "SELECT * FROM dish as e " + "WHERE UPPER(name) LIKE ? " + "ORDER BY name";
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

	public DishDTO findById(String id) {
		String sql = "SELECT * FROM dish WHERE id = ?";
		DishDTO dish = null;
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dish = processRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return dish;
	}

	public DishDTO save(DishDTO dish) {
		return dish.getId() > 0 ? update(dish) : create(dish);
	}

	public DishDTO create(DishDTO dish) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(
					"INSERT INTO dish (name, category, country, region, description, picture) VALUES (?, ?, ?,?,?,?)");
			ps.setString(1, dish.getName());
			ps.setString(2, dish.getCategory());
			ps.setString(3, dish.getCountry());
			ps.setString(4, dish.getRegion());
			ps.setString(5, dish.getDescription());
			ps.setString(6, dish.getPicture());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return dish;
	}

	public DishDTO update(DishDTO dish) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE dish SET name=?, category=?, country=?, region=?, description=?, picture=? WHERE id=?");
			ps.setString(1, dish.getName());
			ps.setString(3, dish.getCategory());
			ps.setString(4, dish.getCountry());
			ps.setString(5, dish.getRegion());
			ps.setString(6, dish.getDescription());
			ps.setString(7, dish.getPicture());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return dish;
	}

	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM dish WHERE id=?");
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

	protected DishDTO processRow(ResultSet rs) throws SQLException {
		DishDTO dish = new DishDTO(rs.getInt("id"), rs.getString("name"), rs.getString("category"),
				rs.getString("country"), rs.getString("region"), rs.getString("description"), rs.getString("picture"));
		return dish;
	}

}
