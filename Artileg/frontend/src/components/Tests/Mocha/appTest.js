const assert = require('chai').assert;
const Product = require('../app');

describe('Product test', function(){

    let product = Product;

    it('check the product has valid name.', function(){
        assert.isString(product.products.checkMenu(), 'string');
    });

    it('check for a category in menu.', function (){
        let category = product.products.checkMenu();
        assert.oneOf(category, product.products)
    });

    it('make sure the product can be bought by more customers.', function(){

        for(var i=0; i<6; i++){
            product.products.customersFed();
            assert.isAtLeast(product.products.customers, 0);
        }
    });
});


