/*

 */
package lists;

/**
 *
 * @author peven
 */
public class ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        for(int i = 0 ; i < 100; i++){
            a.add(i);
        }
        System.out.println(a.toString());
        MyArrayList<String> s = new MyArrayList<>(24);
        String r = "";
         for(int i = 100 ; i < 200; i++){
            r = Character.toString((char)i);
            r+= Character.toString((char) (i + 1));
            s.add(r);
        }
        System.out.println(s);
    }
    
}
