package Projekt3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

    public List<Judgment> parse(String file) {
        String newFile = removeMetadata(file);
        Gson gson = new Gson();
        Type judgementListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(newFile,judgementListType);
    }



    private String removeMetadata(String parsedJson) {
        int start = parsedJson.indexOf("items") + 7;
        int end = parsedJson.indexOf("queryTemplate") - 2;
        return parsedJson.substring(start, end);
    }


    public HashMap<String, Judgment> parser(String [] folderName)
    {


        if(folderName.length != 1)
        {
            System.out.println("nie podano nazwy folderu");
            return null;
        }
        final File folder = new File(folderName[0]);
        if(!folder.isDirectory())
        {
            System.out.println("nie podano nazwy folderu");
            return null;
        }
        HashMap<String, Judgment> hashmap = new HashMap<>();
        List<List<Judgment>> allJudgments = new ArrayList<>();
        File[] files = folder.listFiles();

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
                for(CourtCase courtCase : judgment.courtCases){
                    hashmap.put(courtCase.caseNumber, judgment);
                }
            }

        }
        return hashmap;


    }


}
