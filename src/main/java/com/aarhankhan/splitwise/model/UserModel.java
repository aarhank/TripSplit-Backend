package com.aarhankhan.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String userFirstName;
    private String userLastName;
    private String userMail;
    private String userPassword;
    private String userMatchingPassword;
}
