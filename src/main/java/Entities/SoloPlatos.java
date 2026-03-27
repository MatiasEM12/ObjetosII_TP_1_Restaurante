package Entities;

public class SoloPlatos implements CriterioItem {
    @Override
    public boolean cumpleParaPlato(Plato plato) {
        return true;
    }

    @Override
    public boolean cumpleParaBebida(Bebida bebida) {
        return false;
    }
}