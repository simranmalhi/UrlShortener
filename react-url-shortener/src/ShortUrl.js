export const getShortUrl = () => {
    var longUrl = document.getElementById("longUrl").value;
    shortCode(longUrl)
}
  
async function shortCode(longUrl) {
    const response = await fetch('http://localhost:5000/api/create?longUrl=' + longUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    }); 
    const data = await response.json();  
    var shortUrl = 'Your short url is: <a href="/' + data.shortCode + '" target="_blank">' 
        +   window.location.protocol
        +   '//' + window.location.host
        +   '/' 
        +   data.shortCode + '</a>'; 
    document.getElementById("longUrl").value = "";
    document.getElementById("shortCode").innerHTML = shortUrl; 
}

