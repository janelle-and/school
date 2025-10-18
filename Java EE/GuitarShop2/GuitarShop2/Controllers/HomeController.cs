using System.Diagnostics;
using GuitarShop2.Models;
using Microsoft.AspNetCore.Mvc;

namespace GuitarShop2.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }



    }
}
