package front.controller.controller.impl;

import front.controller.controller.HandleReq;

public class AdminController implements HandleReq {
    @Override
    public void handleReq() {
        System.out.println("Admin controller handled request successfully");
    }
}
