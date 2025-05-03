package sessionfacade.entity;

public class Order {
    private int id;
    private String product;
    private User user;

    public Order(int id, User user, String product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }


    public String getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setId(int id) {
        this.id = id;
    }
}
