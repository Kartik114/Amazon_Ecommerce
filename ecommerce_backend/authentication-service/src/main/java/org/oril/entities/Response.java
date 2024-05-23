package org.oril.entities;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Response
{
    private String accessToken;
    private String refreshToken;
    private String id;
    private String email;
    private String password;
    private String role;
    private String name;


}
