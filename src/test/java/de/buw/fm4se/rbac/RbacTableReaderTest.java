package de.buw.fm4se.rbac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RbacTableReaderTest {

  @Test
  void testGetRoles() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(3, rbac.getRoles().size());
  }
  
    @Test
  void testGetPermissions() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(3, rbac.getPermissions().size());
  }

  @Test
  void testGetRolesForPermission() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(1, rbac.getRolesForPermission("Accounting").size());
    assertEquals(3, rbac.getRolesForPermission("KnowledgeBase").size());
    assertEquals(1, rbac.getRolesForPermission("Firewall").size());
  }

  @Test
  void testGetPermissionsForRole() {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    assertEquals(2, rbac.getPermissionsForRole("Admin").size());
    assertEquals(2, rbac.getPermissionsForRole("HR").size());
    assertEquals(1, rbac.getPermissionsForRole("Support").size());
  }

}
