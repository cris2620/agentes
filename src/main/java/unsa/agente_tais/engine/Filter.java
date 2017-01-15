package unsa.agente_tais.engine;

import java.util.Objects;

public class Filter<T> {
    private String descripcion;
    private T filtro;
    private int tipo;
    
    public static final int RECHAZAR = 0;
    public static final int MAYOR = 1;
    public static final int MENOR = 2;
    public static final int MAYOR_IGUAL = 3;
    public static final int MENOR_IGUAL = 4;
    public static final int IGUAL = 5;
    public static final int DIFERENTE = 6;

    public Filter(String descripcion, T filtro, int tipo) {
        this.descripcion = descripcion;
        this.filtro = filtro;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public T getFiltro() {
        return filtro;
    }

    public int getTipo() {
        return tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFiltro(T filtro) {
        this.filtro = filtro;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Filter{" + "descripcion=" + descripcion + ", filtro=" + filtro + ", tipo=" + tipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.descripcion);
        hash = 73 * hash + Objects.hashCode(this.filtro);
        hash = 73 * hash + this.tipo;
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
        final Filter<?> other = (Filter<?>) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.filtro, other.filtro)) {
            return false;
        }
        return true;
    }   
}
