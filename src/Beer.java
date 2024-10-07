import java.io.Serializable;
import java.util.Comparator;

public class Beer implements Serializable {
    String name;
    String style;
    Double strength;
    public Beer(String name, String style, Double strength) {
        this.name = name;
        this.style = style;
        this.strength = strength;
    }
    public String getName() {
        return name;
    }
    public String getStyle() {
        return style;
    }
    public Double getStrength() {
        return strength;
    }
    @Override
    public String toString(){
        return "Name: " + name + ", Style: " + style + ", Strength: " + strength;
    }

}
