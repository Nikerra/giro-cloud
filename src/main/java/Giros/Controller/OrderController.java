package Giros.Controller;

import Giros.dao.Entity.GiroOrder;
import Giros.dao.Repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("giroOrder")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping("/current")
    public String processOrder(@Valid GiroOrder giroOrder, Errors errors,
                                SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }
        System.out.println("Giro order=" + giroOrder);
        System.out.println("Giro order id=" + giroOrder.getId());
        System.out.println("Giro id=" + giroOrder.getGiros().get(0));
        orderRepository.save(giroOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
