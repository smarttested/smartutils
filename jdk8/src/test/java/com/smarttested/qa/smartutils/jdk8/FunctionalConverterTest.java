package com.smarttested.qa.smartutils.jdk8;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static com.smarttested.qa.smartutils.jdk8.FunctionalConverter.*;

/**
 * Created by andrey.vorobyov on 03/04/14.
 */
public class FunctionalConverterTest {

    private static final List<String> TEST_COLLECTION = Lists.newArrayList("one", "two", "three", "four", "five");

    private static final Function<String, String> JDK_UPPER_CASE = t -> t.toUpperCase();

    com.google.common.base.Function<String, String> GUAVA_UPPER_CASE = new com.google.common.base.Function<String, String>() {
        @Override
        public String apply(String t) {
            return t.toUpperCase();
        }
    };

    com.google.common.base.Function<String, String> GUAVA_LOWER_CASE = new com.google.common.base.Function<String, String>() {
        @Override
        public String apply(String t) {
            return t.toLowerCase();
        }
    };

    com.google.common.base.Predicate<? extends Number> GUAVA_MORE_THAN_ZERO = new com.google.common.base.Predicate<Number>() {
        @Override
        public boolean apply(Number input) {
            return input.floatValue() > 0;
        }
    };

    public void testJdkConverters() {
        //TEST_COLLECTION.stream().fi
    }

    @Test
    public void testGuavaConverters() {

        Predicate<Object> OR = Predicates.or(new Predicate<Object>() {
            @Override
            public boolean apply(Object input) {
                return false;
            }
        }, new Predicate<Object>() {
            @Override
            public boolean apply(Object input) {
                return false;
            }
        });

        //Guava
        Lists.transform(TEST_COLLECTION, GUAVA_UPPER_CASE);

        //JDK8
        TEST_COLLECTION.stream().map(asJdk(GUAVA_UPPER_CASE));

        System.out.println(Joiner.on("\n").join(TEST_COLLECTION.stream().map(asJdk(GUAVA_UPPER_CASE)).iterator()));

    }
}
