# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Gradle project for UI application
* 7.6
* git@bitbucket.org:sonali2711/login_gradle.git

### How do I get set up? ###

* Summary of set up
Prerequisites: Gradle runs on all major operating systems and requires only a Java JDK version 8 or higher to be installed.  
Step 1. Download the latest Gradle distribution 
 The distribution zip file comes in two flavors: 
    Binary-only 
Complete, with docs and sources 

Step 2. Create a new directory C:\Gradle with File Explorer. 
Unpack the zip file in c:/Gradle folder 

Step 3. Configure your sytem Environment. 
https://gradle.org/install/ 

Step 4. Install VS code 

Step 5. Git clone 
 git@bitbucket.org:sonali2711/login_gradle.git
* How to run tests
1. Build project:-Gradle build
2. To run in specific browser:-Gradle test -Dbrowser= chrome/firefox/chromeheadless
3. To run in specific groups:- Gradle test -Dbrowser=chrome/firefox -Dtag=specific tag name
4. To get sepcific log levels:- Gradle test -Dlog=specific log levels
5. To run in remote chrome browser on docker container:- Gradle test -Dbrowser=chromeremote
6. To run in remote firefox browser on docker container:- Gradle test -Dbrowser=firefoxremote
7. To run api Test:-Gradle test -Dtag=specific api tag

### Docker Setup
1. Install docker desktop
2. create image for chrome and firefox
docker pull selenium/standalone-chrome
docker pull selenium/standalone-firefox
3. Running the container
docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox
4. Open the browser and navigate to http://localhost:4444/. It reflects Selenium Grid UI.
5.Open the browser and navigate to http://localhost:4445/. It reflects Selenium Grid UI.

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact