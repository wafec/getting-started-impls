using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace externalService.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class HomeController : ControllerBase
    {
        [HttpGet]
        public IActionResult Index()
        {
            Console.WriteLine("Home Get Called");
            return Ok();
        }

        [HttpPost]
        public IActionResult Post()
        {
            Console.WriteLine("Home Post Called");
            return Ok();
        }
    }
}
