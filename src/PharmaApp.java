import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelFactory;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class PharmaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //ClientFactory
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
