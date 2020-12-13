package by.it.academy.kotlinexample;

import java.util.Objects;

public class A {

    public void doJob() {
        User user = new User("asdasd");
        user.doJob();

        try {
            externalJob();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void externalJob() throws Exception {
        throw new IllegalStateException("sadsd");
    }

    class B {

    }
}
