package com.karuppiah.bringit;

import android.os.Handler;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by 3521 on 9/17/2015.
 */
public class dbconnection extends Thread {

    Handler mHandler;
    ArrayList<Food> foodList;

    public dbconnection(Handler mHandler, ArrayList<Food> foodList) {
        this.mHandler = mHandler;
        this.foodList = foodList;
    }

    @Override
    public void run() {

        int id = -1;
        String name = null;
        int price = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Dashboard.conn = DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/bringitdb", "bringitroot", "karuppiah");

            Statement stmt = null;

            stmt = Dashboard.conn.createStatement();

            String sql = "select * from fooditems";

            ResultSet rs = stmt.executeQuery(sql);

            String result = "";
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");

                foodList.add(new Food(id,name,price));

            }

            mHandler.obtainMessage(Dashboard.DONE, "").sendToTarget();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
