package pl.dpotyralski.spockintroduction

import groovy.sql.Sql
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import pl.dpotyralski.spockintroduction.customer.Customer
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class _6a_PostgreSqlDatabaseExample extends Specification {

    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:16.0")
            .withDatabaseName("exampleDB")
            .withUsername("sa")
            .withPassword("sa")

    @Shared
    static Sql sql = null

    void setupSpec() {
        postgreSQLContainer.start()
        sql = Sql.newInstance(postgreSQLContainer.getJdbcUrl(), "sa", 'sa', "org.postgresql.Driver")
        sql.execute('''
drop table if exists customers;
create table customers(id varchar, name varchar);
insert into customers (id, name) values ('1006e3f5-fa3d-48a7-833d-2b7df58b7b46', 'tom');
insert into customers (id, name) values ('bc299f40-69a8-4d9c-bcb5-2b0660b21085', 'ben');
''')
    }

    def "Should use data from sql select"() {
        given:
        Customer customer = new Customer(id: id, name: name)

        expect:
        customer.getId() == id
        customer.getName() == name

        where:
//        [id, name] << sql.rows('select * from customers;')
        [name, id] << sql.rows('select * from customers;')
    }

}