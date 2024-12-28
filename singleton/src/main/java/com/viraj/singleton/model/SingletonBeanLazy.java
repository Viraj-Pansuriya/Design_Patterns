package com.viraj.singleton.model;


import java.io.Serial;
import java.io.Serializable;

// Example of singleton bean
// This will be lazy way of initialize
// get this static method then only object will be created
public class SingletonBeanLazy implements Serializable , Cloneable {

    private static SingletonBeanLazy singletonBeanLazy;

    private SingletonBeanLazy() {

        // by doing this we make sure by changing accessibility of constructor to public also,
        // we are not allow to create new instance.
        if(singletonBeanLazy!= null){
            throw new RuntimeException("You are trying to break singleton pattern");
        }
        System.out.println("SingletonBean is created");
    }

    /**
    this way of creating instance is not a thread safe,
     let say more than one thread land to this method , all of them will find instance == null ,
     and all thread will create new instance

     approach :
     1)  public synchronized  static SingletonBeanLazy getInstance()
            use method synchronization.
            cons : will block entire method

     2) block only instance creating part in a synchronized manner.
    * */
//    public static SingletonBeanLazy getInstance() {
//        if (singletonBeanLazy == null) {
//            singletonBeanLazy = new SingletonBeanLazy();
//        }
//        return singletonBeanLazy;
//    }

    public static SingletonBeanLazy getInstance() {
        if (singletonBeanLazy == null) {
            synchronized (SingletonBeanLazy.class) {
                if(singletonBeanLazy == null) singletonBeanLazy = new SingletonBeanLazy();
            }
        }
        return singletonBeanLazy;
    }

    // make sure while deserialization it is not creating new instance.
    @Serial
    public Object readResolve() {
        return singletonBeanLazy;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return singletonBeanLazy;
        // here we have passed same instance
        // which make sure super.clone() won't create new instance
    }

}
