using System.ComponentModel.DataAnnotations;

namespace WebMVC.Models
{
    public class Formulario
    {
        [Key]
        public int ID { get; set; }
        public string Nombres { get; set; }
        public string Apellidos { get; set; }
        [Display(Name = "Tipo Documento")]
        public string Tipodoc { get; set; }
        [Display(Name = "Número Documento")]
        public string Númerodoc { get; set; }
        public string Direccion { get; set; }
        public string Telefono { get; set; }
        public string Ciudad { get; set; }
        public string Ocupacion { get; set; }
    }
}
