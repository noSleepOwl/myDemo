package myDemo.database.ibatis.modal;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("Table")
public class Table {
	private String name;
	private List<String> columnNames;
	public Table(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
}
