package lesson10_HWTask2;

public class FullName implements Cloneable{
    private final String name;
    private final String surname;

    public FullName(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    @Override
    public String toString(){
        return "\nName: "+name+"\nSurname: "+surname;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
