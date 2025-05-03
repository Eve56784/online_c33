package frontcontroller.controller.impl;

import frontcontroller.controller.HandleReq;

public class AdminController implements HandleReq {
    @Override
    public void handleReq() {
        System.out.println("Admin controller handled request successfully");
    }
}
