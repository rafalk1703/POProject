package Projekt3;

public enum PersonnelType
{
    ONE_PERSON,
    THREE_PERSON,
    FIVE_PERSON,
    SEVEN_PERSON,
    ALL_COURT,
    ALL_CHAMBER,
    JOINED_CHAMBERS;

    public String toString()
    {
        switch(this)
        {
            case ONE_PERSON:
                return "Skład jednoosobowy";
            case THREE_PERSON:
                return "Skład trzyosobowy";
            case FIVE_PERSON:
                return "Skład pięcioosobowy";
            case SEVEN_PERSON:
                return "Skład siedmioosobowy";
            case ALL_COURT:
                return "Skład całego Sądu Najwyższego";
            case ALL_CHAMBER:
                return "Skład pełnej izby";
            case JOINED_CHAMBERS:
                return "Skład połączonych izb";
            default:
                return "Błędne dane";
        }
    }
}
