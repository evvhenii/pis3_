package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cashier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    Integer age;
    RoleEnum roleEnum;
    String password;
}
