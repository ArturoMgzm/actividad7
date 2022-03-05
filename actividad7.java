public class actividad7 {

    /*
        primos
        recibe como parametro un numero entero y regresa un arreglo de la longitud del parametro con numeros primos
    */
    public static int[] primos(int n){
        //declara el arreglo
        int primos[] = new int[n];
        //el primer valor se necesita para futuro
        primos[0] = 2;
        //si solo se necesita uno regresa el valor que se tiene
        if(n == 1){
            return primos;
        }
        //variables necesarias para el calculo
        //numero a evaluar
        int num = 0;
        //numero para calculo
        int temp = 0;
        //bandera para ver si es primo
        boolean primo = true;
        //bandera para ver si ya se encontro el valor de la siguiente casilla
        boolean found = false;
        //ciclo que rellena el arreglo
        for(int x = 1; x<n;x++){
            //se empieza a analizar a partir del ultimo numero primo encontrado
            num = primos[x-1] + 1;
            temp = num - 1;
            found = false;
            //mientras no se haya encontrado el siguiente numero primo
            while(!found){
                primo = true;
                //si hay un numero divisible entre el valor del numero y 1 entonces el numero no es primo
                while(temp > 1){
                    if(num % temp == 0){
                        primo = false;
                    }
                    temp--;
                }
                // si el numero era primo se agrega al arreglo
                if(primo){
                    primos[x]=num;
                    found = true;
                }
                // si no se avanza el siglo con el siguiente numero
                else{
                    num++;
                    temp = num-1;
                }
            }
        }
        //regresa el arreglo
        return primos;
    }

    /*
        fibonacci
        recibe como parametro un numero entero y regresa un arreglo de la longitud del parametro con la sequencia de fibonacci
    */
    public static long[] fibonacci(int n){
        //se utilizan longs porque los valores tienden a ser muy grandes
        long fibo[] = new long[n];
        //se necesitan los dos primeros valores para hacer los calculos, si se solicita un arreglos de ese tamaño se regresa el valor base
        fibo[0] = 0;
        if(n == 1){
            return fibo;
        }
        fibo[1] = 1;
        if(n == 2){
            return fibo;
        }
        //la sequencia de fibonacci se utilizan los dos valores anteriores para calcular el siguiente numero
        for(int x = 2; x < n; x++){
            fibo[x] = fibo[x-1] + fibo[x-2];
        }
        return fibo;
    }

    public static void main(String args[]) {
        //cantidad a calcular
        int n = 25;
        //se inicializan las variables que se utilizaran
        long fibo[] = new long[n];
        int primos[] = new int[n];
        //se manda a llamar primos y se imprime el resultado
        primos = primos(n);
        System.out.println("Números primos:");
        for(int x = 0; x < n-1; x++){
            System.out.print(primos[x] + ", ");
        }
        System.out.println(primos[n-1]);
        //se manda a llamar fibonacci y se imprime el resultado
        fibo = fibonacci(n);
        System.out.println("Sucesión de Fibonacci:");
        for(int x = 0; x < n-1; x++){
            System.out.print(fibo[x] + ", ");
        }
        System.out.println(fibo[n-1]);
    }
}
