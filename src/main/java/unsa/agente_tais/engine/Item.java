
package unsa.agente_tais.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {
    private List<Trait> traits;

    public Item(List<Trait> traits) {
        this.traits = traits;
    }
    
    public Item(){
        traits = new ArrayList<>();
    }
    
    public void addTrait(Trait trait) {
        traits.add(trait);
    }

    public Trait getAtTrait(int index) {
        return traits.get(index);
    }

    public void removeAtTrait(int index) {
        traits.remove(index);
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void clearTraits() {
        traits.clear();
    }

    public int size() {
        return traits.size();
    }

    @Override
    public String toString() {
        return "Item{" + "traits=" + traits + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.traits);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.traits, other.traits)) {
            return false;
        }
        return true;
    }
    
    public boolean sameFormItem(Item evalItem) {
        Trait tempTrait;
        Trait evalTrait;
        if(traits.size() != evalItem.size()){
            return false;
        }
        for(int i=0; i<traits.size(); i++){
            tempTrait = traits.get(i);
            evalTrait = evalItem.getAtTrait(i);
            if(!tempTrait.sameFormTrait(evalTrait)){
                return false;
            }
        }
        return true;
    }
}
