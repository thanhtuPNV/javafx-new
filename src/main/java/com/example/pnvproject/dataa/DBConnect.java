package com.example.pnvproject.dataa;

import com.example.pnvproject.models.Painting;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
    private Connection connection;

    public static final String URL = "jdbc:mysql://localhost/tujavafx";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public DBConnect(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Painting> getPaintings(){
        ArrayList<Painting> list = new ArrayList<>();
        String sql = "SELECT * FROM painting";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
//                System.out.println(results.getInt("id"));
//                System.out.println(results.getString("name"));
//                System.out.println(results.getFloat("score"));
                Painting painting = new Painting(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getString("image"),
                        results.getInt("price"),
                        results.getString("description")
                );
                list.add(painting);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertPainting(Painting painting){
        String sql = "INSERT INTO painting (name, image, price, description) VALUE ('"+painting.name+"','"+painting.image+"','"+painting.price+"','"+painting.description+"')";
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePainting(Painting painting){
        String sql = "UPDATE painting SET name = '"+ painting.name +"', image = '"+painting.image+"', price = '"+painting.price+"', description = '"+painting.description+"' WHERE id = "+ painting.id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePainting(int id){
        String sql = "DELETE FROM painting WHERE id = "+ id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
