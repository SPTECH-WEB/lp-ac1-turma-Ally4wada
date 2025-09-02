package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;
    public Turma(String nome, Double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }


    public void matricular(Integer qtd) {
        if (qtd != null && qtd > 0 && ativa) {
            this.qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd) {
        if (qtd != null && qtd > 0 && ativa && qtd <= this.qtdAluno) {
            this.qtdAluno -= qtd;
            return qtd;
        } else {
            return null;
        }
    }

    public Integer desativar() {
        if (!ativa) {
            return null;
        }
        int qnt = this.qtdAluno;
        this.qtdAluno = 0;
        this.ativa = false;
        return qnt;
    }

    public void transferir(Turma destino, Integer qtdATransferir) {
        if (destino != null && qtdATransferir != null && destino.ativa && qtdATransferir > 0 && this.qtdAluno > qtdATransferir && this.ativa) {
            destino.qtdAluno += qtdATransferir;
            this.qtdAluno -= qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste) {
        if (reajuste == null || reajuste <= 0) {
            return false;
        }
        reajuste += 1;
        this.mensalidade *= reajuste;
        return true;

    }

    public String getNome() {
        return nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}