const express = require('express');
const request = require('request');
const bodyParser = require('body-parser');
const expHand = require('express-handlebars');
require('dotenv').config();

const accountSid = process.env.accountSid;
const authToken = process.env.authToken;

const client = require('twilio')(accountSid, authToken);
const app = express();

/*  CONFIGURATION    */
app.engine('handlebars', expHand({
    defaultLayout: 'main'
}));
app.set('view engine', 'handlebars');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({
    extended: true
}));


app.get('/', (req, res) => {
    res.render('index');
});

app.get('/onesite', (req, res) => {
    res.render('onesite');
});

app.get('/multisite', (req, res) => {
    res.render('multisite');
});

app.post('/result', (req, res) => {
    let site = req.body.site;
    request(site, (error, response) => {
        if (error) {
            console.log(`Error with the site ${site} \n ${error}`);
        } else {
            let status = response.statusCode;
            res.send(`The result is ${status}`);
        }

        let msgFormat = `The site ${site} is up and running`;
        client.messages.create({
            to: '+15105864466',
            from: '+12019756633',
            body: msgFormat
        })
    });
});







app.listen(process.env.PORT || 3000, () => {
    console.log("Application Has Been Started");
});

//+12019756633