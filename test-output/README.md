ParaBank-Automation/
│
├── pom.xml                        # Maven dependencies & build config
├── README.md                      # (this file)
├── .gitignore                     # files/folders Git should ignore
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/parabank/
│   │           ├── pages/         # Page Object classes (LoginPage, TransferFundsPage, ...)
│   │           ├── managers/      # DriverManager, SessionManager
│   │           ├── utils/         # ConfigReader, ExcelReader, WaitUtils, Screenshot util
│   │           └── data/          # Data models or DTOs (optional)
│   │
│   └── test/
│       └── java/
│           └── com/parabank/
│               ├── tests/         # Test classes (LoginTests, TransferTests ...)
│               ├── listeners/     # ITestListener implementation (screenshots on failure)
│               └── suites/        # testng suite runners (if used)
│
├── resources/
│   ├── config.properties          # browser, URL, timeouts, paths
│   ├── testng.xml                 # TestNG suite config
│   └── testdata.xlsx              # Excel test data for data-driven tests
│
└── output/
    ├── test-output/               # TestNG reports
    ├── screenshots/               # Failure screenshots saved by listeners
    └── logs/                      # Optional logs
pom.xml — tells Maven which libraries to download (Selenium, TestNG, WebDriverManager, Apache POI).

src/main/java/com/parabank/pages — one class per web page; contains locators + methods to interact.

src/main/java/com/parabank/managers — centralizes WebDriver creation (browser selection); use WebDriverManager here.

src/main/java/com/parabank/utils — helpers (read config, read Excel, take screenshots, explicit waits).

src/test/java/com/parabank/tests — TestNG test classes with @BeforeMethod, @Test, @AfterMethod.

resources/config.properties — change browser or URL without editing Java source.

testng.xml — defines which tests/suites to run, parallel settings, listeners.

output/ — stores results so you do not commit generated files to Git.