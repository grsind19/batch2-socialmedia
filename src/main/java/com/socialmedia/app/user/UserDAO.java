package com.socialmedia.app.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "socialmedia_user")
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}
