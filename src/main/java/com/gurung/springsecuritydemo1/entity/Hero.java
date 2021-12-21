package com.gurung.springsecuritydemo1.entity;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Hero {
    private int id;
    private String name;
}
