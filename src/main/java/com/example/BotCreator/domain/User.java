package com.example.BotCreator.domain;

import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.security.MessageDigest;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private static final Random TOKEN_CREATOR=new Random();
    private String firstname;
    private String lastname;
    private String email;
    private String USERTOKEN;

    @ElementCollection(targetClass = BotInfo.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "user_bot", joinColumns =@JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<BotInfo> botInfoSet;

    public User(UserInfo info){
        this.firstname=info.getFirst_name();
        this.email=info.getEmail();
        this.lastname=info.getLast_name();
        this.USERTOKEN=info.getToken();
    }

    User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return firstname;
    }

    public void setFirst_name(String first_name) {
        this.firstname = first_name;
    }

    public String getLast_name() {
        return lastname;
    }

    public void setLast_name(String last_name) {
        this.lastname = last_name;
    }

    public String getUSER_TOKEN() {
        return USERTOKEN;
    }

    public void setUSER_TOKEN(String USER_TOKEN) {
        this.USERTOKEN = USER_TOKEN;
    }

    public Set<BotInfo> getBotInfoSet() {
        return botInfoSet;
    }

    public void setBotInfoSet(Set<BotInfo> botInfoSet) {
        this.botInfoSet = botInfoSet;
    }

    public static String generate_token(){
        String value =String.valueOf(TOKEN_CREATOR.nextFloat());
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes(StandardCharsets.UTF_8));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return sha1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
