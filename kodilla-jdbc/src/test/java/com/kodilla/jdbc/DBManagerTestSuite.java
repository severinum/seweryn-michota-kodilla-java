package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTestSuite {

    @Test
    void testConn() throws SQLException {
        // given
        // when
        DBManager dbManager = DBManager.getInstance();
        // then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DBManager dbManager = DBManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        // given
        DBManager dbManager = DBManager.getInstance();
        // get users count with posts >=2
        String sqlGetUsrs = "SELECT  COUNT(*) " +
                "FROM USERS U\n" +
                "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlGetUsrs);
        int initialCounter = 0; // will hold num. of people with posts count >=2
        while(rs.next()){
            initialCounter++;
        }

        PreparedStatement pstmt;
        int newUserId = 0;
        String insertSql = "INSERT INTO users(FIRSTNAME, LASTNAME) VALUES ('Test', 'User');";
        pstmt = dbManager.getConnection().prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        pstmt.executeUpdate();
        ResultSet resSet = pstmt.getGeneratedKeys();
        resSet.next();
        newUserId = resSet.getInt(1);


        insertSql = "INSERT INTO posts (id, user_id, body) VALUES (NULL, '"+ newUserId +"', 'Some body text 1');";
        pstmt = dbManager.getConnection().prepareStatement(insertSql);
        pstmt.executeUpdate();
        insertSql = "INSERT INTO posts (id, user_id, body) VALUES (NULL, '"+ newUserId +"', 'Some body text 2');";
        pstmt = dbManager.getConnection().prepareStatement(insertSql);
        pstmt.executeUpdate();
        insertSql = "INSERT INTO posts (id, user_id, body) VALUES (NULL, '"+ newUserId +"', 'Some body text 3');";
        pstmt = dbManager.getConnection().prepareStatement(insertSql);
        pstmt.executeUpdate();

        resSet.close();
        pstmt.close();

        // check number of users with posts count >=2 , should be 1 more than initially
        String sqlQuery = "SELECT  COUNT(*) " +
                "FROM USERS U\n" +
                "JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) >= 2;";
        statement = dbManager.getConnection().createStatement();
        rs = statement.executeQuery(sqlQuery);

        // then
        int counter = 0;
        while(rs.next()){
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(initialCounter+1 , counter);
    }

}