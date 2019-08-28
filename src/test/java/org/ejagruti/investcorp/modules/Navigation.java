package org.ejagruti.investcorp.modules;

import org.ejagruti.investcorp.pages.Active_CC_AccountsPage;
import org.ejagruti.investcorp.pages.AdminHomePage;
import org.ejagruti.investcorp.pages.AdminLoginPage;
import org.ejagruti.investcorp.pages.CitywiseBranchesTotalPage;
import org.ejagruti.investcorp.pages.PremiumCalculatorPage;
import org.ejagruti.investcorp.pages.ViewBranchesPage;
import org.ejagruti.investcorp.pages.ViewCitiesPage;
import org.ejagruti.investcorp.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Navigation {

	@Parameters({ "Navigation" })
	@Test(description = "Navigation functionality")
	public void execute(String testData) throws InterruptedException {
		// System.out.println(testData);

		String menu = testData.split(",")[0].split("=")[1];
		String submenu = testData.split(",")[1].split("=")[1];

		// System.out.println(menu+" "+submenu);

		WelcomePage wp = new WelcomePage(LaunchApp.driver);
		AdminLoginPage alp = wp.GetAdminLoginPageObject();
		AdminHomePage ahp = alp.GetAdminHomePageObject();

		Thread.sleep(4000);

		/*
		 * if(menu.equals("Insurance")) { ahp.clickOnSubMenu(menu);
		 * Thread.sleep(3000); ahp.clickOnSubMenu(submenu); Thread.sleep(6000);
		 * } else { ahp.mouseOverMenu(menu); Thread.sleep(3000);
		 * ahp.clickOnSubMenu(submenu); }
		 */

		if (menu.equalsIgnoreCase("view/edit")
				&& submenu.equalsIgnoreCase("branches")) {

			ahp.mouseOverViewEdit();
			Thread.sleep(4000);

			ahp.clickOnBranches();
			Thread.sleep(4000);

			ViewBranchesPage vbp = ahp.GetViewBranchesPageObject();
			boolean vb = vbp.checkViewBranchesPage();
			Assert.assertEquals(vb, true);

		}

		if (menu.equalsIgnoreCase("view/edit")
				&& submenu.equalsIgnoreCase("cities")) {

			ahp.mouseOverViewEdit();
			Thread.sleep(4000);

			ahp.clickOnCities();
			Thread.sleep(4000);

			ViewCitiesPage vcp = ahp.GetViewCitiesPageObject();
			boolean vc = vcp.checkViewCitiesPage();
			Assert.assertEquals(vc, true);

		}

		if (menu.equalsIgnoreCase("reports")
				&& submenu.equalsIgnoreCase("city_wise_branches_total")) {
			ahp.mouseOverReports();
			Thread.sleep(4000);

			ahp.clickOnCitiwiseBranchesTotal();
			Thread.sleep(120000);

			CitywiseBranchesTotalPage cbt = ahp
					.GetCitywiseBranchesTotalPageObject();
			boolean cb = cbt.checkCitywiseBranchesTotalPage();
			Assert.assertEquals(cb, true);

		}

		if (menu.equalsIgnoreCase("reports")
				&& submenu.equalsIgnoreCase("Active_CC_Accounts")) {
			ahp.mouseOverReports();
			Thread.sleep(4000);

			ahp.clickOnActive_CC_Accounts_Total();
			Thread.sleep(120000);

			Active_CC_AccountsPage acp = ahp.GetActiveCCAccountsPageObject();
			boolean aca = acp.checkActiveCCAccountsPage();
			Assert.assertEquals(aca, true);
		}

		if (menu.equalsIgnoreCase("insurance")
				&& submenu.equalsIgnoreCase("premium_calculator")) {
			ahp.mouseOverInsurance();
			Thread.sleep(4000);

			ahp.clickOnPremiumCalculator();
			Thread.sleep(6000);

			PremiumCalculatorPage pcp = ahp.GetPremiumCalculatorPageObject();
			boolean pc = pcp.checkPremiumCalculatorlPage();
			Assert.assertEquals(pc, true);
		}

	}

}
