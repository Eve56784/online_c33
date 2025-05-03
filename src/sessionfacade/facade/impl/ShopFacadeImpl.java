package sessionfacade.facade.impl;

import sessionfacade.entity.Order;
import sessionfacade.entity.User;
import sessionfacade.facade.ShopFacade;
import sessionfacade.service.OrderService;
import sessionfacade.service.UserService;

public class ShopFacadeImpl implements ShopFacade {
    private final UserService userService = new UserService();
    private final OrderService orderService = new OrderService();

    @Override
    public Order getOrder(String name, String productName) {
        User user = userService.createUser(name);
        return orderService.createOrder(productName, user);
    }
}
