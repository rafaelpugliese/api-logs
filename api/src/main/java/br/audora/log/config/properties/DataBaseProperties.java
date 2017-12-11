package br.audora.log.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="db")
public class DataBaseProperties {

	private String driver;
	private String url;
	private String user;
	private String password;

	private String dialect;
	private boolean show_sql;
	private String hbm2ddl_auto;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	public boolean isShow_sql() {
		return show_sql;
	}
	public void setShow_sql(boolean show_sql) {
		this.show_sql = show_sql;
	}
	public String getHbm2ddl_auto() {
		return hbm2ddl_auto;
	}
	public void setHbm2ddl_auto(String hbm2ddl_auto) {
		this.hbm2ddl_auto = hbm2ddl_auto;
	}
	
}