package de.buw.fm4se.rbac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RbacTableReaderTest {

  @Test
  void testGetRoles() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(3, rbac.getRoles().size(),
        "There are 3 roles in the `rbac1.csv` file, but got " + rbac.getRoles().size() + " roles.");
  }

  @Test
  void testGetPermissions() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(3, rbac.getPermissions().size(),
        "There are 3 permissions in the `rbac1.csv` file, but got " + rbac.getPermissions().size() + " permissions.");
  }

  @Test
  void testGetRolesForPermission() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(
        1,
        rbac.getRolesForPermission("Accounting").size(),
        "There is 1 role for the permission Accounting in the `rbac1.csv` file, but got "
            + rbac.getRolesForPermission("Accounting").size() + " roles.");

    assertEquals(3, rbac.getRolesForPermission("KnowledgeBase").size(),
        "There are 3 roles for the permission KnowledgeBase in the `rbac1.csv` file, but got "
            + rbac.getRolesForPermission("KnowledgeBase").size() + " roles.");

    assertEquals(1, rbac.getRolesForPermission("Firewall").size(),
        "There is 1 role for the permission Firewall in the `rbac1.csv` file, but got "
            + rbac.getRolesForPermission("Firewall").size() + " roles.");
  }

  @Test
  void testGetPermissionsForRole() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(2, rbac.getPermissionsForRole("Admin").size(),
        "There are 2 permissions for the role Admin in the `rbac1.csv` file, but got "
            + rbac.getPermissionsForRole("Admin").size() + " permissions.");
    assertEquals(2, rbac.getPermissionsForRole("HR").size(),
        "There are 2 permissions for the role HR in the `rbac1.csv` file, but got "
            + rbac.getPermissionsForRole("HR").size() + " permissions.");
    assertEquals(1, rbac.getPermissionsForRole("Support").size(),
        "There is 1 permission for the role Support in the `rbac1.csv` file, but got "
            + rbac.getPermissionsForRole("Support").size() + " permissions.");
  }

}
