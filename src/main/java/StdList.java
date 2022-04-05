import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class StdList extends Files {
    Stage stage = new Stage();

    public void vbox_style(VBox vbox){
        Image image = new Image("file:backgroundB.jpg");
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);
        vbox.setBackground(background);
    }
    public void button_style(Button button){
        DropShadow shadow = new DropShadow();
        Font font = Font.font("Berlin Sans FB",  15);
        button.setFont(font);
        button.setEffect(shadow);
        button.setCursor(Cursor.HAND);
        button.setStyle("-fx-background-color: #D1ECF2; -fx-text-fill: #FE0101");
    }
    public void label_style(Label label){
        Font font = Font.font("Berlin Sans FB",  15);
        label.setFont(font);
        label.setCursor(Cursor.DISAPPEAR);
        label.setStyle("-fx-text-fill: #000000");
    }

    public static int std_count = 0;
    public static ArrayList<String> nameL = new ArrayList<String>();
    public static ArrayList<String> lastnameL = new ArrayList<String>();
    public static ArrayList<String> majorL = new ArrayList<String>();
    public static ArrayList<Integer> std_idL = new ArrayList<Integer>();

    public void add_to_list(String name, String lastname, String major, int id){
        nameL.add(name);
        lastnameL.add(lastname);
        majorL.add(major);
        std_idL.add(id);
        std_count++;
    }
    public int at(int std_id){
        for(int i = 0; i<std_count; i++){
            if (std_id == std_idL.get(i))
                return i;
        }
        return -1;
    }
    public void print(){
        VBox vbox = new VBox();
        for(int i = 0; i<std_count; i++){
            String data = ("Name= "+nameL.get(i)+ "\t\tLast name= "+lastnameL.get(i)
                    + "\t\tmajor= "+majorL.get(i)+ "\t\tStudent number= "+String.valueOf(std_idL.get(i)));
            Label l1 = new Label();
            l1.setText(data);
            label_style(l1);
            vbox.getChildren().add(l1);
        }
        Button b1 = new Button("Close");
        b1.setOnAction(event -> {
            stage.close();
        });
        button_style(b1);
        vbox.getChildren().add(b1);
        vbox_style(vbox);
        Scene print_std = new Scene(vbox,650,650);
        stage.setScene(print_std);
        stage.setTitle("Student's list");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();

    }
    public Label print(int i){
        String data = ("Name= "+nameL.get(i)+ "\t\tLast name= "+lastnameL.get(i)
                + "\t\tmajor= "+majorL.get(i)+ "\t\tStudent number= "+String.valueOf(std_idL.get(i)));
        Label l1 = new Label();
        l1.setText(data);
        label_style(l1);
        return l1;
    }
    public int getCount(){
        return std_count;
    }
    public void over_write(){
        try {
            if(!students.exists()) {
                students.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(students.getName(),false);
            PrintWriter printWriter = new PrintWriter(fileWritter,false);
            printWriter.flush();
            printWriter.close();
            fileWritter.close();

        } catch(IOException e){
            e.printStackTrace();
        } //Clear file for rewrite

        for(int i =0; i<std_count;i++)
            writing_std(nameL.get(i),lastnameL.get(i),majorL.get(i),std_idL.get(i));
    }

}
