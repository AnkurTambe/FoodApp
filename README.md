# FoodApp
Food-Ordering Android App
Android Studio
APIs|LogIn|SignUp|HomePage|Menu|RecyclerView|Cart|Payment|Confirmation|SplashScreen|Notification|BillHistory|

WAMP-- Windows, Apache, MySQL, PHP

*APK is the Release section*

Screenshots of the App:

![img1](https://user-images.githubusercontent.com/76391639/123266601-d0dd6100-d519-11eb-85a7-3fc06240c545.jpg)
![img2](https://user-images.githubusercontent.com/76391639/123266624-d470e800-d519-11eb-9805-13689737d2dc.jpg)
![img3](https://user-images.githubusercontent.com/76391639/123266643-d9359c00-d519-11eb-9b4b-bf310de4503b.jpg)
![img4](https://user-images.githubusercontent.com/76391639/123266660-dd61b980-d519-11eb-8c86-6eeadffd8e3e.jpg)
![img5](https://user-images.githubusercontent.com/76391639/123266683-e0f54080-d519-11eb-8230-129ed8763832.jpg)

The App is based on WAMP local server so, to see the full execution of the app you have to first do following things:
1. Download WAMP server and install it on your PC. Clone the repo.
2. Go to the file of WAMP(wamp64) and, then to the 'www' folder located inside it. Generally- C:\wamp64\www
3. Copy the folder 'FoodAppPhp' from the code section of this repo, and paste it in the 'www' folder. Now the PHP(APIs) setup is complete.
4. Find the 'foodappdb.sql' from code section of this repo.
5. Run the WAMP app then, go to a browser and type 'http://localhost/phpmyadmin/' in URL, and hit enter.
6. The phpmyadmin login page will appear, username is 'root' and password is blank i.e. nothing, select the server option as 'MySql', then hit 'Go'.
7. Phpmyadmin index page will appear, click on 'Import' and then click on 'Choose File' option, select the 'foodappdb.sql' and then hit 'Go'. Now the database setup is complete.
8. Overall Local Server is setup. Now, install the App from the APK. Ensure that WAMP server is running properly.
9. Now, in the right side of the taskbar, WAMP symbol will appear. Left click on it, then go to 'Apache' and then open 'httpd-vhost.conf'.
10. Replace 'Require Local' to 'Require all granted'. Restart the WAMP app.
11. Ensure the mobile, that has the app installed, and the PC, that has the local server setup, are connected to the same WIFI.
12. If you are opening the app for the first time on a specific mobile device, there will be a prompt asking you for the IPv4 Address of the WLAN connected to the WAMP server.
13. IPv4 Address of the WLAN can be obtained by using the command 'ipconfig' in the CMD.
14. The prompt will come on automatically after the splash screen. And you can manually call the prompt by using various 'Change IP' buttons present in the app.
15. Ensure you give proper IPv4 Address, otherwise the app will not be able to properly contact server and will give you error.
16. Now, you can launch the app, and see its execution.
