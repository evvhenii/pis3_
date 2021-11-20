package entity;

import lombok.*;
import lombok.experimental.PackagePrivate;

import javax.persistence.*;

@Entity
@Table(name = "receipt_entry")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PackagePrivate
public class ReceiptEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receipt_id")
    Receipt receipt;

    @Column(name="product_id")
    Long productId;

    @Column(name="quantity")
    Integer quantity;

    @Column(name="sum")
    Long sum;

    @Override
    public String toString() {
        return "ReceiptEntry{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", sum=" + sum +
                ", receiptId=" + receipt.getId() +
                '}';
    }
}
