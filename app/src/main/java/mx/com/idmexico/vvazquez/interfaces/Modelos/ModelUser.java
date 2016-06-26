package mx.com.idmexico.vvazquez.interfaces.Modelos;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by sistemas on 25/06/2016.
 */
public class ModelUser {
    private int id;
    private String user;
    private String password;
    private Date lastsession;
    private int remember;



    public ModelUser(int id, String user, String password, Date lastsession, int remember) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.lastsession = lastsession;
        this.remember = remember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastsession() {
        return lastsession;
    }

    public void setLastsession(Date lastsession) {
        this.lastsession = lastsession;
    }

    public int getRemember() {
        return remember;
    }

    public void setRemember(int remember) {
        this.remember = remember;
    }
}
