import React, { Component } from 'react'
import './App.css'

export class Redirect extends Component {
    render() {
        //var shortCode = window.location.search.split('shortCode=')[1]
        getLongUrl(this.props.match.params.shortCode)
        return (
            <div className = "Redirect">
                <h1>Redirecting............</h1>               
            </div>
        )
    }    
}

async function getLongUrl(shortCode) {
    const response = await fetch('http://localhost:5000/api/fetch?shortCode=' + shortCode, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }); 
    const data = await response.json();
    var longUrl = data.longUrl; 
    window.location.href = longUrl;
}