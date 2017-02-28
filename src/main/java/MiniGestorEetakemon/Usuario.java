package MiniGestorEetakemon;

/**
 * Created by Roberto on 28/02/2017.
 */
public class Usuario {

    private int id;
    public String name;
    public String password;
    public String email;

    public Usuario(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
