using Microsoft.AspNetCore.Mvc;
using GuitarShop2.Models;
using Microsoft.EntityFrameworkCore;

namespace GuitarShop2.Controllers
{
    public class ProductController : Controller
    {
        private ShopContext context { get; set; }

        // Constructor to initialize the context object
        public ProductController(ShopContext ctx)
        {
            context = ctx;
        }
        public IActionResult Index()
        {
            return View("List");
        }

        public IActionResult List(string id = "All")
        {
            ViewBag.Category = id;
            return View();
        }
        //public IActionResult Details(string id)
        //{
        //    ViewBag.ProductSlug = id;
        //    return View();
        //}

        public IActionResult Details(int id)
        {
            Product product = context.Products.Where(p => p.ProductId == id).Include(context => context.Category).FirstOrDefault()??new Product();
            return View(product);
        }
    }
}
