import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LibList extends StdList {
    Stage stage = new Stage();



    public static int lib_count = 0;
    public static ArrayList<String> bnameL = new ArrayList<String>();
    public static ArrayList<Integer> lib_idL = new ArrayList<Integer>();
    public static ArrayList<Integer> dayL = new ArrayList<Integer>();
    public static ArrayList<Integer> monthL = new ArrayList<Integer>();
    public static ArrayList<Integer> std_idL = new ArrayList<Integer>();


    public int att(int lib_id){

        for(int i =0;i<lib_count;i++){
            if(lib_id == lib_idL.get(i)){
                return i;
            }
        }
        return -1;
    }
    public void add_to_list(String name, int std_id, int month, int day, int lib_id){
        bnameL.add(name);
        std_idL.add(std_id);
        monthL.add(month);
        dayL.add(day);
        lib_idL.add(lib_id);
        lib_count++;
    }
    public void print_lib(){
        VBox vbox = new VBox();
        for(int i = 0; i<lib_count; i++){
            int index = at(std_idL.get(i));
            String data = ("Id= "+String.valueOf(lib_idL.get(i))+"\t\tName= "+ nameL.get(index)+"\t\tLast name= "
                    +lastnameL.get(index)+
                    "\t\tBook= "+bnameL.get(i)+"\t\tUntil= "+String.valueOf(monthL.get(i))+"/"+
                    String.valueOf(dayL.get(i)));
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
        stage.setTitle("Library's list");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
    }
    public void over_write_lib(){
        try {
            if(!library.exists()) {
                library.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(library.getName(),false);
            PrintWriter printWriter = new PrintWriter(fileWritter,false);
            printWriter.flush();
            printWriter.close();
            fileWritter.close();

        } catch(IOException e){
            e.printStackTrace();
        } //Clear file for rewrite

        for(int i =0; i<lib_count;i++)
            writing_lib(std_idL.get(i),bnameL.get(i),monthL.get(i),dayL.get(i));
    }

}
