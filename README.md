#### 💯Points: ![Points bar](../../blob/badges/.github/badges/points-bar.svg)

#### 📝 [Report](../../blob/badges/report.md)
---


# Role-based Access Control (RBAC) with Limboole

This is a basic template to get started implementing an RBAC model analysis with Limboole.

As part of the assignment you will need to implement the TODOs in [RoleBasecAccessControlAnalyzer](src/main/java/de/buw/fm4se/rbac/RoleBasecAccessControlAnalyzer.java) (3 small TODOs) and [RoleBasedAccessControlTableTranslator](src/main/java/de/buw/fm4se/rbac/RoleBasedAccessControlTableTranslator.java) (1 bigger TODO).

## Project Setup

1. Install OpenJDK/JDK 
2. Clone your repository
3. Open in any IDE of your choice (e.g. Eclipse, VS Code, etc.)

## Task 1

[📼 see the code walk-through and explanation of this task](https://www.youtube.com/watch?v=qa08IzWqSQs&list=PLGyeoukah9NYNMJhcHXLjAGN294O2uXCB&index=7)

For this task, you need to implement the `translateToFormula(RbacTableReader rbac)` method in [RoleBasedAccessControlTableTranslator](src/main/java/de/buw/fm4se/rbac/RoleBasedAccessControlTableTranslator.java#L17)  which will return the combined formula in _limboole format_ for a given _RBAC table_.

An example of manual translations appeared in the exercise (T1) and in the first assignment.

After a correct translation all JUnit tests in `RoleBasedAccessControlTableTranslatorTest` checks should pass.


## Task 2:

Solve all of these by using a transaltion to Limboole rather than a direct search in the RBAC table!

- Implement the ``everyUserWithRoleHasPermissions(Set<String> roles, Set<String> permissions)`` method in [RoleBasecAccessControlAnalyzer](src/main/java/de/buw/fm4se/rbac/RoleBasecAccessControlAnalyzer.java) Class, which assert that each of the given roles has all of the given permissions.

- Implement the ``onlyUserWithRoleHasPermission(String role, String permission)`` method in [RoleBasecAccessControlAnalyzer](src/main/java/de/buw/fm4se/rbac/RoleBasecAccessControlAnalyzer.java) Class, which assert that only users with the given role have the given permission.

- Implement the ``noUserHasBothPermissions(String permission1, String permission2)`` method in [RoleBasecAccessControlAnalyzer](src/main/java/de/buw/fm4se/rbac/RoleBasecAccessControlAnalyzer.java) Class, which assert that no user can have the given two permissions at the same time.

For this, reuse the formula you get from Task 1.
