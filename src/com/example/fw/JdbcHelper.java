package com.example.fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class JdbcHelper {

	private Connection conn;
	
	public JdbcHelper(ApplicationManager app, String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public SortedListOf<GroupData> listGroups() {
	  SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		Statement st = null;
		ResultSet res = null;
		
		try {
			st = conn.createStatement();
			res = st.executeQuery("SELECT group_id,group_name,group_header,group_footer FROM group_list");
			while (res.next()) {
				GroupData gr = new GroupData().withId(res.getString(1)).withName(res.getString(2)).withHeader(res.getString(3)).withFooter(res.getString(4));
				groups.add(gr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return groups;
	}
}
