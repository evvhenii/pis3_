package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    RoleEnum roleEnum;
    Long cashierId;
}
