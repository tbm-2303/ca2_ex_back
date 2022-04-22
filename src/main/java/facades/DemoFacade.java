package facades;

import com.google.gson.JsonObject;
import utils.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;

public class DemoFacade {
    private static DemoFacade instance;
    private static EntityManagerFactory emf;


    //Private Constructor to ensure Singleton
    private DemoFacade() {
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static DemoFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DemoFacade();

        }
        return instance;
    }


    public JsonObject getRandomCatFact() throws IOException {
        return Utility.fetchData("https://catfact.ninja/fact");
    }

    public JsonObject getRandomJoke() throws IOException {
        return Utility.fetchData("https://api.chucknorris.io/jokes/random");
    }


}
