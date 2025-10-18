namespace GuitarShop2.Models
{
    public class Product
    {
        public int ProductId { get; set; }
        public int CategoryId { get; set; }
        public string Code { get; set; } = string.Empty;
        public string Name { get; set; } = string.Empty;
        public decimal Price { get; set; }

        public string Slug => Name.Replace(" ", "-");

        public Category Category { get; set; } = null!;
    }
}
