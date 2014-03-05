import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 * Author: Andrea Cadeddu, cadedduan@gmail.com
 * This file contains all the utility classes for parsing the json.
 * Date: 3/3/14
 */

class Format {
    int width;
    int height;
    String fname;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
class Entry{
    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    Format format;
    Data data;
}

class Entries{
    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    List<Entry> entries;
}

class Pairs{
    private int a;
    private int b;
    private String color;
    public void setA(int a){this.a=a;}
    public void setB(int b){this.b=b;}
    public void setColor(String color){this.color=color;}
    public String getColor(){return color;}
    public int getA(){return a;}
    public int getB(){return b;}
    public Color getRGB() {
        return Color.decode("0x"+color);//a color from the hex key;
    }
}

class Data {
    //well since we are bothering passing a json, maybe is worth to create a decent data structure once for all
    private String smiles;
    private List<Pairs> pairs;
    private String[] hmap;
    public String getSmiles() { return smiles; }
    public List<Pairs> getPairs() { return pairs; }
    public String[] getHmap(){
        if (hmap ==null)
            genHmap();
        return hmap;}


    public void setSmiles(String smiles) { this.smiles = smiles; }
    public void setPairs(List<Pairs> pairs) { this.pairs = pairs; }
    public void genHmap(){
        List<String> hm = new ArrayList<String>();
        for (int i=0;i<pairs.size(); i++){
            //System.out.println(i);
            hm.add(i,pairs.get(i).getColor());
        }
        setHmap(hm);
    }
    public void setHmap(List<String> hmap) {this.hmap =  hmap.toArray(new String[hmap.size()]);} //WTF!!!
    public String toString() {
        return String.format("smiles: %s, pairs %s", smiles, pairs);
    }
}
public class companionfile {

    public Entries parse_json (String json){
        return new Gson().fromJson(json, Entries.class);
    }

}
