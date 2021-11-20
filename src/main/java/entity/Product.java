package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    String code;
    Integer quantity;
    Integer price;
}
