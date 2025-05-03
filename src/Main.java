import dto.dto.UserDto;
import dto.entity.UserEntity;
import dto.service.UserService;
import frontcontroller.controller.FrontController;
import sessionfacade.entity.Order;
import sessionfacade.facade.impl.ShopFacadeImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------\nSession Facade pattern:");
        ShopFacadeImpl facade = new ShopFacadeImpl();
        Order order = facade.getOrder("Eve", "Laptop");
        System.out.println("------------------------------");

        System.out.println("Data Transfer Object pattern:");
        UserService userService = new UserService();
        UserDto dto = userService.getUserDto();
        UserEntity user = userService.getUser();
        System.out.println(dto);
        System.out.println(user);
        System.out.println("------------------------------");

        System.out.println("Front Controller pattern:");
        FrontController controller = new FrontController();
        controller.handleReq("user");
        controller.handleReq("admin");
        System.out.println("------------------------------");
    }
}