package Projekt3;

public class Regulation
{
    String journalTitle, text;
    int journalYear, journalNo, journalEntry;

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getJournalYear() {
        return journalYear;
    }

    public void setJournalYear(int journalYear) {
        this.journalYear = journalYear;
    }

    public int getJournalNo() {
        return journalNo;
    }

    public void setJournalNo(int journalNo) {
        this.journalNo = journalNo;
    }

    public int getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(int journalEntry) {
        this.journalEntry = journalEntry;
    }

    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Regulation that = (Regulation) object;
        if(journalYear !=0)
            return journalYear == that.journalYear && journalEntry == that.journalEntry;
        return journalTitle.equals(that.journalTitle);
    }

}
