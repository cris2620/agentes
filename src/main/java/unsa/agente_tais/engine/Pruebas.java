package unsa.agente_tais.engine;

public class Pruebas {

    public static void main(String[] args) {
        Cases baseConocimiento = new Cases();

        Trait<Integer> t11 = new Trait<>("edad", 13, 1);
        Trait<Double> t12 = new Trait<>("talla_cm", 11.1, 1);
        Trait<Float> t13 = new Trait<>("peso_kg", 75.5f, 1);
        Trait<String> t14 = new Trait<>("tipo_sangre", "O+", 1);
        Trait<Character> t15 = new Trait<>("sexo", 'F', 1);
        Trait<Boolean> t16 = new Trait<>("ambos_padres", true, 1);
        
        Trait<Integer> t21 = new Trait<>("edad", 13, 1);
        Trait<Double> t22 = new Trait<>("talla_cm", 9.1, 1);
        Trait<Float> t23 = new Trait<>("peso_kg", 65.5f, 1);
        Trait<String> t24 = new Trait<>("tipo_sangre", "O-", 1);
        Trait<Character> t25 = new Trait<>("sexo", 'M', 1);
        Trait<Boolean> t26 = new Trait<>("ambos_padres", true, 1);
        
        Trait<Integer> t31 = new Trait<>("edad", 15, 1);
        Trait<Double> t32 = new Trait<>("talla_cm", 16.1, 1);
        Trait<Float> t33 = new Trait<>("peso_kg", 55.5f, 1);
        Trait<String> t34 = new Trait<>("tipo_sangre", "O+", 1);
        Trait<Character> t35 = new Trait<>("sexo", 'F', 1);
        Trait<Boolean> t36 = new Trait<>("ambos_padres", false, 1);
        
        Trait<Integer> t41 = new Trait<>("edad", 14, 1);
        Trait<Double> t42 = new Trait<>("talla_cm", 15.1, 1);
        Trait<Float> t43 = new Trait<>("peso_kg", 80.5f, 1);
        Trait<String> t44 = new Trait<>("tipo_sangre", "B-", 1);
        Trait<Character> t45 = new Trait<>("sexo", 'M', 1);
        Trait<Boolean> t46 = new Trait<>("ambos_padres", false, 1);
        
        Trait<Integer> t51 = new Trait<>("edad", 22, 1);
        Trait<Double> t52 = new Trait<>("talla_cm", 20.1, 1);
        Trait<Float> t53 = new Trait<>("peso_kg", 100.5f, 1);
        Trait<String> t54 = new Trait<>("tipo_sangre", "O-", 1);
        Trait<Character> t55 = new Trait<>("sexo", 'M', 1);
        Trait<Boolean> t56 = new Trait<>("ambos_padres", false, 1);
        
        Trait<Integer> eval1 = new Trait<>("edad", 22, 1);
        Trait<Double> eval2 = new Trait<>("talla_cm", 20.1, 1);
        Trait<Float> eval3 = new Trait<>("peso_kg", 100.5f, 1);
        Trait<String> eval4 = new Trait<>("tipo_sangre", "O-", 1);
        Trait<Character> eval5 = new Trait<>("sexo", 'M', 1);
        Trait<Boolean> eval6 = new Trait<>("ambos_padres", false, 1);
        
        Item t1 = new Item();
        t1.addTrait(t11);
        t1.addTrait(t12);
        t1.addTrait(t13);
        t1.addTrait(t14);
        t1.addTrait(t15);
        t1.addTrait(t16);
        
        Item t2 = new Item();
        t2.addTrait(t21);
        t2.addTrait(t22);
        t2.addTrait(t23);
        t2.addTrait(t24);
        t2.addTrait(t25);
        t2.addTrait(t26);
        
        Item t3 = new Item();
        t3.addTrait(t31);
        t3.addTrait(t32);
        t3.addTrait(t33);
        t3.addTrait(t34);
        t3.addTrait(t35);
        t3.addTrait(t36);
        
        Item t4 = new Item();
        t4.addTrait(t41);
        t4.addTrait(t42);
        t4.addTrait(t43);
        t4.addTrait(t44);
        t4.addTrait(t45);
        t4.addTrait(t46);
        
        Item t5 = new Item();
        t5.addTrait(t51);
        t5.addTrait(t52);
        t5.addTrait(t53);
        t5.addTrait(t54);
        t5.addTrait(t55);
        t5.addTrait(t56);
        
        baseConocimiento.addItem(t1);
        baseConocimiento.addItem(t2);
        baseConocimiento.addItem(t3);
        baseConocimiento.addItem(t4);
        baseConocimiento.addItem(t5);
        
        //System.out.println("Base de Conocimiento");
        //System.out.println(baseConocimiento.toString());
        
        Item eval = new Item();
        eval.addTrait(eval1);
        eval.addTrait(eval2);
        eval.addTrait(eval3);
        eval.addTrait(eval4);
        eval.addTrait(eval5);
        eval.addTrait(eval6);
        
        InferenceEngine motor = new InferenceEngineKNN(baseConocimiento);
        
        //Filtros
        Filter<Integer> f1 = new Filter<>("edad", 15, Filter.MAYOR);
        Filter<Double> f2 = new Filter<>("talla_cm", 20.1, Filter.MENOR_IGUAL);
        Filter<Float> f3 = new Filter<>("peso_kg", 100.5f, Filter.MAYOR);
        Filter<String> f4 = new Filter<>("tipo_sangre", "O-", Filter.IGUAL);
        Filter<Character> f5 = new Filter<>("sexo", 'M', Filter.DIFERENTE);
        Filter<Boolean> f6 = new Filter<>("ambos_padres", false, Filter.RECHAZAR);
        
        motor.addFilter(f1);
        motor.addFilter(f2);
        motor.addFilter(f3);
        motor.addFilter(f4);
        motor.addFilter(f5);
        motor.addFilter(f6);
        
        Item[] seleccion = new Item[5];
        double[] pesos = new double[5];
        
        seleccion = motor.getSimilarItems(eval, 5);
        System.out.println("Busqueda Item");
        for (Item item : seleccion) {
            System.out.println(item.toString());
        }
        
        pesos = motor.getDistItems(eval, 5);
        System.out.println("Busqueda Pesos");
        for (double peso : pesos) {
            System.out.println(peso);
        }
        
        //System.out.println("item mas cercado: " + motor.getSimilarItem(eval).toString());
        //System.out.println("peso mas cercano: " + motor.getDistItem(eval));
        
    }
}
