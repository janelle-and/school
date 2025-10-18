const express = require('express');
const {MongoClient} = require('mongodb');

const app = express();
const port = 3000;
const url = "mongodb://localhost:27017";
const dbName = "myFirstDatabase";

let db;

//Connect to MongoDB
MongoClient.connect(url, {useUnifiedTopology: true}, (err, client) => {
    if (err) return console.error(err);
    console.log('Connected to MongoDB');
    db = client.db(dbName);
});

//API to get all students
app.get('/student', (req, res) => {
    db.collection('student').find().toArray((err, results) => {
        if (err) return res.status(500).send(err);
        res.json(results);
    });
});

// Start the server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});