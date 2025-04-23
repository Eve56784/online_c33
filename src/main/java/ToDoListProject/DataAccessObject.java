package ToDoListProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
    public static void addTask(String header, String description, int deadlineInDays) throws SQLException {
        String sql = "insert into tasks(header, description, deadlineInDays) values (?,?,?);";
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, header);
            ps.setString(2, description);
            ps.setInt(3, deadlineInDays);
            ps.executeUpdate();
            System.out.println("\t\nThe task was successfully added");
        }
    }

    public static void readTask(int id) throws SQLException {
        String sql = "select * from tasks where id = ?";
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Header: " + rs.getString("header"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Completed: " + (rs.getBoolean("isCompleted")?"Yes":"No"));
                if(rs.getInt("deadlineInDays") > 1) {
                    System.out.println("Deadline: " + rs.getInt("deadlineInDays") + " days");
                    System.out.println("------------------------------------------");
                }
                else {
                    System.out.println("Deadline: " + rs.getInt("deadlineInDays") + " day");
                    System.out.println("------------------------------------------");
                }
            }
        }
    }

    public static void updateTask(String header, String description, int deadlineInDays, int id) throws SQLException {
        String sql = "update tasks set header = ?, description = ?, deadlineInDays = ? where id = ?";
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, header);
            ps.setString(2, description);
            ps.setInt(3, deadlineInDays);
            ps.setInt(4, id);
            if(ps.executeUpdate()>0)
                System.out.println("\t\nTask was successfully updated");
            else
                System.out.println("\t\nNo task was found with this ID" + id);
        }
    }

    public static void deleteTask(int id) throws SQLException {
        String sql = "delete from tasks where id = ?";
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0)
                System.out.println("\t\nTask was successfully deleted");
            else
                System.out.println("\t\nNo task was found with this ID" + id);
        }
    }

    public static void printAllTasksSortedByDeadline() throws SQLException {
        String sql = "select * from tasks order by deadlineInDays asc";
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Header: " + rs.getString("header"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Completed: " + (rs.getBoolean("isCompleted")?"Yes":"No"));
                if(rs.getInt("deadlineInDays") > 1) {
                    System.out.println("Deadline: " + rs.getInt("deadlineInDays") + " days");
                    System.out.println("------------------------------------------");
                }
                else {
                    System.out.println("Deadline: " + rs.getInt("deadlineInDays") + " day");
                    System.out.println("------------------------------------------");
                }
            }
        }
    }

    public static void updateCompleteness(Boolean isCompleted, int id) throws SQLException {
        String sql = "update tasks set isCompleted = ? where id = ?";
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, isCompleted);
            ps.setInt(2, id);
            if(ps.executeUpdate()>0)
                System.out.println("\t\nTask was successfully updated");
            else
                System.out.println("\t\nNo task was found with this ID" + id);
        }
    }
}
