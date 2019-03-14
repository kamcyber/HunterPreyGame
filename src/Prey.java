
public class Prey {
	int X_POSITION = 0;
	int Y_POSITION = 0;
	Prey(){
		X_POSITION = 200;
		Y_POSITION = 200;
	}
	public boolean check(){
		boolean b = false;
		if(X_POSITION > 400){
			X_POSITION = 0;
			b = true;
		}
		if(Y_POSITION > 380){
			Y_POSITION = 0;
			b = true;
		}
		if(X_POSITION < 0){
			X_POSITION = 400;
			b = true;
		}
		if(Y_POSITION < 0){
			Y_POSITION = 380;
			b = true;
		}
		return b;
	}
	public void move(int i){
		if(i == 0){
			Y_POSITION -= 3; 
		}else if(i == 1){
			Y_POSITION += 3;
		}else if(i == 2){
			X_POSITION += 3;
		}else if(i == 3){
			X_POSITION -= 3;
		}
	}
}
