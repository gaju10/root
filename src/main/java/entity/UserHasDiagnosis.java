package entity;

import java.util.Objects;

public class UserHasDiagnosis {
    private int user_id;
    private int diagnosis_id;
    private String date;
    private DiagnosisStatus status;
    private int treat_id;

    public String getDate() {
        return date;
    }

    public UserHasDiagnosis setDate(String date) {
        this.date = date;
        return this;
    }

    public DiagnosisStatus getStatus() {
        return status;
    }

    public UserHasDiagnosis setStatus(DiagnosisStatus status) {
        this.status = status;
        return this;
    }

    public int getTreat_id() {
        return treat_id;
    }

    public UserHasDiagnosis setTreat_id(int treat_id) {
        this.treat_id = treat_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public UserHasDiagnosis setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getDiagnosis_id() {
        return diagnosis_id;
    }

    public UserHasDiagnosis setDiagnosis_id(int diagnosis_id) {
        this.diagnosis_id = diagnosis_id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHasDiagnosis that = (UserHasDiagnosis) o;
        return user_id == that.user_id &&
                diagnosis_id == that.diagnosis_id &&
                treat_id == that.treat_id &&
                Objects.equals(date, that.date) &&
                status == that.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(user_id, diagnosis_id, date, status, treat_id);
    }

    @Override
    public String toString() {
        return "UserHasDiagnosisDAO{" +
                "user_id=" + user_id +
                ", diagnosis_id=" + diagnosis_id +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", treat_id=" + treat_id +
                '}';
    }
}
