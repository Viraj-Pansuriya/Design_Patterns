package com.viraj.builder.model;

public class User {

    private final String name;
    private final String address;
    private final String city;
    private final int age;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.city = builder.city;
        this.age = builder.age;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public static class UserBuilder{

        private  String name;
        private  String address;
        private  String city;
        private  int age;

        public UserBuilder(){}

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
