//Ôn tập lớp tổng quát, lớp enum, lớp dữ liệu .....

// Bài tập: Quản lý sản phẩm trong kho
// Viết chương trình Kotlin quản lý thông tin sản phẩm. Mỗi sản phẩm có tên, giá và số lượng tồn kho. Giá có thể là số nguyên hoặc số thực, tùy sản phẩm.

// A. Tạo lớp tổng quát

// Tạo lớp Product<T> với các thuộc tính:
// - name: String
// - price: T
// - stock: Int
// B. Tạo đối tượng

// Trong main(), tạo:
// - Một sản phẩm có giá kiểu Int.
// - Một sản phẩm có giá kiểu Double.
// C. Viết hàm tổng quát

// Viết hàm printProduct(product: Product<T>) để in tên, giá và số lượng tồn kho.

// Gọi hàm với cả hai sản phẩm đã tạo ở phần B. Không viết hai hàm riêng cho Int và Double.
//D. Áp dụng enum class
//1. Tạo enum class tên Category gồm các loại sản phẩm: ELECTRONICS, BOOKS, CLOTHING.
//2. Thêm thuộc tính category: Category vào lớp Product<T>.
//3. Gán danh mục phù hợp cho hai sản phẩm đã tạo ở phần B.
//4. Cập nhật printProduct() để in thêm danh mục sản phẩm.
class Product<T>(
    var name: String,
    var price: T,
    var stock: Int,
    var type: Category
)

enum class Category{
    ELECTRONICS, BOOKS, CLOTHING, FOOD
}

fun <T> printProduct(product: Product<T>) {
    println(
        "Product: ${product.name}, Price: ${product.price}, Stock: ${product.stock}, Category: ${product.type}"
    )
}
fun main() {
    var computer: Product<Int> = Product("Computer", 15000000, 100, Category.ELECTRONICS)
    var book: Product<Double> = Product("Book", 5.5, 100, Category.BOOKS)

    printProduct(computer)
    printProduct(book)
}