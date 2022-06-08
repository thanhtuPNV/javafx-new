//package com.example.pnvproject;
//
//import com.example.pnvproject.dataa.DBConnect;
//import com.example.pnvproject.models.Student;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//import java.util.ArrayList;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.stage.StageStyle;
//import java.sql.*;
//
//public class StudentApplication extends Application {
//
//    private Scene scene;
//    private static final String EMPTY = "";
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setVgap(10);
//        grid.setHgap(10);
//        DBConnect DB = new DBConnect();
//        ArrayList<Student> stdList = DB.getStudents();
////        DB.insertStudent(new Student("hue",9));
////        DB.updateStudent(new Student(1,"tu",10));
////        DB.deleteStudent(1);
////        DB.getStudents();
//
//        grid.add(new Label("Name:"), 1, 0);
//        var tfName = new TextField();
//        grid.add(tfName, 1, 1);
//        //
//        grid.add(new Label("Score:"), 2, 0);
//        var tfScore = new TextField();
//        grid.add(tfScore, 2, 1);
//
//        // add
//        var btnAdd = new Button("Add");
//        btnAdd.setPadding(new Insets(5, 15, 5, 15));
//        btnAdd.setOnAction(e -> {
//            String name = tfName.getText();
//            Float score = Float.valueOf(tfScore.getText());
//            if (!name.equals(EMPTY) && !score.equals(EMPTY)) {
//                DB.insertStudent(new Student(name, score));
//                try {
//                    start(stage);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                return;
//            }
//            var alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("Please fill all blank!");
//            alert.showAndWait();
//        });
//        grid.add(btnAdd, 4, 1);
//
//        //show
//        for(int i = 0; i < stdList.size(); i++){
//            grid.add(new Label (stdList.get(i).getName()), 1, i+2);
//            grid.add(new Label (String.valueOf(stdList.get(i).getScore())), 2, i+2);
//
//            // Update
//            var btnUpdate = new Button("Update");
//            btnUpdate.setId(String.valueOf(i));
//            btnUpdate.setOnAction(e -> {
//                btnAdd.setVisible(false);
//                int id1 = Integer.parseInt(btnUpdate.getId());
//                TextField tfname = (TextField) grid.getChildren().get(1);
//                System.out.println(btnUpdate.getId());
//                tfname.setText("" + stdList.get(id1).getName());
////                name.setText(stdList.get(Integer.parseInt(btnUpdate.getId())).getName());
//                TextField tfscore = (TextField) grid.getChildren().get(3);
//                tfscore.setText("" + stdList.get(id1).getScore());
//                var newbtnAdd = new Button("Update");
//                newbtnAdd.setPadding(new Insets(5, 15, 5, 15));
//                newbtnAdd.setOnAction(newe -> {
//                    Integer Newid = stdList.get(id1).id;
//                    String Newname = tfname.getText();
//                    Float Newscore = Float.valueOf(tfscore.getText());
//                    if (!Newname.equals(EMPTY) && !Newscore.equals(EMPTY)) {
//                        DB.updateStudent(new Student(Newid, Newname,Newscore));
//                        try {
//                            start(stage);
//                        } catch (Exception ex) {
//                            throw new RuntimeException(ex);
//                        }
//                        return;
//                    }
//                    var alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setHeaderText(null);
//                    alert.setContentText("Please fill all blank!");
//                    alert.showAndWait();
//                });
//                grid.add(newbtnAdd, 4, 1);
//            });
//            grid.add(btnUpdate, 4, i+2);
//
//            // Delete
//            var btnDelete = new Button("Delete");
//            btnDelete.setId(String.valueOf(stdList.get(i).id));
//            btnDelete.setOnAction(e -> {
//                int id3 = Integer.parseInt(btnDelete.getId());
//                DB.deleteStudent(id3);
//                var alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText(null);
//                alert.setContentText("Deleted!");
//                alert.showAndWait();
//                try {
//                    start(stage);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//            });
//            grid.add(btnDelete, 5, i+2);
//        }
//
//        scene = new Scene(grid, 1500, 800);
//        stage.setTitle("Student");
//        stage.setScene(scene);
//        stage.show();
//    }
//}
