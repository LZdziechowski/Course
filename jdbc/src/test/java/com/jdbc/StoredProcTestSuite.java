package com.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    


    @Test
    void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update READERS set VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as HOW_MANY from READERS where vip_level=\"Not set\"";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update BOOKS set BESTSELLER=0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as HOW_MANY from BOOKS where BESTSELLER=0";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        assertEquals(3, howMany);
    }
}
