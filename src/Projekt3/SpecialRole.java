package Projekt3;

public enum SpecialRole
{
    PRESIDING_JUDGE,
    REPORTING_JUDGE,
    REASONS_FOR_JUDGMENT_AUTHOR;

    public String toString()
    {
        switch(this)
        {
            case PRESIDING_JUDGE:
                return "Przewodniczacy składu sędziowskiego";
            case REPORTING_JUDGE:
                return "Sędzia sprawozdawca";
            case REASONS_FOR_JUDGMENT_AUTHOR:
                return "Autor uzasadnienia";
            default:
                return "Błąd";
        }
    }
}
