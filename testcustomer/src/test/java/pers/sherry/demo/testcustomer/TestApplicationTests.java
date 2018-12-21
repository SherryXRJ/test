package pers.sherry.demo.testcustomer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "pers.sherry.demo")
public class TestApplicationTests {

    @Autowired
    private TestDao testDao;


    @Test
    public void contextLoads() {
        List<Book> list = Arrays.asList(new Book(1), new Book(2), new Book(3));
        testDao.batchInsert(list);
        list.forEach(System.out::print);
    }

    @Test
    public void test() {
        List<Book> list = Arrays.asList(new Book(1, 2, "a"), new Book(2, 2, "a"), new Book(2, 3, "c"), new Book(1, 5, "a"));
        Map<String, List<Book>> collect = list.stream().collect(Collectors.groupingBy(Book::getGroup));
        System.out.println(collect);

    }

    @Test
    public void testOptionalList() throws Exception {
        List<Integer> list = Arrays.asList(1, 1, 1, 3, 1, 1, 3, 2, 1, 1, 3);
        Optional.of(list).map(List::size).filter(num -> num <= 10).orElseThrow(() -> new Exception("最多可指定10个会签人"));

    }

    @Test
    public void testOptional() {
        String str = "a";
        System.out.println(Optional.ofNullable(str).orElse("null"));
    }

    @Test
    public void testList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 6);
        List<List<Integer>> lists = list.stream().map(Collections::singletonList).collect(Collectors.toList());
        System.out.println(lists);
    }

    @Test
    public void testNPE() {
        List<String> l = null;
        Optional.ofNullable(l)
                .map(Collection::stream)
                .filter(s -> s.filter("5"::equals).count() > 0)
                .orElseThrow(() -> new RuntimeException("opps"));

    }

    @Test
    public void testStr(){
        String str = null;
        Optional.ofNullable(str)
                .map(String::length)
                .filter(n -> n < 10)
                .orElseThrow(() -> new RuntimeException("ops"));

    }
}
