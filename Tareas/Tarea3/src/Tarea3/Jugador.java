package Tareas.Tarea3.src.Tarea3;

import java.util.ArrayList;

public class Jugador{
    private String nombre;
    private int javalares;
    private int hierro;
    private int trigo;
    private int tecnología;
    private ArrayList<Persona> personas;
    private ArrayList<Edificio> edificios;
    private ArrayList<Feria> ferias;
    private ArrayList<Museo> museos;
    private ArrayList<Javapato> javapatos;

    public Jugador(String nombre, int javalares, int hierro, int trigo, int tecnología, ArrayList<Persona> personas, ArrayList<Edificio> edificios, ArrayList<Feria> ferias, ArrayList<Museo> museos, ArrayList<Javapato> javapatos){
        this.nombre = nombre;
        this.javalares = javalares;
        this.hierro = hierro;
        this.trigo = trigo;
        this.tecnología = tecnología;
        this.personas = personas;
        this.edificios = edificios;
        this.ferias = ferias;
        this.museos = museos;
        this.javapatos = javapatos;
    }

    //getter y setters de los atributos de la clase.
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setJavalares(int javalares){
        this.javalares = javalares;
    }
    public int getJavalares(){
        return this.javalares;
    }

    public void setHierro(int hierro){
        this.hierro = hierro;
    }
    public int getHierro(){
        return this.hierro;
    }

    public void setTrigo(int trigo){
        this.trigo = trigo;
    }
    public int getTrigo(){
        return this.trigo;
    }

    public void setTecnologia(int tecnologia){
        this.tecnología = tecnologia;
    }
    public int getTecnologia(){
        return this.tecnología;
    }

    public void setListPersonas(ArrayList<Persona> personas ){
        this.personas = personas;
    }
    public ArrayList<Persona> getListPersonas(){
        return this.personas;
    }

    public void setListEdificios(ArrayList<Edificio> edificios ){
        this.edificios = edificios;
    }
    public ArrayList<Edificio> getListEdificios(){
        return this.edificios;
    }

    public void setListFerias(ArrayList<Feria> ferias ){
        this.ferias = ferias;
    }
    public ArrayList<Feria> getListFerias(){
        return this.ferias;
    }

    public void setListMuseos(ArrayList<Museo> museos ){
        this.museos = museos;
    }
    public ArrayList<Museo> getListMuseos(){
        return this.museos;
    }

    public void setListJavapatos(ArrayList<Javapato> javapatos ){
        this.javapatos = javapatos;
    }
    public ArrayList<Javapato> getListJavapatos(){
        return this.javapatos;
    }
    
    /*
     *Nombre de función: sacar_persona
     *Parametros: String nombrePersona
     * Descripción: Lo que hace esta función es que saca a una persona del ArrayList Persona.
     * Retorna: No retorna
    */
    public void sacar_persona(String nombrePersona){
        for(int i = 0; i <= personas.size() - 1; i++){
            if(personas.get(i).getnombre().equals(nombrePersona)){
                personas.remove(i);
            }
        }
    }
    
    /*
     *Nombre de función: agregar_perona
     *Parametros: Persona persona
     * Descripción: Lo que hace esta función es agregar a una persona al ArrayList Persona.
     * Retorna: No retorna
    */
    public void agregar_persona(Persona persona){
        personas.add(persona);

    }

    /*
     *Nombre de función: sacar_edificio
     *Parametros: String nombreEdificio
     * Descripción: Lo que hace es que saca a un edificio del ArrayList Edificio
     * Retorna: No retorna
    */
    public void sacar_edificio(String nombreEdificio){
        for(int i = 0; i <= edificios.size() - 1; i++){
            if(edificios.get(i).getnombre().equals(nombreEdificio)){
                edificios.remove(i);
            }
        }
    }

    /*
     *Nombre de función: agregar_edificio
     *Parametros: Edifico edificio
     * Descripción: Lo que hace esta función es que agrega un edificio al ArrayList Edificio
     * Retorna: No retorna
    */
    public void agregar_edificio(Edificio edificio){
        edificios.add(edificio);

    }

    /*
     *Nombre de función: sacar_atraccion
     *Parametros: String nombreAtraccion, String nombreLugar
     * Descripción: Lo que hace esta función es sacar una atracción de tipo Feria, Museo o Javapato.
     * Retorna: No retorna
    */
    public void sacar_atraccion(String nombreAtraccion, String nombreLugar){
        if(nombreLugar.equals("Feria")){
            for(int i = 0; i <= ferias.size() - 1; i++){
                if(ferias.get(i).getnombre().equals(nombreAtraccion)){
                    ferias.remove(i);
                }
            }
        }
        else if(nombreLugar.equals("Museo")){
            for(int i = 0; i <= museos.size() - 1; i++){
                if(museos.get(i).getnombre().equals(nombreAtraccion)){
                    museos.remove(i);
                }
            }
        }
        else if(nombreLugar.equals("Javapato")){
            for(int i = 0; i <= javapatos.size() - 1; i++){
                if(javapatos.get(i).getnombre().equals(nombreAtraccion)){
                    javapatos.remove(i);
                }
            }
        }
    }

    /*
     *Nombre de función: agregar_feria
     *Parametros: Feria feria
     * Descripción: Lo que hace esta función es que agrega una feria al ArrayList Feria.
     * Retorna: No retorna
    */
    public void agregar_feria(Feria feria){
        ferias.add(feria);

    }
    /*
     *Nombre de función: agregar_Museo
     *Parametros: Museo museo
     * Descripción: Lo que hace esta función es agregar un museo al ArrayList Museo.
     * Retorna: No retorna
    */
    public void agregar_Museo(Museo museo){
        museos.add(museo);

    }
    /*
     *Nombre de función: agregar_javapato
     *Parametros: Javapato javapato
     * Descripción: Lo que hace esta función es agregar un javapato al ArrayList Javapato.
     * Retorna: No retorna
    */
    public void agregar_javapato(Javapato javapato){
        javapatos.add(javapato);

    }

     /*
     *Nombre de función: mostrarNombrePersonas
     *Parametros: Sin parametros
     * Descripción: Mostra por pantalla el nombre de las personas que no se encuentra asignadas dentro de un edificio.
     * Retorna: No retorna
    */
    public void mostrarNombrePersonas(){
        System.out.println("Nombre de Personas no asignadas a un edificio: ");
        for(int i = 0; i <= personas.size() - 1; i++){
            System.out.println(personas.get(i).getnombre());
        }
    }

     /*
     *Nombre de función: mostraNombreedificios
     *Parametros: Sin parametros
     * Descripción: Mostran por pantalla el nombre de los edificios contruidos incluyendo a las personas que se encuentran dentro del edificio.
     * Retorna: No retorna
    */
    public void mostrarNombreEdificios(){
        System.out.println("Nombre de Edificios contruidos, incluyendo a las personas dentro de cada edifcio: ");
        for(int i = 0; i <= edificios.size() - 1; i++){
            System.out.println(edificios.get(i).getnombre() + " Contiene a: ");
            for(int j = 0; j <= edificios.get(i).getListPersonas().size() - 1; j++){
                System.out.println(edificios.get(i).getListPersonas().get(j).getnombre());
            }
        }
    }

     /*
     *Nombre de función: mostraNombreAtraccion
     *Parametros: Sin paramentro
     * Descripción: Muestra por pantalla el nombre de las atracciones contruidas.
     * Retorna: No retorna
    */
    public void mostrarNombreAtraccion(){
        System.out.println("Nombre de Atracciones contruidas: ");
        for(int i = 0; i <= ferias.size()- 1; i++){
            System.out.println(ferias.get(i).getnombre());
        }
        for(int j = 0; j <= museos.size() - 1; j++){
            System.out.println(museos.get(j).getnombre());
        }
        for(int x = 0; x <= javapatos.size() - 1; x++){
            System.out.println(javapatos.get(x).getnombre());
        }
    }
    
}