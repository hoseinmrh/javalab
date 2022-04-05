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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookList extends Files {
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

    public static int book_count = 0;
    public static ArrayList<String> nameL = new ArrayList<String>();
    public static ArrayList<String> authorL = new ArrayList<String>();
    public static ArrayList<Integer> book_idL = new ArrayList<Integer>();
    public static ArrayList<Integer> countL = new ArrayList<Integer>();

    public int getBook_count() {
        return book_count;
    }

    public void add_to_list(String name, String author, int count, int book_id){
        nameL.add(name);
        authorL.add(author);
        book_idL.add(book_id);
        countL.add(count);
        book_count++;
    }
    public int at(int book_id){
        for(int i = 0; i<book_count; i++){
            if (book_id == book_idL.get(i))
                return i;
        }
        return -1;
    }
    public int at(String book_name){
        for(int i =0;i<book_count;i++){
            if (book_name.equals(nameL.get(i)))
                return i;
        }
        return -1;
    }
    public void print(){
        VBox vbox = new VBox();
        for(int i = 0; i<book_count; i++){
            String data = ("Name= "+nameL.get(i)+ "\t\tAuthor= "+authorL.get(i)
                    + "\t\tnumber in stock= "+String.valueOf(countL.get(i))+
                    "\t\tBook id= "+String.valueOf(book_idL.get(i)));
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
        stage.setTitle("Book's list");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
    }
    public Label print(int i){
        String data = ("Name= "+nameL.get(i)+ "\t\tAuthor= "+authorL.get(i)
                + "\t\tnumber in stock= "+String.valueOf(countL.get(i))+
                "\t\tBook id= "+String.valueOf(book_idL.get(i)));
        Label l1 = new Label();
        l1.setText(data);
        label_style(l1);
        return l1;
    }
    public int count(int index){
        return countL.get(index);
    }
    public void set_count(int index){
        int current_count = countL.get(index);
        current_count = current_count - 1;
        countL.set(index, current_count );
        over_write();
    }
    public void over_write(){
        try {
            if(!books.exists()) {
                books.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(books.getName(),false);
            PrintWriter printWriter = new PrintWriter(fileWritter,false);
            printWriter.flush();
            printWriter.close();
            fileWritter.close();

        } catch(IOException e){
            e.printStackTrace();
        } //Clear file for rewrite

        for(int i =0; i<book_count;i++)
            writing_book(nameL.get(i),authorL.get(i),countL.get(i),book_idL.get(i));
    }
}
