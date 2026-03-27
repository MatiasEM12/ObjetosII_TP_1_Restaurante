package Entities;

public class SoloBebidas implements CriterioItem {
    @Override
    public boolean cumpleParaPlato(Plato plato) {
        return false;
    }

    @Override
    public boolean cumpleParaBebida(Bebida bebida) {
        return true;
    }
}