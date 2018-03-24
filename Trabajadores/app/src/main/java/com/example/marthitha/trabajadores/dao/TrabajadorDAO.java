package com.example.marthitha.trabajadores.dao;

import android.content.Context;

import com.example.marthitha.trabajadores.model.Trabajador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Marthitha on 14/03/2018.
 */

public class TrabajadorDAO {


    private Context contexto;

    /**
     * Método constructor que inicializa la variable contexto
     * @param contexto
     */
    public TrabajadorDAO(Context contexto) {
        this.contexto = contexto;
    }

    /**
     * Método para insertar un objeto Producto en la BD
     * @param obj
     */
    public void insert(Trabajador obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "INSERT INTO TRABAJADOR(apellidoP, apellidoM, nombre, curp, puesto, departamento,sexo) " +
                "VALUES('" + obj.getApellidoP() + "', '" + obj.getApellidoM() +
                    "', '" + obj.getNombre() + "', '" + obj.getCurp() + "', '" + obj.getPuesto() +
                    "', '" + obj.getDepartamento() + "'" +
                    ","+obj.getSexo()+" )";
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepciÃ³n aquien invoca el método para que el lo maneje
            throw new Exception("Error al insertar: " + e.getMessage());
        }
    }

    /**
     * MÃ©todo para actualizar un objeto Producto en la BD
     * @param obj
     */
    public void update(Trabajador obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "UPDATE TRABAJADOR SET " +
                "apellidoP='" + obj.getApellidoP() + "'," +
                "apellidoM='" + obj.getApellidoM() + "'," +
                "nombre='" + obj.getNombre() + "'," +
                "curp='" + obj.getCurp() + "'," +
                "sexo=" + obj.getSexo() + "," +
                "puesto='" + obj.getPuesto() + "'," +
                "departamento='" + obj.getDepartamento() + "' " +
                "WHERE id=" + obj.getId() ;
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepción aquien invoca el método para que el lo maneje
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }

    /**
     * MÃ©todo para eliminar un objeto Producto en la BD
     * @param obj
     */
    public void delete(Trabajador obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "DELETE FROM TRABAJADOR WHERE id= " + obj.getId() + " ";
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepción aquien invoca el método para que el lo maneje
            throw new Exception("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos los objetos Producto de la BD
     * @return
     */
    public List<Trabajador> getAll() throws Exception{
        //Se especifica el nombre de la tabla a consultar
        String tabla = "TRABAJADOR";
        //Se indica los campos a consultar de la tabla
        String campos[] = new String[]{"id","apellidoP", "apellidoM", "nombre","curp","puesto","departamento"};
        //Se crea una lista para almacenar los objetos producto almacenados en la tabla
        List<Trabajador> listaTrabajadores = new ArrayList<>();
        //Se abre la conexión a la BD
        Conexion con = new Conexion(contexto);
        //Se consulta mediante la conexiÃ³n todos los registros y campos de la tabla
        List<HashMap<String, String>> resultado = con.ejecutarConsulta(tabla, campos, null);

        //Se crea una referencia a un objeto Producto
        Trabajador pro;
        //se recorre cada uno de los registros regresados de la consulta.
        for (HashMap<String, String> reg : resultado) {
            //Por cada registro se crea un objeto Producto
            pro = new Trabajador();
            //Se asigna cada uno de los atributos del objeto producto.
            pro.setId(Integer.parseInt(reg.get("id")));
            pro.setApellidoP(reg.get("apellidoP"));
            pro.setNombre(reg.get("nombre"));
            pro.setDepartamento(reg.get("departamento"));
            //Se inserta el objeto al producto en la lista
            listaTrabajadores.add(pro);
        }
        return listaTrabajadores;
    }

    /**
     * MÃ©todo para buscar un objeto Producto por su ID en la BD
     * @param obj
     * @return
     */
    public Trabajador getById(Trabajador obj) throws Exception{
        //Se especifica el nombre de la tabla a consultar
        String tabla = "TRABAJADOR";
        //Se indica los campos a consultar de la tabla
        String campos[] = new String[]{"id", "apellidoP", "apellidoM", "nombre","curp","puesto","departamento","sexo"};
        //Se especifica la condiciÃ³n para realizar la consulta.
        String condicion = "id = " + obj.getId();
        //Se abre la conexiÃ³n a la BD
        Conexion con = new Conexion(contexto);
        //Se consulta mediante la conexiÃ³n todos los registros y campos de la tabla
        List<HashMap<String, String>> resultado = con.ejecutarConsulta(tabla, campos, condicion);
        //Se crea una referencia a un objeto Producto
        Trabajador pro = null;
        //se recorre cada uno de los registros regresados de la consulta.
        for (HashMap<String, String> reg : resultado) {
            //Por cada registro se crea un objeto Producto
            pro = new Trabajador();
            //Se asigna cada uno de los atributos del objeto producto.
            pro.setId(Integer.parseInt(reg.get("id")));
            pro.setApellidoP(reg.get("apellidoP"));
            pro.setApellidoM(reg.get("apellidoM"));
            pro.setNombre(reg.get("nombre"));
            pro.setCurp(reg.get("curp"));
            pro.setSexo(Integer.parseInt(reg.get("sexo")));
            pro.setPuesto(reg.get("puesto"));
            pro.setDepartamento(reg.get("departamento"));

        }
        //Se retorna el objeto producto
        return pro;
    }
}
