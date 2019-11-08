package learn.java.aop;

import javax.inject.Singleton;

@Singleton
public class NotNullExample {

    @NotNull
    public void doWork(String taskName) {
        System.out.println("Doing job " + taskName);
    }
}
