# Book author management #

This project implements a **Book Author Management System** using **Spring Boot** and **JPA**. It provides a web-based interface for managing authors and their books, featuring comprehensive **CRUD** operations, custom queries, and a user-friendly **JSP**-based UI. 

## Table of Contents
- [Technologies Used](#technologies-used)
- [Entity Relationships](#entity-relationships)
- [Operations](#operations)
- [Requirements](#requirements)
- [Usage](#usage)
- [Challenges Faced](#challenges-faced)
- [Future Improvements](#future-improvements)
  
## TECHNOLOGIES USED
- **Java 17**: The core programming language for this project, offering robust object-oriented features.
- **Spring Boot 3.0**: Simplifies the setup and development of Spring applications with built-in dependency management and embedded servers.
- **JPA/Hibernate**: For ORM (Object Relational Mapping), allowing easy interaction with the PostgreSQL database.
- **PostgreSQL**: A powerful, open-source relational database management system.
- **JSP**: Provides a dynamic way to render server-side data into web pages.
- **Thymeleaf**: Facilitates the creation of server-side rendered templates with Spring Boot.
- **JUnit**: For unit testing, ensuring that the application's functionalities are reliable and error-free.

## ENTITY RELATIONSHIPS: ##
- **Author:** Each author can write multiple books.
  - `id` (Primary Key)
  - `name` (String)
- **Book:** Each book is associated with a single author.
  - `id` (Primary Key)
  - `title` (String)
  - `author` (Foreign Key to Author)
   
## OPERATIONS: ##

1. ### Populate Database ###
Using **JPA**, I defined the Author and Book entities, which mapped directly to database tables. To
populate these tables, I created a **DataSeeder class** that runs on application startup, adding 10
sample rows to both Author and Book tables. This preloads the database with meaningful data,
allowing me to verify CRUD functionality immediately.

2. ### Create Operation ###
I implemented a form in new_author.html and new_book.html to allow users to add new authors and
books. The form submissions are handled by `saveAuthor()` and `saveBook()` methods in
`AuthorController` and `BookController`, respectively. These methods call the service layer, which
saves new entries to the database through the repository. I included exception handling to catch any
integrity violations, such as invalid author IDs, to ensure data consistency.

3. ### Read Operation ###
For the read operation, I created authors.html and books.html to display lists of all authors and
books. The controller methods `viewAuthorsPage()` and `viewBooksPage()` fetch data from the
service layer and bind it to these views. To implement the custom query, I added
`findBooksByAuthorName()` in BookRepository, which performs an inner join to retrieve books by a
specific author. This query is used in `viewBooksByAuthor()` to support filtered book views based on
author names.

4. ### Update Operation ###
I implemented update functionality through update_author.html and update_book.html, allowing
users to modify existing entries. In the controllers, `updateAuthor()` and `updateBook()` methods
handle update requests by first retrieving the existing entry, binding it to the update form, and then
saving the modified data back to the database. This ensures that the correct entry is updated,
preserving data integrity.

5. ### Delete Operation ###
I implemented delete functionality in AuthorController and BookController to allow users to remove
records. In BookController, the `deleteBook()` method is mapped to the `/books/delete/{id}` route,
which retrieves the book by ID and deletes it from the database through the service layer. This setup
allows admin to manage records effectively, and the confirm prompt on books.html ensures that
users intentionally perform deletions, safeguarding against accidental data loss.

## REQUIREMENTS: ##

1. ### Entity Classes ###
I defined Author and Book classes as entities using `@Entity`, with primary keys annotated by `@Id`
and auto-generated values. I established a `@OneToMany` relationship from Author to Book and a
corresponding `@ManyToOne` relationship from Book to Author, maintaining clear entity
relationships and constraints.

2. ### Repository Layer ###
I created `AuthorRepository` and `BookRepository`, both extending `JpaRepository` for built-in
CRUD operations. In BookRepository, I implemented a custom query `findBooksByAuthorName()`
using `@Query` to perform an inner join, enabling filtered data retrieval based on the author’s name.

3. ### Service Layer ###
In the service layer, I implemented `AuthorService` and `BookService` to handle business logic and
interact with the repository layer. Methods like `saveAuthor()`, `getAllBooks()`, and
`getBooksByAuthorName()` encapsulate data operations, ensuring business logic is maintained
separately from controllers.

4. ### Controller Layer ###
I developed `AuthorController` and `BookController` to handle HTTP requests. These controllers
map routes to **CRUD operations**, with methods like `saveAuthor()` and `updateBook()` managing data
flow between the model and view. I used **JSTL** and **Expression Language (EL)** to bind data to JSP
views effectively, keeping the user interface responsive and dynamic.

5. ### View Layer ###
I created **JSP pages** for listing, adding, and updating entities (`authors.html`, `new_author.html`,
`update_author.html`, etc.), with CSS applied for a consistent, visually appealing design. Forms are
clear and intuitive, supporting efficient user interaction.

6. ### Testing ###
To validate functionality, I wrote unit tests in `AuthorRepositoryTest` and `BookRepositoryTest` to
verify data operations and custom queries. These tests confirm repository reliability, while web
interface tests verified create, read, and update functionalities, ensuring end-to-end functionality.

## USAGE: ##
- **Admin Dashboard**: The admin has full control over the data, including the ability to add new authors and books, update existing records, or delete entries as needed. Regular users, on the other hand, have restricted access, allowing them to view the list of books and authors without modifying the data.
- **View Authors and Books:** Users can browse through a list of authors and their associated books, making it easy to explore the database. The search functionality allows users to filter books by author names, providing a quick way to find specific entries or explore the works of a particular author.
- **Update and Delete:** Admins can use dedicated forms to update the details of authors or books, ensuring that the records remain accurate and up-to-date. Deletion functionality is carefully controlled and restricted to admins, with confirmation prompts to prevent unintentional data loss, maintaining the integrity of the database.

## CHALLENGES FACED: ##

- **Database Design:** Implementing the one-to-many relationship between `Author` and `Book` required careful handling of cascading operations to maintain data integrity, particularly during deletions.

- **Exception Handling:** Ensuring robust error handling for invalid data inputs, especially during create and update operations, was challenging. It was essential to provide meaningful feedback without exposing sensitive details.

- **Optimizing Custom Queries:** Writing efficient JPQL queries for searching books by author name and managing performance as data volume grew required balancing readability with query speed.

- **User Interface with JSP:** Designing a user-friendly interface using JSP was challenging, particularly when integrating it with CSS for a consistent look and ensuring smooth form data handling.

- **Role-Based Access Control (RBAC):** Differentiating admin and user permissions required careful setup to ensure secure access while maintaining a good user experience.

- **Testing with JUnit:** Mocking data and simulating real-world scenarios for unit tests, especially for custom query logic, posed challenges but was crucial for application stability.

- **Configuration and Deployment:** Managing database configuration and migration from development to production environments required precision to avoid data loss and ensure seamless transitions.
  
## FUTURE IMPROVEMENTS: ###

- **Future Improvements:** Implement a RESTful API for External Access: Creating a RESTful API would allow other applications or services to interact with the system programmatically. This would enable integration with mobile apps or third-party platforms, expanding the application's reach and versatility.

- **Enhance Security Features for Better User Management:** Adding features like JWT-based authentication or OAuth 2.0 would provide a more secure way to handle user sessions. Implementing multi-factor authentication (MFA) and stronger password validation can further protect user data from unauthorized access.

- **Add More Search and Filter Options in the UI:** Expanding the search functionality to include filters like book genre, publication year, or partial matches for author names would improve usability. This would help users quickly find specific books or authors, making the application more user-friendly as the dataset grows.

- **Optimize Database Queries for Improved Performance:** Refactoring complex queries and adding database indexes can reduce query execution times, especially for large datasets. Implementing caching mechanisms like Hibernate's second-level cache can also speed up frequently accessed data, enhancing the overall responsiveness of the application.
