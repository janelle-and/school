using Microsoft.EntityFrameworkCore;
using GuitarShop2.Models;

var builder = WebApplication.CreateBuilder(args);

//dependency injection for database
builder.Services.AddDbContext<ShopContext>(options => options.UseSqlServer(
    builder.Configuration.GetConnectionString("ShopContext")));


// Add services to the container.
builder.Services.AddControllersWithViews();

var app = builder.Build();


app.UseHttpsRedirection();
app.UseRouting();

app.UseAuthorization();

app.MapStaticAssets();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}")
    .WithStaticAssets();



app.Run();
