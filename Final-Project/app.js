const express = require('express');
const request = require('request');
const bodyParser = require('body-parser');
const expHand = require('express-handlebars');

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



app.listen(process.env.PORT || 3000, () => {
    console.log("Application Has Been Started");
});