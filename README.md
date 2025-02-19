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

# WEBSITE URL
https://theoretical-quinn-tapz-a749f6e1.koyeb.app/