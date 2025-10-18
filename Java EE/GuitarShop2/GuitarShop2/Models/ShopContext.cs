using Microsoft.EntityFrameworkCore;

namespace GuitarShop2.Models
{
    public class ShopContext : DbContext
    {
        public ShopContext(DbContextOptions<ShopContext> options)
            : base(options)
        {
        }
        public DbSet<Product> Products { get; set; } = null!;
        public DbSet<Category> Categories { get; set; } = null!;
       

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Product>().HasData(
                new Product
                {
                    ProductId = 1,
                    CategoryId = 1,
                    Code = "Fender-Stratocaster",
                    Name = "Fender Stratocaster",
                    Price = 699.00M
                }
            );

            modelBuilder.Entity<Category>().HasData(
                new Category { CategoryId = 1, Name = "Guitars" },
                new Category { CategoryId = 2, Name = "Basses" },
                new Category { CategoryId = 3, Name = "Drums" }
            );
        }
    }
}
