package br.com.fisioterapia.database.pessoas;


public abstract class Pessoa {

    private int codPessoa;
    private String nome;
    private long cpf;
    private String rg;
    private long telefone;
    private String email;
    private String endereco;

   

    public Pessoa(int codPessoa, String nome, long cpf, String rg, long telefone, String email, String endereco) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Pessoa(String nome, long cpf, String rg, long telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
     

    public Pessoa(long cpf) {
        this.cpf = cpf;
    }

    public Pessoa() {

    }
    
     public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   
}
