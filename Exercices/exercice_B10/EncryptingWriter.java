package exercice_B10;

import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer{

	private Writer decore;
	
	public EncryptingWriter(Writer writer){
		this.decore = writer;
	}
	
	
	@Override
	public void close() throws IOException {
		
		decore.close();
	}

	@Override
	public void flush() throws IOException {
		
		decore.flush();
	}

	@Override
	public void write(char[] cbuff, int off, int len) throws IOException {
		
		char[] temp = new char[len];
		
		for(int i = 0; i< len; i++){
			char c = cbuff[off + i];
			
			if(Character.isLetter(c)){
				c = (char) (c + 3);
				
				if(!Character.isLetter(c)){
					c = (char) (c - 26);
				}
				
			}
			temp[i] = c;
		}
		
		decore.write(temp, 0, len);
	}

}































