import React, { Component } from 'react'
import ReactDOM from "react-dom";
//import 'bootstrap/dist/css/bootstrap.css'
import {BrowserRouter as Router, Route} from "react-router-dom";
import {Home} from "./Home";
import {Redirect} from "./Redirect"
//import BrowserRouter from "react-router-dom/BrowserRouter"; 
import {BrowserRouter} from "react-router-dom";

class App extends Component {
    render() {
        return(
            <BrowserRouter>
                <div>
                    {}
                        <Route path="/:shortCode" component={Redirect}/>
                        <Route exact path="/" component={Home}/>
                </div>
            </BrowserRouter>
        )
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));
