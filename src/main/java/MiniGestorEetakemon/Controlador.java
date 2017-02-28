package MiniGestorEetakemon;

import java.util.*;

public class Controlador {

    public Hashtable<Integer, Eetakemon> hashtableEetakemon;
    private int generatedId = 0;

    public Controlador() {
        hashtableEetakemon = new Hashtable<Integer, Eetakemon>();
    }

    //Añadir Eetakemon
    public void addEetakemon (Eetakemon e){
        e.setId(generatedId);
        hashtableEetakemon.put(this.generatedId, e);
        this.generatedId++;
    }

    //Borrar por identificador
    public void delEetakemon(int id) {
        hashtableEetakemon.remove(id);
    }

    //Devolver lista
    public Enumeration<Eetakemon> getList() {
        return hashtableEetakemon.elements();
    }

    public Eetakemon searchByName(String name) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equals(name)) {
                return search.get(i);
            }
        }
        return null;
    }

    public List<Eetakemon> searchAprox(String aprox) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());
        List<Eetakemon> finded = null;

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.contains(aprox)) {
                finded.add(search.get(i));
            }
        }
        return finded;
    }
}
