import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pratos")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String description;
    private Boolean disp;
    private BigDecimal valor;
    @Column(name = "data_de_registro")
    private LocalDate dataDeRegistro;

    public Prato(Integer id, String nome, String description, Boolean disp, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.disp = disp;
        this.valor = valor;
        dataDeRegistro = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisp() {
        return disp;
    }

    public void setDisp(Boolean disp) {
        this.disp = disp;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    @Override
    public String toString() {
        return "Prato [id=" + id + ", nome=" + nome + ", description=" + description + ", disp=" + disp + ", valor="
                + valor + ", dataDeRegistro=" + dataDeRegistro + "]";
    }

}