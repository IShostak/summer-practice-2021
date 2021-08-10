package com.ishostak.toursoverplanet.entity;

import com.ishostak.toursoverplanet.entity.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="order_status")
    private OrderStatus status;
}
