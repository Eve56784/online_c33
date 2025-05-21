public class XMLConfigBean {

    public void init(){
        System.out.println("XML config bean was initialized");
    }
    public void greet(){
        System.out.println("Hello (XMLConfigBean)!");
    }

    public void preDestroy(){
        System.out.println("XML config bean's gonna be destroyed");
    }
}
