import java.util.*;

public class FractionalKnamsack {
    static class Item {
        int price;
        int weight;
        int costPU;

        Item(int p, int w) {
            price = p;
            weight = w;
            costPU = p / w;
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        items.sort(new Comparator<Item>(){
            @Override //this is an anonmous class
            public int compare(Item o1, Item o2) {
                //todo auto generated method stub
                return (int) (o2.costPU - o1.costPU);
            }
        });

        System.out.println(items);
    }
}
