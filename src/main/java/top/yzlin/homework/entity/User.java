package top.yzlin.homework.entity;

import top.yzlin.homework.database.DBField;

public class User {
    private String name;
    private String password;
    private String age;
    private String mail;

    public String getName() {
        return name;
    }

    @DBField("user")
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
