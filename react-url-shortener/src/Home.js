import React, { Component } from 'react'
import './App.css'
import {getShortUrl} from './ShortUrl.js'

export class Home extends Component {
    render() {
        return (
            <div className = "Home">
                <h1>Welcome to Simran's Url Shortener!</h1>
                <h3>Please type in your long url here to get your short url:</h3>
                <input type="text" name="longUrl" id="longUrl"/>
                <button className="btn btn-secondary btn-sm" onClick={getShortUrl}>GetShortCode</button>
                <h3> <span id="shortCode"></span></h3>
            </div>
        )
    }    
}
