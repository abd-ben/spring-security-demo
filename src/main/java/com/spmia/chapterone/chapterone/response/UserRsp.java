package com.spmia.chapterone.chapterone.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRsp {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String token;
}
