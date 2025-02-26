package wallet.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import wallet.system.helper.Role;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;
    private double balance;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN or USER

    private String password;

}

