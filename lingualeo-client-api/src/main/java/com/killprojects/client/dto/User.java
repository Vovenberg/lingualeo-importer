package com.killprojects.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String user_id;
    private String nickname;
    private String meatballs;


}
