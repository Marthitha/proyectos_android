package utng.mmendiola.telefonicastrategy.patronsingleton;

import java.util.Random;

/**
 * Created by MarcoMT on 24/02/2018.
 */
public class MensajeSingleton {
    private static MensajeSingleton instance;// instancia única
    private String mensaje;

    private MensajeSingleton(){
        String[] mensajes ={"Hola bebé", "Hola Amo", "Se va hacer o no se va hacer"};
        Random r1 = new Random();
        int x= 0;
        x = r1.nextInt(mensajes.length);
        mensaje = mensajes[x];
    }

    public static MensajeSingleton getInstance(){
        if(instance == null){// No ha sido creada?
            instance = new MensajeSingleton();
        }
        return  instance;
    }

    public String getMensaje() {
        return mensaje;
    }
}
