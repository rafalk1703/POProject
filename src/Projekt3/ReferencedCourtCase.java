package Projekt3;

import java.util.List;

public class ReferencedCourtCase
{
    private String caseNumber;
    private List<Integer> judgmentIds;
    private Boolean generated;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<Integer> getJudgmentIds() {
        return judgmentIds;
    }

    public void setJudgmentIds(List<Integer> judgmentIds) {
        this.judgmentIds = judgmentIds;
    }

    public Boolean getGenerated() {
        return generated;
    }

    public void setGenerated(Boolean generated) {
        this.generated = generated;
    }
}
