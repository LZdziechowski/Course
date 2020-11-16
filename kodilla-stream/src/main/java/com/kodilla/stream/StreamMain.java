package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.referene.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.SocketHandler;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        /*final SaySomething saySomething = new SaySomething();
        saySomething.say();*/

        /*final Processor processor = new Processor();
        final ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        /*fianl Processor processor = new Processor();
        final Executor codeToExecute = () -> System.out.println("bbb");
        processor.execute(codeToExecute);*/

        /*final Processor processor = new Processor();
        processor.execute(() -> System.out.println("bbb"));*/

        /*final ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10,5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10,5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10,5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10,5, (a, b) -> a / b);

        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subAFromB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);*/

        //-------------------- 7.1 -------------------//

        final PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Text to Decorate", text -> text.toUpperCase());
        poemBeautifier.beautify("Text to Decorate", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Text to Decorate", text -> text.toLowerCase());
        poemBeautifier.beautify("Text to Decorate", text -> {
            if (text.length() % 2 == 0) {
                return text + "- even number of characters";
            } else {
                return text + "- odd number of characters";
            }
        });

        /*System.out.println("Using Stream to generate even numbers form 1 to 20");
        NumbersGenerator.generateEven(20);*/

        /*People.getList().stream()
                .filter(s -> s.length() > 11)
                .map(String::toUpperCase)
                .filter(s -> s.substring(0,1).equals("M"))
                .map(s -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .forEach(System.out::println);*/

        /*BookDirectory bookDirectory = new BookDirectory();
        bookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);*/

        /*BookDirectory bookDirectory = new BookDirectory();
        List<Book> theResultListOfTheBooks = bookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfTheBooks.size());
        theResultListOfTheBooks.stream()
                .forEach(System.out::println);*/

        /*BookDirectory bookDirectory = new BookDirectory();
        Map<String, Book> theResultOfTheBooks = bookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultOfTheBooks.size());
        theResultOfTheBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);*/

        /*BookDirectory bookDirectory = new BookDirectory();
        String theResultStringOfBooks = bookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<", ">>"));

        System.out.println(theResultStringOfBooks);*/


        //-------------------- 7.3 -------------------//

        Forum forum = new Forum(100);
        LocalDate currentDate = LocalDate.now();
        Map<Integer, ForumUser> theResultMapOfForumUsers = forum.getForumUserList().stream()
                .filter(user -> user.getUserSex() == 'M')
                .filter(user -> user.getDateOfBirth().plusYears(20).isBefore(currentDate))
                .filter(user -> user.getQuantityOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        System.out.println("Size result map of forum users: " + theResultMapOfForumUsers.size());
        theResultMapOfForumUsers.entrySet().stream()
                .forEach(System.out::println);

    }
}
