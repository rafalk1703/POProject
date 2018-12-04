package Projekt3;

import java.util.*;

public class JudgmentFunc {

    //In progress...

        HashMap<String,Judgment> judgmentHashMap;



        // ii. umożliwiał wyświetlanie metryki (rubrum)
        public String rubrum(String signature){
            Judgment judgment = judgmentHashMap.get(signature);
            String string = "";
            string+="Sygnatura orzeczenia: " + judgment.getCourtCases();
            string+="Data wydania orzeczenia: " + judgment.getSource().publicationDate;
            string+="Rodzaj sądu: " + judgment.getCourtType();
            string+="Sędziowie: " + judgment.getJudges();
            return string;
        }

        //v. wyświetlał liczbę orzeczeń dla wybranego sędziego
        public String judgementsPerJudge(String judge){
            int i = 0;
            for(Judgment judgment : judgmentHashMap.values()){
                if(judgment.getJudges().contains(judge)){
                    i++;
                }
            }
            if(i==0)
                return "brak orzeczeń";
            else
                return Integer.toString(i);
        }

}
