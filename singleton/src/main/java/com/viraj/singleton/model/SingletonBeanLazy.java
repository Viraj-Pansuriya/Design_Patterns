package com.viraj.singleton.model;


// Example of singleton bean
// This will be lazy way of initialize
// get this static method then only object will be created
public class SingletonBeanLazy {

    private static SingletonBeanLazy singletonBeanLazy;

    private SingletonBeanLazy() {
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
    public static SingletonBeanLazy getInstance() {
        if (singletonBeanLazy == null) {
            singletonBeanLazy = new SingletonBeanLazy();
        }
        return singletonBeanLazy;
    }

//    public static SingletonBeanLazy getInstance() {
//        if (singletonBeanLazy == null) {
//            synchronized (SingletonBeanLazy.class) {
//                singletonBeanLazy = new SingletonBeanLazy();
//            }
//        }
//        return singletonBeanLazy;
//    }

}
