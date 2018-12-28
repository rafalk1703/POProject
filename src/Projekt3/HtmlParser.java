package Projekt3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HtmlParser {


    private Document document;


    private Judgment parseFile(String file) {

        Judgment judgment = new Judgment();
        document = Jsoup.parse(file, "UTF-8");


        judgment.setCourtCases(getSignature());
        judgment.setJudges(findJudges());
        judgment.setCourtType(courtType());
        judgment.setReferencedRegulations(findRegulations());
        judgment.setTextContent(findTextContent());
        return judgment;
    }

    public HashMap<String, Judgment> parse(File f)
    {


        HashMap<String, Judgment> hashmap = new HashMap<>();
        List<Judgment> judgments = new ArrayList<>();
        File[] files = f.listFiles();

        if (files == null) {
            System.out.println("Brak plików .Html w tym folderze");
            return null;
        }
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".Html")) {
                judgments.add(parseFile(file.toString()));
            }
        }


        for (Judgment judgment : judgments) {
            hashmap.put(judgment.getCourtCases().get(0).caseNumber, judgment);
        }


        return hashmap;


    }

    private List<CourtCase> getSignature() {
        String string = document.select("war_header").text();
        int index = string.indexOf("-");
        string = string.substring(0, index - 1);
        CourtCase courtCase = new CourtCase(string);
        List<CourtCase> courtCases = new ArrayList<>();
        courtCases.add(courtCase);
        return courtCases;
    }


    private List<Judge> findJudges() {
        Elements elements = document.select("tr.niezaznaczona");
        List<Judge> result = new ArrayList<>();
        for (Element element : elements) {
            if (element.text().contains("Sędziowie")) {
                String[] judges = element.select("td.info-list-value").html().split("<br>");
                for (String string : judges) {
                    Judge judge = new Judge();
                    String name = string.replaceFirst(" \\/(.*?)\\/", "");
                    judge.name = name;
                    judge.specialRole = findRole(string);
                    result.add(judge);
                }
                break;
            }
        }
        return result;
    }


    private List<SpecialRole> findRole(String string) {

        List<SpecialRole> result = new ArrayList<>();
        if (!string.contains("/")) {
            return null;
        }
        int beg = string.indexOf("/");
        int end = string.lastIndexOf("/");
        String role = string.substring(beg, end);
        if (role.contains("sprawozdawca") || role.contains("Sprawozdawca")) {
            result.add(SpecialRole.REPORTING_JUDGE);
        }
        if (role.contains("autor uzasadnienia")) {
            result.add(SpecialRole.REASONS_FOR_JUDGMENT_AUTHOR);
        }
        if (role.contains("przewodniczący") || role.contains("Przewodniczący")) {
            result.add(SpecialRole.PRESIDING_JUDGE);
        }
        return result;
    }

    private CourtType courtType() {
        Elements elements = document.select("tr.niezaznaczona");
        CourtType court = null;
        for (Element element : elements) {
            if (element.text().contains("Sąd")) {
                if (element.text().contains("Administracyjny")) {
                    court = CourtType.ADMINISTRATIVE;
                } else if (element.text().contains("Najwyższy")) {
                    court = CourtType.SUPREME;
                } else if (element.text().contains("Powszechny")) {
                    court = CourtType.COMMON;
                } else if (element.text().contains("Konstytucyjny")) {
                    court = CourtType.CONSTITUTIONAL_TRIBUNAL;
                } else if (element.text().contains("Odwoławcza")) {
                    court = CourtType.NATIONAL_APPEAL_CHAMBER;
                    break;
                }
            }
        }
            return court;
        }


        private List<Regulation> findRegulations () {
            Elements elements = document.select("tr.niezaznaczona");
            List<Regulation> regs = new ArrayList<>();
            for (Element element : elements) {
                if (element.text().contains("Powołane przepisy")) {
                    String x = element.select("td.info-list-value").html();
                    Elements table = Jsoup.parse(x).select("a");
                    Elements table2 = Jsoup.parse(x).select("span.nakt");
                    for (int i = 0; i < table.size(); i++) {
                        Regulation r = new Regulation();
                        r.journalTitle = table.get(i).html() + " - " + table2.get(i).html();
                        regs.add(r);
                    }
                    break;
                }
            }
            return regs;
        }

    private String  findTextContent(){
        Elements elements = document.select("tr.niezaznaczona");
        String result = new String();
        for(Element element : elements){
            if(element.text().contains("Uzasadnienie")){
                result =  element.text().substring(13);
                break;
            }
        }
        return result;
    }






}
