package MiniGestorEetakemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roberto on 21/02/2017.
 */
public class ListaEetakemon {

    public List<Eetakemon> listaEetakemon;

    public ListaEetakemon(){
        listaEetakemon = new ArrayList<Eetakemon>();
    }

    //Añadir Eetakemon
    public void addEetakemon (Eetakemon e){
        listaEetakemon.add(e);
    }

    //Borrar por posición
    public void delEetakemon (int id){
        listaEetakemon.remove(id);
    }

    //Devolver lista
    public List<Eetakemon> getList(){
        return listaEetakemon;
    }

    public Eetakemon searchByName(String name){

        Eetakemon finded = new Eetakemon();

        for (int i = 0; i<listaEetakemon.size(); i++)
        {
            if (listaEetakemon.get(i).name.equals(name)){
                finded = listaEetakemon.get(i);
                break;
            }
        }
        return finded;
    }
}
