package de.buw.fm4se.rbac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * API for accessing the RBAC table stored in a CSV file.
 * 
 * @author GitHub Copilot
 */
public class RbacTableReader {
  
  /** for each role lists the permissions that role has */
  private Map<String, Set<String>> rolePermissions;
  /** for each permission lists roles with that permission */
  private Map<String, Set<String>> permissionRoles;
  
  public RbacTableReader(String csvFile) {
    rolePermissions = new java.util.LinkedHashMap<>();
    permissionRoles = new java.util.LinkedHashMap<>();
    initialize(csvFile);
  }

  private void initialize(String csvFile) {
    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(csvFile));
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    String[] permissions = lines.get(0).split(",");
    
    // initialize maps for permissions with empty set of roles
    for (int i = 1; i < permissions.length; i++) {
      String permission = permissions[i];
      this.permissionRoles.put(permission, new LinkedHashSet<>());
    }

    for (int i = 1; i < lines.size(); i++) {      
      String[] roleAndPermissions = lines.get(i).split(",");
      if (roleAndPermissions.length < 1) {
        // we found an empty line, skip it
        continue;
      }
      String role = roleAndPermissions[0];
      // initialize map for role with empty set of permissions
      this.rolePermissions.put(role, new LinkedHashSet<>());
      // figure out actual permissions for this current role
      for (int j = 1; j < roleAndPermissions.length; j++) {
        String permission = permissions[j];
        if (roleAndPermissions[j].equals("OK")) {
          this.rolePermissions.get(role).add(permission);
          this.permissionRoles.get(permission).add(role);
        }
      }
    }

  }

  /**
   * Retrieve the set of roles in the RBAC table.
   * 
   * @return
   */
  public Set<String> getRoles() {
    return rolePermissions.keySet();
  }

  /**
   * Retrieve the set of permissions in the RBAC table.
   * 
   * @return
   */
  public Set<String> getPermissions() {
    return permissionRoles.keySet();
  }

  /**
   * Retrieve the set of permissions for a given role.
   * 
   * @param role
   * @return
   */
  public Set<String> getPermissionsForRole(String role) {
    return rolePermissions.get(role);
  }

  /**
   * Retrieve the set of roles for a given permission.
   * 
   * @param permission
   * @return
   */
  public Set<String> getRolesForPermission(String permission) {
    return permissionRoles.get(permission);
  }
  
}
