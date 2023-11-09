package com.revature;

import java.sql.*;

public class ItemTableAccessor {

    // select item by id
    Item selectItemById(int id) {
        Item itemToReturn = new Item();

        // establish a connection within try
        try (Connection connection = PSQLConnectionUtility.getConnection();) {

            // create a statement
            Statement statement = connection.createStatement();

            // execute statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE id = " + id);

            // process results
            while(resultSet.next()) {
                itemToReturn.setId(resultSet.getInt("id"));
                itemToReturn.setName(resultSet.getString("name"));
                itemToReturn.setPrice(resultSet.getDouble("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemToReturn;
    }


    // add item
    boolean addItem(Item itemToAdd) {
        boolean isAdded = false;

        // declare our connection
        try(Connection connection = PSQLConnectionUtility.getConnection();) {

            // create statement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item(name, price) VALUES(?, ?)");
            preparedStatement.setString(1, itemToAdd.getName());
            preparedStatement.setDouble(2, itemToAdd.getPrice());

            // execute statement
            int rowsAffected = preparedStatement.executeUpdate();

            // process the results
            if (rowsAffected > 0) {
                isAdded = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAdded;
    }

}
