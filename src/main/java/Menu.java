

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Menu {
    Stage base = new Stage();
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

    public void vbox_style(VBox vbox){
        Image image = new Image("file:background.jpg");
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
        Font font = Font.font("Berlin Sans FB",  17);
        label.setFont(font);
        label.setCursor(Cursor.DISAPPEAR);
        label.setStyle("-fx-text-fill: #002D79");

    }
    public void label_styleE(Label label){
        Font font = Font.font("Berlin Sans FB",  17);
        label.setFont(font);
        label.setCursor(Cursor.DISAPPEAR);
        label.setStyle("-fx-text-fill: #B60909");

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

    ///////////ADD STUDENT FUNCTIONS
    public void add_std_click(){
        Label l1 = new Label("Name: ");
        TextField name = new TextField();
        HBox hb_name = new HBox(l1, name);
        hb_name.setSpacing(5);

        Label l2 = new Label("Last name: ");
        TextField lastname = new TextField();
        HBox hb_lname = new HBox(l2, lastname);
        hb_lname.setSpacing(5);

        Label l3 = new Label("Major: ");
        TextField major = new TextField();
        HBox hb_major = new HBox(l3, major);
        hb_major.setSpacing(5);

        Label l4 = new Label("Student number: ");
        TextField std_num = new TextField();
        HBox hb_std = new HBox(l4, std_num);
        hb_std.setSpacing(5);

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(hb_name,hb_lname,hb_major,hb_std);
        vbox1.setSpacing(15);
        vbox1.setAlignment(Pos.CENTER);
        Button b1 = new Button("Add");

        b1.setOnAction(event -> {
            String nameB = name.getText();
            String lastnameB = lastname.getText();
            String majorB = major.getText();
            int std_numB = Integer.parseInt(std_num.getText());
            Student s = new Student(nameB, lastnameB,majorB,std_numB);
            name.setText("");
            lastname.setText("");
            major.setText("");
            std_num.setText("");
            show_msg("Student added to file successfully!");
        });

        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);
        label_style(l2);
        label_style(l3);
        label_style(l4);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(vbox1,b1,b2,b3);
        vbox_style(vbox);
        Scene add_std = new Scene(vbox,400,400);
        base.setTitle("Add student");
        base.setScene(add_std);
        base.show();
    }
    public void print_std_click(){
        StdList slist = new StdList();
        slist.print();
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> show_menu());

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });

        button_style(b2);
        button_style(b3);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(b2,b3);
        vbox_style(vbox);
        Scene print_std = new Scene(vbox,400,400);
        base.setTitle("List of students");
        base.setScene(print_std);
        base.show();

    }
    public void add_std(){

        Label msg = new Label("Choose one of the followings!");
        Button b1 = new Button("1)Add new student");
        b1.setCursor(Cursor.HAND);
        Button b2 = new Button("2)See list of students");
        b2.setCursor(Cursor.HAND);

        msg.setAlignment(Pos.CENTER);
        b1.setAlignment(Pos.CENTER_LEFT);
        b2.setAlignment(Pos.CENTER_LEFT);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(msg,b1,b2);
        vbox_style(vbox);

        b1.setOnAction(event -> {
            add_std_click();
        });

        b2.setOnAction(event -> {
            print_std_click();
        });
        button_style(b1);
        button_style(b2);
        label_style(msg);


        Scene add_std = new Scene(vbox,400,400);
        base.setScene(add_std);
        base.setTitle("Add student");
        base.show();
    }

    ///////////ADD BOOK FUNCTIONS
    public void add_book_click(){
        Label l1 = new Label("Name: ");
        TextField name = new TextField();
        HBox hb_name = new HBox(l1, name);
        hb_name.setSpacing(5);

        Label l2 = new Label("Author: ");
        TextField author = new TextField();
        HBox hb_author = new HBox(l2, author);
        hb_author.setSpacing(5);

        Label l3 = new Label("Count: ");
        TextField count = new TextField();
        HBox hb_count = new HBox(l3, count);
        hb_count.setSpacing(5);

        Label l4 = new Label("Book id: ");
        TextField book_id = new TextField();
        HBox hb_id = new HBox(l4, book_id);
        hb_id.setSpacing(5);

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(hb_name,hb_author,hb_count,hb_id);
        vbox1.setSpacing(15);
        vbox1.setAlignment(Pos.CENTER);
        Button b1 = new Button("Add");

        b1.setOnAction(event -> {
            String nameB = name.getText();
            String authorB = author.getText();
            int book_idB = Integer.parseInt(book_id.getText());
            int countB =  Integer.parseInt(count.getText());
            Book b = new Book(nameB,authorB,countB,book_idB);
            name.setText("");
            author.setText("");
            count.setText("");
            book_id.setText("");
            show_msg("Book added to file successfully!");
        });

        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);
        label_style(l2);
        label_style(l3);
        label_style(l4);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(vbox1,b1,b2,b3);
        vbox.setAlignment(Pos.CENTER);
        vbox_style(vbox);
        Scene add_book = new Scene(vbox,400,400);
        base.setTitle("Add book");
        base.setScene(add_book);
        base.show();
    }
    public void print_book_click(){
        BookList blist = new BookList();
        blist.print();
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });

        button_style(b2);
        button_style(b3);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(b2,b3);
        vbox.setAlignment(Pos.CENTER);
        vbox_style(vbox);
        Scene print_book = new Scene(vbox,400,400);
        base.setTitle("List of books");
        base.setScene(print_book);
        base.show();
    }
    public void add_book(){
        Label msg = new Label("Choose one of the followings!");
        Button b1 = new Button("1)Add new books");
        b1.setCursor(Cursor.HAND);
        Button b2 = new Button("2)See list of books");
        b2.setCursor(Cursor.HAND);

        msg.setAlignment(Pos.CENTER);
        b1.setAlignment(Pos.CENTER_LEFT);
        b2.setAlignment(Pos.CENTER_LEFT);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(msg,b1,b2);
        vbox_style(vbox);

        b1.setOnAction(event -> {
            add_book_click();
        });

        b2.setOnAction(event -> {
            print_book_click();
        });
        button_style(b1);
        button_style(b2);
        label_style(msg);


        Scene add_std = new Scene(vbox,400,400);
        base.setScene(add_std);
        base.setTitle("Add Book");
        base.show();

    }

    ///////////EDIT STUDENT FUNCTIONS
    public void edit_std_name(int index){
        EditStd editStd = new EditStd();
        Label l1 = new Label("Enter new name!");
        TextField name = new TextField();
        Button b1 = new Button("Edit");

        b1.setOnAction(event -> {
            String new_name = name.getText();
            editStd.edit_name(new_name,index);
            name.setText("");
            show_msg("Student's name changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);


        VBox vbox = new VBox(l1,name,b1,b2,b3);
        vbox_style(vbox);

        Scene edit_name = new Scene(vbox,400,400);
        base.setTitle("Edit student name:");
        base.setScene(edit_name);
        base.show();
    }
    public void edit_std_lastname(int index){
        EditStd editStd = new EditStd();
        Label l1 = new Label("Enter new last name!");
        TextField lastname = new TextField();
        Button b1 = new Button("Edit");
        b1.setOnAction(event -> {
            String new_lastname = lastname.getText();
            editStd.edit_lastname(new_lastname,index);
            lastname.setText("");
            show_msg("Student's last name changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);


        VBox vbox = new VBox(l1,lastname,b1,b2,b3);
        vbox_style(vbox);
        Scene edit_last = new Scene(vbox,400,400);
        base.setTitle("Edit student last name:");
        base.setScene(edit_last);
        base.show();
    }
    public void edit_std_major(int index){
        EditStd editStd = new EditStd();
        Label l1 = new Label("Enter new major!");
        TextField major = new TextField();
        Button b1 = new Button("Edit");
        b1.setOnAction(event -> {
            String new_major= major.getText();
            editStd.edit_major(new_major,index);
            major.setText("");
            show_msg("Student's major changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);


        VBox vbox = new VBox(l1,major,b1,b2,b3);
        vbox_style(vbox);
        Scene edit_major = new Scene(vbox,400,400);
        base.setTitle("Edit student major:");
        base.setScene(edit_major);
        base.show();
    }
    public void edit_std_option(int ret, int index){
        if (ret == 0){
            Label l1 = new Label("Choose one of the options:");
            Button b1 = new Button("1)Edit name");
            Button b2 = new Button("2)Edit last name");
            Button b3 = new Button("3)Edit major");


            b1.setOnAction(event -> {
                edit_std_name(index);
            });
            b2.setOnAction(event -> {
                edit_std_lastname(index);
            });
            b3.setOnAction(event -> {
                edit_std_major(index);
            });
            button_style(b1);
            button_style(b2);
            button_style(b3);
            label_style(l1);

            VBox vbox1 = new VBox();
            vbox1.getChildren().addAll(l1,b1,b2,b3);
            vbox_style(vbox1);
            Scene show_edit_std = new Scene(vbox1,400,400);
            base.setScene(show_edit_std);
            base.setTitle("Edit student");
            base.show();
        }
        else{
            show_msg("There is no student with this student number!");
        }
    }
    public void edit_std(){
        EditStd editStd = new EditStd();
        Label msg = new Label("Enter student number to edit.");
        TextField std_number = new TextField();
        Button b1 = new Button("Search for student");
        VBox vbox = new VBox();
        b1.setOnAction(event -> {
            int std_id = Integer.parseInt(std_number.getText());
            int ret = editStd.permission(std_id);
            int index = editStd.at(std_id);
            edit_std_option(ret, index);
        });
        button_style(b1);
        label_style(msg);


        vbox.getChildren().addAll(msg,std_number,b1);
        vbox_style(vbox);
        Scene editstd = new Scene(vbox,400,400);
        base.setScene(editstd);
        base.setTitle("Edit student");
        base.show();

    }

    ///////////EDIT BOOK FUNCTIONS
    public void edit_book_name(int index){
        EditBook editBook = new EditBook();
        Label l1 = new Label("Enter new name!");
        TextField name = new TextField();
        Button b1 = new Button("Edit");

        b1.setOnAction(event -> {
            String new_name = name.getText();
            editBook.edit_name(new_name,index);
            name.setText("");
            show_msg("Book's name changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);

        VBox vbox = new VBox(l1,name,b1,b2,b3);
        vbox_style(vbox);

        Scene edit_name = new Scene(vbox,400,400);
        base.setTitle("Edit book name:");
        base.setScene(edit_name);
        base.show();
    }
    public void edit_book_author(int index){
        EditBook editBook = new EditBook();
        Label l1 = new Label("Enter new author!");
        TextField author = new TextField();
        Button b1 = new Button("Edit");

        b1.setOnAction(event -> {
            String new_author = author.getText();
            editBook.edit_author(new_author,index);
            author.setText("");
            show_msg("Book's author changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);


        VBox vbox = new VBox(l1,author,b1,b2,b3);
        vbox_style(vbox);

        Scene edit_author = new Scene(vbox,400,400);
        base.setTitle("Edit book's author:");
        base.setScene(edit_author);
        base.show();
    }
    public void edit_book_count(int index){
        EditBook editBook = new EditBook();
        Label l1 = new Label("Enter new name!");
        TextField count = new TextField();
        Button b1 = new Button("Edit");

        b1.setOnAction(event -> {
            int new_count = Integer.parseInt(count.getText());
            editBook.edit_count(new_count,index);
            count.setText("");
            show_msg("Book's number changed successfully!");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);


        VBox vbox = new VBox(l1,count,b1,b2,b3);
        vbox_style(vbox);

        Scene edit_count = new Scene(vbox,400,400);
        base.setTitle("Edit book's count:");
        base.setScene(edit_count);
        base.show();
    }
    public void edit_book_option(int ret, int index){
        if (ret == 0){
            Label l1 = new Label("Choose one of the options:");
            Button b1 = new Button("1)Edit name");
            Button b2 = new Button("2)Edit Author");
            Button b3 = new Button("3)Edit count");

            b1.setOnAction(event -> {
                edit_book_name(index);
            });
            b2.setOnAction(event -> {
                edit_book_author(index);
            });
            b3.setOnAction(event -> {
                edit_book_count(index);
            });
            button_style(b1);
            button_style(b2);
            button_style(b3);
            label_style(l1);

            VBox vbox1 = new VBox();
            vbox1.getChildren().addAll(l1,b1,b2,b3);
            vbox_style(vbox1);
            Scene show_edit_book = new Scene(vbox1,400,400);
            base.setScene(show_edit_book);
            base.setTitle("Edit book");
            base.show();
        }
        else{
            show_msg("There is no book with this book id!");
        }
    }
    public void edit_book(){
        EditBook editBook = new EditBook();
        Label msg = new Label("Enter book id to edit.");
        TextField book_number = new TextField();
        Button b1 = new Button("Search for book");
        VBox vbox = new VBox();
        b1.setOnAction(event -> {
            int book_id = Integer.parseInt(book_number.getText());
            int ret = editBook.permission(book_id);
            int index = editBook.at(book_id);
            edit_book_option(ret, index);
        });
        button_style(b1);
        label_style(msg);


        vbox.getChildren().addAll(msg,book_number,b1);
        vbox_style(vbox);
        Scene editbook = new Scene(vbox,400,400);
        base.setScene(editbook);
        base.setTitle("Edit book");
        base.show();
    }

    ///////////Search Functions
    public void std_by_name(){
        SearchStd searchStd = new SearchStd();
        Label l1 = new Label("Enter student's name!");
        TextField name = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);


        b1.setOnAction(event -> {
            String std_name = name.getText();
            searchStd.by_name(std_name);
            name.setText("");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);

        VBox vbox = new VBox(l1,name,b1,b2,b3);
        vbox_style(vbox);

        Scene search_name = new Scene(vbox,400,400);
        base.setTitle("Search by student's name:");
        base.setScene(search_name);
        base.show();

    }
    public void std_by_last(){
        SearchStd searchStd = new SearchStd();
        Label l1 = new Label("Enter student's last name!");
        TextField last_name = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);


        b1.setOnAction(event -> {
            String std_lname = last_name.getText();
            searchStd.by_lastname(std_lname);
            last_name.setText("");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);

        VBox vbox = new VBox(l1,last_name,b1,b2,b3);
        vbox_style(vbox);

        Scene search_last = new Scene(vbox,400,400);
        base.setTitle("Search by student's last name:");
        base.setScene(search_last);
        base.show();
    }
    public void std_by_major(){
        SearchStd searchStd = new SearchStd();
        Label l1 = new Label("Enter student's major!");
        TextField major = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);


        b1.setOnAction(event -> {
            String std_major = major.getText();
            searchStd.by_major(std_major);
            major.setText("");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);


        VBox vbox = new VBox(l1,major,b1,b2,b3);
        vbox_style(vbox);

        Scene search_major = new Scene(vbox,400,400);
        base.setTitle("Search by student's major:");
        base.setScene(search_major);
        base.show();
    }
    public void std_by_id(){
        SearchStd searchStd = new SearchStd();
        Label l1 = new Label("Enter student's number!");
        TextField std_id = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);


        b1.setOnAction(event -> {
            int std_num = Integer.parseInt(std_id.getText());
            searchStd.by_id(std_num);
            std_id.setText("");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);


        VBox vbox = new VBox(l1,std_id,b1,b2,b3);
        vbox_style(vbox);

        Scene search_id = new Scene(vbox,400,400);
        base.setTitle("Search by student's number:");
        base.setScene(search_id);
        base.show();
    }
    public void search_std(){
        Label l1 = new Label("Choose one of the options:");
        Button b1 = new Button("1)Search by name");
        Button b2 = new Button("2)Search by last name");
        Button b3 = new Button("3)Search by major");
        Button b4 = new Button("4)Search by student number");
        button_style(b1);
        button_style(b2);
        button_style(b3);
        button_style(b4);
        label_style(l1);
        b1.setOnAction(event -> {
            std_by_name();

        });
        b2.setOnAction(event -> {
            std_by_last();
        });
        b3.setOnAction(event -> {
            std_by_major();
        });
        b4.setOnAction(event -> {
            std_by_id();
        });

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(l1,b1,b2,b3,b4);
        vbox_style(vbox1);
        Scene show_edit_book = new Scene(vbox1,400,400);
        base.setScene(show_edit_book);
        base.setTitle("Edit student");
        base.show();
    }
    public void book_by_name(){
        SearchBook searchBook = new SearchBook();
        Label l1 = new Label("Enter book name!");
        TextField name = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);

        b1.setOnAction(event -> {
            String book_name = name.getText();
            searchBook.by_name(book_name);
            name.setText("");
        });
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);


        VBox vbox = new VBox(l1,name,b1,b2,b3);
        vbox_style(vbox);

        Scene search_name = new Scene(vbox,400,400);
        base.setTitle("Search by book's name:");
        base.setScene(search_name);
        base.show();
    }
    public void book_by_author(){
        SearchBook searchBook = new SearchBook();
        Label l1 = new Label("Enter book's author!");
        TextField author = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);

        b1.setOnAction(event -> {
            String book_author = author.getText();
            searchBook.by_author(book_author);
            author.setText("");
        });

        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);

        VBox vbox = new VBox(l1,author,b1,b2,b3);
        vbox_style(vbox);

        Scene search_author = new Scene(vbox,400,400);
        base.setTitle("Search by book's author:");
        base.setScene(search_author);
        base.show();
    }
    public void book_by_id(){
        SearchBook searchBook = new SearchBook();
        Label l1 = new Label("Enter book's id!");
        TextField book_id = new TextField();
        Button b1 = new Button("Search");
        label_style(l1);


        b1.setOnAction(event -> {
            int bookid = Integer.parseInt(book_id.getText());
            searchBook.by_id(bookid);
            book_id.setText("");
        });

        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });
        button_style(b1);
        button_style(b2);
        button_style(b3);


        VBox vbox = new VBox(l1,book_id,b1,b2,b3);
        vbox_style(vbox);

        Scene search_id = new Scene(vbox,400,400);
        base.setTitle("Search by book's id:");
        base.setScene(search_id);
        base.show();
    }
    public void search_book(){
        Label l1 = new Label("Choose one of the options:");
        Button b1 = new Button("1)Search by name");
        Button b2 = new Button("2)Search by author");
        Button b3 = new Button("3)Search by id");
        button_style(b1);
        button_style(b2);
        button_style(b3);
        label_style(l1);

        b1.setOnAction(event -> {
            book_by_name();

        });
        b2.setOnAction(event -> {
            book_by_author();
        });
        b3.setOnAction(event -> {
            book_by_id();
        });
        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(l1,b1,b2,b3);
        vbox_style(vbox1);
        Scene show_edit_book = new Scene(vbox1,400,400);
        base.setScene(show_edit_book);
        base.setTitle("Edit book");
        base.show();
    }
    public void search(){
        Label msg = new Label("Choose one of the followings!");
        Button b1 = new Button("1)Search for students");
        b1.setCursor(Cursor.HAND);
        Button b2 = new Button("2)Search for books");
        b2.setCursor(Cursor.HAND);

        msg.setAlignment(Pos.CENTER);
        b1.setAlignment(Pos.CENTER_LEFT);
        b2.setAlignment(Pos.CENTER_LEFT);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(msg,b1,b2);
        vbox_style(vbox);
        button_style(b1);
        button_style(b2);
        label_style(msg);



        b1.setOnAction(event -> {
            search_std();
        });

        b2.setOnAction(event -> {
            search_book();
        });
        Scene searching = new Scene(vbox,400,400);
        base.setScene(searching);
        base.setTitle("Search");
        base.show();

    }

    ////Library Functions
    public void lib_form_date(int index, int std_id, String bname){
        Library library = new Library(0);
        if (index > -1){
            Label msg = new Label("Book's name is valid!");
            if (library.book_count(index)>0){
                Label msg2 = new Label("Enter month:");
                Label msg3 = new Label("Enter day:");
                TextField bmonth = new TextField();
                TextField bday = new TextField();
                Button b1 = new Button("Apply");
                b1.setOnAction(event -> {
                    int day = Integer.parseInt(bday.getText());
                    int month = Integer.parseInt(bmonth.getText());
                    Library l = new Library(std_id,bname,month,day);
                    library.reduce_book_count(index);
                    bday.setText("");
                    bmonth.setText("");
                    show_msg("Book taken successfully!");
                });
                VBox vbox = new VBox();
                Button b2 = new Button("Back to menu");
                b2.setOnAction(event -> {
                    show_menu();
                });

                Button b3 = new Button("Exit");
                b3.setOnAction(event -> {
                    base.close();
                });
                button_style(b1);
                button_style(b2);
                button_style(b3);
                label_style(msg);
                label_style(msg2);
                label_style(msg3);

                vbox.getChildren().addAll(msg,msg2,bmonth,msg3,bday,b1,b2,b3);
                vbox_style(vbox);
                Scene lib = new Scene(vbox,400,400);
                base.setScene(lib);
                base.setTitle("Library");
                base.show();
            }
            else{
                show_msg("Book is out of stock!");
            }
        }
        else{
            show_msg("Book name not valid!");
        }
    }
    public void lib_form_name(int index, int std_id){
        if (index > -1){
            Library library = new Library(0);
            Label msg = new Label("Student's number is valid!");
            Label msg2 = new Label("Enter book's name:");
            TextField book_name = new TextField();
            Button b1 = new Button("Search for book's name");
            button_style(b1);
            label_style(msg);
            label_style(msg2);

            b1.setOnAction(event -> {
                String bname = book_name.getText();
                int index_bn = library.check_name(bname);
                lib_form_date(index_bn,std_id,bname);
                book_name.setText("");

            });
            Button b2 = new Button("Back to menu");
            b2.setOnAction(event -> {
                show_menu();
            });

            Button b3 = new Button("Exit");
            b3.setOnAction(event -> {
                base.close();
            });

            button_style(b2);
            button_style(b3);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(msg,msg2,book_name,b1,b2,b3);
            vbox_style(vbox);
            Scene lib = new Scene(vbox,400,400);
            base.setScene(lib);
            base.setTitle("Library");
            base.show();
        }
        else{
            show_msg("Student number is invalid!");
        }
    }
    public void get_book(){
        Library library = new Library(0);
        Label msg = new Label("Enter student's number");
        TextField std_num = new TextField();
        Button b1 = new Button("Search for student");
        button_style(b1);
        label_style(msg);

        b1.setOnAction(event -> {
            int std_id = Integer.parseInt(std_num.getText());
            int index = library.check_std(std_id);
            lib_form_name(index,std_id);

        });
        VBox vbox = new VBox();
        vbox.getChildren().addAll(msg,std_num,b1);
        vbox_style(vbox);
        Scene lib = new Scene(vbox,400,400);
        base.setScene(lib);
        base.setTitle("Library");
        base.show();
    }
    public void print_lib_click(){
        LibList libList = new LibList();
        libList.print_lib();
        Button b2 = new Button("Back to menu");
        b2.setOnAction(event -> {
            show_menu();
        });

        Button b3 = new Button("Exit");
        b3.setOnAction(event -> {
            base.close();
        });

        button_style(b2);
        button_style(b3);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(b2,b3);
        vbox_style(vbox);
        Scene print_std = new Scene(vbox,400,400);
        base.setTitle("Library info");
        base.setScene(print_std);
        base.show();

    }
    public void extend_(int index){
        if (index > -1){
            Library library = new Library(0);
            Label msg = new Label("Book id is valid!");
            Label msg2 = new Label("How many days to extend:");
            TextField day = new TextField();
            Button b1 = new Button("Extend");
            button_style(b1);

            b1.setOnAction(event -> {
                int new_day = Integer.parseInt(day.getText());
                library.extend(index,new_day);
                day.setText("");
                show_msg("Extend successfully!");

            });
            Button b2 = new Button("Back to menu");
            b2.setOnAction(event -> {
                show_menu();
            });

            Button b3 = new Button("Exit");
            b3.setOnAction(event -> {
                base.close();
            });

            button_style(b2);
            button_style(b3);
            label_style(msg);
            label_style(msg2);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(msg,msg2,day,b1,b2,b3);
            vbox_style(vbox);
            Scene lib = new Scene(vbox,400,400);
            base.setScene(lib);
            base.setTitle("Library");
            base.show();
        }
    }
    public void extending(){
        Library library = new Library(0);
        Label msg = new Label("Enter library's id");
        TextField lib_num = new TextField();
        Button b1 = new Button("Search for lib info");
        button_style(b1);
        label_style(msg);

        b1.setOnAction(event -> {
            int lib_id = Integer.parseInt(lib_num.getText());
            int index = library.att(lib_id);
            extend_(index);

        });
        VBox vbox = new VBox();
        vbox.getChildren().addAll(msg,lib_num,b1);
        vbox_style(vbox);
        Scene lib = new Scene(vbox,400,400);
        base.setScene(lib);
        base.setTitle("Extend");
        base.show();
    }
    public void lib(){
        Label l1 = new Label("Choose one of the options:");
        Button b1 = new Button("1)Print list of books");
        Button b2 = new Button("2)Get a book");
        Button b3 = new Button("3)Print library's info");
        Button b4 = new Button("4)Extend");
        button_style(b1);
        button_style(b2);
        button_style(b3);
        button_style(b4);
        label_style(l1);


        b1.setOnAction(event -> {
            print_book_click();
        });
        b2.setOnAction(event -> {
            get_book();
        });
        b3.setOnAction(event -> {
            print_lib_click();
        });
        b4.setOnAction(event -> {
            extending();
        });

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(l1,b1,b2,b3,b4);
        vbox_style(vbox1);
        Scene lib = new Scene(vbox1,400,400);
        base.setScene(lib);
        base.setTitle("Library");
        base.show();
    }

    public void show_menu(){
        Button b1 = new Button("1)Add student");
        Button b2 = new Button("2)Add book");
        Button b3 = new Button("3)Edit student");
        Button b4 = new Button("4)Edit book");
        Button b5 = new Button("5)Search");
        Button b6 = new Button("6)Library");
        Button b7 = new Button("Exit");

        b7.setOnAction(event -> {
            base.close();
        });

        b1.setOnAction(event -> {
            add_std();
        });
        b2.setOnAction(event -> {
            add_book();
        });
        b3.setOnAction(event -> {
            edit_std();
        });
        b4.setOnAction(event -> {
            edit_book();
        });
        b5.setOnAction(event -> {
            search();
        });
        b6.setOnAction(event -> {
            lib();
        });

        button_style(b1);
        button_style(b2);
        button_style(b3);
        button_style(b4);
        button_style(b5);
        button_style(b6);
        button_style(b7);

        VBox vbox = new VBox();


        vbox.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7);
        vbox_style(vbox);
        Scene show_menu = new Scene(vbox,400,400);
        base.setResizable(false);
        base.setScene(show_menu);
        base.setTitle("Menu");
        base.show();


    }
}
