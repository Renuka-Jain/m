package edu.upc.dsa;


import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.ObjetoUsuario;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManager {
    public List<Usuario> listarUsuariosOrdenados(); //orden alfabetico
    public Usuario addUsuario(String nombre, String surname, int birth, String mail, String pass);
    public Usuario LogIn(String mail, String pass);
    public Objeto addObjeto(String nombre,String info, int coins);
    public List<ObjetoUsuario> listadoObjetosUsuario(String mail);//Lista de objetos de un usuario
    public boolean buyObjeto(String mail, String object);//comprar objeto
    public List<Objeto>listarObjetos();//Lista todos los objetos


}
