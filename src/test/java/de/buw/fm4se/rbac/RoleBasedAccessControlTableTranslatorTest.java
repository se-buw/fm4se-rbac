package de.buw.fm4se.rbac;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import de.buw.fm4se.rbac.exec.LimbooleExecutor;

class RoleBasedAccessControlTableTranslatorTest {
  @Test
  void testTranslateToFormula1Sat() throws IOException, InterruptedException {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);
    assertTrue(LimbooleExecutor.runLimboole(formula, false).contains("Admin"),
        "Admin is in the rbac1.csv file but not in the model.");
  }

  @Test
  void testTranslateToFormulaRbac1ContainsAllRolesAndPermissions() throws IOException, InterruptedException {
    RbacTableReader rbac = new RbacTableReader("rbac1.csv");
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);
    String model = LimbooleExecutor.runLimboole(formula, false);
    for (String permission : rbac.getPermissions()) {
      assertTrue(model.contains(permission),
          "Permission " + permission + " is in the rbac1.csv file but not in the model.");
    }
    for (String role : rbac.getRoles()) {
      assertTrue(model.contains(role), "Role " + role + " is in the rbac1.csv file but not in the model.");
    }
  }

  @Test
  void testTranslateToFormula2Sat() throws IOException, InterruptedException {
    RbacTableReader rbac = new RbacTableReader("rbac2.csv");
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);
    assertTrue(LimbooleExecutor.runLimboole(formula, false).contains("Student"),
        "Student is in the rbac2.csv file but not in the model.");
  }

  @Test
  void testTranslateToFormulaRbac2ContainsAllRolesAndPermissions() throws IOException, InterruptedException {
    RbacTableReader rbac = new RbacTableReader("rbac2.csv");
    String formula = RoleBasedAccessControlTableTranslator.translateToFormula(rbac);
    String model = LimbooleExecutor.runLimboole(formula, false);
    for (String permission : rbac.getPermissions()) {
      assertTrue(model.contains(permission),
          "Permission " + permission + " is in the rbac2.csv file but not in the model.");
    }
    for (String role : rbac.getRoles()) {
      assertTrue(model.contains(role), "Role " + role + " is in the rbac2.csv file but not in the model.");
    }
  }

}
