package MiniGestorEetakemon;

import java.util.ArrayList;
import java.util.List;

public class Eetakemon {

    private int id;
    public String name;
    public int level;

    public Eetakemon(){}

    public Eetakemon(String name, int level){
        this.name = name;
        this.level = level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
