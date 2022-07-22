package com.example.test_blog1.dao;

import com.example.test_blog1.entity.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component

public class BlogDao {

    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    public int saveBlog(Blog blog)
    {
        //table name:blog99
        String sql="insert into blog(title,content) values('"+ blog.getTitle()+"','"+blog.getContent()+"')";
        return template.update(sql);

    }
    public int deleteBlogById(int blod_id)
    {
        String sql="delete from blog where blog_id="+blod_id;
        return template.update(sql);
    }




    public List<Blog> queryAllBlog()
    {
        String sql="select * from blog ";
        return template.query(sql, new RowMapper<Blog>() {
            @Override
            public Blog mapRow(ResultSet rs, int row) throws SQLException
            {
                Blog blog =new Blog();
                blog.setBlog_id(rs.getInt(1));
                blog.setTitle(rs.getString(2));
                blog.setContent(rs.getString(3));
                return blog;
            }
        });

    }

}
