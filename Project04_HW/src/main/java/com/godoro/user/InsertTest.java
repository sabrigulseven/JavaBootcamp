package com.godoro.user;

public class InsertTest {
	public static void main(String[] args) {
		try {
			UserManager userManager = new UserManager();
			User user = new User(2, "sss", "sss");
			boolean isInserted = userManager.create(user);
			if (isInserted)
				System.out.println("Eklendi.");
			else
				System.out.println("Eklenemedi.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
