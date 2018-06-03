package sample;

public class Lection {
    private int id, page_count;
    private String lec_name, p, typeFile;

    public Lection(int id,int page_count, String lec_name, String p, String typeFile){
        this.id = id;
        this.p = p;
        this.page_count = page_count;
        this.lec_name = lec_name;
        this.typeFile = typeFile;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public int getId() {
        return id;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLec_name() {
        return lec_name;
    }

    public void setLec_name(String lec_name) {
        this.lec_name = lec_name;
    }
    @Override
    public String toString(){
        return this.lec_name;
    }
}
