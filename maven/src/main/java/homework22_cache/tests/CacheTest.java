package homework22_cache.tests;

import homework22_cache.Cache;
import homework22_cache.models.User;

/**
 * @author Aleksandr Khatsaiuk
 * @version 1.0
 *
 * Class for functionality tests
 */
public class CacheTest {
    public static void main(String[] args) throws InterruptedException {
        User oleg = new User("Oleg", "Olegov", 18, "0675543438", "oleg@gmail.com");
        User dima = new User("Dmitry", "Dmitriev", 28, "0975678275", "dima@gmail.com");
        User sasha = new User("Aleksandr", "Aleksandrov", 35, "0506504675", "sasha@gmail.com");
        User maks = new User("Maksim", "Maksimov", 32, "0976852008", "maks@gmail.com");
        User yura = new User("Yuri", "Yuriev", 26, "0672281337", "yura@gmail.com");
        Cache cache = new Cache(4, 4);

        cache.put("oleg", oleg);
        cache.put("dima", dima);
        cache.put("sasha", sasha);
        cache.put("maks", maks);

        cache.printAllValues();

        System.out.println(cache.get("oleg")); // "oleg" is more used now
        System.out.println(cache.get("sasha")); // "sasha" is more used now

        //cache is full. "yura" will replace "dima", because "dima" is less used and was added earlier than other objects
        cache.put("yura", yura);

        Thread.sleep(3000);
        cache.printAllValues(); // cache will be cleared in one second

        Thread.sleep(1000);
        cache.printAllValues(); // cache is empty
    }
}
