package front.controller.controller;

public class UserController implements HandleReq {
    @Override
    public void handleReq() {
        System.out.println("User controller handled request successfully");
    }
}
