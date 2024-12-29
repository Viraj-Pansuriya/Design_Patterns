import models.Observer;
import models.Subject;
import models.impl.Blogsite;
import models.impl.Subscriber;

public class Main {
    public static void main(String[] args) {


        // created subject
        Subject blogsite = new Blogsite();

        // created subscribers
        Observer subscriber1 = new Subscriber("John");
        Observer subscriber2 = new Subscriber("Mick");
        Observer subscriber3 = new Subscriber("Paul");


        // register subscribers
        blogsite.subscribe(subscriber1);
        blogsite.subscribe(subscriber2);
        blogsite.subscribe(subscriber3);

        // notify subscribers
        blogsite.notifyObservers("New blog on India has been uploaded");

        // unsubscribe subscriber
        blogsite.unsubscribe(subscriber1);

        System.out.println();

        // notify subscribers
        blogsite.notifyObservers("Please share your thoughts on recent uploads");



    }
}
