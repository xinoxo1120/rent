package com.cloudSerenityHotel.dao.rent.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cloudSerenityHotel.base.BaseDao;
import com.cloudSerenityHotel.bean.rent.CarModelBean;

public class CarModelImpl extends BaseDao implements CarModelDao {

	private static final String SELECT_SQL = """
			SELECT
				car_id as carId,
				car_model as carModel,
				description as description,
				brand as brand,
				fuel_efficiency as fuelEfficiency,
				seating_capacity as seatingCapacity,
				total_vehicles as totalVehicles,
				available_vehicles as availableVehicles,
				created_at as createdAt,
				updated_at as updatedAt,
				car_type as carType,
				car_size as carSize
			FROM carmodel
			WHERE car_id = ?
			""";

	private static final String SELECT_SQLAll = """
			SELECT
				car_id as carId,
				car_model as carModel,
				description as description,
				brand as brand,
				fuel_efficiency as fuelEfficiency,
				seating_capacity as seatingCapacity,
				total_vehicles as totalVehicles,
				available_vehicles as availableVehicles,
				created_at as createdAt,
				updated_at as updatedAt,
				car_type as carType,
				car_size as carSize
			FROM carmodel
			""";

	private static final String INSERT_SQL = """

			INSERT INTO carmodel
				(
					car_model,
					description,
					brand,
					fuel_efficiency,
					seating_capacity,
					car_type,
					car_size,
					created_at,
					updated_at
				)
			VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";

	private static final String DELETE_SQL = """
			DELETE FROM carmodel
			WHERE car_id = ?
			""";

	private static final String UPDATE_SQL = """
			UPDATE carmodel
			SET
				description = ?,
				car_size = ?,
				updated_at = ?
			WHERE car_id = ?
			""";

	private static DataSource ds;
	static {
		try {
			Context context = new InitialContext();
			ds =  (DataSource) context.lookup("java:/comp/env/jdbc/csh");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		

	@Override
	public List<CarModelBean> getAllCarModel() {
		List <CarModelBean> carmodel = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carmodel = getForList(conn, SELECT_SQLAll, CarModelBean.class);
		return carmodel;
	}

	//新增車輛型號
	@Override
	public int insertCarModel(CarModelBean carModel) {
		try(Connection conn = ds.getConnection()) {
			return update(conn, INSERT_SQL, 
							carModel.getCarModel(),
							carModel.getDescription(),
							carModel.getBrand(),
							carModel.getFuelEfficiency(),
							carModel.getSeatingCapacity(),
							carModel.getCarType(),
							carModel.getCarSize(),
							carModel.getCreatedAt(),
							carModel.getUpdatedAt());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	
	@Override
	public int updateModel(String description, String carSize, Timestamp timestamp, int carId) {
		try(Connection conn = ds.getConnection()) {
			return update(conn, UPDATE_SQL, description, carSize, timestamp, carId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public int deleteModelById(int carId) {
		try(Connection conn = ds.getConnection()) {
			return update(conn, DELETE_SQL, carId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public CarModelBean CarselectModelOneById(int carId) {
		try (Connection conn = ds.getConnection()) {
			return getOne(conn, SELECT_SQL, CarModelBean.class, carId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
