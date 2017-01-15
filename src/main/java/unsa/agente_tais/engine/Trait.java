package unsa.agente_tais.engine;

import java.util.Objects;

public class Trait<T> {

    private String descripcion;
    private T valor;
    private double peso;

    public Trait(String descripcion, T valor, double peso) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = peso;
    }

    public Trait(String descripcion, T valor) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = 1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public T getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Trait{" + "descripcion=" + descripcion + ", valor=" + valor + ", peso=" + peso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.descripcion);
        hash = 53 * hash + Objects.hashCode(this.valor);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trait<?> other = (Trait<?>) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    public boolean sameFormTrait(Trait evalTrait) {
        return !(!this.getDescripcion().equals(evalTrait.getDescripcion())
                || this.getValor().getClass() != evalTrait.getValor().getClass());
    }

    public boolean testFilter(Filter evalFilter) {
        if (this.getValor().getClass() != evalFilter.getFiltro().getClass()
                || !this.getDescripcion().equals(evalFilter.getDescripcion())) {
            //si no es el Trait correspondiente lo ignora
            return true;
        } else {
            Object tempValor = this.getValor();
            switch (evalFilter.getTipo()) {
                case Filter.RECHAZAR:
                    return false;
                case Filter.MAYOR:
                    if (evalFilter.getFiltro().getClass() == String.class
                            || tempValor.getClass() == Boolean.class
                            || tempValor.getClass() == Character.class) {
                        //la operacion no corresponde
                        return true;
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor > (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor > (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor > (float) evalFilter.getFiltro();
                    }
                    break;
                case Filter.MENOR:
                    if (evalFilter.getFiltro().getClass() == String.class
                            || tempValor.getClass() == Boolean.class
                            || tempValor.getClass() == Character.class) {
                        //la operacion no corresponde
                        return true;
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor < (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor < (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor < (float) evalFilter.getFiltro();
                    }
                    break;
                case Filter.MAYOR_IGUAL:
                    if (evalFilter.getFiltro().getClass() == String.class
                            || tempValor.getClass() == Boolean.class
                            || tempValor.getClass() == Character.class) {
                        //la operacion no corresponde
                        return true;
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor >= (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor >= (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor >= (float) evalFilter.getFiltro();
                    }
                    break;
                case Filter.MENOR_IGUAL:
                    if (evalFilter.getFiltro().getClass() == String.class
                            || tempValor.getClass() == Boolean.class
                            || tempValor.getClass() == Character.class) {
                        //la operacion no corresponde
                        return true;
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor <= (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor <= (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor <= (float) evalFilter.getFiltro();
                    }
                    break;
                case Filter.IGUAL:
                    if (evalFilter.getFiltro().getClass() == String.class){
                        return ((String) tempValor).equals((String) evalFilter.getFiltro());
                    }
                    if (evalFilter.getFiltro().getClass() == Boolean.class){
                        return (boolean) tempValor ^ (boolean) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Character.class){
                        return (char) tempValor == (char) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor == (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor == (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor == (float) evalFilter.getFiltro();
                    }
                    break;
                case Filter.DIFERENTE:
                    if (evalFilter.getFiltro().getClass() == String.class){
                        return !((String) tempValor).equals((String) evalFilter.getFiltro());
                    }
                    if (evalFilter.getFiltro().getClass() == Boolean.class){
                        return !(boolean) tempValor ^ (boolean) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Character.class){
                        return (char) tempValor != (char) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Integer.class) {
                        return (int) tempValor != (int) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Double.class) {
                        return (double) tempValor != (double) evalFilter.getFiltro();
                    }
                    if (evalFilter.getFiltro().getClass() == Float.class) {
                        return (float) tempValor != (float) evalFilter.getFiltro();
                    }
                    break;
            }
        }
        return true;
    }
}
