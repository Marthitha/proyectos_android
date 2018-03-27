package utng.mmendiola.telefonicastrategy.patronstrategy;

/**
 * Created by MarcoMT on 17/02/2018.
 */
public class Unefon implements Telefonica {
    @Override
    public double calcularTarifaLocal(int minutosLocal) {
        return 2*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return 2*minutosLD;
    }
}
