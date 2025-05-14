import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		// System.out.println(etiqueta); // Debería imprimir 3

		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		grafo.agregarVertice(1); // D
		grafo.agregarVertice(2); // B
		grafo.agregarVertice(3); // C
		grafo.agregarVertice(4); // H
		grafo.agregarVertice(5); // R
		grafo.agregarVertice(6); // A
		grafo.agregarVertice(7); // T

		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(2, 4, null);
		grafo.agregarArco(3, 5, null);
		grafo.agregarArco(5, 4, null);
		grafo.agregarArco(4, 6, null);
		grafo.agregarArco(4, 7, null);

		// System.out.println(DFS.run(grafito));

		// System.out.println(BFS.run(grafo));

		System.out.println(IsCiclic.run(grafito));
		System.out.println(IsCiclic.run(grafo));

		GrafoNoDirigido<Float> noDirigido = new GrafoNoDirigido<>();

		noDirigido.agregarVertice(1);
		noDirigido.agregarVertice(2);
		noDirigido.agregarArco(1, 2, null);

		System.out.println(IsCiclic.run(noDirigido));

		GrafoDirigido<Integer> inconexo = new GrafoDirigido<>();

		inconexo.agregarVertice(1);
		inconexo.agregarVertice(2);
		inconexo.agregarVertice(3);

		inconexo.agregarArco(2, 3, null);
		inconexo.agregarArco(3, 2, null);

		System.out.println(IsCiclic.run(inconexo));

		System.out.println(LongestRoad.run(inconexo, 1, 2));

		GrafoDirigido<Integer> cuadernillo = new GrafoDirigido<>();

		int i = 9, j = 10;

		cuadernillo.agregarVertice(i);
		cuadernillo.agregarVertice(j);

		cuadernillo.agregarVertice(2);
		cuadernillo.agregarVertice(3);
		cuadernillo.agregarVertice(4);
		cuadernillo.agregarVertice(5);

		cuadernillo.agregarArco(i, 2, null);
		cuadernillo.agregarArco(i, 3, null);
		cuadernillo.agregarArco(2, 4, null);
		cuadernillo.agregarArco(4, 5, null);
		cuadernillo.agregarArco(5, 3, null);
		cuadernillo.agregarArco(3, 4, null);
		cuadernillo.agregarArco(3, j, null);

		LinkedList<Integer> recorrido = LongestRoad.run(cuadernillo, 3, j);

		System.out.println(recorrido);

		LinkedList<Integer> posiblesIniciosA = ExistingRoads.run(cuadernillo, 4);

		System.out.println(posiblesIniciosA);


	}

}