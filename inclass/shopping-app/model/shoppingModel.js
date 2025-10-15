//simple in memory storage
const shoppingData = {
    wishList: [],
    purchasedList: []
};


const getData = () => shoppingData;

const addItem = (item, listType) => {
    if (!item) return;
    if (listType === "wish") shoppingData.wishList.push(item);
    else shoppingData.purchasedList.push(item);
};

const deleteItem = (item, listType) => {
    if (listType === "wish"){
        shoppingData.wishList = shoppingData.wishList.filter(i => i == item);
    } else {
        shoppingData.purchasedList = shoppingData.purchasedList.filter(i => i !== item);
    }
};

const toggleItem = (item, fromList) => {
    if (fromList === "wish"){
        shoppingData.wishList = shoppingData.wishList.filter(i => i !== item);
        shoppingData.purchasedList.push(item);
    } else {
        shoppingData.purchasedList = shoppingData.purchasedList.filter(i=> i !== item);
        shoppingData.wishList.push(item);
    }
};

module.exports = {getData, addItem, deleteItem, toggleItem};