package com.example.polimorfismoaplicacion.models;


import java.util.ArrayList;

public class Registro {
    private ArrayList<BaseDeDatos> listaEstudiantes=new ArrayList<>();
    private BaseDeDatos baseDeDatos;
    private MySQL mySQL;
    private  SQL sql;
    private MongoDB sqLite;
    public Registro(BaseDeDatos baseDeDatos1){
        this.baseDeDatos=baseDeDatos;
        mySQL=new MySQL();
        sql=new SQL();
        sqLite=new MongoDB();

        listaEstudiantes.add(mySQL);
        listaEstudiantes.add(sql);
        listaEstudiantes.add(sqLite);

    }

    public void save(Student student){
        for (BaseDeDatos baseDeDatos1:listaEstudiantes){
            baseDeDatos1.saveStudent(student);
        }
    }
    public void update(Student student){
        for (BaseDeDatos iBaseDeDatos:listaEstudiantes){
            iBaseDeDatos.updateStude(student);
        }
    }


    public MySQL getMySQL() {
        return mySQL;
    }

    public SQL getSql() {
        return sql;
    }

    public MongoDB getSqLite() {
        return sqLite;
    }
}
