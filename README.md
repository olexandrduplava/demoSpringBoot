# Demo SpringBoot

  ## Creating a local repository
In order to create a local copy of the project you need:
1. Download and install the last version of Git https://git-scm.com/downloads
2. Open a terminal and go to the directory where you want to clone the files. 
3. Run the following command. Git automatically creates a folder with the repository name and downloads the files there.
    git clone https://github.com/olexandrduplava/demoSpringBoot.git
    
## Database
1. Database uses here is h2. Credentials u can find in application.property.

## Starting server using IntelliJ IDEA
1.  Open project and run DemoSpringApplication.main.
2.  Project should start in your localhost;

## AppCheck
1. Open in postman folder Security and press LOGIN reguest
2. In body method enter username in username
				password in password

		roles: 
		USER: username1, password1
		ADMIN: username3, password3
3. You will get tokens. Copy first;
4. Select your request and enter in Authorization: "Bearer $token";


