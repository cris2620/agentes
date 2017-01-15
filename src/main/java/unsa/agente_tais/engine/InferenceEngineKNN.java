package unsa.agente_tais.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Soporta Items con Traits de tipo String, double, int, float, boolean y char
 *
 * @author Christian
 */
public class InferenceEngineKNN implements InferenceEngine {

    private Cases casesknn;
    private ArrayList<Filter> filtros;

    public InferenceEngineKNN(Cases casesknn,  ArrayList filtros) {
        this.casesknn = casesknn;
        this.filtros = filtros;
    }

    public InferenceEngineKNN(Cases casesknn) {
        this.casesknn = casesknn;
        this.filtros = new ArrayList<>();
    }
    
    public InferenceEngineKNN() {
        this.casesknn = new Cases();
        this.filtros = new ArrayList<>();
    }

    @Override
    public void loadItems(String url) {
    }

    @Override
    public void loadItems(List<Item> items) {
        this.casesknn.addItems(items);
    }

    @Override
    public void addItem(Item newItem) {
        this.casesknn.addItem(newItem);
    }

    @Override
    public void removeItem(Item deleteItem) {
        for (int i = 0; i < casesknn.size(); i++) {
            if (casesknn.getAtItem(i).equals(deleteItem)) {
                casesknn.removeAtItem(i);
                return;
            }
        }
    }
    
    @Override
    public void clearItems(){
        casesknn.clearItems();
    }

    @Override
    public Item adapItem(Item evalItem, Item recoItem, int[] changeTraits) {
        return null;
    }

    @Override
    public Item[] getSimilarItems(Item evalItem, int range) {
        int numCasos = casesknn.size();

        if (range <= 0) {
            return null;
        }

        Item[] casesResult;
        double[] distknn;
        if (range > numCasos) {
            casesResult = new Item[numCasos];
        } else {
            casesResult = new Item[range];
        }
        distknn = new double[casesResult.length];
        for (int i = 0; i < distknn.length; i++) {
            casesResult[i] = null;
            distknn[i] = Double.MAX_VALUE;
        }

        //recorre todos los casos de su base de conocimiento
        Item myItem;
        Trait tempTrait, myTrait;
        double tempDistancia;
        for (int i = 0; i < numCasos; i++) {
            myItem = casesknn.getAtItem(i);
            if (myItem.size() != evalItem.size()) {
                continue;
            }
            tempDistancia = 0;
            for (int j = 0; j < myItem.size(); j++) {
                myTrait = myItem.getAtTrait(j);
                tempTrait = evalItem.getAtTrait(j);
                if(!evalFilters(myTrait)){
                    continue;
                }
                if (myTrait.sameFormTrait(tempTrait)) {
                    if (myTrait.getValor().getClass() == String.class) {
                        if (!((String) myTrait.getValor()).equals((String) tempTrait.getValor())) {
                            tempDistancia = tempDistancia + (myTrait.getPeso() + tempTrait.getPeso()) / 2;
                        }
                    }
                    if (myTrait.getValor().getClass() == Boolean.class) {
                        if ((boolean) myTrait.getValor() ^ (boolean) tempTrait.getValor()) {
                            tempDistancia = tempDistancia + (myTrait.getPeso() + tempTrait.getPeso()) / 2;
                        }
                    }
                    if (myTrait.getValor().getClass() == Character.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (char) myTrait.getValor() - tempTrait.getPeso() * (char) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Integer.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (int) myTrait.getValor() - tempTrait.getPeso() * (int) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Double.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (double) myTrait.getValor() - tempTrait.getPeso() * (double) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Float.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (float) myTrait.getValor() - tempTrait.getPeso() * (float) tempTrait.getValor(), 2);
                    }
                }
            }
            tempDistancia = Math.sqrt(tempDistancia);

            int pivote = 0;
            for (int j = distknn.length - 1; j >= 0; j--) {
                if (distknn[j] < tempDistancia) {
                    pivote = j + 1;
                    break;
                }
            }
            if (pivote == distknn.length) {
                distknn[distknn.length - 1] = tempDistancia;
                casesResult[distknn.length - 1] = myItem;
                continue;
            }
            if (pivote < distknn.length) {
                for (int j = distknn.length - 1; j > pivote; j--) {
                    distknn[j] = distknn[j - 1];
                    casesResult[j] = casesResult[j - 1];
                }
                distknn[pivote] = tempDistancia;
                casesResult[pivote] = myItem;
            }
        }
        return casesResult;
    }

    @Override
    public double[] getDistItems(Item evalItem, int range) {
        int numCasos = casesknn.size();

        if (range <= 0) {
            return null;
        }

        double[] distknn;
        if (range > numCasos) {
            distknn = new double[numCasos];
        } else {
            distknn = new double[range];
        }
        for (int i = 0; i < distknn.length; i++) {
            distknn[i] = Double.MAX_VALUE;
        }

        //recorre todos los casos de su base de conocimiento
        Item myItem;
        Trait tempTrait, myTrait;
        double tempDistancia;
        for (int i = 0; i < numCasos; i++) {
            myItem = casesknn.getAtItem(i);
            if (myItem.size() != evalItem.size()) {
                continue;
            }
            tempDistancia = 0;
            for (int j = 0; j < myItem.size(); j++) {
                myTrait = myItem.getAtTrait(j);
                tempTrait = evalItem.getAtTrait(j);
                if(!evalFilters(myTrait)){
                    continue;
                }
                if (myTrait.sameFormTrait(tempTrait)) {
                    if (myTrait.getValor().getClass() == String.class) {
                        if (!((String) myTrait.getValor()).equals((String) tempTrait.getValor())) {
                            tempDistancia = tempDistancia + (myTrait.getPeso() + tempTrait.getPeso()) / 2;
                        }
                    }
                    if (myTrait.getValor().getClass() == Boolean.class) {
                        if ((boolean) myTrait.getValor() ^ (boolean) tempTrait.getValor()) {
                            tempDistancia = tempDistancia + (myTrait.getPeso() + tempTrait.getPeso()) / 2;
                        }
                    }
                    if (myTrait.getValor().getClass() == Character.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (char) myTrait.getValor() - tempTrait.getPeso() * (char) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Integer.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (int) myTrait.getValor() - tempTrait.getPeso() * (int) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Double.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (double) myTrait.getValor() - tempTrait.getPeso() * (double) tempTrait.getValor(), 2);
                    }
                    if (myTrait.getValor().getClass() == Float.class) {
                        tempDistancia = tempDistancia + Math.pow(myTrait.getPeso() * (float) myTrait.getValor() - tempTrait.getPeso() * (float) tempTrait.getValor(), 2);
                    }
                }
            }
            tempDistancia = Math.sqrt(tempDistancia);

            int pivote = 0;
            for (int j = distknn.length - 1; j >= 0; j--) {
                if (distknn[j] < tempDistancia) {
                    pivote = j + 1;
                    break;
                }
            }
            if (pivote == distknn.length) {
                distknn[distknn.length - 1] = tempDistancia;
                continue;
            }
            if (pivote < distknn.length) {
                for (int j = distknn.length - 1; j > pivote; j--) {
                    distknn[j] = distknn[j - 1];
                }
                distknn[pivote] = tempDistancia;
            }
        }
        return distknn;
    }

    @Override
    public Item getSimilarItem(Item evalItem) {
        Item[] temp = getSimilarItems(evalItem, 1);
        return temp[0];
    }

    @Override
    public double getDistItem(Item evalItem) {
        double[] temp = getDistItems(evalItem, 1);
        return temp[0];
    }

    @Override
    public void saveAllCases(String url) {
    }
    
    @Override
    public void WriteItem(String url) {
    }
    
    @Override
    public void addFilter(Filter newFilter){
        filtros.add(newFilter);
    }
    
    @Override
    public void addFilters(List<Filter> listFilter){
        filtros.addAll(listFilter);
    }
    
    @Override
    public void removeFilter(Filter deleteFilter){
        for (int i = 0; i < filtros.size(); i++) {
            if (filtros.get(i).equals(deleteFilter)) {
                filtros.remove(i);
                return;
            }
        }
    }
    
    @Override
    public void clearFilters(){
        filtros.clear();
    }
    
    private boolean evalFilters(Trait evalTrait){
        for (int i = 0; i < filtros.size(); i++) {
            //si el filtro es negativo devuelve false
            if(!evalTrait.testFilter(filtros.get(i))){
                return false;
            }
        }
        return true;
    }
}
