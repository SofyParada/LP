package Tarea3;

import java.util.ArrayList;

public abstract class Edificio{
    private String nombre;
    private int nivel;
    private int capacidad;
    private ArrayList<Persona> personas;

    public Edificio(String nombre, int nivel, int capacidad, ArrayList<Persona> personas){
        this.nombre = nombre;
        this.nivel = nivel;
        this.capacidad = capacidad;
        this.personas = personas;
    }

    /*
     *Nombre de función: sacar_persona
     *Parametros: String nombrePersona
     * Descripción: Lo que hace esta función es sacar auna persona del ArrayList de Persona en el Edificio.
     * Retorna: no retorna
    */
    public void sacar_persona(String nombrePersona){
        for(int i = 0; i < personas.size(); i++){
            if(personas.get(i).getnombre() == nombrePersona){
                personas.remove(i);
            }
        }
    }

    /*
     *Nombre de función: agregar_persona
     *Parametros: Persona persona
     * Descripción: Lo que hace esta función de es agregar a una persona al ArrayList Persona del Edificio.
     * Retorna: No retorna
    */
    public void agregar_persona(Persona persona){
        personas.add(persona);
    }

    /*
     *Nombre de función: mejorar
     *Parametros: No tiene parametros
     * Descripción: Lo que hace esta función es aumentar el nivel de edificio y de mejorar la capacidad del edificio.
     * Retorna: No retorna
    */
    public abstract void mejorar();

    /*
     *Nombre de función: producir
     *Parametros: No tien eparametros 
     * Descripción: Lo que hace esta función es retornar una ArrayList con los javalares, Hierro, Trigos y Tecnologia que se producjo en el edificio.
     * Retorna: ArrayList<Interger>
    */
    public abstract ArrayList<Integer> producir();

    //getters y setters de los atributos de la clase.
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public String getnombre(){
        return this.nombre;
    }

    public void setnivel(int nivel){
        this.nivel = nivel;
    }
    public int getnivel(){
        return this.nivel;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
    }
    public int getCapcidad(){
        return this.capacidad;
    }

    public void setListPersonas(ArrayList<Persona> personas){
        this.personas = personas;
    }
    public ArrayList<Persona> getListPersonas(){
        return this.personas;
    }

     /*
     *Nombre de función: es_granjero
     *Parametros: Persona persona
     * Descripción: Identifica si la persona es de tipo Granjero.
     * Retorna: int
    */
    public int es_granjero(Persona persona){
        if(persona instanceof Granjero){
            return 1;
        }
        else{
            return 0;
        }
    }

     /*
     *Nombre de función: es_cientifico
     *Parametros: Persona persona
     * Descripción: Identifica si la persona es de tipi Cientifico.
     * Retorna: int
    */
    public int es_cientifico(Persona persona){
        if(persona instanceof Cientifico){
            return 1;
        }
        else{
            return 0;
        }
    }

     /*
     *Nombre de función: es_herrero
     *Parametros: Persona persona
     * Descripción: Identifica si la persona es de tipo Herrero
     * Retorna: int
    */
    public int es_herrero(Persona persona){
        if(persona instanceof Herrero){
            return 1;
        }
        else{
            return 0;
        }
    }


    
}