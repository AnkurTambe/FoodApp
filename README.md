# FoodApp
Food-Ordering Android App
Android Studio
APIs|LogIn|SigUp|HomePage|Menu|RecyclerView|Cart|Payment|Confirmation|Notification|BillHistory|

*APK is the Release section*

The App is based on WAMP local server so, to see the full execution of the app you have to first do following things:
1. Download WAMP server and install it on your PC. Clone the repo.
2. Go to the file of WAMP(wamp64) and, then to the 'www' folder located inside it. Generally- C:\wamp64\www
3. Copy the folder 'FoodAppPhp' from the code section of this repo, and paste it in the 'www' folder. Now the PHP(APIs) setup is complete.
4. Find the 'foodappdb.sql' from code section of this repo.
5. Run the WAMP app then, go to a browser and type 'http://localhost/phpmyadmin/' in URL and hit enter.
6. The phpmyadmin login page will appear, username is 'root' and password is blank i.e. nothing, then hit 'Go'.
7. Phpmyadmin index page will appear, click on 'Import' and then click on 'Choose File' option, select the 'foodappdb.sql' and then hit 'Go'. Now the database setup is complete.
8. Overall Local Server is setup. Now, install the App from the APK. Ensure that WAMP server is running properly.
9. Now, in the right side of the taskbar, WAMP symbol will appear. Left click on it, then go to 'Apache' and then open 'httpd-vhost.conf'.
10. Replace 'Require Local' to 'Require all granted'. Restart the WAMP app.
11. Ensure the mobile, that has the app installed, and the PC, that has the local server setup, are connected to the same WIFI.
12. Now, you can launch the app, and see its execution.