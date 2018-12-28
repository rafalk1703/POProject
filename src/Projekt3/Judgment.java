package Projekt3;

import java.util.Date;
import java.util.List;

public class Judgment
{
    private int id;
    private CourtType courtType;
    private List<CourtCase> courtCases;
    private JudgmentType judgmentType;
    private List<Judge> judges;
    private JudgmentSource judgmentSource;
    private List<String> courtReporters;
    private String decision, summary, textContent;
    private List<String> legalBases;
    private List<Regulation> referencedRegulations;
    private List<String> keywords;
    private List<ReferencedCourtCase> referencedCourtCases;
    private String receiptDate;
    private String meansOfAppeal, judgmentResult;
    private List<String> lowerCourtJudgments;
    private List<Chamber> chambers;


    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public CourtType getCourtType() {

        return courtType;
    }

    public void setCourtType(CourtType courtType) {

        this.courtType = courtType;
    }

    public List<CourtCase> getCourtCases() {

        return courtCases;
    }

    public void setCourtCases(List<CourtCase> courtCases) {

        this.courtCases = courtCases;
    }

    public JudgmentType getJudgmentType() {

        return judgmentType;
    }

    public void setJudgmentType(JudgmentType judgmentType) {

        this.judgmentType = judgmentType;
    }


    public List<Judge> getJudges() {

        return judges;
    }

    public void setJudges(List<Judge> judges) {

        this.judges = judges;
    }

    public List<String> getCourtReporters() {

        return courtReporters;
    }

    public void setCourtReporters(List<String> courtReporters) {

        this.courtReporters = courtReporters;
    }

    public String getDecision() {

        return decision;
    }

    public void setDecision(String decision) {

        this.decision = decision;
    }


    public List<Regulation> getReferencedRegulations() {

        return referencedRegulations;
    }

    public void setReferencedRegulations(List<Regulation> referencedRegulations) {

        this.referencedRegulations = referencedRegulations;
    }

    public List<String> getKeywords() {

        return keywords;
    }

    public void setKeywords(List<String> keywords) {

        this.keywords = keywords;
    }

    public List<ReferencedCourtCase> getReferencedCourtCases() {

        return referencedCourtCases;
    }

    public void setReferencedCourtCases(List<ReferencedCourtCase> referencedCourtCases) {

        this.referencedCourtCases = referencedCourtCases;
    }

    public String getReceiptDate() {

        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {

        this.receiptDate = receiptDate;
    }

    public String getMeansOfAppeal() {

        return meansOfAppeal;
    }

    public void setMeansOfAppeal(String meansOfAppeal) {

        this.meansOfAppeal = meansOfAppeal;
    }

    public String getJudgmentResult() {

        return judgmentResult;
    }

    public void setJudgmentResult(String judgmentResult) {

        this.judgmentResult = judgmentResult;
    }


    public List<Chamber> getChambers() {

        return chambers;
    }

    public void setChambers(List<Chamber> chambers) {

        this.chambers = chambers;
    }

    public List<String> getLowerCourtJudgements() {

        return lowerCourtJudgments;
    }

    public void setLowerCourtJudgements(List<String> lowerCourtJudgements) {

        this.lowerCourtJudgments = lowerCourtJudgements;
    }

    public void setSource(JudgmentSource judgmentSource) {

        this.judgmentSource=judgmentSource;
    }
    public JudgmentSource getSource(){

        return judgmentSource;
    }


}
