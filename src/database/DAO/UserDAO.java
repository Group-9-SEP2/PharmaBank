package database.DAO;

        import model.Users;

        import java.util.List;

public interface UserDAO {

    public List<Users> getUsers();
    public void updateUsers();
    public void deleteUsers();
    public void addUsers();
}
