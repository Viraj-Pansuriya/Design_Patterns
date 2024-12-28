package com.viraj.singleton.Service;

import com.viraj.singleton.model.Dog;
import com.viraj.singleton.model.SingletonBeanLazy;
import com.viraj.singleton.model.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataPrintingService {

    private final Dog dog;
    public DataPrintingService(Dog dog) {
        this.dog = dog;
    }

    @PostConstruct
    public void init() {
        System.out.println("DataPrintingService is created");
    }

    public void printData() {


        // here in previous service , we have name of Dog from husky --> pug
        // it is being changes here
        // it's prove that both of dog are same
        System.out.println("Dog is : " + dog);

        // here we have created new dog , which is different that injected one.
        Dog dog1 = new Dog("second dog" , "1500");
        System.out.println("newly added dog is : " + dog1);

        // below we can see two different vehicle object will be created.
        Vehicle vehicle = new Vehicle("chetak" , "scooter" , "12000");
        System.out.println("Vehicle number 1 is : " + vehicle);

        Vehicle vehicle1 = new Vehicle("civic" , "car" , "1200000");
        System.out.println("Vehicle number 2 is : " + vehicle1);

        // can not create new instance of singleton bean
       // SingletonBean singletonBean = new SingletonBean();

        SingletonBeanLazy singletonBeanLazy = SingletonBeanLazy.getInstance();
        System.out.println("Singleton bean is : " + singletonBeanLazy);

        SingletonBeanLazy singletonBeanLazy1 = SingletonBeanLazy.getInstance();
        System.out.println("Singleton bean is : " + singletonBeanLazy1);

        System.out.println("Both singleton lazy bean are same??  : " + (singletonBeanLazy.hashCode() == singletonBeanLazy1.hashCode()));


        /**
         *
         *      Thread safety for lazy bean.
         * **/

        /**
         * this SingletonBeanLazy::getInstance is fancy way of creating this task (Runnable is functional interface)
         * */
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                SingletonBeanLazy.getInstance();
//            }
//        };


        /**
         * if you call  getInstance() which dont have synchronised block ,
         * you will end up creating  multiple instance of singleton bean
         * **/
//        for(int i = 0 ; i < 10 ; i++) {
//            new Thread(SingletonBeanLazy::getInstance).start();
//        }

    }

}
