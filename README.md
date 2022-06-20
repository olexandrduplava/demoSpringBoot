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
2.  Project should start in your localhost

##Postman
1. In Postman folder you will find file DemoWithoutSecurity.json.
2. Import this file into your postman

##Version of project
1. If you on main branch, u can go through url in controllers and test it or using POSTMAN.
2. If you want test Security, go to Security branch and lauch project again
Use login page to authorize:

        User : 
            login: user
            password: user
            
        Admin: 
            login: admin
            password: admin
