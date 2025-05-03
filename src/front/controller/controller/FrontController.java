package front.controller.controller;

import front.controller.dispatcher.Dispatcher;

public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    public void handleReq(String request) {
        System.out.println("Front controller has received a(n) \""+ request +"\" request");
        dispatcher.dispatch(request);
    }

}
