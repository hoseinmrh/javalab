

public class Library extends LibList {


    private int std_id;
    private String book_name;
    private int month;
    private int nothing;
    public static int lib_id = 0;

    BookList blist = new BookList();
    StdList slist = new StdList();
    public Library(int std_id, String book_name, int month, int day) {
        this.std_id = std_id;
        this.book_name = book_name;
        this.month = month;
        lib_id++;


        add_to_list(book_name,std_id,month,day,lib_id);
        writing_lib(std_id,book_name,month,day);
    }
    public Library(int nothing){
        this.nothing = nothing;
    }

    public int book_count(int index){
        return blist.count(index);
    }
    public int check_name(String name){
        return blist.at(name);
    }
    public void reduce_book_count(int index){
        blist.set_count(index);
    }
    public int check_std(int std_id){
        int ret = slist.at(std_id);
        return ret;
    }
    public void check(int day_number, int index){
        int new_day = day_number + dayL.get(index);
        dayL.set(index,new_day%30);
        int new_month = new_day/30 + monthL.get(index);
        monthL.set(index,new_month%12);
    }
    public void extend(int index, int new_days){
        check(new_days,index);
        over_write_lib();

    }


}
