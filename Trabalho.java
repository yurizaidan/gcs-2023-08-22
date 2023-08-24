import java.util.ArrayList;

public class main {
public static void main(String Args[]){
ArrayList<Integer> listWithRepeats = new ArrayList<>();
listWithRepeats.add(1);
listWithRepeats.add(5);
listWithRepeats.add(10);
listWithRepeats.add(5);

ArrayList<Integer> listWithoutRepeats = new ArrayList<>();
listWithoutRepeats.add(5);
listWhithoutRepeats.add(6);
listWithoutRepeats.add(7);

System.out.println(hasRepeat(listWithRepeats));
System.out.println(hasRepeat(listWithoutRepeats));

ArrayList<Integer> listWithRepeats = new ArrayList<>();
listWithRepeats.add(1);
listWithRepeats.add(5);
listWithRepeats.add(10);
listWithRepeats.add(5);

ArrayList<Integer> listWithoutRepeats = new ArrayList<>();
listWithoutRepeats.add(5);
listWhithoutRepeats.add(6);
listWithoutRepeats.add(7);

System.out.println(elementoRepetido(listWithRepeats));
System.out.println(elementoRepetido(listWithoutRepeats));

 ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(3);
        lista2.add(4);
        lista2.add(5);

        ArrayList<Integer> resultado = uniao(lista1, lista2);

        System.out.println("União da lista1 e lista2: " + resultado);


}
}

static boolean elementoRepetido(ArrayList<Integer> l) {
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(i).equals(l.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}



public class ExemploUniao {
    public static ArrayList<Integer> uniao(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> resultado = new ArrayList<>();


        for (Integer elemento : l1) {
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }


        for (Integer elemento : l2) {
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }

        return resultado;
}
