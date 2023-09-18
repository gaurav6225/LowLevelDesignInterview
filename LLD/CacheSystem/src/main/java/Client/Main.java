package Client;

import com.gaurav.cache.Cache;
import com.gaurav.cache.factories.CacheFactory;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelElement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CacheFactory<String, String> cacheFactory = new CacheFactory<>();
        Cache<String, String> cache= cacheFactory.defaultCache(5);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Cache System");
        while(true) {
            System.out.println("Select one option among the following!!");
            System.out.println("1. To insert the (key, value) into the cache");
            System.out.println("2. To get the value with the specified key");

            int option = scanner.nextInt();
            scanner.nextLine();
            String key, value;
            switch (option) {
                case 1 :
                    System.out.println("Enter Key and value to be inserted");
                    key = scanner.nextLine();
                    value = scanner.nextLine();
                    cache.put(key, value);
                    break;
                case 2:
                    System.out.println("Enter the key!!");
                    key = scanner.nextLine();
                    value = cache.get(key);
                    if(value != null) {
                        System.out.println("Value :" + value);
                    }
                    break;
                default:
                    System.out.println("Invalid option selected. Enter a Valid option!!");
            }
        }
    }
}
