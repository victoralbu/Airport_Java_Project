package model;

import com.sun.istack.NotNull;
import javafx.beans.DefaultProperty;
import javafx.print.Collation;

import javax.persistence.*;
import java.nio.charset.Charset;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "aeroport", catalog = "")
public class UsersEntity {
    private int idUser;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String userType;
    private AccountsEntity accountsByIdUser;
    private Collection<ReservationsEntity> reservationsByIdUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", columnDefinition ="")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "usersByIdUser")
    public AccountsEntity getAccountsByIdUser() {
        return accountsByIdUser;
    }

    public void setAccountsByIdUser(AccountsEntity accountsByIdUser) {
        this.accountsByIdUser = accountsByIdUser;
    }

    @OneToMany(mappedBy = "usersByIdUsers",fetch = FetchType.EAGER)
    public Collection<ReservationsEntity> getReservationsByIdUser() {
        return reservationsByIdUser;
    }

    public void setReservationsByIdUser(Collection<ReservationsEntity> reservationsByIdUser) {
        this.reservationsByIdUser = reservationsByIdUser;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "idUser=" + idUser +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", accountsByIdUser=" + accountsByIdUser +
                ", reservationsByIdUser=" + reservationsByIdUser +
                '}';
    }
}
