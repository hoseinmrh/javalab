import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu menu = new Menu();
        menu.show_menu();
    }

}
