package com.mysupermarket.pojo;

public class UserAccount {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.ua_username
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    private Integer uaUsername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.ua_password
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    private String uaPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.ua_email
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    private String uaEmail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.ua_username
     *
     * @return the value of user_account.ua_username
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public Integer getUaUsername() {
        return uaUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.ua_username
     *
     * @param uaUsername the value for user_account.ua_username
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void setUaUsername(Integer uaUsername) {
        this.uaUsername = uaUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.ua_password
     *
     * @return the value of user_account.ua_password
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public String getUaPassword() {
        return uaPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.ua_password
     *
     * @param uaPassword the value for user_account.ua_password
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void setUaPassword(String uaPassword) {
        this.uaPassword = uaPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.ua_email
     *
     * @return the value of user_account.ua_email
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public String getUaEmail() {
        return uaEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.ua_email
     *
     * @param uaEmail the value for user_account.ua_email
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void setUaEmail(String uaEmail) {
        this.uaEmail = uaEmail;
    }
}