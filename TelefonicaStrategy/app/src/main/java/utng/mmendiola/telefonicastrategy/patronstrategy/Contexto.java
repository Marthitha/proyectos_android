package utng.mmendiola.telefonicastrategy.patronstrategy;

/**
 * Created by MarcoMT on 17/02/2018.
 */
public class Contexto {
    private Telefonica strategy;

    public Contexto(Telefonica strategy) {
        this.strategy = strategy;
    }

    public double calcularTarifaLocal(int minutosLocal){
        return strategy.calcularTarifaLocal(minutosLocal);
    }

    public double calcularTarifaLD(int minutosLD){
        return strategy.calcularTarifaLD(minutosLD);
    }
}
