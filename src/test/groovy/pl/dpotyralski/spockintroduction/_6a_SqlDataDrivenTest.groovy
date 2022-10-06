package pl.dpotyralski.spockintroduction

import groovy.sql.Sql
import pl.dpotyralski.spockintroduction.customer.Customer
import spock.lang.Specification

class _6a_SqlDataDrivenTest extends Specification {

    static Sql sql = Sql.newInstance("jdbc:h2:./data/test", "sa", 'password', "org.h2.Driver")

    void setupSpec() {
        sql.execute('''
drop table if exists customers;
create table customers(id varchar, name varchar);
insert into customers (id, name) values ('1006e3f5-fa3d-48a7-833d-2b7df58b7b46', 'tom');
insert into customers (id, name) values ('bc299f40-69a8-4d9c-bcb5-2b0660b21085', 'ben');
''')
    }

    def "Should use data from sql select"() {
        given:
        Customer customer = new Customer(id: UUID.fromString(id), name: name)

        expect:
        customer.getId() == UUID.fromString(id)
        customer.getName() == name

        where:
//        [id, name] << sql.rows('select * from customers;')
        [name, id] << sql.rows('select * from customers;')
    }

    def "Should assign data variables"() {
        given:
        Customer customer = new Customer(id: UUID.fromString(id), name: nameDB)

        expect:
        customer.getName() == "${name} from DB"

        where:
        row << sql.rows('select * from customers;')
        id = row.id
        name = row.name
        nameDB = "${row.name} from DB"
    }

    def "Should show multi-variable assignment"() {
        given:
        Customer customer = new Customer(id: UUID.fromString(id), name: name)

        expect:
        customer.getName() == name

        where:
        row << sql.rows('select * from customers;')
//        (id, name) = row
//        (id, _) = row // in case you are not interested -> _
    }

    void cleanupSpec() {
        sql.close()
    }
}
