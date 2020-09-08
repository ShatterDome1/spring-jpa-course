# springBasics

Spring helps with dependency management and allows develelopers to create loosely coupled software.

Spring has the following important annotations:
- @Component - tells spring to create a bean for the annotated class
- @Autowired - tells spring there is a dependency based on a defined component
- @Primary - prioritise a component, when there is a dependency conflict (2 or more components can be autowired)

There are 2 types of autowiring:
- Constructor - the dependencies are set using the constructor
- Setter - when the constructor doesn't initialise the dependency
