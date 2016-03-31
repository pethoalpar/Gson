package com.pethoalpar.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        JsonObject json = new JsonObject();
        json.addProperty("name","John Doe");
        json.addProperty("age",36);
        System.out.println(json.toString());
        Person person = new Gson().fromJson(json,Person.class);
        System.out.println("Name "+person.getName()+ "  Age:"+person.getAge());

        JsonArray jsonArray = new JsonArray();
        for(int i = 1; i<=3; ++i){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name","John Doe"+i);
            jsonObject.addProperty("age",i);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        JsonObject json3 = new JsonObject();
        json3.add("first",json);
        json3.add("data",jsonArray);
        System.out.println(json3.toString());
        ArrayList<Person> list = new Gson().fromJson(jsonArray,new TypeToken<ArrayList<Person>>(){}.getType());
        for (Person person2 : list){
            System.out.println("Name: "+person2.getName()+ "  Age:"+person2.getAge());
            System.out.println(new Gson().toJson(person2));
        }
    }

    private class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
