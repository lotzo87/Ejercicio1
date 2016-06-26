package mx.com.idmexico.vvazquez.interfaces.Modelos;

/**
 * Created by sistemas on 19/06/2016.
 */
public class ModelItem {
    private int id;
    private  String name;
    private String description;
    private int resource;

    public ModelItem(int id, String name, String description, int resource)
    {
        this.id= id;
        this.name= name;
        this.description = description;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}