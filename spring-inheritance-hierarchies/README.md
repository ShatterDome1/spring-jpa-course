# inheritance-hierarchies

When using inheritance between entites there are 4 ways of storing the data.
Three of them are by using the @Inheritance annotation and the final method is with @MappedSuerclass

When using the @Inheritance annotation we need to decide upon the strategy to use:
- SINGLE_TABLE (defualt) - The data from the subclasses and parent class will be stored in one table. Best for performance because only one table is queried,
bad for data integrity because the different columns of the subclasses will need to be nullable
- TABLE_PER_CPASS - Individual table created for each concrete subclass. Bad for data integrity because we will have duplicated columns
- JOINED - Tables will be created for each entity with their mapped fields. Data will be extracted by doing joins on the parent class and the subclass. Best for data integrity

When using the @MappedSuperclass the parent class can't be used to query the subclasses. Will need to maintain the queries of all subclasses. Impractical.

When choosing which approach to use there are 2 scenarios:
- Best Performance - use @Inheritance(strategy = SNGLE_TABLE)
- Data Integrity - use @Inheritance(strategy = JOINED)
