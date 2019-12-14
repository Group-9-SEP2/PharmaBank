import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelFactory;
import networking.ClientFactory;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class PharmaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
