package com.challenge.mutantes;
/*
 * @mirko
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DnaController {
	
	@GetMapping("/")
	public String Api() {
		return "<html><title>Mirko</title><body><h1>Api Rest Mutantes</h1></body></html>";
	}
	
	@PostMapping("/mutant")
	public ResponseEntity<String> postDna(@RequestBody Dna dna1) {
		String [] dna;
		int bandera=0;
		boolean resultado;
		/* IGUALO EL JSON QUE INGRESO POR POST A UNA VARIABLE TIPO ARRAY STRING*/
		dna=dna1.getDna();
		/* VALIDACION DATOS*/
		for (int i = 0; i < dna.length; i++) {
            if(dna[i].length()!=dna.length){
                bandera=1;
            }
            for (int j = 0; j < dna[i].length(); j++) {
                if(dna[i].charAt(j)!='A' && dna[i].charAt(j)!='C' && dna[i].charAt(j)!='G' &&dna[i].charAt(j)!='T' ){
                   bandera=1;
                }
            }
        }
		
		/*  SI LA VALIDACION ES CORRECTA ENTRA A LA FUNCION BOOL*/
		if(bandera==1){
			return ResponseEntity.status(403).body("Forbidden");
	       }else{
	            resultado=isMutant(dna);
	        
	            if(resultado==true){
	            	return ResponseEntity.status(200).body("OK");
	            }else{
	            	return ResponseEntity.status(403).body("Forbidden");
	            } 
	       }
	}
	
	/* SI HAY UNA SECUENCIA DE CARACTERES IGUALES OBLICUA HORIZONATL VERTICAL RETORNA TRUE SINO FALSE*/
    public static boolean isMutant(String [] dna){
        int sum=0, n1, n2; 
        char letra1,letra2,letra3,letra4;
        /*
            RECORRO CADA POSICION DEL ARRAY
        */
        for (int i = 0; i < dna.length; i++) {
            n1=i;
            /* RECORRO CADA CARACTER DEL ARRAY*/
            for (int j = 0; j < dna.length; j++) {
                n2=j;
                sum=0;
                /* SI LA POCICION EN LA QUE ME ENCCUENTRO ME PERMITE 
                   COMPARAR LOS SIGUIENTES CUATRO CARACTERES
                   LOS COMPARO SI SON IGUALES SUMA 1 
                */
                
                /* COMPARA DE FORMA OBLICUA DECRECIENTE*/
                if((dna.length-j)>3 && (dna.length-i)>3){
                    letra1=dna[i].charAt(j);
                    letra2=dna[n1+1].charAt(n2+1);
                    letra3=dna[n1+2].charAt(n2+2);
                    letra4=dna[n1+3].charAt(n2+3);
                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
                    	sum++;
                    }
                }
                /* COMPARA DE FORMA HORIZONTAL*/

                if((dna.length-j)>3){
                    letra1=dna[i].charAt(j);
                    letra2=dna[i].charAt(n2+1);
                    letra3=dna[i].charAt(n2+2);
                    letra4=dna[i].charAt(n2+3);
                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
                    	sum++;
                    }
                }
                /* COMPARA DE FORMA VERTICAL*/
                if((dna.length-i)>3){
                    letra1=dna[i].charAt(j);
                    letra2=dna[n1+1].charAt(j);
                    letra3=dna[n1+2].charAt(j);
                    letra4=dna[n1+3].charAt(j);
                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
                    	sum++;
                    }
                }
                /* COMPARA DE FORMA OBLICUA ASCENDENTE*/
                if(j>=3 && (dna.length-i)>3){
                    letra1=dna[i].charAt(j);
                    letra2=dna[n1+1].charAt(n2-1);
                    letra3=dna[n1+2].charAt(n2-2);
                    letra4=dna[n1+3].charAt(n2-3);
                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
                    	sum++;
                    }
                }
                if(sum>0) {
                	return true;
                }
            }
        }
        
       /* SI EL SUMADOR ES MAS DE 0 ES QUE HAY UNA SECUENCIA DE CARACTERES IGUALES
            YA SEA OBLICUA HORIZONTAL VERTICAL
        */
       
            return false;
    }
}