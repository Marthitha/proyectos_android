package utng.mmendiola.telefonicastrategy.patronstrategy;

/**
 * Created by MarcoMT on 24/02/2018.
 */
public class Movistar implements Telefonica{
    @Override
    public double calcularTarifaLocal(int minutosLocal) {
        return 4*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return 6*minutosLD;
    }
}
