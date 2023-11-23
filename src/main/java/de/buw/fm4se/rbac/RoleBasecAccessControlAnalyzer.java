package de.buw.fm4se.rbac;

import java.util.Set;

import de.buw.fm4se.rbac.exec.LimbooleExecutor;

/**
 * This code needs to be implemented by translating FMs to input for Limboole
 * and interpreting the output
 *
 */
public class RoleBasecAccessControlAnalyzer {

  RbacTableReader rbac;

  public RoleBasecAccessControlAnalyzer(String csvFile) {
    rbac = new RbacTableReader(csvFile);
  }

  /**
   * TODO Check if each of the given roles has all of the given permissions
   * 
   * Solve it by using a transaltion to Limboole rather than a direct search in
   * the RBAC table!
   * 
   * @param roles
   * @param permissions
   * @return
   */
  public boolean everyUserWithRoleHasPermissions(Set<String> roles, Set<String> permissions) {
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);

    // TODO: implement this method by translating the problem to Limboole


    // check validity of formula by checking unsatisfiability
    return !checkSat(formula);
  }

  /**
   * TODO Check if only users with the given role have the given permission
   * 
   * Solve it by using a transaltion to Limboole rather than a direct search in
   * the RBAC table!
   * 
   * @param role
   * @param permission
   * @return
   */
  public boolean onlyUserWithRoleHasPermission(String role, String permission) {
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);

    // TODO: implement this method by translating the problem to Limboole

    // check validity of formula by checking unsatisfiability
    return !checkSat(formula);
  }

  /**
   * TODO Check that no user can have the given two permissions at the same time
   * 
   * Solve it by using a transaltion to Limboole rather than a direct search in
   * the RBAC table!
   * 
   * @param permission1
   * @param permission2
   * @return
   */
  public boolean noUserHasBothPermissions(String permission1, String permission2) {
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);

    // TODO: implement this method by translating the problem to Limboole


    // check validity of formula by checking unsatisfiability
    return !checkSat(formula);
  }

  /**
   * Check satisfiability of the formula using Limboole
   * 
   * @param formula
   * @return
   */
  public boolean checkSat(String formula) {
    String result;
    try {
      result = LimbooleExecutor.runLimboole(formula, true);
    } catch (Exception e) {
      throw new RuntimeException("Evaluation for formula via Limboole unsusscessful", e);
    }
    if (result.contains("UNSATISFIABLE")) {
      return false;
    }
    return true;
  }

}
