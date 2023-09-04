package com.skv.hometask18.service;

import com.skv.hometask18.config.DataBaseConnectionConfig;
import com.skv.hometask18.domain.City;

import java.sql.*;

public class CityService {
    public void save(City city) throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSetForId = statement.executeQuery("select max(id) + 1 from cities");
        boolean next = resultSetForId.next();
        int nextId = resultSetForId.getInt(1);

        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into cities(id, name) values (?,?)");
        preparedStatement.setInt(1, nextId);
        preparedStatement.setString(2, city.getName());
        preparedStatement.execute();
    }

    public City findCity(String name) throws Exception {
        Connection connection = DataBaseConnectionConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cities where name = ?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int resultId = resultSet.getInt(1);
            String cityName = resultSet.getString(2);
            return new City(resultId, cityName);
        } else{
            throw new Exception("This city " + name + " wasn't found");
        }
    }
    public void deleteCityById(Integer id) throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from cities where  id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

}
