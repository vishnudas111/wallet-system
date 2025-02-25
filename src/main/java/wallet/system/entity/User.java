package wallet.system.entity;

@Entity
@Table(name = "users")
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

    private String password; // Encrypted

    // Getters and Setters
}

