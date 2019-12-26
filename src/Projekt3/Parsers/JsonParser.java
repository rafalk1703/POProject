package Projekt3.Parsers;

import Projekt3.CourtCase;
import Projekt3.Judgment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {

    public List<Judgment> parse(String file) {
        String newFile = removeMetadata(file);
        Gson gson = new Gson();
        Type judgementListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(newFile,judgementListType);
    }



    private String removeMetadata(String json) {
        int start = json.indexOf("items") + 7;
        int end = json.indexOf("queryTemplate") - 2;
        return json.substring(start, end);
    }


    public HashMap<String, Judgment> parser(File f)
    {



        HashMap<String, Judgment> hashmap = new HashMap<>();
        List<List<Judgment>> allJudgments = new ArrayList<>();
        File[] files = f.listFiles();

        if(files == null)
        {
            System.out.println("Brak plików .json w tym folderze");
            return null;
        }
        for(File file : files)
        {
            if(file.isFile() && file.getName().endsWith(".json"))
            {
                allJudgments.add(parse(file.toString()));
            }
        }

        for(List<Judgment> list : allJudgments){
            for(Judgment judgment : list){
                for(CourtCase courtCase : judgment.getCourtCases()){
                    hashmap.put(courtCase.getCaseNumber(), judgment);
                }
            }

        }
        return hashmap;


    }


}
