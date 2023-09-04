package com.skv.hometask18.service;

import com.skv.hometask18.config.DataBaseConnectionConfig;
import com.skv.hometask18.domain.City;
import com.skv.hometask18.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public void save(Student student) throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSetForId = statement.executeQuery("select max(id) + 1 from students");
        boolean next = resultSetForId.next();
        int nextId = resultSetForId.getInt(1);

        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into students(id, first_name, second_name, isMan, city_id) values (?,?,?,?,?)");
        preparedStatement.setInt(1, nextId);
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getSecondName());
        preparedStatement.setBoolean(4, student.getMan());
        preparedStatement.setObject(5, (student.getCity() == null) ? null : student.getCity().getId());
        preparedStatement.execute();
    }

    public void deleteStudentById(Integer id) throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from students where  id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Student> findAll() throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        return createFromResultSet(resultSet);
    }

    private List<Student> createFromResultSet(ResultSet resultSet) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            boolean isMan = resultSet.getBoolean("isman");

            Student student = new Student(id, firstName, secondName, isMan);
            studentList.add(student);
        }
        return studentList;
    }

    public List<Student> findAllWithCities() throws SQLException {
        Connection connection = DataBaseConnectionConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students join cities c on students.city_id = c.id");
        return createFromResultSetWithCities(resultSet);
    }

    private List<Student> createFromResultSetWithCities(ResultSet resultSet) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            boolean isMan = resultSet.getBoolean("isman");
            int cityId = resultSet.getInt("city_id");
            String cityName = resultSet.getString("name");
            City city = new City(cityId, cityName);

            Student student = new Student(id, firstName, secondName, isMan, city);
            studentList.add(student);
        }
        return studentList;
    }
}
