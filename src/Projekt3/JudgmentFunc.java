package Projekt3;

import java.util.*;
import java.util.stream.Collectors;

public class JudgmentFunc {



        HashMap<String,Judgment> judgmentHashMap;

         JudgmentFunc(HashMap<String,Judgment> judgmentHashMap){

            this.judgmentHashMap=judgmentHashMap;
        }


        public String showTextcontent(){
             StringBuilder s = new StringBuilder();
             for(Judgment judgment : judgmentHashMap.values()){
                s.append(judgment.getTextContent() + "\n");
             }
             return s.toString();
        }

        // II
        public String rubrum(String signature){
            Judgment judgment = judgmentHashMap.get(signature);
            StringBuilder string = new StringBuilder();
            string.append("Sygnatura orzeczenia: " + signature + "\n");
            string.append("Sygnatura orzeczenia: " + judgment.getCourtCases() + "\n");
            string.append("Data wydania orzeczenia: " + judgment.getSource().publicationDate + "\n");
            string.append("Rodzaj sądu: " + judgment.getCourtType() + "\n");
            string.append("Sędziowie: " + judgment.getJudges() + "\n");
            return string.toString();
        }

        //V
        public String judgementsPerJudge(String name){
            int result = 0;
            Judge judge=new Judge();
            judge.name=name;
            for(Judgment judgment : judgmentHashMap.values()){
                if(judgment.getJudges().contains(judge)){
                    result++;
                }
            }
            return Integer.toString(result);
        }

    //VI
    public String BestJudges(){
        Map<Judge,Integer> judgeHashMap = new LinkedHashMap<>();
        for(Judgment judgment : judgmentHashMap.values()){
            for (Judge judge : judgment.getJudges()){
                if(judgeHashMap.containsKey(judge)){
                    Integer oldValue = judgeHashMap.get(judge);
                    judgeHashMap.replace( judge, oldValue,oldValue + 1);
                }
                else{
                    judgeHashMap.put(judge,1);
                }
            }
        }
        List<Judge> judges = judgeHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return judges.toString();
    }
    //VII
    public String judgementsPerMonth() {
        Collection<Judgment> judgments = judgmentHashMap.values();
        int[] judgmentsPerMonth = new int[12];
        StringBuilder result = new StringBuilder();
        for (Judgment judgment : judgments) {
            if (!judgment.getSource().publicationDate.isEmpty()) {
                Integer a = Integer.valueOf(judgment.getSource().publicationDate.substring(5, 7));
                judgmentsPerMonth[a - 1]++;
            }
        }
        for (int i = 0; i < 12; i++) {
            result.append(("miesiąc " + (i+1) + Integer.toString(judgmentsPerMonth[i]) + "\n"));
        }

        return result.toString();
    }
    //VIII
    public Map<CourtType,Integer> courtTypeDistribution(){
        Collection<Judgment> judgments = judgmentHashMap.values();
        Map<CourtType,Integer> distribution = new HashMap<>();
        for(Judgment judgment: judgments){
            if(!distribution.containsKey(judgment.getCourtType())){
                distribution.put(judgment.getCourtType(),1);
            }
            else{
                distribution.replace(judgment.getCourtType(),distribution.get(judgment.getCourtType()),distribution.get(judgment.getCourtType())+1);
            }
        }
        return distribution;
    }
    //IX
    public List<String> topLaws(){
        Map<String,Integer> judgeHashMap = new LinkedHashMap<>();
        for(Judgment judgment : judgmentHashMap.values()){
            for (Regulation regulation : judgment.getReferencedRegulations()){
                if(judgeHashMap.containsKey(regulation.journalTitle)){
                    Integer oldValue = judgeHashMap.get(regulation.journalTitle);
                    judgeHashMap.replace( regulation.journalTitle, oldValue,oldValue + 1);
                }
                else{
                    judgeHashMap.put(regulation.journalTitle,1);
                }
            }
        }
        List<String> laws = judgeHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return laws;
    }
    //X
    public double judgesPerJudgment(){
        Collection<Judgment> judgments = judgmentHashMap.values();
        double judges = 0;
        for(Judgment judgment : judgments){
            judges += judgment.getJudges().size();
        }
        return judges/judgments.size();
    }

    public String help (){
            return "dostępne komendy: /n" +
                    "1.rubrum /n" +
                    "2.content /n" +
                    "3.judge /n" +
                    "4.judges /n" +
                    "5.months /n" +
                    "6.courts /n" +
                    "7.regulations /n" +
                    "8.jury /n";

    }
}
