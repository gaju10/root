package entity;

import java.util.Objects;

public class Personal {
    private int id;
    private String name;
    private String login;
    private String password;
    private String phone;
    private String email;
    private int prof_id;

    public int getId() {
        return id;
    }

    public Personal setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public Personal setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Personal setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Personal setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Personal setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Personal setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getProf_id() {
        return prof_id;
    }

    public Personal setProf_id(int prof_id) {
        this.prof_id = prof_id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personal personal = (Personal) o;
        return id == personal.id &&
                prof_id == personal.prof_id &&
                Objects.equals(name, personal.name) &&
                Objects.equals(login, personal.login) &&
                Objects.equals(password, personal.password) &&
                Objects.equals(phone, personal.phone) &&
                Objects.equals(email, personal.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, login, password, phone, email, prof_id);
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", prof_id=" + prof_id +
                '}';
    }
}
