package com.example.myweb.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.myweb.board.BoardVO;
import com.example.myweb.user.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String SQL_GET = "select * from users where id=?";
	final String SQL_LIST = "select * from users order by id desc";
	final String SQL_INSERT = "insert into users(id, password, name, role) values(?,?,?,?)";
	final String SQL_UPDATE = "update users set password=?, name=?, role=? where id=?";
	final String SQL_DELETE = "delete from users where id=?";
	
	class UserMapper implements RowMapper<UserVO> {
		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setId(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setName(rs.getString(3));
			user.setRole(rs.getString(4));
			return user;
		}
	}
	
	public List<UserVO> selectAll() {
		System.out.println(">>> selectAll() 실행");
		return jdbcTemplate.query(SQL_LIST, new UserMapper());
	}
	
	public UserVO findById(UserVO dto) {
		Object[] args = new Object[] {dto.getId()};
		return jdbcTemplate.queryForObject(SQL_GET, args, new UserMapper());
	}
	//등록
	public void insert(UserVO dto) {
		jdbcTemplate.update(SQL_INSERT, dto.getId(), dto.getPassword(), dto.getName(), dto.getRole());
	}
	//수정
	public void update(UserVO dto) {
		jdbcTemplate.update(SQL_UPDATE, dto.getPassword(), dto.getName(), dto.getRole(), dto.getId());
	}
	//삭제
	public void delete(UserVO dto) {
		jdbcTemplate.update(SQL_DELETE, dto.getId());
	}

	public List<UserVO> getUserList(UserVO vo) {
		Object[] args = new Object[] {vo.getId()};
		return jdbcTemplate.query(SQL_LIST, args, new UserMapper());
	}
}