package Giros.dao.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GiroOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Giro> giros = new ArrayList<>();

    public void addGiro(Giro giro) {
        this.giros.add(giro);
    }

}
