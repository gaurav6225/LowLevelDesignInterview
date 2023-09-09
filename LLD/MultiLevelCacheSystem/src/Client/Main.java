package Client;

import CacheSystem.CacheSystem;
import CacheSystem.MultiLevelCacheSystem;
import Utils.Time;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to MultiLevelCacheSystem!!");
        System.out.println("Enter Number of levels");
        int levels = scanner.nextInt();
        int[] readTime = new int[levels];
        int[] writeTime = new int[levels];
        int[] capacities = new int[levels];
        System.out.println("Enter read time, write time, capacity of Each level cache");
        for(int i=0; i<levels;i++) {
            readTime[i] = scanner.nextInt();
            writeTime[i] = scanner.nextInt();
            capacities[i] = scanner.nextInt();
        }

        CacheSystem cacheSystem = new MultiLevelCacheSystem(levels, readTime, writeTime, capacities);

        System.out.println("For inserting into cache select - 1");
        System.out.println("For reading the cache select - 2");
        String key, value;
        Time time = new Time();
        while(true) {
            int request = scanner.nextInt();
            switch (request) {
                case 1 :
                    System.out.println("Enter key, value");
                    key = scanner.next();
                    value = scanner.next();
                    time.setTime(0);
                    cacheSystem.write(key, value, time);
                    System.out.println("Value is successfully written in the cache");
                    System.out.println("Time taken to complete the write operation " + time);
                    break;
                case 2:
                    System.out.println("Enter key to get the value");
                    key = scanner.next();
                    time.setTime(0);
                    value = null;
                    value = cacheSystem.read(key, time);
                    System.out.println("Time taken to complete the read operation " + time);
                    if(value == null) {
                        System.out.println("Value with the specified key is not present");
                    } else {
                        System.out.println("Value returned successfully. Value :" + value);
                    }
                    break;
                default:
                    System.out.println("Invalid request. try again");
            }
         }
    }
}
