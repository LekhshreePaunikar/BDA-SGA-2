# Book author management #

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

6. ## Testing ###
To validate functionality, I wrote unit tests in `AuthorRepositoryTest` and `BookRepositoryTest` to
verify data operations and custom queries. These tests confirm repository reliability, while web
interface tests verified create, read, and update functionalities, ensuring end-to-end functionality.
