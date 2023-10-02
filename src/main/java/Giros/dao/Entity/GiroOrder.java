package Giros.dao.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "giro_order", schema = "giro-cloud")
public class GiroOrder implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "placed_at")
    private Date placedAt = new Date();


    @NotBlank(message="Delivery name is required")
    @JoinColumn(name = "delivery_name")
    private String deliveryName;

    @NotBlank(message="Street is required")
    @JoinColumn(name = "delivery_street")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    @JoinColumn(name = "delivery_city")
    private String deliveryCity;

    @CreditCardNumber(message = "Not a valid credit card number")
    @JoinColumn(name = "cc_number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    @JoinColumn(name = "cc_expiration")
    private String ccExpiration;

    @Digits(integer = 3,fraction = 0, message = "Invalid CVV number")
    @JoinColumn(name = "cccvv")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Giro.class)
    private List<Giro> giros = new ArrayList<>();

    public void addGiro(Giro giro) {
        this.giros.add(giro);
    }

}
