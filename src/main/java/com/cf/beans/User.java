package com.cf.beans;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.accname
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private String accname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.type
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.createtime
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    private String createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.accname
     *
     * @return the value of t_user.accname
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public String getAccname() {
        return accname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.accname
     *
     * @param accname the value for t_user.accname
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setAccname(String accname) {
        this.accname = accname == null ? null : accname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.type
     *
     * @return the value of t_user.type
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.type
     *
     * @param type the value for t_user.type
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createtime
     *
     * @return the value of t_user.createtime
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createtime
     *
     * @param createtime the value for t_user.createtime
     *
     * @mbg.generated Sat Jun 13 12:26:47 EDT 2020
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}