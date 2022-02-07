package mk.ukim.finki.wp.eshop.jUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class jUnitRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(jUnitTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}

