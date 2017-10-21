package core;

import java.security.Permission;

public class DoNotTerminate {
	
	public static void main(String[] args) {
		DoNotTerminate.forbidExit();
		try {
			System.out.println("Exiting...");
			System.exit(0);
		} catch (DoNotTerminate.ExitTrappedException e) {
			   System.out.println("Unsuccessful Termination!!");
		}
	}

	public static class ExitTrappedException extends SecurityException {

		  private static final long serialVersionUID = 1;
		 }

		 public static void forbidExit() {
		  final SecurityManager securityManager = new SecurityManager() {
		   @Override
		   public void checkPermission(Permission permission) {
		    if (permission.getName().contains("exitVM")) {
		     throw new ExitTrappedException();
		    }
		   }
		  };
		  System.setSecurityManager(securityManager);
		 }

}
