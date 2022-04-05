public class Book extends BookList {
    private String name;
    private String author;
    private int count;
    private int book_id;

    public Book(String name, String author, int count, int book_id) {
        this.name = name;
        this.author = author;
        this.count = count;
        this.book_id = book_id;
        add_to_list(name,author,count,book_id);
        writing_book(name,author,count,book_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
