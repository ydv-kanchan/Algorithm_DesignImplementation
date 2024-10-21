// package HashTable;

// import java.util.*;
 
// public class HashTableChaining {

//     static class Entry {
//         int key;
//         String value;

//         public Entry(int key, String value) {
//             this.key = key;
//             this.value = value;
//         }
//     }
    
//     public int size;
//     public LinkedList<Entry>[] table;

//     public HashTableChaining(int size) {
//         this.size = size;
//         table = new LinkedList[size];
//         for(int i=0;i<size;i++){
//             table[i] = new LinkedList<>();
//         }
//     }

//     public int hash(int key) 
//     {
//         return key % size;
//     }
    
//     public void put(int key, String value) {
//         int index = hash(key);
//         for (Entry entry : table[index]) {
//             if (entry.key == key) {
//                 entry.value = value;
//                 return;
//             }
//         }
//         table[index].add(new Entry(key, value));
//     }

//     public String get(int key) {
//         int index = hash(key);
//         for (Entry entry : table[index]) {
//             if (entry.key == key) {
//                 return entry.value;
//             }
//         }
//         return "no value found";
//     }
    

//     public static void main(String[] args) {
//         HashTableChaining hashtable = new HashTableChaining(10);
//         hashtable.put(123, "Kanchan");
//         hashtable.put(245, "Jasjeet");
//         hashtable.put(213, "Kashika");

//         System.out.println(hashtable.get(123));
//         System.out.println(hashtable.get(213));
//         System.out.println(hashtable.get(345));
//         System.out.println(hashtable.get(245));
//     }
// }