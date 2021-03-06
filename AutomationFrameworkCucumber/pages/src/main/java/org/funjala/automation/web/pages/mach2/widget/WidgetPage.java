package org.funjala.automation.web.pages.mach2.widget;

import org.funjala.automation.web.model.mach2.widget.WidgetModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by DavidVallejos on 1/21/2017.
 */
public class WidgetPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = WidgetModel.dropdownIcon)
  private WebElement dropdownIcon;

  @FindBy(xpath = WidgetModel.dropDownList)
  private WebElement dropDownList;

  @FindBy(css = WidgetModel.erpOption)
  private WebElement erpOption;

  @FindBy(xpath = WidgetModel.eiOption)
  private WebElement eiOption;

  @FindBy(xpath = WidgetModel.managerInput)
  private List<WebElement> managerInput;

  @FindBy(css = WidgetModel.saveButton)
  private WebElement saveButton;

  @FindBy(xpath = WidgetModel.listElementTable)
  private List<WebElement> listElementTable;

  @FindBy(css = WidgetModel.erpEngineerInformationOption)
  private WebElement erpEngineerInformationOption;

  @FindBy(css = "a[data-id='advanced-config']")
  private WebElement advanceConfig;

  @FindBy(xpath = "//div[4]/div[2]/div/div[2]/div/i")
  private WebElement jobTitles;

  @FindBy(xpath = "//div[text()='CFO']")
  private WebElement optionCFO;

  @FindBy(xpath = "//div[@class='truncated text header']")
  private List<WebElement> listName;


  //---------------------------------
  public static final String advanceConfigurationPath = ".//a/b[text()='ADVANCED CONFIGURATION']";
  public static final String comboboxDepartmentPath = ".//*[@id='mach-wizard']/div/div[3]/div/div/div[2]/div[4]/div[2]/div/div[1]/div";
  public static final String tablePath = "//body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/table";
  public static final String tableColumnSkillsPath = "//div[2]/div[1]/table/tbody/tr/td[2]";
  public static final String departmentItem = "//div[contains(text(),'%s')]";
  public static final String skillLevelPath = "//div[contains(text(),'%s')]";
  public static final String skillLevelsPath = "//div[@class='ui form params-container']/div[3]/div";
  //-------------------------------

  @FindBy(xpath = advanceConfigurationPath)
  private WebElement advanceConfiguration;

  @FindBy(xpath = comboboxDepartmentPath)
  private WebElement comboboxDepartment;

  @FindBy(xpath = tablePath)
  private WebElement table;

  @FindBy(xpath = tableColumnSkillsPath)
  private List<WebElement> tableColumnSkills;

  @FindBy(xpath = WidgetModel.menuDivisionsButton)
  WebElement menuDivisionsButton;

  @FindBy(xpath = WidgetModel.accountItem)
  WebElement accountItem;

  @FindBy(xpath = WidgetModel.ListElementListWidget)
  private List<WebElement> listElementListWidget;

  @FindBy(xpath = WidgetModel.selectorDivisions)
  List<WebElement> selectorDivisions;

  @FindBy(xpath = skillLevelsPath)
  WebElement skillLevels;

  public void clickOnAdvanceConfiguration() {
    wait.until(ExpectedConditions.visibilityOf(advanceConfiguration));
    advanceConfiguration.click();
  }

  public void clickOnComboboxDepartment() {
    comboboxDepartment.click();
  }

  public void setDepartmentName(String departmentName) {
    wait.until(ExpectedConditions.visibilityOf(comboboxDepartment));
    wait.until(ExpectedConditions.elementToBeClickable(comboboxDepartment));
    comboboxDepartment.click();
    driver.findElement(By.xpath(String.format(departmentItem, departmentName))).click();
  }

  public int findSkillOnColumns(String skill) {
    int count = 0;
    for (WebElement element : tableColumnSkills) {
      if (element.getText().contains(skill)) {
        count++;
      }
    }
    return count;
  }

  public int verifyCantDepartment(String department) {
    int cant = 0;
    for (WebElement element : listElementTable) {
      if (element.getText().equals("Security test")) {
        cant++;
      }
    }
    return cant;
  }

  public WidgetPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public void clickOnSkillLevels() {
    wait.until(ExpectedConditions.visibilityOf(skillLevels)).click();
  }

  public void setSkillLevel(String skill) {
    driver.findElement(By.xpath(String.format(skillLevelPath, skill))).click();
  }

  public void addWidget(String type) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-component='widget']")));
    driver.findElement(By.xpath("//div[@class='name' and text()=" + "\'" + type + "\'" + "]")).click();
  }

  public void setDivisionName(String divisionName) {
    wait.until(ExpectedConditions.elementToBeClickable(menuDivisionsButton));
    menuDivisionsButton.click();
    for (WebElement element : selectorDivisions) {
      if (element.getText().trim().toUpperCase().equals(divisionName.trim().toUpperCase()))
        element.click();
    }
    menuDivisionsButton.click();
  }

  public void clickOnService(String service) {
    driver.findElement(By.xpath("//span[text()=" + "\'" + service + "\'" + "]")).click();
  }

  public void clickOnSpecificService(String specificService) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mach-wizard\"]//*[@class=\"wizard-provider-panel\"]")));
    driver.findElement(By.xpath("//h4[@class='ui header' and text()=" + "\'" + specificService + "\'" + "]")).click();
  }

  public void clickOnSpecificCombobox() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mach-wizard\"]/div/div[3]/div/div/div[2]/div[4]/div")));
    driver.findElement(By.xpath("//*[@id=\"mach-wizard\"]/div/div[3]/div/div/div[2]/div[4]/div")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='field' and @data-key='Areas']//div[@class='item' and @data-value='33']")));
    driver.findElement(By.xpath("//div[@class='field' and @data-key='Areas']//div[@class='item' and @data-value='33']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wizard']/div")));
    driver.findElement(By.xpath("//*[@id='wizard']/div")).click();
  }


  public int verifyQtyEmployeeExperienceBySkillsCloud(String skillName) {
    int cant = 0;
    for (WebElement element : listElementListWidget) {
      if (element.getText().toUpperCase().contains(skillName.toUpperCase())) {
        cant++;
      }
    }
    return cant;
  }


  public void selectEiOption() {
    wait.until(ExpectedConditions.visibilityOf(eiOption));
    wait.until(ExpectedConditions.elementToBeClickable(eiOption));
    eiOption.click();
  }

  public void selectErpOption() {
    wait.until(ExpectedConditions.elementToBeClickable(erpOption));
    erpOption.click();
  }


  public void setManagerName(String managerName) {
    wait.until(ExpectedConditions.visibilityOf(dropDownList));
    wait.until(ExpectedConditions.elementToBeClickable(dropDownList));
    dropDownList.click();

    for (WebElement element : managerInput) {
      if (element.getText().equals(managerName)) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
      }
    }
    dropdownIcon.click();
  }


  public int verifyCant(String managerName) {
    int cant = 0;
    for (WebElement element : listElementTable) {
      if (element.getText().equals(managerName)) {
        cant++;
      }
    }
    return cant;
  }

  public void selectEngineerInformationOption() {
    wait.until(ExpectedConditions.elementToBeClickable(erpEngineerInformationOption));
    erpEngineerInformationOption.click();
  }

  public boolean verifyList(String name) {
    boolean result = false;
    for (WebElement element : listName) {
      wait.until(ExpectedConditions.visibilityOf(element));
      if (element.getText().equals(name))
        result = true;
    }
    return result;
  }

  public void clickAdvanceConfiguration() {
    wait.until(ExpectedConditions.elementToBeClickable(advanceConfig));
    advanceConfig.click();
  }

  public void selectCFO() {
    wait.until(ExpectedConditions.visibilityOf(jobTitles));
    wait.until(ExpectedConditions.elementToBeClickable(jobTitles));
    jobTitles.click();
    wait.until(ExpectedConditions.visibilityOf(optionCFO));
    wait.until(ExpectedConditions.elementToBeClickable(optionCFO));
    optionCFO.click();
  }

  public void clickSaveButton() {
    wait.until(ExpectedConditions.visibilityOf(saveButton));
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    saveButton.click();
  }
}
