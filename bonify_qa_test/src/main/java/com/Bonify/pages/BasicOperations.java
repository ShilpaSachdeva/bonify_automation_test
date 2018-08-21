package com.Bonify.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementHandling;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.MouseOperations;

import commonLibs.implementation.TextboxControls;
import commonLibs.implementation.WindowHandling;

public class BasicOperations {
	public ElementHandling elementControl;
	public TextboxControls textboxControl;
	public DropdownControl dropdownControl;
	public MouseOperations mouseOperation;
	public WindowHandling windowControl;

	public WebDriver driver;

	public BasicOperations(WebDriver driver) {
		elementControl = new ElementHandling();
		textboxControl = new TextboxControls();
		dropdownControl = new DropdownControl();
		mouseOperation = new MouseOperations(driver);
		windowControl = new WindowHandling(driver);

	}
}
