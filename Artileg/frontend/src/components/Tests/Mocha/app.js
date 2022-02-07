var Product = function(){
    this.products = ['Bionic_leg', 'Blue_Covering_Armor', 'Natural_leg'];
};
Product.prototype.checkMenu= function(){
    //returns a string
    //returns a random product from the products array
    let product = this.products[Math.floor(Math.random() * this.products.length)];

    console.log("I will like to have:", product);
    return product;
};

Product.prototype.customersFed= function(){

    if(this.customers >=1){

        console.log("Customer fed with good product!");
        this.customers--;

    }else if(this.customers===0){
        console.log("All customers have been satisfied. Done for the day!");
    }else{
        let cusLeft= this.customers;
        console.log("Customer fed with good product!", cusLeft , "more to go!");
        this.customers-= cusLeft;
    }

    return this.customers;
};

let product = new Product();

module.exports = product;

