package entity;

import java.util.Objects;

public class Treat {
    private int id;
    private String name;
    private int cost;
    private String describe;
    private TreatType type;

    public int getId() {
        return id;
    }

    public Treat setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Treat setName(String name) {
        this.name = name;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public Treat setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public Treat setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public TreatType getType() {
        return type;
    }

    public Treat setType(TreatType type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treat treat = (Treat) o;
        return id == treat.id &&
                cost == treat.cost &&
                Objects.equals(name, treat.name) &&
                Objects.equals(describe, treat.describe) &&
                type == treat.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, cost, describe, type);
    }

    @Override
    public String toString() {
        return "Treat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", describe='" + describe + '\'' +
                ", type=" + type +
                '}';
    }
}
