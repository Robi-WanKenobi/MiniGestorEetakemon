package MiniGestorEetakemon;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    Controlador testControlador = new Controlador();

    @org.junit.Test
    public void addUsuario()
    {
        //Introducimos un usuario y miramos que en la lista haya algo
        testControlador.add(new Usuario("Roberto", "robrobrob", "roberto@gmail.com"));
        assertTrue(testControlador.getListUsuarios().hasMoreElements());
    }

    @org.junit.Test
    public void delUsuario() {
        testControlador.add(new Usuario("Roberto", "robrobrob", "roberto@gmail.com"));
        //Borramos y miramos que la lsita este vacía
        testControlador.delUsuario(0);
        assertTrue(!testControlador.getListUsuarios().hasMoreElements());
    }

    @org.junit.Test
    public void searchUserByName() {
        testControlador.add(new Usuario("Roberto", "robrobrob", "roberto@gmail.com"));
        assertEquals(Usuario.class, testControlador.searchUsuarioByName("Roberto").getClass());
    }

    @org.junit.Test
    public void searchUserByAprox() {
        testControlador.add(new Usuario("Roberto", "robrobrob", "roberto@gmail.com"));
        testControlador.add(new Usuario("Norberto", "nornornor", "bert@gmail.com"));
        testControlador.add(new Usuario("Bertin", "osborne", "bosborne@gmail.com"));
        assertTrue(testControlador.searchUsuarioAprox("er").size() == 3);
    }


}
