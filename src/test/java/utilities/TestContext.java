package utilities;

import java.io.IOException;

public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ConfigManager configManager = new ConfigManager();

	public TestContext() throws IOException{
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.init_driver(configManager.readPropertiesFile().getProperty("browser")));

	}
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	public ConfigManager getConfigManager() {
		return configManager;
	}
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
