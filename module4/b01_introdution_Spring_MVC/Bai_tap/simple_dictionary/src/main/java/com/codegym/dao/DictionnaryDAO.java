package com.codegym.dao;

import com.codegym.model.Dictionnary;

import java.util.ArrayList;
import java.util.List;

public class DictionnaryDAO {
    private static List<Dictionnary> dic;
    static {
        dic = new ArrayList<>();

        Dictionnary d1 =new Dictionnary();
        d1.setViet("Xin Chao");
        d1.setAnh("Hello");
        dic.add(d1);

        Dictionnary d2 =new Dictionnary();
        d2.setViet("the nao");
        d2.setAnh("how");
        dic.add(d2);

        Dictionnary d3 =new Dictionnary();
        d3.setViet("Quyen vo");
        d3.setAnh("Book");
        dic.add(d3);

        Dictionnary d4 =new Dictionnary();
        d4.setViet("May Tinh");
        d4.setAnh("Computer");
        dic.add(d4);
    }

    public static Dictionnary checkWord(String word){
        for(Dictionnary d: dic){
            if(word.equals(d.getAnh())){
                return d;
            }
        }
        return null;
    }
}
