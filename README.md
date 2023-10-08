# ListaGenerica_DAMDUAL

### Transformar lista en Generica

*Puede ver el codigo en la siguiente URL: [RepoListaGnerica](https://github.com/JamirGDC/ListaGeneria_DAMDUAL.git)
* Codigo Inicial
  ```
  public class NodeList {
	//El propio elemento
	private int elem;
	//La referencia al siguiente elemento
	private NodeList next = null;
	//La referencia al anterior elemento
	private NodeList prev = null;
	
	public NodeList(int elemento)
	{
		this.elem = elemento;
	}
	
	//Getters
	public int getElem()
	{
		return this.elem;
	}
	public NodeList getNext()
	{
		return this.next;
	}
	public NodeList getPrev()
	{
		return this.prev;
	}
	
	//Setters
	public void setElem(int elemento)
	{
		this.elem = elemento;
	}
	public void setNext(NodeList siguiente)
	{
		this.next = siguiente;
	}
	public void setPrev(NodeList anterior)
	{
		this.prev = anterior;
	}
	}
	
	public class Lista {
		//El primer elemento de la lista
		private NodeList first = null;
		//El tamaño de la lista
		private int length = 0;
	
	/**
		Devuelve el tamaño.
	*/
	public int size()
	{
		return this.length;
	}
	
	/**
		Añade un elemento al final de lista
		
		@param elem: El valor del elemento a añadir.
	*/
	public void add(int elem)
	{
		NodeList act = new NodeList(elem); //Creamos el nuevo elemento
		if(this.first != null) //Si la lista no está vacía
		{
			NodeList last = this.first;
			//Busca el que no tenga siguiente, es decir, el último.
			while(last.getNext() != null)
			{
				last = last.getNext();
			}
			last.setNext(act);
			act.setPrev(last);
		}else{
			this.first = act;
		}
		
		this.length++;
	}

	/**
		Busca un elemento dado un índice y lo devuelve.
		
		@param index: El índice del elemento a buscar empezando en 0
	*/
	private NodeList search(int index)
	{
		NodeList act = this.first;
		for(int i = 0; i < index; i++)
		{
			act = act.getNext();
		}
		return act;
	}
	
	/**
		Devuelve el valor del elemento en una posición dada.
		
		@param index: La posición del elemento a buscar empezando en 0.
	*/
	public int get(int index) throws IndexOutOfBoundsException
	{
		//Si el índice está dentro de los parámetros.
		if(index >= 0 && index < this.length)
		{
			NodeList elem = search(index);
			return elem.getElem();
		}
		throw new IndexOutOfBoundsException();
	}

	/**
		Cambia el valor del elemento en una posición dada.
		
		@param index: La posición del elemento a cambiar empezando en 0.
		@param elem: El valor a establecer
	*/
	public void set(int index, int elem) throws IndexOutOfBoundsException
	{
		//Si el índice está dentro de los parámetros.
		if(index >= 0 && index < this.length)
		{
			NodeList act = search(index);
			act.setElem(elem);
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
		Elimina el elemento en una posición dada.
		
		@param index: La posición del elemento a borrar empezando en 0.
	*/
	public void delete(int index)
	{
		if(index >= 0 && index < this.length && this.first != null)
		{
			if(this.length == 1)
			{
				this.first = null;
			}else{
				if(index == 0)
				{
					this.first = this.first.getNext();
					this.first.setPrev(null);
				}else{
					NodeList act = search(index);
					act.getPrev().setNext(act.getNext());
					if(act.getNext() != null)
					{
						act.getNext().setPrev(act.getPrev());
					}
				}
				
			}
			this.length--;
		}
	}

	/**
		Muestra por pantalla el valor de todos los elementos de la lista.
	*/
	public String toString()
	{
		if(this.length > 0)
		{
			NodeList act = this.first;
			String list = "[" + act.getElem();
			for(int i = 1; i < this.length; i++)
			{
				act = act.getNext();
				list += "," + act.getElem();
			}
			return list + "]";
		}else{
			return "Lista vacía";
		}
	}
	}
  
  ```

* Primeros Cambios
  * En primer lugar intruzco el parametro generico 'T' que representa el tipo de elemento que la lista va a contener
	
	<image src="/CleanShot 2023-10-08 at 18.24.17.png" alt="Descripción de la imagen">
		
	* Declaracion de la clase, Defino una clase estatica llamada NodeList, ahora de tipo generica que recibe un tipo 'T' como parametro.

	```
  	public static class NodeList<T> {
  
	```

  	*Atributos de la clase NodeList, en esta parte de cambia la variavle int por un tipo 'T' que es el mismo tipo de nuestra clase, asi mismo se añade el tipo 'T' a las referencias de NodeList next y prev
    
	```
  	private T elem;
	private NodeList<T> next = null;
	private NodeList<T> prev = null;

	```

  	* Metodo Setters, tambien se cambian los tipo int por un tipo generico 'T'
  	```
   	public void setElem(T elemento) {
	this.elem = elemento;
	}
	
	public void setNext(NodeList<T> siguiente) {
	    this.next = siguiente;
	}
	
	public void setPrev(NodeList<T> anterior) {
	    this.prev = anterior;
	}

	```

  


    

  * Se hace lo mismo para las demas clases Lista, asi como para sus metodos.
    
	<image src="/IMG_AF0314C8D489-1.jpeg" alt="Descripción de la imagen">
 	* Declaracion de la Clase Lista, se define que Lista es generica y toma 'T' como parametro, que podria aceptar tener una lista de enteros como tambien cadenas de texto
		
	```
	public class Lista<T> {

	```
  	* Atributos de clase se define que lista, en los atributos de clase añadimos el atributo generico tipo 'T', pero no al int de lenght que almacenara el tamaño actual de la lista que por cierto esta vacia.

  	```
  	private NodeList<T> first = null;
	private int length = 0;

	```
  	* Metodos
     
	* Metodo size devuelve un entero que es el tamaño total de la lista
     
  	```
  	public int size() {
	    return this.length;
	}

	```
   
	* Metodo add T elem, añade un nuevo elemento al final de la lista
    
	```
  	public void add(T elem) {
	    // ...
	}


	```
 	* Metodo search, busca y devuelve el nodo en la posicion index
	```
	  	private NodeList<T> search(int index) {
		    // ...
		}
  	```
	
  	* los demas metodos son exactamente igual

  	* Metodo toString

  	Antes
  	```
	public String toString()
        {
            if(this.length > 0)
            {
                NodeList act = this.first;
                String list = "[" + act.getElem();
                for(int i = 1; i < this.length; i++)
                {
                    act = act.getNext();
                    list += "," + act.getElem();
                }
                return list + "]";
            }else{
                return "Lista vacía";
            }
        }

	```
   Despues
  
	```
 	   public String toString() {
            if (this.length > 0) {
                NodeList<T> act = this.first;
                StringBuilder list = new StringBuilder("[" + act.getElement());
                for (int i = 1; i < this.length; i++) {
                    act = act.getNext();
                    list.append(",").append(act.getElement());
                }
                return list + "]";
            } else {
                return "Lista vacía";
            }
        }

	```

   	* Podemos apreciar que añadimos el parametro generico 'T' a todas las declaraciones de variables
   	* Usamos stringBuilder porque vamos a contruir una nueva cadena en java, mas que nada por ser una clase optimizada para ello
 
  ### Codigo Final

  	```
   	public class Main {
    public static void main(String[] args) {
        Lista<Integer> listaDeEnteros = new Lista<>();
        listaDeEnteros.add(5);
        listaDeEnteros.add(10);
        listaDeEnteros.add(15);

        Lista<String> listaDeCadenas = new Lista<>();
        listaDeCadenas.add("Hola");
        listaDeCadenas.add("Mundo");
        listaDeCadenas.add("!");


        System.out.println("Tamaño de la lista: " + listaDeEnteros.size());
        System.out.println("Elemento en la posición 1: " + listaDeEnteros.get(1));

        listaDeEnteros.set(1, 25);
        System.out.println("Elemento en la posición 1 después de modificar: " + listaDeEnteros.get(1));

        listaDeEnteros.delete(0);
        System.out.println("Tamaño de la lista después de eliminar un elemento: " + listaDeEnteros.size());

        System.out.println("Contenido de la lista: " + listaDeEnteros.toString());


        System.out.println("lista strings");

        System.out.println("Tamaño de la lista: " + listaDeCadenas.size());
        System.out.println("Elemento en la posición 1: " + listaDeCadenas.get(1));

        listaDeCadenas.set(1, "Mundo cruel");
        System.out.println("Elemento en la posición 1 después de modificar: " + listaDeCadenas.get(1));

        listaDeCadenas.delete(0);
        System.out.println("Tamaño de la lista después de eliminar un elemento: " + listaDeCadenas.size());

        System.out.println("Contenido de la lista: " + listaDeCadenas.toString());
    }

    public static class NodeList <T> {
        //El propio elemento
        private T elem;
        //La referencia al siguiente elemento
        private NodeList <T> next = null;
        //La referencia al anterior elemento
        private NodeList <T> prev = null;

        public NodeList(T elemento)
        {
            this.elem = elemento;
        }

        //Getters
        public T getElement()

        {
            return this.elem;
        }
        public NodeList <T> getNext()
        {
            return this.next;
        }
        public NodeList <T> getPrev()
        {
            return this.prev;
        }

        //Setters
        public void setElem(T elemento)
        {
            this.elem = elemento;
        }
        public void setNext(NodeList<T> siguiente)
        {
            this.next = siguiente;
        }
        public void setPrev(NodeList<T> anterior)
        {
            this.prev = anterior;
        }
    }

    public static class Lista <T> {
        //El primer elemento de la lista
        private NodeList<T> first = null;
        //El tamaño de la lista
        private int length = 0;

        /**
         Devuelve el tamaño.
         */
        public int size()
        {
            return this.length;
        }

        /**
         Añade un elemento al final de lista

         @param elem: El valor del elemento a añadir.
         */
        public void add(T elem)
        {
            NodeList <T> act = new NodeList<>(elem); //Creamos el nuevo elemento
            if(this.first != null) //Si la lista no está vacía
            {
                NodeList<T> last = this.first;
                //Busca el que no tenga siguiente, es decir, el último.
                while(last.getNext() != null)
                {
                    last = last.getNext();
                }
                last.setNext(act);
                act.setPrev(last);
            }else{
                this.first = act;
            }

            this.length++;
        }

        /**
         Busca un elemento dado un índice y lo devuelve.

         @param index: El índice del elemento a buscar empezando en 0
         */
        private NodeList<T> search(int index)
        {
            NodeList<T> act = this.first;
            for(int i = 0; i < index; i++)
            {
                act = act.getNext();
            }
            return act;
        }

        /**
         Devuelve el valor del elemento en una posición dada.

         @param index: La posición del elemento a buscar empezando en 0.
         */
        public T get(int index) throws IndexOutOfBoundsException
        {
            //Si el índice está dentro de los parámetros.
            if(index >= 0 && index < this.length)
            {
                NodeList<T> elem = search(index);
                return elem.getElement();
            }
            throw new IndexOutOfBoundsException();
        }

        /**
         Cambia el valor del elemento en una posición dada.

         @param index: La posición del elemento a cambiar empezando en 0.
         @param elem: El valor a establecer
         */
        public void set(int index, T elem) throws IndexOutOfBoundsException
        {
            //Si el índice está dentro de los parámetros.
            if(index >= 0 && index < this.length)
            {
                NodeList<T> act = search(index);
                act.setElem(elem);
            }else{
                throw new IndexOutOfBoundsException();
            }
        }

        /**
         Elimina el elemento en una posición dada.

         @param index: La posición del elemento a borrar empezando en 0.
         */
        public void delete(int index)
        {
            if(index >= 0 && index < this.length && this.first != null)
            {
                if(this.length == 1)
                {
                    this.first = null;
                }else{
                    if(index == 0)
                    {
                        this.first = this.first.getNext();
                        this.first.setPrev(null);
                    }else{
                        NodeList<T> act = search(index);
                        act.getPrev().setNext(act.getNext());
                        if(act.getNext() != null)
                        {
                            act.getNext().setPrev(act.getPrev());
                        }
                    }

                }
                this.length--;
            }
        }

        /**
         Muestra por pantalla el valor de todos los elementos de la lista.
         */
        public String toString() {
            if (this.length > 0) {
                NodeList<T> act = this.first;
                StringBuilder list = new StringBuilder("[" + act.getElement());
                for (int i = 1; i < this.length; i++) {
                    act = act.getNext();
                    list.append(",").append(act.getElement());
                }
                return list + "]";
            } else {
                return "Lista vacía";
            }
        }



    }
	}
	```

	
	
	
	
	
	
	
