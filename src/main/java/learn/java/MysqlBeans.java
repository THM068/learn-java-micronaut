package learn.java;

import com.mysql.cj.xdevapi.Schema;
import com.mysql.cj.xdevapi.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class MysqlBeans {

    @Bean
    public Session mysqlSession() {
        Session session = new SessionFactory().getSession("mysqlx://localhost:33060/test?user=root&password=");
        return session;
    }

    @Bean
    public Schema database(Session mysqlSession) {
        Schema db = mysqlSession.getSchema("test");
        return db;
    }
}
