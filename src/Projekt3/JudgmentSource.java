package Projekt3;

public class JudgmentSource
{
    CourtType code;
    String judgmentUrl;
    String judgmentId, publisher, reviser;
    String publicationDate;

    public enum CourtType
    {
        COMMON_COURT,
        SUPREME_COURT,
        CONSTITUTIONAL_TRIBUNAL,
        NATIONAL_APPEAL_CHAMBER;

        public String toString()
        {
            switch(this)
            {
                case COMMON_COURT: return "Sąd powszechny";
                case SUPREME_COURT: return "Sąd Najwyższy";
                case CONSTITUTIONAL_TRIBUNAL: return "Trybunał Konstytucyjny";
                case NATIONAL_APPEAL_CHAMBER: return "Krajowa Izba Odwoławcza";
                default: return "Błąd";
            }
        }
    }
}
