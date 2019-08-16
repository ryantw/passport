package io.lker.passport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_enabled")
    private boolean enabled;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="users_roles",
            joinColumns = { @JoinColumn(name="user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name="role_id", referencedColumnName = "id") }
    )
    private List<Role> roles;

}
