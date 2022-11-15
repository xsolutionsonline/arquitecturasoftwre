const express = require('express');
const dotenv= require('dotenv');

const cors = require('cors');

dotenv.config({path:'.env-local'});

const PORT = process.env.PORT | 3000;

const app = express();
app.use(cors({
    origin: 'http://localhost:4200'
}));

// MIDDLEWARE
app.use(express.json());
app.use(express.urlencoded({extended:false}));

//ROUTES

const userRouter = require('./routes/user');
app.use('/user',userRouter);

// SERVER RUNNING
app.listen(PORT,()=> {
    console.log(`server running on port ${PORT}`);
});



