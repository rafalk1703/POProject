package Projekt3;

public enum Month
{
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public String toString()
    {
        switch(this)
        {
            case JANUARY:
                return "Styczeń";
            case FEBRUARY:
                return  "Luty";
            case MARCH:
                return "Marzec";
            case APRIL:
                return "Kwiecień";
            case MAY:
                return "Maj";
            case JUNE:
                return "Czerwiec";
            case JULY:
                return "Lipiec";
            case AUGUST:
                return "Sierpień";
            case SEPTEMBER:
                return "Wrzesień";
            case OCTOBER:
                return "Pażdziernik";
            case NOVEMBER:
                return "Listopad";
            case DECEMBER:
                return "Grudzień";
            default:
                return "Błąd";
        }
    }
}