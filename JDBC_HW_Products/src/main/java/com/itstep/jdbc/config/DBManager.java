package com.itstep.jdbc.config;

import com.itstep.jdbc.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String GET_ALL_QUERY = "Select * from productsdb.items";
    private static final String SET_NEW_ITEM_QUERY = "INSERT INTO productsdb.items(name, price) VALUES(?, ?)";
    private static final String DELETE_BY_ID_QUERY = "DELETE from productsdb.items WHERE ID = ?";

    public  void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery(); // ctrl+alt+v

            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAllItem(){
        List<Item> itemList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery(); // ctrl+alt+v
            while(resultSet.next()){
                Item item = new Item();
                item.setId( resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));

                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }
    // create
    public void setNewCar(Item item){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SET_NEW_ITEM_QUERY);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemById(Integer id){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
