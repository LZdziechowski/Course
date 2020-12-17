package com.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuit {

    private static int testCounter = 0;

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("");
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "select * from USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(7, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        System.out.println("Test users with more than one post");
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "select U.FIRSTNAME, U.LASTNAME, count(*) as POST_NUMBER from USERS U \n" +
                "join POSTS P on U.ID = P.USER_ID\n" +
                "group by U.ID\n" +
                "having count(*) >= 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + " " +
                    resultSet.getString("LASTNAME") + ": " +
                    resultSet.getInt("POST_NUMBER"));
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(1, counter);
    }

}
