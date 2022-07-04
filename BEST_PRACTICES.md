# Best practices

1. Write test. Even better to start writing code from making tests first. TDD and BDD rules!
2. Stick to unified convention, which is commonly used by community
3. Use migrations for Database
4. Separate API endpoints and logic. Logic could be encapsulated into Services.
5. Use Static Analysis tools
6. Use Gateway or Proxy, to get extra security layer for the web application

# Rationale on usage of it

For the current project due to small scale of application and relatively simple logic many of these practise were not used.
The reason for it is avoiding creation of overhead and increasing maintenance cost in the future what is not main focus for these this study project.

However, some verification tools were used:

* IDEA IDE were used during development which provide initial and sufficient (for beginning) static analysis checking for _**source code**_ and _**markdown**_
* Manual testing was performed to verify the result of developed application

* Java - [JAVA.md](./app_java/JAVA.md)
* Python - [PYTHON.md](./app_python/PYTHON.md)

