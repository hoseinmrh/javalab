import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Files  {
    File students = new File("students.txt");
    File books = new File("books.txt");
    File library = new File("library.txt");

    public void writing_std(String name, String lastname, String major,int std_id){

        try {
            String data = "Name= "+name+ "\t\tLast name= "+lastname
                    + "\t\tmajor= "+major+ "\t\tStudent number= "+String.valueOf(std_id);

            if(!students.exists()) {
                students.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(students.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void writing_book(String name, String author, int count, int book_id){
        try {
            String data = "Name= "+name+ "\t\tAuthor= "+author
                    + "\t\tnumber in stock= "+String.valueOf(count)+ "\t\tBook id= "+String.valueOf(book_id);

            if(!books.exists()) {
                books.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(books.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void writing_lib(int std_id,String bname,int month,int day){
        try {
            String data = "Student number= "+String.valueOf(std_id)+"\t\tName= "+
                    bname+"\t\tUntil= "+String.valueOf(month)+"/"+String.valueOf(day);


            if(!library.exists()) {
                library.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(library.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}
