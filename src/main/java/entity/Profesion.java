package entity;

import java.util.Objects;

public class Profesion {
    private int id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public Profesion setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Profesion setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Profesion setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesion profesion = (Profesion) o;
        return id == profesion.id &&
                Objects.equals(name, profesion.name) &&
                Objects.equals(type, profesion.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        return "Profesion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
