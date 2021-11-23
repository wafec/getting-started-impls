using AutoMapper;

namespace CoreWebApi.Models
{
    public class ModelProfile : Profile
    {
        public ModelProfile()
        {
            CreateMap<SampleInputModel, SampleData>();
            CreateMap<SampleData, SampleOutputModel>();
        }
    }
}
