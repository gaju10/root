package entity;

import java.util.Objects;

public class PersonalHasUser {
    private int personal_id;
    private int user_id;
    private String date;

    public int getPersonal_id() {
        return personal_id;
    }

    public PersonalHasUser setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public PersonalHasUser setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public PersonalHasUser setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalHasUser that = (PersonalHasUser) o;
        return personal_id == that.personal_id &&
                user_id == that.user_id &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personal_id, user_id, date);
    }

    @Override
    public String toString() {
        return "PersonalHasUser{" +
                "personal_id=" + personal_id +
                ", user_id=" + user_id +
                ", date='" + date + '\'' +
                '}';
    }
}
