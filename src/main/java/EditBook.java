public class EditBook extends BookList{
    public int permission(int book_id){
        int index = at(book_id);
        if (index > -1){
            return 0;
        }
        else{
            System.out.println("Book id not valid!Try again.");
            return -1;
        }
    }
    public void edit_name(String new_name, int index){
        nameL.set(index,new_name);
        System.out.println("Books's name changes successfully!");
        over_write();
    }
    public void edit_author(String new_author, int index){
        authorL.set(index,new_author);
        System.out.println("Book's author changes successfully!");
        over_write();
    }
    public void edit_count(int new_count, int index){
        countL.set(index,new_count);
        System.out.println("Number of book changes successfully!");
        over_write();
    }
}
