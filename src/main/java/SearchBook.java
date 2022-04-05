import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SearchBook extends BookList{
    Stage stage = new Stage();
    public void label_styleE(Label label){
        Font font = Font.font("Berlin Sans FB",  17);
        label.setFont(font);
        label.setCursor(Cursor.DISAPPEAR);
        label.setStyle("-fx-text-fill: #B60909");

    }
    public static void play_sound(String filepath){
        InputStream music;

        try{
            music = new FileInputStream(new File(filepath));
            AudioStream audioStream = new AudioStream(music);
            AudioPlayer.player.start(audioStream);
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    ///////////SHOW MSG
    public void show_msg(String msg){
        Stage message = new Stage();
        Label l1 = new Label(msg);
        label_styleE(l1);
        Button b1 = new Button("Close");
        button_style(b1);

        b1.setOnAction(event -> {
            message.close();
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(l1,b1);
        vbox_style(vbox);

        Scene error = new Scene(vbox,300,100);
        message.setScene(error);
        message.setAlwaysOnTop(true);
        message.setResizable(false);
        message.show();
        play_sound("error.wav");


    }

    public void by_name(String name){
        int flag = 0;
        VBox vbox = new VBox();
        for(int i =0; i<book_count;i++){
            if (name.equals(nameL.get(i))){
                vbox.getChildren().add(print(i));
                flag = 1;
            }

        }
        if (flag == 0){
            show_msg("There is no book with this name!");
        }
        else{
            Button b1 = new Button("Close");
            b1.setOnAction(event -> {
                stage.close();
            });
            button_style(b1);
            vbox.getChildren().add(b1);
            vbox_style(vbox);
            Scene print_std = new Scene(vbox,650,650);
            stage.setScene(print_std);
            stage.setTitle("Search book by name");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.show();

        }

    }
    public void by_author(String author){
        int flag = 0;
        VBox vbox = new VBox();
        for(int i =0; i<book_count;i++){
            if (author.equals(authorL.get(i))){
                vbox.getChildren().add(print(i));
                flag = 1;
            }
        }
        if (flag == 0){
            show_msg("There is no book with this author!");
        }
        else{
            Button b1 = new Button("Close");
            b1.setOnAction(event -> {
                stage.close();
            });
            button_style(b1);
            vbox.getChildren().add(b1);
            vbox_style(vbox);
            Scene print_std = new Scene(vbox,650,650);
            stage.setScene(print_std);
            stage.setTitle("Search book by author");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.show();
        }
    }
    public void by_id(int book_id){
        int flag = 0;
        VBox vbox = new VBox();
        for(int i =0; i<book_count;i++){
            if (book_id == book_idL.get(i)){
                vbox.getChildren().add(print(i));
                flag = 1;
                break; //book id is unique
            }

        }
        if (flag == 0){
            show_msg("There is no book with this id!");
        }
        else{
            Button b1 = new Button("Close");
            b1.setOnAction(event -> {
                stage.close();
            });
            button_style(b1);
            vbox.getChildren().add(b1);
            vbox_style(vbox);
            Scene print_std = new Scene(vbox,650,650);
            stage.setScene(print_std);
            stage.setTitle("Search book by id");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.show();

        }

    }
}
