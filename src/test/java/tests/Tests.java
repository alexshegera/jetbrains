package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.homePageTests.StartPageTests;

@Suite
@SuiteDisplayName("Start Page tests")
@SelectClasses({StartPageTests.class})
public class Tests {}
