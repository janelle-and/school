const express = require("express");
const app = express();
const PORT = 3001;

app.set("view engine","ejs");
app.use(express.urlencoded({extended: true}));
//body parser for form data
app.use(express.static("public"));
//serve CSS, image from public

const shoppingRoutes = require("./routes/shoppingRoutes");
app.use("/",shoppingRoutes);

app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
}); 