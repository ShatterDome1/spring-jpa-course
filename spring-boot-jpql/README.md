# spring-jpa-relationships

**JPQL:**
When creating your own jpql queries you can create joins on tables that have a relationship.

The resulting objects will be returned in a list depending in the order that
the query is executed: Course, Student => result[o].type = Course && result[1].type = Student

There are three types of joins that I learned:
- Join - Courses without students will **not** be displayed
```Java
    @Test
    public void join() {
        // Courses without students will not be displayed
        Query query = entityManager.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }
```
- Left Join - Courses without students will be displayed
```Java
    @Test
    public void leftJoin() {
        // Courses without students will be displayed
        Query query = entityManager.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }
```
- CrossJoin - Returns the cartesian product between the entities
```Java
    @Test
    public void crossjoin() {
        // Cross join, it makes a cartesian product between the entities
        Query query = entityManager.createQuery("Select c, s from Course c, Student s");
        List<Object[]> list = query.getResultList();
        // The resulting objects will be returned in a list depending in the order that
        // the query is executed: Course, Student => result[o].type = Course && result[1].type = Student
        for (Object[] result : list) {
            System.out.println("Course " + result[0]);
            System.out.println("Student " + result[1]);
        }
    }
```

**Criteria Queries are not worth learning** :)

**Transaction Management:**

ACID properties:
- A - Atomic - If one instruction fails, all subsequent ones should fail as well and the other operations rolled back
- C - Concurrent - All transactions can run in parallel
- I - Isolation - Transactions do not interfere with other ones
- D - Durability - Data that is written to the database must persist if system crashes

There are 3 problems when it comes to transactions:
- Dirty Reads - When there are two transactions t1 and t2. If t1 changes a field and then t2 reads the updated one before the t1 is finished
- Non Repeatable Reads - When t1 reads a field, then t2 updates it, and t1 reads it again and sees the updated value
- Phantom Reads - This is related to rows, if t1 does a select all and t2 inserts a row and t1 does another select all. The data will be inconsistent

There are 4 isolation levels that can solve these problems:
- read uncommited
- read commited
- Non repeatable reads

Spring data JPA replaces the repository and autogenerates custom queries based on the methods (pretty cool)
Spring data REST makes a repository available to an endpoint and allows queries
- Serialisation
