package unsa.agente_tais.engine;

import java.util.List;

public interface InferenceEngine {
    
    public void loadItems(String url);
    
    public void loadItems(List<Item> items);
    
    public void addItem(Item newItem);
    
    public void removeItem(Item deleteItem);
    
    public Item adapItem(Item evalItem, Item recoItem);
    
    public Item[] getSimilarItems(Item evalItem, int range);
    
    public double[] getDistItems(Item evalItem, int range);
    
    public Item getSimilarItem(Item evalItem);
    
    public double getDistItem(Item evalItem);
    
    public void saveCases(String url);
}