import java.util.ArrayList;
import java.lang.Integer;
import java.util.Random;

public class Quicksort {
    public static ArrayList<ArrayList<Integer>> partition(ArrayList<Integer> liste, Integer pivot){
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        for (Integer element: liste){
            if (element < pivot){
                left.add(element);
            }
            else if (element > pivot) {
                right.add(element);
            }
            else {
                equal.add(element);
            }
        }
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(left);
        answer.add(equal);
        answer.add(right);

        return answer;
    }

    public static ArrayList<Integer> quicksort(ArrayList<Integer> liste){
        if (liste.size() <= 1) { return liste; }

        Integer pivot = liste.get(0);
        ArrayList<ArrayList<Integer>> parti = partition(liste, pivot);

        ArrayList<Integer> answer = new ArrayList<>();
        answer.addAll(quicksort(parti.get(0))); //liste gauche, plus petit que pivot, recursif
        answer.addAll(parti.get(1)); //liste equal, meme nombre que pivot
        answer.addAll(quicksort(parti.get(2))); // liste droite, plus grand que pivot, recursif

        return answer;
    }

    public static void randomInit(ArrayList<Integer> input,int size){
        Random random = new Random();
        for (int i = 0; i <= size; i++){
            input.add(random.nextInt(100));
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(3);
        test1.add(5);
        test1.add(8);
        test1.add(1);
        test1.add(2);
        test1.add(6);
        test1.add(7);
        test1.add(9);
        test1.add(4);

        System.out.println("Liste non trie de test 1: " + test1);
        System.out.println("Liste trie de test 1: " + quicksort(test1));
        System.out.println("-----------------------------");

        ArrayList<Integer> test2 = new ArrayList<>();
        randomInit(test2, 20);
        System.out.println("Liste non trie de test 2: " + test2);
        long duree = System.nanoTime();
        System.out.println("Liste trie de test 2: " + quicksort(test2));
        System.out.println("Temps de run en milliseconde: " + (System.nanoTime() - duree)/1_000_000.0);

        System.out.println("-----------------------------");
        ArrayList<Integer> test3 = new ArrayList<>();
        randomInit(test3, 50);
        System.out.println("Liste non trie de test 3: " + test3);
        duree = System.nanoTime();
        System.out.println("Liste trie de test 3: " + quicksort(test3));
        System.out.println("Temps de run en milliseconde: " + (System.nanoTime() - duree)/1_000_000.0);

        System.out.println("-----------------------------");
        ArrayList<Integer> test4 = new ArrayList<>();
        randomInit(test4, 100);
        System.out.println("Liste non trie de test 4: " + test4);
        duree = System.nanoTime();
        System.out.println("Liste trie de test 4: " + quicksort(test4));
        System.out.println("Temps de run en milliseconde: " + (System.nanoTime() - duree)/1_000_000.0);

        System.out.println("-----------------------------");
        ArrayList<Integer> test5 = new ArrayList<>();
        randomInit(test5, 500);
        System.out.println("Liste non trie de test 5: " + test5);
        duree = System.nanoTime();
        System.out.println("Liste trie de test 5: " + quicksort(test5));
        System.out.println("Temps de run en milliseconde: " + (System.nanoTime() - duree)/1_000_000.0);

        System.out.println("-----------------------------");
        ArrayList<Integer> test6 = new ArrayList<>();
        randomInit(test6, 1000);
        System.out.println("Liste non trie de test 6: " + test6);
        duree = System.nanoTime();
        System.out.println("Liste trie de test 6: " + quicksort(test6));
        System.out.println("Temps de run en milliseconde: " + (System.nanoTime() - duree)/1_000_000.0);
    }
}
