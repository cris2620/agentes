package unsa.agente_tais.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cases {
    private List<Item> items;

    public Cases(List<Item> items) {
        this.items = items;
    }
    
    public Cases() {
        this.items = new ArrayList();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void addItems(List<Item> items) {
        items.addAll(items);
    }

    public Item getAtItem(int index) {
        return items.get(index);
    }

    public void removeAtItem(int index) {
        items.remove(index);
    }

    public List<Item> getItems() {
        return items;
    }

    public void clearItems() {
        items.clear();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Case{" + "items=" + items + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.items);
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
        final Cases other = (Cases) obj;
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }
}
