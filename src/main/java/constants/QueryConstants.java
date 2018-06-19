package constants;

public final class QueryConstants {
    // Profesion
    public static final String PROFESION_CREATE = "INSERT into profesion (name,type) VALUES (?,?)";
    public static final String PROFESION_GET = "SELECT * from profesion WHERE id=?";
    public static final String PROFESION_GET_ALL = "SELECT * FROM profesion";
    public static final String PROFESION_UPDATE = "UPDATE profesion SET name = ?, type = ? WHERE id = ?";
    public static final String PROFESION_DELETE = "DELETE FROM profesion WHERE id = ?";
    // User
    public static final String USER_CREATE = "INSERT into user (birthday,email,gender,login,name,password,phone) VALUES (?,?,?,?,?,?,?)";
    public static final String USER_GET = "SELECT * from user WHERE id=?";
    public static final String USER_GET_ALL = "SELECT * FROM user";
    public static final String USER_UPDATE = "UPDATE user SET birthday = ?, email = ?,gender=?,login=?,name=?,password=?,phone=? WHERE id = ?";
    public static final String USER_DELETE = "DELETE FROM user WHERE id = ?";
    //Personal
    public static final String PERSONAL_CREATE = "INSERT into personal (name,email,login,password,phone,profesion_id) VALUES (?,?,?,?,?,?)";
    public static final String PERSONAL_GET = "SELECT * from personal WHERE id=?";
    public static final String PERSONAL_GET_ALL = "SELECT * FROM personal";
    public static final String PERSONAL_UPDATE = "UPDATE personal SET name = ?, email = ?,login=?,password=?,phone=?,profesion_id=? WHERE id = ?";
    public static final String PERSONAL_DELETE = "DELETE FROM personal WHERE id = ?";
    //Treat
    public static final String TREAT_CREATE = "INSERT into treat (name,cost,describe,type) VALUES (?,?,?,?)";
    public static final String TREAT_GET = "SELECT * from treat WHERE id=?";
    public static final String TREAT_GET_ALL = "SELECT * FROM treat";
    public static final String TREAT_UPDATE = "UPDATE treat SET name = ?, cost = ?,describe=?,type=? WHERE id = ?";
    public static final String TREAT_DELETE = "DELETE FROM treat WHERE id = ?";
    //Diagnosis
    public static final String DIAGNOSIS_CREATE = "INSERT into diagnosis (name,date,tips,status) VALUES (?,?,?,?)";
    public static final String DIAGNOSIS_GET = "SELECT * from diagnosis WHERE id=?";
    public static final String DIAGNOSIS_GET_ALL = "SELECT * FROM diagnosis";
    public static final String DIAGNOSIS_UPDATE = "UPDATE diagnosis SET name = ?, date = ?,tips=?,status=? WHERE id = ?";
    public static final String DIAGNOSIS_DELETE = "DELETE FROM diagnosis WHERE id = ?";
    //PHU
    public static final String PHU_CREATE = "INSERT into personal_has_user (personal_id,user_id,date) VALUES (?,?,?)";
    //UHD
    public static final String UHD_CREATE = "INSERT into user_has_diagnosis (user_id,diagnosis_id,date,status,treat_id) VALUES (?,?,?,?,?)";


}
