package Projekt3;

public class Regulation
{
    String journalTitle, text;
    int journalYear, journalNo, journalEntry;

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
