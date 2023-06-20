package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.Todo;
import com.playdata.todos.dto.TodoJoinUser;
import com.playdata.todos.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    public List<TodoJoinUser> findAll() {
        List<TodoJoinUser> todoJoinUsers = new ArrayList<TodoJoinUser>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select t.id, t.create_at ,t.content, t.checked,u.name, u.id uid " +
                "from todos.todos as t " +
                "inner join todos.users as u " +
                "on t.user_id = u.id";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                todoJoinUsers.add(new TodoJoinUser
                        (resultSet.getInt("id"),
                                resultSet.getString("content"),
                                resultSet.getString("create_at"),
                                resultSet.getBoolean("checked"),
                                resultSet.getString("name"),
                                resultSet.getInt("uid")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todoJoinUsers;

    }

    public void insert(int uid, String content) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into todos (user_id, content,checked) " +
                "values(?,?, false)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, uid);
            pst.setString(2, content);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TodoJoinUser fineById(int id) {
        List<TodoJoinUser> todoJoinUsers = new ArrayList<TodoJoinUser>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select t.id, t.create_at ,t.content, t.checked,u.name, u.id uid " +
                "from todos.todos as t " +
                "inner join todos.users as u " +
                "on t.user_id = u.id " +
                "where t.id=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                todoJoinUsers.add(new TodoJoinUser(resultSet.getInt("id"),
                        resultSet.getString("content"),
                        resultSet.getString("create_at"),
                        resultSet.getBoolean("checked"),
                        resultSet.getString("name"),
                        resultSet.getInt("uid")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todoJoinUsers.get(0);
    }

    public void update(int id, int uid, String content) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "update todos.todos set todos.content = ? " +
                "where id = ? and user_id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, content);
            pst.setInt(2, id);
            pst.setInt(3, uid);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public List<TodoJoinUser> findByKeyword(String keyword) {
        List<TodoJoinUser> todoJoinUsers = new ArrayList<TodoJoinUser>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select t.id, t.create_at ,t.content, t.checked,u.name, u.id uid " +
                "from todos.todos as t " +
                "inner join todos.users as u " +
                "on t.user_id = u.id " +
                "where content like ? ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                todoJoinUsers.add(new TodoJoinUser
                        (resultSet.getInt("id"),
                                resultSet.getString("content"),
                                resultSet.getString("create_at"),
                                resultSet.getBoolean("checked"),
                                resultSet.getString("name"),
                                resultSet.getInt("uid")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todoJoinUsers;

    }

    }