package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, unique = true)
    private String encryptedPwd;

    @Builder
    public UserEntity(String email, String name, String userId, String encryptedPwd){
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.encryptedPwd = encryptedPwd;
    }

    public UserEditor.UserEditorBuilder toEditor(){
        return UserEditor.builder()
                .name(name)
                .encryptedPwd(encryptedPwd);
    }

    public void edit(UserEditor userEditor){
        name = userEditor.getName();
        encryptedPwd = userEditor.getEncryptedPwd();
    }
}
