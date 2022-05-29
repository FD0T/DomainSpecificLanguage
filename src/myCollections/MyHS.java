package myCollections;

public class MyHS<T> {
    private int SIZE=0;
    private MyLL bucket0; //private final MyLL<?> bucket;
    private MyLL bucket1;
    private MyLL bucket2;
    private MyLL bucket3;

    public MyHS(){
        bucket0 = new MyLL<>();
        bucket1 = new MyLL<>();
        bucket2 = new MyLL<>();
        bucket3 = new MyLL<>();
    }

    public void put(Object item){
        //System.out.println(item.hashCode());
        switch(item.hashCode() % 4){
            case (0):
                if(!contains((T)item)){
                    bucket0.addLast(item);
                }
                else{
                    System.out.println(item + " is already exists");
                }
                break;
            case (1):
                if(!contains((T)item)) {
                    bucket1.addLast(item);
                }
                else{
                    System.out.println(item + " is already exists");
                }
                break;
            case (2):
                if(!contains((T)item)) {
                    bucket2.addLast(item);
                }
                else{
                    System.out.println(item + " is already exists");
                }
                break;
            case (3):
                if(!contains((T)item)) {
                    bucket3.addLast(item);
                }
                else{
                    System.out.println(item + " is already exists");
                }
                break;
        }
        setSize();
    }

    public void remove(T item){
        switch(item.hashCode() % 4){
            case (0):
                if(contains(item)){
                    bucket0.removeByKey(item);
                }
                else{
                    System.out.println(item + " doesn't exist");
                }
                break;
            case (1):
                if(contains(item)) {
                    bucket1.removeByKey(item);
                }
                else{
                    System.out.println(item + " doesn't exist");
                }
                break;
            case (2):
                if(contains(item)) {
                    bucket2.removeByKey(item);
                }
                else{
                    System.out.println(item + " doesn't exist");
                }
                break;
            case (3):
                if(contains(item)) {
                    bucket3.removeByKey(item);
                }
                else{
                    System.out.println(item + " doesn't exist");
                }
                break;
        }
        setSize();
    }

    public boolean contains(T item){
        switch(item.hashCode() % 4){
            case (0):
                if(bucket0.contains(item) != null){
                    return true;
                }
                break;
            case (1):
                if(bucket1.contains(item) != null){
                    return true;
                }
                break;
            case (2):
                if(bucket2.contains(item) != null){
                    return true;
                }
                break;
            case (3):
                if(bucket3.contains(item) != null){
                    return true;
                }
                break;
        }
        return false;
    }

    public int getSize(){
        return this.SIZE;
    }
    private void setSize(){
        SIZE = bucket0.length() + bucket1.length() + bucket2.length() + bucket3.length();
    }

    public void print(){
        System.out.print("{ ");
        bucket0.print();
        bucket1.print();
        bucket2.print();
        bucket3.print();
        System.out.print(SIZE + " }\n");
    }
}
