const model = require("../model/shoppingModel");

const showShoppingList = (req, res) => {
    const data = model.getData();
    res.render("index",{ wishList: data.wishList, purchasedList: data.purchasedList});
};

const addItem = (req, res) => {
    const { item, listType } = req.body;
    model.addItem(item, listType);
    res.redirect("/");
};

const deleteItem = (req, res) => {
    const { item, listType } = req.body;
    model.deleteItem(item,listType);
    res.redirect("/");
};

const toggleItem = (req, res) => {
    const { item, fromList } = req.body;
    model.toggleItem(item, fromList);
    res.redirect("/");
};

module.exports = { showShoppingList, addItem, deleteItem, toggleItem }
