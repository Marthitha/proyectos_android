package utng.mmendiola.telefonicastrategy.patronstrategy;

/**
 * Created by MarcoMT on 17/02/2018.
 */
public class MyCompany implements Telefonica {
    @Override
    public double calcularTarifaLocal(int minutosLocal) {
        return 0.5*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return minutosLD;
    }
}
