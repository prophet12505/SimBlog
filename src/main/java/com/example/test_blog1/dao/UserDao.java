package com.example.test_blog1.dao;

import com.example.test_blog1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    JdbcTemplate template;
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template=template;
    }


    public int getUserIdByLogin(String name,String password)
    {

        List<User> queryResult= queryUsersByName(name);
        if(queryResult.size()==0)
            return -1;
        for(User user:queryResult)
        {
            if(password.equals(user.getPassword()))//String values compare should use euqals, not ==
            {
                return user.getUser_id();
            }
        }
        return -1;

    }
    public List<User> queryUsersByName(String name)
    {
        String sql=" SELECT * FROM USER WHERE USER_NAME='"+name+"'";

        return template.query(sql, new ResultSetExtractor<List<User>>() {
            @Override
            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<User> list=new ArrayList<User>();
                while(rs.next()){
                    User user=new User();
                    user.setUser_id(rs.getInt(1));
                    user.setUser_name(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    list.add(user);
                }
                return list;
            }
        });

        //return new ArrayList<User>();//test

    }


}
