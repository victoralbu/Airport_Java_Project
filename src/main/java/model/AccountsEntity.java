package model;

import javax.persistence.*;

@Entity
@Table(name = "accounts", schema = "aeroport")
public class AccountsEntity {
    private int IdUser;
    private Integer sum;
    private UsersEntity usersByIdUser;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        this.IdUser = idUser;
    }

    @Basic
    @Column(name = "sum")
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (IdUser != that.IdUser) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = IdUser;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    public UsersEntity getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(UsersEntity usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    @Override
    public String toString() {
        return "AccountsEntity{" +
                "IdUser=" + IdUser +
                ", sum=" + sum +
                '}';
    }
}
