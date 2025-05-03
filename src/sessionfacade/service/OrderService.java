package sessionfacade.service;

import sessionfacade.entity.Order;
import sessionfacade.entity.User;

public class OrderService {
        public Order createOrder(String product, User user) {
            System.out.println("-Order info-\n\tProduct: " + product + "\n\tUser: " +user);
            return new Order(1, user, product);
        }
}
