package example.adam.pri.crazyandroid.ch04;

import java.io.Serializable;

/**
 * Created by lab on 2015/3/18.
 */
public class Person implements Serializable{

    public String username;
    public String intro;

    public Person(){}

    public Person(String username,String intro){
        this.username = username;
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
