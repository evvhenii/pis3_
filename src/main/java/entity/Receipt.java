package entity;

import lombok.*;
import lombok.experimental.PackagePrivate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "receipt")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PackagePrivate
public class Receipt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column(name="total_price")
    Long totalPrice;

    @Column(name="cashier_id")
    Long cashierId;

    @Column(name="date_time")
    Date dateTime;

    @OneToMany(mappedBy="receipt", fetch = FetchType.EAGER)
    List<ReceiptEntry> entries;
}
