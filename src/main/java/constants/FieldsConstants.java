package constants;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class FieldsConstants {

    // Diagnosis
    public static final String DIAGNOSIS_ID="id";
    public static final String DIAGNOSIS_NAME="name";
    public static final String DIAGNOSIS_TIP="tips";
    // Personal
    public static final String PERSONAL_ID="id";
    public static final String PERSONAL_NAME="name";
    public static final String PERSONAL_LOGIN="login";
    public static final String PERSONAL_PASSWORD="password";
    public static final String PERSONAL_PHONE="phone";
    public static final String PERSONAL_EMAIL="email";
    public static final String PERSONAL_PROF_ID="profesion_id";
    // Profesion
    public static final String PROFESION_ID="id";
    public static final String PROFESION_NAME="name";
    public static final String PROFESION_TYPE="type";
    // Treat
    public static final String TREAT_ID="id";
    public static final String TREAT_NAME="name";
    public static final String TREAT_COST="cost";
    public static final String TREAT_DESCRIBE="describe";
    public static final String TREAT_TYPE="type";
    // User
    public static final String USER_ID="id";
    public static final String USER_NAME="name";
    public static final String USER_LOGIN="login";
    public static final String USER_PASSWORD="password";
    public static final String USER_EMAIL="email";
    public static final String USER_PHONE="phone";
    public static final String USER_GENDER="gender";
    public static final String USER_BIRTHDAY="birthday";
    //PersonalHasUser
    public static final String PHS_PERSONAL_ID="personal_id";
    public static final String PHS_USER_ID="user_id";
    public static final String PHS_DATE="date";
    //UserHasDiagnosis
    public static final String UHD_USER_ID="user_id";
    public static final String UHD_DIAGNOSIS_ID="diagnosis_id";
    public static final String UHD_DATE="date";
    public static final String UHD_STATUS="status";
    public static final String UHD_TREAT_ID="treat_id";
    

    private FieldsConstants() {
        throw new UnsupportedOperationException("The creation of this object does not make sense");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost/hospitaldb?serverTimezone=UTC","root","1234");
    }
}
