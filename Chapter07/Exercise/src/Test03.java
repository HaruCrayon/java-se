public class Test03 {
    public static void main(String[] args) {
        Book book1 = new Book("小王子", 134.0);
        book1.info();
        book1.updatePrice();
        book1.info();

    }
}


// 编写类Book,  定义方法updatePrice，实现更改某本书的价格，
// 具体：如果价格>150,则更改为150，如果价格>100,更改为100，否则不变

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        //如果方法中，没有 price 局部变量, this.price 等价 price
        if(price > 150) {
            price = 150;
        } else if(price > 100) {
            price = 100;
        }
    }

    public void info() {
        System.out.println("书名=" + name + " 价格=" + price);
    }
}

