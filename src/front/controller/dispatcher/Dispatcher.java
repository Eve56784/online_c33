package front.controller.dispatcher;

import front.controller.controller.UserController;
import front.controller.controller.AdminController;

public class Dispatcher {
    private AdminController adminController;
    private UserController userController;

    public Dispatcher() {
        this.adminController = new AdminController();
        this.userController = new UserController();
    }

    public void dispatch(String req){
        if(req.equalsIgnoreCase("admin"))
            adminController.handleReq();
        else if(req.equalsIgnoreCase("user"))
            userController.handleReq();
        else
            System.out.println("Message from dispatcher: Invalid request");
    }
}
