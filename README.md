## REFLECTION 1

I applied several clean code principles covered in class, such as using clear and descriptive naming conventions. For example, method names like `deleteProduct`, `editProductPage`, and `productListPage` explicitly convey their functionality, enhancing code readability and maintainability. I also followed the Single Responsibility Principle (SRP) by ensuring that the controller handles request routing, the service manages business logic, and the repository is responsible for data persistence.

To reduce redundancy, I utilized existing service and repository methods instead of writing repetitive code. Additionally, I implemented secure coding practices, such as using `POST` instead of `GET` for delete actions to prevent unintended modifications via URL access. Furthermore, I added confirmation prompts before product deletions to improve user experience and minimize accidental data loss.


## REFLECTION 2

1. After writing the unit tests, I feel more confident in the application's stability, knowing that the core functionalities, edge cases, and error handling are covered; however, while achieving high or even 100% code coverage is encouraging, it doesn't guarantee that our code is entirely free of bugs, as code coverage only measures which lines are executed rather than the quality or comprehensiveness of the tests themselves.


2. When creating another functional test suite that verifies the number of items in the product list and shares similar setup procedures and instance variables with the CreateProductFunctionalTest, the duplication of code becomes a concern, as it violates the DRY (Don't Repeat Yourself) principle, potentially reducing maintainability and overall code quality; to improve this, common setup routines and configuration code should be refactored into a shared base class or utility, thereby centralizing changes and ensuring consistency across all test suites.



