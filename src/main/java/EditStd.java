

public class EditStd extends StdList {
    public int permission(int std_id){
        int index = at(std_id);
        if (index > -1){
            return 0;
        }
        else{
            System.out.println("Student number not valid!Try again.");
            return -1;
        }
    }
    public void edit_name(String new_name, int index){
        nameL.set(index,new_name);

        over_write();
    }
    public void edit_major(String new_major, int index){
        majorL.set(index,new_major);

        over_write();
    }
    public void edit_lastname(String new_lastname, int index){
        lastnameL.set(index,new_lastname);

        over_write();
    }
}
