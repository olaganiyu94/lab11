package models.users;

/**
 * Created by wdd on 09/12/16.
 */
import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;

@Entity
public class User extends Model {

    @Id
    private String email;

    @Constraints.Required
    private String role;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String password;

    //Default Constructor
    public User(){

    }
    //Generic query helper for entity User with unique id string
    public static Finder<String,User> find = new Finder<String, User>(User.class);

    public static List<User> findAll(){

        return User.find.all();
    }

    public static User authenticate(String email, String password){

        return find.where().eq("email",email).eq("password", password).findUnique();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
