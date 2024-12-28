package com.viraj.singleton.Service;

import com.viraj.singleton.model.Dog;
import com.viraj.singleton.model.SingletonBeanLazy;
import com.viraj.singleton.model.Vehicle;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Slf4j
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

    public void printData()  {


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


        /**
        * ways to break singleton pattern
        * */

        /** way 1:
         *
          */
        try{

            /**
             *
             * here you can break singleton pattern , we are making constructor public and then try to create new instance
             *
             * **/
            Constructor<SingletonBeanLazy> declaredConstructor = SingletonBeanLazy.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            SingletonBeanLazy singletonBeanLazyNewInstance = declaredConstructor.newInstance();
            System.out.println("Singleton bean is : " + singletonBeanLazyNewInstance);
            /**
             *
             * solution to avoid creating new instance
             * 1) if instance is created -> throw Exception inside constructor.
             * 2) rather , create a ENUM instead of class:
             * ref : https://www.youtube.com/watch?v=zHWusHi9Nt0&list=PL0zysOflRCek8kmc_jYl_6C7tpud7U2V_&index=3
             * **/

        }

        catch (Exception e){
            System.out.println(("Error while creating new instance of singleton bean : " +  e.getMessage()));
        }

        /**
         * way 2 : serialization and deserialization
         * **/

        SingletonBeanLazy bean1 = SingletonBeanLazy.getInstance();
        System.out.println("Hash code of bean1 is : " + bean1.hashCode());

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SingletonBeanLazy.obj"));
            oos.writeObject(bean1);
            System.out.println("Serialized singleton bean");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SingletonBeanLazy.obj"));
            SingletonBeanLazy bean2 = (SingletonBeanLazy) ois.readObject();
            System.out.println("Deserialized singleton bean");
            System.out.println("Hash code of bean2 is : " + bean2.hashCode());
        }
        catch (Exception e){
            System.out.println("Error while creating new instance of singleton bean : " +  e.getMessage());
        }

        /**
         * created readResolve() method in singleton class which prevents creating new instance
         * */


        /**
         * way 3 : cloning
         *
         * */

        try{

            SingletonBeanLazy bean3  = (SingletonBeanLazy) bean1.clone();
            System.out.println("Cloned singleton bean");
            System.out.println("Hash code of bean3 is : " + bean3.hashCode());
        }
        catch (CloneNotSupportedException e){
            System.out.println("Error while creating new instance of singleton bean : " +  e.getMessage());
        }








        /**
         *
         * link : https://www.geeksforgeeks.org/singleton-design-pattern/
         *
         * **/

    }

}
