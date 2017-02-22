package MiniGestorEetakemon;

import java.util.ArrayList;
import java.util.List;

public class ListaEetakemon {

    public List<Eetakemon> listaEetakemon;
    int id = 0;

    public ListaEetakemon(){
        listaEetakemon = new ArrayList<Eetakemon>();
    }

    //Añadir Eetakemon
    public void addEetakemon (Eetakemon e){
        e.setId(id);
        this.id++;
        listaEetakemon.add(e);
    }

    //Borrar por posición
    public boolean delEetakemon(int id) {

        int size = listaEetakemon.size();

        for (int i = 0; i < listaEetakemon.size(); i++) {
            if (listaEetakemon.get(i).getId() == id) {
                listaEetakemon.remove(i);
            }
        }

        if (listaEetakemon.size() != size) //Se ha borrado algo pq el tamaño se ha visto reducido
        {
            return true;
        } else {
            return false;
        }
    }

    //Devolver lista
    public List<Eetakemon> getList(){
        return listaEetakemon;
    }

    public List<Eetakemon> searchByName(String name) {

        List<Eetakemon> finded = new ArrayList<Eetakemon>();

        for (int i = 0; i<listaEetakemon.size(); i++)
        {
            if (listaEetakemon.get(i).name.equals(name)){
                finded.add(listaEetakemon.get(i));
            }
        }
        return finded;
    }

    public List<Eetakemon> searchAprox(String aprox) {

        List<Eetakemon> finded = new ArrayList<Eetakemon>();

        for (int i = 0; i < listaEetakemon.size(); i++) {
            if (listaEetakemon.get(i).name.contains(aprox)) {
                finded.add(listaEetakemon.get(i));
            }
        }
        return finded;
    }
}
