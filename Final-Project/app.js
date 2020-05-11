const express = require('express');
const request = require('request');
const bodyParser = require('body-parser');
const expHand = require('express-handlebars');
const func = require('./public/js/functions');
require('dotenv').config();



/* TWILIO KEYS */
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
    sample();
    res.render('index');

});

app.get('/onesite', (req, res) => {
    res.render('onesite');
});

app.get('/multisite', (req, res) => {
    res.render('multisite');
});

app.post('/onesite', (req, res) => {
    let site = req.body.site;
    request(site, (error, response) => {
        if (error) {
            console.log(`Error with the site ${site} \n ${error}`);
        } else {
            let status = response.statusCode;
            res.render('onesite', {
                result: status
            });
        }

        /*  RECURRING FUNCTION CALL */
        let interval;
        let count = 0;

        function test() {
            sendMessage();
            interval = setInterval(sendMessage, 3000);
        }

        function sendMessage() {
            let date = new Date();
            let h = date.getHours();
            let m = date.getMinutes();
            let s = date.getSeconds();

            /*  TWILIO SETUP FOR SENDING MESSAGES */
            let msgFormat = `The site ${site} is up and running \n @${h}:${m}:${s}`;
            client.messages.create({
                to: '+15105864466',
                from: '+12019756633',
                body: msgFormat
            });
            count++;
            if (count == 3) {
                clearInterval(interval);
            }
        }

        test();
    });
});







app.listen(process.env.PORT || 3000, () => {
    console.log("Application Has Been Started");
});

//+12019756633