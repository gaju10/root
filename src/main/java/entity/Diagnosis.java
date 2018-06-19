package entity;

import java.util.Objects;

public class Diagnosis {
    private int id;
    private String name;
    private String tips;

    public String getTips() {
        return tips;
    }

    public Diagnosis setTips(String tips) {
        this.tips = tips;
        return this;
    }

    public int getId() {
        return id;
    }

    public Diagnosis setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diagnosis setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id == diagnosis.id &&
                Objects.equals(name, diagnosis.name) &&
                Objects.equals(tips, diagnosis.tips);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, tips);
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
