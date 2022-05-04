package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String surname;
    private int birth;
    private String mail;
    private String pass;
    private int dsaCoins;

    private List<Objeto> listaObjetos = new LinkedList<>();

    public Usuario() {
        this.id = RandomUtils.getId();
        this.dsaCoins = 50;
    }

    public Usuario(String nombre, String surname, int birth, String mail, String pass) {
        this();
        this.setNombre(nombre);
        this.setSurname(surname);
        this.setBirth(birth);
        this.setMail(mail);
        this.setPass(pass);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(int dsaCoins) {
        this.dsaCoins = dsaCoins;
    }

    public void addObjetoLista(Objeto objeto,String fecha){
        listaObjetos.add(new ObjetoUsuario(objeto,fecha));
    }


    public int numPuntos(){
        return listaObjetos.size();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ObjetoUsuario> getListaObjetos() {
        return listaObjetos;
    }
    public void setListaObjetos(List<ObjetoUsuario> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
}
