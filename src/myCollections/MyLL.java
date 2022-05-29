package myCollections;

public class MyLL<T> {
    private int SIZE = 0;
    private Wrapper first;
    private Wrapper mid;
    private Wrapper last;

    public MyLL(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void addFirst(T data){
        Wrapper temp = new Wrapper(data);
        SIZE++;
        if (isEmpty())
            last = temp;
        else
            first.prev = temp;
        temp.next = first;
        first = temp;
        setMid();
    }


    public void addLast(T data){
        SIZE++;
        Wrapper temp = new Wrapper(data);
        if (isEmpty())
            first = temp;
        else
            last.next = temp;
        temp.prev = last;
        last = temp;
        setMid();
    }

    public void addByIndex(T data, int index){
        SIZE++;
        Wrapper cur = first;
        int c = 0;
        while(cur != null && c != index){
            cur = cur.next;
            c++;
        }

        Wrapper temp = new Wrapper(data);
        cur.prev.next = temp;
        temp.prev = cur.prev;
        cur.prev = temp;
        temp.next = cur;
        setMid();
    }

    public T removeFirst(){
        SIZE--;
        Wrapper temp = first;
        if (first.next == null) {
            temp = last;
            last = null;
        }
        else
            first.next.prev = null;
        first = first.next;
        setMid();
        return (T)temp.item;
    }

    public T removeLast(){
        SIZE--;
        Wrapper temp = last;
        if (first.next == null) {
            first = null;
        }
        else
            last.prev.next = null;
        last = last.prev;
        setMid();
        return (T)temp.item;
    }

    public T removeByKey(T key){
        SIZE--;
        Wrapper cur = first;

        while (cur.item != key){
            cur = cur.next;
            if(cur == null)
                return null;
        }

        if (cur == first)
            removeFirst();
        else
            cur.prev.next = cur.next;
        if (cur == last)
            removeLast();
        else
            cur.next.prev = cur.prev;
        setMid();
        return (T) cur.item;
    }
    public T removeByIndex(int index){
        Wrapper cur = mid;
        if (index <= SIZE % 2){
            cur = first;
            int c = 0;
            while(cur != null && c != index){
                cur = cur.next;
                c++;
            }
        }
        if (index > SIZE % 2 && SIZE % 2 == 0){
            cur = last;
            int c = SIZE-1;
            while(cur != null && c != index){
                cur = cur.prev;
                c--;
            }
        }
        if (index > SIZE % 2 + 1 && SIZE % 2 == 1){
            cur = last;
            int c = SIZE-1;
            while(cur != null && c != index){
                cur = cur.prev;
                c--;
            }
        }
        if (cur == first)
            removeFirst();
        else
            cur.prev.next = cur.next;
        if (cur == last)
            removeLast();
        else
            cur.next.prev = cur.prev;
        SIZE--;
        setMid();
        return (T) cur.item;
    }

    public T contains(T key){
        Wrapper cur = first;
        if(cur == null || isEmpty())
            return null;
        while (cur.item != key){
            cur = cur.next;
            if(cur == null)
                return null;
        }
        return (T) cur.item;
    }

    private void setMid(){
        if (SIZE % 2 == 0 ){
            this.mid = null;
        }
        else {
            int i = 1;
            Wrapper temp = first;
            while(i < SIZE / 2 +1){
                i++;
                this.mid = temp;
                temp = temp.next;
            }
        }
    }

    public void print(){
        Wrapper temp = first;
        String str1 = "[ ";
        while(temp != null){
            str1 += temp.item; //.item.hashCode();
            str1 += " ";
            temp = temp.next;
        }
        str1 += "]";
        System.out.println(str1);
    }

    public int length(){
        return this.SIZE;
    }

//    public static void main(String[] args) {
//        MyLL<java.lang.Integer> list = new MyLL();

//        list.addFirst(1);
//        list.addFirst(2);
//        list.addLast(3);
//        list.addByIndex(4,2);
//        list.addLast(6);
//        list.addLast(8);
//        list.addFirst(7);
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);
//        list.print();
//        //System.out.println("Size is " + list.lenght());
//        //int a = list.removeLast();

//        //int b = list.removeByKey(4);
//        list.removeByIndex(6);
//        list.print();
//        //System.out.println(b);
//    }
}
