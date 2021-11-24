using Microsoft.EntityFrameworkCore;

namespace CoreWebApi.Models
{
    public class SampleContext : DbContext
    {
        public DbSet<SampleData> SampleDataSet { get; set; }

        public SampleContext()
        {

        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySQL("server=mysql.localhost;database=sample;user=sample_user;password=secret");
        }
    }
}
