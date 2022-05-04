package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.ObjetoUsuario;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class GameManagerImpl implements GameManager{

    private static GameManagerImpl manager;
    private HashMap<String, Usuario> gameUsers;
    private List<Objeto> objetos;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);


    private GameManagerImpl(){
        this.gameUsers = new HashMap<>();
        this.objetos = new LinkedList<Objeto>();}

    public static GameManagerImpl getInstance(){
        if(manager==null){
            logger.info("New instance edu.upc.dsa.GameManagerImpl");
            manager = new GameManagerImpl();
        }
        return manager;
    }

    public static void delete(){
        manager = null;
        logger.info("Instance GameManagerImpl deleted");
    }

    public void clear(){
        gameUsers.clear();
        objetos.clear();
    }

    @Override
    public List<Usuario> listarUsuariosOrdenados() {
        logger.info("sort users alphabetically by name");
        List<Usuario> usuariosOrdenados = Arrays.asList(gameUsers.values().stream().sorted(
                (s1,s2)->s1.getSurname().compareToIgnoreCase(s2.getSurname())).toArray(Usuario[]::new));

        return usuariosOrdenados;
    }

    @Override
    public Usuario addUsuario(String nombre, String surname, int birth, String mail, String pass) {
        logger.info("get user with mail ("+mail+")");
        Usuario user = this.gameUsers.get(mail);
        if(user==null){
            logger.info("get user ("+mail+"): "+user.getNombre());
            return this.addUsuario(new Usuario(nombre,surname,birth,mail,pass));
        }
        else
            return null;
    }

    private Usuario addUsuario(Usuario usuario) {
        Usuario u = this.gameUsers.

    }


    public int numUsuario() {
        int ret = this.gameUsers.size();
        logger.info("size " + ret);
        return ret;
    }
    @Override
    public Usuario LogIn(String mail, String pass){
        logger.info("get user with mail ("+mail+")");
        Usuario user = this.gameUsers.get(mail);
        if(user!=null){
            logger.info("get user ("+mail+"): exits");
            if(user.getPass()==pass) {
                logger.info("get user ("+mail+"): logged in");
                return user;
            }
            else{
                logger.info("get user ("+mail+"): password error");
                return null;
            }
        }
        else {
            logger.info("user ("+mail+"): not in system");
            return null;
        }

    }
    @Override
    public Objeto addObjeto(String nombre,String info, int coins) {
        return this.addObjeto(new Objeto(nombre, info, coins));
    }

    public Objeto addObjeto(Objeto t) {
        this.objetos.add(t);
        return t;
    }


    @Override
    public List<ObjetoUsuario> listadoObjetosUsuario(String mail) {
        List<ObjetoUsuario> userObjetos = this.gameUsers.get(mail).getListaObjetos();
        if (userObjetos.size() != 0)
            logger.info("User " + mail + " " + userObjetos);
        else
            logger.warn("user or punto not found");

        return userObjetos;
    }

    @Override
    public boolean buyObjeto(String mail, String object) {
        return false;
    }

    @Override
    public List<Objeto> listarObjetos() {
        Collections.sort(this.objetos,
                (Objeto o1, Objeto o2)->Integer.compare(o2.getCoins(), o1.getCoins()));
        return null;
    }

    @Override
    public int numObjetosUsuario(String mail) {
        int res = this.gameUsers.get(mail).getListaObjetos().size();
        if(res != 0)
            logger.info("UserID: "+mail+" -> Number of punto: "+res);
        else
            logger.warn("User not found");
        return res;
    }






    @Override
    public String getUsuarioID(String nombreUsuario){
        String idUsuario= this.gameUsers.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue().getNombre(), nombreUsuario))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(0);
        if (idUsuario!=null){
            logger.info("Usuario ("+nombreUsuario+") ID: "+idUsuario);
            return idUsuario;
        }
        logger.warn("User not found");
        return null;

    }
    public Usuario getUsuario(String id){
        return gameUsers.get(id);

    }
    public Objeto getPunto(String nombre){
        logger.info("punto: "+nombre+" encontrado: "+ objetos.stream().filter(n->n.getNombre()==nombre).collect(Collectors.toList()).get(0).getNombre());
        return objetos.stream().filter(n->n.getNombre()==nombre).collect(Collectors.toList()).get(0);
    }

    public int numPunto(){
        return objetos.size();
    }
}
