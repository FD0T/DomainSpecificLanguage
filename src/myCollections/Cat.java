package myCollections;

public class Cat {
    int id;
    int size;
    int age;
    public int hash;

    public Cat(int id, int size, int age) {
        this.id = id;
        this.size = size;
        this.age = age;
        this.hash = this.id + this.size + this.age;
    }

    public boolean equals(Cat cat){
        if(this.id == cat.id && this.size == cat.size && this.age == cat.age)
            return true;
        else
            return false;
    }
    public int hashCode(){
        return this.hash;
    }
}
