package sample;

public class Temp {
    static String str = "";

    public Temp(String str){ this.str = str;}
    public Temp(){

    }

    public String getStr() {
        System.out.println(str);
        return str;
    }

    public void setStr(String stri) {
        System.out.println(str);
        str = stri;
    }
    @Override
    public String toString(){ return this.str;}
}
