# spring-boot-jdbc-jpa
Important annotations for JPA:
- @Entity - Creates the database table with the mapped fields
- @Table - Set the name of the table by setting the name attribute
- @NamedQuery - Create custom queries that the entity manager does not support
- @Id - Marks the field as the primary key of the entity
- @GeneratedValue - Allows hibernate to generate the value
- @Column - Maps the column name from the table to the entity field
- @PersistanceContext - used along the EntityManager

Important classes:
- EntityManager - Allows for queries on the database (find, merge, remove, creteNamedQuery)

Files that might be useful:
- data.sql - Runs the sql code from the file if an embedded database is used (h2)
