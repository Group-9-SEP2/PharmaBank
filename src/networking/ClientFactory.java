package networking;

import networking.admin.AdminClientImp;
import model.ModelFactory;
import networking.admin.AdminClient;
import networking.login.LoginClient;
import networking.login.LoginClientImp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientFactory {
    private LoginClient login;
    private AdminClient admin;
    private ClientSocketHandler socketHandler;
    public ClientFactory() {
        try {
            Socket socket = new Socket("localhost", 3000);
            socketHandler = new ClientSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream()),
                    this
            );
            Thread t = new Thread(socketHandler);
            t.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
        this.login = new LoginClientImp(socketHandler);
        //this.admin = new AdminClientImp(socketHandler);

    }

    public LoginClient getLogin() {
        return login;
    }

    public AdminClient getAdmin() {
        return admin;
    }

    public LoginClient getLoginClient() {
        return login;
    }

    public AdminClient getAdminClient() {
        return admin;
    }
}
