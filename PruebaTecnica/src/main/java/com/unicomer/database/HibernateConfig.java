package com.unicomer.database;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
public class HibernateConfig extends JpaBaseConfiguration {

	protected HibernateConfig(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
		super(dataSource, properties, jtaTransactionManager);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		return vendor;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<>();
		map.put(Environment.FORMAT_SQL, true);
		map.put(Environment.SHOW_SQL, true);
		map.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
		map.put(Environment.HBM2DDL_AUTO, "none");

		return map;
	}

}
