import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelFactory;
import model.ModelFactory;
import networking.ClientFactory;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class PharmaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //DO NOT TOUCH THIS
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        ClientFactory cf = new ClientFactory(mf);
        //SocketClient cl = new SocketClient(mf.getTaskModel());
        vh.start();
    }
}
