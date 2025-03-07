# MODULE 1

## REFLECTION 1

I applied several clean code principles covered in class, such as using clear and descriptive naming conventions. For example, method names like `deleteProduct`, `editProductPage`, and `productListPage` explicitly convey their functionality, enhancing code readability and maintainability. I also followed the Single Responsibility Principle (SRP) by ensuring that the controller handles request routing, the service manages business logic, and the repository is responsible for data persistence.

To reduce redundancy, I utilized existing service and repository methods instead of writing repetitive code. Additionally, I implemented secure coding practices, such as using `POST` instead of `GET` for delete actions to prevent unintended modifications via URL access. Furthermore, I added confirmation prompts before product deletions to improve user experience and minimize accidental data loss.


## REFLECTION 2

1. After writing the unit tests, I feel more confident in the application's stability, knowing that the core functionalities, edge cases, and error handling are covered; however, while achieving high or even 100% code coverage is encouraging, it doesn't guarantee that our code is entirely free of bugs, as code coverage only measures which lines are executed rather than the quality or comprehensiveness of the tests themselves.


2. When creating another functional test suite that verifies the number of items in the product list and shares similar setup procedures and instance variables with the CreateProductFunctionalTest, the duplication of code becomes a concern, as it violates the DRY (Don't Repeat Yourself) principle, potentially reducing maintainability and overall code quality; to improve this, common setup routines and configuration code should be refactored into a shared base class or utility, thereby centralizing changes and ensuring consistency across all test suites.

# MODULE 2

1. One of the major code quality issues that were fixed was the problem of code duplication in the ProductController.java file. The string "redirect:/product/list" was repeated three times in different methods, which undermined maintainability and increased the risk of inconsistency. To fix this problem, a constant (REDIRECT_PRODUCT_LIST) was defined, and all occurrences of the hardcoded string were replaced accordingly, thus making it easier and more consistent to make future changes.


2. The current CI/CD setup only partially meets the definition of Continuous Integration (CI) and Continuous Deployment (CD). The CI pipeline automates unit testing and code quality analysis using GitHub Actions and SonarCloud, detecting bugs and problems early in the process. The CD process releases the application to Koyeb or Render, where automatic releases are performed without any human intervention. However, the pipeline does not have an automated rollback process, and thus, in the event of a failed deployment, it must be fixed manually. 

# MODULE 3

1. In my project, I applied SOLID principles throughout the code base, as seen in ProductController.java where the controller handles only product-related tasks and delegates business logic to ProductServiceImpl.java. In CarController.java, I separated car operations so that it focuses solely on car management. I ensured new functionality can be added via extension points in ProductService.java without modifying existing methods. I also followed the Liskov Substitution Principle by allowing subclasses like DigitalProduct.java and ElectricCar.java to replace their parent classes without altering behavior. Finally, in ProductServiceImpl.java, I implemented dependency inversion by making the service depend on repository abstractions rather than concrete implementations.


2. Applying SOLID principles has made the project more modular and easier to test, as demonstrated in ProductController.java, where distinct responsibilities lead to fewer side effects when making changes. The Open/Closed Principle in ProductServiceImpl.java allows for adding features like custom filtering without altering existing code. In CarController.java, dependency inversion enables substituting the car service with a mock during testing. This clear separation of concerns makes debugging and future enhancements straightforward. Overall, each file, including ProductServiceImpl.java and CarController.java, maintains its purpose and minimizes regression risks.


3. Without SOLID principles, the project would become tightly coupled and difficult to maintain, as seen if ProductController.java combined both HTTP handling and business logic. If the Open/Closed Principle were ignored in ProductServiceImpl.java, adding new features like filtering would require modifying existing code, increasing the chance of regression errors. Neglecting the Liskov Substitution Principle could result in subclasses that do not work seamlessly, for example, replacing a Product with a DigitalProduct might break functionality. A lack of proper interface segregation and dependency inversion would cause changes in one module to ripple through the entire application. Overall, these shortcomings would make the code base less modular, more error-prone, and harder to enhance over time.

# MODULE 4

1. Reflecting on Percival’s (2017) self-assessment, the TDD approach has been valuable by defining expected behaviors, promoting modular design, and providing rapid feedback. However, there is room for improvement, such as broadening test coverage to capture more edge cases and enhancing the diagnostic clarity of failed tests. Although refactoring was part of the process, some temporary code remained longer than necessary. Moving forward, more time will be dedicated to crafting comprehensive test cases upfront and implementing immediate cleanup routines to maintain a lean and well-structured codebase.


2. Evaluating my unit tests against the F.I.R.S.T. principles, I found that they generally meet the criteria of being fast, independent, repeatable, self-validating, and timely. However, there are areas for improvement. Some tests involving external resources slowed down execution, and shared state issues revealed the need for stricter isolation with more effective setup and teardown routines. Moving forward, I plan to enhance test isolation, automate validations for complex scenarios, and ensure all tests consistently adhere to the F.I.R.S.T. principles efficiently.
# WEBSITE URL
https://theoretical-quinn-tapz-a749f6e1.koyeb.app/