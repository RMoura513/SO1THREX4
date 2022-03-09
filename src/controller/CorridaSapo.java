package controller;

public class CorridaSapo{

	final static int nsapo = 5;
	final static int dst = 500;
	
	public static void main(String[] args) {
		for (int i = 1; i <= nsapo; i++) {
			new SapoCorrendo("Sapo_" + i, dst).start();
			
		}
	}
}
	
	
	
class SapoCorrendo extends Thread{

	String nome;
	int dstcor = 0;
	int dsttcor;
	int pulo = 0;
	int pulos = 0;
	static int colocacao = 0;
	final static int pulom = 50;
	
	public SapoCorrendo (String nome, int dsttcor) {
	super(nome);
	this.dsttcor = dsttcor;
	this.nome = nome;
	}
	
	public void SituacaoSapo() {
		System.out.println("O " + nome + " pulou " + pulo + "cm \t e já percorreu " + dstcor + "cm");
	}
	
	public void PuloSapo() {
		pulos++;
		pulo = (int) (Math.random() * pulom);
		dstcor += pulo;
		if (dstcor > dsttcor) {
			dstcor = dsttcor;
		}
	}
	
	public void SapoD() {
		this.yield();
	}
		
	public void ColocacaoSapo() {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + "º colocado com " + pulos + " pulos");
	}
	
    public void run() {
    	while (dstcor < dsttcor) {
    		PuloSapo();
    		SituacaoSapo();
    		SapoD();
    	}
    	ColocacaoSapo();
    		
    	}
    }