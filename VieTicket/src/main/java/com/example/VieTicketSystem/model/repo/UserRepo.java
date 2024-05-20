package com.example.VieTicketSystem.model.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VieTicketSystem.model.entity.User;

@Repository
public class UserRepo {
    public void EditImgUser(String img, int id) throws Exception {

        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "UPDATE User SET avatar = ? where user_id = ?");
        ps.setString(1, img);
        ps.setInt(2, id);
        ps.executeUpdate();
        ps.close();
    }

    public void editProfile(String name, String email, String phone, Date dob, char gender, int user_id)
            throws Exception {
        Class.forName(Baseconnection.nameClass);
        Connection con = DriverManager.getConnection(Baseconnection.url, Baseconnection.username,
                Baseconnection.password);
        PreparedStatement ps = con.prepareStatement(
                "UPDATE User SET full_name = ?, phone = ?, dob= ?, gender = ?, email = ? where user_id = ?");
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.setDate(3, dob);
        ps.setString(4, String.valueOf(gender));
        ps.setString(5, email);
        ps.setInt(6, user_id);
        ps.executeUpdate();
        ps.close();

    }
}
