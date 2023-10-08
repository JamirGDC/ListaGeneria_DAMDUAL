# ListaGeneria_DAMDUAL

### Transformar lista en Generica

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
  * En primer lugar intruzco el parametro generico 'T' que representa el tipo de elemento que la lista va a contener, en lugar de usar int en la clase nodeList 
	
	<image src="/CleanShot 2023-10-08 at 18.24.17.png" alt="Descripción de la imagen">

  * Se hace lo mismo para las demas clases Lista, asi como para sus metodos.
    
	<image src="/CleanShot 2023-10-08 at 18.24.17.png" alt="Descripción de la imagen">



