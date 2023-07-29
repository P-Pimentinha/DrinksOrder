package com.example.drinksorder

class DrinkModel {


        private var name: String = "";
        private var quantity: Int = 0;

        constructor(name: String, quantity: Int) {
            this.name = name
            this.quantity = quantity
        }

        fun getDrinkName(): String{
            return this.name;
        }

        fun getDrinkQuantity(): String{
            return this.quantity.toString()
        }

        fun addQUantity(){
            this.quantity += 1;
        }

        fun subQuantity(){
            if(this.quantity == 0) return;
            this.quantity -= 1
        }

}