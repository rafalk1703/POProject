package Projekt3;

import java.util.List;

public class Judge
{
    String name;
    String function;
    List<SpecialRole> specialRole;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<SpecialRole> getSpecialRole() {
        return specialRole;
    }

    public void setSpecialRole(List<SpecialRole> specialRole) {
        this.specialRole = specialRole;
    }
}
