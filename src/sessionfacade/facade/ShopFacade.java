package sessionfacade.facade;

import sessionfacade.entity.Order;

public interface ShopFacade {
    Order getOrder(String name, String productName);
}
