package MiniGestorEetakemon;

import java.util.*;

public class Controlador {

    public Hashtable<Integer, Eetakemon> hashtableEetakemon;
    public Hashtable<Integer, Usuario> hashtableUsuarios;
    private int generatedIdEetakemon = 0;
    private int generateIdUsuario = 0;

    public Controlador() {
        hashtableEetakemon = new Hashtable<Integer, Eetakemon>();
        hashtableUsuarios = new Hashtable<Integer, Usuario>();
    }

    //Añadir
    public void add(Object o) {

        //Si es un Eetakemon
        if (o.getClass().equals(Eetakemon.class)) {
            Eetakemon add = (Eetakemon) o;
            add.setId(generatedIdEetakemon);
            hashtableEetakemon.put(this.generatedIdEetakemon, add);
            this.generatedIdEetakemon++;
        }
        //Si es un Usuario
        else if (o.getClass().equals(Usuario.class)) {
            Usuario add = (Usuario) o;
            add.setId(generateIdUsuario);
            hashtableUsuarios.put(this.generateIdUsuario, add);
            this.generateIdUsuario++;
        }
    }

    //Borrar Eetakemon por identificador
    public boolean delEetakemon(int id) {
        int size = hashtableEetakemon.size();
        hashtableEetakemon.remove(id);

        if (hashtableEetakemon.size() < size) {
            return true;
        } else return false;
    }

    //Borrar Usuario por identificador
    public boolean delUsuario(int id) {
        int size = hashtableUsuarios.size();
        hashtableUsuarios.remove(id);

        if (hashtableUsuarios.size() < size) {
            return true;
        } else return false;
    }

    //Devolver lista de Eetakemon
    public Enumeration<Eetakemon> getListEetakemon() {
        return hashtableEetakemon.elements();
    }

    //Devolver lista de Usuarios
    public Enumeration<Usuario> getListUsuarios() {
        return hashtableUsuarios.elements();
    }

    //Buscar Eetakemon por nombre
    public Eetakemon searchEetakemonByName(String name) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equals(name)) {
                return search.get(i);
            }
        }
        return null;
    }

    //Buscar Usuario por nombre
    public Usuario searchUsuarioByName(String name) {

        List<Usuario> search = Collections.list(hashtableUsuarios.elements());

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equals(name)) {
                return search.get(i);
            }
        }
        return null;
    }

    //Buscar Eetakemon por fracción de nombre
    public List<Eetakemon> searchEetakemonAprox(String aprox) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());
        List<Eetakemon> finded = new ArrayList<Eetakemon>();

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.contains(aprox)) {
                finded.add(search.get(i));
            }
        }
        return finded;
    }

    //Buscar Usuario por fracción de nombre
    public List<Usuario> searchUsuarioAprox(String aprox) {

        List<Usuario> search = Collections.list(hashtableUsuarios.elements());
        List<Usuario> finded = new ArrayList<Usuario>();

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.contains(aprox)) {
                finded.add(search.get(i));
            }
        }
        return finded;
    }
}
