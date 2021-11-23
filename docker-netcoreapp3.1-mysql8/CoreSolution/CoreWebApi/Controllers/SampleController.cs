using AutoMapper;
using CoreWebApi.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;

namespace CoreWebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SampleController : ControllerBase
    {
        private SampleContext _sampleContext;
        private IMapper _mapper;

        public SampleController(SampleContext sampleContext, IMapper mapper)
        {
            _sampleContext = sampleContext;
            _mapper = mapper;
        }

        [HttpPost]
        public IActionResult Post(SampleInputModel inputModel)
        {
            var sampleData = _mapper.Map<SampleData>(inputModel);
            _sampleContext.SampleDataSet.Add(sampleData);
            _sampleContext.SaveChanges();
            return new JsonResult(_mapper.Map<SampleOutputModel>(sampleData));
        }

        [HttpGet]
        public IEnumerable<SampleOutputModel> Get()
        {
            return _sampleContext.SampleDataSet.ToList().Select(x => _mapper.Map<SampleOutputModel>(x));
        }
    }
}
