# UrlShortener

Hello everyone!

This repository is a url shortener service that I have created. 

The folder titled "shortener" is a backend service that I have written in java using SpringBoot and Hibernate in order to create a REST
API and a connection to a MySQL database. "Shortener" takes in a POST REST API call with a long url as a parameter and creates and returns 
a unique short code. Both the short code and long url are saved in a MySQL table in a database. The short code can be used in a GET REST API 
call to get the long url. Both the response and request are in JSON format.

The folder titled "react-url-shortener" is a front-end client ui/webapp that I have written in javascript and css using REACT. It has a
text box for the user to enter the long url and a button for the user to click to recieve a shortUrl, containing the unique short code,
that redirects the user to the original long url. It makes the calls to the REST API in "shortener".
