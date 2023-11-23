package de.buw.fm4se.rbac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RoleBasecAccessControlAnalyzerTest {

  /**
   * Every user with role HR or Support must be able to access the KnowledgeBase.
   * 
   */
  @Test
  void testEveryUserWithRoleHasPermissions() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac1.csv");
    Set<String> roles = new HashSet<>();
    roles.add("Support");
    roles.add("HR");
    Set<String> permissions = new HashSet<>();
    permissions.add("KnowledgeBase");
    assertTrue(analyzer.everyUserWithRoleHasPermissions(roles, permissions),
        "Every user with role HR or Support must be able to access the KnowledgeBase.");
  }

  /**
   * Only users with role Admin may access the Firewall.
   */
  @Test
  void testOnlyUsersWithRoleHavePermissions() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac1.csv");
    assertTrue(analyzer.onlyUserWithRoleHasPermission("Admin", "Firewall"),
        "Only users with role Admin may access the Firewall.");
  }

  /**
   * No user may access the firewall and the accounting at the same time.
   */
  @Test
  void testNoUserHasBothPermissions() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac1.csv");
    assertFalse(analyzer.noUserHasBothPermissions("Firewall", "Accounting"),
        "No user may access the firewall and the accounting at the same time.");
  }

  /**
   * No user may access the course and the marks at the same time.
   */
  @Test
  void testNoUserHasBothPermissions2() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac2.csv");
    assertTrue(analyzer.noUserHasBothPermissions("Course", "Marks"),
        "No user may access the course and the marks at the same time.");
  }

  /**
   * Only users with role Teacher may access the assignment.
   */
  @Test
  void testOnlyUsersWithRoleHavePermissions2() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac2.csv");
    assertFalse(analyzer.onlyUserWithRoleHasPermission("Teacher", "Assignment"),
        "Only users with role Teacher may access the assignment.");
  }

  /**
   * Every user with role Student or Admin must be able to access the course and
   * the server.
   */
  @Test
  void testEveryUserWithRoleHasPermissions2() {
    RoleBasecAccessControlAnalyzer analyzer = new RoleBasecAccessControlAnalyzer("rbac2.csv");
    Set<String> roles = new HashSet<>();
    roles.add("Student");
    roles.add("Admin");
    Set<String> permissions = new HashSet<>();
    permissions.add("Course");
    permissions.add("Server");
    assertFalse(analyzer.everyUserWithRoleHasPermissions(roles, permissions),
        "Every user with role Student or Admin must be able to access the course and the server.");
  }
}
