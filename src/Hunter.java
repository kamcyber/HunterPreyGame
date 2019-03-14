
public class Hunter {
	public boolean control = true;
	int X_POSITION = 0;
	int Y_POSITION = 0;
	Hunter(){
		X_POSITION = 50;
		Y_POSITION = 50;
	}
	int movingPosition = 0;
	
	public boolean check(){
		boolean b = false;
		
		if(X_POSITION > 349){
			X_POSITION = 349;
			b = true;
		}
		if(Y_POSITION > 325){
			Y_POSITION = 325;
			b = true;
		}
		if(X_POSITION < 0){
			X_POSITION = 1;
			b = true;
		}
		if(Y_POSITION < 0){
			Y_POSITION = 1;
			b = true;
		}
		return b;
	}
	public void move(int num){
		
		if(num == 0){
			Y_POSITION -= 1;
		}
		if(num == 1){
			Y_POSITION += 1;
		}
		if(num == 2){
			X_POSITION -= 1;
		}
		if(num == 3){
			X_POSITION += 1;
		}
		if(num == 4){
			Y_POSITION += 1;
			X_POSITION -= 1;
		}
		if(num == 5){
			Y_POSITION += 1;
			X_POSITION += 1;
		}
		if(num == 6){
			Y_POSITION -= 1;
			X_POSITION -= 1;
		}
		if(num == 7){
			Y_POSITION -= 1;
			X_POSITION += 1;
		}
	}

}
