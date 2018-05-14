package lists;

import java.util.Arrays;

/**
 * 
 * @author peven
 * @param <T> 
 */
public class MyArrayList<T>  {
    
    T[] values;
    int firstAvailableIndex;
    int length;
    
    public MyArrayList(int size){
        values = (T[]) new Object[size];
        firstAvailableIndex = 0;
        length = size;
    }
    
    public MyArrayList(){
        this(12);
    }
    
    public T get(int index){
        if(index > length){
            throw new IllegalArgumentException("Input argument must be lower than amount of elements stored nd larger than zero.");
        }
        return values[index];
    }
    
    public void remove(int index){
        if(index > length || index < 0){
            throw new IllegalArgumentException("Input argument must be lower than amount of elements stored and larger than zero.");
        }
        if(firstAvailableIndex < index) {
            firstAvailableIndex = index;
        }
        values[index] = null;
    }
    
    public void add(T value){
        if(value == null){
            throw new IllegalArgumentException("Null value not allowed.");
        }
        if(firstAvailableIndex == length){
            increaseSize();
            values[firstAvailableIndex] = value;
            firstAvailableIndex++;
        }else {            
            values[firstAvailableIndex] = value;
            firstAvailableIndex = findFirstAvailableIndex();
        }      
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(int i = 0; i < length - 1; i++){
            if(values[i] != null) {
                s.append(values[i].toString() + ", ");  
            }
        }
        s.deleteCharAt(s.length() - 1);
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();
    }
    
    private int findFirstAvailableIndex(){
        for(int i = 0; i < length - 1; i ++){
            if(values[i] == null){
                return i;
            }
        }
        increaseSize();
        return firstAvailableIndex;
    }
    
    public int length () {
        return this.length;
    }
    
    public boolean empty(){
        return this.length == 0;
    }
    
    public int contains(T value){
        if(value == null){
            throw new IllegalArgumentException("Null values not allowed.");
        }
        for(int i = 0; i < length; i++){
            if(values[i] != null && values[i].equals(value)){
                return i;
            }
        }
        return -1; // Not found.
    }
    
    private void increaseSize(){
        firstAvailableIndex = length;
        this.length = length * 2;
        T[] newArray = Arrays.copyOf(values, length);
        this.values = newArray;
    }
}
