package se.lexicon;

import java.lang.String;
import java.util.Arrays;
public class NameRepository {
    private static String[] names = {"Roberto Camacho", "Julius Büchner"};

    public static void main(String[] args) {
        System.out.println(getSize());
        setNames(names);
        for (String str : findAll())
            System.out.println(str);
//        clear();
        add("Simon Elbrink");
        System.out.println(find("Simon Elbrink"));
        System.out.println(Arrays.toString(findByFirstName("Simon")));
        System.out.println(Arrays.toString(findByLastName("Elbrink")));
        System.out.println(update("Simon Elbrink", "Bamse Långhus"));
        for (String str : findAll())
            System.out.println(str);
        remove("Bamse Långhus");
        for (String str : findAll())
            System.out.println(str);
    }


    private static int getSize() {
        return (names.length);
    }

    public static void setNames(String[] names) {
        String[] tempNames = {"Julius Büchner", "Roberto Camacho"};
        for (int i = 0; i < names.length; i++) {
            names[i] = tempNames[i];
        }
    }

    public static void clear() {
        names = new String[]{};
    }

    public static String[] findAll() {
        String[] temp = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            temp[i] = names[i];
        }
        return temp;
    }

    public static String find(final String fullName) {
        for (int i=0;i< names.length;i++){
            if (fullName.equals(names[i])){
                return fullName;
            }
        }
        return null;
    }
    public static boolean add(final String fullName){
        names = Arrays.copyOf(names, names.length+1);
        //      System.arraycopy(names, 0, names, 0, names.length);
        names[names.length-1] = fullName;
        for (int i=0;i< names.length;i++){
            if (fullName.equals(names[i])){
                return false;
            }
        }
        return true;
    }
    public static String[] findByFirstName(final String firstname){
        String[] a = new String[names.length];
        String[] parts;
        int b = 0;
        for(int i=0;i< names.length;i++){
            parts = names[i].split(" ");
            if(parts[0].equals(firstname)) {
                a[b] = parts[0];
                b++;
            }
        }
        return Arrays.copyOf(a, b);
    }
    public static String[] findByLastName(final String lastname){
        String[] d = new String[names.length];
        String[] parts1;
        int e = 0;
        for(int i=0;i< names.length;i++){
            parts1 = names[i].split(" ");
            if(parts1[1].equals(lastname)) {
                d[e] = parts1[1];
                e++;
            }
        }
        return Arrays.copyOf(d, e);
    }
    public static boolean update(final String original, final String updatedName){

        for (int i=0;i< names.length;i++) {

            if(original.equals(names[i])) {
                if(!updatedName.equals(names[i])) {
                    names[i] = names[i].replace(original, updatedName);
                    System.out.println(updatedName);
                    return true;
                }

            }

        }
        return false;
    }
    public static boolean remove(final String fullName){
        int a=0;
        int b=0;
        for(int i=0;i<names.length;i++){
            if(names[a].equals(fullName)){
                a++;
            } else {
                names[b] = names[a];
                a++;
                b++;
            }
        }
        names = Arrays.copyOf(names, b);
        return true;
    }
}
