package front.controller.controller.impl;

import front.controller.controller.HandleReq;

public class UserController implements HandleReq {
    @Override
    public void handleReq() {
        System.out.println("User controller handled request successfully");
    }
}
