const express = require('express');
const router = express.Router();
const controller = require('../controller/shoppingController');

router.get('/', controller.showShoppingList);
router.post('/add', controller.addItem);
router.post('/delete', controller.deleteItem);
router.post('/toggle', controller.toggleItem);

module.exports = router;
