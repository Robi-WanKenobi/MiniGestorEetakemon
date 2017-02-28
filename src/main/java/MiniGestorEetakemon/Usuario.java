package MiniGestorEetakemon;

/**
 * Created by Roberto on 28/02/2017.
 */
public class Usuario {

    String name;
    String password;
    String email;

    public Usuario(){}

    public Usuario(String name, String pass, String email){
        this.name = name;
        this.password = pass;
        this.email = email;
    }
}
