package unsa.agente_tais.engine;

import java.util.List;

public interface InferenceEngine {
    
    public void loadItems(String url);
    
    public void loadItems(List<Item> items);
    
    public void addItem(Item newItem);
    
    public void removeItem(Item deleteItem);
    
    public void clearItems();
    
    public Item adapItem(Item evalItem, Item recoItem, int[] changeTraits);
    
    public Item[] getSimilarItems(Item evalItem, int range);
    
    public double[] getDistItems(Item evalItem, int range);
    
    public Item getSimilarItem(Item evalItem);
    
    public double getDistItem(Item evalItem);
    
    public void saveAllCases(String url);
    
    public void WriteItem(String url);
    
    public void addFilter(Filter newFilter);
    
    public void addFilters(List<Filter> newFilter);
    
    public void removeFilter(Filter deleteFilter);
    
    public void clearFilters();
}