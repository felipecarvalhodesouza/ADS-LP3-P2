package negocio;

/*
 * Crie um novo projeto padr�o Servlet. Nesse projeto, fa�a um pacote para a regra (chamado "negocio"), onde dever� existir uma classe abstrata chamada "Figura", que implementar� a interface abaixo:

Ainda no pacote "negocio", crie 2 classes, Circulo e Retangulo, derivadas da classe Figura, e implemente as regras de neg�cio (no caso, o m�todo "calcularArea"), bem como os atributos necess�rios para tal c�lculo.

Em outro pacote, chamado "servlets", crie o servlet chamado "ServletForm" e, dentro deste, crie um formul�rio para receber os valores necess�rios para realizar o c�lculo das �reas das figuras c�rculo e ret�ngulo. Crie, tamb�m, 2 bot�es, com os textos "Calcular �rea do c�rculo" e "Calcular �rea do ret�ngulo".

Neste mesmo pacote, crie um servlet chamado "ServletFiguras" e, nele, execute as regras de neg�cio para exibir os valores calculados de acordo com o bot�o clicado no formul�rio HTML.<?xml version="1.0" encoding="ISO-8859-1"?>
 * 
 */
public interface IFigura {
	float calcularArea();
}
